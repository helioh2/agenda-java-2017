<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib tagdir="/WEB-INF/tags" prefix="liccomp" %>
<html>
    <head>
        <title>Adiciona Contato</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<script src="js/jquery.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <link href="css/jquery.css" rel="stylesheet"> -->
        <script   src="https://code.jquery.com/jquery-2.2.3.js"   integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4="   crossorigin="anonymous"></script>
        <script   src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"   integrity="sha256-DI6NdAhhFRnO2k51mumYeDShet3I8AKCQf/tf7ARNhI="   crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.7.3/themes/mint-choc/jquery-ui.css">
    </head>
    <body>
        <h1>Adiciona Contatos</h1>
        <hr />
        <form action="adicionaContato">
            Nome: <input type="text" name="nome" /><br />
            E-mail: <input type="text" name="email" /><br />
            Endereço: <input type="text" name="endereco" /><br />
            Data Nascimento: 
            <!--<input type="text" id="dataNascimento" name="dataNascimento" /><br />
            <script>
               $("#dataNascimento").datepicker({dateFormat:"dd/mm/yy"});
            </script> -->
            <liccomp:campoData id="dataNascimento"/>

            <input type="submit" value="Gravar" />
        </form>
    </body>
</html>
