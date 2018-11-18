package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.ConexaoDb;
import Models.MaquinaDAO;
import Models.MaquinaVO;
import Models.ProdutoDAO;
import Models.ProdutoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaMaquinasController {
	@FXML
	private Button btnCadastro;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnExcluir;
	
	@FXML
    private Button btnPesquisar;

	@FXML
	private TableView<MaquinaVO> tblMaquinas;

	@FXML
	private TableColumn<MaquinaVO, Integer> codigoCol;

	@FXML
	private TableColumn<MaquinaVO, Float> kwhCol;

	@FXML
	private TableColumn<MaquinaVO, String> descricaoCol;
	
	@FXML
    private TextField txtFiltro;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtDescricao;

	@FXML
	private TextField txtKwh;

	private Alert alertInfo = new Alert(AlertType.INFORMATION);

	public final ObservableList<MaquinaVO> data = FXCollections.observableArrayList();

	private void LimparCampos() {
		txtCodigo.setText(null);
		txtDescricao.setText(null);
		txtKwh.setText(null);
		btnCadastro.setText("Adicionar");
	}

	private void adicionarMaquina() {
		try {
			MaquinaVO maquina = new MaquinaVO();
			maquina.setDescricao(txtDescricao.getText());
			maquina.setKwh(Float.parseFloat(txtKwh.getText()));
			MaquinaDAO dao = new MaquinaDAO();
			if (dao.insertMaquina(maquina)) {
				alertInfo.setContentText("Máquina adicionada com sucesso!");
				alertInfo.showAndWait();
				LimparCampos();
				populateTabelaMaquinas();
			} else {
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

	private void editarMaquina() {
		try {
			MaquinaVO maquina = new MaquinaVO();
			maquina.setDescricao(txtDescricao.getText());
			maquina.setKwh(Float.parseFloat(txtKwh.getText()));
			maquina.setCodigo(Integer.parseInt(txtCodigo.getText()));
			MaquinaDAO dao = new MaquinaDAO();
			if (dao.updateMaquina(maquina)) {
				alertInfo.setContentText("Máquina editada com sucesso!");
				alertInfo.showAndWait();
				LimparCampos();
				populateTabelaMaquinas();
			} else {
				alertInfo.setContentText("Erro ao editar máquina!");
				alertInfo.showAndWait();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			alertInfo.setContentText(e.getMessage());
			alertInfo.showAndWait();
			e.printStackTrace();
		}
	}

	private void populateTabelaMaquinas() {
		populateTabelaMaquinas("");
	}

	private void populateTabelaMaquinas(String filtro) {
		data.clear();
		MaquinaDAO dao = new MaquinaDAO();
		if (filtro.isEmpty()) {
			for (MaquinaVO maquina : dao.getAllMaquinas()) {
				data.add(maquina);
			}
		} else {
			for (MaquinaVO maquina : dao.getListMaquinas(filtro)) {
				data.add(maquina);
			}
		}
		tblMaquinas.setItems(data);
	}

	@FXML // basically works like an onload() method
	protected void initialize() {
		txtCodigo.setDisable(true);
		btnCancelar.setVisible(false);
		btnExcluir.setVisible(false);

		PropertyValueFactory<MaquinaVO, Integer> codigoProp = new PropertyValueFactory<MaquinaVO, Integer>("codigo");
		codigoCol.setCellValueFactory(codigoProp);

		PropertyValueFactory<MaquinaVO, String> descricaoProp = new PropertyValueFactory<MaquinaVO, String>(
				"descricao");
		descricaoCol.setCellValueFactory(descricaoProp);

		PropertyValueFactory<MaquinaVO, Float> kwhProp = new PropertyValueFactory<MaquinaVO, Float>("kwh");
		kwhCol.setCellValueFactory(kwhProp);

		tblMaquinas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				btnCadastro.setText("Salvar");
				txtCodigo.setText(String.valueOf(newSelection.getCodigo()));
				txtDescricao.setText(newSelection.getDescricao());
				txtKwh.setText(String.valueOf(newSelection.getKwh()));
				btnExcluir.setVisible(true);
				btnCancelar.setVisible(true);
			} else {
				LimparCampos();
				btnExcluir.setVisible(false);
				btnCancelar.setVisible(false);
			}
		});

		populateTabelaMaquinas();
	}

	@FXML
	void btnCadastro_Click(ActionEvent event) {
		if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == null) {
			adicionarMaquina();
		} else {
			editarMaquina();
		}
	}

	@FXML
	void btnCancelar_Click(ActionEvent event) {
		tblMaquinas.getSelectionModel().clearSelection();
		LimparCampos();
	}
	
	@FXML
    void btnExcluir_Click(ActionEvent event) {
		MaquinaVO maquina = tblMaquinas.getSelectionModel().getSelectedItem();
		if (maquina != null) {
			MaquinaDAO dao = new MaquinaDAO();
			if (dao.deleteMaquina(maquina.getCodigo())) {
				alertInfo.setContentText("Máquina exlcuida com sucesso!");
				alertInfo.showAndWait();
				populateTabelaMaquinas();
				LimparCampos();
			} else {
				alertInfo.setContentText("Erro ao excluir Máquina!");
				alertInfo.showAndWait();
			}
		}
    }
	
	@FXML
    void btnPesquisar_Click(ActionEvent event) {
		populateTabelaMaquinas(txtFiltro.getText());
    }

}
