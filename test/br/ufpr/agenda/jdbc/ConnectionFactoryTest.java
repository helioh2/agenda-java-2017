/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;


public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }
    
    @Test
    public void testGetConnection() throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        connection.close();
    }
}
