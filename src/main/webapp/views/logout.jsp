<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <c:remove var="sess_id"/>
    <c:remove var="sess_name"/>
    <c:redirect url="Login"></c:redirect>

<%
//session.invalidate(); 
//response.sendRedirect("Login");
%>

