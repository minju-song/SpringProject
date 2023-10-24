package com.yedam.app.dep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dep.service.DepVO;

public interface DepMapper {
	
	//��ü��ȸ
	public List<DepVO> selectAllDepInfo();
	
	//�ܰ���ȸ
	public DepVO selectDepInfo(DepVO vo);
	
	public int insertDepInfo(DepVO vo);
	
	public int updateDepInfo(DepVO vo);
	
	public int deleteDepInfo(@Param("depid") int departmentId);
}
