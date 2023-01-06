package service;

import java.util.List;

import mapper.TimeDiaryMapper;
import model.PagingDTO;
import model.TimeDiaryVO;

public class TimeDiaryServiceImpl implements TimeDiaryService {
	
	private TimeDiaryMapper mapper;
	
	public TimeDiaryServiceImpl() {
		this.mapper = new TimeDiaryMapper();
	}

	@Override
	public void create(TimeDiaryVO vo) {
		mapper.create(vo);		
	}

	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}

	@Override
	public List<TimeDiaryVO> readWithPaging(PagingDTO dto) {
		return mapper.readWithPaging(dto);
	}

}
