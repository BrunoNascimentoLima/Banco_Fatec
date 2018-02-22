package edu.bancofatec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.bancofatec.entidades.UsuarioConta;

public class UsuarioContaDAO implements DAO{

	@Override
	public int inserir(Object obj) throws SQLException {
		UsuarioConta usuarioConta;
		if(obj instanceof UsuarioConta)
			usuarioConta = (UsuarioConta)obj;
		else
			usuarioConta = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" +
				"localhost:3306/bancofatec","root","");
		String sql = "INSERT INTO usuarioconta (id,idConta,idUsuario) VALUES " +
				"(?,?,?)";
		
		PreparedStatement pstm =con.prepareStatement(sql);
		pstm.setLong(1,usuarioConta.getId());
		pstm.setLong(2,usuarioConta.getIdConta());
		pstm.setLong(3,usuarioConta.getIdUsuario());
		 int atualizado= pstm.executeUpdate();
		
		 return atualizado;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" +
				"localhost:3306/bancofatec","root","");
		
		String sql = "SELECT * FROM usuarioconta WHERE id =?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		ResultSet rs =pstm.executeQuery();
		UsuarioConta uc = null; 
		if(rs.next()){
			 uc = new UsuarioConta();
			 uc.setId(rs.getLong("id"));
			 uc.setIdConta(rs.getLong("idConta"));
			 uc.setIdUsuario(rs.getLong("idUsuario"));
			 
		 }
		
		
		return uc;
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bancofatec","root","");
		
		String sql ="SELECT * FROM usuarioconta";
		
		PreparedStatement pstm =con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<UsuarioConta> usuarioContas = new ArrayList<UsuarioConta>();
		 while(rs.next()){
			 UsuarioConta uc = null;
			 uc= new UsuarioConta();
			 uc.setId(rs.getLong("id"));
			 uc.setIdConta(rs.getLong("idConta"));
			 uc.setIdUsuario(rs.getLong("idUsuario"));
			  usuarioContas.add(uc);
		 }
		return usuarioContas;
	}

}
