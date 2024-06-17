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
| /productInquiryDetail | GET | 내가 작성한 상품문의상세를 조회합니다.|https://docs.github.com/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
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
