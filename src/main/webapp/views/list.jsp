<%@page import="model.PagingDTO"%>
<%@page import="model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%
//List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
//PagingDTO paging = (PagingDTO)request.getAttribute("paging");
%>    
<%@ include file="includes/header.jsp"%>

  <div class="wrap">
	<section class="app-content">
		<div class="row">
				<div class="col-md-12">
				<%//=paging.getP() %><%//= paging.getTotalPage()%>
				${paging.p} / ${paging.totalPage}
					<div class="form-group">					
						<div>
							<select id="bo_category" name="bo_category">
							<option value="">전체</option>
							<option value="html"  <%="html".equals(request.getParameter("cate"))? "selected" : ""  %> >HTML</option>									
							<option value="css"  <%="css".equals(request.getParameter("cate"))? "selected" : ""  %>>CSS</option>
							<option value="js"  <%="js".equals(request.getParameter("cate"))? "selected" : ""  %>>JS</option>
							</select>
						</div>
					</div>
					
					<div class="mail-toolbar m-b-lg  pull-right">										
						<div class="btn-group" role="group">
							<a href="List?p=${paging.p-1}<%//=paging.getP()-1 %>" class="btn btn-default <c:if test="${paging.p eq 1}">disabled</c:if>">
							<i class="fa fa-chevron-left"></i></a>
						<!-- 디스에이블로 첫페이지일때 앞페이지 못넘기게 함-->
							<a href="List?p=${paging.p+1}" class="btn btn-default <c:if test="${paging.p eq paging.totalPage}">disabled</c:if> ">
							<i class="fa fa-chevron-right"></i></a>
						</div>
						
						<div class="btn-group" role="group">
							<a href="Write" class="btn btn-default">글쓰기</a>
						</div>
						
					</div>
				</div>
		</div>
	</section><!-- #dash-content -->
</div><!-- .wrap -->
 
			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 class="m-b-lg">게시판</h4>
					<div class="table-responsive">
						<table class="table">
			
			<c:set value="false" var="dataChk"/>
			<c:set value="${paging.total - ((paging.p-1)*paging.pageRow)}" var="rowNum"/>			
			<c:forEach var="data" items="${list}">	
						
				<tr>
					<td>${rowNum} <%//=rowNum-- %> <a href="View?bo_num=${data.bo_num}<%//=data.getBo_num() %>">${data.bo_title}<%//=data.getBo_title()%></a></td>
					<td align="right">${data.bo_inputdate}<%//=data.getBo_inputdate()  %></td>
				</tr>	
			<c:set value="${rowNum - 1}" var="rowNum"/>	
			<c:set value="true" var="dataChk"/>				
			</c:forEach>						
			<c:if test="${dataChk eq 'false'}">			
							<tr>
								<td colspan="2">등록된 글이 없습니다..</td>
							</tr>	
			</c:if>							
						</table>
					</div>
				</div><!-- .widget -->
			</div><!-- END column -->
<script>
$(document).ready(function(){
	$("#bo_category").on("change",function(){
		console.log("선택카테"+$("#bo_category").val());
		if($("#bo_category").val() == '' ){
			location.href="?";
			
		}else {
			location.href="?cate="+$("#bo_category").val();
			
		}
	});
	
});
</script>
<%@ include file="includes/footer.jsp"%>