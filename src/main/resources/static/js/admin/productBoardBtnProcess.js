document.addEventListener('DOMContentLoaded', function () {
    // 수정 버튼 클릭 이벤트 처리
    document.querySelectorAll('.edit-btn').forEach(button => {
        button.addEventListener('click', function () {
            const productId = this.getAttribute('data-id');
            console.log(productId);
            window.location.href = `/admin/modifyProduct?id=${productId}`;
        });
    });

    // 삭제 버튼 클릭 이벤트 처리
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function () {
            const productId = this.getAttribute('data-id');
            if (confirm('정말로 이 상품을 삭제하시겠습니까?')) {
                axios.delete(`/admin/product?id=${productId}`)
                    .then(response => {
                        alert(response.data);
                        window.location.reload();
                    })
                    .catch(error => {
                        alert('상품 삭제 중 오류가 발생하였습니다.');
                    });
            }
        });
    });
});