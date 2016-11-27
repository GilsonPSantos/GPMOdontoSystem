package br.com.gpmodontosystem.persistence.planodao;

import java.util.List;

import br.com.gpmodontosystem.model.Plano;
import br.com.gpmodontosystem.persistence.dao.ICrudDao;

public interface IPlanoDao extends ICrudDao<Plano>{
	
	public List<Plano> listarPlanos() throws Exception;

}
