package Vista;

import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controladorainformes {

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
		
		 public void setProgramaPrincipal(Main ProgramaPrincipal) {
		     this.ProgramaPrincipal = ProgramaPrincipal;
		  }
		//elementos
		 @FXML
			private DatePicker textFechaInicial;
		 @FXML
			private DatePicker FechaFinal;
		 @FXML
			private TextField textTipoDonante;
		@FXML
			private TextField volumentiposanguineo;
		
		
		@FXML
		private Button BuscarPorTipoDonante;
		
		@FXML
		private Button BuscarPorFecha;
		
		@FXML
		private Button Borrar;
		@FXML
		private TextArea resultadoTipodonacion;

		//datos tabla
			ObservableList<Donante> datos = FXCollections.observableArrayList();
		
		
		
		//metodo borrar
		public void Borrar(){
			textTipoDonante.setText("");
			volumentiposanguineo.setText("");
		}
	
		
	

		

			
			
		
}
