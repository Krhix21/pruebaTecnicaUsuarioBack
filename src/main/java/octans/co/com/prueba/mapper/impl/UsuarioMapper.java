package octans.co.com.prueba.mapper.impl;

import octans.co.com.prueba.entitie.Rol;
import octans.co.com.prueba.entitie.Usuario;
import octans.co.com.prueba.mapper.IUsuarioMapper;
import octans.co.com.prueba.model.RolModel;
import octans.co.com.prueba.model.UsuarioModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class UsuarioMapper implements IUsuarioMapper {

    @Override
    public UsuarioModel mapFromEntity(Usuario usuario) {
        UsuarioModel usuarioModel = new UsuarioModel();
        Rol rol = usuario.getRol();
        RolModel rolModel = new RolModel(rol.getIdRol(), rol.getNombre());

        usuarioModel.setIdUsuario(usuario.getIdUsuario());
        usuarioModel.setRol(rolModel);
        usuarioModel.setNombre(usuario.getNombre());
        if(usuario.getActivo().equals("S"))
            usuarioModel.setActivo("Sí");
        else
            usuarioModel.setActivo("No");
        return usuarioModel;
    }

    @Override
    public Usuario mapFromDTO(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario();
        Rol rol = new Rol();

        RolModel rolModel = usuarioModel.getRol();

        rol.setIdRol(rolModel.getIdRol());
        rol.setNombre(rolModel.getNombre());

        usuario.setIdUsuario(usuarioModel.getIdUsuario());
        usuario.setRol(rol);
        usuario.setNombre(usuarioModel.getNombre());
        usuario.setActivo(usuarioModel.getActivo());
        if(usuarioModel.getActivo().equals("Sí"))
            usuario.setActivo("S");
        else
            if (usuarioModel.getActivo().equals("No"))
                usuario.setActivo("N");
        return usuario;
    }

    @Override
    public List<UsuarioModel> mapListUsuario(List<Usuario> listUsuario) {
        List<UsuarioModel> listUsuarioModel = new LinkedList<>();
        for(Usuario usuario: listUsuario)
            listUsuarioModel.add(mapFromEntity(usuario));
        return listUsuarioModel;
    }
}
