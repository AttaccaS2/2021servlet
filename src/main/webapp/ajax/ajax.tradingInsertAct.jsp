<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String url= "jdbc:mysql://localhost:3306/bigdata?serverTimezone=Asia/Seoul";
String user= "root";
String password= "bigdata";

StringBuffer qry= new StringBuffer();
qry.append(" INSERT INTO big_tradingdetail (trad_num, trad_refnum, trad_tradingDate,  ");
qry.append("  trad_subject, trad_standard, trad_quantity, trad_unitPrice, trad_supplyPrice, trad_taxAmount, trad_note)  ");
qry.append(" VALUES (null,?,?,?,?,?,?,?,?,? ) ");
String sql = qry.toString();


Connection conn = null;
PreparedStatement stmt = null; 

String ajaxMessage = "Fail";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	
	stmt = conn.prepareStatement(sql);
	
	stmt.setInt(1, Integer.parseInt(request.getParameter("trad_refnum")) );
	stmt.setString(2,request.getParameter("trad_tradingDate"));
	stmt.setString(3, request.getParameter("trad_subject"));
	stmt.setString(4, request.getParameter("trad_standard"));
	stmt.setInt(5, Integer.parseInt(request.getParameter("trad_quantity")));
	stmt.setInt(6, Integer.parseInt(request.getParameter("trad_unitPrice")));
	stmt.setInt(7, Integer.parseInt(request.getParameter("trad_supplyPrice")));	
	stmt.setInt(8, Integer.parseInt(request.getParameter("trad_taxAmount")));
	stmt.setString(9, request.getParameter("trad_note"));
	
	int res = stmt.executeUpdate();
	
	if(res>0){
		ajaxMessage = "Success";
	}	
} catch(Exception e){
		
}finally {
		try{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			
		}
	}
out.print(sql);
out.print(ajaxMessage);
%>