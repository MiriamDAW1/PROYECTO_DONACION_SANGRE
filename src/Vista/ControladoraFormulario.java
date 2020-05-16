package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
			TextField preguntaexdef1;

		 //pregunta 2 EXCLUSION DEFINITIVA
		
			 @FXML
			 TextField preguntaexdef2;

		 //pregunta 3 EXCLUSION DEFINITIVA
			 @FXML
			 TextField preguntaexdef3;

		 @FXML
			 public void abrirVentanaDonacion() {
			 if(preguntaexdef1.getText().equals("NO") && preguntaexdef2.getText().equals("NO") && preguntaexdef3.getText().equals("NO")) {
				 this.ProgramaPrincipal.mostrarVentanaDonaciones();
					this.ventana.close();
			 }else {
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Informacion");
				 alert.setHeaderText("NO PUEDE REALIZAR UNA DONACION!");
				 alert.setContentText("TIENES MOTIVOS DE EXCLUSION");

				 alert.showAndWait();
			 }
				
			}
		
		
		
}
