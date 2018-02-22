<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page ="./cabecalho.jsp"/>
<h2>Digite seu usúario e senha para acessar o banco:</h2>
      <form action="./LoginController"  method ="POST">
       <table>
          <tr>
            <td> Usuário: </td>
           <td><input type="text" name ="txtUsuario"/></td>
         </tr>
        <tr>
      <td> senha:</td> 
       <td><input type ="Password" name="txtSenha"></td> 
    </tr> 
      <tr>
         <td><input type="submit"  name="cmd"  value="login"/></td>
         <td><input type ="submit" name="cmd"  value="Cancela"></td>
</tr>
</table>
</form>

</body>
</html>