package sn.lamp.fall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sn.lamp.fall.DAO.EquipementRepository;
import sn.lamp.fall.Model.Equipement;
import sn.lamp.fall.service.EquipementService;

public class EquipementImpl implements EquipementService {
@Autowired
  private EquipementRepository equipementRepository;
	@Override
	public void saveEquipement(Equipement E) {
		equipementRepository.save(E);
		

	}

	@Override
	public Equipement updatEquipement(Equipement E) {
		
		return equipementRepository.save(E);
	}

	@Override
	public void deleteEquipe(Long id) {
		equipementRepository.deleteById(id);

	}

	@Override
	public List<Equipement> getAll() {
		
		return equipementRepository.findAll();
	}

	@Override
	public Equipement findById(Long id) {
		
		return equipementRepository.findById(id).get();
	}

}
