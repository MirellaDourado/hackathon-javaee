package com.stefanini.service;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.stefanini.dto.UserDTO;
import com.stefanini.repository.UserRepository;

@ApplicationScoped
public class UserService {
  @Inject
  UserRepository userRepository;

  public UserDTO createUser(UserDTO userDTO){
    if (Objects.nonNull(userDTO.getId())){
        throw new RuntimeException("Erro ao cadastra usuario.");
    }
    if (!userDTO.getSenha().isEmpty()) {
        String senha = Base64.getEncoder().encodeToString(userDTO.getSenha().getBytes());
        userDTO.setSenha(senha);
    }
    return userRepository.criarUser(userDTO);
  }

  public UserDTO editUser (UserDTO userDTO) {
     if (Objects.nonNull(userDTO.getId())){
        throw new RuntimeException("Erro ao cadastra usuario.");
    }
    if (!userDTO.getSenha().isEmpty()) {
      String senha = Base64.getEncoder().encodeToString(userDTO.getSenha().getBytes());
      userDTO.setSenha(senha);
    }
    return userRepository.editUser(userDTO);
  }

  public void removeUser(Long id) {
    userRepository.removeUser(id);
  }

  public List<UserDTO> listAllUsers() {
    return userRepository.listAllUsers();
  }

  public List<UserDTO> listMonthBirthday() {
    return userRepository.listMonthBirthday();
  }

  public List<UserDTO> listProvedorEmail(String mail) {
    return userRepository.listProvedorEmail(mail);
  }
}
