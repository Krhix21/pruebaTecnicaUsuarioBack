package octans.co.com.prueba.mapper;

import octans.co.com.prueba.entitie.Rol;
import octans.co.com.prueba.model.RolModel;

import java.util.List;

public interface IRolMapper {

    RolModel mapFromEntity(Rol rol);

    List<RolModel> mapListRol(List<Rol> listRol);
}
