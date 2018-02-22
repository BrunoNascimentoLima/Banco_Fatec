<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList,java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date" %>
    <%@ page import="edu.bancofatec.entidades.Lancamento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%DateFormat df= new SimpleDateFormat("dd/MM/YYYY");   
%>
</head>
<body>
<jsp:include page="./cabecalho.jsp"/>
<h2>Informe as datas de In�cio e T�rmino para consulta do extrato</h2>
<form action="./ExtratoController" method="POST">
<table>
<tr>
<td>
Data In�cio:
</td>
<td>
<input type="text" name="txtDataInicio">
</td>
</tr>
<tr>
<td>
Data T�rmino:
</td>
<td>
<input type="text" name="txtDataFim">
</td>
</tr>
<tr>
<td>
<input type="submit" value="Mostrar Extrato" name="cmd">
</td>
<td>
<input type="submit" value="Cancela" name="cmd">
</td>
</tr>
</table>
</form>
<%ArrayList<Lancamento> lancamentos=(ArrayList<Lancamento>)request.getAttribute("EXTRATO");
           if(lancamentos != null && lancamentos.size() > 0){
              String txtInicio=(String)request.getAttribute("INICIO");
			  String txtFim=(String)request.getAttribute("FIM");   
%>
<h2>Lan�amentos no per�odo de <%=txtInicio %> � <%=txtFim %> </h2>
<form>
<table border="2">
<tr>
<td><b>Id</B></td>
<td><b>Tipo</b></td>
<td><b>Data</b></td>
<td><b>Valor</b></td>
<td><b>Descri��o</b></td>
<td><b>Saldo Resultante</b></td>
</tr>
      <tr>
       <%for(Lancamento l : lancamentos){ %>
           <td><%=l.getId() %></td>
           <td><%=l.getTipo() %></td>
           <td><%=df.format(l.getDataLancamento()) %></td>
           <td><%=l.getValor() %></td>
           <td><%=l.getDescricao() %></td>
           <td><%=l.getSaldoPosterior() %></td>
       </tr>
       <%}
       
       } %>
</table>
</form>

</body>
</html>