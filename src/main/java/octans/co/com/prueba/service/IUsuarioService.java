package octans.co.com.prueba.service;

import octans.co.com.prueba.model.UsuarioModel;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioModel> getUsuarios();

    UsuarioModel createUsuario(UsuarioModel usuarioModel);

    UsuarioModel modifiedUsuario(UsuarioModel usuarioModel);

    UsuarioModel deleteUsuario(int idUsuario);
}
