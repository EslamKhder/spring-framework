package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdemo.finalprojectrestoran.Service.CategoryService;
import springdemo.finalprojectrestoran.dto.CategoryDto;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/getAll")
    ResponseEntity<List<CategoryDto>> categories(){
        return  ResponseEntity.ok(categoryService.getAllCategory());
    }
}
