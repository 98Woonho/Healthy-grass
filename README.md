1. 엔드포인트에서는 동사 대신 명사를 사용하세요
REST API를 설계할 때는 엔드포인트 주소에 동사를 사용하지 마세요. 이때는 명사를 사용해서 각 엔드포인트들이 무슨 일을 하는지 명시해야 합니다.

HTTP 메소드들이 이미 GET, PUT, PATCH, DELETE라는 동작을 (Create, Read, Update, Delete) 동사의 형태로 나타내기 때문입니다.

GET, POST, PUT, PATCH, DELETE는 가장 주로 쓰이는 HTTP 동사들이고, COPY, PURGE, LINK, UNLINK 등과 같은 다른 것들도 있습니다.

따라서 엔드포인트 주소는 다음과 같아서는 안 됩니다. https://mysite.com/getPosts 혹은 https://mysite.com/createPost 대신에 이런 모습이면 더 좋겠지요: https://mysite.com/posts

요약하자면, HTTP 메소드로 엔드포인트가 무슨 일을 할지 정하도록 하세요. GET은 데이터를 얻어오고, POST는 데이터를 생성하며, PUT은 데이터를 갱신하고, DELETE는 그 데이터를 삭제하도록 합시다.

2. 복수 명사를 사용하세요
API 데이터는 사용자로부터 얻어온 리소스라고도 볼 수 있습니다.

https://mysite.com/post/123와 같은 엔드포인트가 있다면, POST 요청으로 게시물을 지우거나, PUT 혹은 PATCH 요청을 통해 갱신하는 게 가능할 겁니다. 그러나 사용자는 다른 게시물들이 있음을 알아채기 힘들 수 있기 때문에 복수 명사를 사용해야 합니다.

따라서 https://mysite.com/post/123 보다는, https://mysite.com/posts/123이 되어야 합니다.

3. 에러 핸들링을 위해 상태 코드를 사용하세요
API 요청에 대해 응답할 때는 항상 HTTP 상태 코드를 포함해야 합니다. 그래야만 사용자가 요청이 성공했는지, 실패했는지 등 어떻게 돌아가는지 알 수 있습니다.

다음은 HTTP 상태 코드들과 의미를 담은 표입니다.

상태 코드 범위	의미
100 - 199	정보 제공용
예를 들어, 102는 자원이 가공 중인 걸 나타냅니다.
300 - 309	리다이렉트
예를 들어, 301은 영구적으로 이동한 걸 나타냅니다.
400 - 409	클라이언트 단 에러
예를 들어, 400은 클라이언트 측에서 잘못 요청한 것을, 404는 요청한 자원을 찾을 수 없다는 것을 나타냅니다.
500 - 509	서버 단 에러
예를 들어, 500은 서버 내부의 에러를 나타냅니다.
4. 관계를 보여주기 위해 엔드포인트를 중첩해 사용하세요
종종 다른 엔드포인트들은 연결되곤 합니다. 따라서 이해하기 쉽도록 중첩해 사용하세요

멀티 유저 블로그 플랫폼의 경우를 예로 들자면, 여러 게시물이 각기 다른 사용자들에 의해 작성됩니다. 따라서 엔드포인트를 https://mysite.com/posts/author 만들면 됩니다.

같은 식으로, 게시물들은 각자의 댓글들을 가지고 있기 때문에 댓글을 받아오는 엔드포인트는 https://mysite.com/posts/postId/comments 정도면 될 것 같습니다.

그렇다고 3단계 이상을 중첩하면 가독성이 떨어지기 때문에 너무 많이 중첩하지 않는 것이 좋습니다.
ERD
![건강풀때기_ERD](https://github.com/pakms980319/ShoppingMall-SpringBoot-Mybatis/assets/114930673/7f1923f4-16d7-4dd2-9beb-59ad00ed4f89)



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

