package octans.co.com.prueba.mapper.impl;

import octans.co.com.prueba.entitie.Rol;
import octans.co.com.prueba.mapper.IRolMapper;
import octans.co.com.prueba.model.RolModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RolMapper implements IRolMapper {

    @Override
    public RolModel mapFromEntity(Rol rol){
        return new RolModel(rol.getIdRol(), rol.getNombre());
    }

    @Override
    public List<RolModel> mapListRol(List<Rol> listRol){
        List<RolModel> listRolModel = new LinkedList<>();
        for(Rol rol: listRol)
            listRolModel.add(mapFromEntity(rol));
        return listRolModel;
    }
}
