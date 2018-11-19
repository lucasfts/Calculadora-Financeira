package application;

import java.util.ArrayList;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class TelaCadCustoController {

    @FXML
    private ToggleGroup tipoCusto;

    @FXML
    private Button btnCustoGeralAdicionar;

    @FXML
    private ComboBox<ProdutoVO> cbCustoProdProduto;

    @FXML
    private RadioButton rbCustoFixo;

    @FXML
    private TextField txtCustoProdDescricao;

    @FXML
    private RadioButton rbCustoVariavel;

    @FXML
    private TextField txtCustoGeralDescricao;

    @FXML
    private TextField txtCustoMaqTempoUnit;

    @FXML
    private ComboBox<MaquinaVO> cbCustoMaqMaquina;

    @FXML
    private Button btnCustoProdAdicionar;

    @FXML
    private Button btnCustoMaqAdicionar;

    @FXML
    private TextField txtCustoProdCusto;


    @FXML
    private TextField txtCustoGeralCusto;

    @FXML
    private ComboBox<ProdutoVO> cbCustoMaqProduto;
    
    private Alert alertInfo = new Alert(AlertType.INFORMATION);
    
    private void populateCbProdutos() {
    	ProdutoDAO prodDAO = new ProdutoDAO();
    	ArrayList<ProdutoVO> listaProds = prodDAO.getAllProdutos();
    	ObservableList<ProdutoVO> prodItems = FXCollections.observableArrayList(listaProds);
    	cbCustoMaqProduto.setItems(prodItems);
    	cbCustoProdProduto.setItems(prodItems);
    	
    	MaquinaDAO maqDAO = new MaquinaDAO();
    	ArrayList<MaquinaVO> listaMaqs = maqDAO.getAllMaquinas();
    	ObservableList<MaquinaVO> maqItems = FXCollections.observableArrayList(listaMaqs);
    	cbCustoMaqMaquina.setItems(maqItems);
    	  	
    	
    }
    
    @FXML //basically works like an onload() method
    protected void initialize() {
    	populateCbProdutos();
    	rbCustoFixo.setSelected(true);
    }

    @FXML
    void btnCustoProdAdicionar_Click(ActionEvent event) {
    	ProdutoVO produto = cbCustoProdProduto.getSelectionModel().getSelectedItem();
    	if(produto != null) {
    		CustoProducaoVO custo = new CustoProducaoVO();
        	custo.setCodigoProduto(produto.getCodigo());
        	custo.setDescricao(txtCustoProdDescricao.getText());
        	custo.setTipoCusto(rbCustoFixo.isSelected() ? 0 : 1);
        	custo.setValorCusto(Float.valueOf(txtCustoProdCusto.getText()));
        	CustoProducaoDAO dao = new CustoProducaoDAO();
        	if (dao.insertCusto(custo)) {
				alertInfo.setContentText("Custo de produção adicionado com sucesso!");
				alertInfo.showAndWait();
				rbCustoFixo.setSelected(true);
				txtCustoProdDescricao.setText(null);
				txtCustoProdCusto.setText(null);
				cbCustoProdProduto.getSelectionModel().select(null);
			} else {
				alertInfo.setContentText("Erro ao custo de produção!");
				alertInfo.showAndWait();
			}
    	}
    	
    }

    @FXML
    void btnCustoGeralAdicionar_Click(ActionEvent event) {
    	CustoGeralVO custo = new CustoGeralVO();
    	custo.setDescricao(txtCustoGeralDescricao.getText());
    	custo.setvalorCusto(Float.valueOf(txtCustoGeralCusto.getText()));
    	CustoGeralDAO dao = new CustoGeralDAO();
    	if (dao.insertCusto(custo)) {
			alertInfo.setContentText("Custo geral adicionado com sucesso!");
			alertInfo.showAndWait();
			txtCustoGeralDescricao.setText(null);
			txtCustoGeralCusto.setText(null);
		} else {
			alertInfo.setContentText("Erro ao custo geral!");
			alertInfo.showAndWait();
		}
    }

    @FXML
    void btnCustoMaqAdicionar_Click(ActionEvent event) {
    	ProdutoVO produto = cbCustoMaqProduto.getSelectionModel().getSelectedItem();
    	MaquinaVO maquina = cbCustoMaqMaquina.getSelectionModel().getSelectedItem();
    	if(produto != null && maquina != null) {
    		CustoMaquinaVO custo = new CustoMaquinaVO();
        	custo.setCodigoMaquina(maquina.getCodigo());
        	custo.setCodigoProduto(produto.getCodigo());
        	custo.setTempoUnitario(Float.valueOf(txtCustoMaqTempoUnit.getText()));
        	CustoMaquinaDAO dao = new CustoMaquinaDAO();
        	if (dao.insertCusto(custo)) {
				alertInfo.setContentText("Custo de máquina adicionado com sucesso!");
				alertInfo.showAndWait();
				cbCustoMaqProduto.getSelectionModel().select(null);
				cbCustoMaqMaquina.getSelectionModel().select(null);
				txtCustoMaqTempoUnit.setText(null);
			} else {
				alertInfo.setContentText("Erro ao custo de máquina!");
				alertInfo.showAndWait();
			}
    	}
    }
    
    @FXML
    void cbCustoMaqProduto_Action(ActionEvent event) {
    	
    }
    
    @FXML
    void cbCustoMaqMaquina_Action(ActionEvent event) {
    	
    }
    
    @FXML
    void cbCustoProdProduto_Action(ActionEvent event) {
    	
    }


}
