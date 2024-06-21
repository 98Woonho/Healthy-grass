package com.example.app.shopping.domain.service.productReviewBoard;

import com.example.app.shopping.domain.dto.ProductReviewBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ProductReviewBoardService {
    public Map<String, Object> getproductReviewBoards(Criteria criteria, Integer pId) throws Exception;
    public Map<String, Object> getproductReviewBoardDetail(Integer id) throws Exception;
    public Map<String, Object> getMyProductReviewBoards(Criteria criteria, String uId) throws Exception;
    public Map<String, Object> checkAddReview(Long oId, Long pId, String uId) throws Exception;
    void insertProductReviewServ(ProductReviewBoardDto boardDto, MultipartFile image) throws Exception;
}
