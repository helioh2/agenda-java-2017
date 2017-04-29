
package br.ufpr.agenda.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCInsereTest {

    //JEITO FEIO DE SE FAZER UM PROGRAMA COM BANCO DE DADOS:
    
    public static void main(String[] args) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {

            // cria um preparedStatement
            String sql = "INSERT INTO contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, "José");
            stmt.setString(2, "ze@uol.com.br");
            stmt.setString(3, "R. Pioneiro");
            stmt.setDate(4, new java.sql.Date(
                    Calendar.getInstance().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
