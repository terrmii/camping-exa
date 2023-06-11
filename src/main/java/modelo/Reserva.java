package modelo;

import java.util.Date;

/**
 * 
 * @author Eñaut
 * Esta clase DTO representa la entidad
 * RESERVA de la BBDD
 *
 */
public class Reserva {
	//TODO crear los atributos pribados, setters y getters
	
	private int id;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String dniUsuario;
	private int numeroUsuarios;
	private Date inicioReserva;
	private Date finReserva;
	private Date fechaReserva;
	private boolean luz;
	private int idParcela;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}
	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}
	public Date getInicioReserva() {
		return inicioReserva;
	}
	public void setInicioReserva(Date inicioReserva) {
		this.inicioReserva = inicioReserva;
	}
	public Date getFinReserva() {
		return finReserva;
	}
	public void setFinReserva(Date finReserva) {
		this.finReserva = finReserva;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public boolean isLuz() {
		return luz;
	}
	public void setLuz(boolean luz) {
		this.luz = luz;
	}
	public int getIdParcela() {
		return idParcela;
	}
	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}
	
	
	
}
