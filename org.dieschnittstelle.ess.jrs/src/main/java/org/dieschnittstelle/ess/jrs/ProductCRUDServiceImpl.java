package org.dieschnittstelle.ess.jrs;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.core.Context;
import org.dieschnittstelle.ess.entities.GenericCRUDExecutor;
import org.dieschnittstelle.ess.entities.crm.StationaryTouchpoint;
import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

import java.util.List;

/*
 * TODO JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDServiceImpl implements IProductCRUDService {

	private GenericCRUDExecutor<AbstractProduct> productCRUD;
	public ProductCRUDServiceImpl(@Context ServletContext servletContext) {
		this.productCRUD = (GenericCRUDExecutor<AbstractProduct>) servletContext.getAttribute("productCRUD");
	}

	@Override
	public AbstractProduct createProduct(
			AbstractProduct prod) {
		return productCRUD.createObject(prod);
	}

	@Override
	public List<AbstractProduct> readAllProducts() {
		return productCRUD.readAllObjects();
	}

	@Override
	public AbstractProduct updateProduct(long id, AbstractProduct update) {
		return productCRUD.updateObject(update);
	}

	@Override
	public boolean deleteProduct(long id) {
		return productCRUD.deleteObject(id);
	}

	@Override
	public AbstractProduct readProduct(long id) {
		return productCRUD.readObject(id);
	}
	
}
