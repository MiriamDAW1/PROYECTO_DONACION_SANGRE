package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonacion implements Initializable {
	 private  Main ProgramaPrincipal;
		
	 //pantalla
		@FXML
		private Button buttonclose;
		
		@FXML
		private Button buttonabrirformularioDonante;

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

		 @Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				// TODO Apéndice de método generado automáticamente
				
			}
		 @FXML
		    public void abrirVentanaDonante() {
		       	this.ProgramaPrincipal.mostrarVentanaFormulario();
		    }
		 
		 //elementos
		 
}
