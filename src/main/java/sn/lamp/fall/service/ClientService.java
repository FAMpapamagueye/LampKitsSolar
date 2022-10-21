package sn.lamp.fall.service;

import java.util.List;

import sn.lamp.fall.Model.Client;

public interface ClientService {
	void save(Client C);

	List<Client> getAll();

	Client findById(Long id);

}
