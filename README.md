ERD
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/114930673/2ee7465b-0b5b-476f-8096-ac8169a02274)





비회원 기능
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /productDetail | GET         | 물건상세 폼으로 갑니다. 상세폼에는 상품상세게시판/상품문의게시판/상품후기게시판/장바구니버튼/구매버튼 등이 보여져야합니다. |


회원 기능
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /joinForm | GET         | 회원가입 페이지로 이동합니다. | 
| /users | GET           | 나의 회원정보를 조회합니다.  |
| /users | POST           | 새로운 회원을 생성합니다. |
| /users | PATCH         | 나의 회원정보를 수정합니다. |
| /users | DELETE        | 나의 회원을 삭제합니다.  |
| /productDetail | GET         | 물건상세 폼으로 갑니다. 상세폼에는 상품상세게시판/상품문의게시판/상품후기게시판/장바구니버튼/구매버튼 등이 보여져야합니다. |
| /productReviews | GET | 내가 작성한 상품 후기를 조회합니다. 상품후기글은 리스트 형태로 조회합니다. |
| /productReviews | POST | 특정 물품의 상품 후기를 작성합니다. 상품후기는 상품구매 후 배송이 완료되면 마이페이지/주문정보에서 작성이 가능합니다. |
| /productReviewDetail | GET | 내가 작성한 상품 후기상세를 조회합니다.|
| /productReviewDetail | PATCH | 특정 물품의 상품후기를 수정합니다. 상품후기는 상품상세 |
| /productReviewDetail | DELETE | 특정 물품의 상품후기를 삭제합니다. |
| /productInquirys | GET | 내가 작성한 상품문의글을 조회합니다. 상품문의글은 리스트 형태로 조회합니다. |
| /productInquirys | POST | 상품 문의 글을 작성합니다. 상품문의는 상품상세페이지에 상품문의게시판에서 작성가능합니다. |
| /productInquiryDetail | GET | 내가 작성한 상품문의상세를 조회합니다.|
| /productInquiryDetail | PATCH | 나의 상품 문의글을 수정합니다. 상품문의 수정은 상품문의 상세페이지에서 가능합니다. |
| /productInquiryDetail | DELETE | 나의 상품 문의글을 삭제합니다. 상품문의 삭제는 상품문의 상세페이지에서 가능합니다.|
| CustomerInquirys | GET | 내가작성한 고객문의글을 조회합니다. 고객문의글은 리스트 형태로 조회합니다. |
| CustomerInquirys | POST | 고객문의글을 작성합니다. 고객문의글은 마이페이지/1:1문의 에서 작성가능합니다.|
| CustomerInquiryDetail | GET | 내가작성한 고객문의 상세글을 조회합니다.|
| CustomerInquiryDetail | PATCH | 고객문의글을 수정합니다. 고객문의 수정은 고객문의 상세페이지에서 가능합니다. |
| CustomerInquiryDetail | DELETE | 고객문의글을 삭제합니다. 고객문의 삭제는 고객문의 상세페이지에서 가능합니다. |




관리자 기능
| URI                | REQUEST METHOD | DESCRIPTION                  |
|--------------------|----------------|------------------------------|
| /admin/users       | GET                | 가입된 전체 회원을 조회합니다.|
| /admin/products     | POST           | 새로운 물건을 등록합니다.      |
| /admin/products | PATCH         | 관리자가 등록한 물건 정보를 수정합니다. 물건정보 수정은 물건상세 폼에서 가능합니다.  |
| /admin/products | DELETE      | 관리자가 등록한 물건을 삭제합니다. 물건정보 삭제는 물건상세 폼에서 가능합니다. |
| /admin/productInquirys | GET | 전체 상품 문의글을 리스트 형태로 조회합니다. |
| /admin/productInquiryDetail/comments | POST | 상품 문의댓글을 작성합니다. |
| /admin/productInquiryDetail/comments | PATCH | 관리자가 작성한 상품 문의댓글을 수정합니다. |
| /admin/productInquiryDetail/comments | DELETE | 관리자가 작성한 상품 문의댓글을 삭제합니다. |

