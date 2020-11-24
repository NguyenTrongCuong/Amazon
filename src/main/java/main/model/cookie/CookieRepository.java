package main.model.cookie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.user.Client;

@Repository
public interface CookieRepository extends CrudRepository<CookieDetails, Integer> {
	
	public CookieDetails findCookieDetailsByCookieId(int cookieId);
	

}
