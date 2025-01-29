package springdemo.finalprojectrestoran.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

public interface ProductService {
List<ProductDto> getProductsByCategoryId(Long categoryId, int pageNumber, int pageSize);
//ProductDto getProductById(Long id);

List<ProductDto> getProductByName(String productName);
List<ProductDto> getProductByLetters(String letter,int pageNumber, int pageSize);
List<ProductDto> getProducts(int pageNumber, int pageSize);
int getProductSize();
int findProductSizeByCategoryId(Long id);
int findProductSizeByKey(String value);
List<ProductDto> findProductsByIds(List<Long> porductIds);


}
