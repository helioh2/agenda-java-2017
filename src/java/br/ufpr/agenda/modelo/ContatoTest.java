/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.modelo;

import br.ufpr.agenda.dao.ContatoDao;
import java.util.Calendar;
import java.util.List;

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
        
        for (Integer i = 1; i < 5; i++){
            Contato contato2 = new Contato();
            contato1.setNome("helio"+i);
            contato1.setEmail("heliohenrique3@gmail.com_"+i);
            contato1.setEndereco("rua lupicinio_"+i);
            contato1.setDataNascimento(Calendar.getInstance());
            bd.adiciona(contato1);
        }
        
        System.out.println(contato1.getNome());
        
        //Busca:       
        List<Contato> contatos = bd.getLista();
        for (Contato contato: contatos){
            System.out.println(contato.getId()+" "+contato.getNome());
        }
        
        //Altera:
        int id = 2;
        Contato contatoaltera = contatos.get(id);
        contatoaltera.setNome(contatoaltera.getNome() + " alterado");
        bd.altera(contatoaltera);
        
        //Remove:
        int id2 = 3;
        Contato contatoremove = contatos.get(id2);
        bd.remove(contatoremove);
        
        
        
        
        
        
    }
    
    
}
