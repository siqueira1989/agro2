package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Endereco;
import util.PostgresConnection;


/**
 *
 * @author Luciano Siqueira
 */
public class EnderecoDAO {
	 public boolean existeCep(Endereco endereco) throws SQLException {
		 PostgresConnection conn = new PostgresConnection();
		 Connection conexao= conn.getConnection();
		 
	        boolean existe = false;

	        // Substitua pelo seu método de obter conexão com o banco de dados
	        try {
	        	 String sql = "SELECT COUNT(*) FROM endereco WHERE cep = ?";
	             PreparedStatement stmt = conexao.prepareStatement(sql);
	             // Definindo o valor do parâmetro da consulta
	             stmt.setString(1, endereco.getCep());
	             ResultSet rs = stmt.executeQuery();
	             if (rs.next()) {
	                    // Verificando se a contagem é maior que zero
	                    existe = rs.getInt(1)>0;
	                }


	        } catch (SQLException e) {
	        	e.printStackTrace();
	            System.out.println("Erro no nivel dao: "+e.getMessage()); // Tratar exceções de forma adequada na sua aplicação
	        }
  
	        return existe;
	    }
	 
	 public Integer obterIdEnderecoPorCep(Endereco endereco) throws SQLException {
		    PostgresConnection conn = new PostgresConnection();
		    Connection conexao = conn.getConnection();
		    
		    Integer idEndereco = null;

		    try {
		        // Modificando a consulta SQL para retornar o 'idendereco' ao invés de contar os registros
		        String sql = "SELECT idendereco FROM endereco WHERE cep = ?";
		        PreparedStatement stmt = conexao.prepareStatement(sql);
		        
		        // Definindo o valor do parâmetro da consulta
		        stmt.setString(1, endereco.getCep());
		        ResultSet rs = stmt.executeQuery();
		        
		        if (rs.next()) {
		            // Atribuindo o valor de 'idendereco' à variável
		            idEndereco = rs.getInt("idendereco");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Erro no nivel DAO: " + e.getMessage()); // Tratar exceções de forma adequada na sua aplicação
		    } finally {
		        if (conexao != null) {
		            conexao.close(); // Certifique-se de fechar a conexão para evitar vazamento de recursos
		        }
		    }
		    
		  
		    return idEndereco;
		}
	 public void create(Endereco endereco) throws SQLException {
	     
	        PostgresConnection conn = new PostgresConnection();
		    Connection conexao = conn.getConnection();
	        try {
	        	   String sql = "INSERT INTO endereco (endereco, cep, bairro, cidade, estado, pais) VALUES (?, ?, ?, ?, ?, ?)";
	        	   PreparedStatement stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, endereco.getEndereco());
	            stmt.setString(2, endereco.getCep());
	            stmt.setString(3, endereco.getBairro());
	            stmt.setString(4, endereco.getCidade());
	            stmt.setString(5, endereco.getEstado());
	            stmt.setString(6, endereco.getPais());
	           
	            stmt.executeUpdate();
	        }catch (Exception e) {
	        	 e.printStackTrace();
			     System.out.println("Erro no nivel DAO: " + e.getMessage());
			}
	    }
	
        /* Método para criar um novo endereço no banco de dados
   

    // Método para ler um endereço do banco de dados pelo id
    public Endereco read(int id) throws SQLException {
        String sql = "SELECT * FROM endereco WHERE idendereco = ?";
        Endereco endereco = null;

        try (Connection conn = PostgresConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                endereco = new Endereco(
                        rs.getInt("idendereco"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("cep"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("localizacaogeografica")
                );
            }
        }

        return endereco;
    }

    // Método para atualizar um endereço no banco de dados
    public void update(Endereco endereco) throws SQLException {
        String sql = "UPDATE endereco SET endereco = ?, numero = ?, complemento = ?, cep = ?, bairro = ?, cidade = ?, estado = ?, pais = ?, localizacaogeografica = ? WHERE idendereco = ?";

        try (Connection conn = PostgresConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco.getEndereco());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getCep());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getEstado());
            stmt.setString(8, endereco.getPais());
            stmt.setString(9, endereco.getLocalizacaogeografica());
            stmt.setInt(10, endereco.getIdendereco());

            stmt.executeUpdate();
        }
    }

    // Método para deletar um endereço do banco de dados
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM endereco WHERE idendereco = ?";

        try (Connection conn = PostgresConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os endereços do banco de dados
    public List<Endereco> listAll() throws SQLException {
        String sql = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection conn = PostgresConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Endereco endereco = new Endereco(
                        rs.getInt("idendereco"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("cep"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("localizacaogeografica")
                );

                enderecos.add(endereco);
            }
        }

        return enderecos;
    }

    Endereco setEnderecoById(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Endereco getIdendereco(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
