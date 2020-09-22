package com.itstudent.example.test;

import java.util.List;

public interface SpringOutfitService {

    List<SpringOutfit> sortByName();

    List<SpringOutfit> sortByPrice();

    SpringOutfit findById(int id);

    void save(SpringOutfit springOutfit);
    // id null -> tạo id vào thêm vào list
    // id đã có -> thay thế object có id tương ứng
    // id đã có nhưng ko trùng -> thêm vào list

    boolean delete(int id);
    //id tồn tại -> xoá
    //id ko tồn tại báo lỗi
}
