package br.com.gpmodontosystem.persistence.dao;

/***
 * @author gilson
 * Inteface com o CRUD básico, que deverá ser implementado por todas as classes DAO.
 */
public interface ICrudDao {
	
	public void inserir() throws Exception;
	
	public void consultarPeloId() throws Exception;
	
	public void alterar() throws Exception;
	
	public void deletar() throws Exception;

}
