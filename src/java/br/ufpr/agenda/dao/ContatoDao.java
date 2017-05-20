/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.dao;

import br.ufpr.agenda.jdbc.ConnectionFactory;
import br.ufpr.agenda.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ufpr
 */
public class ContatoDao {

    private Connection conexao;

    public ContatoDao() {
        ConnectionFactory factory = new ConnectionFactory();
        conexao = factory.getConnection();
    }

    public void adiciona(Contato contato) {

        String sql = "INSERT INTO contatos"
                + " (nome,email,endereco,dataNascimento)"
                + " VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            Date dataSql = new Date(contato.getDataNascimento().getTimeInMillis());
            stmt.setDate(4, dataSql);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Contato> getLista() {

        try {

            List<Contato> contatos = new ArrayList<Contato>();

            PreparedStatement stmt = this.conexao.prepareStatement("select * from contatos");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                // adicionando o objeto à lista
                contatos.add(contato);

            }
            rs.close();
            stmt.close();
            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void altera(Contato contato) {

        String sql = "update contatos set nome=?, email=?, endereco=?,"
                + "dataNascimento=? where id=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void remove(Long id) {
        try {

            PreparedStatement stmt = conexao.prepareStatement("delete"
                    + " from contatos where id=?");
            
            stmt.setLong(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {

        remove(contato.getId());

    }

}
