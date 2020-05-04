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
			// TODO Ap�ndice de m�todo generado autom�ticamente
			
		}
		
		 /* Cuando se pulsa el bot�n tendr� que abrir ventana nueva
	     * para eso llama al m�todo del main */
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
