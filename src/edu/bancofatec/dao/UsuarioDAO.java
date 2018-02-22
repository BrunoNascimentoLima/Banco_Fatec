package edu.bancofatec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.bancofatec.entidades.Usuario;


public class UsuarioDAO implements DAO{

	@Override
	public int inserir(Object obj) throws SQLException {
		Usuario usuario;
		if(obj instanceof Usuario)
			usuario=(Usuario)obj;
		else 
			usuario = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bancofatec","root","");
		
		String sql ="INSERT INTO usuario (id,usuario,nome,email,telefone,senha," +
				"perfil) VALUES " +
				" (?,?,?,?,?,?,?)";
		
		PreparedStatement pstm =con.prepareStatement(sql);
        pstm.setLong(1, usuario.getId());
        pstm.setString(2, usuario.getUsuario());
        pstm.setString(3, usuario.getNome());
        pstm.setString(4, usuario.getEmail());
        pstm.setString(5, usuario.getTelefone());
        pstm.setString(6, usuario.getSenha());
        pstm.setString(7, usuario.getPerfil());
        
         int atualizado = pstm.executeUpdate();
         return atualizado;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bancofatec","root","");
		
		String sql ="SELECT * FROM usuario WHERE id =?";
		
		PreparedStatement pstm =con.prepareStatement(sql);
		pstm.setLong(1, id);
		ResultSet rs = pstm.executeQuery();
        Usuario usuario = null;
		if(rs.next()){
	      usuario = new Usuario();
          usuario.setId(rs.getLong("id"));
          usuario.setUsuario(rs.getString("usuario"));
          usuario.setNome(rs.getString("nome"));
          usuario.setEmail(rs.getString("email"));
          usuario.setTelefone(rs.getString("telefone"));
          usuario.setSenha(rs.getString("senha"));
          usuario.setPerfil(rs.getString("perfil"));
        }
        return usuario;
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bancofatec","root","");
		
		String sql ="SELECT * FROM usuario WHERE usuario =?";
		
		PreparedStatement pstm =con.prepareStatement(sql);
		pstm.setString(1, nome);
		ResultSet rs = pstm.executeQuery();
        Usuario usuario = null;
		if(rs.next()){
	      usuario = new Usuario();
          usuario.setId(rs.getLong("id"));
          usuario.setUsuario(rs.getString("usuario"));
          usuario.setNome(rs.getString("nome"));
          usuario.setEmail(rs.getString("email"));
          usuario.setTelefone(rs.getString("telefone"));
          usuario.setSenha(rs.getString("senha"));
          usuario.setPerfil(rs.getString("perfil"));
        }
        return usuario;
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
		
		String sql ="SELECT * FROM usuario";
		
		PreparedStatement pstm =con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
        List<Usuario> usuarios = new ArrayList<Usuario>();
		while(rs.next()){
		  Usuario usuario =null;	
	      usuario = new Usuario();
          usuario.setId(rs.getLong("id"));
          usuario.setUsuario(rs.getString("usuario"));
          usuario.setNome(rs.getString("nome"));
          usuario.setEmail(rs.getString("email"));
          usuario.setTelefone(rs.getString("telefone"));
          usuario.setSenha(rs.getString("senha"));
          usuario.setPerfil(rs.getString("perfil"));
           usuarios.add(usuario);
        }
        return usuarios;
	}

}
