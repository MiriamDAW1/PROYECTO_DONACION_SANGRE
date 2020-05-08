package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import oracle.sql.BLOB;

public class ConexionBBDD {
	
		private String url= "jdbc:oracle:thin:@localhost:1521:XE";
		private String usr = "";
		private String esptrab = "";
		private String pwd = "";
		private Connection conexion;


		public ConexionBBDD()  {
			Properties propiedades = new Properties();
			InputStream entrada = null;
			
			try {
				File miFichero = new File("src/Modelo/datos.ini");
				if (miFichero.exists()){
					entrada = new FileInputStream(miFichero);
					propiedades.load(entrada);
					url=propiedades.getProperty("url");
					usr=propiedades.getProperty("usr");
					esptrab=propiedades.getProperty("esptrab");
					pwd=propiedades.getProperty("pwd");
					
				}

				else
					System.out.println("Fichero no encontrado");
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				if (entrada != null) {
					try {
						entrada.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conexion = DriverManager.getConnection(url, usr, pwd);

					if(!conexion.isClosed()) {
						System.out.println("Conexi�n establecida");

						//conexion.close();
					}
					else
						System.out.println("Fallo en Conexi�n");


				}catch (Exception e) {
					System.out.println("ERROR en conexi�n con ORACLE");
					e.printStackTrace();
				}

			}

		
		
		
		//*************************METODOS APLICACION*****************************************
		
		//*******************************DONANTE*********************************
		//metodo bbddObtenerDonantes
		public ObservableList<Donante> bbddObtenerDonantes() throws SQLException{
			
			ObservableList<Donante> listaDonantes = FXCollections.observableArrayList();

			//Preparo la conexi�n para ejecutar sentencias SQL de tipo update
			Statement stm = conexion.createStatement();

			// Preparo la sentencia SQL CrearTablaPersonas
			String selectsql = "SELECT * FROM "+ esptrab+".DONANTE";

			//ejecuto la sentencia
			try{
				ResultSet resultado = stm.executeQuery(selectsql);

				int contador = 0;
				while(resultado.next()){
					contador++;

					int NUM_DONANTE = resultado.getInt(1);
					String NOMBRE = resultado.getString(2);
					String APELLIDO1 = resultado.getString(3);
					String APELLIDO2 = resultado.getString(4);
					String DNI=resultado.getString(5);
					String FECHA_NACIMIENTO=resultado.getString(6);
					String PAIS_NACIMIENTO=resultado.getString(7);
					String DIRECCION=resultado.getString(8);
					String POBLACION=resultado.getString(9);
					int CODIGO_POSTAL=resultado.getInt(10);
					int TELEFONO=resultado.getInt(11);
					int TELEFONO2=resultado.getInt(12);
					String CORREO_ELECTRONICO=resultado.getString(13);
					char SEXO = resultado.getString(14).charAt(0);
					String GRUPO_SANGUINEO=resultado.getString(15);
					Blob FOTO=resultado.getBlob(16);
					
					Donante nueva = new Donante(NUM_DONANTE, NOMBRE, APELLIDO1,APELLIDO2,DNI,FECHA_NACIMIENTO,PAIS_NACIMIENTO,DIRECCION,POBLACION,CODIGO_POSTAL,TELEFONO,TELEFONO2,CORREO_ELECTRONICO,SEXO,GRUPO_SANGUINEO,FOTO);
					listaDonantes.add(nueva);
				}

				if(contador==0)
					System.out.println("no data found");

			}catch(SQLException sqle){

				int pos = sqle.getMessage().indexOf(":");
				String codeErrorSQL = sqle.getMessage().substring(0,pos);

				System.out.println(codeErrorSQL);
			}

			return listaDonantes;
		}

		
				
			
		
//*******************************DONACCION**********************************************************
		//metodo bbddObtenerDonaciones
			public ObservableList<Donacion> bbddObtenerDonaciones() throws SQLException{
	
			ObservableList<Donacion> listaDonantes = FXCollections.observableArrayList();

			//Preparo la conexi�n para ejecutar sentencias SQL de tipo update
				Statement stm = conexion.createStatement();

					// Preparo la sentencia SQL CrearTablaPersonas
					String selectsql = "SELECT * FROM "+ esptrab+".DONACION";

					//ejecuto la sentencia
					try{
						ResultSet resultado = stm.executeQuery(selectsql);

						int contador = 0;
						while(resultado.next()){
							contador++;

							String NUM_DONACION = resultado.getString(1);
							String COD_COLECTA = resultado.getString(2);
							String TIPO_DONACION = resultado.getString(3);
							String PULSO = resultado.getString(4);
							String TA_SIST = resultado.getString(5);
							String TA_DIAST = resultado.getString(6);
							String HB_CAP = resultado.getString(7);
							String HB_VEN = resultado.getString(8);
							String FECHA = resultado.getString(9);
							
							Donacion nueva = new Donacion(NUM_DONACION,COD_COLECTA,TIPO_DONACION,PULSO,TA_SIST,TA_DIAST,HB_CAP,HB_VEN,FECHA);
							listaDonantes.add(nueva);
						}

						if(contador==0)
							System.out.println("no data found");

					}catch(SQLException sqle){

						int pos = sqle.getMessage().indexOf(":");
						String codeErrorSQL = sqle.getMessage().substring(0,pos);

						System.out.println(codeErrorSQL);
					}

					return listaDonantes;
				}
		
				

			/*
			 * El m�todo InsertarDonacion devuelve un c�digo de error para los siguientes casos:
			 *
			 * 0 - Persona insertada OK!
			 * 1 - Se ha queriro introducir uan persona con un email existente (Primary key violated)
			 * 2 - Otro fallo en el tipo de datos o en la base de datos al hacer la inserci�n
			 *
			 *
			 */
			public int InsertarDonacion(String NUM_DONACION,String COD_COLECTA,String TIPO_DONACION, String PULSO,String TA_SIST, String TA_DIAST,String HB_CAP,String HB_VEN,String FECHA) throws SQLException{
				
				// Preparo la sentencia SQL CrearTablaPersonas
				String insertsql = "INSERT INTO " + esptrab+".DONACION VALUES (?,?,?,?,?,?,?,?,?)";

				//Seguridad en las Aplicaciones: SQL Injection

				PreparedStatement pstmt = conexion.prepareStatement (insertsql);
				pstmt.setString(1, NUM_DONACION);
				pstmt.setString(2, COD_COLECTA);
				pstmt.setString(3, TIPO_DONACION);
				pstmt.setString(4, PULSO);
				pstmt.setString(5, TA_SIST);
				pstmt.setString(6, TA_DIAST);
				pstmt.setString(7, HB_CAP);
				pstmt.setString(8, HB_VEN);
				pstmt.setString(9,FECHA);
				
				
				//ejecuto la sentencia
				try{
					int resultado = pstmt.executeUpdate();//pstmt y tiene que estar vacio

					if(resultado != 1)
						System.out.println("Error en la inserci�n " + resultado);
					else
						System.out.println("Persona insertada con �xito!!!");

					return 0;
				}catch(SQLException sqle){

					int pos = sqle.getMessage().indexOf(":");
					String codeErrorSQL = sqle.getMessage().substring(0,pos);

					if(codeErrorSQL.equals("ORA-00001") ){
						System.out.println("Ya existe una persona con  ese email!!");
						return 1;
					}
					else{
						System.out.println("Ha habido alg�n problema con  Oracle al hacer la insercion");
						return 2;
					}

				}

			}
			
			
			/*
			 * El m�todo ModificarDonacion devuelve un c�digo de error para los siguientes casos:
			 *
			 * 0 - Persona insertada OK!
			 * 1 - Se ha queriro introducir uan persona con un email existente (Primary key violated)
			 * 2 - Otro fallo en el tipo de datos o en la base de datos al hacer la inserci�n
			 *
			 *
			 */
			public int ModificarDonacion(String NUM_DONACION,String COD_COLECTA,String TIPO_DONACION, String PULSO,String TA_SIST, String TA_DIAST,String HB_CAP,String HB_VEN,String FECHA) throws SQLException{

				// Preparo la sentencia SQL CrearTablaPersonas
				String updatesql = "UPDATE " + esptrab+".DONACION SET COD_COLECTA=?,TIPO_DONACION=?,PULSO=?,TA_SIST=?,TA_DIAST=?,HB_CAP=?,HB_VEN=?,FECHA=? WHERE NUM_DONACION=?";

				//Seguridad en las Aplicaciones: SQL Injection

						PreparedStatement pstmt = conexion.prepareStatement (updatesql);
						pstmt.setString(1, NUM_DONACION);
						pstmt.setString(2, COD_COLECTA);
						pstmt.setString(3, TIPO_DONACION);
						pstmt.setString(4, PULSO);
						pstmt.setString(5, TA_SIST);
						pstmt.setString(6, TA_DIAST);
						pstmt.setString(7, HB_CAP);
						pstmt.setString(8, HB_VEN);
						pstmt.setString(9,FECHA);
						
						
				//ejecuto la sentencia
				try{
					int resultado = pstmt.executeUpdate(); //pstmt y tiene que estar vacio

					if(resultado != 1)
						System.out.println("Error en la actualizaci�n " + resultado);
					else
						System.out.println("Persona actualizada con �xito!!!");

					return 0;
				}catch(SQLException sqle){

					int pos = sqle.getMessage().indexOf(":");
					String codeErrorSQL = sqle.getMessage().substring(0,pos);

					if(codeErrorSQL.equals("ORA-00001") ){
						System.out.println("Ya existe una persona con  ese email!!");
						return 1;
					}
					else{
						System.out.println("Ha habido alg�n problema con  Oracle al hacer la insercion");
						return 2;
					}

				}

			}
			
			//eliminar Donacion
			public int BorrarPersona(String NUM_DONACION) throws SQLException{

				// Preparo la sentencia SQL
				String deletesql = "DELETE "+ esptrab+".DONACION WHERE NUM_DONACION=?";

				//Seguridad en las Aplicaciones: SQL Injection

				PreparedStatement pstmt = conexion.prepareStatement (deletesql);
				pstmt.setString(1, NUM_DONACION);
				
				//ejecuto la sentencia
				try{
					int resultado = pstmt.executeUpdate();//pstmt y tiene que estar vacio

					if(resultado != 1)
						System.out.println("Error en el borrado " + resultado);
					else
						System.out.println("Persona borrada con �xito!!!");

					return 0;
				}catch(SQLException sqle){

					int pos = sqle.getMessage().indexOf(":");
					String codeErrorSQL = sqle.getMessage().substring(0,pos);

					System.out.println("Ha habido alg�n problema con  Oracle al hacer el borrado" + codeErrorSQL);
					return 2;
				}

			}

			//buscar por tipo de donacion
			public ObservableList<Donacion> BuscarPersonas(String tipodonacion) throws SQLException{

				ObservableList<Donacion> listapersonas = FXCollections.observableArrayList();		
				
				// Preparo la sentencia SQL en funci�n de lo que venga en apellido
				String selectsql ="SELECT * FROM "+ esptrab+".DONACION WHERE TIPO_DONACION LIKE ?";

				
				//Seguridad en las Aplicaciones: SQL Injection
				PreparedStatement pstmt = conexion.prepareStatement (selectsql);
				pstmt.setString(1, tipodonacion + "%");
				
				//ejecuto la sentencia
				try{
					ResultSet resultado = pstmt.executeQuery();//pstmt y tiene que estar vacio

					int contador = 0;
					while(resultado.next()){
						contador++;
						
						String NUM_DONACION = resultado.getString(1);
						String COD_COLECTA = resultado.getString(2);
						String TIPO_DONACION = resultado.getString(3);
						String PULSO = resultado.getString(4);
						String TA_SIST = resultado.getString(5);
						String TA_DIAST = resultado.getString(6);
						String HB_CAP = resultado.getString(7);
						String HB_VEN = resultado.getString(8);
						String FECHA = resultado.getString(9);
						
						Donacion nueva = new Donacion(NUM_DONACION, COD_COLECTA, TIPO_DONACION,PULSO,TA_SIST,TA_DIAST,HB_CAP,HB_VEN,FECHA);
						listapersonas.add(nueva);
					}

					if(contador==0)
						System.out.println("no data found");

				}catch(SQLException sqle){

					int pos = sqle.getMessage().indexOf(":");
					String codeErrorSQL = sqle.getMessage().substring(0,pos);

					System.out.println(codeErrorSQL);
				}

				return listapersonas;
			}






				
		
		
	}

