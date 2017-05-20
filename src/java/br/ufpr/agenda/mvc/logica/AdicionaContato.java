/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.mvc.logica;

import br.ufpr.agenda.dao.ContatoDao;
import br.ufpr.agenda.modelo.Contato;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ufpr
 */
public class AdicionaContato implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataNascimentoStr = req.getParameter("dataNascimento");
        
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        
        //transformar o dataNascimento em Calendar
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascDate = null;
        try {
            dataNascDate = format.parse(dataNascimentoStr);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dataNascDate);
        
        contato.setDataNascimento(dataNascimento);
        
        // fim transformar...
        
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        
        return "contato-adicionado.jsp";
    
    }
    
}
