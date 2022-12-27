package br.com.testes.api.services.impl;

import br.com.testes.api.domain.User;
import br.com.testes.api.domain.dto.UserDTO;
import br.com.testes.api.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplementacaoTest {

    public static final long ID = 1l;
    public static final String NAME = "valdir";
    public static final String EMAIL = "valdir@gmail.com";
    public static final String PASSWORD = "123";
    @InjectMocks // instancia real
    private UserServiceImplementacao service;
    @Mock // instancia ficticia
    private UserRepository repository;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    private ModelMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        starUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class,response.getClass());
        assertEquals(ID,response.getId());
        assertEquals(NAME,response.getName());
        assertEquals(EMAIL,response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
    private void starUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL,PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL,PASSWORD));
    }
}