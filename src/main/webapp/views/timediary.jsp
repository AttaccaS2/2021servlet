<%@page import="model.PagingDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="includes/header.jsp"%>

  <div class="wrap">
		<div class="col-md-12">
				<div class="widget p-lg">
					<h4 class="m-b-lg">방명록</h4>					

	  	        <div class="form-group">
	            <c:forEach var="guestbook" items="${list}">
	                <div class="form-group">   
                    <div><p>${guestbook.tbo_content}</p></div>
                    <div>${guestbook.tbo_datetime}</div>
               		</div>
           		</c:forEach>
       			</div>


        <form method="post" action="">
            <textarea class="form-control" name="tbo_content" cols="5" rows="3"></textarea><br>
			<section class="app-content">
				<div class="row">
						<div class="col-md-12">
							<div class="form-group"></div>						
							<div class="mail-toolbar m-b-lg  pull-left">										
								<div class="btn-group" role="group">
									<a href="?p=${paging.p-1}" class="btn btn-default <c:if test="${paging.p eq 1}">disabled</c:if>">
									<i class="fa fa-chevron-left"></i></a>
									<a href="?p=${paging.p+1}" class="btn btn-default <c:if test="${paging.p eq paging.totalPage}">disabled</c:if> ">
									<i class="fa fa-chevron-right"></i></a>
								</div>							
								<div class="btn-group" role="group">
									<button id="btn" type="submit" class="btn btn-default">글쓰기</button>
								</div>								
							</div>
						</div>
				</div>
			</section><!-- #dash-content -->
		</form>
		
			</div>
	</div>
</div><!-- .wrap -->	


<%@ include file="includes/footer.jsp"%>