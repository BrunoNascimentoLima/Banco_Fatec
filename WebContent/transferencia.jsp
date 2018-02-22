<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./cabecalho.jsp"/>
<h2>Informe os dados da Conta a ser creditada</h2>
<form action="./TransferenciaController" method="POST">
<table>
<tr>
<td>
Numero da Conta:
</td>
<td>
<input type="text" name="txtNumeroConta">
</td>
</tr>
<tr>
<td>
Nome do Titular:
</td>
<td>
<input type="text" name="txtTitular">
</td>
</tr>
<tr>
<td>
Valor:
</td>
<td>
<input type="text" name="txtValor">
</td>
</tr>
<tr>
<td>
Descrição:
</td>
<td>
<input type="text" name="txtDescricao">
</td>
</tr>
<tr>
<td>
<input type="submit" value ="Transferir" name="cmd">
</td>
<td>
<input type="submit" value="Cancela" name="cmd">
</td>
</tr>
</table>

</form>
</body>
</html>