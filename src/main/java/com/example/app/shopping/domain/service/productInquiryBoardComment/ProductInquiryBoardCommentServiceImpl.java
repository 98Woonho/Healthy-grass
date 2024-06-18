package com.example.app.shopping.domain.service.productInquiryBoardComment;

import com.example.app.shopping.domain.dto.ProductInquiryBoardCommentDto;
import com.example.app.shopping.domain.mapper.ProductInquiryBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductInquiryBoardCommentServiceImpl implements ProductInquiryBoardCommentService {

    @Autowired
    private ProductInquiryBoardCommentMapper mapper;

    @Override
    public List<Map<String, Object>> getComments(Integer id) throws Exception {
        return mapper.findCommentsByProductInquiryBoardId(id);
    }

    /*
        전달받은 commentDto 를 mapper 를 사용하여 insert 한다
        요청 결과 성공하면
        ("success", true) 를 반환하고
        실패하면
        ("success", false) 를 반환한다
    */
    @Override
    public Map<String, Object> postComments(ProductInquiryBoardCommentDto commentDto) throws Exception {
        int commentDtoInsertResult = mapper.insertProductInquiryBoardComment(commentDto);

        Map<String, Object> result = new HashMap<>();

        if (commentDtoInsertResult < 1) {
            // 삽입 실패
            result.put("success", false);
            result.put("msg", "댓글 등록에 실패하였습니다.");
        } else {
            // 삽입 성공
            result.put("success", true);
            result.put("msg", "댓글 등록에 성공하였습니다.");
        }

        return result;
    }

    @Override
    public Map<String, Object> deleteComments(Long id) throws Exception {
        int commentDtoDeleteResult = mapper.deleteCommentById(id);

        Map<String, Object> result = new HashMap<>();

        if (commentDtoDeleteResult < 1) {
            // 삽입 실패
            result.put("success", false);
            result.put("msg", "댓글 삭제에 실패하였습니다.");
        } else {
            // 삽입 성공
            result.put("success", true);
            result.put("msg", "댓글 삭제에 성공하였습니다.");
        }

        return result;
    }
}
