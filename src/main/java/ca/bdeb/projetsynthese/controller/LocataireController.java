package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.dto.LocataireDTO;
import ca.bdeb.projetsynthese.dto.LoginDTO;
import ca.bdeb.projetsynthese.models.Locataire;
import ca.bdeb.projetsynthese.services.LocataireService;
import ca.bdeb.projetsynthese.vo.AdministrateurLoginVO;
import ca.bdeb.projetsynthese.vo.LocataireLoginVO;
import ca.bdeb.projetsynthese.vo.LocataireVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = "API pour Locataire")
@RestController
@RequestMapping("api/v1/locataire")
public class LocataireController {
    @Autowired
    private LocataireService service;

    @ApiOperation(value = "Locataire login")
    @PostMapping(value = "/login")
    public LocataireLoginVO login(LoginDTO loginDTO){
        return service.login(loginDTO);
    }

    @ApiOperation(value = "Logout")
    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus status) {
        session.invalidate();
        status.setComplete();
        return "A la prochaine";
    }

    @ApiOperation(value = "Récupérer la liste de Locataire")
    @GetMapping("/list")
    public List<Locataire> getLocataireList(){
        return service.getLocataireList();
    }

    @ApiOperation(value = "Récupérer le locataire spécifié by email")
    @GetMapping("/{email}")
    public Locataire getLocataireByEmail(@PathVariable("email") String email){
        return service.getLocataireByEmail(email);
    }

    @ApiOperation(value = "Ajouter un nouveau locataire")
    @PostMapping("/add")
    public LocataireVO addLocataire(@RequestBody LocataireDTO locataireDTO){
        return service.addLocataire(locataireDTO);
    }

    @ApiOperation(value = "Modifier un locataire")
    @PutMapping("/update")
    public Locataire updateLocataire(@RequestBody Locataire locataire){
        return service.updateLocataire(locataire);
    }

    @ApiOperation(value = "Supprimer un nouveau locataire")
    @DeleteMapping("/delete/{email}")
    public void deleteLocataire(@PathVariable("email") String email){
        service.removeLocataire(email);
    }

}
