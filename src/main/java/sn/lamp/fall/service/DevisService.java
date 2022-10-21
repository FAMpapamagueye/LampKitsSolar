package sn.lamp.fall.service;

import java.util.List;

import sn.lamp.fall.Model.Devis;

public interface DevisService {

	void save(Devis D);

	List<Devis> getAll();

	Devis findById(Long id);

	List<Devis> findByListId(Long id);

}
