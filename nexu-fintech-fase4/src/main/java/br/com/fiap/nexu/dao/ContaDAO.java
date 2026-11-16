package br.com.fiap.nexu.dao;

import br.com.fiap.nexu.infra.ConnectionFactory;
import br.com.fiap.nexu.model.Conta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private static final String SQL_INSERT =
            "INSERT INTO TB_CONTA (id_conta, id_usuario, saldo_disponivel, status, data_abertura) "
                    + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_GET_ALL =
            "SELECT id_conta, id_usuario, saldo_disponivel, status, data_abertura "
                    + "FROM TB_CONTA ORDER BY id_conta";

    public boolean insert(Conta conta) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

            ps.setInt(1, conta.getIdConta());
            ps.setInt(2, conta.getIdUsuario());
            ps.setBigDecimal(3, conta.getSaldoDisponivel());
            ps.setString(4, conta.getStatus());
            ps.setDate(5, Date.valueOf(conta.getDataAbertura()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta (ORA-" + e.getErrorCode() + "): " + e.getMessage());
            return false;
        }
    }

    public List<Conta> getAll() {
        List<Conta> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Conta(
                        rs.getInt("id_conta"),
                        rs.getInt("id_usuario"),
                        rs.getBigDecimal("saldo_disponivel"),
                        rs.getString("status"),
                        rs.getDate("data_abertura").toLocalDate()));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar contas (ORA-" + e.getErrorCode() + "): " + e.getMessage());
        }
        return lista;
    }
}
