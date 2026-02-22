package com.example.clone.project.serviceImpl;


import com.example.clone.project.dto.ProductDto;
import com.example.clone.project.dto.ProductsDto;
import com.example.clone.project.dto.ResponseDto;
import com.example.clone.project.entity.ProductEntity;
import com.example.clone.project.repository.ProductRespostiory;
import com.example.clone.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRespostiory productRespostiory;

    @Override
    public ResponseDto saveOrupdateProductDetails(ProductDto productDto) {

        ResponseDto response = new ResponseDto();
        try{
            ProductEntity productEntity = new ProductEntity();
            if(productDto.getProductId() == null)
            {
                productEntity.setProductName(productDto.getProductName());
                productEntity.setProductDescription(productDto.getProductDescription());
                productEntity.setQuantity(productDto.getQuantity());
                productEntity.setPrice(productDto.getPrice());
                productEntity.setSellerName(productDto.getSellerName());
                productEntity.setSellerAddress(productDto.getSellerAddress());
                productEntity.setSellerEmailID(productDto.getSellerEmailID());
                productRespostiory.save(productEntity);
                response.setStatusMessage("Product is Saved Successfully");
                response.setStatusCode("200");
            }
            else {
                Optional<ProductEntity>productOpt = productRespostiory.findById(productDto.getProductId());
                if(productOpt.isPresent())
                {
                    productEntity.setProductName(productDto.getProductName());
                    productEntity.setProductDescription(productDto.getProductDescription());
                    productEntity.setQuantity(productDto.getQuantity());
                    productEntity.setPrice(productDto.getPrice());
                    productEntity.setSellerName(productDto.getSellerName());
                    productEntity.setSellerAddress(productDto.getSellerAddress());
                    productEntity.setSellerEmailID(productDto.getSellerEmailID());
                    productRespostiory.save(productEntity);
                    response.setStatusMessage("product is Updated Successfully");
                    response.setStatusCode("200");
                }
                else {
                    response.setStatusMessage("Product Not Found!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public ProductsDto searchProduct(String productName) {
        ProductsDto productsDto = new ProductsDto();
        try{
            List<ProductEntity>productEntities = productRespostiory.findByProductNameContainingIgnoreCase(productName);
            List<ProductDto> productDtos = new ArrayList<>();

            for(ProductEntity productEntity : productEntities)
            {
                ProductDto productDto = new ProductDto();
                productDto.setProductId(productEntity.getProductId());
                productDto.setProductName(productEntity.getProductName());
                productDto.setProductDescription(productEntity.getProductDescription());
                productDto.setQuantity(productEntity.getQuantity());
                productDto.setPrice(productEntity.getPrice());
                productDto.setSellerName(productEntity.getSellerName());
                productDto.setSellerEmailID(productEntity.getSellerEmailID());
                productDto.setSellerAddress(productEntity.getSellerAddress());
                productDtos.add(productDto);

            }
            productsDto.setProductList(productDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productsDto;
    }


    @Override
    public ProductsDto getAllProduct() {

        ProductsDto productsDto = new ProductsDto();

        try{

            List<ProductEntity>productEntities = productRespostiory.findAll();
            List<ProductDto> productDtos = new ArrayList<>();

            for(ProductEntity productEntity : productEntities)
            {
                ProductDto productDto = new ProductDto();
                productDto.setProductId(productEntity.getProductId());
                productDto.setProductName(productEntity.getProductName());
                productDto.setProductDescription(productEntity.getProductDescription());
                productDto.setQuantity(productEntity.getQuantity());
                productDto.setPrice(productEntity.getPrice());
                productDto.setSellerName(productEntity.getSellerName());
                productDto.setSellerEmailID(productEntity.getSellerEmailID());
                productDto.setSellerAddress(productEntity.getSellerAddress());
                productDtos.add(productDto);

            }
            productsDto.setProductList(productDtos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productsDto;
    }

    @Override
    public ProductDto getProduct(String productName) {
        ProductDto productDto1= new ProductDto();
        try{
            Optional<ProductEntity> productOpt= productRespostiory.findByProductName(productName);
            if(productOpt.isPresent())
            {
                productDto1.setProductId(productOpt.get().getProductId());
                productDto1.setProductName(productOpt.get().getProductName());
                productDto1.setProductDescription(productOpt.get().getProductDescription());
                productDto1.setQuantity(productOpt.get().getQuantity());
                productDto1.setPrice(productOpt.get().getPrice());
                productDto1.setSellerName(productOpt.get().getSellerName());
                productDto1.setSellerEmailID(productOpt.get().getSellerEmailID());
                productDto1.setSellerAddress(productOpt.get().getSellerAddress());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productDto1;
    }


}
