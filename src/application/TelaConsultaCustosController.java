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

	@FXML // basically works like an onload() method
	protected void initialize() {
		PropertyValueFactory<CustoGeralVO, String> descricaoCG = new PropertyValueFactory<CustoGeralVO, String>(
				"descricao");
		colDescricaoCG.setCellValueFactory(descricaoCG);

		PropertyValueFactory<CustoGeralVO, Float> valorCG = new PropertyValueFactory<CustoGeralVO, Float>("valorCusto");
		colValorCustoCG.setCellValueFactory(valorCG);
		
		populateCustoGeral();
	}
}