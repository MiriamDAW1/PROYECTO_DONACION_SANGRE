package Modelo;

public class Donacion {
	//atributos
	private String NUM_DONACION;
	private String COD_COLECTA;
	private String TIPO_DONACION;
	private String PULSO;
	private String TA_SIST;
	private String TA_DIAST;
	private String HB_CAP;
	private String HB_VEN;
	private String FECHA;
	
	//constructor

	public Donacion(String nUM_DONACION, String cOD_COLECTA, String tIPO_DONACION, String pULSO, String tA_SIST,
			String tA_DIAST, String hB_CAP, String hB_VEN, String fECHA) {
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
	public String getNUM_DONACION() {
		return NUM_DONACION;
	}

	public void setNUM_DONACION(String nUM_DONACION) {
		NUM_DONACION = nUM_DONACION;
	}

	public String getCOD_COLECTA() {
		return COD_COLECTA;
	}

	public void setCOD_COLECTA(String cOD_COLECTA) {
		COD_COLECTA = cOD_COLECTA;
	}

	public String getTIPO_DONACION() {
		return TIPO_DONACION;
	}

	public void setTIPO_DONACION(String tIPO_DONACION) {
		TIPO_DONACION = tIPO_DONACION;
	}

	public String getPULSO() {
		return PULSO;
	}

	public void setPULSO(String pULSO) {
		PULSO = pULSO;
	}

	public String getTA_SIST() {
		return TA_SIST;
	}

	public void setTA_SIST(String tA_SIST) {
		TA_SIST = tA_SIST;
	}

	public String getTA_DIAST() {
		return TA_DIAST;
	}

	public void setTA_DIAST(String tA_DIAST) {
		TA_DIAST = tA_DIAST;
	}

	public String getHB_CAP() {
		return HB_CAP;
	}

	public void setHB_CAP(String hB_CAP) {
		HB_CAP = hB_CAP;
	}

	public String getHB_VEN() {
		return HB_VEN;
	}

	public void setHB_VEN(String hB_VEN) {
		HB_VEN = hB_VEN;
	}

	public String getFECHA() {
		return FECHA;
	}

	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	
	
	
	
}