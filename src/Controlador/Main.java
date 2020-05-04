package Controlador;

import java.io.IOException;

import Vista.ControladoraDonacion;
import Vista.ControladoraDonante;

import Vista.ControladoraPrincipal;
import Vista.Controladorainformes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main  extends Application{

	 private static Stage stagePrincipal;
	    private AnchorPane rootPane;

	    @Override
	    public void start(Stage stagePrincipal) throws Exception {
	        Main.stagePrincipal = stagePrincipal;
	        mostrarVentanaPrincipal();

	    }

	    /* En un proyecto JavaFX el main llama al launch que a su vez llama a start */
	    public static void main(String[] args) {
	        launch(args);
	    }

	    /*
	     * cargamos la ventana principal
	     */
	    public void mostrarVentanaPrincipal() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/VentanaPrincipal.fxml"));
	            rootPane=(AnchorPane) loader.load();
	            Scene scene = new Scene(rootPane);
	            stagePrincipal.setTitle("Ventana Principal");
	            stagePrincipal.setScene(scene);
	            /*
	             * Añadidos las llamadas del main al Controlador y del controlador al main ***/
	             ControladoraPrincipal controller = loader.getController();
	             controller.setProgramaPrincipal(this);

	            stagePrincipal.show();
	        } catch (IOException e) {
	            //tratar la excepción.
	        }
	   }
    
	    
	    /* Este método es llamado cuando se presiona el botón de la ventana principal
	     * Lo llama el controlador de la vista principal
	     */
	    
	 //METODOS CONTROLADORA PRINCIPAL
	   //Ventana donantes  
	    public void mostrarVentanaDonante() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/PantallaDonantes.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Ventana Donantes");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            ControladoraDonante controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        }
	    }
	    
	  //Ventana donantes  
	    public void mostrarVentanaDonaciones() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/PantallaDonacion.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Ventana Donacion");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            ControladoraDonacion controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        }
	    }
	    
	  //Ventana informes y estadisticas 
	    public void mostrarVentanainformes() {
	        try {
	            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/Pantallainformes.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Ventana Informes");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(stagePrincipal);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            Controladorainformes controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        }
	    }
	    
	   
	  

}
