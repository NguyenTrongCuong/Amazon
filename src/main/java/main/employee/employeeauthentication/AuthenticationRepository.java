package main.employee.employeeauthentication;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import main.model.cookie.CookieDetails;
import main.model.user.Employee;

@Repository
public interface AuthenticationRepository extends PagingAndSortingRepository<Employee, String> {
	
	@Nullable
	public Employee findEmployeeByUserEmailAndUserPassword(String email, String password);

}
