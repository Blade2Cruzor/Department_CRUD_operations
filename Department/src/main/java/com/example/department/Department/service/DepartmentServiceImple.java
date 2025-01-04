package com.example.department.Department.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.Department.dto.DepartmentDTO;
import com.example.department.Department.entity.DepartmentEntity;
import com.example.department.Department.exception.EntityNotExist;
import com.example.department.Department.repository.DepartmentRepo;

@Service
public class DepartmentServiceImple implements DepartmentService
{
	@Autowired
	private DepartmentRepo departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO)
	{
		DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
		DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
		
		return modelMapper.map(savedEntity, DepartmentDTO.class);
	}

	@Override
	public DepartmentDTO updateDepartment(Long departmentID, DepartmentDTO departmentDTO) throws EntityNotExist
	{
		//check if id exist or not
		if(!departmentRepository.existsById(departmentID))
			throw new EntityNotExist("Department not found with id: " + departmentID);
		
		DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
		DepartmentEntity updatedEntity = departmentRepository.save(departmentEntity);
		
		return modelMapper.map(updatedEntity, DepartmentDTO.class);
	}

	@Override
	public List<DepartmentDTO> getAllDepartments()
	{
		List<DepartmentEntity> departments = (List<DepartmentEntity>) departmentRepository.findAll();
		
		return departments.stream()
				.map(department -> modelMapper.map(department, DepartmentDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteDepartment(Long departmentID) throws EntityNotExist
	{
		//check if id exist or not
		if(!departmentRepository.existsById(departmentID))
			throw new EntityNotExist("Department not found with id: " + departmentID);
		
		departmentRepository.deleteById(departmentID);
	}
	

}
