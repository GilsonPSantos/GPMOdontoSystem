package br.com.gpmodontosystem.persistence.dao;

public interface IDao {
	
	/***
	 * @throws Exception
	 * Método para abrir uma conexão com o banco de dados
	 */
	public void open() throws Exception;
	
	/***
	 * @throws Exception
	 * Método para fechar uma conexão
	 */
	public void close() throws Exception;

}
