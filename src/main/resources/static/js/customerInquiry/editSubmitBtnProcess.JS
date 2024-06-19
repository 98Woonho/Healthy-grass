document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('submit');
    const imageInput = document.getElementById('image');
    const boardIdInput = document.getElementById('id'); // boardId input element

    submitButton.addEventListener('click', function (event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 폼 데이터 가져오기
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        const image = imageInput.files[0];
        const boardId = boardIdInput.value; // boardId 값 가져오기
        const deleteImageInput = document.getElementById('deleteImage');
        const deleteImage = deleteImageInput ? deleteImageInput.checked : false; // deleteImage 값 가져오기

        // 이미지 유효성 검사
        if (image && !image.type.startsWith('image/')) {
            alert('이미지 파일만 업로드할 수 있습니다.');
            return;
        }

        if (image) {
            // 이미지 리사이즈
            resizeImage(image, 800, 600, function (resizedFile) {
                uploadFormWithImage(boardId, title, content, resizedFile, deleteImage);
            });
        } else {
            // 이미지가 없는 경우 그대로 업로드
            uploadFormWithImage(boardId, title, content, null, deleteImage);
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

    function uploadFormWithImage(boardId, title, content, imageFile, deleteImage) {
        const formData = new FormData();
        formData.append('id', boardId); // boardId 추가
        formData.append('title', title);
        formData.append('content', content);
        formData.append('deleteImage', deleteImage); // deleteImage 추가
        if (imageFile) {
            formData.append('image', imageFile);
        }

        // axios를 사용하여 PUT 요청 보내기
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
