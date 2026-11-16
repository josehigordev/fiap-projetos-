package br.com.fiap.nexu.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/** Lancamento financeiro: tipo RECEITA (entrada) ou DESPESA (gasto). */
public class Lancamento {
    private int idLancamento;
    private int idConta;
    private String tipo;
    private BigDecimal valor;
    private String categoria;
    private LocalDate dataLancamento;

    public Lancamento() {
    }

    public Lancamento(int idLancamento, int idConta, String tipo, BigDecimal valor,
                      String categoria, LocalDate dataLancamento) {
        this.idLancamento = idLancamento;
        this.idConta = idConta;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
    }

    public int getIdLancamento() { return idLancamento; }
    public void setIdLancamento(int idLancamento) { this.idLancamento = idLancamento; }
    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    @Override
    public String toString() {
        return "Lancamento{id=" + idLancamento + ", idConta=" + idConta + ", tipo=" + tipo
                + ", valor=" + valor + ", categoria=" + categoria
                + ", dataLancamento=" + dataLancamento + "}";
    }
}
