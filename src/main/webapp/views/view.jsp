<%@page import="model.CommentVO"%>
<%@page import="model.BoardVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<%
//BoardVO view =(BoardVO) request.getAttribute("view");
//List<CommentVO> list =(List<CommentVO>) request.getAttribute("list");
%>    
        
<%@ include file="includes/header.jsp"%>

			<div class="wrap">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">글내용보기</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body">
						<div class="m-b-lg">
							<small>
								<!-- 설명 -->
							</small>
						</div>
						<form method="post" class="form-horizontal" action="list.jsp">
				
							<div class="form-group">
								<label for="exampleTextInput1" class="col-sm-3 control-label">제목:</label>
								<div class="col-sm-9">
			${view.bo_title}				<%//=view.getBo_title() %>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleTextInput1" class="col-sm-3 control-label">작성자:</label>
								<div class="col-sm-9">
			${view.bo_mb_name}    <%//=view.getBo_mb_name() %>
								</div>
							</div>						

							<div class="form-group">
								<label for="textarea1" class="col-sm-3 control-label">내용:</label>
								<div class="col-sm-9">
								
			<% pageContext.setAttribute("newLineChar", "\n"); %>
			${fn:replace( view.bo_content, newLineChar, "<br>") } <%//=view.getBo_content().replace("\r\n","<br>") %>			
								</div>
							</div>											
							<div class="form-group">
								<label for="exampleTextInput1" class="col-sm-3 control-label">작성일:</label>
								<div class="col-sm-9">
			${view.bo_inputdate} <%//=view.getBo_inputdate() %>
								</div>
							</div>
		
						<div class="row">
							<div class="col-sm-7">
							</div>
							<div class="col-sm-5">
						
			<c:if test="${sessionScope.sess_id eq view.bo_mb_id }">			
								<a href="Modify?bo_num=${view.bo_num}<%//=view.getBo_num() %>" class="btn btn-success">글수정</a>
								<a href="javascript:void(0);" class="btn btn-success" onclick="del()">글삭제</a>								
	
			</c:if>	
								<a href="List" class="btn btn-success">글목록</a>
							</div>
						</div>
						</form>
											
					</div><!-- .widget-body -->
				</div><!-- .widget -->
			</div><!-- END column -->
			
<form id="sendfrm" method="post" action="deleteAct.jsp">
<input type="hidden" name="bo_num" value="${view.bo_num}<%//=view.getBo_num() %>">
</form>

						<!--댓글시작  -->
				
						<div>					
						<h4 class="widget-title">댓글</h4>						
						<form method="post" action="">
						<input type="hidden" id="com_refnum" name="com_refnum" value="${view.bo_num}<%//=view.getBo_num() %>">
							<div class="form-group">
								<input type="text" id="com_content" name="com_content" class="form-control" required="required">
								<div style="text-align:right;">
								<button id="btn_comment" class="btn btn-default">입력</button>
								</div>
							</div>	
						</form>
					</div>
					
					<!-- 댓글목록 -->
				<div id="commentList">	
			<c:set value="0" var="rowNum"/>
			<c:forEach var="data" items="${list}">				
					<div>
						<div>${data.com_mb_name}<%//=data.getCom_mb_name() %>${data.com_inputdate} <%//=data.getCom_inputdate() %></div>
						<div>${data.com_content}<%//=data.getCom_content() %></div>
					</div>
					<hr>
			<c:set value="${rowNum + 1}" var="rowNum"/>
			</c:forEach>
			
				<c:if test="${rowNum eq 0}">					
					<div>
						<div>등록된 댓글이 없습니다.</div>
					</div>
				</c:if>
				</div>	
					<!-- 댓글목록 끝 -->
						<!-- 댓글 끝 -->

<script>
function del(){
	if(confirm("정말 삭제?")){
	document.getElementById('sendfrm').submit();
	}	
}
</script>

<%@ include file="includes/footer.jsp"%>
