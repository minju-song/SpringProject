package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	
	//��ü��ȸ
	public List<EmpVO> getEmpAll();
	
	//�ܰ���ȸ
	public EmpVO getEmpInfo(EmpVO empVO);
	
	//���
	public int insertEmpInfo(EmpVO empVO);
	
	//����
	public Map<String, Object> updateEmpInfo(EmpVO empVO);
	
	//����
	public boolean deleteEmpInfo(int empId);
	
}
