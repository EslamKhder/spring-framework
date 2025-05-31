package com.spring.boot.restaurant.service.impl;

import com.spring.boot.restaurant.dto.ContactInfoDto;
import com.spring.boot.restaurant.mapper.ContactInfoMapper;
import com.spring.boot.restaurant.model.ContactInfo;
import com.spring.boot.restaurant.repository.ContactInfoRepo;
import com.spring.boot.restaurant.service.ContactInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private final ContactInfoRepo contactInfoRepo;
    private final ContactInfoMapper contactInfoMapper;

    public ContactInfoServiceImpl(ContactInfoRepo contactInfoRepo,
                                  ContactInfoMapper contactInfoMapper) {
        this.contactInfoRepo = contactInfoRepo;
        this.contactInfoMapper = contactInfoMapper;
    }

    @Override
    public ContactInfoDto getContactInfo(Long id) {
        ContactInfo entity = contactInfoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ContactInfo not found"));
        return contactInfoMapper.toDto(entity);
    }

    @Override
    public List<ContactInfoDto> getAllContactInfo() {
        return contactInfoMapper.toDtoList(contactInfoRepo.findAll());
    }

    @Override
    public ContactInfoDto saveContactInfo(ContactInfoDto dto) {
        ContactInfo entity = contactInfoMapper.toEntity(dto);
        ContactInfo saved = contactInfoRepo.save(entity);
        return contactInfoMapper.toDto(saved);
    }

    @Override
    public ContactInfoDto updateContactInfo(Long id, ContactInfoDto dto) {
        ContactInfo existing = contactInfoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ContactInfo not found with id " + id));

        dto.setId(id); // ensure the DTO has the correct ID
        ContactInfo updatedEntity = contactInfoMapper.toEntity(dto);

        // Optional: selectively update only modifiable fields if needed
        updatedEntity.setId(existing.getId()); // preserve ID
        ContactInfo saved = contactInfoRepo.save(updatedEntity);

        return contactInfoMapper.toDto(saved);
    }

    @Override
    public boolean deleteContactInfo(Long id) {
        if (!contactInfoRepo.existsById(id)) {
            return false;
        }
        contactInfoRepo.deleteById(id);
        return true;
    }
}
