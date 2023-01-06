package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import model.TradingDetailVO;

public class TradingDetailMapper {

	public void create(TradingDetailVO vo) {
		StringBuffer qry = new StringBuffer();
		qry.append(" INSERT INTO big_tradingdetail (trad_num, trad_refnum, trad_tradingDate,  ");
		qry.append("  trad_subject, trad_standard, trad_quantity, trad_unitPrice, trad_supplyPrice, trad_taxAmount, trad_note)  ");
		qry.append(" VALUES (null,?,?,?,?,?,?,?,?,? ) ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println(sql);
		System.out.println(vo);
		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getTrad_refnum());
			stmt.setDate(2,new java.sql.Date(vo.getTrad_traingDate().getTime()));
			stmt.setString(3, vo.getTrad_subject());
			stmt.setString(4, vo.getTrad_standard());
			stmt.setInt(5, vo.getTrad_quantity());
			stmt.setInt(6, vo.getTrad_unitPrice());
			stmt.setInt(7, vo.getTrad_supplyPrice());	
			stmt.setInt(8, vo.getTrad_taxAmount());
			stmt.setString(9, vo.getTrad_note());
		
			int res = stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

	}
	
	/**
	 * 
	 * @param tra_num
	 * @return
	 */
	public List<TradingDetailVO> read(int tra_num){
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT * from big_tradingdetail WHERE trad_refnum =? ORDER BY trad_num ASC  ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<TradingDetailVO> list= new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tra_num);
		
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				TradingDetailVO vo = new TradingDetailVO(); //임포트한 클래스를 객체 생성해서 만드는 has a 방식 상속은 is a
				vo.setTrad_num(rs.getInt("trad_num"));
				vo.setTrad_traingDate(rs.getDate("trad_tradingDate"));
				vo.setTrad_subject(rs.getString("trad_subject"));
				vo.setTrad_standard(rs.getString("trad_standard"));
				vo.setTrad_quantity(rs.getInt("trad_quantity"));
				vo.setTrad_unitPrice(rs.getInt("trad_unitPrice"));
				vo.setTrad_supplyPrice(rs.getInt("trad_supplyPrice"));
				vo.setTrad_taxAmount(rs.getInt("trad_taxAmount"));
				vo.setTrad_note(rs.getString("trad_note"));
				
				list.add(vo);
			}

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

		return list;
	}
	
	public void delete(int trad_refnum) {
		StringBuffer qry = new StringBuffer();
		qry.append(" DELETE FROM big_tradingdetail ");
		qry.append(" WHERE trad_refnum = ?  ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		//System.out.println(sql);

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, trad_refnum);
			
			int res = stmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}
	}

	
}
