package com.spring.boot.restaurant.controller;

import com.spring.boot.restaurant.dto.ContactInfoDto;
import com.spring.boot.restaurant.dto.ProductDto;
import com.spring.boot.restaurant.service.ContactInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-info")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactInfoDto>> getAllContactInfo() {
        return ResponseEntity.ok(contactInfoService.getAllContactInfo());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ContactInfoDto> getContactInfo(@PathVariable Long id) {
        return ResponseEntity.ok(contactInfoService.getContactInfo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ContactInfoDto> createContactInfo(@RequestBody ContactInfoDto dto) {
        return ResponseEntity.ok(contactInfoService.saveContactInfo(dto));
    }

//    @PutMapping("/update")
//    public ResponseEntity<ProductDto> updateContactInfo(@RequestBody ProductDto productDto) {
//        return ResponseEntity.ok(contactInfoService.updateContactInfo(productDto));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContactInfo(@PathVariable Long id) {
        boolean deleted = contactInfoService.deleteContactInfo(id);
        if (deleted) {
            return ResponseEntity.ok("ContactInfo deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("ContactInfo not found.");
        }
    }
}
