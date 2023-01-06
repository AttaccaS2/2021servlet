package service;
import java.util.List;

import model.BoardVO;
import model.PagingDTO;
import model.ViewinfoVO;

	public interface BoardService {
		public void create(BoardVO vo);
		
		public void update(BoardVO vo);
		
		public List<BoardVO> readWithPaging(PagingDTO dto, String cate);
		
		public BoardVO read(int bo_num);
			
		public BoardVO readModify(int bo_num);
		
		public int totalCnt(String cate); 
		
		public ViewinfoVO view(int bo_num);
		
}
