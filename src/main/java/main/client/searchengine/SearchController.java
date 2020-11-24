package main.client.searchengine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.model.product.Product;
import main.model.product.repository.ProductService;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private ProductService service;
	
	@PostMapping(value="/findProduct", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Product> findProduct(@RequestParam String keyword, HttpServletRequest request) {
		HttpSession session = null;
		List<Product> searchResult = this.service.getProductByKeyWord(keyword);
		synchronized(session = request.getSession()) {
			session.setAttribute("findResult", searchResult);
		}
		return searchResult;
	}
	
}










































