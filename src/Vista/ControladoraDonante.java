package Vista;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oracle.sql.BLOB;

public class ControladoraDonante implements Initializable{
	//pantalla
	private Main ProgramaPrincipal;
		
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

		//***********elementos************
		
		@FXML
		private TextField NUM_DONANTE;
		@FXML
		private TextField NOMBRE;
		@FXML
		private TextField APELLIDO1;
		@FXML
		private TextField APELLIDO2;
		@FXML
		private TextField DNI;
		@FXML
		private DatePicker FECHA_NACIMIENTO;
		@FXML
		private ComboBox PAIS_NACIMIENTO;
		@FXML
		private ComboBox GRUPO_SANGUINEO;
		@FXML
		private TextField DIRECCION;
		@FXML
		private TextField POBLACION;
		@FXML
		private TextField CODIGO_POSTAL;
		@FXML
		private TextField TELEFONO;
		@FXML
		private TextField TELEFONO2;
		@FXML
		private TextField CORREO_ELECTRONICO;
		@FXML
		RadioButton H;
		@FXML
		RadioButton M;
		@FXML
		ToggleGroup SEXO;
		@FXML
		private TextField TextFieldBucarporDNI;
		@FXML
		private Button BotonbuscarDNI;
		@FXML
		private Button SELECIONARIMAGEN;
		@FXML
		private Button GENERARCARNET;
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
		private TableColumn<Donante,Integer> col_NUM_DONANTE;
		@FXML
		private TableColumn<Donante,String> col_NOMBRE;
		@FXML
		private TableColumn<Donante,String> col_APELLIDO1;
		@FXML
		private TableColumn<Donante,String> col_APELLIDO2;
		@FXML
		private TableColumn<Donante,String> col_DNI;
		@FXML
		private TableColumn<Donante,String> col_FECHA_NACIMIENTO;
		@FXML
		private TableColumn<Donante,String> col_PAIS_NACIMIENTO;
		@FXML
		private TableColumn<Donante,String> col_DIRECCION;
		@FXML
		private TableColumn<Donante,String> col_POBLACION;
		@FXML
		private TableColumn<Donante,Integer> col_CODIGO_POSTAL;
		@FXML
		private TableColumn<Donante,Integer> col_TELEFONO;
		@FXML
		private TableColumn<Donante,Integer> col_TELEFONO2;
		@FXML
		private TableColumn<Donante,String> col_CORREO_ELECTRONICO;
		@FXML
		private TableColumn<Donante,Character> col_SEXO;
		@FXML
		private TableColumn<Donante,String> col_GRUPO_SANGUINEO;
		
		
		//comboboxañadir
		ObservableList<String>ListacomboPais=FXCollections.observableArrayList();
		ObservableList<String>ListacomboGrupoSanguineo=FXCollections.observableArrayList();
			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				//listacomboPais
				ListacomboPais.add("Afganistán");
				ListacomboPais.add("Albania");
				ListacomboPais.add("Alemania");
				ListacomboPais.add("Andorra");
				ListacomboPais.add("Angola");
				ListacomboPais.add("Antigua y Barbuda");
				ListacomboPais.add("Arabia Saudita");
				ListacomboPais.add("Argelia");
				ListacomboPais.add("Argentina");
				ListacomboPais.add("Armenia");
				ListacomboPais.add("Australia");
				ListacomboPais.add("Austria");
				ListacomboPais.add("Azerbaiyán");
				ListacomboPais.add("Bahamas");
				ListacomboPais.add("Bangladés");
				ListacomboPais.add("Barbados");
				ListacomboPais.add("Baréin");
				ListacomboPais.add("Bélgica");
				ListacomboPais.add("Belice");
				ListacomboPais.add("Benín");
				ListacomboPais.add("Bielorrusia");
				ListacomboPais.add("Birmania");
				ListacomboPais.add("Bolivia");
				ListacomboPais.add("Bosnia y Herzegovina");
				ListacomboPais.add("Botsuana");
				ListacomboPais.add("Brasil");
				ListacomboPais.add("Brunéi");
				ListacomboPais.add("Bulgaria");
				ListacomboPais.add("Burkina Faso");
				ListacomboPais.add("Burundi");
				ListacomboPais.add("Bután");
				ListacomboPais.add("Cabo Verde");
				ListacomboPais.add("Camboya");
				ListacomboPais.add("Camerún");
				ListacomboPais.add("Canadá");
				ListacomboPais.add("Catar");
				ListacomboPais.add("Chad");
				ListacomboPais.add("Chile");
				ListacomboPais.add("China");
				ListacomboPais.add("Chipre");
				ListacomboPais.add("Colombia");
				ListacomboPais.add("Comoras");
				ListacomboPais.add("Corea del Norte");
				ListacomboPais.add("Corea del Sur");
				ListacomboPais.add("Costa de Marfil");
				ListacomboPais.add("Costa Rica");
				ListacomboPais.add("Croacia");
				ListacomboPais.add("Cuba");
				ListacomboPais.add("Dinamarca");
				ListacomboPais.add("Ecuador");
				ListacomboPais.add("Egipto");
				ListacomboPais.add("Emiratos Árabes Unidos");
				ListacomboPais.add("Eslovaquia");
				ListacomboPais.add("Eslovenia");
				ListacomboPais.add("España");
				ListacomboPais.add("Estados Unidos");
				ListacomboPais.add("Estonia");
				ListacomboPais.add("Etiopía");
				ListacomboPais.add("Filipinas");
				ListacomboPais.add("Finlandia");
				ListacomboPais.add("Francia");
				ListacomboPais.add("Grecia");
				ListacomboPais.add("Guatemala");
				ListacomboPais.add("Guinea ecuatorial");
				ListacomboPais.add("Honduras");
				ListacomboPais.add("Hungría");
				ListacomboPais.add("India");
				ListacomboPais.add("Indonesia");
				ListacomboPais.add("Irak");
				ListacomboPais.add("Irán");
				ListacomboPais.add("Irlanda");
				ListacomboPais.add("Islandia");
				ListacomboPais.add("Israel");
				ListacomboPais.add("Italia");
				ListacomboPais.add("Jamaica");
				ListacomboPais.add("Japón");
				ListacomboPais.add("Jordania");
				ListacomboPais.add("Kazajistán");
				ListacomboPais.add("Kenia");
				ListacomboPais.add("Letonia");
				ListacomboPais.add("Líbano");
				ListacomboPais.add("Lituania");
				ListacomboPais.add("Luxemburgo");
				ListacomboPais.add("Madagascar");	
				ListacomboPais.add("Maldivas");
				ListacomboPais.add("Malta");
				ListacomboPais.add("Marruecos");
				ListacomboPais.add("México");
				ListacomboPais.add("Moldavia");
				ListacomboPais.add("Mónaco");
				ListacomboPais.add("Montenegro");
				ListacomboPais.add("Nicaragua");
				ListacomboPais.add("Noruega");
				ListacomboPais.add("Nueva Zelanda");
				ListacomboPais.add("Omán");
				ListacomboPais.add("Países Bajos");
				ListacomboPais.add("Pakistán");
				ListacomboPais.add("Panamá");
				ListacomboPais.add("Perú");
				ListacomboPais.add("Polonia");
				ListacomboPais.add("Portugal");
				ListacomboPais.add("Reino Unido");
				ListacomboPais.add("Rumanía");
				ListacomboPais.add("Rusia");
				ListacomboPais.add("Senegal");
				ListacomboPais.add("Serbia");
				ListacomboPais.add("Singapur");
				ListacomboPais.add("Siria");
				ListacomboPais.add("Suecia");
				ListacomboPais.add("Suiza");
				ListacomboPais.add("Tailandia");
				ListacomboPais.add("Turquía");
				ListacomboPais.add("Uruguay");
				ListacomboPais.add("Venezuela");
				ListacomboPais.add("Vietnam");
				ListacomboPais.add("Yemen");
				ListacomboPais.add("Zambia");
				ListacomboPais.add("Zimbabue");
				PAIS_NACIMIENTO.setItems(ListacomboPais);
				
				//listaComboGrupoSanguineo
				
				ListacomboGrupoSanguineo.add("A POSITIVO");
				ListacomboGrupoSanguineo.add("A NEGATIVO");
				ListacomboGrupoSanguineo.add("B POSITIVO");
				ListacomboGrupoSanguineo.add("B NEGATIVO");
				ListacomboGrupoSanguineo.add("AB POSITIVO");
				ListacomboGrupoSanguineo.add("AB NEGATIVO");
				ListacomboGrupoSanguineo.add("0 POSITIVO");
				ListacomboGrupoSanguineo.add("0 NEGATIVO");
				GRUPO_SANGUINEO.setItems(ListacomboGrupoSanguineo);
			}
		
			//datos tabla
			ObservableList<Donante> datos = FXCollections.observableArrayList();

			// Atributos necesarios para codificar la edicion
			private boolean edicion;
			private int indiceedicion;
			
			public void initialize() throws SQLException{
				System.out.println("inicialize");
				// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

				ConexionBBDD con = new ConexionBBDD();
				datos = con.bbddObtenerDonantes();

				tabla.setItems(datos);

				col_NUM_DONANTE.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("NUM_DONACION"));
				col_NOMBRE.setCellValueFactory(new PropertyValueFactory<Donante,String>("NOMBRE"));
				col_APELLIDO1.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO1"));
				col_APELLIDO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO2"));
				col_DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNI"));
				col_FECHA_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("FECHA_NACIMIENTO"));
				col_PAIS_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("PAIS_NACIMIENTO"));
				col_DIRECCION.setCellValueFactory(new PropertyValueFactory<Donante,String>("DIRECCION"));
				col_POBLACION.setCellValueFactory(new PropertyValueFactory<Donante,String>("POBLACION"));
				col_CODIGO_POSTAL.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("CODIGO_POSTAL"));
				col_TELEFONO.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TELEFONO"));
				col_TELEFONO2.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TELEFONO2"));
				col_CORREO_ELECTRONICO.setCellValueFactory(new PropertyValueFactory<Donante,String>("CORREO_ELECTRONICO"));
				col_SEXO.setCellValueFactory(new PropertyValueFactory<Donante,Character>("SEXO"));
				col_GRUPO_SANGUINEO.setCellValueFactory(new PropertyValueFactory<Donante,String>("GRUPO_SANGUINEO"));
				
				

				// Al arrancar la vista se pone edicion a false
				edicion = false;
				indiceedicion = 0;
				}
			
			

			}

	

