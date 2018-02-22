<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="edu.bancofatec.entidades.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco FATEC - SCS</title>

</head>
<body >
<img src ="./Images/BF.jpg"/>
<table>
  <tr>
    <td> 
      <% String msg= (String)request.getAttribute("MENSAGEM");
             if(msg!=null){
       %>
           <P align ="center"><h3><%=msg%></h3></p>

       <% }
              %>
 </td>
     <td>
        <%Usuario user =(Usuario)session.getAttribute("PERFIL");
             String logado ="Não logado";
              if (user !=null){
              logado =user.getId().toString();
              }
         %>
   <P align ="right"><h2>Cliente : <%= logado%></h2></p>
</td>
</tr>
</table>

	</body>
</html>