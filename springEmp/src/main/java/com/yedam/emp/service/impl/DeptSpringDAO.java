package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired
	JdbcTemplate jdbc;

	private final String INSERT_DEPT = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
										+ " VALUES(?,?,?,?)";
	private final String UPDATE_DEPT = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID=?,  LOCATION_ID=? WHERE DEPARTMENT_ID=?";
	private final String DELETE_DEPT = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
	private final String GET_DEPT = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
	private final String GET_SEARCH_DEPT = "SELECT * FROM DEPARTMENTS ORDER BY 1";

	// 등록
	public int insertDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT, vo.getDepartment_id(), vo.getDepartment_name(), vo.getManager_id(),
				vo.getLocation_id());
		return result;
	}

	// 수정
	public int updateDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT, vo.getDepartment_name(), vo.getManager_id(), vo.getLocation_id(),
				vo.getDepartment_id());
		return result;
	}

	// 삭제
	public int deleteDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_DEPT, vo.getDepartment_id());
		return result;
	}

	// 단건조회
	public DeptVO getDept(DeptVO vo) {
		return jdbc.queryForObject(GET_DEPT, new EmpRowMapper(), vo.getDepartment_id());
	}

	// 검색조회
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return jdbc.query(GET_SEARCH_DEPT, new EmpRowMapper());
	}

	// rowmapper
	class EmpRowMapper implements RowMapper<DeptVO> {

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getString("DEPARTMENT_ID"));
			vo.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			vo.setManager_id(rs.getString("MANAGER_ID"));
			vo.setLocation_id(rs.getString("LOCATION_ID"));
			return vo;
		}

	}

}
