package br.com.gpmodontosystem.service.cargo;

import java.util.List;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface ICargoService extends ICrudDao<Cargo>{
	
	public List<Cargo> listarCargos() throws Exception;

}
