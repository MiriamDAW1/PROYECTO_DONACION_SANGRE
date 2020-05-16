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
		
			 @FXML
			 TextField preguntaexdef2;

			 @FXML
			 TextField preguntaexdef3;

			 //pregunta 5 EXCLUSION TEMPORAL
			 @FXML
			 TextField preguntaexdef5;
			 @FXML
			 TextField preguntaexdef1temporal;
			 
			 @FXML
			 TextField preguntaexdef3temporal;
			 
			 @FXML
			 TextField preguntaexdef12;
			 @FXML
			 TextField preguntaexdef14;
			 @FXML
			 TextField preguntaexdef16;
			 @FXML
			 TextField preguntaexdef17;
		 @FXML
			 public void abrirVentanaDonacion() {
			 if(preguntaexdef1.getText().equals("NO") && preguntaexdef2.getText().equals("NO") && preguntaexdef3.getText().equals("NO")&& preguntaexdef5.getText().equals("SI") && preguntaexdef1temporal.getText().equals("NO") && preguntaexdef3temporal.getText().equals("NO") && preguntaexdef12.getText().equals("SI") && preguntaexdef14.getText().equals("SI") && preguntaexdef16.getText().equals("SI") && preguntaexdef17.getText().equals("SI")) {
				 this.ProgramaPrincipal.mostrarVentanaDonaciones();
					this.ventana.close();
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Informacion de datos");
					alert.setHeaderText("comprobando datos.....");
					alert.setContentText("EXCELENTE YA PUEDE REALIZAR LA DONACION!!!");

					alert.showAndWait();
			 }else {
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Informacion");
				 alert.setHeaderText("comprobando datos.....");
				 alert.setContentText("NO PUEDE REALIZAR UNA DONACION TIENES MOTIVOS DE EXCLUSION");

				 alert.showAndWait();
			 }
				
			}
		
		
		
}
