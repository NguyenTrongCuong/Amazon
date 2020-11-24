package main.employee.adminworks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.model.product.Book;
import main.model.product.Intermediate;
import main.model.product.Keyboard;
import main.model.product.Meat;
import main.model.product.Milk;
import main.model.product.Mouse;
import main.model.product.Product;
import main.model.product.Vegetable;
import main.model.product.factory.ProductFactory;
import main.model.product.factory.SaveProductImage;
import main.model.product.repository.ProductService;

@Controller
@RequestMapping("/adminworks")
public class AdminWorks {
	@Autowired
	private ProductService service;
	
	private enum Type {
		Book, GamingGear, Food
	}
	
	@GetMapping("/getAddingForm")
	public String getAddingForm(ModelMap model) {
		List<String> productType = new ArrayList<String>();
		for(Type ele : Type.values()) {
			productType.add(ele.toString());
		}
		Collections.sort(productType);
		model.addAttribute("productType", productType);
		return "AddingForm";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(Intermediate temp) throws IOException {
		Product product = ProductFactory.getProduct(temp);
		SaveProductImage.saveImage(temp.getImage(), "C:\\Users\\Admin\\eclipse-workspace2\\Amazon\\src\\main\\webapp\\WEB-INF\\images");
		this.service.addProduct(product);
		return "AddProductDone";
	}
	
	@GetMapping("/getSearchForm")
	public String getUpdateForm(@RequestParam String action, Model model) {
		if(action.equals("update")) {
			model.addAttribute("destination", "UpdateForm");
		}
		else {
			model.addAttribute("destination", "GetOrRemoveForm");
		}
		return "SearchForm";
	}
	
	@PostMapping("/findProductById")
	public String findProductById(@RequestParam int productId, HttpServletRequest request, ModelMap model) {
		Optional<Product> temp = this.service.findProductById(productId);
		if(temp.isEmpty()) {
			model.addAttribute("error", "No products found, please try again");
			return "SearchForm";
		}
		else {
			Product product = temp.get();
			if(product instanceof Book) {
				Book book = (Book) product;
				model.addAttribute("product", book);
			}
			else if(product instanceof Mouse) {
				Mouse mouse = (Mouse) product;
				model.addAttribute("product", mouse);
			}
			else if(product instanceof Keyboard) {
				Keyboard keyboard = (Keyboard) product;
				model.addAttribute("product", keyboard);
			}
			else if(product instanceof Meat) {
				Meat meat = (Meat) product;
				model.addAttribute("product", meat);
			}
			else if(product instanceof Milk) {
				Milk milk = (Milk) product;
				model.addAttribute("product", milk);
			}
			else {
				Vegetable vegetable = (Vegetable) product;
				model.addAttribute("product", vegetable);
			}
		}
		return request.getParameter("destination");
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(Intermediate temp) throws IOException {
		Product product = ProductFactory.getProduct(temp);
		product.markNotNew();
		product.setProductId(temp.getProductId());
		SaveProductImage.saveImage(product.getImage(), "C:\\Users\\Admin\\eclipse-workspace2\\Amazon\\src\\main\\webapp\\WEB-INF\\images");
		this.service.updateProduct(product);
		return "UpdateProductDone";
	}
	
	@PostMapping("/removeProduct")
	public String removeProduct(@RequestParam String productId) {
		this.service.removeProduct(Integer.parseInt(productId));
		return "RemoveProductDone";
	}
	
}






































