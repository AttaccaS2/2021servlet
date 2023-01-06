package model;

import java.util.*;

public class ViewinfoVO {

	private BoardVO board;
	
	private List<CommentVO> list;

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public List<CommentVO> getList() {
		return list;
	}

	public void setList(List<CommentVO> list) {
		this.list = list;
	}
	
	
}
