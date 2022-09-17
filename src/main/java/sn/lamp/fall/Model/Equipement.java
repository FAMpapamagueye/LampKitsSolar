package sn.lamp.fall.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Equipement {
	@Id
	private long id;
	private String equipement;
	private int nombre;
	private int puissance;
	private int nombreHeureUtilisation;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEquipement() {
		return equipement;
	}
	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public int getNombreHeureUtilisation() {
		return nombreHeureUtilisation;
	}
	public void setNombreHeureUtilisation(int nombreHeureUtilisation) {
		this.nombreHeureUtilisation = nombreHeureUtilisation;
	}
	

}
