package com.example.app.shopping.domain.service.admin;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.ProductMapper;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProductMapper productMapper;

    public List<String> getProductMajorCategoryList() {
        return productMapper.findDistinctMajorCategoryList();
    }

    public List<String> getProductMiddleCategoryList() {
        return productMapper.findDistinctMiddleCategoryList();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addProduct(MultipartFile mainImage, MultipartFile subImage, ProductDto productDto) throws IOException {
        String uploadPath = "c:\\" + File.separator + "shopping" + File.separator + productDto.getName();
        File dir = new File(uploadPath);
        if (!dir.exists())
            dir.mkdirs();
        
        File mainImageObj = new File(dir, "main_" + mainImage.getOriginalFilename());
        mainImage.transferTo(mainImageObj);
        File subImageObj = new File(dir, "sub_" + subImage.getOriginalFilename());
        subImage.transferTo(subImageObj);

        productDto.setMainImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator + "main_" + mainImage.getOriginalFilename());
        productDto.setSubImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator + "sub_" + subImage.getOriginalFilename());

        LocalDate currentDate = LocalDate.now();

        productDto.setRegDate(currentDate);
        productDto.setUpdateDate(currentDate);
        productDto.setContent(productDto.getContent().split(",")[0]);

        // product table insert
        productMapper.insertProduct(productDto);
    }
}
