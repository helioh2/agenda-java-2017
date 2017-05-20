/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.servlets;

import br.ufpr.agenda.mvc.logica.Logica;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "mvc", urlPatterns = {"/mvc"})
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String logicaStr = req.getParameter("logica");
        String nomeDaClasse = "br.ufpr.agenda.mvc.logica."+logicaStr;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            
            String pagina = logica.executa(req, resp);
            
            req.getRequestDispatcher(pagina).forward(req, resp);

        } catch (Exception ex) {
            
            throw new 
        ServletException("A lógica de negócios causou uma exceção: ", ex);
        }
    }

   

}
