package main.model.user.userrepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import main.model.user.Client;
import main.model.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	@Nullable
	public Client findClientByUserEmailAndUserPassword(String userEmail, String userPassword);
	
	@Query("SELECT COUNT(*) FROM Employee e WHERE e.position = :position")
	public int countByPosition(@Param("position") String position);
	
	@Query("FROM User u JOIN Employee e ON u.userEmail = e.userEmail WHERE e.position = :position ORDER BY u.userName ASC")
	public List<User> getUser(@Param("position") String position);
	
	
}
