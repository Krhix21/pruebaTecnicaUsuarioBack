package octans.co.com.prueba.controller;

import octans.co.com.prueba.model.UsuarioModel;
import octans.co.com.prueba.service.IUsuarioService;
import octans.co.com.prueba.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constantes.USUARIO_CONTROLLER)
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService iUsuarioService) {
        this.usuarioService = iUsuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<UsuarioModel> getUsuarios(){
        return new ResponseEntity(usuarioService.getUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuarioModel){
        return new ResponseEntity(usuarioService.createUsuario(usuarioModel), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<UsuarioModel> modifiedUsuario(@RequestBody UsuarioModel usuarioModel){
        return new ResponseEntity(usuarioService.modifiedUsuario(usuarioModel), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<UsuarioModel> deleteUsuario(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity(usuarioService.deleteUsuario(idUsuario), HttpStatus.OK);
    }
}
