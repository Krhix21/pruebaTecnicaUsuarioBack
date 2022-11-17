package octans.co.com.prueba.dao;

import octans.co.com.prueba.entitie.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDao extends JpaRepository<Rol, Integer> {

    @Query(value = "SELECT rol FROM Rol rol where rol.nombre = :nombre", nativeQuery = false)
    Rol getByNombre(@Param("nombre") String nombre);
}
