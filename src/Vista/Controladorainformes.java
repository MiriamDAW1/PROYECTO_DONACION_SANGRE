package Vista;


import java.sql.SQLException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
		
	//tabla
		@FXML
		private TableView<Donante> tabla;
			
		@FXML
		private TableColumn<Donante,String> col_FechaInicial;
		@FXML
		private TableColumn<Donante,String> col_FechaFinal;
		@FXML
		private TableColumn<Donante,String> col_TipoDonante;	
		@FXML
		private TableColumn<Donante,String> col_volumentiposanguineo;	
		
		//datos tabla
				ObservableList<Donante> datos = FXCollections.observableArrayList();
		//inial al cargar
		public void initialize() throws SQLException{
			// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos
			
			ConexionBBDD con = new ConexionBBDD();
			datos = con.bbddObtenerDonantes();

			tabla.setItems(datos);
			col_TipoDonante.setCellValueFactory(new PropertyValueFactory<Donante,String>("GRUPO_SANGUINEO"));
			
		}
		
		
		public void BuscarDon() throws SQLException{

			String buscar = textTipoDonante.getText();
			System.out.println(buscar);
			// llama a un  método  que haga el select de la base de datos
			ConexionBBDD con = new ConexionBBDD();
			datos = con.BuscarTipo(buscar);

			tabla.setItems(datos);


		}

		//metodo borrar
		public void Borrar(){
			textTipoDonante.setText("");
			volumentiposanguineo.setText("");
		}
	
		
	

		

			
			
		
}
