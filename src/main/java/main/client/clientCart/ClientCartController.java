package main.client.clientCart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.model.order.Bill;
import main.model.order.BillService;
import main.model.product.Product;
import main.model.product.repository.ProductService;
import main.model.shippingdetails.ShipService;
import main.model.shippingdetails.ShippingDetails;
import main.model.user.Client;
import main.model.user.User;
import main.model.user.userrepository.UserService;

@Controller
@RequestMapping("/clientCart")
public class ClientCartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShipService shipService;
	@Autowired
	private BillService billService;
	
	@GetMapping("/getCartDetails")
	public String getCartDetails() {
		return "ClientCartView";
	}
	
	@GetMapping("/doPayment")
	public String doPayment() {
		return "PaymentView";
	}
	
	@GetMapping("/processPayment")
	public String processPayment(@RequestParam String id, @RequestParam String quantity, @RequestParam long total, HttpServletRequest request) {
		Calendar calendar = Calendar.getInstance();
		HttpSession session = null;
		Client client = null;
		List<Integer> productId = new ArrayList<Integer>();
		List<Integer> productQuantity = new ArrayList<Integer>();
		List<Product> product = null;
		int numberOfOrders = 0, numberOfEmployee = 0;
		String[] arr = id.split(", ");
		String startDate = "", endDate = "";
		Date start = null, end = null;
		for(String ele : arr) {
			productId.add(Integer.parseInt(ele));
		}
		arr = quantity.split(", ");
		for(String ele : arr) {
			productQuantity.add(Integer.parseInt(ele));
		}
		synchronized(session = request.getSession()) {
			client = (Client) session.getAttribute("account");
		}
		for(int i = 0; i < productId.size(); ++i) {
			this.productService.updateProductByIdAndQuantity(productId.get(i), productQuantity.get(i));
		}
		product = this.productService.getListOfProduct(productId);
		numberOfEmployee = this.userService.countUsers();
		numberOfOrders = this.shipService.countUsers();
		startDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		endDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
		start = Date.valueOf(startDate);
		end = Date.valueOf(endDate);
		ShippingDetails shippingDetails = new ShippingDetails(start, end, client.getClientAddress(), this.userService.getUser(numberOfOrders % numberOfEmployee));
		Bill bill = new Bill(start, total, client, product);
		shippingDetails.setBill(bill);
		this.billService.saveBill(bill);
		this.shipService.saveShip(shippingDetails);
		return "PaymentDoneView";
	}
	
	
}




























































