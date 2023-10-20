package co.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.yedam.app.emp.mapper.EmpMapper;
import co.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void getEmpAll() {
		List<EmpVO> list = empMapper.selectAllEmpInfo();
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void getEmpInfo() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO findvo = empMapper.selectEmpInfo(vo);
		assertEquals(findvo.getLast_name(), "King");
	}
}
