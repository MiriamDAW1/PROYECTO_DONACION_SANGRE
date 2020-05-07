package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

		//*******************************DONACCION*********************************
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

							int NUM_DONACION = resultado.getInt(1);
							int COD_COLECTA = resultado.getInt(2);
							String TIPO_DONACION = resultado.getString(3);
							int PULSO = resultado.getInt(4);
							int TA_SIST = resultado.getInt(5);
							int TA_DIAST = resultado.getInt(6);
							int HB_CAP = resultado.getInt(7);
							int HB_VEN = resultado.getInt(8);
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
		
				

			
				






				
		
		
	}

