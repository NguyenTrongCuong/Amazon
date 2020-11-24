package main.client.clientservice;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.model.product.Book;
import main.model.product.Food;
import main.model.product.GamingGear;
import main.model.product.Product;
import main.model.product.ProductTemp;
import main.model.product.repository.ProductService;

@Controller
@RequestMapping("/clientService")
public class ClientService {
	@Autowired
	private ProductService productService;
	
	private Object[] getProductCategory(String productType) {
		return this.productService.getProductCategory(productType);
	}
	
	private Object[] getGamingGearBrand() {
		return this.productService.getGamingGearBrand();
	}
	
	private Object[] getFoodOrigin() {
		return this.productService.getFoodOrigin();
	}
	
	private Object[] getBookAuthor() {
		return this.productService.getBookAuthor();
	}
	
	private Object[] getBookPublisher() {
		return this.productService.getBookPublisher();
	}
	
	@GetMapping("/getProduct")
	public String getProduct(@RequestParam String productType, HttpServletRequest request, Model model) {
		HttpSession session = null;
		Pageable firstPage = PageRequest.of(0, 2);
		Page<Product> page = this.productService.getProductByPage(productType, firstPage);
		if(productType.equals("GamingGear")) {
			synchronized(session = request.getSession()) {
				session.setAttribute("productCategory", this.getProductCategory(productType));
				session.setAttribute("brand", this.getGamingGearBrand());
				session.setAttribute("page", page);
			}
		}
		else if(productType.equals("Food")) {
			synchronized(session = request.getSession()) {
				session.setAttribute("productCategory", this.getProductCategory(productType));
				session.setAttribute("origin", this.getFoodOrigin());
				session.setAttribute("page", page);
			}
		}
		else if(productType.equals("Book")) {
			synchronized(session = request.getSession()) {
				session.setAttribute("productCategory", this.getProductCategory(productType));
				session.setAttribute("author", this.getBookAuthor());
				session.setAttribute("publisher", this.getBookPublisher());
				session.setAttribute("page", page);
			}
		}
		model.addAttribute("productlist", page.getContent());
		model.addAttribute("pageNumber", page.getNumber() + 1);
		model.addAttribute("productType", productType);
		model.addAttribute("totalPages", page.getTotalPages());
		return "ProductView";
	}
	
	@GetMapping("/getNextPage")
	public String getNextPage(@RequestParam String productType,
							  @RequestParam String nextOrPrevious,
							  HttpServletRequest request,
							  Model model) {
		HttpSession session = null;
		Page<Product> page = null;
		Pageable nextPage = null;
		synchronized(session = request.getSession()) {
			page = (Page<Product>) session.getAttribute("page");
		}
		if(nextOrPrevious.equals("next")) {
			nextPage = page.nextPageable();
		}
		else nextPage = page.previousPageable();
		Page<Product> newPage = this.productService.getProductByPage(productType, nextPage);
		synchronized(session = request.getSession()) {
			session.setAttribute("page", newPage);
		}
		model.addAttribute("productlist", newPage.getContent());
		model.addAttribute("pageNumber", newPage.getNumber() + 1);
		model.addAttribute("productType", productType);
		model.addAttribute("totalPages", newPage.getTotalPages());
		return "ProductView";
	}
	
	@PostMapping("/getSortedProduct")
	public String getProductSorted(ProductTemp temp, HttpServletRequest request, Model model) {
		HttpSession session = null;
		Pageable nextPage = null;
		String categoryFilter = "", productFilter = "";
		if(temp.getSortOption().equals("None")) {
			nextPage = PageRequest.of(0, 2);
		}
		else if(temp.getSortOption().equals("High to low")) {
			nextPage = PageRequest.of(0, 2, Sort.by("productPrice").descending());
		}
		else nextPage = PageRequest.of(0, 2, Sort.by("productPrice").ascending());
		if(temp.getCategoryOption() == null) {
			synchronized(session = request.getSession()) {
				Object[] arr1 = (Object[]) session.getAttribute("productCategory");
				String[] arr2 = Arrays.copyOf(arr1, arr1.length, String[].class);
				temp.setCategoryOption(Arrays.asList(arr2));
			}
		}
		for(String ele : temp.getCategoryOption()) {
			categoryFilter += ele + "  ";
		}
		synchronized(session = request.getSession()) {
			if(temp.getProductType().equals("GamingGear")) {
				if(temp.getBrandOption() == null) {
					Object[] arr1 = (Object[]) session.getAttribute("brand");
					String[] arr2 = Arrays.copyOf(arr1, arr1.length, String[].class);
					temp.setBrandOption(Arrays.asList(arr2));
				}
				for(String ele : temp.getBrandOption()) {
					productFilter += ele + "  ";
				}
				Page<GamingGear> page = this.productService.getSortedGamingGear(temp.getProductType(),
																				temp.getCategoryOption(),
																				temp.getBrandOption(),
																				nextPage);
				session.setAttribute("page", page);
				session.setAttribute("brandOption", temp.getBrandOption());
				model.addAttribute("productlist", page.getContent());
				model.addAttribute("pageNumber", page.getNumber() + 1);
				model.addAttribute("productType", temp.getProductType());
				model.addAttribute("totalPages", page.getTotalPages());
			}
			else if(temp.getProductType().equals("Food")) {
				if(temp.getOriginOption() == null) {
					Object[] arr1 = (Object[]) session.getAttribute("origin");
					String[] arr2 = Arrays.copyOf(arr1, arr1.length, String[].class);
					temp.setOriginOption(Arrays.asList(arr2));
				}
				for(String ele : temp.getOriginOption()) {
					productFilter += ele + "  ";
				}
				Page<Food> page = this.productService.getSortedFood(temp.getProductType(),
																	temp.getCategoryOption(),
																	temp.getOriginOption(),
																	nextPage);
				session.setAttribute("page", page);
				session.setAttribute("originOption", temp.getOriginOption());
				model.addAttribute("productlist", page.getContent());
				model.addAttribute("pageNumber", page.getNumber() + 1);
				model.addAttribute("productType", temp.getProductType());
				model.addAttribute("totalPages", page.getTotalPages());
			}
			else if(temp.getProductType().equals("Book")) {
				if(temp.getAuthorOption() == null) {
					Object[] arr1 = (Object[]) session.getAttribute("author");
					String[] arr2 = Arrays.copyOf(arr1, arr1.length, String[].class);
					temp.setAuthorOption(Arrays.asList(arr2));
				}
				for(String ele : temp.getAuthorOption()) {
					productFilter += ele + "  ";
				}
				if(temp.getPublisherOption() == null) {
					Object[] arr1 = (Object[]) session.getAttribute("publisher");
					String[] arr2 = Arrays.copyOf(arr1, arr1.length, String[].class);
					temp.setPublisherOption(Arrays.asList(arr2));
				}
				for(String ele : temp.getPublisherOption()) {
					productFilter += ele + "  ";
				}
				Page<Book> page = this.productService.getSortedBook(temp.getProductType(),
																	temp.getCategoryOption(),
																	temp.getAuthorOption(),
																	temp.getPublisherOption(),
																	nextPage);
				session.setAttribute("page", page);
				session.setAttribute("authorOption", temp.getAuthorOption());
				session.setAttribute("publisherOption", temp.getPublisherOption());
				model.addAttribute("productlist", page.getContent());
				model.addAttribute("pageNumber", page.getNumber() + 1);
				model.addAttribute("productType", temp.getProductType());
				model.addAttribute("totalPages", page.getTotalPages());
			}
			session.setAttribute("categoryFilter", categoryFilter);
			session.setAttribute("productFilter", productFilter);
			session.setAttribute("categoryOption", temp.getCategoryOption());
		}
		return "ProductView2";
	}
	
	@GetMapping("/getSortedProductNextPage")
	public String getSortedProductNextPage(@RequestParam String productType,
										   @RequestParam String nextOrPrevious,
										   HttpServletRequest request,
										   Model model) {
		HttpSession session = null;
		Pageable newPage = null;
		Page<GamingGear> gamingGearPage = null;
		Page<Food> foodPage = null;
		Page<Book> bookPage = null;
		if(productType.equals("GamingGear")) {
			synchronized(session = request.getSession()) {
				gamingGearPage = (Page<GamingGear>) session.getAttribute("page");
				if(nextOrPrevious.equals("next")) {
					newPage = gamingGearPage.nextPageable();
				}
				else newPage = gamingGearPage.previousPageable();
				gamingGearPage = this.productService.getSortedGamingGear(productType,
																		 (List<String>) session.getAttribute("categoryOption"),
																		 (List<String>) session.getAttribute("brandOption"),
																		 newPage);
				session.setAttribute("page", gamingGearPage);
			}
			model.addAttribute("productlist", gamingGearPage.getContent());
			model.addAttribute("pageNumber", gamingGearPage.getNumber() + 1);
			model.addAttribute("productType", productType);
			model.addAttribute("totalPages", gamingGearPage.getTotalPages());
		}
		else if(productType.equals("Food")) {
			synchronized(session = request.getSession()) {
				foodPage = (Page<Food>) session.getAttribute("page");
				if(nextOrPrevious.equals("next")) {
					newPage = foodPage.nextPageable();
				}
				else newPage = foodPage.previousPageable();
				foodPage = this.productService.getSortedFood(productType,
															 (List<String>) session.getAttribute("categoryOption"),
															 (List<String>) session.getAttribute("originOption"),
															 newPage);
				session.setAttribute("page", foodPage);
			}
			model.addAttribute("productlist", foodPage.getContent());
			model.addAttribute("pageNumber", foodPage.getNumber() + 1);
			model.addAttribute("productType", productType);
			model.addAttribute("totalPages", foodPage.getTotalPages());
		}
		else if(productType.equals("Book")) {
			synchronized(session = request.getSession()) {
				bookPage = (Page<Book>) session.getAttribute("page");
				if(nextOrPrevious.equals("next")) {
					newPage = bookPage.nextPageable();
				}
				else newPage = bookPage.previousPageable();
				bookPage = this.productService.getSortedBook(productType,
															 (List<String>) session.getAttribute("categoryOption"),
															 (List<String>) session.getAttribute("authorOption"),
															 (List<String>) session.getAttribute("publisher"),
															 newPage);
				session.setAttribute("page", bookPage);
			}
			model.addAttribute("productlist", bookPage.getContent());
			model.addAttribute("pageNumber", bookPage.getNumber() + 1);
			model.addAttribute("productType", productType);
			model.addAttribute("totalPages", bookPage.getTotalPages());
		}
		return "ProductView2";
	}
	
	@GetMapping("/removeFilters")
	public ModelAndView removeFilters(@RequestParam String productType, HttpServletRequest request, ModelMap model) {
		HttpSession session = null;
		synchronized(session = request.getSession()) {
			session.removeAttribute("categoryFilter");
			session.removeAttribute("productFilter");
			session.removeAttribute("categoryOption");
			if(productType.equals("GamingGear")) {
				session.removeAttribute("brandOption");
			}
			else if(productType.equals("Food")) {
				session.removeAttribute("originOption");
			}
			else if(productType.equals("Book")) {
				session.removeAttribute("authorOption");
				session.removeAttribute("publisherOption");
			}
		}
		model.addAttribute("productType", productType);
		return new ModelAndView("redirect:/clientService/getProduct", model);
	}
	
	@GetMapping("/getProductDetails")
	public String getProductDetails(@RequestParam int productId, @RequestParam String productCategory, Model model) {
		if(productCategory.equals("Mouse")) {
			model.addAttribute("productDetails", this.productService.getMouse(productId));
		}
		else if(productCategory.equals("Keyboard")) {
			model.addAttribute("productDetails", this.productService.getKeyboard(productId));
		}
		else if(productCategory.equals("Meat")) {
			model.addAttribute("productDetails", this.productService.getMeat(productId));
		}
		else if(productCategory.equals("Milk")) {
			model.addAttribute("productDetails", this.productService.getMilk(productId));
		}
		else if(productCategory.equals("Vegetable")) {
			model.addAttribute("productDetails", this.productService.getVegetable(productId));
		}
		else {
			model.addAttribute("productDetails", this.productService.getBook(productId));
		}
		return "ProductDetailsView";
	}
	
}















































