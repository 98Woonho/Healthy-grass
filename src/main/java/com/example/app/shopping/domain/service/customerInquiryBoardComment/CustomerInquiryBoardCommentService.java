package com.example.app.shopping.domain.service.customerInquiryBoardComment;

import com.example.app.shopping.domain.dto.CustomerInquiryCommentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CustomerInquiryBoardCommentService {
    List<Map<String, Object>> getComments(Integer id) throws Exception;

    Map<String, Object> postCommentServ(CustomerInquiryCommentDto commentDto, MultipartFile file) throws Exception;

    Map<String, Object> deleteCustomerInquiryCommentServ(Long id) throws Exception;
}
