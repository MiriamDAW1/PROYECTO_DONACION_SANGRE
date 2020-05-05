package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

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
						System.out.println("Conexión establecida");

						//conexion.close();
					}
					else
						System.out.println("Fallo en Conexión");


				}catch (Exception e) {
					System.out.println("ERROR en conexión con ORACLE");
					e.printStackTrace();
				}

			}

		
		
		//*************************METODOS APLICACION*****************************************
		
		
		
		
	}

