package br.com.testes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.testes.api.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
