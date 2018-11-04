package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.ConexaoDb;
import Models.MaquinaDAO;
import Models.MaquinaVO;
import Models.ProdutoDAO;
import Models.ProdutoVO;
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
    	try {
			  MaquinaVO maquina = new MaquinaVO();
			  maquina.setDescricao(txtDescricao.getText());
			  maquina.setKwh(Float.parseFloat(txtKwh.getText()));
			  MaquinaDAO dao = new MaquinaDAO();			
			if(dao.insertMaquina(maquina)) {
				alertInfo.setContentText("Máquina adicionada com sucesso!");
				alertInfo.showAndWait();
			}
			else {
				alertInfo.setContentText("Erro ao adicionar máquina!");
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
