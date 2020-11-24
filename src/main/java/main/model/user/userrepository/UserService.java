package main.model.user.userrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.user.Client;
import main.model.user.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public boolean verifyUserEmail(String userEmail) {
		return this.repository.existsById(userEmail);
	}
	
	public void saveUser(Client client) {
		this.repository.save(client);
	}
	
	public Client getClient(String userEmail, String userPassword) {
		return this.repository.findClientByUserEmailAndUserPassword(userEmail, userPassword);
	}
	
	public Optional<User> getClientByEmail(String userEmail) {
		return this.repository.findById(userEmail);
	}
	
	public int countUsers() {
		return this.repository.countByPosition("deliverer");
	}
	
	public User getUser(int quantity) {
		return this.repository.getUser("deliverer").get(quantity);
	}

}












































































