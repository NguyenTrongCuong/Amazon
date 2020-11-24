package main.client.searchengine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.product.Product;

@Controller
@RequestMapping("/searchResult")
public class SearchResultController {
	
	@GetMapping("/getSearchResult")
	public String getSearchReslut(HttpServletRequest request, Model model) {
		HttpSession session = null;
		synchronized(session = request.getSession()) {
			model.addAttribute("searchResult", (List<Product>) session.getAttribute("findResult"));
			session.removeAttribute("findResult");
		}
		return "SearchResultView";
	}
	
}
