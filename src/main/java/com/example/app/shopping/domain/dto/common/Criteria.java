package com.example.app.shopping.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Criteria {
    private Integer pageno;		// 현재 페이지
    private Integer amount;	// 표시할 게시물 양(10건)
    private String keyword;			// 포함문자열
    private String sorting;         // 정렬 방식
    private String majorCategory;   // 대분류
    private String middleCategory;  // 중분류
    
    private String commentChk;  // 댓글 없는 게시판을 조회하기 위한 체크값

    public Criteria() {
        pageno=1;
        amount=10;
    }

    public Criteria(int no,int amt) {
        pageno = no;
        amount =amt;
    }
    public Criteria(String keyword) {
        pageno=1;
        amount=10;

        this.keyword = keyword;
    }
    public Criteria(int no,int amt, String keyword) {
        pageno = no;
        amount = amt;

        this.keyword = keyword;
    }
}
