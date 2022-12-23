package br.com.testes.api.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testes.api.domain.User;
import br.com.testes.api.domain.dto.UserDTO;
import br.com.testes.api.services.impl.UserServiceImplementacao;



@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    UserServiceImplementacao serviceImplementacao;
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(serviceImplementacao.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = serviceImplementacao.findAll();
        List<UserDTO> listDTO = list.stream().map((x) -> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
}
