package springdemo.finalprojectrestoran.Service;

import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategory();

}
