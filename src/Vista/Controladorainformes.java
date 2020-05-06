package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controladorainformes implements Initializable{

	//pantalla
	 private  Main ProgramaPrincipal;
		
		@FXML
		private Button buttonclose;

		private Stage ventana;

		public void setStagePrincipal(Stage ventana) {
			// TODO Auto-generated method stub
			this.ventana = ventana;
		}

		public void closeWindow(){
			this.ventana.close();
		}
		
		//elementos
		 @FXML
			private DatePicker FechaInicial;
		 @FXML
			private DatePicker FechaFinal;
		 @FXML
			private ComboBox<String> TipoDonante;
		@FXML
			private TextField volumentiposanguineo;
		@FXML
			private TextArea resultados;
		@FXML
		private Button Buscar;
		@FXML
		private Button Borrar;
		 
		 //comboboxañadir
			ObservableList<String>ListaTipodonante=FXCollections.observableArrayList();

			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				//listaComboGrupoSanguineo
				ListaTipodonante.add("A POSITIVO");
				ListaTipodonante.add("A NEGATIVO");
				ListaTipodonante.add("B POSITIVO");
				ListaTipodonante.add("B NEGATIVO");
				ListaTipodonante.add("AB POSITIVO");
				ListaTipodonante.add("AB NEGATIVO");
				ListaTipodonante.add("0 POSITIVO");
				ListaTipodonante.add("0 NEGATIVO");
				TipoDonante.setItems(ListaTipodonante);
			}
		
			
			
		
}
