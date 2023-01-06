package mapper;

import java.sql.*;
import java.util.*;

import common.DBUtil;
import model.MemberVO;

public class MemberMapper {

	public void create(MemberVO vo) {
		// 회원테이블 관련 sql에 데이터 등록

		StringBuffer qry = new StringBuffer();
		qry.append(
				" insert into big_member (mb_id, mb_pw, mb_name, mb_email, mb_zipcode, mb_addr, mb_detailAddr, mb_phone, mb_birth, mb_gender, mb_joindate)  ");
		qry.append(" values ( ?, ?, ? ,? ,? ,? ,? ,?, ? ,? , now()) "); // ?하는 이유는 보안때문

		String sql = qry.toString();

		int idx = 1;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			// ?에 값넣기
			stmt.setString(idx++, vo.getMb_id()); // 1 int idx=1;이니까 1이 먼저 나오고 1씩 더해짐
			stmt.setString(idx++, vo.getMb_pw()); // 2
			stmt.setString(idx++, vo.getMb_name());
			stmt.setString(idx++, vo.getMb_email());
			stmt.setString(idx++, vo.getMb_zipcode());
			stmt.setString(idx++, vo.getMb_addr());
			stmt.setString(idx++, vo.getMb_detailAddr());
			stmt.setString(idx++, vo.getMb_phone());
			stmt.setString(idx++, vo.getMb_birth());
			stmt.setString(idx++, vo.getMb_gender());

			// 실행
			int res = stmt.executeUpdate();
			if (res > 0) {
			}
		} catch (Exception e) {
			e.getLocalizedMessage();
		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

	}

	public List<MemberVO> readIn(String keyword) {

		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT * FROM big_member WHERE mb_out = 'N' ");

		if (keyword != null || "".equals(keyword)) {
			qry.append(" AND ( mb_name LIKE ? OR mb_email LIKE ? OR mb_phone LIKE ? OR mb_birth LIKE ? ) ");
		}

		qry.append("ORDER BY mb_joindate DESC");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			if (keyword != null || "".equals(keyword)) {
				stmt.setString(1, "%" + keyword + "%");
				stmt.setString(2, "%" + keyword + "%");
				stmt.setString(3, "%" + keyword + "%");
				stmt.setString(4, "%" + keyword + "%");
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_name(rs.getString("mb_name"));
				member.setMb_email(rs.getString("mb_email"));
				member.setMb_phone(rs.getString("mb_phone"));
				member.setMb_birth(rs.getString("mb_birth"));
				member.setMb_gender(rs.getString("mb_gender"));
				member.setMb_joindate(rs.getDate("mb_joindate"));

				list.add(member);
			}

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

		return list;
	}

	public List<MemberVO> readOut(String keyword) {

		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT * FROM big_member WHERE mb_out='Y' ");

		if (keyword != null || "".equals(keyword)) {
			qry.append(" AND ( mb_name LIKE ? OR mb_email LIKE ? OR mb_phone LIKE ? OR mb_birth LIKE ? ) ");
		}

		qry.append("order by mb_joindate desc");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			if (keyword != null || "".equals(keyword)) {
				stmt.setString(1, "%" + keyword + "%");
				stmt.setString(2, "%" + keyword + "%");
				stmt.setString(3, "%" + keyword + "%");
				stmt.setString(4, "%" + keyword + "%");
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_name(rs.getString("mb_name"));
				member.setMb_email(rs.getString("mb_email"));
				member.setMb_phone(rs.getString("mb_phone"));
				member.setMb_birth(rs.getString("mb_birth"));
				member.setMb_gender(rs.getString("mb_gender"));
				member.setMb_joindate(rs.getDate("mb_joindate"));

				list.add(member);
			}

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

		return list;
	}

	// 회원정보 가지고 오기
	public MemberVO read(String mb_id) {

		/*
		 * 객체 생성 없이 하려면 static 하면 된다 DBUtil db = DBUtil(); db.getConnection(); 매번 선언 귄찮
		 */

		DBUtil.getConnection();

		StringBuffer qry = new StringBuffer();
		qry.append(" select * from big_member where mb_id=? ");
		String sql = qry.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MemberVO member = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mb_id);

			rs = stmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_name(rs.getString("mb_name"));
				member.setMb_email(rs.getString("mb_email"));
				member.setMb_phone(rs.getString("mb_phone"));
				member.setMb_birth(rs.getString("mb_birth"));
				member.setMb_gender(rs.getString("mb_gender"));
				member.setMb_joindate(rs.getDate("mb_joindate"));

			}

		} catch (Exception e) {

		} finally {
			DBUtil.setClose(null, stmt, conn);
		}

		return member;
	}
	

}
