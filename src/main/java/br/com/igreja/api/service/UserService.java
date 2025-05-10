package br.com.igreja.api.service;

import br.com.igreja.api.entidade.User;
import br.com.igreja.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
