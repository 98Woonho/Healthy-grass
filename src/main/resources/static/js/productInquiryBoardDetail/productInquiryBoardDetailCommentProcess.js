document.addEventListener("DOMContentLoaded", function() {
    const boardId = document.querySelector("#boardId").textContent;
    fetchComments(boardId);
});

function fetchComments(boardId) {
    fetch(`/ProductInquiryBoardComment?id=${boardId}`)
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                displayComments(data.list);
            } else {
                displayError('댓글 정보를 불러오는 데 실패했습니다. 다시 시도해 주세요.');
            }
        })
        .catch(error => {
            displayError('서버로의 요청에 실패했습니다.');
        });
}

function displayComments(comments) {
    const commentsSection = document.getElementById('comments-section');
    comments.forEach(comment => {
        const commentElement = document.createElement('div');
        commentElement.classList.add('comment');
        commentElement.innerHTML = `
            <p><span>--------------------------------------------------------</span></p>
            <p>제목: <span>${comment.title}</span></p>
            <p>내용: <span>${comment.content}</span></p>
            <p>작성일: <span>${comment.regDate}</span></p>
            <p>수정일: <span>${comment.updateDate}</span></p>
            <p><span>--------------------------------------------------------</span></p>
        `;
        commentsSection.appendChild(commentElement);
    });
}

function displayError(message) {
    const commentsSection = document.getElementById('comments-section');
    const errorElement = document.createElement('p');
    errorElement.classList.add('error-message');
    errorElement.textContent = message;
    commentsSection.appendChild(errorElement);
}