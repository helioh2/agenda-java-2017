<%-- 
    Document   : listar-contatos
    Created on : 12/05/2017, 22:26:44
    Author     : ufpr
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.ufpr.agenda.modelo.Contato"%>
<%@page import="br.ufpr.agenda.dao.ContatoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Contatos</title>
    </head>
    <body>
        <h1>Agenda de Contatos</h1>
        <ul>
        <%
            ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getLista();
            for (Contato contato: contatos){ 
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataNascStr = dateFormat.format(contato.getDataNascimento().getTime());
        %>
    <li> <%= contato.getNome()%>,<%= contato.getEmail()%>, 
        <%= contato.getEndereco()%>,<%= dataNascStr %>
    </li>
           <%     
            }
            %>
        </ul>
    </body>
</html>
