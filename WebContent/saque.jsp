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
<h2>Informe o valor a ser sacado da Conta</h2>
<form action="./SaqueController" method="POST">
<table>
<tr>
<td>Valor:
</td>
<td> <input type="text" name="txtValor">
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
<input type="submit" name="cmd" value="Saque">
</td>
<td>
<input type="submit" name="cmd" value="Cancela">
</td>
</tr>
</table>
</form>
</body>
</html>