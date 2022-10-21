package sn.lamp.fall.Utils;

import java.util.List;

import sn.lamp.fall.Model.Equipement;

public class Constant {
	public static String SESSION_ID_UTILISATEUR = "user_id";
	public static String SESSION_TIME_OUT = "time_out";
	public static String CLIENT = "client";
	public static String CLIENTS = "clients";
	public static String PERSONAL_BY_ID = "Personal_By_Id";
	public static String DECONNEXION = "deconnexion";
	public static String EQUIPEMENT = "Equipement";
	public static String EQUIPEMENTS = "Equipements";
	public static String DEVI = "devi";
	public static String DEVIS = "devis";

	public static double Puissance_onduleur(List<Equipement> E) {
		double PT = 0;
		for (Equipement equi : E) {

			PT += equi.getPuissance() * equi.getNombre();
		}
		return PT;
	}

	public static double Energie_consomme(List<Equipement> E) {
		double ET = 0;
		for (Equipement equi : E) {

			ET += equi.getPuissance() * equi.getNombre() * equi.getNombreHeureUtilisation();
		}
		return ET;
	}

	public static double Puissance_onduleur(double PT) {
		return PT / 0.96;

	}

	public static double Puissance_max_requise(double PT) {
		return PT / 0.98;

	}

	public static double Puissance_PV_installée(double ET) {
		return ET / 4.24;

	}

	public static double Capacite_batterie(double ET) {
		return ((ET / (0.8 * 0.6)) / 24);
	}

	public static double Nombre_batteries(double Cbatt) {
		return Cbatt / 125;
	}

}
