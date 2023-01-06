<%@page import="model.TradingVO"%>
<%@page import="model.PagingDTO"%>
<%@page import="model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//List<TradingVO> list = (List<TradingVO>)request.getAttribute("list");
//PagingDTO paging = (PagingDTO)request.getAttribute("paging");
%>    
<%@ include file="includes/header.jsp"%>

  <div class="wrap">
	<section class="app-content">
		<div class="row">
				<div class="col-md-12">
				<%//=paging.getP() %><%//= paging.getTotalPage()%>
				${paging.p} / ${paging.totalPage}
					<div class="mail-toolbar m-b-lg  pull-right">										
						<div class="btn-group" role="group">
							<a href="?p=${paging.p-1}<%//=paging.getP()-1 %>" class="btn btn-default <c:if test="${paging.p eq 1}">disabled</c:if>"><i class="fa fa-chevron-left"></i></a>
						<!-- 디스에이블로 첫페이지일때 앞페이지 못넘기게 함-->
							<a href="?p=${paging.p+1}<%//=paging.getP()+1 %>" class="btn btn-default <c:if test="${paging.p eq paging.totalPage}">disabled</c:if>"><i class="fa fa-chevron-right"></i></a>
						</div>
						
						<div class="btn-group" role="group">
							<a href="TradingWrite" class="btn btn-default">글쓰기</a>
						</div>
						
					</div>
				</div>
		</div>
	</section><!-- #dash-content -->
</div><!-- .wrap -->
 
			<div class="col-md-12">
				<div class="widget p-lg">
					<h4 class="m-b-lg">거래명세서</h4>
					<p class="m-b-lg docs">
						설명
					</p>
					<div class="table-responsive">
						<table class="table">
			
			<c:set value="false" var="dataChk"/>
			<c:set value="${paging.total - ((paging.p-1)*paging.pageRow)}" var="rowNum"/>			
			<c:forEach var="data" items="${list}">								
				<tr>
					<td>${rowNum}<%//=rowNum-- %> 
					<a href="TradingView?tra_num=${data.tra_num}<%//=data.getTra_num() %>">${data.tra_account}<%//=data.getTra_account()%></a></td>
					<td align="right">${data.tra_inputdate}<%//=data.getTra_inputdate()  %></td>
				</tr>	
			<c:set value="${rowNum - 1}" var="rowNum"/>						
			</c:forEach>	
	
			<c:set value="true" var="dataChk"/>							
			<c:if test="${dataChk eq 'false'}">				
							<tr>
								<td colspan="2">등록된 글이 없습니다..</td>
							</tr>	
			</c:if>							
						</table>
					</div>
				</div><!-- .widget -->
			</div><!-- END column -->

<%@ include file="includes/footer.jsp"%>