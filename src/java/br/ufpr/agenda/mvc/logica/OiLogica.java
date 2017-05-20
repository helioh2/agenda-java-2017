/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ufpr
 */
public class OiLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Primeira lógica!!");
        
        System.out.print("FAZ ALGUMA COISA!!");
        
        return "primeira-logica.jsp";
                
    }
    
}
