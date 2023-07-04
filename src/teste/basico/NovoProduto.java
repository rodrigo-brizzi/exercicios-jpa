package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		//Produto produto = new Produto("Caneta", 7.45);
		//dao.abrirT().incluir(produto).fecharT().fechar();
		
		//Produto notebook = new Produto("Notebook", 5365.69);
		//dao.incluirAtomico(notebook).fechar();
		
		Produto monitor = new Produto("Monitor", 1230.89);
		dao.incluirAtomico(monitor).fechar();
		
		System.out.println("Id do produto: " + monitor.getId());
		
	}
}
