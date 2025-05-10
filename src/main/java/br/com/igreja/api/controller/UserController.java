package br.com.igreja.api.controller;

import br.com.igreja.api.controller.dto.LoginDTO;
import br.com.igreja.api.entidade.User;
import br.com.igreja.api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping

    public ResponseEntity<User>  login(@RequestBody LoginDTO loginDTO){
        var user = userService.findUser(loginDTO.getEmail(), loginDTO.getPassword()).orElse(null);
        if(Objects.isNull(user)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
}
