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

}
