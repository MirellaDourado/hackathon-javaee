package com.stefanini.dto;
import com.stefanini.entity.UserEntity; 

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
    private Long idUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    private LocalDateTime dataCriacao;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    private LocalDateTime dataAtualizacao;

    @Size(max = 50)
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    private String nome;
    
    @Size(min = 20, max = 20)
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    private String login;

    @Size(min = 4, max = 50)
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    private String senha;

    @Size(min = 10)
    @NotBlank(message = "Não deve ser nulo e nem em branco.")
    @Email
    private String email;

    public UserDTO() {}

    public void UsuarioDTO(UserEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.senha = usuarioEntity.getSenha();
        this.email = usuarioEntity.getEmail();
        this.dataNascimento = usuarioEntity.getDataNascimento();
        this.dataCriacao = usuarioEntity.getDataCriacao();
        this.dataAtualizacao = usuarioEntity.getDataAtualizacao();
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
