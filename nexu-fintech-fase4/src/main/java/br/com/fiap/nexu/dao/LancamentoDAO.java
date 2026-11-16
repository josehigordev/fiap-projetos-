package br.com.fiap.nexu.dao;

import br.com.fiap.nexu.infra.ConnectionFactory;
import br.com.fiap.nexu.model.Lancamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoDAO {

    private static final String SQL_INSERT =
            "INSERT INTO TB_LANCAMENTO (id_lancamento, id_conta, tipo, valor, categoria, data_lancamento) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_GET_ALL =
            "SELECT id_lancamento, id_conta, tipo, valor, categoria, data_lancamento "
                    + "FROM TB_LANCAMENTO ORDER BY id_lancamento";

    public boolean insert(Lancamento lancamento) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

            ps.setInt(1, lancamento.getIdLancamento());
            ps.setInt(2, lancamento.getIdConta());
            ps.setString(3, lancamento.getTipo());
            ps.setBigDecimal(4, lancamento.getValor());
            ps.setString(5, lancamento.getCategoria());
            ps.setDate(6, Date.valueOf(lancamento.getDataLancamento()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir lancamento (ORA-" + e.getErrorCode() + "): " + e.getMessage());
            return false;
        }
    }

    public List<Lancamento> getAll() {
        List<Lancamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Lancamento(
                        rs.getInt("id_lancamento"),
                        rs.getInt("id_conta"),
                        rs.getString("tipo"),
                        rs.getBigDecimal("valor"),
                        rs.getString("categoria"),
                        rs.getDate("data_lancamento").toLocalDate()));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar lancamentos (ORA-" + e.getErrorCode() + "): " + e.getMessage());
        }
        return lista;
    }
}
