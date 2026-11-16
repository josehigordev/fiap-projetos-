package br.com.fiap.nexu;

import br.com.fiap.nexu.dao.ContaDAO;
import br.com.fiap.nexu.dao.LancamentoDAO;
import br.com.fiap.nexu.dao.UsuarioDAO;
import br.com.fiap.nexu.model.Conta;
import br.com.fiap.nexu.model.Lancamento;
import br.com.fiap.nexu.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Teste das tres entidades: cadastra 5 registros de cada uma e depois consulta com getAll().
 * A ordem importa por causa das FKs: Usuario -> Conta -> Lancamento.
 *
 * Obs.: os IDs abaixo sao fixos. Se rodar duas vezes, o Oracle devolve ORA-00001
 * (chave primaria duplicada); troque os IDs ou apague os registros de teste.
 */
public class Teste {

    public static void main(String[] args) {
        testarUsuario(new UsuarioDAO());
        testarConta(new ContaDAO());
        testarLancamento(new LancamentoDAO());
    }

    private static void testarUsuario(UsuarioDAO dao) {
        System.out.println("=== USUARIOS: INSERT ===");
        LocalDate hoje = LocalDate.now();
        Usuario[] novos = {
                new Usuario(101, "11111111111", "Ana Souza", "ana@nexu.com", "CONSERVADOR", hoje),
                new Usuario(102, "22222222222", "Bruno Lima", "bruno@nexu.com", "MODERADO", hoje),
                new Usuario(103, "33333333333", "Carla Dias", "carla@nexu.com", "ARROJADO", hoje),
                new Usuario(104, "44444444444", "Diego Rocha", "diego@nexu.com", "MODERADO", hoje),
                new Usuario(105, "55555555555", "Elisa Mota", "elisa@nexu.com", "CONSERVADOR", hoje)
        };
        for (Usuario u : novos) {
            System.out.println(u.getNome() + " -> " + (dao.insert(u) ? "OK" : "FALHOU"));
        }

        System.out.println("=== USUARIOS: getAll ===");
        List<Usuario> lista = dao.getAll();
        lista.forEach(System.out::println);
        System.out.println("Total: " + lista.size());
    }

    private static void testarConta(ContaDAO dao) {
        System.out.println("\n=== CONTAS: INSERT ===");
        LocalDate hoje = LocalDate.now();
        Conta[] novas = {
                new Conta(201, 101, new BigDecimal("1500.00"), "ATIVA", hoje),
                new Conta(202, 102, new BigDecimal("3200.50"), "ATIVA", hoje),
                new Conta(203, 103, new BigDecimal("800.00"), "ATIVA", hoje),
                new Conta(204, 104, new BigDecimal("0.00"), "BLOQUEADA", hoje),
                new Conta(205, 105, new BigDecimal("12000.75"), "ATIVA", hoje)
        };
        for (Conta c : novas) {
            System.out.println("Conta " + c.getIdConta() + " -> " + (dao.insert(c) ? "OK" : "FALHOU"));
        }

        System.out.println("=== CONTAS: getAll ===");
        List<Conta> lista = dao.getAll();
        lista.forEach(System.out::println);
        System.out.println("Total: " + lista.size());
    }

    private static void testarLancamento(LancamentoDAO dao) {
        System.out.println("\n=== LANCAMENTOS: INSERT ===");
        LocalDate hoje = LocalDate.now();
        Lancamento[] novos = {
                new Lancamento(301, 201, "RECEITA", new BigDecimal("5000.00"), "Salario", hoje.minusDays(10)),
                new Lancamento(302, 201, "DESPESA", new BigDecimal("450.90"), "Mercado", hoje.minusDays(5)),
                new Lancamento(303, 202, "DESPESA", new BigDecimal("1200.00"), "Aluguel", hoje.minusDays(3)),
                new Lancamento(304, 203, "RECEITA", new BigDecimal("300.00"), "Freelance", hoje.minusDays(2)),
                new Lancamento(305, 205, "DESPESA", new BigDecimal("89.90"), "Streaming", hoje)
        };
        for (Lancamento l : novos) {
            System.out.println("Lancamento " + l.getIdLancamento() + " -> " + (dao.insert(l) ? "OK" : "FALHOU"));
        }

        System.out.println("=== LANCAMENTOS: getAll ===");
        List<Lancamento> lista = dao.getAll();
        lista.forEach(System.out::println);
        System.out.println("Total: " + lista.size());
    }
}
