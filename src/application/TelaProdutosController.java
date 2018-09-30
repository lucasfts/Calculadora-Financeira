package application;

import java.awt.List;
import java.util.ArrayList;

import Models.Produto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaProdutosController {
	
	
	  @FXML
	  private TableView<Produto> tblProdutos;
	  
	  @FXML
	    private TableColumn<Produto, Integer> codigoCol;


	    @FXML
	    private TableColumn<Produto, String> descricaoCol;


	    @FXML
	    private TableColumn<Produto, Float> precoCol;
	   public  final ObservableList<Produto> data = FXCollections.observableArrayList();
	  
	  @FXML //basically works like an onload() method
	    protected void initialize() {
		  
		  PropertyValueFactory<Produto, Integer> codigoProp = new PropertyValueFactory<Produto, Integer>("codigo");
		  codigoCol.setCellValueFactory(codigoProp);
		  
		  PropertyValueFactory<Produto, String> descricaoProp =  new PropertyValueFactory<Produto, String>("descricao");
		  
		  descricaoCol.setCellValueFactory(descricaoProp);
		  
		  PropertyValueFactory<Produto, Float> precoProp = new PropertyValueFactory<Produto, Float>("preco");
		  precoCol.setCellValueFactory(precoProp);		  
		  
		  /*
		  Produto prod = new Produto(1,"teste",3,"teste","teste");
		  Produto prod2 = new Produto(1,"teste",3,"teste","teste");

		  
		  data.add(prod);
		  data.add(prod2);
		  tblProdutos.setItems(data);
		  */
		  
		 
	  }

	  
	 	 
}
