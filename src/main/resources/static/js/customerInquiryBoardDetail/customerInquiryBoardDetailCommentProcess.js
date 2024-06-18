document.addEventListener("DOMContentLoaded", function() {
    const boardId = document.querySelector("#boardId").textContent;
    fetchComments(boardId);
});

function fetchComments(boardId) {
    fetch(`/customerInquiryBoardComment?id=${boardId}`)
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                displayComments(data.list);
            } else {
                displayError('댓글 정보를 불러오는 데 실패했습니다. 다시 시도해 주세요.');
            }
        })
        .catch(error => {
            console.error(error);
            displayError('서버로의 요청에 실패했습니다.');
        });
}

function displayComments(comments) {
    const commentsSection = document.getElementById('comments-section');
    commentsSection.innerHTML = ''; // 이전 댓글 초기화


    comments.forEach(comment => {
        const commentElement = document.createElement('div');
        commentElement.classList.add('comment');
        const imgUrl = comment.imgPath ? `${comment.imgPath}/${comment.imgName}` : '';
        commentElement.innerHTML = `
            <div class="comment-header">
                <span class="comment-title">${comment.title}</span>
                <span class="comment-date">${comment.regDate}</span>
            </div>
            <div class="comment-body">
                ${imgUrl ? `<p><img src="${imgUrl}" alt="첨부 이미지" class="comment-image" /></p>` : ''}
                <p>${comment.content}</p>
            </div>
            <div class="comment-footer">
                <span class="comment-update-date">수정일: ${comment.updateDate}</span>
                <button class="delete-comment-btn" data-id="${comment.id}">삭제</button>
            </div>
        `;
        commentsSection.appendChild(commentElement);
    });

    document.querySelectorAll('.delete-comment-btn').forEach(button => {
        button.addEventListener('click', function() {
            const commentId = this.getAttribute('data-id');
            deleteComment(commentId);
        });
    });
}

function deleteComment(commentId) {
    axios.delete(`/customerInquiryBoardComment?id=${commentId}`)
        .then(function (response) {
            if (response.data.success) {
                alert(response.data.msg || '댓글이 성공적으로 삭제되었습니다.');
                window.location.reload(); // 페이지 새로고침
            } else {
                alert(response.data.msg || '댓글 삭제에 실패했습니다.');
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('댓글 삭제에 실패했습니다. 다시 시도해 주세요.');
        });
}

function displayError(message) {
    const commentsSection = document.getElementById('comments-section');
    const errorElement = document.createElement('p');
    errorElement.classList.add('error-message');
    errorElement.textContent = message;
    commentsSection.appendChild(errorElement);
}