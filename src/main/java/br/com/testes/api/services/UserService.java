package br.com.testes.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.testes.api.domain.User;

@Service
public interface UserService {
    
    User findById(Long id);
    
    List<User> findAll();
}
