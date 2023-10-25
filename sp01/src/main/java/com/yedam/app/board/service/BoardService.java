package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	//��ü��ȸ
	public List<BoardVO> getBoardList();
	
	//�ܰ���ȸ
	public BoardVO getBoard(BoardVO boardVO);
	
	//���
	public int insertBoard(BoardVO boardVO);
	
	//����
	public Map<String,Object> updateBoard(BoardVO boardVO);
	
	//����
	public int deleteBoard(int boardNo);
	
}
