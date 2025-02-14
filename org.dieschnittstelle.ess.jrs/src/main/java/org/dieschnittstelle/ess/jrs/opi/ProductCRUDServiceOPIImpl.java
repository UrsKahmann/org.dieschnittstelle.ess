package org.dieschnittstelle.ess.jrs.opi;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import org.dieschnittstelle.ess.entities.crm.StationaryTouchpoint;
import org.dieschnittstelle.ess.entities.erp.Campaign;
import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.ess.jrs.IProductCRUDService;
import org.dieschnittstelle.ess.jrs.ProductCRUDServiceImpl;
import org.dieschnittstelle.ess.jrs.TouchpointCRUDServiceImpl;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

/*
 * TODO OPI1: Statten Sie diese Klasse so mit JAX-RS Annotationen aus, dass  alle Methoden
 *  im Rahmen der server-seitigen Web API aufrufbar sind. Sie koennen dafuer weitgehend
 *  die Annotationen uebernehmen, die Sie fuer IProductCRUDService in JRS genutzt haben.
 *  Zugegriffen wird auf diese Implementierung aus dem Testcase TestProductRESTServiceWithOpenAPI
 */
// TODO: verwenden Sie die URI opi/products
@Path("opi/products")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProductCRUDServiceOPIImpl {

	private IProductCRUDService service;

	public ProductCRUDServiceOPIImpl() {

	}

	/*
	 * TODO: implementieren Sie einen weiteren Konstruktor, der es Ihnen erlaubt, das service Attribut
	 *  so zu instantiieren, dass es zur Laufzeit erfolgreich verwendet werden kann
	 */
	public ProductCRUDServiceOPIImpl(@Context ServletContext servletContext) {
		this.service = new ProductCRUDServiceImpl(servletContext);
	}

	@POST
	@Operation(operationId = "createProduct")
	public IndividualisedProductItem createProduct(
			IndividualisedProductItem prod) {
		return (IndividualisedProductItem)this.service.createProduct(prod);
	}

	// TODO: ueberlegen Sie, wie Sie createCampaign() von createProduct() unterscheidbar machen koennen - wenn
	//  Sie JRS3 umgesetzt haben, koennen Sie die derzeit noch auskommentierte Codezeile aktivieren
	@POST
	@Path("/campaigns")
	@Operation(operationId = "createCampaign")
	public Campaign createCampaign(
			Campaign prod) {
		return (Campaign) this.service.createProduct(prod);
	}

	@GET
	@Operation(operationId = "readAllProducts")
	public List<IndividualisedProductItem> readAllProducts() {
		return (List)this.service.readAllProducts()
				.stream()
				.filter(prod -> prod instanceof IndividualisedProductItem)
				.collect(Collectors.toList());
	}

	@PUT
	@Operation(operationId = "updateProduct")
	public IndividualisedProductItem updateProduct(
			IndividualisedProductItem update) {
		return (IndividualisedProductItem)this.service.updateProduct(update.getId(), update);
	}

	@DELETE
	@Path("/{id}")
	@Operation(operationId = "deleteProduct")
	public boolean deleteProduct(@PathParam("id") long id) {
		return this.service.deleteProduct(id);
	}

	@GET
	@Path("/{id}")
	@Operation(operationId = "readProduct")
	public IndividualisedProductItem readProduct(@PathParam("id") long id) {
		IndividualisedProductItem item = (IndividualisedProductItem)this.service.readProduct(id);
		return item;
	}

}
