package main.model.shippingdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
	@Autowired
	private ShipRepository repository;
	
	public int countUsers() {
		return this.repository.countUsers();
	}
	
	public void saveShip(ShippingDetails shippingDetails) {
		this.repository.save(shippingDetails);
	}

}
