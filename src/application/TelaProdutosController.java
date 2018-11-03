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

public class TelaProdutosController {
	
	
	 @FXML
	    private Button btnSalvar;

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
	    
	    
	    public  final ObservableList<ProdutoVO> data = FXCollections.observableArrayList();
	    
	    private Alert alertInfo = new Alert(AlertType.INFORMATION);
	  
	  @FXML //basically works like an onload() method
	    protected void initialize() {
		  
		  txtCodigo.setDisable(true);
		  
		  PropertyValueFactory<ProdutoVO, Integer> codigoProp = new PropertyValueFactory<ProdutoVO, Integer>("codigo");
		  codigoCol.setCellValueFactory(codigoProp);
		  
		  PropertyValueFactory<ProdutoVO, String> descricaoProp =  new PropertyValueFactory<ProdutoVO, String>("descricao");
		  
		  descricaoCol.setCellValueFactory(descricaoProp);
		  
		  PropertyValueFactory<ProdutoVO, Float> precoProp = new PropertyValueFactory<ProdutoVO, Float>("preco");
		  precoCol.setCellValueFactory(precoProp);		  
		  
		  /*
		  Produto prod = new Produto(1,"teste",3,"teste","teste");
		  Produto prod2 = new Produto(1,"teste",3,"teste","teste");

		  
		  data.add(prod);
		  data.add(prod2);
		  tblProdutos.setItems(data);
		  */
		  
		 
	  }
	  
	  @FXML
	    void btnSalvar_Click(ActionEvent event) {
		  
			  try {
				  ProdutoVO produto = new ProdutoVO();
				  produto.setDescricao(txtDescricao.getText());
				  produto.setPreco(Float.parseFloat(txtPrecoVenda.getText()));
				  ProdutoDAO dao = new ProdutoDAO();			
				if(dao.insertProduto(produto)) {
					alertInfo.setContentText("Produto adicionado com sucesso!");
					alertInfo.showAndWait();
				}
				else {
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

	  
	 	 
}
