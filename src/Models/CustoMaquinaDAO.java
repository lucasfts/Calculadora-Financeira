package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustoMaquinaDAO {
	public boolean insertCusto(CustoMaquinaVO custo) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "insert into CustoProducao (IdProduto,IdMaquina,TempoUnitario) "
				+ "values (?,?,?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, custo.getCodigoProduto() );
			pst.setInt(2, custo.getCodigoMaquina());
			pst.setFloat(3, custo.getTempoUnitario() );
			int adicionado = pst.executeUpdate();
			return adicionado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<CustoMaquinaVO> getListaCustos() {
		ArrayList<CustoMaquinaVO> lista = new ArrayList<CustoMaquinaVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from CustoMaquina";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				CustoMaquinaVO custo = new CustoMaquinaVO(rs.getInt("Id"),rs.getInt("IdProduto"),
						rs.getInt("IdMaquina"),rs.getFloat("TempoUnitario"));
				lista.add(custo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
}
