package sn.lamp.fall.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.lamp.fall.Model.Devis;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long>{
	@Query("SELECT DISTINCT r FROM Devis r WHERE r.client_id=:id ")
	List<Devis> findByListId(@Param("id") Long id);
}
