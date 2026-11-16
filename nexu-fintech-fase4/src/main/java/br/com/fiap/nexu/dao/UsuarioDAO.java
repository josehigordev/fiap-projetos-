package br.com.fiap.nexu.dao;

import br.com.fiap.nexu.infra.ConnectionFactory;
import br.com.fiap.nexu.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQL_INSERT =
            "INSERT INTO TB_USUARIO (id_usuario, cpf, nome, email, perfil_risco, data_cadastro) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_GET_ALL =
            "SELECT id_usuario, cpf, nome, email, perfil_risco, data_cadastro "
                    + "FROM TB_USUARIO ORDER BY id_usuario";

    /** Insere um usuario. Retorna true se o registro foi gravado. */
    public boolean insert(Usuario usuario) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getPerfilRisco());
            ps.setDate(6, Date.valueOf(usuario.getDataCadastro()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuario (ORA-" + e.getErrorCode() + "): " + e.getMessage());
            return false;
        }
    }

    /** Retorna todos os usuarios. Em caso de erro, retorna a lista vazia. */
    public List<Usuario> getAll() {
        List<Usuario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("perfil_risco"),
                        rs.getDate("data_cadastro").toLocalDate()));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar usuarios (ORA-" + e.getErrorCode() + "): " + e.getMessage());
        }
        return lista;
    }
}
