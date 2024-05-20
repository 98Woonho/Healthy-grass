회원 기능
| URI           | REQUEST METHOD | DESCRIPTION            |
|---------------|----------------|------------------------|
| /users        | POST           | 새로운 회원을 생성합니다. |
| /users/{Id} | GET           | 특정 회원을 조회합니다.  |
| /users/{Id} | PATCH         | 특정 회원 정보를 수정합니다. |
| /users/{Id} | DELETE        | 특정 회원을 삭제합니다.  |
| /products/{Id} | GET         | 특정 물건을 조회합니다.  |
| /productReviews | POST | 상품 리뷰를 작성합니다. |
| /productReviews/{Id} | GET | 특정 상품리뷰를 조회합니다. |
| /productReviews/{Id} | PATCH | 특정 상품리뷰를 수정합니다. |
| /productReviews/{Id} | DELETE | 특정 상품리뷰를 삭제합니다. |


관리자 기능
| URI                | REQUEST METHOD | DESCRIPTION                  |
|--------------------|----------------|------------------------------|
| /admin/users       | GET                | 가입된 전체 회원을 조회합니다.|
| /admin/products     | POST           | 새로운 물건을 등록합니다.      |
| /admin/products/{Id} | PATCH         | 특정 물건 정보를 수정합니다.   |
| /admin/products/{Id} | DELETE      | 특정 물건을 삭제합니다.        |
