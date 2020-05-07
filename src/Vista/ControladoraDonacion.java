package Vista;

import java.sql.SQLException;
import java.util.Optional;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraDonacion  {
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
		       	this.ventana.close();
		    }
		 
		//***********elementos************
		 @FXML
			private TextField NUM_DONACION;
		 @FXML
			private TextField COD_COLECTA;
		 @FXML
			private ComboBox<String> TIPO_DONACION;
		 @FXML
			private ComboBox<String> PULSO;
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
			private TableView<Donacion> tabla;
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
			private TableColumn<Donacion,String> col_FECHA;
		 
		 
		 
		 //comboboxañadir
			ObservableList<String>ListaTipoDonacion=FXCollections.observableArrayList();
			ObservableList<String>ListaPulso=FXCollections.observableArrayList();
			
		//datos tabla
			ObservableList<Donacion> datos = FXCollections.observableArrayList();
			
		//Atributos necesarios para codificar la edicion
			private boolean edicion;
			private int indiceedicion;
			
			//inial al cargar
			public void initialize() throws SQLException{
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
			 
				// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

				ConexionBBDD con = new ConexionBBDD();
				datos = con.bbddObtenerDonaciones();

				tabla.setItems(datos);

				col_NUM_DONACION.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("NUM_DONACION"));
				col_COD_COLECTA.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("COD_COLECTA"));
				col_TIPO_DONACION.setCellValueFactory(new PropertyValueFactory<Donacion,String>("TIPO_DONACION"));
				col_PULSO.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("PULSO"));
				col_TA_SIST.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("TA_SIST"));
				col_TA_DIAST.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("TA_DIAST"));
				col_HB_CAP.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("HB_CAP"));
				col_HB_VEN.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("HB_VEN"));
				col_FECHA.setCellValueFactory(new PropertyValueFactory<Donacion,String>("FECHA"));
				
				// Al arrancar la vista se pone edicion a false
				edicion = false;
				indiceedicion = 0;
			}
			

			//***********************************BBDDGUARDAR(INSERTAR DONACION)******************************
			public void Guardar() throws SQLException{

			// Añadir un chequeo de campos vacíos o de validación de formato como el email
				if(NUM_DONACION.getText().equals("") || COD_COLECTA.getText().equals("") || TA_SIST.getText().equals("") || TA_DIAST.getText().equals("") || HB_CAP.getText().equals("") || HB_VEN.getText().equals("")){
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
						int res = con.ModificarDonacion(NUM_DONACION.getText(), COD_COLECTA.getText(), TIPO_DONACION.getButtonCell().getText(), PULSO.getButtonCell().getText(), TA_SIST.getText(), TA_DIAST.getText(), HB_CAP.getText(), HB_VEN.getText(), FECHA.getAccessibleText());
						switch (res){

							case 0:
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("OK!");
							alert.setHeaderText("Modificación OK!");
							alert.setContentText("¡Persona modificada con éxito!");
							alert.showAndWait();

							// Actualizo los datos de la tabla
							datos = con.bbddObtenerDonaciones();
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
									int res = con.InsertarDonacion(NUM_DONACION.getText(), COD_COLECTA.getText(), TIPO_DONACION.getButtonCell().getText(), PULSO.getButtonCell().getText(), TA_SIST.getText(), TA_DIAST.getText(), HB_CAP.getText(), HB_VEN.getText(), FECHA.getAccessibleText());
									
								
									switch (res){

									case 0:
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("OK!");
										alert.setHeaderText("Inserción OK!");
										alert.setContentText("¡Persona insertada con éxito!");
										alert.showAndWait();

										// Actualizo los datos de la tabla
										datos = con.bbddObtenerDonaciones();
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
						
					
					//***********************************BBDD ELIMINAR(ELIMINAR DONACION)******************************
			public void Eliminar() throws SQLException{
				int index = tabla.getSelectionModel().getSelectedIndex();
				if( index >= 0){

					Donacion seleccionada = tabla.getSelectionModel().getSelectedItem();

					// Se abre un dialog box de confirmacion de eliminar
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Conformación!!!");
					alert.setHeaderText("Por favor confirme el borrado");
					alert.setContentText("Dese borrar la donacion "+ seleccionada.getNUM_DONACION() +" ?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
					    // ... user chose OK

						// Llamar a un método que realice el DELETE en la base de datos
						ConexionBBDD con = new ConexionBBDD();
						int res = con.BorrarPersona(seleccionada.getNUM_DONACION());
						switch(res){
							case 0:
								alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("OK!");
								alert.setHeaderText("Borrado OK!");
								alert.setContentText("¡Persona borrada con éxito!");
								alert.showAndWait();

								// Actualizo los datos de la tabla
								datos = con.bbddObtenerDonaciones();
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
				NUM_DONACION.setText("");
				COD_COLECTA.setText("");
				TA_SIST.setText("");
				TA_DIAST.setText("");
				HB_CAP.setText("");
				HB_VEN.setText("");
				edicion = false;
				indiceedicion = 0;
			}

			//***********************************BBDD EDITAR(EDITAR DONACION)******************************
			public void Editar(){


				int index = tabla.getSelectionModel().getSelectedIndex();


				if( index >= 0){

					// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
					edicion = true;
					indiceedicion = index;


					Donacion seleccionada = tabla.getSelectionModel().getSelectedItem();
					NUM_DONACION.setPromptText(seleccionada.getNUM_DONACION());
					COD_COLECTA.setText(seleccionada.getCOD_COLECTA());
					TIPO_DONACION.setPromptText(seleccionada.getTIPO_DONACION());
					PULSO.setPromptText(seleccionada.getPULSO());
					TA_SIST.setText(seleccionada.getTA_SIST());
					TA_DIAST.setText(seleccionada.getTA_DIAST());
					HB_CAP.setText(seleccionada.getHB_CAP());
					HB_VEN.setText(seleccionada.getHB_VEN());
					FECHA.setAccessibleText(seleccionada.getFECHA());
				}
			}

			public void Buscar() throws SQLException{

				String buscar = TextFieldBuacarTipoDonacion.getText();
				System.out.println(buscar);
				// llama a un  método  que haga el select de la base de datos
				ConexionBBDD con = new ConexionBBDD();
				datos = con.BuscarPersonas(buscar);

				tabla.setItems(datos);


			}

			
}
		 
		
