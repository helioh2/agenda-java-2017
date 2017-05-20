/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.mvc.logica;

import br.ufpr.agenda.dao.ContatoDao;
import br.ufpr.agenda.modelo.Contato;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ufpr
 */
public class RemoverContato implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        ContatoDao dao = new ContatoDao();
        
        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        
        dao.remove(id);
        
        return "mvc?logica=ListarContatos";
    }
    
}
