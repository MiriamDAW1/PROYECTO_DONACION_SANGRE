package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraFormulario  implements Initializable {
	
	//pantalla
	 	private Main ProgramaPrincipal;
		@FXML
		private Button buttonvolver;

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
		
		
		
		
		
		
		
}
