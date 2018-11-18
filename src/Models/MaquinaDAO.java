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
	
	public boolean updateMaquina(MaquinaVO maquina) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "update Maquinas set Descricao = ?, Kwh = ? where Id = ?";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, maquina.getDescricao() );
			pst.setFloat(2, maquina.getKwh());
			pst.setInt(3, maquina.getCodigo());
			int editado = pst.executeUpdate();
			return editado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deleteMaquina(int codigo) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "delete from Maquinas where Id = ?";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, codigo );
			int exluido = pst.executeUpdate();
			return exluido > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<MaquinaVO> getAllMaquinas() {
		return getListMaquinas("");
		
	}
	
	public ArrayList<MaquinaVO> getListMaquinas(String filtro) {
		ArrayList<MaquinaVO> lista = new ArrayList<MaquinaVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from Maquinas where Descricao like ?";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, "%"+filtro+"%");
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
