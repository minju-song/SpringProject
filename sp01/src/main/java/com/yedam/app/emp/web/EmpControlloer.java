package com.yedam.app.emp.web;

import java.util.HashMap;
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

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpControlloer {

	@Autowired
	EmpService empService;
	//GET : 조회, 페이지 호출
	//POST : 데이터 건드릴 때
	
	
	//전체조회 
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";
	}
	
	
	//사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(Model model, EmpVO empVO) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empVO", findVO);
		
		return "emp/empInfo";
	}
	
	//등록 - Form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	//등록 - Process
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {

		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		if(empId > -1) {
			path = "redirect:empInfo?employeeId="+empId;
		}
		else {
			path = "redirect:empList";			
		}
		
		return path;
	}
	
	//수정
	//Ajax -> @ResponseBody
	//QueryString으로 보낼거면 커멘드객체 사용
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//json으로 보낼거면 @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//삭제
	@GetMapping("empDelete")
	public String empDeleteProcess(@RequestParam Integer employeeId,
									RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		String msg = null;
		
		if(result) {
			msg = "정상적으로 삭제되었습니다. \n삭제대상 : "+employeeId;
		}
		else {
			msg = "정상적으로 삭제되지않았습니다. \n정보를 확인해주시길 바랍니다.\n삭제요청 : "+employeeId;
		}
		ratt.addAttribute("result", msg);
		return "redirect:empList";
	}
}
