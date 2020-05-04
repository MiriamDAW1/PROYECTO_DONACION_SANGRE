package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladoraPrincipal implements Initializable {
	
	 private  Main ProgramaPrincipal;

	 	@FXML
		private Button adminDonantes;
		
		@FXML
		private Button adminDonaciones;
		
		@FXML
		private Button adminInformesyestadisticas;
		
		 public void setProgramaPrincipal(Main ProgramaPrincipal) {
		     this.ProgramaPrincipal = ProgramaPrincipal;
		  }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Apéndice de método generado automáticamente
			
		}
		
		 /* Cuando se pulsa el botón tendrá que abrir ventana nueva
	     * para eso llama al método del main */
	    @FXML
	    private void abrirVentanaDonante() {
	       	this.ProgramaPrincipal.mostrarVentanaDonante();
	    }
	    @FXML
	    private void abrirVentanaDonacion() {
	       	this.ProgramaPrincipal.mostrarVentanaDonaciones();
	    }
	    @FXML
	    private void abrirVentanaInformes() {
	       	this.ProgramaPrincipal.mostrarVentanainformes();
	    }
	   
	   
}
