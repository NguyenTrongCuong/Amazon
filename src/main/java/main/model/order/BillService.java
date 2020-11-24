package main.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	@Autowired
	private BillRepository repository;
	
	public int saveBill(Bill bill) {
		return this.repository.save(bill).getBillId();
	}
	
	public List<Bill> getBills(String clientEmail) {
		return this.repository.findConCac(clientEmail);
	}
	

}
