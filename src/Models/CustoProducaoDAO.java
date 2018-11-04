package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustoProducaoDAO {
	public boolean insertCusto(CustoProducaoVO custo) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "insert into CustoProducao (IdProduto,TipoCusto,Descricao,ValorCusto) "
				+ "values (?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, custo.getCodigoProduto() );
			pst.setFloat(2, custo.getTipoCusto());
			pst.setString(3, custo.getDescricao() );
			pst.setFloat(4, custo.getValorCusto());
			int adicionado = pst.executeUpdate();
			return adicionado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<CustoProducaoVO> getListaCustos() {
		ArrayList<CustoProducaoVO> lista = new ArrayList<CustoProducaoVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from CustoProducao";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				CustoProducaoVO custo = new CustoProducaoVO(rs.getInt("Id"),rs.getInt("IdProduto"),
						rs.getInt("TipoCusto"),rs.getString("Descricao"),rs.getFloat("ValorCusto"));
				lista.add(custo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
}
