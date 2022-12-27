package br.com.testes.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.testes.api.domain.User;
import br.com.testes.api.domain.dto.UserDTO;

@Service
public interface UserService {
    
    User findById(Long id);
    
    List<User> findAll();

    User create(UserDTO obj);

    User update(UserDTO obj);
}
