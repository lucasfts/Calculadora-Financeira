package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.ConexaoDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaMaquinasController {
	@FXML
    private Button btnAdicionar;

    @FXML
    private TableColumn<?, ?> codigoCol;

    @FXML
    private TableColumn<?, ?> descricaoCol;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TableView<?> tblProdutos;

    @FXML
    private TableColumn<?, ?> precoCol;

    @FXML
    private TextField txtKwh;
    
    private Alert alertInfo = new Alert(AlertType.INFORMATION);
    
    @FXML //basically works like an onload() method
    protected void initialize() {
    	txtCodigo.setDisable(true);
    }

    @FXML
    void btnAdicionar_Click(ActionEvent event) {
    	Connection conexao =  ConexaoDb.getConexao();
		  if(conexao != null) {
			  String sql = "insert into Maquinas (Descricao, KWH) values (?,?)";
			  try {
				PreparedStatement pst = conexao.prepareStatement(sql);
				pst.setString(1, txtDescricao.getText());
				pst.setString(2, txtKwh.getText());
				int adicionado = pst.executeUpdate();
				if(adicionado > 0) {
					alertInfo.setContentText("Máquina adicionada com sucesso!");
					alertInfo.showAndWait();
				}
				else {
					alertInfo.setContentText("Erro ao adicionar máquina!");
					alertInfo.showAndWait();
				}
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				  alertInfo.setContentText(e.getMessage());
				  alertInfo.showAndWait();
				  e.printStackTrace();
			  }	  
		  }
    }

}
