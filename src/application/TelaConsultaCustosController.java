package application;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaConsultaCustosController {

	@FXML
	private TableView<CustoGeralVO> tblCustoGeral;

	@FXML
	private TableColumn<CustoGeralVO, String> colDescricaoCG;

	@FXML
	private TableColumn<CustoGeralVO, Float> colValorCustoCG;

	public final ObservableList<CustoGeralVO> CustoGeralData = FXCollections.observableArrayList();

	@FXML
	private TableColumn<CustoProducaoVO, String> colDescricaoCP;

	@FXML
	private TableColumn<CustoProducaoVO, ProdutoVO> colProdutoCP;

	@FXML
	private TableView<CustoProducaoVO> tblCustoProducao;

	@FXML
	private TableColumn<CustoProducaoVO, String> colTipoCP;

	@FXML
	private TableColumn<CustoProducaoVO, Float> colCustoCP;

	public final ObservableList<CustoProducaoVO> CustoProducaoData = FXCollections.observableArrayList();

	@FXML
	private TableColumn<CustoMaquinaVO, ProdutoVO> colProdutoCM;

	@FXML
	private TableColumn<CustoMaquinaVO, Float> colTempoCM;

	@FXML
	private TableColumn<CustoMaquinaVO, MaquinaVO> colMaquinaCM;
	
	@FXML
    private TableView<CustoMaquinaVO> tblCustoMaquina;
	
	public final ObservableList<CustoMaquinaVO> CustoMaquinaData = FXCollections.observableArrayList();

	private Alert alertInfo = new Alert(AlertType.INFORMATION);

	private void populateCustoGeral() {
		populateCustoGeral("");
	}

	private void populateCustoGeral(String filtro) {
		CustoGeralData.clear();
		CustoGeralDAO dao = new CustoGeralDAO();
		if (filtro.isEmpty()) {
			for (CustoGeralVO custo : dao.getAllCustos()) {
				CustoGeralData.add(custo);
			}
		} else {
			for (CustoGeralVO custo : dao.getListCustos(filtro)) {
				CustoGeralData.add(custo);
			}
		}
		tblCustoGeral.setItems(CustoGeralData);
	}
	
	
	private void populateCustoProducao() {
		CustoProducaoData.clear();
		CustoProducaoDAO dao = new CustoProducaoDAO();
		for (CustoProducaoVO custo : dao.getAllCustos()) {
			CustoProducaoData.add(custo);
		}
		tblCustoProducao.setItems(CustoProducaoData);
	}
	
	private void populateCustoMaquina() {
		CustoMaquinaData.clear();
		CustoMaquinaDAO dao = new CustoMaquinaDAO();
		for (CustoMaquinaVO custo : dao.getAllCustos()) {
			CustoMaquinaData.add(custo);
		}
		tblCustoMaquina.setItems(CustoMaquinaData);
	}

	@FXML // basically works like an onload() method
	protected void initialize() {
		PropertyValueFactory<CustoGeralVO, String> descricaoCG = new PropertyValueFactory<CustoGeralVO, String>(
				"descricao");
		colDescricaoCG.setCellValueFactory(descricaoCG);

		PropertyValueFactory<CustoGeralVO, Float> valorCG = new PropertyValueFactory<CustoGeralVO, Float>("valorCusto");
		colValorCustoCG.setCellValueFactory(valorCG);

		
		
		PropertyValueFactory<CustoProducaoVO, String> descricaoCP = new PropertyValueFactory<CustoProducaoVO, String>(
				"descricao");
		colDescricaoCP.setCellValueFactory(descricaoCP);

		PropertyValueFactory<CustoProducaoVO, Float> valorCP = new PropertyValueFactory<CustoProducaoVO, Float>(
				"valorCusto");
		colCustoCP.setCellValueFactory(valorCP);

		PropertyValueFactory<CustoProducaoVO, String> tipoNome = new PropertyValueFactory<CustoProducaoVO, String>(
				"tipoCustoName");
		colTipoCP.setCellValueFactory(tipoNome);

		PropertyValueFactory<CustoProducaoVO, ProdutoVO> produtoCP = new PropertyValueFactory<CustoProducaoVO, ProdutoVO>(
				"produto");
		colProdutoCP.setCellValueFactory(produtoCP);
		
		
		PropertyValueFactory<CustoMaquinaVO, ProdutoVO> produtoCM = new PropertyValueFactory<CustoMaquinaVO, ProdutoVO>(
				"produto");
		colProdutoCM.setCellValueFactory(produtoCM);
		
		PropertyValueFactory<CustoMaquinaVO, MaquinaVO> maquinaCM = new PropertyValueFactory<CustoMaquinaVO, MaquinaVO>(
				"maquina");
		colMaquinaCM.setCellValueFactory(maquinaCM);
		
		PropertyValueFactory<CustoMaquinaVO, Float> tempoCM = new PropertyValueFactory<CustoMaquinaVO, Float>(
				"tempoUnitario");
		colTempoCM.setCellValueFactory(tempoCM);
		
		

		populateCustoGeral();
		populateCustoProducao();
		populateCustoMaquina();
	}
}