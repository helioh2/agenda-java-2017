/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.mvc.logica;

import br.ufpr.agenda.dao.ContatoDao;
import br.ufpr.agenda.modelo.Contato;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ufpr
 */
public class ListarContatos implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        
        req.setAttribute("contatos", contatos);
        
        return "/WEB-INF/jsp/listar-contatos3.jsp";
    
    }
    
}
