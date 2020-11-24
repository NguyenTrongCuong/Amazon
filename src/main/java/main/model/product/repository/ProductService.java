package main.model.product.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import main.model.product.Book;
import main.model.product.Food;
import main.model.product.GamingGear;
import main.model.product.Keyboard;
import main.model.product.Meat;
import main.model.product.Milk;
import main.model.product.Mouse;
import main.model.product.Product;
import main.model.product.Vegetable;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public void addProduct(Product product) {
		this.repository.save(product);
	}
	
	public Optional<Product> findProductById(int productId) {
		return this.repository.findById(productId);
	}
	
	public void updateProduct(Product product) {
		this.repository.save(product);
	}
	
	public void removeProduct(int productId) {
		this.repository.deleteById(productId);
	}
	
	public Object[] getProductType() {
		return this.repository.getProductType();
	}
	
	public Object[] getProductCategory(String productType) {
		return this.repository.getProductCategory(productType);
	}
	
	public Object[] getGamingGearBrand() {
		return this.repository.getGamingGearBrand();
	}
	
	public Object[] getFoodOrigin() {
		return this.repository.getFoodOrigin();
	}
	
	public Object[] getBookAuthor() {
		return this.repository.getBookAuthor();
	}
	
	public Object[] getBookPublisher() {
		return this.repository.getBookPublisher();
	}
	
	public Page<Product> getProductByPage(String productType, Pageable page) {
		return this.repository.findByProductType(productType, page);
	}

	
	public Page<GamingGear> getSortedGamingGear(String productType, List<String> productCategory, List<String> brand, Pageable page) {
		return this.repository.findGamingGearByProductTypeAndProductCategoryInAndBrandIn(productType, productCategory, brand, page);
	}
	
	public Page<Food> getSortedFood(String productType, List<String> productCategory, List<String> origin, Pageable page) {
		return this.repository.findFoodByProductTypeAndProductCategoryInAndOriginIn(productType, productCategory, origin, page);
	}
	
	public Page<Book> getSortedBook(String productType, List<String> productCategory, List<String> author, List<String> publisher, Pageable page) {
		return this.repository.findBookByProductTypeAndProductCategoryInAndAuthorInAndPublisherIn(productType, productCategory, author, publisher, page);
	}
	
	public Mouse getMouse(int productId) {
		return this.repository.findMouseByProductId(productId);
	}
	
	public Keyboard getKeyboard(int productId) {
		return this.repository.findKeyboardByProductId(productId);
	}
	
	public Meat getMeat(int productId) {
		return this.repository.findMeatByProductId(productId);
	}
	
	public Milk getMilk(int productId) {
		return this.repository.findMilkByProductId(productId);
	}
	
	public Vegetable getVegetable(int productId) {
		return this.repository.findVegetableByProductId(productId);
	}
	
	public Book getBook(int productId) {
		return this.repository.findBookByProductId(productId);
	}
	
	private List<Product> filter(List<Product> rs, int quantity) {
		List<Product> check = new ArrayList<Product>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < rs.size(); ++i) {
			Product inter = rs.get(i);
			if(!check.contains(inter)) {
				check.add(inter);
				map.put(i, 1);
			}
			else {
				int index = check.indexOf(inter);
				map.put(index, map.get(index) + 1);
			}
		}
		check.clear();
		if(!map.isEmpty()) {
			for(Map.Entry<Integer, Integer> set : map.entrySet()) {
				if(set.getValue() == quantity) {
					check.add(rs.get(set.getKey()));
				}
			}
		}
		return check;
	}
	
	public List<Product> getProductByKeyWord(String keyword) {
		keyword = keyword.trim();
		List<Product> rs = new ArrayList<Product>();
		List<Product> temp = null;
		String[] elements = null;
		if(keyword.matches("^[0-9]*$")) {
			Optional<Product> product = this.repository.findById(Integer.parseInt(keyword));
			if(!product.isEmpty()) {
				rs.add(product.get());
			}
		}
		else {
			elements = keyword.split("\\s+");
			for(String inter : elements) {
				List<Product> check = this.repository.getProductByKeyWord(inter);
				if(check != null && check.size() > 0) {
					rs.addAll(check);
				}
			}
			if(rs.size() > 0) {
				temp = filter(rs, elements.length);
				if(temp.size() > 0) {
					rs = temp;
				}
				else {
					Set<Product> set = new HashSet<Product>();
					for(Product ele : rs) {
						set.add(ele);
					}
					rs.clear();
					rs.addAll(set);
				}
			}
		}
		return rs;
	}
	
	public List<Product> getListOfProduct(List<Integer> productId) {
		return this.repository.findByProductIdIn(productId);
	}
	
	public void updateProductByIdAndQuantity(int productId, int productQuantity) {
		this.repository.updateByProductId(productId, productQuantity);
	}


}







































