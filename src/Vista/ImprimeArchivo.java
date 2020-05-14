package Vista;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Modelo.Donante;

public class ImprimeArchivo {
	private String filename;
	private String filepath;


	public ImprimeArchivo(String filename, String filepath) {
		super();
		this.filename = filename;
		this.filepath = filepath;
	}



	/* Este m�todo generar� el PDF  */
	public void generarArchivoPDF(Donante seleccionada) throws FileNotFoundException, DocumentException {

		// Crea el nombre del archivo con el path, el nombre del  fichero y la extensi�n PDF
		String sFileNamePath = filepath + filename+".pdf";

		// Se crea el documento que se va a imprimir
		Document documento = new Document();


		// En principio el tama�o de la p�gina est� paara un A4 en vertical, pero puedes investigar y cambiar el tama�o de la zona de impresi�n
		// Eso s�... te tocar� investigar y buscar: el m�todo setPageSize
		//documento.setPageSize() Lo que le pases como  argumento

		System.out.println(sFileNamePath);

		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		documento.open();

		// La unidad para imprimir es el p�rrafo se pasa el texto del p�rrafo, se pueden poner saltos de l�nea dentro
		// el tipo, tama�o de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p1 = new Paragraph( "NUM DONANTE:" +seleccionada.getNUM_DONANTE(),
		FontFactory.getFont("Curlz MT",   // fuente
		16,                            // tama�o
		Font.BOLD));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p1.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p1);

		Paragraph p2 = new Paragraph("                    "+"NOMBRE: " + seleccionada.getNOMBRE() + " GENERO: " + seleccionada.getSEXO(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p2);


		Paragraph p3 = new Paragraph("                                                              "+ "APELLIDOS: " + seleccionada.getAPELLIDO1() + seleccionada.getAPELLIDO2(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p3);

		Paragraph p4 = new Paragraph("                                                              "+ "DNI: " + seleccionada.getDNI(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p4);
		
		Paragraph p5 = new Paragraph("                                                              "+ "Fecha Nacimiento: " + seleccionada.getFECHA_NACIMIENTO(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p5);
		
		Paragraph p6 = new Paragraph("                                                              "+ "PAIS NACIMIENTO: " + seleccionada.getPAIS_NACIMIENTO(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p6);
		
		
		Paragraph p7 = new Paragraph("                                                              "+ "DIRECCION: " + seleccionada.getDIRECCION(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p7);
		
		Paragraph p8 = new Paragraph("                                                              "+ "POBLACION: " + seleccionada.getPOBLACION() + " CODIGO_POSTAL: " + seleccionada.getCODIGO_POSTAL(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p8);
		
		
		Paragraph p9 = new Paragraph("                                                              "+ "TELEFONO : " + seleccionada.getTELEFONO() + " TELEFONO 2: " + seleccionada.getTELEFONO2(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p9);
		
		
		
		Paragraph p10 = new Paragraph("                                                              "+ "CORREO ELECTRONICO : " + seleccionada.getCORREO_ELECTRONICO(),
				FontFactory.getFont("Garamond",   // fuente
				12,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
		p2.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		documento.add(p10);
		
		
		
		
		Paragraph p11 = new Paragraph("                                                                                                                                                                                                                        "+"GRUPO SANGUINEO:" +seleccionada.getGRUPO_SANGUINEO(),
				FontFactory.getFont("Curlz MT",   // fuente
				20,                            // tama�o
				Font.ITALIC));

				// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
				// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFIED
				p1.setAlignment(Element.ALIGN_CENTER);

				// A�ade el p�rrafo al documeento
				documento.add(p11);

		


		// Meter una imagen

		try
		{
			String path = "src\\Vista\\carnet donante.jpg";
			Image foto = Image.getInstance(path);
			foto.scaleToFit(550, 550);  
			foto.setAbsolutePosition(8, 440);
			documento.add(foto);
		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}

		


		documento.close();
	}

}
