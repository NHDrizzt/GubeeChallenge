package testinho.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import testinho.annotation.Transaction;
import testinho.model.Product;

public class ProductRepositoryProxy implements ProductRepository {

	private final ProductRepository productRepository;
	
	public ProductRepositoryProxy(ProductRepository productRepository) {
		Objects.requireNonNull(productRepository, "productRepository is required");
		this.productRepository = productRepository;
	}
	
	@Override
	public Set<Product> listProductByMarketAndStack(String sqlMarket, String sqlStack) {
		Set<Product> listProducts = null;
		try {
			Arrays.stream(this.productRepository.getClass().getMethods()).filter(it -> it.isAnnotationPresent(Transaction.class)).findAny().ifPresent(it -> {
				System.out.println("Iniciando execucao do metodo " + it.getName());
			});
			listProducts = productRepository.listProductByMarketAndStack(sqlMarket, sqlStack);
		}
		catch(Exception e){
			System.out.println("Finalizando execucao do metodo com erro " + e.getMessage());
		}
		finally {
			System.out.println("Finalizando execução do metodo com sucesso");
		}
		return Objects.requireNonNullElse(listProducts, Set.of());
	}
}
