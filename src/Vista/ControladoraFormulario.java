package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraFormulario {
	
		@FXML
		private Button buttonvolver;

		private Stage ventana;
		
		public void setStagePrincipal(Stage ventana) {
			this.ventana = ventana;
		}
		
		public void closeWindow(){
			this.ventana.close();
		}

}
