package br.com.gpmodontosystem.persistence.dao;

/***
 * @author gilson
 * Inteface com o CRUD b�sico, que dever� ser implementado por todas as classes DAO.
 */
public interface ICrudDao<Classe> {
	
	public void inserir(Classe c) throws Exception;
	
	public Classe consultarPeloId(Classe c) throws Exception;
	
	public void alterar(Classe c) throws Exception;
	
	public void deletar(Classe c) throws Exception;

}
