package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Service
public class DepServiceImpl implements DepService{
	@Autowired
	DepMapper depMapper;
	
	@Override
	public List<DepVO> getDepAll() {
		return depMapper.selectAllDepInfo();
	}

	@Override
	public DepVO getDepInfo(DepVO vo) {
		return depMapper.selectDepInfo(vo);
	}

	@Override
	public int insertDepInfo(DepVO vo) {
		int result = depMapper.insertDepInfo(vo);
		if(result == 1) {
			return vo.getDepartmentId();
		}
		else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> updateDepInfo(DepVO vo) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = depMapper.updateDepInfo(vo);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("vo", vo);
		
		return map;
	}

	@Override
	public boolean deleteDepInfo(int depId) {
		int result = depMapper.deleteDepInfo(depId);
		
		if(result == 1) {
			return true;
		}
		else return false;
	}

}
