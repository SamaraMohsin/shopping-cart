package com.exam.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductServiceImpl productService;

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(
            @RequestBody Product product) {
        Product product1 = productService
                .saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product1 = productService.getProductById(id);
        if (product1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<CandidateAcademicInfo> updateAcademicInformation(@PathVariable Long id,
    //         @RequestBody CandidateAcademicInfo academicInfotmation) {
    //     CandidateAcademicInfo updatedAcademicInformation = academicInfoService.updateAcademicInformation(id,
    //             academicInfotmation);
    //     if (updatedAcademicInformation == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    //     } else {
    //         return new ResponseEntity<CandidateAcademicInfo>(updatedAcademicInformation, HttpStatus.OK);
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product1 = productService.getProductById(id);
        if (product1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productService.deleteProduct(id);;
            System.out.println("product deleted successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }







}
