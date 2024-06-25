document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('review-submit');
    const imageInput = document.getElementById('image');

    submitButton.addEventListener('click', function (event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 폼 데이터 가져오기
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        const rating = document.getElementById('rating').value;
        const image = imageInput.files[0];
        const oId = submitButton.getAttribute('data-oid');
        const pId = submitButton.getAttribute('data-pid');

        // 이미지 유효성 검사
        if (image && !image.type.startsWith('image/')) {
            alert('이미지 파일만 업로드할 수 있습니다.');
            return;
        }

        if (image) {
            // 이미지 리사이즈
            resizeImage(image, 800, 600, function (resizedFile) {
                uploadFormWithImage(title, content, rating, resizedFile, oId, pId);
            });
        } else {
            // 이미지가 없는 경우 그대로 업로드
            uploadFormWithImage(title, content, rating, null, oId, pId);
        }
    });

    function resizeImage(file, width, height, callback) {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (event) {
            const img = new Image();
            img.src = event.target.result;
            img.onload = function () {
                const canvas = document.createElement('canvas');
                canvas.width = width;
                canvas.height = height;
                const ctx = canvas.getContext('2d');
                ctx.drawImage(img, 0, 0, width, height);
                canvas.toBlob(function (blob) {
                    const resizedFile = new File([blob], file.name, {
                        type: file.type,
                        lastModified: Date.now()
                    });
                    callback(resizedFile);
                }, file.type, 1);
            }
        }
    }

    function uploadFormWithImage(title, content, rating, imageFile, oId, pId) {
        const formData = new FormData();
        formData.append('title', title);
        formData.append('content', content);
        formData.append('rating', rating);
        formData.append('oId', oId);
        formData.append('pId', pId);
        if (imageFile) {
            formData.append('image', imageFile);
        }

        // axios를 사용하여 POST 요청 보내기
        axios.post('/productReview', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
        .then(function (response) {
            // 요청이 성공했을 때의 처리
            if (response.data.success) {
                alert("리뷰 등록에 성공하였습니다.");
                window.location.href = '/myProductReviewBoardList'; // 내 리뷰 목록 페이지로 이동
            } else {
                alert("리뷰 등록에 실패하였습니다. " + response.data.msg);
            }
        })
        .catch(function (error) {
            // 요청이 실패했을 때의 처리
            console.error('There was an error!', error);
            alert('리뷰 등록에 실패했습니다. 다시 시도해 주세요.');
        });
    }
});
