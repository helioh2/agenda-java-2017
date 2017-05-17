<%-- 
    Document   : campoData
    Created on : 16/05/2017, 22:22:46
    Author     : ufpr
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id"%>

<%-- any content can be specified here e.g.: --%>
<input type="text" id="${id}" name="${id}" /><br />            
<script>
     $("#${id}").datepicker({dateFormat:"dd/mm/yy"});
</script>