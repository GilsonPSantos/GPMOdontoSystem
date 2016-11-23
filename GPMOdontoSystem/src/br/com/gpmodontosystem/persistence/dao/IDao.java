package br.com.gpmodontosystem.persistence.dao;

public interface IDao {
	
	/***
	 * @throws Exception
	 * M�todo para abrir uma conex�o com o banco de dados
	 */
	public void open() throws Exception;
	
	/***
	 * @throws Exception
	 * M�todo para fechar uma conex�o
	 */
	public void close() throws Exception;

}
