/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.modelo;

import br.ufpr.agenda.dao.ContatoDao;
import java.util.Calendar;

/**
 *
 * @author ufpr
 */
public class ContatoTest {
    
    public static void main(String[] args) {
        
        Contato contato1 = new Contato();
        contato1.setNome("helio");
        contato1.setEmail("heliohenrique3@gmail.com");
        contato1.setEndereco("rua lupicinio");
        contato1.setDataNascimento(Calendar.getInstance());
        
        //DAO = Data Access Object -> persiste dados no bd
        ContatoDao bd = new ContatoDao();
        bd.adiciona(contato1);
        
        System.out.println(contato1.getNome());
        
        
    }
    
    
}
