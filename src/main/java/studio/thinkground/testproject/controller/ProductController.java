package studio.thinkground.testproject.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.data.dto.ProductDTO;
import studio.thinkground.testproject.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {


    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[productController] perm {} of AROUND HUB API. ", "getProduct");

        ProductDTO productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController] Response :: productId= {}, productName = {}, productPrice = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), (System.currentTimeMillis() - startTime ));


        return productDto;
    }

    @PostMapping(value = "/product")
    public ResponseEntity createProduct(@Valid @RequestBody ProductDTO productDTO){

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId,productName,productPrice,productStock);

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {} ",
                response.getProductId(),response.getProductName(),response.getProductPrice(),response.getProductStock()
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){return null;}
}
