package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	
	//��ü��ȸ
	public List<BoardVO> selectBoardList();
	
	//�ܰ���ȸ : bno
	public BoardVO selectBoard(BoardVO boardVO);
	
	//��� : ��ϴ�� = bno(selectkey), title, contents, writer, image
	public int insertBoard(BoardVO boardVO);
	
	//���� : ������� = title, contents, writer, updatedate, image
	public int updateBoard(BoardVO boardVO);
	
	//���� : bno
	public int deleteBoard(int boardNo);
}
