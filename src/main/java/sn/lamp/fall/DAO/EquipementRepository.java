package sn.lamp.fall.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.lamp.fall.Model.Equipement;
@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

}
