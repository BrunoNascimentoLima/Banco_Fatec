package edu.bancofatec.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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
 * Servlet implementation class ExtratoController
 */
@WebServlet("/ExtratoController")
public class ExtratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Lancamento> lancamentos ;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtratoController() {
        super();
        // TODO Auto-generated constructor stub
    }

   @Override
   public void init(){
	   lancamentos = (ArrayList<Lancamento>)this.getServletContext().getAttribute("LISTA_LANCAMENTOS"); 
       if(lancamentos == null){
    	   lancamentos = new ArrayList<Lancamento>();
    	   this.getServletContext().setAttribute("LISTA_LANCAMENTOS",lancamentos);
       }
   }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="Não há Lançamentos para este período especificado";
		String destino="./extrato.jsp";
		String cmd = request.getParameter("cmd");
		String dataInicio = request.getParameter("txtDataInicio");
		String dataFim = request.getParameter("txtDataFim");
		
	  Usuario u= (Usuario)request.getSession().getAttribute("PERFIL");
    	if(u!= null){ 
	    	if("Mostrar Extrato".equalsIgnoreCase(cmd)){
			 Conta conta = (Conta)request.getSession().getAttribute("CONTA");
			if(conta !=null){
			 LancamentoDAO ldao = new LancamentoDAO();
			try {
			lancamentos=(ArrayList<Lancamento>)ldao.pesquisarEntreDatas(dataInicio,dataFim,conta.getId());
		  	request.setAttribute("EXTRATO", lancamentos);
		  	msg="Lançamentos encontrados com sucesso!";
		  	request.setAttribute("INICIO",dataInicio);
			request.setAttribute("FIM",dataFim);
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			request.setAttribute("MENSAGEM",msg);
    		RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);
			} else if(conta ==null){
				request.setAttribute("MENSAGEM",msg);
				RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response);
			    }
			
		 }
		 else if("Cancela".equalsIgnoreCase(cmd)){
			 destino="./menu.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response); 
		 }
		 
		 
    	}else{
			 destino="./login.jsp";
			 RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response); 
			 }
		 }

}
