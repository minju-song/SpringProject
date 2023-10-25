package com.yedam.app.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yedam.app.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//��ü��ȸ : URI - boardList / RETURN - board/boardList
	
	//�ܰ���ȸ : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	
	//��� - ������ : URI - boardInsert / RETURN - board/boardInsert
	
	//��� - ó�� : URI - boardInsert / PARAMETER - BoardVO / RETURN - ��ü��ȸ �ٽ� ȣ��
	
	//���� - ������ : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	
	//���� - ó�� : URI - boardUpdate / PARAMETER - BoardVO / RETURN - ������� ������(Map)
	
	//���� - ó�� : URI - boardDelete / PARAMETER - Integer / RETURN - ��ü��ȸ �ٽ� ȣ��
	
}
