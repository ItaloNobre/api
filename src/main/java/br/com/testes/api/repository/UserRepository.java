package br.com.testes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testes.api.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
}
