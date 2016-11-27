package br.com.gpmodontosystem.service.plano;

import java.util.List;

import br.com.gpmodontosystem.model.Plano;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface IPlanoService extends ICrudDao<Plano>{

	public List<Plano> listarPlanos() throws Exception;
	
}
