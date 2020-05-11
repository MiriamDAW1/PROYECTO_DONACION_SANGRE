package Vista;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import oracle.sql.BLOB;

public class ControladoraDonante {
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
		
		 public void setProgramaPrincipal(Main ProgramaPrincipal) {
		     this.ProgramaPrincipal = ProgramaPrincipal;
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
		private ComboBox<String> PAIS_NACIMIENTO;
		@FXML
		private ComboBox<String> GRUPO_SANGUINEO;
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
		
		//imagen
		@FXML
		private ImageView FOTO;
		private int position;
		private int maximo;
		private File file;
		
		@FXML
		private TextField txtf_ruta;
	
		
		//tabla
		@FXML
		private TableView<Donante> tabla;
		
		@FXML
		private TableColumn<Donante,String> col_NUM_DONANTE;
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
		private TableColumn<Donante,String> col_CODIGO_POSTAL;
		@FXML
		private TableColumn<Donante,String> col_TELEFONO;
		@FXML
		private TableColumn<Donante,String> col_TELEFONO2;
		@FXML
		private TableColumn<Donante,String> col_CORREO_ELECTRONICO;
		@FXML
		private TableColumn<Donante,Character> col_SEXO;
		@FXML
		private TableColumn<Donante,String> col_GRUPO_SANGUINEO;
		
		
		//comboboxañadir
		ObservableList<String>ListacomboPais=FXCollections.observableArrayList();
		ObservableList<String>ListacomboGrupoSanguineo=FXCollections.observableArrayList();
		
		//datos tabla
		ObservableList<Donante> datos = FXCollections.observableArrayList();

		// Atributos necesarios para codificar la edicion
		private boolean edicion;
		private int indiceedicion;
		
		//inial al cargar
		public void initialize() throws SQLException{
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
				
				
				
				// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos
				
				ConexionBBDD con = new ConexionBBDD();
				datos = con.bbddObtenerDonantes();

				tabla.setItems(datos);

				col_NUM_DONANTE.setCellValueFactory(new PropertyValueFactory<Donante,String>("NUM_DONANTE"));
				col_NOMBRE.setCellValueFactory(new PropertyValueFactory<Donante,String>("NOMBRE"));
				col_APELLIDO1.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO1"));
				col_APELLIDO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("APELLIDO2"));
				col_DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNI"));
				col_FECHA_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("FECHA_NACIMIENTO"));
				col_PAIS_NACIMIENTO.setCellValueFactory(new PropertyValueFactory<Donante,String>("PAIS_NACIMIENTO"));
				col_DIRECCION.setCellValueFactory(new PropertyValueFactory<Donante,String>("DIRECCION"));
				col_POBLACION.setCellValueFactory(new PropertyValueFactory<Donante,String>("POBLACION"));
				col_CODIGO_POSTAL.setCellValueFactory(new PropertyValueFactory<Donante,String>("CODIGO_POSTAL"));
				col_TELEFONO.setCellValueFactory(new PropertyValueFactory<Donante,String>("TELEFONO"));
				col_TELEFONO2.setCellValueFactory(new PropertyValueFactory<Donante,String>("TELEFONO2"));
				col_CORREO_ELECTRONICO.setCellValueFactory(new PropertyValueFactory<Donante,String>("CORREO_ELECTRONICO"));
				col_SEXO.setCellValueFactory(new PropertyValueFactory<Donante,Character>("SEXO"));
				col_GRUPO_SANGUINEO.setCellValueFactory(new PropertyValueFactory<Donante,String>("GRUPO_SANGUINEO"));
				
				

				// Al arrancar la vista se pone edicion a false
				edicion = false;
				indiceedicion = 0;
				}
		
				
				//imprimir carnet
				public void imprimeCarnet() throws FileNotFoundException, DocumentException{
				
				ImprimeArchivo imprime = new ImprimeArchivo("CarnetDonante2020","C:\\Users\\javichu\\Downloads\\");
				imprime.generarArchivoPDF();

				}
				
				
				
				//***********************************BBDDGUARDAR(INSERTAR DONACION)******************************
				public void Guardar() throws SQLException{
					char sexo;

					if(H.isSelected()) {
						sexo = 'H';
					}else {
						sexo = 'M';
					}

					// Añadir un chequeo de campos vacíos o de validación de formato como el email
					if(NUM_DONANTE.getText().equals("") || NOMBRE.getText().equals("") || APELLIDO1.getText().equals("") || APELLIDO2.getText().equals("") || DNI.getText().equals("") || DIRECCION.getText().equals("") || POBLACION.getText().equals("") || CODIGO_POSTAL.getText().equals("") || TELEFONO.getText().equals("") || TELEFONO2.getText().equals("") || CORREO_ELECTRONICO.getText().equals("") ){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!!!");
						alert.setHeaderText("Observa que hayas introducido todos los datos");
						alert.setContentText("¡No se pueden grabar campos vacíos!");
						alert.showAndWait();
					}
					else{

						if(edicion == true){

							// Hago la llamda al método que hace el update en la base de datos
							ConexionBBDD con = new ConexionBBDD();
							
							DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
							String fcita = FECHA_NACIMIENTO.getValue().format(isoFecha);
							
							BLOB Foto =null;
							
							int res = con.ModificarDonante(NUM_DONANTE.getText(),NOMBRE.getText(),APELLIDO1.getText(),APELLIDO2.getText(),DNI.getText(),fcita,PAIS_NACIMIENTO.getValue(),DIRECCION.getText(),POBLACION.getText(),CODIGO_POSTAL.getText(),TELEFONO.getText(),TELEFONO2.getText(),CORREO_ELECTRONICO.getText(),sexo,GRUPO_SANGUINEO.getValue(),Foto);
							switch (res){

								case 0:
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("OK!");
									alert.setHeaderText("Modificación OK!");
									alert.setContentText("¡Persona modificada con éxito!");
									alert.showAndWait();

									// Actualizo los datos de la tabla
									datos = con.bbddObtenerDonantes();
									tabla.setItems(datos);
									break;

								default:
										alert = new Alert(AlertType.ERROR);
										alert.setTitle("Error!");
										alert.setHeaderText("Modificación NOK!");
										alert.setContentText("¡Ha habido un problema al realizar el update!");
										alert.showAndWait();
										break;

									}




						}
						else{
							// Realizar el insertado de datos en la base de datos
							ConexionBBDD con = new ConexionBBDD();
							
							DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
							String fcita = FECHA_NACIMIENTO.getValue().format(isoFecha);
							
							BLOB Foto =null;
							int res = con.InsertarDonante(NUM_DONANTE.getText(),NOMBRE.getText(),APELLIDO1.getText(),APELLIDO2.getText(),DNI.getText(),fcita,PAIS_NACIMIENTO.getValue(),DIRECCION.getText(),POBLACION.getText(),CODIGO_POSTAL.getText(),TELEFONO.getText(),TELEFONO2.getText(),CORREO_ELECTRONICO.getText(),sexo,GRUPO_SANGUINEO.getValue(),Foto);
							
						
							switch (res){

							case 0:
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("OK!");
								alert.setHeaderText("Inserción OK!");
								alert.setContentText("¡Persona insertada con éxito!");
								alert.showAndWait();

								// Actualizo los datos de la tabla
								datos = con.bbddObtenerDonantes();
								tabla.setItems(datos);
								break;

							case 1:
								alert = new Alert(AlertType.WARNING);
								alert.setTitle("Aviso!");
								alert.setHeaderText("Inserción NOK!");
								alert.setContentText("¡Ya existe una persona con ese email!");
								alert.showAndWait();
								break;

							default:
								alert = new Alert(AlertType.ERROR);
								alert.setTitle("Error!");
								alert.setHeaderText("Inserción NOK!");
								alert.setContentText("¡Ha habido un problema al realizar la inserción!");
								alert.showAndWait();
								break;

							}

						}


						}

					}


				//eliminar Donante
				public void Eliminar() throws SQLException{
					int index = tabla.getSelectionModel().getSelectedIndex();
					if( index >= 0){

						Donante seleccionada = tabla.getSelectionModel().getSelectedItem();

						// Se abre un dialog box de confirmacion de eliminar
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Conformación!!!");
						alert.setHeaderText("Por favor confirme el borrado");
						alert.setContentText("Dese borrar al usuario "+ seleccionada.getNUM_DONANTE()+ ""+seleccionada.getNOMBRE() + " " +seleccionada.getAPELLIDO1() +" ?");

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK){
						    // ... user chose OK

							// Llamar a un método que realice el DELETE en la base de datos
							ConexionBBDD con = new ConexionBBDD();
							int res = con.BorrarDonante(seleccionada.getNUM_DONANTE());
							switch(res){
								case 0:
									alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("OK!");
									alert.setHeaderText("Borrado OK!");
									alert.setContentText("¡Persona borrada con éxito!");
									alert.showAndWait();

									// Actualizo los datos de la tabla
									datos = con.bbddObtenerDonantes();
									tabla.setItems(datos);
									break;

								default:
									alert = new Alert(AlertType.ERROR);
									alert.setTitle("Error!");
									alert.setHeaderText("Inserción NOK!");
									alert.setContentText("¡Ha habido un problema al eliminar!");
									alert.showAndWait();
									break;
							}

							Borrar();
						}

					}else{

						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Error en selección de datos");
						alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
						alert.showAndWait();

					}
				}
			
				public void Borrar(){
					NUM_DONANTE.setText("");
					NOMBRE.setText("");
					APELLIDO1.setText("");
					APELLIDO2.setText("");
					DNI.setText("");
					DIRECCION.setText("");
					POBLACION.setText("");
					CODIGO_POSTAL.setText("");
					TELEFONO.setText("");
					TELEFONO2.setText("");
					CORREO_ELECTRONICO.setText("");
					
					
					edicion = false;
					indiceedicion = 0;
				}


				//modificar 
				public void Editar(){


					int index = tabla.getSelectionModel().getSelectedIndex();


					if( index >= 0){

						// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
						edicion = true;
						indiceedicion = index;


						Donante seleccionada = tabla.getSelectionModel().getSelectedItem();

						NUM_DONANTE.setText(seleccionada.getNUM_DONANTE());
						NOMBRE.setText(seleccionada.getNOMBRE());
						APELLIDO1.setText(seleccionada.getCORREO_ELECTRONICO());
						APELLIDO2.setText(seleccionada.getAPELLIDO2());
						DNI.setText(seleccionada.getDNI());
						FECHA_NACIMIENTO.setAccessibleText(seleccionada.getFECHA_NACIMIENTO());
						PAIS_NACIMIENTO.setAccessibleText(seleccionada.getPAIS_NACIMIENTO());
						DIRECCION.setAccessibleText(seleccionada.getDIRECCION());
						POBLACION.setAccessibleText(seleccionada.getPOBLACION());
						CODIGO_POSTAL.setAccessibleText(seleccionada.getCODIGO_POSTAL());
						TELEFONO.setAccessibleText(seleccionada.getTELEFONO());
						TELEFONO2.setAccessibleText(seleccionada.getTELEFONO2());
						CORREO_ELECTRONICO.setAccessibleText(seleccionada.getCORREO_ELECTRONICO());
						if(seleccionada.getSEXO() == 'H')
							H.setSelected(true);
						else
							M.setSelected(true);
						
						GRUPO_SANGUINEO.setAccessibleText(seleccionada.getGRUPO_SANGUINEO());

					}
				}
				
				
				//buscar DNI

				public void Buscar() throws SQLException{

					String buscar = TextFieldBucarporDNI.getText();
					System.out.println(buscar);
					// llama a un  método  que haga el select de la base de datos
					ConexionBBDD con = new ConexionBBDD();
					datos = con.BuscarDniDonante(buscar);

					tabla.setItems(datos);


				}

				
				
}



		
	

