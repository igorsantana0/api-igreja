package br.com.igreja.api.controller;

import br.com.igreja.api.controller.dto.HelperDTO;
import br.com.igreja.api.entidade.HelpersEntity;
import br.com.igreja.api.entidade.User;
import br.com.igreja.api.service.HelperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("helpers")
public class HelperController {

    private final HelperService helperService;

    public HelperController(HelperService helperService) {
        this.helperService = helperService;
    }
    @GetMapping("all")
    public ResponseEntity<?> all(){
        var helpers = helperService.all();
        if(helpers.isEmpty())return ResponseEntity.noContent().build();
        return ResponseEntity.ok(helpers);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Long id){
        var helpers = helperService.findByUserId(id);
        if(helpers.isEmpty())return ResponseEntity.noContent().build();
        return ResponseEntity.ok(helpers);
    }


    @PostMapping("/enviar")
    public ResponseEntity<?> saveHelper(@RequestBody HelperDTO helperDTO){
        HelpersEntity helpers = new HelpersEntity();
        User usr = new User();
        usr.setId(helperDTO.getUserId());
        helpers.setUser(usr);
        helpers.setDescricao(helperDTO.getDescricao());
        helpers.setNome(helperDTO.getNome());
        helpers.setIdade(helperDTO.getIdade());
        helpers.setStatus("ABERTO");
        helperService.save(helpers);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/atualizar-status/{id}/{status}")
    public ResponseEntity<?> update(@PathVariable Long id,@PathVariable String status){
        helperService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
