package application;

import Models.*;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.ProdutoVO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TelaProdutosController {

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;
	
	@FXML
    private Button btnPesquisar;
	
	@FXML
    private TextField txtPesquisa;

	@FXML
	private TextField txtPrecoVenda;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtDescricao;

	@FXML
	private TableView<ProdutoVO> tblProdutos;

	@FXML
	private TableColumn<ProdutoVO, Integer> codigoCol;

	@FXML
	private TableColumn<ProdutoVO, String> descricaoCol;

	@FXML
	private TableColumn<ProdutoVO, Float> precoCol;

	@FXML
	private Button btnExcluir;

	public final ObservableList<ProdutoVO> data = FXCollections.observableArrayList();

	private Alert alertInfo = new Alert(AlertType.INFORMATION);
	
	private void populateTabelaProdutos() {
		populateTabelaProdutos("");
	}

	private void populateTabelaProdutos(String filtro) {
		data.clear();
		ProdutoDAO dao = new ProdutoDAO();
		if(filtro.isEmpty()) {
			for (ProdutoVO produto : dao.getListaProdutos()) {
				data.add(produto);
			}
		}
		else {
			for (ProdutoVO produto : dao.getListaProdutosComFiltro(filtro)) {
				data.add(produto);
			}
		}
		tblProdutos.setItems(data);
	}
	

	private void LimparCampos() {
		btnSalvar.setText("Adicionar");
		txtCodigo.setText(null);
		txtDescricao.setText(null);
		txtPrecoVenda.setText(null);
	}

	private void adicionarProduto() {
		try {
			ProdutoVO produto = new ProdutoVO();
			produto.setDescricao(txtDescricao.getText());
			produto.setPreco(Float.parseFloat(txtPrecoVenda.getText()));
			ProdutoDAO dao = new ProdutoDAO();
			if (dao.insertProduto(produto)) {
				alertInfo.setContentText("Produto adicionado com sucesso!");
				alertInfo.showAndWait();
				populateTabelaProdutos();
				LimparCampos();
			} else {
				alertInfo.setContentText("Erro ao adicionar produto!");
				alertInfo.showAndWait();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			alertInfo.setContentText(e.getMessage());
			alertInfo.showAndWait();
			e.printStackTrace();
		}
	}

	private void editarProduto() {
		try {
			ProdutoVO produto = new ProdutoVO();
			produto.setDescricao(txtDescricao.getText());
			produto.setPreco(Float.parseFloat(txtPrecoVenda.getText()));
			produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
			ProdutoDAO dao = new ProdutoDAO();
			if (dao.updateProduto(produto)) {
				alertInfo.setContentText("Produto editado com sucesso!");
				alertInfo.showAndWait();
				populateTabelaProdutos();
				LimparCampos();
			} else {
				alertInfo.setContentText("Erro ao editar produto!");
				alertInfo.showAndWait();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			alertInfo.setContentText(e.getMessage());
			alertInfo.showAndWait();
			e.printStackTrace();
		}
	}

	@FXML // basically works like an onload() method
	protected void initialize() {

		txtCodigo.setDisable(true);
		btnCancelar.setVisible(false);

		PropertyValueFactory<ProdutoVO, Integer> codigoProp = new PropertyValueFactory<ProdutoVO, Integer>("codigo");
		codigoCol.setCellValueFactory(codigoProp);

		PropertyValueFactory<ProdutoVO, String> descricaoProp = new PropertyValueFactory<ProdutoVO, String>(
				"descricao");
		descricaoCol.setCellValueFactory(descricaoProp);

		PropertyValueFactory<ProdutoVO, Float> precoProp = new PropertyValueFactory<ProdutoVO, Float>("preco");
		precoCol.setCellValueFactory(precoProp);

		populateTabelaProdutos();

		tblProdutos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				btnSalvar.setText("Salvar");
				txtCodigo.setText(String.valueOf(newSelection.getCodigo()));
				txtDescricao.setText(newSelection.getDescricao());
				txtPrecoVenda.setText(String.valueOf(newSelection.getPreco()));
				btnCancelar.setVisible(true);
			} else {
				LimparCampos();
				btnCancelar.setVisible(false);
			}
		});

	}

	@FXML
	void btnSalvar_Click(ActionEvent event) {
		if (txtCodigo.getText() != null && !txtCodigo.getText().isEmpty()) {
			editarProduto();
		} else {
			adicionarProduto();
		}
	}

	@FXML
	void btnExcluir_Click(ActionEvent event) {
		ProdutoVO produto = tblProdutos.getSelectionModel().getSelectedItem();
		if (produto != null) {
			ProdutoDAO dao = new ProdutoDAO();
			if (dao.deleteProduto(produto.getCodigo())) {
				alertInfo.setContentText("Produto exlcuido com sucesso!");
				alertInfo.showAndWait();
				populateTabelaProdutos();
				LimparCampos();
			} else {
				alertInfo.setContentText("Erro ao excluir produto!");
				alertInfo.showAndWait();
			}
		}
	}
	
	@FXML
    void btnCancelar_Click(ActionEvent event) {
		tblProdutos.getSelectionModel().clearSelection();
		LimparCampos();
    }
	
	@FXML
    void btnPesquisar_Click(ActionEvent event) {
		populateTabelaProdutos(txtPesquisa.getText());
    }

}
