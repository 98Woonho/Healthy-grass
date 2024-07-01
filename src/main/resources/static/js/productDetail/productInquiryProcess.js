let currentPage2 = 1;

document.addEventListener('DOMContentLoaded', function() {
    loadProductInquiry(currentPage2);
});

function loadProductInquiry(page) {
    if (page < 1) return; // 페이지 번호가 1보다 작으면 요청하지 않음

    const pId = document.getElementById('productId').value;

    axios.post('/productInquiryBoardListAPI', {
        criteria: {
            pageno: page,
            amount: 10
        },
        pId: pId
    })
    .then(function(response) {
        if (response.data.success) {
            currentPage2 = page;
            displayProductInquiries(response.data.list);
            updatePagination2(response.data.pageDto);
        } else {
            alert('상품 문의를 불러오는 데 실패했습니다.');
        }
    })
    .catch(function(error) {
        console.error('서버 응답 에러:', error);
        alert('서버 응답 에러: ' + error.message);
    });
}

function displayProductInquiries(productInquiries) {
    const productInquiryList = document.getElementById('productInquiry-list');
    productInquiryList.innerHTML = ''; // 기존 상품 문의 목록 초기화

    productInquiries.forEach((productInquiry, index) => {
        // 각 상품 문의 제목에 대한 고유 ID 생성
        const productInquiryContentId = `productInquiry-content-${index}`;

        const row = document.createElement('tr');

        // 이미지 경로 결정
        const lockImageSrc = productInquiry.isLocked === 'Y' ? '/img/Lock_close.svg' : '/img/Lock_open.svg';

        row.innerHTML = `
            <td>${productInquiry.Uid}</td>
            <td><img src="${lockImageSrc}" alt="${productInquiry.isLocked === 'Y' ? '글잠김' : '잠김없음'}"></td>
            <td>${productInquiry.title}</td>
            <td>${productInquiry.regDate}</td>
        `;
        //tr 클릭하면 문의글 보이게 토글 설정
        row.onclick = () => toggleInquiryContentProcess(productInquiryContentId);
        productInquiryList.appendChild(row);

        const div1 = document.createElement('div');
        const row1 = document.createElement('tr');

        // tr 요소에 id 속성 추가
        row1.id = `inquiry-row-${index}`;

        if (productInquiry.isLocked === 'Y') {
            row1.innerHTML = `
                <td colspan="5" class="productInquiry-content ${productInquiryContentId}" id="${productInquiryContentId}" style="display: none;">
                    <form id="password-form-${index}" data-index="${index}">
                        <input type="hidden" id="id-${index}" value="${productInquiry.id != null ? productInquiry.id : ''}">
                        <span>패스워드: <input type="password" name="password" id="password-${index}" class="input-password" autocomplete="new-password"></span>
                        <button type="submit" style="border: 1px solid black; margin-left: 1rem">입력</button>
                    </form>
                </td>
            `;
        } else {
            row1.innerHTML = `
                <td colspan="5" class="productInquiry-content ${productInquiryContentId}" id="${productInquiryContentId}" style="display: none;">
                    ${productInquiry.content}
                </td>
            `;
            const boardId = `${productInquiry.id}`;
            axios.get('/ProductInquiryBoardComment', {
                params: {
                    id: Number(boardId) // id를 숫자 타입으로 변환하여 전달
                }
            })
            .then(function(response) {
                response.data.list.forEach((comment) => {
                    row1.insertAdjacentHTML('afterend',`
                        <tr class="${productInquiryContentId}" style="display: none;">
                            <td>관리자</td>
                            <td>-</td>
                            <td>
                                <span>제목: ${comment.title}</span>
                                <p>내용: ${comment.content}</p>
                            </td>
                            <td>${comment.regDate}</td>
                        </tr>
                    `);
                });
            })
            .catch(function(error) {
                alert("댓글조회 실패");
            });
        }

        productInquiryList.appendChild(row1);

        // 폼의 submit 이벤트 리스너를 동적으로 추가
        if (productInquiry.isLocked === 'Y') {
            const passwordForm = document.getElementById(`password-form-${index}`);
            passwordForm.addEventListener('submit', function(event) {
                event.preventDefault(); // 기본 폼 제출 동작 방지
                submitPassword(index);
            });
        }
    });
}

function submitPassword(index) {
    const passwordInput = document.getElementById(`password-${index}`);
    const idInput = document.getElementById(`id-${index}`).value;
    const password = passwordInput.value;

    console.log(password);

    axios.post('/productInquiryBoard/passwordCheck', {
        id: idInput,
        password: password
    })
    .then(function(response) {
        if (response.data.success) {
            const content = document.getElementById(`inquiry-row-${index}`);
            const productInquiryContentId = `productInquiry-content-${index}`;

            content.innerHTML = `
               <td colspan="5" class="productInquiry-content ${productInquiryContentId}" id="${productInquiryContentId}" style="display: '';">
                    ${response.data.result.content}
               </td>
            `;

            const boardId = idInput;
            console.log(boardId);
            axios.get('/ProductInquiryBoardComment', {
                params: {
                    id: Number(boardId) // id를 숫자 타입으로 변환하여 전달
                }
            })
            .then(function(response) {
                response.data.list.forEach((comment) => {
                    content.insertAdjacentHTML('afterend',`
                        <tr class="${productInquiryContentId}" style="display: '';">
                            <td>관리자</td>
                            <td>-</td>
                            <td>
                                <span>${comment.title}</span>
                                <p>${comment.content}</p>
                            </td>
                            <td>${comment.regDate}</td>
                        </tr>
                    `);
                });
            })
            .catch(function(error) {
                alert("댓글조회 실패");
            });
        } else {
            alert('비밀번호가 틀립니다.');
        }
    })
    .catch(function(error) {
        console.error('서버 응답 에러:', error);
        alert('서버 응답 에러: ' + error.message);
    });
}

function updatePagination2(pageDto) {
    const pagination = document.getElementById('pagination2');
    pagination.innerHTML = '';

    const ul = document.createElement('ul');

    if (pageDto.prev) {
        const prevLi = document.createElement('li');
        const prevLink = document.createElement('a');
        prevLink.href = '#';
        prevLink.textContent = '이전';
        prevLink.onclick = (e) => {
            e.preventDefault();
            loadProductInquiry(currentPage2 - 1);
        };
        prevLi.appendChild(prevLink);
        ul.appendChild(prevLi);
    }

    for (let pageNumber = pageDto.startPage; pageNumber <= pageDto.endPage; pageNumber++) {
        const pageLi = document.createElement('li');
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.textContent = pageNumber;
        if (pageNumber === currentPage2) {
            pageLi.classList.add('active');
        }
        pageLink.onclick = (e) => {
            e.preventDefault();
            loadProductInquiry(pageNumber);
        };
        pageLi.appendChild(pageLink);
        ul.appendChild(pageLi);
    }

    if (pageDto.next) {
        const nextLi = document.createElement('li');
        const nextLink = document.createElement('a');
        nextLink.href = '#';
        nextLink.textContent = '다음';
        nextLink.onclick = (e) => {
            e.preventDefault();
            loadProductInquiry(currentPage2 + 1);
        };
        nextLi.appendChild(nextLink);
        ul.appendChild(nextLi);
    }

    pagination.appendChild(ul);
}

function displayComments(comments) {

}
