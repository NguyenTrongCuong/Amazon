package main.model.product.repository;

import java.util.List;

import main.model.product.Product;

public interface ProductRepositoryCustom {
	public List<Product> getProductByKeyWord(String keyword);
	
	public void updateByProductId(int productId, int productQuantity);

}
