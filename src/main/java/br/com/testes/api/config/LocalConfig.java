package br.com.testes.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.testes.api.domain.User;
import br.com.testes.api.repository.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User u1 = new User(1l,"italo" , "italo@bol.com", "123");
        User u2 = new User(2l,"Andressa" , "andressa@bol.com", "123");
        
        repository.saveAll(List.of(u1,u2));
    }
    
}
