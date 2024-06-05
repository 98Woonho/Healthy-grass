function toggleReviewContent(contentId) {
    var content = document.getElementById(contentId);
    if (content.style.display === "none") {
        content.style.display = ""; // 리뷰 내용을 보여줍니다.
    } else {
        content.style.display = "none"; // 리뷰 내용을 숨깁니다.
    }
}