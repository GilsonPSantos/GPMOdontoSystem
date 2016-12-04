package br.com.gpmodontosystem.persistence.cargodao;

import java.util.List;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface ICargoDao extends ICrudDao<Cargo>{
	
	public List<Cargo> listarCargos() throws Exception;

}
