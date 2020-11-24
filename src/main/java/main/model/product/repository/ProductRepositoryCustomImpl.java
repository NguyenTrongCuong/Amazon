package main.model.product.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.model.product.Product;

@Repository
@Transactional
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	@Autowired
	private EntityManager entityManager;
	
	public List<Product> getProductByKeyWord(String keyword) {
		List<Product> rs = new ArrayList<Product>();
		String query = "SELECT p.productId, p.imageLocation, p.productCategory, p.productName, p.productPrice, p.productQuantity, p.productType FROM product as p"
					   + " LEFT JOIN gaminggear as g ON p.productId = g.productId"
					   + " LEFT JOIN food as f ON p.productId = f.productId"
					   + " LEFT JOIN book as b ON p.productId = b.productId"
					   + " WHERE REGEXP_LIKE(p.productName, '" + keyword + "')"
					   + " OR REGEXP_LIKE(p.productCategory, '" + keyword + "')"
					   + " OR REGEXP_LIKE(g.brand, '" + keyword + "')"
					   + " OR REGEXP_LIKE(f.origin, '" + keyword + "')"
					   + " OR REGEXP_LIKE(b.author, '" + keyword + "')"
					   + " OR REGEXP_LIKE(b.publisher, '" + keyword + "')";
		NativeQuery sql = (NativeQuery) this.entityManager.createNativeQuery(query);
		List<Object[]> temp = sql.getResultList();
		for(Object[] obj : temp) {
			rs.add(new Product((String) obj[3], (String) obj[6], (Integer) obj[5], (String) obj[2], ((BigInteger) obj[4]).longValue(), (String) obj[1], (Integer) obj[0]));
		}
		return rs;
	}

	public void updateByProductId(int productId, int productQuantity) {
		String sql = "UPDATE Product p SET p.productQuantity = p.productQuantity - :productQuantity WHERE p.productId = :productId";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter("productQuantity", productQuantity);
		query.setParameter("productId", productId);
		query.executeUpdate();
	}

}










































