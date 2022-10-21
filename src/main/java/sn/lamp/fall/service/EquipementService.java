package sn.lamp.fall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sn.lamp.fall.Model.Equipement;

public interface EquipementService {
	List<Equipement> getAll();
	Equipement findById(Long id);
	void saveEquipement(Equipement E);
	Equipement updatEquipement(Equipement E);
	void deleteEquipe(Long id);
	List<Equipement> findByListId(Long id);

}
