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
	
	public boolean updateProduto(ProdutoVO produto) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "update Produtos set Descricao = ?, PrecoVenda = ? where Id = ?";
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, produto.getDescricao() );
			pst.setFloat(2, produto.getPreco());
			pst.setInt(3, produto.getCodigo());
			int editado = pst.executeUpdate();
			return editado > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deleteProduto(int codigo) {
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "delete from Produtos where Id = ?";
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
	
	public ArrayList<ProdutoVO> getAllProdutos() {	
		return getListProdutos("");		
	}
	
	public ArrayList<ProdutoVO> getListProdutos(String descricao) {
		ArrayList<ProdutoVO> lista = new ArrayList<ProdutoVO>();
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from Produtos where Descricao like ?";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, "%"+descricao+"%");
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
	
	public ProdutoVO getProduto(int id) {
		ProdutoVO produto = null;
		Connection conexao =  ConexaoDb.getConexao();
		String sql = "select * from Produtos where Id = ?";	
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produto = new ProdutoVO(rs.getInt("Id"),rs.getString("Descricao"),rs.getFloat("PrecoVenda"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produto;
		
	}
}
