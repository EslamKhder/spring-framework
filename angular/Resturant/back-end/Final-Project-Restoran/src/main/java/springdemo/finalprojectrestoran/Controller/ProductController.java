package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdemo.finalprojectrestoran.Service.CategoryService;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.CategoryDto;
import springdemo.finalprojectrestoran.dto.ProductDto;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProducts/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity<List<ProductDto>> productAllProducts(@PathVariable("pageNumber")int pageNumber, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.getProducts(pageNumber, pageSize));
    }

    @GetMapping("/getProductsBy/{id}/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity<List<ProductDto>> productByCategoryId(@PathVariable("id") Long CategoryId,@PathVariable("pageNumber")int pageNumber, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(CategoryId, pageNumber, pageSize));
    }
    @GetMapping("/getProductsByName/{productName}")
    ResponseEntity<List<ProductDto>> productByName(@PathVariable("productName") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/getProductsByletter/{letters}/pageNumber/{pageNumber}/pageSize/{pageSize}")
    ResponseEntity<List<ProductDto>> productByLetters(@PathVariable("letters") String Letter, @PathVariable("pageNumber")int pageNumber, @PathVariable("pageSize") int pageSize) {
        return ResponseEntity.ok(productService.getProductByLetters(Letter, pageNumber, pageSize));
    }

    @GetMapping("/getProductSize")
    ResponseEntity<Integer> productSize() {
        return ResponseEntity.ok(productService.getProductSize());
    }

    @GetMapping("/getProductSizeByCategoryId/{id}")
    ResponseEntity<Integer> productSizeByCategoryId( @PathVariable("id") Long CategoryId) {
        return ResponseEntity.ok(productService.findProductSizeByCategoryId(CategoryId));
    }
    @GetMapping("/getProductSizeByKey/{key}")
    ResponseEntity<Integer> productSizeByKey( @PathVariable("key") String key) {
        return ResponseEntity.ok(productService.findProductSizeByKey(key));
    }
}
