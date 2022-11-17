package octans.co.com.prueba.service.impl;

import octans.co.com.prueba.dao.IRolDao;
import octans.co.com.prueba.entitie.Rol;
import octans.co.com.prueba.mapper.IRolMapper;
import octans.co.com.prueba.model.RolModel;
import octans.co.com.prueba.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    private final IRolMapper rolMapper;
    private final IRolDao rolDao;

    @Autowired
    public RolService(IRolMapper rolMapper, IRolDao rolDao) {
        this.rolMapper = rolMapper;
        this.rolDao = rolDao;
    }

    @Override
    public RolModel getRolForName(String name){
        return rolMapper.mapFromEntity(rolDao.getByNombre(name));
    }

    @Override
    public List<RolModel> getRoles() {
        List<Rol> listRol = rolDao.findAll();
        return rolMapper.mapListRol(listRol);
    }

}
