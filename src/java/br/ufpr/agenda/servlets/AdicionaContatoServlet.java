/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.servlets;

import br.ufpr.agenda.dao.ContatoDao;
import br.ufpr.agenda.modelo.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ufpr
 */
@WebServlet(name = "adicionaContato", urlPatterns = {"/adicionaContato"})
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
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
        
        out.println("<body>");
        out.println("Usuário "+nome+" inserido com sucesso!");
        out.println("</body>");
        
    
    }

    
}
