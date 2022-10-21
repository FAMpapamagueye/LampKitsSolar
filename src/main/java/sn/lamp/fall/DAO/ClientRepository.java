package sn.lamp.fall.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.fall.Model.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
