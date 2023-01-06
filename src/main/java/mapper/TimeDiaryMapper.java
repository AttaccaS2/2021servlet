package mapper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.DBUtil;
import model.PagingDTO;
import model.TimeDiaryVO;

public class TimeDiaryMapper {
	public void create(TimeDiaryVO vo) {

		StringBuffer qry= new StringBuffer();
		qry.append(" INSERT INTO big_timediary (tbo_num, tbo_content, tbo_mb_id, tbo_mb_name, tbo_datetime)  ");
		qry.append(" VALUES (null,?,?,?,now())   ");
		String sql = qry.toString();
		System.out.println(sql);

		Connection conn = null;
		PreparedStatement stmt = null; 
	
		try{
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, vo.getTbo_content());
			stmt.setString(2, vo.getTbo_mb_id());			
			stmt.setString(3, vo.getTbo_mb_name());

			int res=stmt.executeUpdate();
			if(res>0){
			}	
			
		}	catch(Exception e){
			
			}finally{
				 DBUtil.setClose(null, stmt, conn);
			}
	}

	public List<TimeDiaryVO> readWithPaging(PagingDTO dto) {
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT * FROM big_timediary ");
		qry.append(" ORDER BY tbo_num desc LIMIT " + dto.startPage() +   "," + dto.getPageRow() );
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TimeDiaryVO> list=new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				TimeDiaryVO board= new TimeDiaryVO();
				board.setTbo_num(rs.getInt("tbo_num"));
				board.setTbo_content(rs.getString("tbo_content"));
				board.setTbo_mb_id(rs.getString("tbo_mb_id"));
				board.setTbo_mb_name(rs.getString("tbo_mb_name"));
			
				//SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분");
				//board.setTbo_datetime(sdf.format(rs.getTimestamp("tbo_datetime")));
				//string을 date로 캐스팅 불가 
				
				board.setTbo_datetime(rs.getTimestamp("tbo_datetime"));		

				list.add(board); /* ﻿추가하고 난 것을 배열에 넣어주는 함수 */
			}
			
		} catch(Exception e){
			
		} finally{
			 DBUtil.setClose(null, stmt, conn);	
		}

		return list;
	}

	public int totalCnt() {
		StringBuffer qry= new StringBuffer();
		qry.append(" SELECT count(*) as cnt FROM big_timediary ");

		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		int total =0 ;

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);

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
