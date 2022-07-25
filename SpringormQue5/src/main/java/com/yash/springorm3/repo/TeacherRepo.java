package com.yash.springorm3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.springorm3.models.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer>{

}
