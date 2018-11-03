package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
	public boolean insertProduto(ProdutoVO produto) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "insert into Produtos (Descricao, PrecoVenda) values (?,?)";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, produto.getDescricao() );
			pst.setFloat(2, produto.getPreco());
			int adicionado = pst.executeUpdate();
			return adicionado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<ProdutoVO> getListaProdutos() {
		ArrayList<ProdutoVO> lista = new ArrayList<ProdutoVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from Produtos";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ProdutoVO prod = new ProdutoVO(rs.getInt("Id"),rs.getString("Descricao"),rs.getFloat("PrecoVenda"));
				lista.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	}
}
