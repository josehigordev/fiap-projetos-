package br.com.fiap.nexu.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Conta {
    private int idConta;
    private int idUsuario;
    private BigDecimal saldoDisponivel;
    private String status;
    private LocalDate dataAbertura;

    public Conta() {
    }

    public Conta(int idConta, int idUsuario, BigDecimal saldoDisponivel,
                 String status, LocalDate dataAbertura) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.saldoDisponivel = saldoDisponivel;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public BigDecimal getSaldoDisponivel() { return saldoDisponivel; }
    public void setSaldoDisponivel(BigDecimal saldoDisponivel) { this.saldoDisponivel = saldoDisponivel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    @Override
    public String toString() {
        return "Conta{id=" + idConta + ", idUsuario=" + idUsuario
                + ", saldoDisponivel=" + saldoDisponivel + ", status=" + status
                + ", dataAbertura=" + dataAbertura + "}";
    }
}
