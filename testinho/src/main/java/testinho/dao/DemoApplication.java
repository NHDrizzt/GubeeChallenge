package testinho.dao;

public class DemoApplication {

	public static ApplicationRepositoryClient configureApplication() {
		ApplicationRepositoryClient app;
		AbstractDaoFactory factory;
		factory = new ProdutoRepositoryInMemoryFactory();
		app = new ApplicationRepositoryClient(factory);
		return null;
	}
	
	public static void main(String[] args) {
		ApplicationRepositoryClient app = configureApplication();

	}
}
