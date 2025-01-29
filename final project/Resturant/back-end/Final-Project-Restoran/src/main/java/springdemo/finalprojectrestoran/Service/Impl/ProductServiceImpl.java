package springdemo.finalprojectrestoran.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Controller.ProductController;
import springdemo.finalprojectrestoran.Mapper.ProductMapper;
import springdemo.finalprojectrestoran.Repository.ProductRepository;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;




    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> productsPage = productRepository.findAllByCategoryId(categoryId, pageable);
        List<Product> products = productsPage.stream().toList();

        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public List<ProductDto> getProductByName(String productName) {
        List<Product> product = productRepository.findByName(productName);
         if(product.isEmpty()) {
             throw  new RuntimeException("error.product");
         }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(product);
    }

    @Override
    public List<ProductDto> getProductByLetters(String letter,int pageNumber, int pageSize) {


        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> productsPage = productRepository.getProductByLetters(letter, pageable);
        List<Product> products = productsPage.stream().toList();

        //<Product> products = productRepository.getProductByLetters(letter);

        if (products.isEmpty()) {
            throw  new RuntimeException("error.noSuchLetter");
        }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public List<ProductDto> getProducts( int pageNumber, int pageSize) {

         Pageable pageable = PageRequest.of(pageNumber,pageSize);   //  for pagination
         Page<Product> productsPage = productRepository.findAll(pageable);  // for pagenation
          List<Product>  products = productsPage.stream().toList();   //for pagenation

        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public int getProductSize() {
        return productRepository.findProductSize();
    }

    @Override
    public int findProductSizeByCategoryId(Long id) {
        return productRepository.findProductSizeByCategoryId(id);
    }

    @Override
    public int findProductSizeByKey(String value) {
        return productRepository.findProductSizeByKey(value);
    }

    @Override
    public List<ProductDto> findProductsByIds(List<Long> porductIds) {
        List <Product> products = productRepository.findAllById(porductIds);
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }


}
