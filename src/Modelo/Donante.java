package Modelo;

import java.sql.Blob;

import oracle.sql.BLOB;

public class Donante {
	//atributos
	private int NUM_DONANTE;
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String  DNI;
	private String FECHA_NACIMIENTO;
	private String PAIS_NACIMIENTO;
	private String DIRECCION;
	private String POBLACION;
	private int CODIGO_POSTAL;
	private int TELEFONO;
	private int TELEFONO2;
	private String CORREO_ELECTRONICO;
	private char SEXO;
	private String GRUPO_SANGUINEO;
	private Blob FOTO;
	
	//constructor
	public Donante(int nUM_DONANTE, String nOMBRE, String aPELLIDO1, String aPELLIDO2, String dNI,
			String fECHA_NACIMIENTO, String pAIS_NACIMIENTO, String dIRECCION, String pOBLACION, int cODIGO_POSTAL,
			int tELEFONO, int tELEFONO2, String cORREO_ELECTRONICO, char sEXO, String gRUPO_SANGUINEO, Blob fOTO) {
		super();
		NUM_DONANTE = nUM_DONANTE;
		NOMBRE = nOMBRE;
		APELLIDO1 = aPELLIDO1;
		APELLIDO2 = aPELLIDO2;
		DNI = dNI;
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
		PAIS_NACIMIENTO = pAIS_NACIMIENTO;
		DIRECCION = dIRECCION;
		POBLACION = pOBLACION;
		CODIGO_POSTAL = cODIGO_POSTAL;
		TELEFONO = tELEFONO;
		TELEFONO2 = tELEFONO2;
		CORREO_ELECTRONICO = cORREO_ELECTRONICO;
		SEXO = sEXO;
		GRUPO_SANGUINEO = gRUPO_SANGUINEO;
		FOTO = fOTO;
	}

	//getters y setters 
	public int getNUM_DONANTE() {
		return NUM_DONANTE;
	}

	public void setNUM_DONANTE(int nUM_DONANTE) {
		NUM_DONANTE = nUM_DONANTE;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getAPELLIDO1() {
		return APELLIDO1;
	}

	public void setAPELLIDO1(String aPELLIDO1) {
		APELLIDO1 = aPELLIDO1;
	}

	public String getAPELLIDO2() {
		return APELLIDO2;
	}

	public void setAPELLIDO2(String aPELLIDO2) {
		APELLIDO2 = aPELLIDO2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}

	public void setFECHA_NACIMIENTO(String fECHA_NACIMIENTO) {
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
	}

	public String getPAIS_NACIMIENTO() {
		return PAIS_NACIMIENTO;
	}

	public void setPAIS_NACIMIENTO(String pAIS_NACIMIENTO) {
		PAIS_NACIMIENTO = pAIS_NACIMIENTO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getPOBLACION() {
		return POBLACION;
	}

	public void setPOBLACION(String pOBLACION) {
		POBLACION = pOBLACION;
	}

	public int getCODIGO_POSTAL() {
		return CODIGO_POSTAL;
	}

	public void setCODIGO_POSTAL(int cODIGO_POSTAL) {
		CODIGO_POSTAL = cODIGO_POSTAL;
	}

	public int getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(int tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public int getTELEFONO2() {
		return TELEFONO2;
	}

	public void setTELEFONO2(int tELEFONO2) {
		TELEFONO2 = tELEFONO2;
	}

	public String getCORREO_ELECTRONICO() {
		return CORREO_ELECTRONICO;
	}

	public void setCORREO_ELECTRONICO(String cORREO_ELECTRONICO) {
		CORREO_ELECTRONICO = cORREO_ELECTRONICO;
	}

	public char getSEXO() {
		return SEXO;
	}

	public void setSEXO(char sEXO) {
		SEXO = sEXO;
	}

	public String getGRUPO_SANGUINEO() {
		return GRUPO_SANGUINEO;
	}

	public void setGRUPO_SANGUINEO(String gRUPO_SANGUINEO) {
		GRUPO_SANGUINEO = gRUPO_SANGUINEO;
	}

	public Blob getFOTO() {
		return FOTO;
	}

	public void setFOTO(Blob fOTO) {
		FOTO = fOTO;
	}
	
	
	
	
	

	

	
	
	
	
	
	
	
	
	
}
