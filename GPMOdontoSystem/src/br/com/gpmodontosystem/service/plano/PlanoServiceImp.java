package br.com.gpmodontosystem.service.plano;

import java.util.List;

import br.com.gpmodontosystem.model.Plano;
import br.com.gpmodontosystem.persistence.planodao.IPlanoDao;
import br.com.gpmodontosystem.persistence.planodao.PlanoDaoImp;

public class PlanoServiceImp implements IPlanoService{

	private IPlanoDao planoDao;
	
	public PlanoServiceImp() {
		planoDao = new PlanoDaoImp();
	}
	
	@Override
	public void inserir(Plano p) throws Exception {
		planoDao.inserir(p);
	}

	@Override
	public Plano consultarPeloId(Plano p) throws Exception {
		return planoDao.consultarPeloId(p);
	}

	@Override
	public void alterar(Plano p) throws Exception {
		planoDao.alterar(p);
	}

	@Override
	public void deletar(Plano p) throws Exception {
		planoDao.deletar(p);
	}

	@Override
	public List<Plano> listarPlanos() throws Exception {
		return planoDao.listarPlanos();
	}

}
