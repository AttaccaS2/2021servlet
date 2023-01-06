package service;

import java.util.List;

import mapper.MemberMapper;
import model.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Override
	public void create(MemberVO vo) {
		MemberMapper mapper = new MemberMapper();
		mapper.create(vo);
		
	//new MemberMapper().create(vo); 랑 같음	
	}

	@Override
	public List<MemberVO> readOut(String keyword) {
		MemberMapper mapper = new MemberMapper();
		return mapper.readOut(keyword);
	}

	@Override
	public MemberVO read(String mb_id) {
		MemberMapper mapper = new MemberMapper();
		return mapper.read(mb_id);
	}


	@Override
	public List<MemberVO> readIn(String keyword) {
		MemberMapper mapper = new MemberMapper();
		return mapper.readIn(keyword);
		}


	

}
