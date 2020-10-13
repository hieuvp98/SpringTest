package com.itstudent.controller.public_api;

import com.itstudent.entities.payload.BillPayload;
import com.itstudent.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/bill")
@AllArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody BillPayload payload){
        try {
            billService.save(payload);
            return ResponseEntity.noContent().build();
        }catch (Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(billService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
