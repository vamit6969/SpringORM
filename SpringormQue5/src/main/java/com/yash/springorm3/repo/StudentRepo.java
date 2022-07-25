package com.yash.springorm3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.yash.springorm3.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	@Query(value="select sid from student where sname=?1",nativeQuery = true)
	Integer findByName(String name);
}
