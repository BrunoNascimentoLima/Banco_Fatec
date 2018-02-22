package edu.bancofatec.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.bancofatec.dao.LancamentoDAO;
import edu.bancofatec.entidades.Conta;
import edu.bancofatec.entidades.Lancamento;
import edu.bancofatec.entidades.Usuario;

/**
 * Servlet implementation class SaqueController
 */
@WebServlet("/SaqueController")
public class SaqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static long i;
    String tipo="Saque";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaqueController() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "erro ao efetuar o saque";
		String destino = "./saque.jsp";
		String cmd = request.getParameter("cmd");
		String valor = request.getParameter("txtValor");
		String descricao = request.getParameter("txtDescricao");
		i=(long)(1+Math.random()*1000);
		
		 Usuario u= (Usuario)request.getSession().getAttribute("PERFIL");
	      if(u!= null){
		   if("Saque".equalsIgnoreCase(cmd)){
			 try{
               Lancamento l = new Lancamento();
               l.setId(i);
                 Conta conta= (Conta)request.getSession().getAttribute("CONTA");
               if(conta != null){
               l.setIdConta(conta.getId());
               l.setTipo(tipo);
               l.setDescricao(descricao);
               l.setSaldoAnterior(conta.getSaldo());
               l.setSaldoPosterior(conta.getSaldo() - Float.parseFloat(valor));
                 conta.setSaldo(l.getSaldoPosterior());
                 request.getSession().setAttribute("CONTA", conta);
               l.setValor(Float.parseFloat(valor));
                  Date data = new Date(System.currentTimeMillis());
                  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                  try {
                	  
					l.setDataLancamento(df.parse(df.format(data)));
			    	
                 LancamentoDAO ldao = new LancamentoDAO();
                 
					int atualizado =ldao.inserir(l);
				    	if (atualizado > 0){
					      msg="Saque efetuado com sucesso";   	
						  destino ="./saque.jsp";
				    	}
				} catch (SQLException | java.text.ParseException e) {
					e.printStackTrace();
				}
              
                 
                 request.setAttribute("MENSAGEM",msg);                                                           
        	     RequestDispatcher rd =request.getRequestDispatcher(destino);
        	     rd.forward(request,response); 		
	     	}   else if(conta== null){
	     	    	request.setAttribute("MENSAGEM",msg);                                                           
       	            RequestDispatcher rd =request.getRequestDispatcher(destino);
       	            rd.forward(request,response); 		
	     	    }
			 }catch(Exception e){
				 msg="Erro! Há campos vazios";
					request.setAttribute("MENSAGEM",msg);
	                RequestDispatcher rd = request.getRequestDispatcher(destino);
	                rd.forward(request, response);
			 }
               
		   }
		   else if("Cancela".equalsIgnoreCase(cmd)){
			  destino="./menu.jsp";
			 RequestDispatcher rd =request.getRequestDispatcher(destino);
      	     rd.forward(request,response); 
		   }
		}
		   else{
			   destino="./login.jsp";
				 RequestDispatcher rd =request.getRequestDispatcher(destino);
	      	     rd.forward(request,response); 
		   }
	}

}
