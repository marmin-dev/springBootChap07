package com.springboot.jpa.Controller;

import com.springboot.jpa.data.dto.ChangeProductNameDto;
import com.springboot.jpa.data.dto.ProductDto;
import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number){
        ProductResponseDto productResponseDto = service.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto dto){
        ProductResponseDto productResponseDto = service.saveProduct(dto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto) throws Exception{
        ProductResponseDto productResponseDto = service.changeProductName(
                changeProductNameDto.getNumber(),changeProductNameDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        service.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다");
    }
}
