package Vista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonante {
	 private  Controlador.Main ProgramaPrincipal;
		
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

}
