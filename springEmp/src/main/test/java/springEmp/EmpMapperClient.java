package springEmp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	
	@Autowired EmpMapper empMapper;
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		assertNotNull(resultVO);	//T/F
		System.out.println(resultVO);
	}
	
	//@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build();
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		assertNotNull(list);	//T/F
		System.out.println(list);
	}
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
						.employee_id("992")
						.manager_id("100")
						.last_name("test1")
						.email("a@dw23a.cd")
						.hire_date(new java.sql.Date(new Date(0).getTime()))
				        .job_id("IT_PROG")
						.first_name("na")
						.phone_number("010.5555")
						.department_id("60")
				        .build();
		int result = empMapper.insertEmp(vo);
		assertEquals(result, 1);
	}
	
	
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
						.email("a@a.ff")
						.employee_id("994")
				        .build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}

}
