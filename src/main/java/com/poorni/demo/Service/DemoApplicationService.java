package com.poorni.demo.Service;


import com.poorni.demo.entity.Employee;
import java.util.Collection;
import java.util.List;

public interface DemoApplicationService {
     void createUser(Employee user);

     void deleteUser(long id);

     Employee findUser(long id);

     Collection<Employee> findAllUsers(final String filterBy, final String value);

     List<Employee> findByLastName(String lastName);

     String findAddress(long id) throws Exception;
}
