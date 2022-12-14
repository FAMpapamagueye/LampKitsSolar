package sn.lamp.fall.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.lamp.fall.Model.Equipement;
@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
	@Query("SELECT DISTINCT r FROM Equipement r WHERE r.client_id=:id ")
	List<Equipement> findByListId(@Param("id") Long id);
}
