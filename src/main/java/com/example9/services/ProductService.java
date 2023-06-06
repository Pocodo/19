package com.example9.services;

import com.example9.entity.Product;
import com.example9.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Integer id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void updateProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
