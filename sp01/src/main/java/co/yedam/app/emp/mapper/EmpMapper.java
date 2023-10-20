package co.yedam.app.emp.mapper;

import java.util.List;

import co.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public List<EmpVO> selectAllEmpInfo();
	public EmpVO selectEmpInfo(EmpVO empvo);
}
