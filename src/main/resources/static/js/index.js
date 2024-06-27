//----------------------------------------------
// new Swiper(선택자, 옵션)
//----------------------------------------------
new Swiper(".notification .swiper", {
  direction: "vertical",
  autoplay: true,
  loop: true,
    // nav 화살표 출력 시 추가
  navigation: {
            prevEl: '.banner .swiper-button-prev',
            nextEl: '.banner .swiper-button-next',
  },
});

//----------------------------------------------
// Section2.Banner
//----------------------------------------------
const prdRatingEls = document.querySelectorAll('.item-list .prd-info>ul>li.prd-review');
prdRatingEls.forEach(el=>{
    let data =  el.innerHTML;
    data.replace("리뷰 수",'<span class="material-symbols-outlined" style="font-size:.7rem">rate_review</span> ')

})


