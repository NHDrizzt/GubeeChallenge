package testinho.dao;

public class ProdutoRepositoryInMemoryFactory implements AbstractDaoFactory{

	@Override
	public ProdutoRepository criarBanco() {
		return new ProdutoRepositoryInMemory();
	} 
}
