package br.com.gpmodontosystem.persistence.planodao;

import java.util.ArrayList;
import java.util.List;

import br.com.gpmodontosystem.model.Plano;
import br.com.gpmodontosystem.persistence.dao.DaoImpl;

public class PlanoDaoImp extends DaoImpl implements IPlanoDao {

	@Override
	public void inserir(Plano p) throws Exception {
		open();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO PLANO (PL_CONVENIO) VALUES (?)");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, p.getNomePlano());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public Plano consultarPeloId(Plano p) throws Exception {
		open();
		String sql = "SELECT PL_CODIGO, PL_CONVENIO FROM PLANO WHERE PL_CODIGO = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, p.getIdPlano());
		rs = stmt.executeQuery();
		Plano plano = null;
		if(rs.next()){
			plano = new Plano();
			plano.setIdPlano(rs.getInt("PL_CODIGO"));
			plano.setNomePlano(rs.getString("PL_CONVENIO"));
		}
		stmt.close();
		rs.close();
		close();
		return plano;
	}

	@Override
	public void alterar(Plano p) throws Exception {
		open();
		String sql = "UPDATE PLANO SET PL_CONVENIO = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, p.getNomePlano());
		stmt.execute();
		stmt.close();
		close();
	}

	@Override
	public void deletar(Plano p) throws Exception {
		open();
			String sql = "DELETE FROM PLANO WHERE PL_CODIGO = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, p.getIdPlano());
			stmt.execute();
			stmt.close();
		close();
	}

	@Override
	public List<Plano> listarPlanos() throws Exception {
		open();
			String sql = "SELECT PL_CODIGO, PL_CONVENIO FROM PLANO";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Plano> lst = new ArrayList<>();
			while(rs.next()){
				Plano plano = new Plano();
				plano.setIdPlano(rs.getInt("PL_CODIGO"));
				plano.setNomePlano(rs.getString("PL_CONVENIO"));
				lst.add(plano);
			}
			stmt.close();
			rs.close();
		close();
		return lst;
	}
	
//	public static void main(String[] args) {
//		try {
//			IPlanoDao pd = new PlanoDaoImp();
//			Plano p1 = new Plano(null,"Bradesco");
//			Plano p2 = new Plano(null,"Unimed");
//			Plano p3 = new Plano(null,"Sulamerica");
//			pd.inserir(p1);
//			pd.inserir(p2);
//			pd.inserir(p3);
//			System.out.println("Ok..");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
