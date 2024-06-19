document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();

    var title = document.getElementById('title').value.trim();
    var content = document.getElementById('content').value.trim();

    var errorMessages = [];

    // Check title
    if (title.length === 0) {
        errorMessages.push('제목을 입력해 주세요.');
    } else if (title.length > 80) {
        errorMessages.push('제목은 80자를 초과할 수 없습니다.');
    }

    // Check content
    if (content.length === 0) {
        errorMessages.push('내용을 입력해 주세요.');
    }

    // If there are errors, show errors and stop submission
    if (errorMessages.length > 0) {
        alert(errorMessages.join('\n'));
        return;
    }

});
