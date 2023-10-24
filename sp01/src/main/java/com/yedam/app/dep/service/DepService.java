package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {

	//전체조회
	public List<DepVO> getDepAll();
	
	//단건조회
	public DepVO getDepInfo(DepVO vo);
	
	//등록
	public int insertDepInfo(DepVO vo);
	
	//수정
	public Map<String, Object> updateDepInfo(DepVO vo);
	
	//삭제
	public boolean deleteDepInfo(int depId);
}
