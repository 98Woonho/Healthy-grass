package com.example.app.shopping.domain.service.admin;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.MajorCategoryMapper;
import com.example.app.shopping.domain.mapper.MiddleCategoryMapper;
import com.example.app.shopping.domain.mapper.ProductMapper;
import com.example.app.shopping.properties.FileUploadPathProperties;
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
import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MajorCategoryMapper majorCategoryMapper;

    @Autowired
    private MiddleCategoryMapper middleCategoryMapper;

    // 랜덤 파일 이름 생성 메서드
    private String generateRandomFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        return uuid + extension;
    }

    public List<String> getProductMajorCategoryList() {
        return majorCategoryMapper.findMajorCategoryList();
    }

    public List<String> getProductMiddleCategoryList() {
        return middleCategoryMapper.findMiddleCategoryList();
    }

    public List<String> getProductList() {
        return productMapper.findProductList();
    }

    public ProductDto getProductById(Long id) {
        return productMapper.findProductById1(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addProduct(MultipartFile mainImage, MultipartFile subImage, ProductDto productDto) throws IOException {
        // 생성 시간 set
        LocalDate currentDate = LocalDate.now();
        productDto.setRegDate(currentDate);
        productDto.setUpdateDate(currentDate);

        // 이미지 업로드 경로
        String uploadPath = FileUploadPathProperties.getUploadDir() + File.separator + "product" + File.separator + productDto.getRegDate();

        // 업로드 경로 디렉터리 생성
        File dir = new File(uploadPath);
        if (!dir.exists())
            dir.mkdirs();

        String mainImageFileName = generateRandomFileName(mainImage.getOriginalFilename());
        String subImageFileName = generateRandomFileName(subImage.getOriginalFilename());

        // 이미지 오브젝트 생성
        File mainImageObj = new File(dir, mainImageFileName);
        File subImageObj = new File(dir, subImageFileName);

        // 이미지 저장
        mainImage.transferTo(mainImageObj);
        subImage.transferTo(subImageObj);

        // 이미지 경로 set
        productDto.setMainImgPath(File.separator + "uploads" + File.separator + "product" + File.separator + productDto.getRegDate() + File.separator);
        productDto.setSubImgPath(File.separator + "uploads" + File.separator + "product" + File.separator + productDto.getRegDate() + File.separator);

        // 이미지 이름 set
        productDto.setMainImgName(mainImageFileName);
        productDto.setSubImgName(subImageFileName);

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
        String prevUploadPath = FileUploadPathProperties.getUploadDir() + File.separator + "product" + File.separator + prevProductDto.getUpdateDate();

        // 이전 업로드 경로 디렉터리 생성
        File dir = new File(prevUploadPath);

        // 이미지 경로 set
        productDto.setMainImgPath(File.separator + "uploads" + File.separator + "product" + File.separator + prevProductDto.getRegDate() + File.separator);
        productDto.setSubImgPath(File.separator + "uploads" + File.separator + "product" + File.separator + prevProductDto.getRegDate() + File.separator);

        // 메인 이미지가 수정 되었을 경우
        if (mainImage != null) {
            // 이전 이미지 삭제
            File prevMainImage = new File(dir, prevProductDto.getMainImgName());
            if (prevMainImage.exists()) {
                prevMainImage.delete();
            }

            String mainImageFileName = generateRandomFileName(mainImage.getOriginalFilename());


            // 이미지 오브젝트 생성
            File mainImageObj = new File(dir, mainImageFileName);

            // 이미지 저장
            mainImage.transferTo(mainImageObj);

            // 이미지 이름 set
            productDto.setMainImgName(mainImageFileName);

        // 메인 이미지 수정 안 되었을 경우
        } else {
            // 기존 이미지 이름 set
            productDto.setMainImgName(prevProductDto.getMainImgName());
        }

        // 서브 이미지가 수정 되었을 경우
        if (subImage != null) {
            // 이전 이미지 삭제
            File prevSubImage = new File(dir, prevProductDto.getSubImgName());
            if (prevSubImage.exists()) {
                prevSubImage.delete();
            }

            String subImageFileName = generateRandomFileName(subImage.getOriginalFilename());


            // 이미지 오브젝트 생성
            File subImageObj = new File(dir, subImageFileName);

            // 이미지 저장
            subImage.transferTo(subImageObj);

            // 이미지 이름 set
            productDto.setSubImgName(subImageFileName);

        // 서브 이미지 수정 안 되었을 경우
        } else {
            // 기존 이미지 이름 set
            productDto.setSubImgName(prevProductDto.getSubImgName());
        }

        // 할인된 가격 set
        int discountedPrice = (int) (productDto.getPrice() * productDto.getDiscount() * 0.01);
        productDto.setDiscountedPrice(productDto.getPrice() - discountedPrice);

        // 수정 시간 set
        LocalDate currentDate = LocalDate.now();
        productDto.setUpdateDate(currentDate);

        // product table update
        productMapper.updateProduct(productDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(Long id) {
        ProductDto productDto = productMapper.findProductById1(id);

        // 이미지 경로
        String mainFilePath = FileUploadPathProperties.getUploadDir() + File.separator + "product" + File.separator + productDto.getRegDate() + File.separator + productDto.getMainImgName();
        String subFilePath = FileUploadPathProperties.getUploadDir() + File.separator + "product" + File.separator + productDto.getRegDate() + File.separator + productDto.getSubImgName();

        // 업로드 경로 디렉터리 생성
        File mainFile = new File(mainFilePath);
        File subFile = new File(subFilePath);

        mainFile.delete();
        subFile.delete();

        productMapper.deleteProduct(id);
    }
}
