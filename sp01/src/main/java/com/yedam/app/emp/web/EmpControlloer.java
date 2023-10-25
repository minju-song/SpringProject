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
	//GET : ��ȸ, ������ ȣ��
	//POST : ������ �ǵ帱 ��
	
	
	//��ü��ȸ 
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";
	}
	
	
	//�����ȸ
	@GetMapping("empInfo")
	public String getEmpInfo(Model model, EmpVO empVO) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empVO", findVO);
		
		return "emp/empInfo";
	}
	
	//��� - Form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	//��� - Process
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
	
	//����
	//Ajax -> @ResponseBody
	//QueryString���� �����Ÿ� Ŀ��尴ü ���
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//json���� �����Ÿ� @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	//����
	@GetMapping("empDelete")
	public String empDeleteProcess(@RequestParam Integer employeeId,
									RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		String msg = null;
		
		if(result) {
			msg = "���������� �����Ǿ����ϴ�. \n������� : "+employeeId;
		}
		else {
			msg = "���������� ���������ʾҽ��ϴ�. \n������ Ȯ�����ֽñ� �ٶ��ϴ�.\n������û : "+employeeId;
		}
		ratt.addFlashAttribute("result", msg);
		return "redirect:empList";
	}
}
