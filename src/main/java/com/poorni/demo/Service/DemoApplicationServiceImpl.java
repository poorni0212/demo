package com.poorni.demo.Service;

import com.poorni.demo.Repository.UserRepository;

import com.poorni.demo.client.AddressHTTPClient;
import com.poorni.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DemoApplicationServiceImpl implements DemoApplicationService {

    private final UserRepository userRepository;

    public DemoApplicationServiceImpl(Map<Integer, Employee> userMap, UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(Employee employee) {
        userRepository.save(employee);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Employee findUser(long id) {
        Employee employee = userRepository.findById(id).get();
        return employee;
    }

    @Override
    public Collection<Employee> findAllUsers(String filterBy, final String value) {
        if (filterBy != null && filterBy.equalsIgnoreCase("lastName")) {
            return userRepository.findByLastName(value);
        }
        return userRepository.findAll();

    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public String findAddress(long id) throws Exception {
        return AddressHTTPClient.getAddress(id);
    }
}
