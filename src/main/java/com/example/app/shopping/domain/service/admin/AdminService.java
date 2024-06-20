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
import java.util.Map;

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

    public List<String> getProductList() {
        return productMapper.findProductList();
    }

    public Map<String, Object> getProductById(Integer id) throws Exception {
        return productMapper.findProductById(id);
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
        productDto.setMainImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator);
        productDto.setSubImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator);

        // 이미지 이름 set
        productDto.setMainImgName("main_" + mainImage.getOriginalFilename());
        productDto.setSubImgName("sub_" + subImage.getOriginalFilename());

        // 생성 시간 set
        LocalDate currentDate = LocalDate.now();
        productDto.setRegDate(currentDate);
        productDto.setUpdateDate(currentDate);

        // 할인된 가격 set
        int discountedPrice = (int) (productDto.getPrice() * productDto.getDiscount() * 0.01);
        productDto.setDiscountedPrice(
                ( (int) ( (productDto.getPrice() - discountedPrice) / 10 ) * 10 )
        );


        // product table insert
        productMapper.insertProduct(productDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modifyProduct(MultipartFile mainImage, MultipartFile subImage, ProductDto productDto) throws IOException {
        // 수정 전 productDto
        ProductDto prevProductDto = productMapper.findProductById1(productDto.getId());

        // 이전 이미지 업로드 경로
        String prevUploadPath = "c:\\" + File.separator + "shopping" + File.separator + prevProductDto.getName();

        // 새로운 이미지 업로드 경로
        String newUploadPath = "c:\\" + File.separator + "shopping" + File.separator + productDto.getName();

        // 이전 업로드 경로 디렉터리 생성
        File dir = new File(prevUploadPath);
        // 새로운 업로드 경로 디렉터리 생성
        File newDir = new File(newUploadPath);

        // 디렉터리 이름 변경
        dir.renameTo(newDir);

        // 이미지 경로 set
        productDto.setMainImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator);
        productDto.setSubImgPath(File.separator + "shopping" + File.separator + productDto.getName() + File.separator);

        // 메인 이미지가 수정 되었을 경우
        if (mainImage != null) {
            // 이전 이미지 삭제
            File prevMainImage = new File(dir, prevProductDto.getMainImgName());
            if (prevMainImage.exists()) {
                prevMainImage.delete();
            }

            // 이미지 오브젝트 생성
            File mainImageObj = new File(newDir, "main_" + mainImage.getOriginalFilename());

            // 이미지 저장
            mainImage.transferTo(mainImageObj);

            // 이미지 이름 set
            productDto.setMainImgName("main_" + mainImage.getOriginalFilename());

        // 메인 이미지 수정 안 되었을 경우
        } else {
            // 기존 이미지 이름 set
            productDto.setMainImgName(prevProductDto.getMainImgName());
        }

        // 서브 이미지가 수정 되었을 경우
        if (subImage != null) {
            // 이전 이미지 삭제
            File prevSubImage = new File(newDir, prevProductDto.getSubImgName());
            if (prevSubImage.exists()) {
                prevSubImage.delete();
            }

            // 이미지 오브젝트 생성
            File subImageObj = new File(newDir, "sub_" + subImage.getOriginalFilename());

            // 이미지 저장
            subImage.transferTo(subImageObj);

            // 이미지 이름 set
            productDto.setSubImgName("sub_" + subImage.getOriginalFilename());

        // 서브 이미지 수정 안 되었을 경우
        } else {
            // 기존 이미지 이름 set
            productDto.setMainImgName(prevProductDto.getSubImgName());
        }

        // 수정 시간 set
        LocalDate currentDate = LocalDate.now();
        productDto.setUpdateDate(currentDate);

        // 할인된 가격 set
        int discountedPrice = (int) (productDto.getPrice() * productDto.getDiscount() * 0.01);
        productDto.setDiscountedPrice(productDto.getPrice() - discountedPrice);


        // product table update
        productMapper.updateProduct(productDto);
    }
}
