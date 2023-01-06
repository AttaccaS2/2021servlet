package mapper;

import java.sql.*;
import java.util.*;

import common.DBUtil;
import model.BoardVO;
import model.PagingDTO;

public class BoardMapper {

	public void create(BoardVO vo) {

		StringBuffer qry= new StringBuffer();
		qry.append(" insert into big_board (bo_num, bo_category, bo_title, bo_content, bo_mb_id, bo_mb_name, bo_hit, bo_inputdate, bo_ip)  ");
		qry.append(" VALUES (null,?,?,?,?,?,0,now(),?)   ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null; 
	
		try{
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, vo.getBo_category());
			stmt.setString(2, vo.getBo_title());
			stmt.setString(3, vo.getBo_content());
			stmt.setString(4, vo.getBo_mb_id());			
			stmt.setString(5, vo.getBo_mb_name());
			stmt.setString(6, vo.getBo_ip()); //ip주소 가져오는 코드

			int res=stmt.executeUpdate();
			if(res>0){
			}	
			
		}	catch(Exception e){
			
			}finally{
				 DBUtil.setClose(null, stmt, conn);
			}
	}
	
	public void update(BoardVO vo) {
		StringBuffer qry= new StringBuffer();
		qry.append(" UPDATE big_board SET bo_category=?, bo_title=?, bo_content=?, bo_inputdate = now()  ");
		qry.append(" WHERE bo_num = ? ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null; 
	
		try{
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1,vo.getBo_category());
			stmt.setString(2,vo.getBo_title());
			stmt.setString(3,vo.getBo_content());
			stmt.setInt(4,vo.getBo_num() );

			int res=stmt.executeUpdate();
			
			if(res>0){
				}	
		}	catch(Exception e){
			
			}finally{
				 DBUtil.setClose(null, stmt, conn);
			}
	}

	public List<BoardVO> readWithPaging(PagingDTO dto , String cate){
	
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT * FROM big_board ");
		if(cate != null) {
			qry.append(" WHERE bo_category = ? ");
		}
		qry.append(" ORDER BY bo_num desc LIMIT " + dto.startPage() +   "," + dto.getPageRow() );
		/*  1페이지당 20줄이 나오도록 만들 예정 */
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<BoardVO> list=new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			if(cate != null) {
				stmt.setString(1, cate);
			}
			rs= stmt.executeQuery();
			
			while(rs.next()){
				BoardVO board= new BoardVO();
				board.setBo_num(rs.getInt("bo_num"));
				board.setBo_category(rs.getString("bo_category"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_content(rs.getString("bo_content"));
				board.setBo_mb_id(rs.getString("bo_mb_id"));
				board.setBo_mb_name(rs.getString("bo_mb_name"));
				board.setBo_hit(rs.getInt("bo_hit"));
				board.setBo_inputdate(rs.getTimestamp("bo_inputdate"));		
				board.setBo_ip(rs.getString("bo_ip"));
				
				list.add(board); /* ﻿추가하고 난 것을 배열에 넣어주는 함수 */
			}
			
		} catch(Exception e){
			
		} finally{
			 DBUtil.setClose(null, stmt, conn);	
		}

		return list;
	}
	
	public BoardVO read(int bo_num){
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT * FROM big_board WHERE bo_num = ? " );
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BoardVO board = null;

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bo_num);
			rs= stmt.executeQuery();
			
			if(rs.next()){
				board= new BoardVO();
				board.setBo_num(rs.getInt("bo_num"));
				board.setBo_category(rs.getString("bo_category"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_content(rs.getString("bo_content"));
				board.setBo_mb_id(rs.getString("bo_mb_id"));
				board.setBo_mb_name(rs.getString("bo_mb_name"));
				board.setBo_hit(rs.getInt("bo_hit"));
				board.setBo_inputdate(rs.getDate("bo_inputdate"));		
				board.setBo_ip(rs.getString("bo_ip"));
				
			}
			
		} catch(Exception e){
			
		} finally{
			 DBUtil.setClose(null, stmt, conn);
		}

		return board;
	}
	
	public BoardVO readModify(int bo_num){
		
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT * FROM big_board WHERE bo_num = ? " );
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BoardVO board = null;

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bo_num);
			rs= stmt.executeQuery();
			
			if(rs.next()){
				board= new BoardVO();
				board.setBo_num(rs.getInt("bo_num"));
				board.setBo_category(rs.getString("bo_category"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_content(rs.getString("bo_content"));
				board.setBo_mb_id(rs.getString("bo_mb_id"));
				board.setBo_mb_name(rs.getString("bo_mb_name"));
				board.setBo_hit(rs.getInt("bo_hit"));
				board.setBo_inputdate(rs.getDate("bo_inputdate"));		
				board.setBo_ip(rs.getString("bo_ip"));
				
			}
			
		} catch(Exception e){
			
		} finally{
			 DBUtil.setClose(null, stmt, conn);
		}

		return board;
	}

	
	//전체 행수
	public int totalCnt(String cate) {	
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT count(*) as cnt FROM big_board ");
		if(cate != null) {
			qry.append(" WHERE bo_category = ? ");
		}
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		int total =0 ;

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			if(cate != null) {
				stmt.setString(1, cate);
			}
			rs= stmt.executeQuery();
			
			if(rs.next()){
				total = rs.getInt("cnt");
				/* 별칭을 넣어주었다*/
			}
			
		} catch(Exception e){
			
		} finally{
			 DBUtil.setClose(rs, stmt, conn);
		}
		
		return total;
	}
	
}
