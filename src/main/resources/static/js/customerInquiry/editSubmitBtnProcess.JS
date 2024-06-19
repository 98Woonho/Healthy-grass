document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('submit');
    const imageInput = document.getElementById('image');

    submitButton.addEventListener('click', function (event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 폼 데이터 가져오기
        const form = document.getElementById('editForm');
        const formData = new FormData(form);

        // 이미지 유효성 검사
        const file = imageInput.files[0];
        if (file && !file.type.startsWith('image/')) {
            alert('이미지 파일만 업로드할 수 있습니다.');
            return;
        }

        if (file) {
            // 이미지 리사이즈
            resizeImage(file, 800, 600, function (resizedFile) {
                formData.set('image', resizedFile);
                uploadForm(formData);
            });
        } else {
            // 이미지가 없는 경우 그대로 업로드
            uploadForm(formData);
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

    function uploadForm(formData) {
        axios.put('/customerInquiry', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
        .then(function (response) {
            // 요청이 성공했을 때의 처리
            if (response.data.success) {
                alert(response.data.msg);
                window.location.href = '/customerInquiryBoardList'; // 수정 후 목록 페이지로 이동
            } else {
                alert(response.data.msg);
            }
        })
        .catch(function (error) {
            // 요청이 실패했을 때의 처리
            console.error('There was an error!', error);
            alert('문의 수정에 실패했습니다. 다시 시도해 주세요.');
        });
    }
});
