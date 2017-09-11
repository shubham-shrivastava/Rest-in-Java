package org.shubham.wingify.store.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.shubham.wingify.store.databases.DatabaseStub;
import org.shubham.wingify.store.exception.DataNotFoundException;
import org.shubham.wingify.store.model.Product;

public class ProductService {
	private Map<Long, Product> products = DatabaseStub.getProducts();
	
	public ProductService(){
		products.put(1L, new Product(1L, "Product1", 25.23, "DescriptionOfP1"));
		products.put(2L, new Product(2L, "Product2", 56.00, "DescriptionOfP2"));
	}
	
	public ArrayList<Product> getAllProducts(){
		return new ArrayList<>(products.values());
	}
	
	public List<Product> getAllProductForYear(int year) {
		List<Product> productForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Product product : products.values()){
			calendar.setTime(product.getAddedOn());
			if(calendar.get(Calendar.YEAR)==year){
				productForYear.add(product);
			}
		}
		return productForYear;
	}
	
	public List<Product> getAllProductsPaginated(int start, int limit) {
		List<Product> allProducts = new ArrayList<>(products.values());
		if(start+limit > allProducts.size()) return new ArrayList<Product>();
		return allProducts.subList(start, start+limit);
		
	}
	
	public Product getProduct(long id){
		Product product = products.get(id);
		if(product == null)
			throw new DataNotFoundException("Product with id " + id + " Doesn't Exist.");
		return products.get(id);
	}
	
	public Product addProduct(Product product){
		product.setId(products.size() + 1);
		products.put(product.getId(), product);
		return product;
	}
	
	public Product updateProduct(Product product){
		if(product.getId()==0)
			return null;
		products.put(product.getId(), product);
		return product;
	}
	
	public Product removeProduct(long id){
		Product product = products.get(id);
		if(product == null)
			throw new DataNotFoundException("Product with id " + id + " Doesn't Exist.");
		return products.remove(id);
		
	}
}
