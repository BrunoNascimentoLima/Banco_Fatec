package edu.bancofatec.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bancofatec.dao.ContaDAO;
import edu.bancofatec.dao.UsuarioContaDAO;
import edu.bancofatec.dao.UsuarioDAO;
import edu.bancofatec.entidades.Conta;
import edu.bancofatec.entidades.Usuario;
import edu.bancofatec.entidades.UsuarioConta;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
    	super();
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String msg = "erro ao efetuar login";
           String destino ="./login.jsp";
           String usuario  =    request.getParameter("txtUsuario");
           String senha     =    request.getParameter("txtSenha") ;   
           String cmd     =    request.getParameter("cmd") ;       

        if("Login".equalsIgnoreCase( cmd )) {
              UsuarioDAO uDAO =new UsuarioDAO();
             Usuario u ;
	     	try {
	        	u = (Usuario) uDAO.pesquisarPorNome( usuario );
				
                if(u!=null && u.getSenha().equals(senha)){
                       request.getSession().setAttribute("PERFIL",u);
                        UsuarioContaDAO ucDAO= new UsuarioContaDAO();
                        UsuarioConta uc   =(UsuarioConta)ucDAO.pesquisarPorId(u.getId());
                           if(uc != null){
                                  ContaDAO   cDAO = new ContaDAO();
                                     Conta    cc= (Conta)cDAO.pesquisarPorId( uc.getIdConta());
                                  if(cc!=null){
                                       request.getSession().setAttribute("CONTA",cc);
                                            msg="Login efetuado com Sucesso!";
                                             destino="./menu.jsp";
                                   }        
                           }  
                  }                             

		    } catch (SQLException e) {
		    	e.printStackTrace();
			 }
		 request.setAttribute("MENSAGEM",msg);                                                           
	     RequestDispatcher rd =request.getRequestDispatcher(destino);
	     rd.forward(request,response); 		
  
	  }
        else if("Cancela".equalsIgnoreCase(cmd)){
        destino="./login.jsp";
        RequestDispatcher rd =request.getRequestDispatcher(destino);
   	     rd.forward(request,response); 			
        }
     
  }
}

