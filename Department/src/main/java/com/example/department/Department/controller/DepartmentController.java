package com.example.department.Department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.Department.dto.DepartmentDTO;
import com.example.department.Department.exception.EntityNotExist;
import com.example.department.Department.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController
{
	@Autowired
	DepartmentService departmentService;
	
	 //CREATE
    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO)
    {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/get")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments()
    {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //UPDATE
    @PutMapping("/{departmentID}")
    public ResponseEntity<DepartmentDTO> updateDepartment(
            @PathVariable Long departmentID,
            @RequestBody DepartmentDTO departmentDTO) throws EntityNotExist
    {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentID, departmentDTO);			
        
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{departmentID}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentID) throws EntityNotExist
    {
        departmentService.deleteDepartment(departmentID);
        String response = "Entity with id: " + departmentID + " has been removed";
        
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
