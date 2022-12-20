package br.com.testes.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testes.api.domain.User;
import br.com.testes.api.repository.UserRepository;
import br.com.testes.api.services.UserService;
import br.com.testes.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImplementacao implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
       
       Optional<User> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

  
    
}
