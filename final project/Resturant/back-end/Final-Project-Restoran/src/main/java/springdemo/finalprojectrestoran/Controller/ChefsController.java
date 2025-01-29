package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdemo.finalprojectrestoran.Service.CategoryService;
import springdemo.finalprojectrestoran.Service.ChefsService;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.dto.ChefsDto;

import java.util.List;
@RestController
@RequestMapping("/Chefs")
public class ChefsController {

    @Autowired
    ChefsService chefsService;


    @GetMapping("/getAll")
    ResponseEntity<List<ChefsDto>> getAllCategoryChefs(){
        return  ResponseEntity.ok(chefsService.getAllChefs());

    }
}
