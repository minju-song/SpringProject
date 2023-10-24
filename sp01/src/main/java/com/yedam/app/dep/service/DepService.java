package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {

	//��ü��ȸ
	public List<DepVO> getDepAll();
	
	//�ܰ���ȸ
	public DepVO getDepInfo(DepVO vo);
	
	//���
	public int insertDepInfo(DepVO vo);
	
	//����
	public Map<String, Object> updateDepInfo(DepVO vo);
	
	//����
	public boolean deleteDepInfo(int depId);
}
