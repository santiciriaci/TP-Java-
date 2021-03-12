package Entidades;

import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import Logica.TarifaLogic;



public class Ticket {

	private int id;
	private Timestamp fecha_horaIni;
	private Timestamp fecha_horaFin;
	private double importe;
	private String numpat;
	private Auto auto;
	private Tarifa tarifa;
	
	public Ticket() {
		
	}
	
	public Ticket(int id, Timestamp fecha_horaIni, Timestamp fecha_horaFin, double importe, Auto auto,
			Tarifa tarifa) {
		super();
		this.id = id;
		this.fecha_horaIni = fecha_horaIni;
		this.fecha_horaFin = fecha_horaFin;
		this.importe = importe;
		this.auto = auto;
		this.tarifa = tarifa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getFecha_horaIni() {
		return fecha_horaIni;
	}
	public void setFecha_horaIni(Timestamp dia_hora) {
		this.fecha_horaIni = dia_hora;
	}
	public Timestamp getFecha_horaFin() {
		return fecha_horaFin;
	}
	public void setFecha_horaFin(Timestamp fecha_horaFin) {
		this.fecha_horaFin = fecha_horaFin;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) throws SQLException, ParseException {
		if(this.getFecha_horaFin()==null) {
			
		this.importe = this.calculaImporte(this.getFecha_horaIni(),this.getFecha_horaFin(),this.getID_tarifa());}
		
		else {this.importe = importe;};
		
	}
	

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getPatente() {
		return auto.getPatente();
	}
	public int getID_tarifa() {
		return tarifa.getIDtarifa();
	}
	
	public String getNumpat() {
		
		return numpat;
	}

	public void setNumpat(String numpat) {
		this.numpat = numpat;
	}

	public float calculaImporte(Timestamp fecini, Timestamp fecfin, int idtar) throws SQLException, ParseException {
		Tarifa tar = new Tarifa();
		TarifaLogic tarlog = new TarifaLogic();
		tar=tarlog.getActual();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fecinicio= fecini.toString();
		String fecfini= fecfin.toString();
		Date feci = (Date) format.parse(fecinicio);
		Date fecf = (Date) format.parse(fecfini);

		double importe =0;
		
		long diff=(fecf.getTime() - feci.getTime())/1000/60; //DIFF
		
		//DIAS
		long diffOnlyDays=(long) Math.floor(diff/60/24); //DIAS
		
		System.out.println("dias" + Math.floor(diff/60/24));
		if(diffOnlyDays > 0) {
			importe = diffOnlyDays * (tar.getEstadiaCompleta());
		}
		
		
		//HORAS
		long diffOnlyHs=(long) (Math.floor(diff/60)%24); //HORAS
		
		System.out.println("hs" + Math.floor(diff/60)%24);
		if(diffOnlyHs > 6) {
			importe = importe + ( tar.getMediaEstadia());
		
			long sobrante = diffOnlyHs-6;
			System.out.println(sobrante);
			if ((sobrante > 1) & (sobrante <6)) {
				importe = importe + (sobrante * (tar.getHora()));
		}}
		else {
			importe = importe + (diffOnlyHs * (tar.getHora()));
		}
		
		//MINUTOS
		long diffOnlyMin=(long) (Math.floor(diff%60)); //minutos
		
		System.out.println("min" + (Math.floor(diff%60)));
		if(diffOnlyMin > 15) {
			importe = importe + ((tar.getMediaHora()));}
		
		/*
		long diff=(fecf.getTime() - feci.getTime())/1000/60 
		long diffMin=Math.floor(diff);
		long diffOnlyMin=Math.floor(diff)%60; minutos
		long diffOnlyHs=Math.floor(diff/60)%24; horas
		long diffOnlyDays=Math.floor(diff/60/24); dias

		
		*/
		this.setImporte(importe);
		return (float) importe;
	}
	
	public ByteArrayOutputStream Pdf(boolean benefUsr, boolean benefDia) throws DocumentException, SQLException, ParseException{

        Document document = new Document();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	
        
        	double importe = 0;
        	importe = this.getImporte();
        	if(benefUsr==true) {
        		if(benefDia==true) {
        		importe=importe*0.7;
        		}
        		else {importe=importe*0.85;}
        	}
        	
        	if(benefDia==true && benefUsr==false) {
        		importe=importe*0.85;
        	}
        	
            PdfWriter.getInstance(document, baos);
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Paragraph par = new Paragraph("ID: "+this.getId()+"\r\n"+"Patente: "+this.getNumpat()+"\r\n"+"Fecha y hora de llegada:"+this.getFecha_horaIni()+"\r\n"+"Fecha y hora de salida:"+this.getFecha_horaFin()+"\r\n"+"Importe:"+importe,font);
            document.add(par);
            document.close();
        
            return baos;

    }
	

}
