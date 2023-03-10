package mapper;

import java.sql.*;

import common.DBUtil;
import model.MemberVO;

public class LoginMapper {
	//로그인 정보 조회	
	public MemberVO read(MemberVO vo) {
		StringBuffer qry= new StringBuffer();
		qry.append(" 	SELECT * FROM big_member WHERE mb_out='N' AND mb_id=? AND mb_pw=?");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		MemberVO member= null;
		
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getMb_id());
			stmt.setString(2, vo.getMb_pw());
			
			rs = stmt.executeQuery();
			
			if(rs.next()){	
			member = new MemberVO();	
			member.setMb_id(rs.getString("mb_id"));
			member.setMb_name(rs.getString("mb_name"));
			
			
			} 
		} catch(Exception e){
				
		}finally {
			 DBUtil.setClose(null, stmt, conn);
		}
		return member;
	}
	
}
