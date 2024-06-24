document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('submit');
    const deleteImageButton = document.getElementById('delete-image-btn');
    const editForm = document.getElementById('edit-form');

    submitButton.addEventListener('click', function (event) {
        event.preventDefault(); // 기본 폼 제출 방지

        const reviewId = this.getAttribute('data-id');
        const formData = new FormData(editForm);

        axios.put(`/productReview`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
        .then(function (response) {
            if (response.data.success) {
                alert('리뷰가 성공적으로 수정되었습니다.');
                window.location.href = `/productReview/detail?id=${reviewId}`; // 리뷰 상세 페이지로 이동
            } else {
                alert('리뷰 수정에 실패했습니다: ' + response.data.msg);
            }
        })
        .catch(function (error) {
            console.error('There was an error!', error);
            alert('리뷰 수정 중 오류가 발생하였습니다.');
        });
    });

    deleteImageButton.addEventListener('click', function () {
        const reviewId = this.getAttribute('data-id');

        if (confirm('정말로 이미지를 삭제하시겠습니까?')) {
            axios.delete(`/productReview/${reviewId}/image`)
                .then(function (response) {
                    if (response.data.success) {
                        alert('이미지가 성공적으로 삭제되었습니다.');
                        location.reload(); // 페이지를 새로고침하여 상태를 업데이트합니다.
                    } else {
                        alert('이미지 삭제에 실패했습니다: ' + response.data.msg);
                    }
                })
                .catch(function (error) {
                    console.error('There was an error!', error);
                    alert('이미지 삭제 중 오류가 발생하였습니다.');
                });
        }
    });
});
