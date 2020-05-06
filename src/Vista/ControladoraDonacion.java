package Vista;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

		 @FXML
		    public void abrirVentanaDonante() {
		       	this.ProgramaPrincipal.mostrarVentanaFormulario();
		    }
		 
		//***********elementos************
		 @FXML
			private TextField NUM_DONACION;
		 @FXML
			private TextField COD_COLECTA;
		 @FXML
			private ComboBox TIPO_DONACION;
		 @FXML
			private ComboBox PULSO;
		 @FXML
			private TextField TA_SIST;
		 @FXML
			private TextField TA_DIAST;
		 @FXML
			private TextField HB_CAP;
		 @FXML
			private TextField HB_VEN;
		 @FXML
			private DatePicker FECHA;
		 @FXML
			private TextField TextFieldBuacarTipoDonacion;
		 @FXML
			private Button BotonbuscartipoDonacion;
		 @FXML
			private Button GUARDAR;
			@FXML
			private Button BORRAR;
			@FXML
			private Button ELIMINAR;
			
		 //tabla
		 @FXML
			private TableView<Donante> tabla;
		 @FXML
			private TableColumn<Donacion,Integer> col_NUM_DONACION;
		 @FXML
			private TableColumn<Donacion,Integer> col_COD_COLECTA;
		 @FXML
			private TableColumn<Donacion,String> col_TIPO_DONACION;
		 @FXML
			private TableColumn<Donacion,Integer> col_PULSO;
		 @FXML
			private TableColumn<Donacion,Integer> col_TA_SIST;
		 @FXML
			private TableColumn<Donacion,Integer> col_TA_DIAST;
		 @FXML
			private TableColumn<Donacion,Integer> col_HB_CAP;
		 @FXML
			private TableColumn<Donacion,Integer> col_HB_VEN;
		 @FXML
			private TableColumn<Donacion,Integer> col_FECHA;
		 
		 
		 
		 //comboboxañadir
			ObservableList<String>ListaTipoDonacion=FXCollections.observableArrayList();
			ObservableList<String>ListaPulso=FXCollections.observableArrayList();
		 @Override
			public void initialize(URL arg0, ResourceBundle arg1) {
			 //LitaTipoDonacion
			 ListaTipoDonacion.add("SANGRE");
			 ListaTipoDonacion.add("AFERESIS");
			
			 //ListaPulso
			 ListaPulso.add("60");
			 ListaPulso.add("61");
			 ListaPulso.add("62");
			 ListaPulso.add("63");
			 ListaPulso.add("64");
			 ListaPulso.add("65");
			 ListaPulso.add("66");
			 ListaPulso.add("67");
			 ListaPulso.add("68");
			 ListaPulso.add("69");
			 ListaPulso.add("70");
			 ListaPulso.add("71");
			 ListaPulso.add("72");
			 ListaPulso.add("73");
			 ListaPulso.add("74");
			 ListaPulso.add("75");
			 ListaPulso.add("76");
			 ListaPulso.add("77");
			 ListaPulso.add("78");
			 ListaPulso.add("79");
			 ListaPulso.add("80");
			 ListaPulso.add("81");
			 ListaPulso.add("82");
			 ListaPulso.add("83");
			 ListaPulso.add("84");
			 ListaPulso.add("85");
			 ListaPulso.add("86");
			 ListaPulso.add("87");
			 ListaPulso.add("88");
			 ListaPulso.add("89");
			 ListaPulso.add("90");
			 ListaPulso.add("91");
			 ListaPulso.add("92");
			 ListaPulso.add("93");
			 ListaPulso.add("94");
			 ListaPulso.add("95");
			 ListaPulso.add("96");
			 ListaPulso.add("97");
			 ListaPulso.add("98");
			 ListaPulso.add("99");
			 ListaPulso.add("100");
			}
		 
		 
			

		 
		 
}
