package com.example.department.Department.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.department.Department.entity.DepartmentEntity;

@Repository
public interface DepartmentRepo extends CrudRepository<DepartmentEntity, Long>
{

}
