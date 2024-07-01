let currentPage = 1;

document.addEventListener('DOMContentLoaded', function() {
    loadReviews(currentPage);
});

function loadReviews(page) {
    if (page < 1) return; // 페이지 번호가 1보다 작으면 요청하지 않음

    const pId = document.getElementById('productId').value;

    axios.post('/productReviewBoardListAPI', {
        criteria: {
            pageno: page,
            amount: 10
        },
        pId: pId
    })
    .then(function(response) {
        if (response.data.success) {
            currentPage = page;
            displayReviews(response.data.list);
            updatePagination(response.data.pageDto);
        } else {
            alert('리뷰를 불러오는 데 실패했습니다.');
        }
    })
    .catch(function(error) {
        console.error('서버 응답 에러:', error);
        alert('서버 응답 에러: ' + error.message);
    });
}

function displayReviews(reviews) {
    const reviewList = document.getElementById('review-list');
    reviewList.innerHTML = ''; // 기존 리뷰 목록 초기화

    reviews.forEach((review, index) => {
        // 각 리뷰 제목에 대한 고유 ID 생성
        const reviewContentId = `review-content-${index}`;

        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${review.Uid}</td>
            <td>${review.title}</td>
            <td>${review.regDate}</td>
            <td>${review.rating}</td>
        `;
        //tr 클릭하면 보이게 토글 설정
        row.onclick = () => toggleReviewContent(reviewContentId);

        reviewList.appendChild(row);

        const row1 = document.createElement('tr');
        let imgHtml = '';

        if (review.imgPath) {
            imgHtml = `
                <div style="text-align: center">
                    <img style="max-width: 500px; max-height: 500px; margin-bottom: 1rem;" src="${review.imgPath}/${review.imgName}" alt="리뷰 이미지" />
                </div>
            `;
        }

        row1.innerHTML = `
            <td colspan="5" class="review-content" id="${reviewContentId}" style="display: none;">
                ${imgHtml}
                <div style="margin-right: 130px; margin-left: 130px; text-align: left">${review.content}</div>
            </td>
        `;
        reviewList.appendChild(row1);
    });
}

function updatePagination(pageDto) {
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    const ul = document.createElement('ul');

    if (pageDto.prev) {
        const prevLi = document.createElement('li');
        const prevLink = document.createElement('a');
        prevLink.href = '#';
        prevLink.textContent = '이전';
        prevLink.onclick = (e) => {
            e.preventDefault();
            loadReviews(currentPage - 1);
        };
        prevLi.appendChild(prevLink);
        ul.appendChild(prevLi);
    }

    for (let pageNumber = pageDto.startPage; pageNumber <= pageDto.endPage; pageNumber++) {
        const pageLi = document.createElement('li');
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.textContent = pageNumber;
        if (pageNumber === currentPage) {
            pageLi.classList.add('active');
        }
        pageLink.onclick = (e) => {
            e.preventDefault();
            loadReviews(pageNumber);
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
            loadReviews(currentPage + 1);
        };
        nextLi.appendChild(nextLink);
        ul.appendChild(nextLi);
    }

    pagination.appendChild(ul);
}
