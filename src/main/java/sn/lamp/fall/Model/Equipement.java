package sn.lamp.fall.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Equipement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String equipement;
	private int nombre;
	private int puissance;
	private int nombreHeureUtilisation;
	private Long client_id;
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
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	
	
	

}
