package octans.co.com.prueba.service;

import octans.co.com.prueba.model.RolModel;

import java.util.List;

public interface IRolService {

    RolModel getRolForName(String name);

    List<RolModel> getRoles();
}
