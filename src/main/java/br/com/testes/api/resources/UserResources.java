package br.com.testes.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testes.api.domain.User;
import br.com.testes.api.services.impl.UserServiceImplementacao;



@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @Autowired
    UserServiceImplementacao serviceImplementacao;
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceImplementacao.findById(id));
    }

    
    
}
