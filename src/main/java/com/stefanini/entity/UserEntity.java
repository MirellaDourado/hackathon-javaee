package com.stefanini.entity;
import com.stefanini.dto.UserDTO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "usuario" )
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuário")
  private Long idUsuario;

  @Column(nullable = false, length = 50)
  private String nome;

  @Column(nullable = false, unique = true, length = 20)
  private String login;

  @Column(nullable = false, length = 50)
  private String email;

  @Column(nullable = false, length = 10)
  private String senha;

  @Column(nullable = true)
  private LocalDate dataNascimento;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime dataCriacao;
  
  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime dataAtualizacao;

  public UserEntity() {
  }

  public  UserEntity(UserDTO usuarioDTO){
      this.idUsuario = usuarioDTO.getId();
      this.nome = usuarioDTO.getNome();
      this.login = usuarioDTO.getLogin();
      this.senha = usuarioDTO.getSenha();
      this.email = usuarioDTO.getEmail();
      this.dataNascimento = usuarioDTO.getDataNascimento();
      this.dataCriacao = usuarioDTO.getDataCriacao();
      this.dataAtualizacao = usuarioDTO.getDataAtualizacao();
  }

  public Long getId() {
      return idUsuario;
  }

  public void setId(Long idUsuario) {
      this.idUsuario = idUsuario;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getLogin() {
      return login;
  }

  public void setLogin(String login) {
      this.login = login;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getSenha() {
      return senha;
  }

  public void setSenha(String senha) {
      this.senha = senha;
  }

  public LocalDate getDataNascimento() {
      return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
      this.dataNascimento = dataNascimento;
  }

  public LocalDateTime getDataCriacao() {
      return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
      this.dataCriacao = dataCriacao;
  }

  public LocalDateTime getDataAtualizacao() {
      return dataAtualizacao;
  }

  public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
      this.dataAtualizacao = dataAtualizacao;
  }
}
