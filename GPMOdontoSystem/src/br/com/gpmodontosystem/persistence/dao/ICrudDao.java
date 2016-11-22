package br.com.gpmodontosystem.persistence.dao;

/***
 * @author gilson
 * Inteface com o CRUD básico, que deverá ser implementado por todas as classes DAO.
 */
public interface ICrudDao<Classe> {
	
	public void inserir(Classe c) throws Exception;
	
	public void consultarPeloId(Classe c) throws Exception;
	
	public void alterar(Classe c) throws Exception;
	
	public void deletar(Classe c) throws Exception;

}
