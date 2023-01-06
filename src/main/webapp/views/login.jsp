<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<c:if test="${! empty sessionScope.sess_id} ">
<c:redirect url="Main">
</c:redirect>
</c:if>

<%@ include file="includes/loginHeader.jsp"%>

<div class="simple-page-form animated flipInY" id="login-form">
	<h4 class="form-title m-b-xl text-center">Sign In With Your Infinity Account</h4>
	<form method="post" action="">
		<div class="form-group">
			<input id="mb_id" type="text" name="mb_id" class="form-control" placeholder="아이디">
		</div>

		<div class="form-group">
			<input id="mb_pw" type="password" name="mb_pw" class="form-control" placeholder="비밀번호">
		</div>

		<div class="form-group m-b-xl">
			<div class="checkbox checkbox-primary">
				<input type="checkbox" id="keep_me_logged_in" /> <label
					for="keep_me_logged_in">Keep me signed in</label>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" value="SING IN">
	</form>
</div>
<!-- #login-form -->


    <div class="simple-page-footer">
	<p><a href="password-forget">FORGOT YOUR PASSWORD ?</a></p>
	<p>
		<small>Don't have an account ?</small>
		<a href="Signup">CREATE AN ACCOUNT</a>
	</p>
</div><!-- .simple-page-footer -->

<script>
$(document).ready(function(){
	$("input[type=submit]").on("click",function(){	
	//	e.preventDefault(); 	/* a태그, 폼 이벤트를 없애는 매소드임 void(0)처럼 */
		console.log("클릭");
		let mb_id = $('#mb_id').val().trim(); 
		let mb_pw = $('#mb_pw').val().trim(); 
		
		if(mb_id==''){
			alert('아이디 6~16글자 입력하셔야합나디');
			
		} else if(mb_id.length < 6 || mb_id.length > 16){
			alert('아이디 6~16글자 입력하셔야합나디');
			$('#mb_id').css("color","red");  //조건에서 어긋나면 빨간색으로 나와요
		} else if(mb_pw==''){
			alert('비밀번호 6~16글자 입력하셔야합나디');
		} else if(mb_pw.length < 6 || mb_pw.length > 16){
			alert('비밀번호 6~16글자 입력하셔야합나디');
		} else{

			$('form').sumbit();
			
			
		}

	});
});
</script>

<%@ include file="includes/loginFooter.jsp"%>