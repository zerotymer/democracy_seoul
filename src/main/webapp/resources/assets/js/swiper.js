/**
 * 
 */

$(document).ready(function(){
	//swiper
	var swiper = new Swiper(".mySwiper", {
	    slidesPerView: 3,
	    spaceBetween: 30,
	    slidesPerGroup: 3,
	    loop: true,
	    loopFillGroupWithBlank: true,
	    navigation: {
	      nextEl: ".swiper-button-next",
	      prevEl: ".swiper-button-prev"
	   }
	});
});
