package com.example.app.shopping.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Criteria {
    private int pageno;	 			//현재 페이지
    private int amount;	 			//표시할 게시물 양(10건)
    private String type;			//	제목,작성자,게시물번호
    private String keyword;			//	포함문자열

    public Criteria() {
        pageno=1;
        amount=10;
    }

    public Criteria(int no,int amt) {
        pageno = no;
        amount =amt;
    }
    public Criteria(String type, String keyword) {
        pageno=1;
        amount=10;

        this.type=type;
        this.keyword = keyword;
    }
    public Criteria(int no,int amt,String type, String keyword) {
        pageno = no;
        amount =amt;

        this.type=type;
        this.keyword = keyword;
    }
}
