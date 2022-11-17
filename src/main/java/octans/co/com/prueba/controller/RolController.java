package octans.co.com.prueba.controller;

import octans.co.com.prueba.model.RolModel;
import octans.co.com.prueba.service.IRolService;
import octans.co.com.prueba.util.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constantes.ROL_CONTROLLER)
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/roles")
    public ResponseEntity<RolModel> getRoles(){
        return new ResponseEntity(rolService.getRoles(), HttpStatus.OK);
    }
}
