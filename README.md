WEB PROJECT PLANING
=

## ▶️ 개발 동기
<strong>
    <p>농축산물 쇼핑몰 웹 서비스는 뉴스 등 매체를 통해 복잡한 유통 과정을 확인하였고 이를 개선하기 위해 기획 되었습니다.</p>
    <p>생산자들이 사이트 관리자를 통해 상품을 판매할 수 있는 플랫폼을 제공하여 이익을 극대화하고</p>
    <p>소비자들이 신선하고 질 좋은 농축산물을 합리적인 가격에 구매할 수 있도록 하기 위해 개발되었습니다.</p>
</strong>
<br/>

## ▶️ 개발 목표
<strong>
    <p>농축산물 쇼핑몰 웹 서비스 구축 및 배포</p>
</strong>
<br/>

## ▶️ 참가 인원 
[박민석 BE/FE](https://github.com/pakms980319) | [황보성현 BE/FE](https://github.com/hbsh2330) | [이운호 BE/FE](https://github.com/98Woonho) |
<br/>

## ▶️ 개발 일정
|PLAN|일정|DESCRIPTION|
|---------------|----------------|------------------------|
|주제 선정 및 요구사항 분석, 기술스택 결정, 개발환경 구축|2024-05-20 ~ 2024-05-22(02Days)|완료| 
|기본 구조 설계 및 백엔드 개발|2024-05-23 ~ 2024-06-28(37Days)|50% 진행중| 
|프론트엔드 및 백엔드 개발|2024-06-28 ~ 2024-07-12(15Days)|예정| 
|테스트 및 유지보수|2024-07-13 ~ 2024-07-20(8Days)|예정| 
<br/>

## ▶️ 역할
|조원|주역할|보조역할|
|---------------|----------------|------------------------|
|공통|요구사항분석 및 시스템 설계|-| 
|박민석(조장, BE/FE)|상품 서비스, 게시판 서비스|회원 서비스, 결제 서비스, 장바구니 서비스| 
|황보성현(조원1, BE/FE)|회원 서비스, 주문/결제 서비스, 장바구니 서비스|배송 서비스| 
|이운호(조원2, BE/FE)|상품 서비스, 배송 서비스|결제 서비스| 
<br/>

## ▶️ 개발 환경
<strong>
    <p>IDE : IntelliJ Idea</p>
    <p>JDK 17</p>
    <p>SpringBoot Version : 3.2.5</p>
    <p>Build Tool : gradle</p>
    <p>DBMS : Mysql</p>
    <p>Connection Pool : HikariCP</p>
    <p>Version Control : Git</p>
    <p>Repository Hosting : GitHub</p>
    <p>Testing Framework : JUnit5</p>
    <p>Security : Spring Security</p>
</strong>
<br/>

## ▶️ 사용 API
|용도|제공|API 문서|
|---------------|----------------|------------------------|
|결제|아임포트|[링크](https://developers.portone.io/docs/ko/readme?v=v1)|
|인증|아임포트|[링크](https://developers.portone.io/docs/ko/readme?v=v1)|
|주소 찾기|다음|[링크](https://postcode.map.daum.net/guide)|
|OAuth2 로그인|카카오|[링크](https://developers.kakao.com/docs/latest/ko/index)|
|OAuth2 로그인|구글|[링크](https://console.cloud.google.com/)|
|OAuth2 로그인|네이버|[링크](https://developers.naver.com/products/login/api/api.md)|
|이메일 인증|Google Gmail|[링크](https://console.cloud.google.com/)|
<br/>

## ▶️ 기술스택

### BACKEND
![JAVA](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white)
![SpringBoot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![SpringSecurity](https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![thymeleaf](https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
### FRONTEND

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Axios](https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=Axios&logoColor=white)
![BootStrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)

### SERVER
![MySQL](https://img.shields.io/badge/Mysql-4479A1?style=for-the-badge&logo=Mysql&logoColor=white)
![AWS](https://img.shields.io/badge/amazonwebservices-232F3E?style=for-the-badge&logo=amazonwebservices&logoColor=white)
![jenkins](https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)

### DEVOPS
![redhat](https://img.shields.io/badge/redhat-EE0000?style=for-the-badge&logo=redhat&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Github](https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white)
![intelli-j](https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
<br/>

## ▶️ 주요 기능
<strong>
    <p>JWT 기반 로그인/소셜 로그인 및 회원가입</p>
    <p>상품문의/상품리뷰/고객문의 게시판</p>
    <p>상품 조회/검색</p>
    <p>사용자 마이페이지(회원정보 조회/수정/탈퇴, 작성글 조회/수정/삭제, 장바구니/찜 목록 조회/수정/삭제  , 주문/결제 내역 조회, 결제 취소 신청, 배송지 정보 관리)</p>
    <p>관리자 페이지(매출 현황 그래프, 문의글 관리, 댓글 작성/삭제, 상품 등록/수정/삭제, 주문/결제 관리)</p>
</strong>
<br/>

## ▶️ ERD
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/114930673/2ee7465b-0b5b-476f-8096-ac8169a02274)
<br/>


## ▶️ 유스케이스 다이어그램
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/141478303/19f868cd-d3e7-4498-9b67-ca2088b515e4)
<br/>


## ▶️ 시퀀스 다이어그램
<strong><p>회원가입</p></strong>
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/141478303/c4db6478-c703-4933-940a-7f4816d3f1df)
<br/>

<strong><p>상품구매</p></strong>
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/141478303/d520506a-c821-4d04-a4a6-2cb7fbe11d15)
<br/>

<strong><p>비밀번호 찾기</p></strong>
![image](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/141478303/c2ff37df-0393-4426-b95a-332c1fc759a1)
<br/>


## ▶️ 주요 END POINT
<strong>회원 서비스</strong>
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /user         | POST               | 회원가입을 합니다. 회원가입은 포트원 본인인증 API를 사용해서 인증된 회원만 회원가입이 가능합니다. |
| /user/findUserIdByEmail     | POST               | 회원이 가입한 이메일로 회원의 아이디를 찾는 서비스입니다. |
| /user/findUserIdByPhone     | POST               | 회원이 가입한 휴대폰번호로 회원의 아이디를 찾는 서비스입니다. |
| /user/findUserPasswordByEmailAsRandomValue     | POST               | 회원 이메일과 랜덤코드를 받아서 회원의 비밀번호를 찾는 서비스입니다. 인증에 통과한 회원에게 비밀번호 랜덤값을 전송합니다. |
| /user/findUserPasswordByAuthentication     | POST               | 포트원 본인인증 API를 사용해서 회원의 비밀번호를 찾는 서비스입니다. 본인인증에 통과한 회원에게 비밀번호 랜덤값을 전송합니다.|
| /user/duplicateUserCheck     | POST               | 회원가입시 중복된 회원인지 확인하는 서비스입니다.  |
| /myPage/user/modify     | PATCH               | 회원정보를 수정하는 서비스입니다. 회원정보 수정시 아이디, 비밀번호 체크를 한번더 통해서 인증된 회원만 수정이 가능합니다. |
| /myPage/user/delete     | DELETE               | 회원정보를 삭제하는 서비스입니다. 회원정보 삭제시 아이디, 비밀번호 체크를 한번더 통해서 인증된 회원만 수정이 가능합니다. |
| /myPage/user/searchForm     | GET               | 회원정보 조회를 합니다. 회원조회시 회원의 중요 정보(아이디, 비밀번호 등)을 제외한 개인정보(이름, 주소, 휴대폰 번호)등을 확인 할 수 있습니다.|
<br/>

<strong>상품 서비스</strong>
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /productList | GET         | 상품 리스트를 조회합니다. | 
| /product | GET           | 상품 상세정보를 조회합니다  |
| /popularProducts | GET           | 카테고리별 인기 상품 리스트를 반환합니다. |
| /highDiscountProducts | GET         | 할인율이 높은 상품 리스트를 반환합니다.  |
| /recentProducts | GET        | 최근에 등록된 상품 리스트를 반환합니다.  |
| /admin/addProduct | GET        | 상품 등록 폼 페이지를 조회합니다.  |
| /admin/product | POST        | 상품을 등록합니다.  |
| /admin/modifyProduct | GET        | 상품 수정 폼 페이지를 조회합니다.  |
| /admin/product | PUT        | 상품을 수정합니다.  |
<br/>

<strong>게시판 서비스</strong>
| URI                | REQUEST METHOD | DESCRIPTION                  |
|--------------------|----------------|------------------------------|
| /customerInquiryBoardList       | GET                | 고객 문의 게시판을 조회합니다. |
| /customerInquiryBoard       | GET                | 고객 문의 상세 정보를 조회합니다. |
| /myCustomerInquiryBoardList       | GET                | 나의 고객 문의 게시판을 조회합니다. |
| /customerInquiryBoardComment       | GET                | 고객 문의 게시글에 작성된 댓글 리스트를 반환합니다. |
| /productInquiryBoardList       | GET                | 상품 문의 게시판을 조회합니다. |
| /productInquiryBoard       | GET                | 상품 문의 게시글을 조회합니다. |
| /productInquiryBoard/passwordCheck       | POST                | 상품 문의 게시글 비밀번호를 체크합니다. |
| /myProductInquiryBoardList      | GET                | 나의 상품 문의 게시판을 조회합니다. |
| /productInquiryBoardListAPI      | GET                | 상품에 대해 작성된 상품 문의 게시글 리스트를 반환합니다. |
| /productInquiry      | GET                | 상품 문의 게시글 작성 페이지를 조회합니다. |
| /productInquiry      | POST                | 상품 문의 게시글을 작성합니다. |
| /updateProductInquiry      | GET                | 상품 문의 게시글 수정 페이지를 조회합니다. |
| /productInquiry      | PUT                | 상품 문의 게시글을 수정합니다. |
| /productInquiry      | DELETE                | 상품 문의 게시글을 삭제합니다. |
| /ProductInquiryBoardComment      | GET                | 게시글에 작성된 댓글 리스트를 반환합니다. |
| /productReviewBoardListAPI      | POST                | 상품에 대해 작성된 상품 리뷰 리스트를 반환합니다. |
| /productReviewBoardList      | GET                | 상품 리뷰 게시판을 조회합니다. |
| /productReviewBoard      | GET                | 상품 리뷰 게시글을 조회합니다. |
| /myProductReviewBoardList      | GET                | 나의 상품 리뷰 게시판을 조회합니다. |
<br/>


<strong>장바구니 서비스</strong>
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /cart         | GET               | 장바구니에 담긴 물건들을 보여주는 서비스입니다.|
| /cart         | POST              | 장바구니에 물건을 담는 서비스입니다. 비회원도 장바구니에 물건을 담을 수 있습니다. |
| /cart/Amount   | POST             | 장바구니에서도 물건의 수량을 변경할 수 있는 서비스입니다. 수량을 변경하면 cart-items의 테이블에 담긴 수량이 변경됩니다. |
| /cart/delete   | DELETE             | 장바구니에 담긴 물건을 삭제할 수 있는 서비스입니다. 물건을 삭제하면 CASCADE옵션으로 인해 cart의 하위 테이블도 함께 삭제됩니다. |
<br/>


<strong>주문/결제 서비스</strong>
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /order         | GET              | 주문한 물건들을 보여주는 서비스입니다. 물건 주문 시 주문할 물건만 보여줍니다.|
| /order         | POST             | 물건들을 주문하는 서비스입니다. 물건 주문은 장바구니 또는 상품페이지에서 가능합니다. |
| /order/user    | GET              | 주문자 정보와 동일함 클릭시 회원가입시 입력한 정보를 바탕으로 화면에 전달해주는 서비스입니다. |
| /order/recent    | GET          | 최근에 입력한 배송지를 바탕으로 화면에 전달해주는 서비스입니다. |
| /payment/paymentForm         | GET        | 결제한 정보를 조회할 수 있는 서비스입니다.|
| /payment/save         | POST               | 결제한 정보를 저장하는 서비스입니다. 결제정보 저장 후 회원은 결제 정보 조회가 가능합니다.|
| /payment/cancel         | POST               | 결제를 취소하는 서비스입니다. 결제 취소는 관리자가 승인 한 이후 환불처리가 이루어집니다.|
<br/>

<strong>배송지 서비스</strong>
| URI                | REQUEST METHOD | DESCRIPTION                  |
|--------------------|----------------|------------------------------|
| /myPage/editAddress       | GET                | 배송지 작성/수정 페이지를 조회하는 서비스 입니다. |
| /myPage/editAddress       | POST                | 배송지를 작성/수정 하는 서비스 입니다. |
| /myPage/editAddress       | POST                | 배송지를 작성/수정 하는 서비스 입니다. |
| /order/shipping       | GET                | 나의 배송지 정보를 반환하는 서비스 입니다. |
<br/>

📃: File Tree
---
```
C:.
│  .gitignore
│  build.gradle
│  gradlew
│  gradlew.bat
│  README.md
│  settings.gradle
│
├─.gradle
│  ├─8.7
│  │  │  gc.properties
│  │  │
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │
│  │  ├─dependencies-accessors
│  │  │      gc.properties
│  │  │
│  │  ├─executionHistory
│  │  │      executionHistory.lock
│  │  │
│  │  ├─expanded
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │
│  │  ├─fileHashes
│  │  │      fileHashes.lock
│  │  │
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │
│  └─vcs-1
│          gc.properties
│
├─.idea
│  │  .gitignore
│  │  .name
│  │  compiler.xml
│  │  dataSources.local.xml
│  │  dataSources.xml
│  │  gradle.xml
│  │  jarRepositories.xml
│  │  misc.xml
│  │  vcs.xml
│  │  workspace.xml
│  │
│  └─dataSources
│      │  e4fc7de4-c637-429f-99ca-5b216a7187d0.xml
│      │
│      └─e4fc7de4-c637-429f-99ca-5b216a7187d0
│          └─storage_v2
│              └─_src_
│                  └─schema
│                          information_schema.FNRwLQ.meta
│                          mysql.osA4Bg.meta
│                          performance_schema.kIw0nw.meta
│                          shopping.aPF36w.meta
│                          sys.zb4BAA.meta
│
├─build
│  └─classes
│      └─java
│          └─main
│              └─com
│                  └─example
│                      └─app
│                          │  AppApplication.class
│                          │
│                          └─shopping
│                              ├─config
│                              │  │  DataSourceConfig.class
│                              │  │  MybatisConfig.class
│                              │  │  SecurityConfig.class
│                              │  │  WebConfig.class
│                              │  │  WebMvcConfig.class
│                              │  │
│                              │  └─auth
│                              │          PrincipalDetails$1.class
│                              │          PrincipalDetails.class
│                              │          PrincipalDetailsService.class
│                              │
│                              ├─controller
│                              │      AdminController.class
│                              │      CartController.class
│                              │      CustomerInquiryBoardCommentController.class
│                              │      CustomerInquiryBoardController.class
│                              │      HomeController.class
│                              │      MyPageController.class
│                              │      OrderController$AddOrder.class
│                              │      OrderController.class
│                              │      PaymentController$PortOneTokenResponse.class
│                              │      PaymentController$TokenResponse.class
│                              │      PaymentController.class
│                              │      ProductController.class
│                              │      ProductInquiryBoardCommentController.class
│                              │      ProductInquiryBoardController$ProductReviewBoardAPI.class
│                              │      ProductInquiryBoardController.class
│                              │      ProductReviewBoardController$ProductReviewBoardAPI.class
│                              │      ProductReviewBoardController.class
│                              │      UserController$AuthInfoResponse.class
│                              │      UserController$PortOneAuthInfoResponse.class
│                              │      UserController$PortOneTokenResponse.class
│                              │      UserController$TokenResponse.class
│                              │      UserController.class
│                              │
│                              ├─domain
│                              │  ├─dto
│                              │  │  │  CartDto.class
│                              │  │  │  CartItemsDto.class
│                              │  │  │  CustomerInquiryBoardDto.class
│                              │  │  │  CustomerInquiryCommentDto.class
│                              │  │  │  OrderDto.class
│                              │  │  │  OrderItemDto.class
│                              │  │  │  PaymentDto.class
│                              │  │  │  PersistentLoginsDto.class
│                              │  │  │  ProductDetailBoardDto.class
│                              │  │  │  ProductDto.class
│                              │  │  │  ProductInquiryBoardCommentDto.class
│                              │  │  │  ProductInquiryBoardDto.class
│                              │  │  │  ProductMajorCategoryDto.class
│                              │  │  │  ShippingAddressDto.class
│                              │  │  │  UserDto$UserDtoBuilder.class
│                              │  │  │  UserDto.class
│                              │  │  │  WishlistDto.class
│                              │  │  │
│                              │  │  └─common
│                              │  │          Criteria.class
│                              │  │          PageDto.class
│                              │  │
│                              │  ├─mapper
│                              │  │      CartItemMapper.class
│                              │  │      CartMapper.class
│                              │  │      CustomerInquiryBoardCommentMapper.class
│                              │  │      CustomerInquiryBoardMapper.class
│                              │  │      OrderItemMapper.class
│                              │  │      OrderMapper.class
│                              │  │      PaymentMapper.class
│                              │  │      ProductInquiryBoardCommentMapper.class
│                              │  │      ProductInquiryBoardMapper.class
│                              │  │      ProductMapper.class
│                              │  │      ProductReviewBoardMapper.class
│                              │  │      UserMapper.class
│                              │  │
│                              │  └─service
│                              │      │  PaymentService.class
│                              │      │
│                              │      ├─admin
│                              │      │      AdminService.class
│                              │      │
│                              │      ├─cart
│                              │      │      CartService.class
│                              │      │
│                              │      ├─customerInquiryBoard
│                              │      │      CustomerInquiryBoardService.class
│                              │      │      CustomerInquiryBoardServiceImpl.class
│                              │      │
│                              │      ├─customerInquiryBoardComment
│                              │      │      CustomerInquiryBoardCommentService.class
│                              │      │      CustomerInquiryBoardCommentServiceImpl.class
│                              │      │
│                              │      ├─order
│                              │      │      OrderService.class
│                              │      │
│                              │      ├─product
│                              │      │      ProductService.class
│                              │      │      ProductServiceImpl.class
│                              │      │
│                              │      ├─productInquiryBoard
│                              │      │      productInquiryBoardService.class
│                              │      │      productInquiryBoardServiceImpl.class
│                              │      │
│                              │      ├─productInquiryBoardComment
│                              │      │      ProductInquiryBoardCommentService.class
│                              │      │      ProductInquiryBoardCommentServiceImpl.class
│                              │      │
│                              │      ├─productReviewBoard
│                              │      │      ProductReviewBoardService.class
│                              │      │      ProductReviewBoardServiceImpl.class
│                              │      │
│                              │      └─user
│                              │              UserService.class
│                              │
│                              ├─handler
│                              │      CustomLoginFailureHandler.class
│                              │      CustomLogoutHandler.class
│                              │
│                              └─valid
│                                      CustomPasswordMatchesValidator.class
│                                      PasswordMatches.class
│
├─design
│  ├─ERD
│  │      ERD.drawio
│  │      ERD.png
│  │
│  ├─ShoppingMall_html
│  │      addProduct.html
│  │      basket.html
│  │      categoryProductList.html
│  │      index.html
│  │      mypage.html
│  │      order.html
│  │      passwordCheckForm.html
│  │      productDetail.html
│  │      productInquiry.html
│  │      userInquiry.html
│  │      wishlist.html
│  │
│  ├─SQL
│  │      Shopping.sql
│  │
│  └─UI
│      │  게시글조회.png
│      │  게시판.png
│      │  관리자.png
│      │  관리자_게시판관리.png
│      │  관리자_등록상품조회.png
│      │  관리자_매출 현황.png
│      │  관리자_문의.png
│      │  관리자_상품등록.png
│      │  관리자_주문내역.png
│      │  로그인.png
│      │  마이페이지.png
│      │  메인.png
│      │  비밀번호재확인-회원정보수정.png
│      │  비밀번호재확인-회원탈퇴.png
│      │  상품리뷰페이지.png
│      │  상품문의페이지.png
│      │  상품상세페이지.png
│      │  상품주문조회.png
│      │  장바구니.png
│      │  좋아요.png
│      │  주문, 결제 페이지.png
│      │  최근주문조회.png
│      │  카테고리상품조회.png
│      │  회원가입.png
│      │  회원가입양식.png
│      │  회원가입완료페이지.png
│      │  회원정보수정.png
│      │
│      └─template
│              footer.png
│              header.png
│              관리자용 header.png
│
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
├─out
│  └─production
│      └─resources
│          │  application.properties
│          │
│          ├─mapper
│          │      CartItemMapper.xml
│          │      CartMapper.xml
│          │      CustomerInquiryBoardCommentMapper.xml
│          │      CustomerInquiryBoardMapper.xml
│          │      OrderItemMapper.xml
│          │      OrderMapper.xml
│          │      PaymentMapper.xml
│          │      ProductInquiryBoardCommentMapper.xml
│          │      ProductInquiryBoardMapper.xml
│          │      ProductMapper.xml
│          │      ProductReviewBoardMapper.xml
│          │      UserMapper.xml
│          │
│          ├─static
│          │  ├─css
│          │  │  ├─admin
│          │  │  │      addProduct.css
│          │  │  │      modifyProduct.css
│          │  │  │
│          │  │  ├─cart
│          │  │  │      cartForm.css
│          │  │  │
│          │  │  ├─customerInquiryBoardDetail
│          │  │  │      customerInquiryBoardDetail.css
│          │  │  │
│          │  │  ├─customerInquiryBoardList
│          │  │  │      common.css
│          │  │  │
│          │  │  ├─fragments
│          │  │  │      common.css
│          │  │  │      nav.css
│          │  │  │
│          │  │  ├─index
│          │  │  │      common.css
│          │  │  │      hightDiscountProducts.css
│          │  │  │      popularProducts.css
│          │  │  │      recentProducts.css
│          │  │  │
│          │  │  ├─myPage
│          │  │  │      common.css
│          │  │  │      mainDetail.css
│          │  │  │      myCustomerInquiryPage.css
│          │  │  │      myReviewPage.css
│          │  │  │
│          │  │  ├─order
│          │  │  │      order.css
│          │  │  │
│          │  │  ├─product
│          │  │  │      productDetail.css
│          │  │  │      productInquiryBoard.css
│          │  │  │      productReviewBoard.css
│          │  │  │
│          │  │  ├─productInquiry
│          │  │  │      addProductInquiry.css
│          │  │  │      updateProductInquiry.css
│          │  │  │
│          │  │  ├─productInquiryBoardDetail
│          │  │  │      productInquiryBoardDetail.css
│          │  │  │      productInquiryBoardDetailPasswordCheck.css
│          │  │  │
│          │  │  ├─productInquiryBoardList
│          │  │  │      common.css
│          │  │  │
│          │  │  ├─productList
│          │  │  │      common.css
│          │  │  │
│          │  │  ├─productReviewBoardDetail
│          │  │  │      productReviewBoardDetail.css
│          │  │  │
│          │  │  └─productReviewBoardList
│          │  │          common.css
│          │  │
│          │  ├─img
│          │  │      minus.svg
│          │  │      plus.svg
│          │  │
│          │  └─js
│          │      ├─admin
│          │      │      addProduct.js
│          │      │      modifyProduct.js
│          │      │
│          │      ├─cart
│          │      │      cartForm.js
│          │      │
│          │      ├─customerInquiryBoardDetail
│          │      │      customerInquiryBoardDetailCommentProcess.js
│          │      │
│          │      ├─customerInquiryBoardList
│          │      │      searchFormOnchange.js
│          │      │
│          │      ├─index
│          │      │      hightDiscountProductsProcess.js
│          │      │      popularProductsProcess.js
│          │      │      recentProductsProcess.js
│          │      │
│          │      ├─myPage
│          │      │      deleteForm.js
│          │      │      modifyForm.js
│          │      │      passwordCheckForm.js
│          │      │      productInquiryBoardDetailPasswordCheckProcess.js
│          │      │      searchFormOnchange.js
│          │      │
│          │      ├─order
│          │      │      order.js
│          │      │
│          │      ├─payment
│          │      │      paymentForm.js
│          │      │
│          │      ├─productDetail
│          │      │      productDetail.js
│          │      │      productInquiryAddBtn.js
│          │      │      productInquiryProcess.js
│          │      │      productReviewProcess.js
│          │      │      toggleInquiryContentProcess.js
│          │      │      toggleReviewContentProcess.js
│          │      │
│          │      ├─productInquiry
│          │      │      formValidation.js
│          │      │      pwChkProcess.js
│          │      │      updateFormValidation.js
│          │      │
│          │      ├─productInquiryBoardDetail
│          │      │      btnProcess.js
│          │      │      productInquiryBoardDetailCommentProcess.js
│          │      │      productInquiryBoardDetailPasswordCheckProcess.js
│          │      │
│          │      ├─productInquiryBoardList
│          │      │      searchFormOnchange.js
│          │      │
│          │      ├─productList
│          │      │      searchFormOnchange.js
│          │      │
│          │      └─user
│          │              findUserIdForm.js
│          │              findUserPasswordForm.js
│          │              joinForm.js
│          │              loginForm.js
│          │
│          └─templates
│              │  index.html
│              │
│              ├─admin
│              │      addProduct.html
│              │      modifyProduct.html
│              │
│              ├─cart
│              │      cartForm.html
│              │
│              ├─customerInquiryBoard
│              │      boardDetail.html
│              │      boardList.html
│              │
│              ├─error
│              │      error.html
│              │
│              ├─fragments
│              │  │  link.html
│              │  │  nav.html
│              │  │  topHeader.html
│              │  │
│              │  └─myPage
│              │          mainMenu.html
│              │
│              ├─myPage
│              │      deleteForm.html
│              │      modifyForm.html
│              │      myCustomerInquiryPage.html
│              │      mypage.html
│              │      myProductInquiryPage.html
│              │      myReviewPage.html
│              │      passwordCheckForm.html
│              │      searchForm.html
│              │
│              ├─order
│              │      orderForm.html
│              │
│              ├─payment
│              │      paymentForm.html
│              │      paymentList.html
│              │
│              ├─product
│              │      productDetail.html
│              │      productList.html
│              │
│              ├─productInquiryBoard
│              │      addProductInquiry.html
│              │      boardDetail.html
│              │      boardList.html
│              │      passwordChk.html
│              │      updateProductInquiry.html
│              │
│              ├─productReviewBoard
│              │      boardDetail.html
│              │      boardList.html
│              │
│              └─user
│                      findUserIdForm.html
│                      findUserPasswordForm.html
│                      joinForm.html
│                      loginForm.html
│
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─app
    │  │              │  AppApplication.java
    │  │              │
    │  │              └─shopping
    │  │                  ├─config
    │  │                  │  │  DataSourceConfig.java
    │  │                  │  │  MybatisConfig.java
    │  │                  │  │  SecurityConfig.java
    │  │                  │  │  WebConfig.java
    │  │                  │  │  WebMvcConfig.java
    │  │                  │  │
    │  │                  │  └─auth
    │  │                  │          PrincipalDetails.java
    │  │                  │          PrincipalDetailsService.java
    │  │                  │
    │  │                  ├─controller
    │  │                  │      AdminController.java
    │  │                  │      CartController.java
    │  │                  │      CustomerInquiryBoardCommentController.java
    │  │                  │      CustomerInquiryBoardController.java
    │  │                  │      HomeController.java
    │  │                  │      MyPageController.java
    │  │                  │      OrderController.java
    │  │                  │      PaymentController.java
    │  │                  │      ProductController.java
    │  │                  │      ProductInquiryBoardCommentController.java
    │  │                  │      ProductInquiryBoardController.java
    │  │                  │      ProductReviewBoardController.java
    │  │                  │      UserController.java
    │  │                  │
    │  │                  ├─domain
    │  │                  │  ├─dto
    │  │                  │  │  │  CartDto.java
    │  │                  │  │  │  CartItemsDto.java
    │  │                  │  │  │  CustomerInquiryBoardDto.java
    │  │                  │  │  │  CustomerInquiryCommentDto.java
    │  │                  │  │  │  OrderDto.java
    │  │                  │  │  │  OrderItemDto.java
    │  │                  │  │  │  PaymentDto.java
    │  │                  │  │  │  PersistentLoginsDto.java
    │  │                  │  │  │  ProductDetailBoardDto.java
    │  │                  │  │  │  ProductDto.java
    │  │                  │  │  │  ProductInquiryBoardCommentDto.java
    │  │                  │  │  │  ProductInquiryBoardDto.java
    │  │                  │  │  │  ProductMajorCategoryDto.java
    │  │                  │  │  │  ShippingAddressDto.java
    │  │                  │  │  │  UserDto.java
    │  │                  │  │  │  WishlistDto.java
    │  │                  │  │  │
    │  │                  │  │  └─common
    │  │                  │  │          Criteria.java
    │  │                  │  │          PageDto.java
    │  │                  │  │
    │  │                  │  ├─mapper
    │  │                  │  │      CartItemMapper.java
    │  │                  │  │      CartMapper.java
    │  │                  │  │      CustomerInquiryBoardCommentMapper.java
    │  │                  │  │      CustomerInquiryBoardMapper.java
    │  │                  │  │      OrderItemMapper.java
    │  │                  │  │      OrderMapper.java
    │  │                  │  │      PaymentMapper.java
    │  │                  │  │      ProductInquiryBoardCommentMapper.java
    │  │                  │  │      ProductInquiryBoardMapper.java
    │  │                  │  │      ProductMapper.java
    │  │                  │  │      ProductReviewBoardMapper.java
    │  │                  │  │      ShippingAddressMapper.java
    │  │                  │  │      UserMapper.java
    │  │                  │  │
    │  │                  │  └─service
    │  │                  │      │  PaymentService.java
    │  │                  │      │
    │  │                  │      ├─admin
    │  │                  │      │      AdminService.java
    │  │                  │      │
    │  │                  │      ├─cart
    │  │                  │      │      CartService.java
    │  │                  │      │
    │  │                  │      ├─customerInquiryBoard
    │  │                  │      │      CustomerInquiryBoardService.java
    │  │                  │      │      CustomerInquiryBoardServiceImpl.java
    │  │                  │      │
    │  │                  │      ├─customerInquiryBoardComment
    │  │                  │      │      CustomerInquiryBoardCommentService.java
    │  │                  │      │      CustomerInquiryBoardCommentServiceImpl.java
    │  │                  │      │
    │  │                  │      ├─myPage
    │  │                  │      │      MyPageService.java
    │  │                  │      │
    │  │                  │      ├─order
    │  │                  │      │      OrderService.java
    │  │                  │      │
    │  │                  │      ├─product
    │  │                  │      │      ProductService.java
    │  │                  │      │      ProductServiceImpl.java
    │  │                  │      │
    │  │                  │      ├─productInquiryBoard
    │  │                  │      │      productInquiryBoardService.java
    │  │                  │      │      productInquiryBoardServiceImpl.java
    │  │                  │      │
    │  │                  │      ├─productInquiryBoardComment
    │  │                  │      │      ProductInquiryBoardCommentService.java
    │  │                  │      │      ProductInquiryBoardCommentServiceImpl.java
    │  │                  │      │
    │  │                  │      ├─productReviewBoard
    │  │                  │      │      ProductReviewBoardService.java
    │  │                  │      │      ProductReviewBoardServiceImpl.java
    │  │                  │      │
    │  │                  │      └─user
    │  │                  │              UserService.java
    │  │                  │
    │  │                  ├─handler
    │  │                  │      CustomLoginFailureHandler.java
    │  │                  │      CustomLogoutHandler.java
    │  │                  │
    │  │                  └─valid
    │  │                          CustomPasswordMatchesValidator.java
    │  │                          PasswordMatches.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │
    │      ├─mapper
    │      │      CartItemMapper.xml
    │      │      CartMapper.xml
    │      │      CustomerInquiryBoardCommentMapper.xml
    │      │      CustomerInquiryBoardMapper.xml
    │      │      OrderItemMapper.xml
    │      │      OrderMapper.xml
    │      │      PaymentMapper.xml
    │      │      ProductInquiryBoardCommentMapper.xml
    │      │      ProductInquiryBoardMapper.xml
    │      │      ProductMapper.xml
    │      │      ProductReviewBoardMapper.xml
    │      │      ShippingAddressMapper.xml
    │      │      UserMapper.xml
    │      │
    │      ├─static
    │      │  ├─css
    │      │  │  ├─admin
    │      │  │  │      addProduct.css
    │      │  │  │      modifyProduct.css
    │      │  │  │
    │      │  │  ├─cart
    │      │  │  │      cartForm.css
    │      │  │  │
    │      │  │  ├─customerInquiryBoardDetail
    │      │  │  │      customerInquiryBoardDetail.css
    │      │  │  │
    │      │  │  ├─customerInquiryBoardList
    │      │  │  │      common.css
    │      │  │  │
    │      │  │  ├─fragments
    │      │  │  │      common.css
    │      │  │  │      nav.css
    │      │  │  │
    │      │  │  ├─index
    │      │  │  │      common.css
    │      │  │  │      hightDiscountProducts.css
    │      │  │  │      popularProducts.css
    │      │  │  │      recentProducts.css
    │      │  │  │
    │      │  │  ├─myPage
    │      │  │  │      common.css
    │      │  │  │      editAddress.css
    │      │  │  │      mainDetail.css
    │      │  │  │      myCustomerInquiryPage.css
    │      │  │  │      myReviewPage.css
    │      │  │  │
    │      │  │  ├─order
    │      │  │  │      order.css
    │      │  │  │
    │      │  │  ├─product
    │      │  │  │      productDetail.css
    │      │  │  │      productInquiryBoard.css
    │      │  │  │      productReviewBoard.css
    │      │  │  │
    │      │  │  ├─productInquiry
    │      │  │  │      addProductInquiry.css
    │      │  │  │      updateProductInquiry.css
    │      │  │  │
    │      │  │  ├─productInquiryBoardDetail
    │      │  │  │      productInquiryBoardDetail.css
    │      │  │  │      productInquiryBoardDetailPasswordCheck.css
    │      │  │  │
    │      │  │  ├─productInquiryBoardList
    │      │  │  │      common.css
    │      │  │  │
    │      │  │  ├─productList
    │      │  │  │      common.css
    │      │  │  │
    │      │  │  ├─productReviewBoardDetail
    │      │  │  │      productReviewBoardDetail.css
    │      │  │  │
    │      │  │  └─productReviewBoardList
    │      │  │          common.css
    │      │  │
    │      │  ├─img
    │      │  │      minus.svg
    │      │  │      plus.svg
    │      │  │
    │      │  └─js
    │      │      ├─admin
    │      │      │      addProduct.js
    │      │      │      modifyProduct.js
    │      │      │
    │      │      ├─cart
    │      │      │      cartForm.js
    │      │      │
    │      │      ├─customerInquiryBoardDetail
    │      │      │      customerInquiryBoardDetailCommentProcess.js
    │      │      │
    │      │      ├─customerInquiryBoardList
    │      │      │      searchFormOnchange.js
    │      │      │
    │      │      ├─index
    │      │      │      hightDiscountProductsProcess.js
    │      │      │      popularProductsProcess.js
    │      │      │      recentProductsProcess.js
    │      │      │
    │      │      ├─myPage
    │      │      │      deleteForm.js
    │      │      │      editAddress.js
    │      │      │      modifyForm.js
    │      │      │      passwordCheckForm.js
    │      │      │      productInquiryBoardDetailPasswordCheckProcess.js
    │      │      │      searchFormOnchange.js
    │      │      │
    │      │      ├─order
    │      │      │      order.js
    │      │      │
    │      │      ├─payment
    │      │      │      paymentForm.js
    │      │      │
    │      │      ├─productDetail
    │      │      │      productDetail.js
    │      │      │      productInquiryAddBtn.js
    │      │      │      productInquiryProcess.js
    │      │      │      productReviewProcess.js
    │      │      │      toggleInquiryContentProcess.js
    │      │      │      toggleReviewContentProcess.js
    │      │      │
    │      │      ├─productInquiry
    │      │      │      formValidation.js
    │      │      │      pwChkProcess.js
    │      │      │      updateFormValidation.js
    │      │      │
    │      │      ├─productInquiryBoardDetail
    │      │      │      btnProcess.js
    │      │      │      productInquiryBoardDetailCommentProcess.js
    │      │      │      productInquiryBoardDetailPasswordCheckProcess.js
    │      │      │
    │      │      ├─productInquiryBoardList
    │      │      │      searchFormOnchange.js
    │      │      │
    │      │      ├─productList
    │      │      │      searchFormOnchange.js
    │      │      │
    │      │      └─user
    │      │              findUserIdForm.js
    │      │              findUserPasswordForm.js
    │      │              joinForm.js
    │      │              loginForm.js
    │      │
    │      └─templates
    │          │  index.html
    │          │
    │          ├─admin
    │          │      addProduct.html
    │          │      modifyProduct.html
    │          │
    │          ├─cart
    │          │      cartForm.html
    │          │
    │          ├─customerInquiryBoard
    │          │      boardDetail.html
    │          │      boardList.html
    │          │
    │          ├─error
    │          │      error.html
    │          │
    │          ├─fragments
    │          │  │  link.html
    │          │  │  nav.html
    │          │  │  topHeader.html
    │          │  │
    │          │  └─myPage
    │          │          mainMenu.html
    │          │
    │          ├─myPage
    │          │      deleteForm.html
    │          │      editAddress.html
    │          │      modifyForm.html
    │          │      myCustomerInquiryPage.html
    │          │      mypage.html
    │          │      myProductInquiryPage.html
    │          │      myReviewPage.html
    │          │      passwordCheckForm.html
    │          │      searchForm.html
    │          │
    │          ├─order
    │          │      orderForm.html
    │          │
    │          ├─payment
    │          │      paymentForm.html
    │          │      paymentList.html
    │          │
    │          ├─product
    │          │      productDetail.html
    │          │      productList.html
    │          │
    │          ├─productInquiryBoard
    │          │      addProductInquiry.html
    │          │      boardDetail.html
    │          │      boardList.html
    │          │      passwordChk.html
    │          │      updateProductInquiry.html
    │          │
    │          ├─productReviewBoard
    │          │      boardDetail.html
    │          │      boardList.html
    │          │
    │          └─user
    │                  findUserIdForm.html
    │                  findUserPasswordForm.html
    │                  joinForm.html
    │                  loginForm.html
    │
    └─test
        └─java
            └─com
                └─example
                    └─app
                        │  AppApplicationTests.java
                        │
                        └─shopping
                            ├─config
                            │      DataSourceConfigTest.java
                            │
                            └─domain
                                └─mapper
                                        ProductInquiryBoardMapperTest.java
                                        ProductReviewBoardMapperTest.java
