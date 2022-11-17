package octans.co.com.prueba.service.impl;

import octans.co.com.prueba.dao.IUsuarioDao;
import octans.co.com.prueba.entitie.Usuario;
import octans.co.com.prueba.mapper.IUsuarioMapper;
import octans.co.com.prueba.model.UsuarioModel;
import octans.co.com.prueba.service.IRolService;
import octans.co.com.prueba.service.IUsuarioService;
import octans.co.com.prueba.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioMapper usuarioMapper;
    private final IUsuarioDao usuarioDao;
    private final IRolService rolService;

    @Autowired
    public UsuarioService(IUsuarioMapper usuarioMapper, IUsuarioDao usuarioDao, IRolService rolService) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioDao = usuarioDao;
        this.rolService = rolService;
    }

    @Override
    public List<UsuarioModel> getUsuarios() {
        List<Usuario> listUsuario = usuarioDao.findAll();
        return usuarioMapper.mapListUsuario(listUsuario);
    }

    @Override
    public UsuarioModel createUsuario(UsuarioModel usuarioModel) {
        if(usuarioDao.findById(usuarioModel.getIdUsuario()).isPresent())
            throw new RuntimeException(Constantes.IDUSUARIO_DUPLICADO);
        Usuario usuario = usuarioMapper.mapFromDTO(usuarioModel);
        return usuarioMapper.mapFromEntity(usuarioDao.save(usuario));
    }

    @Override
    public UsuarioModel modifiedUsuario(UsuarioModel usuarioModel) {
        usuarioDao.findById(usuarioModel.getIdUsuario()).orElseThrow(() -> new RuntimeException(Constantes.MENSAJE_NULO));
        usuarioModel.setRol(rolService.getRolForName(usuarioModel.getRol().getNombre()));
        Usuario usuario = usuarioMapper.mapFromDTO(usuarioModel);
        return usuarioMapper.mapFromEntity(usuarioDao.save(usuario));
    }

    @Override
    public UsuarioModel deleteUsuario(int idUsuario) {
        usuarioDao.findById(idUsuario).orElseThrow(() -> new RuntimeException(Constantes.MENSAJE_NULO));
        Usuario usuario = usuarioDao.getById(idUsuario);
        usuarioDao.deleteById(idUsuario);
        return usuarioMapper.mapFromEntity(usuario);
    }
}
