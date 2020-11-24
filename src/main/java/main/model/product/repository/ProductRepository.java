package main.model.product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.product.Book;
import main.model.product.Food;
import main.model.product.GamingGear;
import main.model.product.Keyboard;
import main.model.product.Meat;
import main.model.product.Milk;
import main.model.product.Mouse;
import main.model.product.Product;
import main.model.product.Vegetable;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, ProductRepositoryCustom {
	@Query("SELECT DISTINCT p.productType FROM Product p")
	public Object[] getProductType();
	
	@Query("SELECT DISTINCT p.productCategory FROM Product p WHERE p.productType = :productType")
	public Object[] getProductCategory(@Param("productType") String productType);
	
	@Query("SELECT DISTINCT g.brand FROM Product p JOIN GamingGear g ON p.productId = g.productId")
	public Object[] getGamingGearBrand();
	
	@Query("SELECT DISTINCT f.origin FROM Product p JOIN Food f ON p.productId = f.productId")
	public Object[] getFoodOrigin();
	
	@Query("SELECT DISTINCT b.author FROM Product p Join Book b ON p.productId = b.productId")
	public Object[] getBookAuthor();
	
	@Query("SELECT DISTINCT b.publisher FROM Product p Join Book b ON p.productId = b.productId")
	public Object[] getBookPublisher();
	
	public Page<Product> findByProductType(String productType, Pageable page);
	
	public Page<GamingGear> findGamingGearByProductTypeAndProductCategoryInAndBrandIn(String productType, List<String> productCategory, List<String> brand, Pageable page);
	
	public Page<Food> findFoodByProductTypeAndProductCategoryInAndOriginIn(String productType, List<String> productCategory, List<String> origin, Pageable page);
	
	public Page<Book> findBookByProductTypeAndProductCategoryInAndAuthorInAndPublisherIn(String productType, List<String> productCategory, List<String> author, List<String> publisher, Pageable page);
	
	public Mouse findMouseByProductId(int productId);
	
	public Keyboard findKeyboardByProductId(int productId);
	
	public Meat findMeatByProductId(int productId);
	
	public Milk findMilkByProductId(int productId);
	
	public Vegetable findVegetableByProductId(int productId);
	
	public Book findBookByProductId(int productId);
	
	public List<Product> findByProductIdIn(List<Integer> productId);


}





















































