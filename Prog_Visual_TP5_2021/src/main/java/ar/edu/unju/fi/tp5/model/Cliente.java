package ar.edu.unju.fi.tp5.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private String tipoDocumento;
	private int nroDocumento;
	private String apellidoNombre;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int edad;
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String tipoDocumento, int nroDocumento, String apellidoNombre, String email, String password,
			LocalDate fechaNacimiento, int edad, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.apellidoNombre = apellidoNombre;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getApellidoNombre() {
		return apellidoNombre;
	}

	public void setApellidoNombre(String apellidoNombre) {
		this.apellidoNombre = apellidoNombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		this.edad = calcularEdad();
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		int edadd = periodo.getYears();
		return edadd;	
	}	
	
	
	public String tDesdeUltimaCompra() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaUltimaCompra, hoy);
		//String ultimaCompra = periodo.getYears() + "-" + periodo.getMonths() + 
		//		"-" + periodo.getDays();
		String ultimaCompra = periodo.getYears() + " Años - " + periodo.getMonths() + " Meses - " + 
							  periodo.getDays() + " Dias";
		return ultimaCompra;
	}	
	
	public long tDesdeFechaNacimiento() {
		LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime fechaNacLDT = LocalDateTime.of(this.fechaNacimiento, LocalTime.of(0,0,0));
      
        Duration duration = Duration.between(fechaNacLDT,hoy);
        long dias = duration.toDaysPart();
		return dias;	
	}
	
	public String tHastaProxCumple() {
		
		LocalDateTime fechaNacLDT = LocalDateTime.of(this.fechaNacimiento, LocalTime.of(0,0,0));
		LocalDateTime hoyLDT = LocalDateTime.now();
		LocalDateTime proximoCumpleLDT = fechaNacLDT.withYear(hoyLDT.getYear());
		
		if (proximoCumpleLDT.isBefore(hoyLDT) || proximoCumpleLDT.isEqual(hoyLDT)) {
        	proximoCumpleLDT = proximoCumpleLDT.plusYears(1);
		}
		
        Duration duracion = Duration.between(hoyLDT,proximoCumpleLDT);
        int horas = duracion.toHoursPart();
        int minutos = duracion.toMinutesPart();
        int segundos = duracion.toSecondsPart();
        
        LocalDate hoy = LocalDate.now();
        LocalDate proximoCumple = proximoCumpleLDT.toLocalDate();
        Period periodo = Period.between(hoy,proximoCumple);
        /*int anio = periodo.getYears();*/
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        
        String tiempoProximoCumple = meses + " meses - " + dias  + " dias - " + horas  + " horas - " 
        							+ minutos + " minutos - " + segundos + " segundos";
        if ((meses == 0 ) && (dias == 0)){
        	tiempoProximoCumple = "Feliz Cumpleaños!!!";
        }
        return tiempoProximoCumple;
        

	}

	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", apellidoNombre="
				+ apellidoNombre + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono="
				+ nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}
	
	
	
	
	
	

}
