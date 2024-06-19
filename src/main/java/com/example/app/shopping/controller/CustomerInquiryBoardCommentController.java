package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.CustomerInquiryCommentDto;
import com.example.app.shopping.domain.service.customerInquiryBoardComment.CustomerInquiryBoardCommentServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerInquiryBoardCommentController {
    @Autowired
    private CustomerInquiryBoardCommentServiceImpl service;

    @GetMapping("/customerInquiryBoardComment")
    public @ResponseBody Map<String, Object> CustomerInquiryBoardComment(@RequestParam(name = "id") Integer id) {
        System.out.println("CustomerInquiryBoardCommentController's CustomerInquiryBoardComment id: " + id);

        Map<String, Object> response = new HashMap<>();

        try {
            response.put("list", service.getComments(id));
            response.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
        }

        return response;
    }

    @PostMapping("/customerInquiry/comment")
    public @ResponseBody Map<String, Object> postComment(
            @ModelAttribute PostCommentDto postCommentDto, Authentication authentication) {
        System.out.println("CustomerInquiryBoardController's postComment dto: " + postCommentDto);

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "로그인이 필요합니다.");
            return response;
        }

        CustomerInquiryCommentDto commentDto = new CustomerInquiryCommentDto();

        commentDto.setC_Board_id(postCommentDto.getBoardId());
        commentDto.setTitle(postCommentDto.getTitle());
        commentDto.setComment(postCommentDto.getContent());
        commentDto.setRegDate(LocalDate.now());
        commentDto.setUpdateDate(LocalDate.now());

        MultipartFile file = postCommentDto.getImage();

        try {
            response = service.postCommentServ(commentDto, file);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "댓글 등록에 실패하였습니다.");
        }

        return response;
    }

    @Data
    private static class PostCommentDto {
        @JsonProperty("boardId")
        private Long boardId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("image")
        private MultipartFile image;
    }

    @DeleteMapping("/customerInquiry/comment")
    public @ResponseBody Map<String, Object> deleteCustomerInquiry(@RequestParam("id") Long id, Authentication authentication) {
        System.out.println("CustomerInquiryBoardController's deleteCustomerInquiry id: " + id);

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
            // 관리자가 아니라면 게시글을 삭제할 수 없다
            response.put("success", false);
            response.put("msg", "관리자만 게시글을 삭제할 수 있습니다.");
            return response;
        }

        try {
            response = service.deleteCustomerInquiryCommentServ(id);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "DB 통신에 실패하였습니다.");
        }

        return response;
    }

}
