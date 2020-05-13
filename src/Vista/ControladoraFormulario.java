package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControladoraFormulario  implements Initializable {
	
	//pantalla
	 	private Main ProgramaPrincipal;
		@FXML
		private Button buttonvolver;
		
		 @FXML
			private Button guardar;

		private Stage ventana;
		
		public void setStagePrincipal(Stage ventana) {
			this.ventana = ventana;
		}
		
		public void closeWindow(){
			this.ventana.close();
		}


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		}
		
		 public void setProgramaPrincipal(Main ProgramaPrincipal) {
		     this.ProgramaPrincipal = ProgramaPrincipal;
		  }
		 @FXML
		    public void abrirVentanaDonacion() {
			
		       	this.ProgramaPrincipal.mostrarVentanaDonaciones();
		       	this.ventana.close();
		    }
		 
		//***********elementos************
		
		 @FXML
			private TextField codigodonante;
		 @FXML
			private DatePicker FECHA;
		 @FXML
			private Button borrar;
		 @FXML
			private Button Guardar;
		 
		 //pregunta 1 EXCLUSION DEFINITIVA
		 @FXML
			ToggleGroup opcion1;
		 @FXML
			RadioButton S;

			@FXML
			RadioButton N;

			
		 //pregunta 2 EXCLUSION DEFINITIVA
		 
			 @FXML
				ToggleGroup opcion2;
			 @FXML
				RadioButton s;

				@FXML
				RadioButton n;

		 //pregunta 3 EXCLUSION DEFINITIVA
				 @FXML
					ToggleGroup opcion3;
				 @FXML
					RadioButton si;

					@FXML
					RadioButton no;

		
		
		
}
