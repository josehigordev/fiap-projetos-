package br.com.fiap.nexu.model;

import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String cpf;
    private String nome;
    private String email;
    private String perfilRisco;
    private LocalDate dataCadastro;

    public Usuario() {
    }

    public Usuario(int idUsuario, String cpf, String nome, String email,
                   String perfilRisco, LocalDate dataCadastro) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.perfilRisco = perfilRisco;
        this.dataCadastro = dataCadastro;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPerfilRisco() { return perfilRisco; }
    public void setPerfilRisco(String perfilRisco) { this.perfilRisco = perfilRisco; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    @Override
    public String toString() {
        return "Usuario{id=" + idUsuario + ", cpf=" + cpf + ", nome=" + nome
                + ", email=" + email + ", perfilRisco=" + perfilRisco
                + ", dataCadastro=" + dataCadastro + "}";
    }
}
