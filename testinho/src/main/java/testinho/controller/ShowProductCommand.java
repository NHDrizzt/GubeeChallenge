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
import testinho.service.ProductServiceImpl;

public class ShowProductCommand extends FrontCommand {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)  {
		AbstractDaoFactory abstractDaoFactory;
		ProductService productService;
		Set<Product> listResult;
		try {
			abstractDaoFactory = TypeDatabase.DEFAULT.getDefaultFactory();
			productService = new ProductServiceImpl(abstractDaoFactory);
			listResult = productService.getMarketAndStack(listValuesByMarket(request), listValuesByStack(request));

			if(isNotNullOrEmpty(listResult)){
				request.setAttribute("products", listResult);
				forward("showProduct", request, response);
			}
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	}

	private List<Market> listValuesByMarket(HttpServletRequest request){
		List<Market> listOfValues = new ArrayList<>();
		String[] listOfValuesOfMarket = request.getParameterValues("anyMarket");
		if(isNotNullOrEmpty(listOfValuesOfMarket)){
			Arrays.stream(listOfValuesOfMarket).map(Market::new).forEach(listOfValues::add);
		}
		return listOfValues;
	}
	private List<Stack>  listValuesByStack(HttpServletRequest request){
		List<Stack> listOfValues = new ArrayList<>();
		String[] listOfValuesOfStack = request.getParameterValues("anyStack");
		if(isNotNullOrEmpty(listOfValuesOfStack)) {
			Arrays.stream(listOfValuesOfStack).map(Stack::new).forEach(listOfValues::add);
		}
		return listOfValues;
	}
	private static boolean isNotNullOrEmpty(String[] list) {
		return list != null && list.length != 0;
	}
	private static boolean isNotNullOrEmpty(Set<Product> list) {
		return list != null && !list.isEmpty();
	}
}
