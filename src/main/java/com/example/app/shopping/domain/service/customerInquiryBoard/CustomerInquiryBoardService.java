package com.example.app.shopping.domain.service.customerInquiryBoard;

import com.example.app.shopping.domain.dto.CustomerInquiryBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CustomerInquiryBoardService {
    public Map<String, Object> getCustomerInquiryBoards(Criteria criteria) throws Exception;
    public Map<String, Object> getCustomerInquiryBoardDetail(Integer id) throws Exception;
    public Map<String, Object> getMyCustomerInquiryBoards(Criteria criteria, String uId) throws Exception;
    public Map<String, Object> postCustomerInquiryServ(CustomerInquiryBoardDto boardDto, MultipartFile file) throws Exception;
    public Map<String, Object> putCustomerInquiryServ(CustomerInquiryBoardDto boardDto, MultipartFile file, boolean deleteImage) throws Exception;
    Map<String, Object> deleteCustomerInquiryServ(Long id) throws Exception;
}
