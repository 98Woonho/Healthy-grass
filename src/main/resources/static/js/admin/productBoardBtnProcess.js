document.addEventListener('DOMContentLoaded', function () {
    // 수정 버튼 클릭 이벤트 처리
    document.querySelectorAll('.edit-btn').forEach(button => {
        button.addEventListener('click', function () {
            const productId = this.getAttribute('data-id');
            window.location.href = `/admin/productEdit?id=${productId}`;
        });
    });

    // 삭제 버튼 클릭 이벤트 처리
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function () {
            const productId = this.getAttribute('data-id');
            if (confirm('정말로 이 상품을 삭제하시겠습니까?')) {
                axios.delete(`/admin/product?id=${productId}`)
                    .then(response => {
                        if (response.data.success) {
                            alert(response.data.msg);
                            window.location.reload();
                        } else {
                            alert(response.data.msg);
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('상품 삭제 중 오류가 발생하였습니다.');
                    });
            }
        });
    });
});