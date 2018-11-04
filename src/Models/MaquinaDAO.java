package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinaDAO {
	public boolean insertMaquina(MaquinaVO maquina) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "insert into Maquinas (Descricao, Kwh) values (?,?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, maquina.getDescricao() );
			pst.setFloat(2, maquina.getKwh());
			int adicionado = pst.executeUpdate();
			return adicionado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<MaquinaVO> getListaMaquinas() {
		ArrayList<MaquinaVO> lista = new ArrayList<MaquinaVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from Maquinas";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				MaquinaVO maq = new MaquinaVO(rs.getInt("Id"),rs.getString("Descricao"),rs.getFloat("Kwh"));
				lista.add(maq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
}
