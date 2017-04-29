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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ufpr
 */
public class ContatoDao {
    
    private Connection con;

    public ContatoDao() {
        ConnectionFactory factory = new ConnectionFactory();      
        con = factory.getConnection();
    }
    
    
    public void adiciona(Contato contato) {
        
        String sql = "INSERT INTO contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
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
    
}
