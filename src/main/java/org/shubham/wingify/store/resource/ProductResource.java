package org.shubham.wingify.store.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.shubham.wingify.store.model.Product;
import org.shubham.wingify.store.service.ProductService;

/**
*This is the sample documentation of the this rest api.
*@author Shubham Shrivastav
*@summary Perform CRUD Operation on the product of particular store
 */

@Path("/products")
@Produces(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Consumes(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class ProductResource {
	
	ProductService productService = new ProductService();
	
	@GET
	/**
	  *@servicetag products
	  *@param Year for which products are needed or start index and limit for products
	  *@returns	All products available in the db
	  *@statuscode 401 if right credentials are not given
	  *@title Get All Products
	
	 */
	public List<Product> getAllProducts(@QueryParam("year") int year, 
										@QueryParam("start") int start, @QueryParam("limit") int limit){
		
		if(year>0)
			return productService.getAllProductForYear(year);
		if(start>0 && limit > 0)
			return productService.getAllProductsPaginated(start, limit);
		return productService.getAllProducts();
	}
	
	@GET
	@Path("/{productId}")
	/**
	 *@servicetag product
	 *@param Product id of the desired product
	 *@returns Product with the given id
	 *@statuscode 401 if right credentials are not given
	 */
	public Product getProduct(@PathParam("productId") long productId){
		return productService.getProduct(productId);
	}
	
	@PUT
	@Path("/{productId}")
	/**
	 *@servicetag Update
	 *@param Product id of the desired product
	 *@returns updated product with the given id
	 *@statuscode 401 if right credentials are not given
	 */
	public Product updateProduct(@PathParam("productId") long productId, Product product){
		product.setId(productId);
		return productService.updateProduct(product);
	}
	
	@POST
	/**
	 *@servicetag addProduct
	 *@param Product to be added
	 *@returns added product
	 *@statuscode 401 if right credentials are not given
	 */
	public Response addProduct(Product product, @Context UriInfo uriInfo){
		Product newProduct = productService.addProduct(product);
		String id = String.valueOf(newProduct.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(uri).entity(newProduct).build();
	}
	
	@DELETE
	@Path("/{productId}")
	/**
	 *@servicetag delete product
	 *@param Product id of the desired product
	 *@returns None
	 *@statuscode 401 if right credentials are not given
	 */
	public void removeProduct(@PathParam("productId") int id){
		productService.removeProduct(id);
		
	}
	
}
