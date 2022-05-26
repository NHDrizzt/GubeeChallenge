package testinho.dao;

import testinho.service.ProdutoService;

public class ApplicationRepositoryClient {

	private ProdutoRepositoryInMemory produtoInMemory;
	private ProdutoRepository produtoRepository;
	
	public ApplicationRepositoryClient(AbstractDaoFactory factory) {
		produtoRepository = factory.criarBanco();
	}
	
	public void bancoTest() {
		produtoRepository.databaseImplementation(null, null);
	}
}
