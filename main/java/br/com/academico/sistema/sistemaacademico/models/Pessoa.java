package br.com.academico.sistema.sistemaacademico.models;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa  {

    @Id
    private Long matricula;

    //@Column(nullable = false) ;
    private Long cpf;

    //@Column(nullable = false)
    private String nome;

    //@Column(nullable = false)
    private int idade;

   // @Column(nullable = false)
    private String sexo;

    //@Column(nullable = true)
    private String linkFoto;

    //@Column(nullable = false)
    private String senha;

    //@Column(nullable = false)
    private String email;

    //@Column(nullable = false)
    private String dataCriacao;

    private String dataTermino;

    private String tipo;

    public Pessoa() {
    }

    public Pessoa(Long matricula, Long cpf, String nome, int idade, String sexo, String linkFoto, String senha, String email, String dataCriacao, String dataTermino) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.linkFoto = linkFoto;
        this.senha = senha;
        this.email = email;
        this.dataCriacao = dataCriacao;
        this.dataTermino = dataTermino;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
