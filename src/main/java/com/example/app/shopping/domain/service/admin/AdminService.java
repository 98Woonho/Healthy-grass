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
        // 이미지 업로드 경로
        String uploadPath = "c:\\" + File.separator + "shopping" + File.separator + productDto.getName();

        // 업로드 경로 디렉터리 생성
        File dir = new File(uploadPath);
        if (!dir.exists())
            dir.mkdirs();

        // 이미지 오브젝트 생성
        File mainImageObj = new File(dir, "main_" + mainImage.getOriginalFilename());
        File subImageObj = new File(dir, "sub_" + subImage.getOriginalFilename());

        // 이미지 저장
        mainImage.transferTo(mainImageObj);
        subImage.transferTo(subImageObj);

        // 이미지 경로 set
        productDto.setMainImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator + "main_" + mainImage.getOriginalFilename());
        productDto.setSubImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator + "sub_" + subImage.getOriginalFilename());

        // 생성 시간 set
        LocalDate currentDate = LocalDate.now();
        productDto.setRegDate(currentDate);
        productDto.setUpdateDate(currentDate);

        // 할인된 가격 set
        int discountedPrice = (int) (productDto.getPrice() * productDto.getDiscount() * 0.01);
        productDto.setDiscountedPrice(productDto.getPrice() - discountedPrice);


        // product table insert
        productMapper.insertProduct(productDto);
    }
}
