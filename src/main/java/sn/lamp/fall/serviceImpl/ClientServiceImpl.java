package sn.lamp.fall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.fall.DAO.ClientRepository;
import sn.lamp.fall.Model.Client;
import sn.lamp.fall.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService{
@Autowired
private ClientRepository clientRepository;
	@Override
	public void save(Client C) {
		// TODO Auto-generated method stub
		clientRepository.save(C);
		
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).get();
	}

}
