package com.poorni.demo.Repository;

import com.poorni.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByLastName(String lastName);
}
