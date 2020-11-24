package main.model.shippingdetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends CrudRepository<ShippingDetails, Integer> {
	@Query("SELECT COUNT(*) FROM ShippingDetails")
	public int countUsers();

}
