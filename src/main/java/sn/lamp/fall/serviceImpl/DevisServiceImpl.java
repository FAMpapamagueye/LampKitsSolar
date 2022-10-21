package sn.lamp.fall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.fall.DAO.DevisRepository;
import sn.lamp.fall.Model.Devis;
import sn.lamp.fall.service.DevisService;
@Service
public class DevisServiceImpl implements DevisService{
	@Autowired
  private DevisRepository devisRepository;
	@Override
	public void save(Devis D) {
		// TODO Auto-generated method stub
		devisRepository.save(D);
		
		
	}

	@Override
	public List<Devis> getAll() {
		// TODO Auto-generated method stub
		return devisRepository.findAll();
	}

	@Override
	public Devis findById(Long id) {
		// TODO Auto-generated method stub
		return devisRepository.findById(id).get();
	}

	@Override
	public List<Devis> findByListId(Long id) {
		// TODO Auto-generated method stub
		return devisRepository.findByListId(id);
	}

}
