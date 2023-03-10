<%@page import="java.util.*"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<%@ include file="includes/header.jsp"%>
  <div class="wrap">
	<section class="app-content">
		<div class="row">		
			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 class="m-b-lg">탈퇴회원관리</h4>
					<p class="m-b-lg docs">
						탈퇴된 회원 목록입니다. 1년간 로그인이 없을시 틸퇴회원 또는 휴먼계정으로 변환하셔야합니다.
					</p>
					<form>
						<div style="text-align: right; margin-botton:1rem">
						<input type="text" name="keyword"><button>검색</button>
						</div>
					</form>
					<div class="table-responsive">
						<table class="table">
							<tr>
								<th>#순번</th>
								<th>아이디</th>
								<th>회원이름</th>
								<th>이메일</th>
								<th>연락처</th>
								<th>생년월일</th>
								<th>성별</th>
								<th>가입일자</th>
								<th>관리</th>
							</tr>
<c:set value="1" var="num"/>
<c:forEach var="data" items="${list}">	
							<tr>													
								<td><c:out value="${num}"/><%//=num++%></td>
								<td><c:out value="${data.mb_id}"/><%//=data.getMb_id() %></td>
							 	<td><c:out value="${data.mb_name}"/><%//=data.getMb_name() %></td>
								<td><c:out value="${data.mb_email}"/><%//=data.getMb_email() %></td>
								<td><c:out value="${data.mb_phone}"/><%//=data.getMb_phone() %></td>
								<td><c:out value="${data.mb_birth}"/><%//=data.getMb_birth() %></td>
								<td><c:out value="${data.mb_gender}"/><%//=data.getMb_gender() %></td>
								<td><fmt:formatDate value="${data.mb_joindate}" pattern="yyyy-MM-dd" />  <%//=data.getMb_joindate()%></td>
								<td><button data-mb_id="${data.mb_id}<%//=data.getMb_id() %>" class="btn">복구</button></td>
							</tr>		
<c:set value="${num + 1}" var="num"/>												
</c:forEach>
<c:if test="${num eq 1}">
							<tr>
								<td colspan="9">탈퇴한 회원이 없습니다.</td>															
							</tr>	
</c:if>																		
						</table>
					</div>
				</div><!-- .widget -->
			</div><!-- END column -->	
	
		</div><!-- .row -->
	</section><!-- #dash-content -->
</div><!-- .wrap -->
<script>
$(document).ready(function(){
	$('.btn').on("click",function(){
		let mb_id=$(this).data('mb_id');
		let superEle = $(this).parent().parent(); //tr
		
		
		if(confirm('정말 복구?')){
			   // ajax 통신
	        $.ajax({
	            type : "POST",            // HTTP method type(GET, POST) 형식이다.
	            url : "../ajax/ajax.memberOutAct.jsp",      // 컨트롤러에서 대기중인 URL 주소이다.
	            data : {mb_id:mb_id},            // Json 형식의 데이터이다. 변수명 : 변수값
	            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
	                // 응답코드 > 0000
	               if(res='Success'){
	            		 //  location.reload();
		            	superEle.remove(); 
		           }
	            },
	            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	            	console.log("통신 실패.")
	            }
	        });				
		}
		//console.log("[button클릭]" +mb_id);
	})
});
</script>
 <%@ include file="includes/footer.jsp"%>