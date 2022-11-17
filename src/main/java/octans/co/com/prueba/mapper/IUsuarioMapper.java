package octans.co.com.prueba.mapper;

import octans.co.com.prueba.entitie.Usuario;
import octans.co.com.prueba.model.UsuarioModel;

import java.util.List;

public interface IUsuarioMapper {

    UsuarioModel mapFromEntity(Usuario usuario);

    Usuario mapFromDTO(UsuarioModel usuarioModel);

    List<UsuarioModel> mapListUsuario(List<Usuario> listUsuario);
}
