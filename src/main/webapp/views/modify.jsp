<%@page import="model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>    
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
    
<%
//BoardVO view =(BoardVO) request.getAttribute("view");
%>       
<%@ include file="includes/header.jsp"%>

			<div class="wrap">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">글수정</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body">
						<div class="m-b-lg">
							<small>
								<!-- 설명 -->
							</small>
						</div>
						<form method="post" class="form-horizontal" action="">
						<input type="hidden" id="bo_num" name="bo_num" value="${view.bo_num}<%//=view.getBo_num() %>">
						
							<div class="form-group">
								<label for="exampleTextInput1" class="col-sm-3 control-label">카테고리:</label>
								<div class="col-sm-9">
									<select id="bo_category" name="bo_category" class="form-control">
									<option value="html" 
									<c:if test="${'html' eq view.bo_category}">
									selected
									</c:if>
									<%//="html".equals(view.getBo_category())?"selected":""  %> >HTML</option>
									
									<option value="css" 
									<c:if test="${'css' eq view.bo_category}">
									selected
									</c:if>									
									<%//="css".equals(view.getBo_category())?"selected":""  %> >CSS</option>
									
									<option value="js" 
									<c:if test="${'js' eq view.bo_category}">
									selected
									</c:if>	
									<%//="js".equals(view.getBo_category())?"selected":""  %> >JS</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="exampleTextInput1" class="col-sm-3 control-label">제목:</label>
								<div class="col-sm-9">
									<input type="text" id="bo_title" name="bo_title" class="form-control" id="exampleTextInput1" value="${view.bo_title}<%//=view.getBo_title() %>" placeholder="제목을 입력하시오">
								</div>
							</div>
							<div class="form-group">
								<label for="textarea1" class="col-sm-3 control-label">내용:</label>
								<div class="col-sm-9">
<textarea class="form-control" name="bo_content" id="bo_content" placeholder="내용을 입력하시오">${view.bo_content}<%//=view.getBo_content() %></textarea>
								
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-2 col-sm-offset-9">
									<button id="btn" type="submit" class="btn btn-success">글수정</button>
								</div>
							</div>
						</form>
					</div><!-- .widget-body -->
				</div><!-- .widget -->
			</div><!-- END column -->

<script>
$(document).ready(function(){
	$('#btn').on("click", function(){
			
		let bo_num = ${view.bo_num}<%//=view.getBo_num()%>;
		let bo_category = $('#bo_category').val();
		let bo_title = $('#bo_title').val().trim();
		let bo_content = $('#bo_content').val().trim();
	
		if(bo_title == ''){
			alert('제목입력');
			$('#bo_title').focus();
		}else if(bo_content == '' ){
			alert('내용입력해');
			$('#bo_content').focus();	
		}else{
			$('form').sumbmit();
		}
			
		
		
	});	
});		
</script>
<%@ include file="includes/footer.jsp"%>
