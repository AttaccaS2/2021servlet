package service;

import java.util.List;

import mapper.BoardMapper;
import model.BoardVO;
import model.CommentVO;
import model.PagingDTO;
import model.ViewinfoVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public void create(BoardVO vo) {
		BoardMapper mapper = new BoardMapper();
		mapper.create(vo);
	}

	@Override
	public void update(BoardVO vo) {
		BoardMapper mapper = new BoardMapper();
		mapper.update(vo);	
	}

	@Override
	public List<BoardVO> readWithPaging(PagingDTO dto , String cate) {
		BoardMapper mapper = new BoardMapper();
		return mapper.readWithPaging(dto, cate);	//보이드 안하면 리턴 
		}

	@Override
	public int totalCnt(String cate) {
		BoardMapper mapper = new BoardMapper();
		return mapper.totalCnt(cate);	
		}

	@Override
	public BoardVO read(int bo_num) {
		BoardMapper mapper = new BoardMapper();
		return mapper.read(bo_num);	
		}

	@Override
	public BoardVO readModify(int bo_num) {
		BoardMapper mapper = new BoardMapper();
		return mapper.read(bo_num);	
		}

	@Override
	public ViewinfoVO view(int bo_num) {
		BoardVO board = new BoardMapper().read(bo_num);
		List<CommentVO> list = new CommentServiceImpl().read(bo_num);		
		ViewinfoVO info = new ViewinfoVO();
		info.setBoard(board); //보드를 넣어줌
		info.setList(list);// 리스트도 넣어줌
		return info; //2개 호출하고 info라는 객체에 2개 다 넣음
		}
}
