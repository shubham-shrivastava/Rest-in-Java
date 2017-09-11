package org.shubham.wingify.store.databases;

import java.util.HashMap;
import java.util.Map;

import org.shubham.wingify.store.model.Product;

public class DatabaseStub {
	private static Map<Long, Product> products = new HashMap<>();

	public static Map<Long, Product> getProducts() {
		return products;
	}
	
}
