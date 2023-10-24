package com.yedam.app.dep.web;

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

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Controller
public class DepController {

	@Autowired
	DepService depService;
	
	@GetMapping("depList")
	public String getDepList(Model model) {
		List<DepVO> list = depService.getDepAll();
		model.addAttribute("depList", list);
		return "dep/depList";
	}
	
	@GetMapping("depInfo")
	public String getDepInfo(Model model, DepVO depVO) {
		DepVO findVO = depService.getDepInfo(depVO);
		model.addAttribute("depVO", findVO);
		return "dep/depInfo";
	}
	
	@GetMapping("depInsert")
	public String insertDepInfoForm() {
		return "dep/depInsert";
	}
	
	@PostMapping("depInsert")
	public String insertDepInfoProcess(DepVO depVO) {
		
		int depId = depService.insertDepInfo(depVO);
		
		String path = null;
		if(depId > -1) {
			path = "redirect:depInfo?departmentId="+depId;
		}
		else {
			path = "redirect:depList";
		}
		
		return path;
	}
	
	@PostMapping("depUpdateAjax")
	@ResponseBody
	public Map<String, Object> depUpdateAjaxProcess(@RequestBody DepVO depVO) {
		return depService.updateDepInfo(depVO);
	}
	
	@GetMapping("depDelete")
	public String depDeleteProcess(@RequestParam Integer departmentId,
									RedirectAttributes ratt) {
		boolean result = depService.deleteDepInfo(departmentId);
		String msg = null;
		
		if(result) {
			msg = "���������� �����Ǿ����ϴ�. \n������� : "+departmentId;
		}
		else {
			msg = "���������� ���������ʾҽ��ϴ�. \n������ Ȯ�����ֽñ� �ٶ��ϴ�.\n������û : "+departmentId;
		}
		
		ratt.addAttribute("result", msg);
		return "redirect:depList";
	}
}
