package com.stefanini.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import javax.persistence.Query;
import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UserDTO;
import com.stefanini.entity.UserEntity;

@ApplicationScoped
public class UserRepository extends GenericDAO<UserEntity, Long> {

  @Transactional
  public UserDTO criarUser(UserDTO userDTO){
    UserEntity user = new UserEntity(userDTO);
    this.save(user);
    return new UserDTO(user);
  }

  @Transactional
  public UserDTO editUser(UserDTO userDTO) {
    UserEntity user = new UserEntity(userDTO);
    this.update(user);
    return new UserDTO(user);
  }

  @Transactional
  public void removeUser(Long id) {
    this.delete(id);
  }

  public List<UserDTO> listAllUsers() {
    List<UserEntity> users = this.listAll();
    return users.stream().map(UserDTO::new).collect(Collectors.toList());
  }

  public List<UserDTO> listMonthBirthday() {
    Query nativeQuery = this
    .createNativeQuery("SELECT * FROM usuario WHERE month(data_de_nascimento) = ?");
    nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
    List<UserEntity> resultUsers = nativeQuery.getResultList();
    return resultUsers.stream().map(UserDTO::new).collect(Collectors.toList());
  }

  public List<UserDTO> listProvedorEmail(String mail) {
    Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE email LIKE ?");
    nativeQuery.setParameter(1, "%" + mail + "%");
    List<UserEntity> resultList = nativeQuery.getResultList();
    return resultList.stream().map(UserDTO::new).collect(Collectors.toList());
  } 
}
