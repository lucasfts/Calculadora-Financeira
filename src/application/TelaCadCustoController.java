package application;

import java.util.ArrayList;

import Models.MaquinaDAO;
import Models.MaquinaVO;
import Models.ProdutoDAO;
import Models.ProdutoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private AnchorPane cbTipo1;

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
    private AnchorPane cbTipo11;

    @FXML
    private TextField txtCustoGeralCusto;

    @FXML
    private AnchorPane cbTipo12;

    @FXML
    private ComboBox<ProdutoVO> cbCustoMaqProduto;
    
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
    	
    	
    	cbCustoMaqProduto.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ProdutoVO produto = cbCustoMaqProduto.getSelectionModel().getSelectedItem();
                System.out.println(produto.getCodigo());
            }
        });
    	
    	cbCustoProdProduto.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ProdutoVO produto = cbCustoMaqProduto.getSelectionModel().getSelectedItem();
                System.out.println(produto.getCodigo());
            }
        });
    	
    	cbCustoMaqMaquina.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
            	MaquinaVO maquina = cbCustoMaqMaquina.getSelectionModel().getSelectedItem();
                System.out.println(maquina.getCodigo());
            }
        });
    	
    	
    }
    
    @FXML //basically works like an onload() method
    protected void initialize() {
    	populateCbProdutos();
    }

    @FXML
    void btnCustoProdAdicionar_Click(ActionEvent event) {
    	
    }

    @FXML
    void btnCustoGeralAdicionar_Click(ActionEvent event) {

    }

    @FXML
    void btnCustoMaqAdicionar_Click(ActionEvent event) {

    }
    
    @FXML
    void cbCustoMaqProduto_Action(ActionEvent event) {
    	System.out.println(cbCustoMaqProduto.getSelectionModel().getSelectedItem().getCodigo());
    }
    
    @FXML
    void cbCustoMaqMaquina_Action(ActionEvent event) {
    	System.out.println(cbCustoMaqMaquina.getSelectionModel().getSelectedItem().getCodigo());
    }
    
    @FXML
    void cbCustoProdProduto_Action(ActionEvent event) {
    	System.out.println(cbCustoProdProduto.getSelectionModel().getSelectedItem().getCodigo());
    }


}
