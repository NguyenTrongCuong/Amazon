package main.model.product.factory;

import main.model.product.Book;
import main.model.product.Intermediate;
import main.model.product.Keyboard;
import main.model.product.Meat;
import main.model.product.Milk;
import main.model.product.Mouse;
import main.model.product.Product;
import main.model.product.Vegetable;

public class ProductFactory {
	
	public static Product getProduct(Intermediate temp) {
		temp.setImageLocation(temp.getImage().getOriginalFilename());
		if(temp.getProductType().equals("Book")) {
			return new Book(temp.getProductName(),
							temp.getProductType(),
							temp.getProductQuantity(), 
							temp.getProductCategory(),
							temp.getProductPrice(),
							temp.getImageLocation(),
							temp.getImage(),
							temp.getPublisher(),
							temp.getAuthor());
		}
		else if(temp.getProductCategory().equals("Mouse")) {
			return new Mouse(temp.getProductName(),
							 temp.getProductType(),
							 temp.getProductQuantity(), 
							 temp.getProductCategory(),
							 temp.getProductPrice(),
							 temp.getImageLocation(),
							 temp.getImage(),
							 temp.getBrand(),
							 temp.getDps());
		}
		else if(temp.getProductCategory().equals("Keyboard")) {
			return new Keyboard(temp.getProductName(),
					 	 		temp.getProductType(),
					 	 		temp.getProductQuantity(), 
					 	 		temp.getProductCategory(),
					 	 		temp.getProductPrice(),
					 	 		temp.getImageLocation(),
					 	 		temp.getImage(),
					 	 		temp.getBrand(),
					 	 		temp.getKeyAdventure());
		}
		else if(temp.getProductCategory().equals("Meat")) {
			return new Meat(temp.getProductName(),
		 	 				temp.getProductType(),
		 	 				temp.getProductQuantity(), 
		 	 				temp.getProductCategory(),
		 	 				temp.getProductPrice(),
		 	 				temp.getImageLocation(),
		 	 				temp.getImage(),
		 	 				temp.getOrigin(),
		 	 				temp.getQuantityUnit(),
		 	 				temp.getQuality());
		}
		else if(temp.getProductCategory().equals("Milk")) {
			return new Milk(temp.getProductName(),
 	 						temp.getProductType(),
 	 						temp.getProductQuantity(), 
 	 						temp.getProductCategory(),
 	 						temp.getProductPrice(),
 	 						temp.getImageLocation(),
 	 						temp.getImage(),
 	 						temp.getOrigin(),
 	 						temp.getQuantityUnit(),
 	 						temp.getExpiryDate());
		}
		else {
			return new Vegetable(temp.getProductName(),
								 temp.getProductType(),
								 temp.getProductQuantity(), 
								 temp.getProductCategory(),
								 temp.getProductPrice(),
								 temp.getImageLocation(),
								 temp.getImage(),
								 temp.getOrigin(),
								 temp.getQuantityUnit(),
								 temp.getFreshness());
		}
	}

}
























































































