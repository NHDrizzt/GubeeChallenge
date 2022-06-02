package testinho.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testinho.dao.AbstractDaoFactory;
import testinho.db.ControllerException;
import testinho.enums.TypeDatabase;
import testinho.model.Market;
import testinho.model.Product;
import testinho.model.Stack;
import testinho.service.ProductService;
import testinho.service.ProductServiceInMemory;
import testinho.service.ProductServiceJdbc;

public class ShowProductCommand extends FrontCommand {
	private static final String productType = "JDBC_PRODUCT";
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)  {
		AbstractDaoFactory abstractDaoFactory;
		ProductService productService;
		Set<Product> listResult = null;
		try {
			if(productType.contentEquals("JDBC_PRODUCT")){
				abstractDaoFactory = TypeDatabase.JDBC.getFactory();
				productService = new ProductServiceJdbc(abstractDaoFactory);
				listResult = productService.getMarketAndStack(listValuesByMarket(request), listValuesByStack(request));
			}
			if(productType.contentEquals("INMEMORY_PRODUCT")){
				abstractDaoFactory = TypeDatabase.MEMORY.getFactory();
				productService = new ProductServiceInMemory(abstractDaoFactory);
				listResult = productService.getMarketAndStack((listValuesByMarket(request)), listValuesByStack(request));
			}
			if(isNotNullOrEmpty(listResult)){
				request.setAttribute("products", listResult);
				forward("showProduct", request, response);
			}
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	}

	public List<Market> listValuesByMarket(HttpServletRequest request){
		List<Market> listOfValues = new ArrayList<>();
		String[] listOfValuesOfMarket = request.getParameterValues("anyMarket");
		if(isNotNullOrEmpty(listOfValuesOfMarket)){
			Arrays.stream(listOfValuesOfMarket).map(Market::new).forEach(listOfValues::add);
		}
		return listOfValues;
	}
	public List<Stack>  listValuesByStack(HttpServletRequest request){
		List<Stack> listOfValues = new ArrayList<>();
		String[] listOfValuesOfStack = request.getParameterValues("anyStack");
		if(isNotNullOrEmpty(listOfValuesOfStack)) {
			Arrays.stream(listOfValuesOfStack).map(Stack::new).forEach(listOfValues::add);
		}
		return listOfValues;
	}
	public static boolean isNotNullOrEmpty(String[] list) {
		return list != null && list.length != 0;
	}
	public static boolean isNotNullOrEmpty(Set<Product> list) {
		return list != null && !list.isEmpty();
	}
}
