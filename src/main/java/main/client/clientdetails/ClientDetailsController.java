package main.client.clientdetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.order.BillService;
import main.model.user.Client;

@Controller
@RequestMapping("/clientDetails")
public class ClientDetailsController {
	@Autowired
	private BillService billService;
	
	@GetMapping("/getOptions")
	public String getOptions() {
		return "OptionsView";
	}
	
	@GetMapping("/getHistory")
	public String getHistory(HttpServletRequest request, Model model) {
		HttpSession session = null;
		Client client = null;
		synchronized(session = request.getSession()) {
			client = (Client) session.getAttribute("account");
		}
		model.addAttribute("history", this.billService.getBills(client.getUserEmail()));
		return "HistoryView";
	}
	
}



































































