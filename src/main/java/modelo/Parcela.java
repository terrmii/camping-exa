package modelo;

import java.util.ArrayList;
/**
 * 
 * @author Eñaut
 * Esta clase DTO representa la entidad
 * PARCELA de la BBDD
 *
 */
public class Parcela {
	//TODO crear los atributos pribados, setters y getters
	
	private int id;
	private String numero;
	private int mCuadrados;
	private double precioDia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getmCuadrados() {
		return mCuadrados;
	}
	public void setmCuadrados(int mCuadrados) {
		this.mCuadrados = mCuadrados;
	}
	public double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	
	
	
}
