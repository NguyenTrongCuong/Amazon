package main.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
	@Query(value="SELECT * FROM bill WHERE bill.clientEmail = :clientEmail", nativeQuery=true)
	public List<Bill> findConCac(@Param("clientEmail") String clientEmail);
	

}
