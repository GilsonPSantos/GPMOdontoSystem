package br.com.gpmodontosystem.persistence.cargodao;

import java.util.ArrayList;
import java.util.List;

import br.com.gpmodontosystem.model.Cargo;
import br.com.gpmodontosystem.persistence.dao.DaoImpl;

public class CargoDaoImp extends DaoImpl implements ICargoDao{

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
		open();
			String sql = "SELECT CAR_CODIGO, CAR_FUNCAO FROM CARGO";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Cargo cargo = null;
			List<Cargo> lst = new ArrayList<>();
			while(rs.next()){
				cargo = new Cargo();
				cargo.setIdCargo(rs.getInt("CAR_CODIGO"));
				cargo.setNomeCargo(rs.getString("CAR_FUNCAO"));
				lst.add(cargo);
			}
			stmt.close();
			rs.close();
		close();
		return lst;
	}

}
