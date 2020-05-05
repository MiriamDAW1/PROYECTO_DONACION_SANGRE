package Modelo;

public class Donacion {
	//atributos
	private int NUM_DONACION;
	private int COD_COLECTA;
	private String TIPO_DONACION;
	private int PULSO;
	private int TA_SIST;
	private int TA_DIAST;
	private int HB_CAP;
	private int HB_VEN;
	private String FECHA;
	
	//constructor
	public Donacion(int nUM_DONACION, int cOD_COLECTA, String tIPO_DONACION, int pULSO, int tA_SIST, int tA_DIAST,
			int hB_CAP, int hB_VEN, String fECHA) {
		super();
		NUM_DONACION = nUM_DONACION;
		COD_COLECTA = cOD_COLECTA;
		TIPO_DONACION = tIPO_DONACION;
		PULSO = pULSO;
		TA_SIST = tA_SIST;
		TA_DIAST = tA_DIAST;
		HB_CAP = hB_CAP;
		HB_VEN = hB_VEN;
		FECHA = fECHA;
	}

	//getters y setters 
	public int getNUM_DONACION() {
		return NUM_DONACION;
	}

	public void setNUM_DONACION(int nUM_DONACION) {
		NUM_DONACION = nUM_DONACION;
	}

	public int getCOD_COLECTA() {
		return COD_COLECTA;
	}

	public void setCOD_COLECTA(int cOD_COLECTA) {
		COD_COLECTA = cOD_COLECTA;
	}

	public String getTIPO_DONACION() {
		return TIPO_DONACION;
	}

	public void setTIPO_DONACION(String tIPO_DONACION) {
		TIPO_DONACION = tIPO_DONACION;
	}

	public int getPULSO() {
		return PULSO;
	}

	public void setPULSO(int pULSO) {
		PULSO = pULSO;
	}

	public int getTA_SIST() {
		return TA_SIST;
	}

	public void setTA_SIST(int tA_SIST) {
		TA_SIST = tA_SIST;
	}

	public int getTA_DIAST() {
		return TA_DIAST;
	}

	public void setTA_DIAST(int tA_DIAST) {
		TA_DIAST = tA_DIAST;
	}

	public int getHB_CAP() {
		return HB_CAP;
	}

	public void setHB_CAP(int hB_CAP) {
		HB_CAP = hB_CAP;
	}

	public int getHB_VEN() {
		return HB_VEN;
	}

	public void setHB_VEN(int hB_VEN) {
		HB_VEN = hB_VEN;
	}

	public String getFECHA() {
		return FECHA;
	}

	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	
	
	
}
