package com.example.department.Department.service;

import java.util.List;

import com.example.department.Department.dto.DepartmentDTO;
import com.example.department.Department.exception.EntityNotExist;

public interface DepartmentService
{	
	//create
	DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
	
	//update
	DepartmentDTO updateDepartment(Long departmentID, DepartmentDTO departmentDTO) throws EntityNotExist;
	
	//read/GET
	List<DepartmentDTO> getAllDepartments();
	
	//delete
	void deleteDepartment(Long departmentID) throws EntityNotExist;

}
