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
<h2>Informe os dados da Conta a ser paga</h2>
<form action="./PagamentoController" method="POST">
<table>
<tr>
<td>
Numero Boleto:
</td>
<td>
<input type="text" name="txtBoleto">
</td>
</tr>
<tr>
<td>
Data Vencimento:
</td>
<td>
<input type="text" name="txtVencimento">
</td>
</tr>
<tr>
<td>
Cedente:
</td>
<td>
<input type="text" name="txtCedente">
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
<input type="submit" name="cmd" value="Efetuar Pagamento">
</td>
<td>
<input type="submit" name ="cmd" value="Cancela">
</td>
</tr>

</table>
</form>

</body>
</html>