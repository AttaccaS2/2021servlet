package service;

import java.util.List;

import model.PagingDTO;
import model.TimeDiaryVO;

public interface TimeDiaryService {
	public void create(TimeDiaryVO vo);
	
	public List<TimeDiaryVO> readWithPaging(PagingDTO dto);
	
	public int totalCnt(); 
}
