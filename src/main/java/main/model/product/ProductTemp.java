package main.model.product;

import java.util.List;

public class ProductTemp {
	private String productType;
	private String sortOption;
	private List<String> categoryOption;
	private List<String> brandOption;
	private List<String> originOption;
	private List<String> authorOption;
	private List<String> publisherOption;
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getSortOption() {
		return sortOption;
	}
	
	public void setSortOption(String sortOption) {
		this.sortOption = sortOption;
	}
	
	public List<String> getCategoryOption() {
		return categoryOption;
	}
	
	public void setCategoryOption(List<String> categoryOption) {
		this.categoryOption = categoryOption;
	}
	
	public List<String> getBrandOption() {
		return brandOption;
	}
	
	public void setBrandOption(List<String> brandOption) {
		this.brandOption = brandOption;
	}
	
	public List<String> getOriginOption() {
		return originOption;
	}
	
	public void setOriginOption(List<String> originOption) {
		this.originOption = originOption;
	}
	
	public List<String> getAuthorOption() {
		return authorOption;
	}
	
	public void setAuthorOption(List<String> authorOption) {
		this.authorOption = authorOption;
	}
	
	public List<String> getPublisherOption() {
		return publisherOption;
	}
	
	public void setPublisherOption(List<String> publisherOption) {
		this.publisherOption = publisherOption;
	}

}
