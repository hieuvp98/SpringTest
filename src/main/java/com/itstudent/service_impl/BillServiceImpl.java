package com.itstudent.service_impl;

import com.itstudent.entities.data.Bill;
import com.itstudent.entities.data.BillHasProduct;
import com.itstudent.entities.data.Product;
import com.itstudent.entities.json.BillJson;
import com.itstudent.entities.key.BillProductKey;
import com.itstudent.entities.payload.BillPayload;
import com.itstudent.entities.payload.ProductInBill;
import com.itstudent.repository.interfac.BillHasProductRepo;
import com.itstudent.repository.interfac.BillRepository;
import com.itstudent.repository.interfac.ProductRepo;
import com.itstudent.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillHasProductRepo billHasProductRepo;
    private final ProductRepo productRepo;

    @Override
    @Transactional
    public void save(BillPayload payload) throws Exception{
        payload.getBill().setDeleted(false);
        payload.getBill().setCreated(new Date());
        //save bill
        Bill savedBill = billRepository.save(payload.getBill());
        // tao list BillHasProduct
        List<BillHasProduct> billHasProducts = new ArrayList<>();
        //tinh tong tien
        double totalPrice = 0;

        //tao billHasProduct
        for (ProductInBill productInBill : payload.getProductInBills()) {
            Product product = productRepo.findById(productInBill.getProductId()).get();
            BillHasProduct billHasProduct = new BillHasProduct();
            // tao id
            billHasProduct.setId(BillProductKey
                    .builder()
                    .billId(savedBill.getId())
                    .productId(productInBill.getProductId())
                    .build());
            billHasProduct.setAmount(productInBill.getAmount());
            billHasProduct.setPrice(product.getPrice());
            billHasProduct.setProduct(product);
            billHasProducts.add(billHasProduct);
            totalPrice += billHasProduct.getAmount() * billHasProduct.getPrice();
        }
        // save all billHasProducts
        billHasProductRepo.saveAll(billHasProducts);
        // calculate total price
        payload.getBill().setTotalMoney(totalPrice);
        billRepository.save(payload.getBill());
    }

    @Override
    public BillJson findById(Integer billId) throws Exception{
        Bill bill = billRepository.findByIdAndDeletedFalse(billId);
        if (bill != null){
            List<BillHasProduct> billHasProducts = billHasProductRepo.findById_BillId(billId);
            return BillJson.builder()
                    .bill(bill)
                    .billHasProducts(billHasProducts)
                    .build();
        } else throw new Exception("bill not found");
    }
}
