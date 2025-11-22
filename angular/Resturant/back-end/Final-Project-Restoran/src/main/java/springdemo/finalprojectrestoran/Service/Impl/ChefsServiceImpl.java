package springdemo.finalprojectrestoran.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Mapper.ChefsMapper;
import springdemo.finalprojectrestoran.Repository.ChefsRepository;
import springdemo.finalprojectrestoran.Service.ChefsService;
import springdemo.finalprojectrestoran.dto.ChefsDto;

import java.util.List;

@Service
public class ChefsServiceImpl implements ChefsService {
    @Autowired
    ChefsRepository chefsRepository;

    @Override
    public List<ChefsDto> getAllChefs() {
        return ChefsMapper.CHEFS_MAPPER.toDtoList(chefsRepository.findAll());
    }
}
