package service;

import java.util.*;

import model.MemberVO;

public interface MemberService {
	
	public void create(MemberVO vo);
	
	public List<MemberVO> readOut(String keyword);
	
	public List<MemberVO> readIn(String keyword);
	
	public MemberVO read(String mb_id);
	
}
