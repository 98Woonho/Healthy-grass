document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault(); // 기본 폼 제출 방지

    // 폼 데이터 가져오기
    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    const image = document.getElementById('image').files[0];

    // FormData 객체 생성
    const formData = new FormData();
    formData.append('title', title);
    formData.append('content', content);
    if (image) {
        formData.append('image', image);
    }

    // axios를 사용하여 POST 요청 보내기
    axios.post('/customerInquiry', formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    })
    .then(function (response) {
        // 요청이 성공했을 때의 처리
        if (response.data.success) {
            alert(response.data.msg);
            window.location.href = '/customerInquiryBoardList'; // 문의 목록 페이지로 이동
        } else {
            alert(response.data.msg);
        }
    })
    .catch(function (error) {
        // 요청이 실패했을 때의 처리
        console.error('There was an error!', error);
        alert('문의 등록에 실패했습니다. 다시 시도해 주세요.');
    });
});