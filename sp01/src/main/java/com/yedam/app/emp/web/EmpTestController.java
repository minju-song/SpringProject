package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	
	@GetMapping("parameterTest")
	public String getMethodTest(EmpVO empVO) {
		System.out.print("get : ");
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest")
	public String postMethodTest(EmpVO empVO) {
		System.out.print("post : ");
		System.out.println(empVO);
		return "";
	}
	
	//pathvariable�� ��ü�� �ޱ� ��������
	@GetMapping("pathGet/{employeeId}")
	public String pathGet(@PathVariable String employeeId) {
		System.out.print("get : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
	//�Ķ���Ϳ� �޴� ���� �̸��� �ٸ��� name�� ���� �̸� �ٲ���
	@PostMapping("pathPost/{id}")
	public String pathPost(@PathVariable(name="id") String employeeId) {
		System.out.print("post : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
	@GetMapping("reqParamTest")
	public String reqParamGet(String employeeId, String lastName) {
		System.out.print("get : ");
		System.out.printf("%s, %s\n",employeeId, lastName);
		return "";
	}
	
	//�Ķ���Ϳ� �޴� ���� �̸��� �ٸ���  value�� ���� �̸� �ٲ���
	@PostMapping("reqParamTest")
	public String reqParamPost(@RequestParam String employeeId, 
								@RequestParam(defaultValue = "guest") String lastName) {
		System.out.print("post : ");
		System.out.printf("%s, %s\n",employeeId, lastName);
		return "";
	}
	
	//requestbody�� get������ ������ post���
	//viewresolve�� ���ƿ�������
	@PostMapping("ajaxJson")
	@ResponseBody
	public EmpVO ajaxJson(@RequestBody EmpVO empVO) {
		return empVO;
	}
}
