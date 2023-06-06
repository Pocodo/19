package com.example9.controller;

import com.example9.entity.Product;
import com.example9.services.CategoryService;
import com.example9.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RequestMapping("admin/products")
@Controller
public class AdminProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("listproduct", productService.getAllProducts());
        return "admin/products/index.html";
    }
    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("listCategory", categoryService.getAllCategories() );
        return "admin/products/create";
    }
    @PostMapping("/create")
    public String create( Product newProduct,
                         @RequestParam MultipartFile imageProduct,

                         Model model) {

        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/admin/products";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model)
    {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("listCategory", categoryService.getAllCategories() );
        return "admin/products/edit";
    }
    @PostMapping("/edit")
    public String edit( Product editProduct,
                       @RequestParam MultipartFile imageProduct,

                       Model model)
    {

        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + editProduct.getImage());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.updateProduct(editProduct);
        return "redirect:/admin/products";
    }
}