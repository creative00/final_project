<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
//슬라이드 스크립

var slideIndex = 1;
showSlides(slideIndex);



function plusSlides(n) {
  showSlides(slideIndex += n);
}



function currentSlide(n) {
  showSlides(slideIndex = n);

}



function showSlides(n) {

  var i;

  var slides = document.getElementsByClassName("mySlides");

  var dots = document.getElementsByClassName("dot");

  if (n > slides.length) {slideIndex = 1}

  if (n < 1) {slideIndex = slides.length}

  for (i = 0; i < slides.length; i++) {

      slides[i].style.display = "none";

  }

  for (i = 0; i < dots.length; i++) {

      dots[i].className = dots[i].className.replace(" active", "");

  }

  slides[slideIndex-1].style.display = "block";

  dots[slideIndex-1].className += " active";

}
</script>
	<!-- 메인 슬라이드 -->

	<div class="slideshow-container">

		<div class="mySlides fade2">

			<img class="main_slideImg" src="assets/images/1.jpg">

			<div class="text">Caption Text</div>

		</div>



		<div class="mySlides fade2">

			<img class="main_slideImg" src="assets/images/2.jpg">

			<div class="text">Caption Two</div>

		</div>



		<div class="mySlides fade2">

			<img class="main_slideImg" src="assets/images/3.jpg">

			<div class="text">Caption Three</div>

		</div>

		<a class="prev" onclick="plusSlides(-1)">❮</a>

		<a class="next"onclick="plusSlides(1)">❯</a>

	</div>

	<br>



	<div style="text-align: center">

		<span class="dot" onclick="currentSlide(1)"></span> 

		<span class="dot" onclick="currentSlide(2)"></span>

		<span class="dot" onclick="currentSlide(3)"></span>

	</div>

<!-- 메인 슬라이드 End -->



</head>
<body>
	<!-- 메인 슬라이드 Slideshow container  -->

/* Slideshow container */

* {box-sizing:border-box}

body {font-family: Verdana,sans-serif;margin:0}



/* Slideshow container */

.slideshow-container {

	width: 100%;

	height: 300px;

	position: static;

	margin: auto;

	margin-top: 50px;

}



.main_slideImg{

	width: 100%; 

	height: 300px; 

	top : 100px;	

}



/* Next & previous buttons */

.prev, .next {

  cursor: pointer;

  position: absolute;

  text-align : center;

  top: 0;

  top: 20%;

  width: 3%;

  padding: 16px;

  margin-top: -22px;

  color: white;

  font-weight: bold;

  font-size: 18px;

  transition: 0.6s ease;

  border-radius: 0 3px 3px 0;

  z-index: 100;

}



/* Position the "next button" to the right */

.next {

  right: 0;

  border-radius: 3px 0 0 3px;

}



/* On hover, add a black background color with a little bit see-through */

.prev:hover, .next:hover {

  background-color: rgba(0,0,0,0.8);

}



/* Caption text */

.text {

  color: #f2f2f2;

  font-size: 15px;

  padding: 8px 12px;

  position: absolute;

  bottom: 8px;

  width: 100%;

  text-align: center;

}



/* Number text (1/3 etc) */

.numbertext {

  color: #f2f2f2;

  font-size: 12px;

  padding: 8px 12px;

  position: absolute;

  top: 0;

}



/* The dots/bullets/indicators */

.dot {

  cursor:pointer;

  height: 13px;

  width: 13px;

  margin: 0 2px;

  background-color: #bbb;

  border-radius: 50%;

  display: inline-block;

  transition: background-color 0.6s ease;

}



.active, .dot:hover {

  background-color: #717171;

}



/* Fading animation */

.fade2 {

  -webkit-animation-name: fade;

  -webkit-animation-duration: 0.5s;

  animation-name: fade;

  animation-duration: 5s;

}



@-webkit-keyframes fade2 {

  from {opacity: .4}

  to {opacity: 1}

}



@keyframes fade2 {

  from {opacity: .4}

  to {opacity: 1}

}



/* On smaller screens, decrease text size */

@media only screen and (max-width: 300px) {

  .slprev, .slnext,.text {font-size: 11px}
</body>
</html>