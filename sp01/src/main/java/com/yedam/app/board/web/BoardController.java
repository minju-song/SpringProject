package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.dep.service.DepVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//��ü��ȸ : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getboardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	//�ܰ���ȸ : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(Model model, BoardVO vo) {
		BoardVO findVO = boardService.getBoard(vo);
		model.addAttribute("vo", findVO);
		return "board/boardInfo";
	}
	
	//��� - ������ : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardInfoForm() {
		return "board/boardInsert";
	}
	
	//��� - ó�� : URI - boardInsert / PARAMETER - BoardVO / RETURN - ��ü��ȸ �ٽ� ȣ��
	@PostMapping("boardInsert")
	public String insertBoardInfoProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		
		return "redirect:boardList";
	}
	
	//���� - ������ : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String updateBoardForm(Model model, BoardVO boardVO) {
		BoardVO findVO = boardService.getBoard(boardVO);
		System.out.println(findVO);
		model.addAttribute("findVO", findVO);
		return "board/boardUpdate";
	}
	
	//���� - ó�� : URI - boardUpdate / PARAMETER - BoardVO / RETURN - ������� ������(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardProcess(@RequestBody BoardVO boardVO) {
		return boardService.updateBoard(boardVO);
	}
	
	//���� - ó�� : URI - boardDelete / PARAMETER - Integer / RETURN - ��ü��ȸ �ٽ� ȣ��
	@GetMapping("boardDelete")
	public String deleteBoardProcess(@RequestParam Integer bno,
			RedirectAttributes ratt) {
		int result = boardService.deleteBoard(bno);
		
		String msg = null;
		
		if(result > -1) {
			msg = "���� �Ϸ�";
		}
		else {
			msg = "���� ����";
		}
		
		ratt.addFlashAttribute("result", msg);
		
		return "redirect:boardList";
	}
}
