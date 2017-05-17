<%-- 
    Document   : listar-contatos2
    Created on : 16/05/2017, 21:38:09
    Author     : ufpr
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="dao" class="br.ufpr.agenda.dao.ContatoDao"/>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Agenda de Contatos</h1>
        <table>
            <th>Nome</th> <th>Email</th> <th>Endereço</th> <th>Data de Nascimento</th>
            <c:forEach var="contato" items="${dao.lista}">
            
            <tr>
                <td> ${contato.nome}</td>
                <td> 
                    <!--<c:if test="${not empty contato.email}">
                        <a href="mailto:${contato.email}">${contato.email}</a>
                    </c:if></td> -->
                
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:when>
                        <c:otherwise>
                            E-mail não informado
                        </c:otherwise>
                    </c:choose>
                <td> ${contato.endereco}</td>
                <td> 
                <fmt:formatDate value="${contato.dataNascimento.time}"
                            pattern="dd/MM/yyyy"/>
                    </td>
          
            </tr>
            
            </c:forEach>
        </table>
    </body>
</html>
