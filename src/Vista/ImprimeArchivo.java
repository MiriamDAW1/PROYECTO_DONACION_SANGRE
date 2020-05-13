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



	/* Este método generará el PDF  */
	public void generarArchivoPDF(Donante seleccionada) throws FileNotFoundException, DocumentException {

		// Crea el nombre del archivo con el path, el nombre del  fichero y la extensión PDF
		String sFileNamePath = filepath + filename+".pdf";

		// Se crea el documento que se va a imprimir
		Document documento = new Document();


		// En principio el tamaño de la página está paara un A4 en vertical, pero puedes investigar y cambiar el tamaño de la zona de impresión
		// Eso sí... te tocará investigar y buscar: el método setPageSize
		//documento.setPageSize() Lo que le pases como  argumento

		System.out.println(sFileNamePath);

		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		documento.open();

		// La unidad para imprimir es el párrafo se pasa el texto del párrafo, se pueden poner saltos de línea dentro
		// el tipo, tamaño de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p1 = new Paragraph("CARNET DE DONANTE",
		FontFactory.getFont("arial",   // fuente
		12,                            // tamaño
		Font.BOLD));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p1.setAlignment(Element.ALIGN_CENTER);

		// Añade el párrafo al documeento
		documento.add(p1);

		Paragraph p2 = new Paragraph("NOMBRE: " + seleccionada.getNOMBRE() + "/n" +
				"APELLIDOS: " + seleccionada.getAPELLIDO1() + " " +seleccionada.getAPELLIDO2(),
				
				FontFactory.getFont("Garamond",   // fuente
				14,                            // tamaño
				Font.ITALIC));

		// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p2.setAlignment(Element.ALIGN_RIGHT);

		// Añade el párrafo al documeento
		documento.add(p2);


		// Meter una imagen

		try
		{
			String path = "src\\Vista\\imagen1.jpg";
			Image foto = Image.getInstance(path);
			foto.scaleToFit(200, 200);
			foto.setAbsolutePosition(20, 740);
			documento.add(foto);
		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}


		documento.close();
	}

}
