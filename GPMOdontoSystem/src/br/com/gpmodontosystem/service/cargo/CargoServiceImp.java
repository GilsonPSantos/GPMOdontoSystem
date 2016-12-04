package br.com.gpmodontosystem.service.cargo;

import java.util.List;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.persistence.cargodao.CargoDaoImp;
import br.com.gpmodontosystem.persistence.cargodao.ICargoDao;

public class CargoServiceImp implements ICargoService{

	private ICargoDao icargoDao;
	
	public CargoServiceImp() {
		icargoDao = new CargoDaoImp();
	}
	
	@Override
	public void inserir(Cargo c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cargo consultarPeloId(Cargo c) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Cargo c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Cargo c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cargo> listarCargos() throws Exception {
		return icargoDao.listarCargos();
	}

}
