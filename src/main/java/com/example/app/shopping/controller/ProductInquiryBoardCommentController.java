package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.ProductInquiryBoardCommentDto;
import com.example.app.shopping.domain.service.productInquiryBoardComment.ProductInquiryBoardCommentServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductInquiryBoardCommentController {
    @Autowired
    private ProductInquiryBoardCommentServiceImpl service;

    @GetMapping("ProductInquiryBoardComment")
    public @ResponseBody Map<String, Object> ProductInquiryBoardComment(@RequestParam(name = "id") Integer id) {
        System.out.println("ProductInquiryBoardCommentController's ProductInquiryBoardComment id: " + id);

        Map<String, Object> response = new HashMap<>();

        try {
            response.put("list", service.getComments(id));
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
        }

        return response;
    }

    /*
        POST /productInquiryBoardComment
        
        RestfulAPI 요청
        관리자의 댓글 등록 요청을 받는다.
        CommentDto 객체로 입력 값을 받아
        ProductInquiryBoardCommentDto 로 변환 후 등록 작업을 거친다

        등록을 성공하면 서비스로부터 결과를 전달받아
        ("success", true)

        등록에 실패하면
        ("success", false)
        를 반환한다.
     */
    @PostMapping("productInquiryBoardComment")
    public @ResponseBody Map<String, Object> postProductInquiryBoardComment(
            @RequestBody CommentDto commentDto
    )
    {
        System.out.println("ProductInquiryBoardCommentController's postProductInquiryBoardComment commentDto: " + commentDto);

        Map<String, Object> response = new HashMap<>();

        ProductInquiryBoardCommentDto pBoardCommentDto = new ProductInquiryBoardCommentDto();

        pBoardCommentDto.setP_Board_Id(commentDto.getBoardId());
        pBoardCommentDto.setTitle(commentDto.getTitle().trim());
        pBoardCommentDto.setContent(commentDto.getContent().trim());
        pBoardCommentDto.setRegDate(LocalDate.now());
        pBoardCommentDto.setUpdateDate(LocalDate.now());

        try {
            response = service.postComments(pBoardCommentDto);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "DB 통신에 실패하였습니다.");
            e.printStackTrace();
        }

        return response;
    }

    @Data
    private static class CommentDto {
        @JsonProperty("title")
        String title;
        @JsonProperty("content")
        String content;
        @JsonProperty("P_Board_Id")
        Long boardId;
    }

    @DeleteMapping("productInquiryBoardComment")
    public @ResponseBody Map<String, Object> deleteProductInquiryBoardComment(@RequestParam("id") Long id, Authentication authentication) {
        System.out.println("ProductInquiryBoardCommentController's deleteProductInquiryBoardComment id: " + id);

        Map<String, Object> response = new HashMap<>();

        boolean isAdmin = false;

        if (authentication != null) {
            // 관리자 권한 체크
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
            isAdmin = authorities.stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        }

        if (!isAdmin) {
            // 관리자가 아니라면 댓글을 삭제 할 수 없다
            // 실패 response 반환
            response.put("success", false);
            response.put("msg", "관리자만 댓글을 삭제할 수 있습니다.");

            return response;
        }

        try {
            response = service.deleteComments(id);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "DB 통신에 실패하였습니다.");
        }

        return response;
    }

}
