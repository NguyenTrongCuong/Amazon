package main.employee.employeeauthentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.user.Employee;

@Service
public class EmployeeAuthenticationService {
	@Autowired
	private AuthenticationRepository repository;
	
	public Employee getEmployee(String email, String password) {
		return this.repository.findEmployeeByUserEmailAndUserPassword(email, password);
	}
	
	public Optional<Employee> getEmployeeByEmail(String email) {
		return this.repository.findById(email);
	}

}
















































































