package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TelaPrincipalController {
	 	@FXML
	    private Menu menuProduto;

	 	 @FXML
	     private BorderPane centerPane;
	 	 
	 	 @FXML
	 	 protected void initialize() {
	 		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaDashboard.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	 }

	    @FXML
	    void menuProduto_Action(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaProdutos.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
	    
	    @FXML
	    void menuMaquinas_Click(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaMaquinas.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void menuCadCusto_Click(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaCadCusto.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void menuConsultaCustos_Click(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaConsultaCusto.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void menuRelCustos_Click(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaRelCustos.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void menuAjuda_Click(ActionEvent event) {
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaAjuda.fxml"));
			Parent root;
			try {
				root = (Parent)fxmlLoader.load();
				centerPane.setCenter(root);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
