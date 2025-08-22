package daoimobiliaria;

import imobiliaria.Cliente;
import conexaoimobiliaria.ConexaoImobiliaria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void inserir(Cliente c) throws Exception {
        String sql = "INSERT INTO Cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexaoImobiliaria.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
        }
    }

    public List<Cliente> listar() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                clientes.add(c);
            }
        }
        return clientes;
    }

    // 🔥 Novo método: Ranking de clientes com mais contratos
    public List<Object[]> clientesComMaisContratos() throws Exception {
        List<Object[]> ranking = new ArrayList<>();

        String sql = "SELECT c.nome, COUNT(ct.id) AS totalContratos " +
                "FROM Cliente c " +
                "JOIN Contrato ct ON c.id = ct.cliente_id " +
                "GROUP BY c.id, c.nome " +
                "ORDER BY totalContratos DESC";

        try (Connection con = ConexaoImobiliaria.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Object[] linha = new Object[2];
                linha[0] = rs.getString("nome");        // Nome do cliente
                linha[1] = rs.getInt("totalContratos"); // Quantidade de contratos
                ranking.add(linha);
            }
        }
        return ranking;
    }
}
