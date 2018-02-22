package edu.bancofatec.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.bancofatec.entidades.Conta;



public class ContaDAO implements DAO{

	@Override
	public int inserir(Object obj) throws SQLException {
		Conta conta;
		if(obj instanceof Conta)
			conta=(Conta)obj;
		else 
			conta = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bancofatec","root","");
		
		String sql ="INSERT INTO conta (id,tipo,numero,saldo,limite,taxaServico," +
				"taxaJuros,taxaRendimento,dataAbertura,diaRendimento,nomeGerente) VALUES " +
				" (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm =con.prepareStatement(sql);
        pstm.setLong(1, conta.getId());
        pstm.setString(2, conta.getTipo());
        pstm.setString(3, conta.getNumero());
        pstm.setFloat(4,conta.getSaldo());       
        pstm.setFloat(5,conta.getLimite());
        pstm.setFloat(6, conta.getTaxaServico());
        pstm.setFloat(7, conta.getTaxaJuros());
        pstm.setFloat(8, conta.getTaxaRendimento());
        pstm.setDate(9, new java.sql.Date(conta.getDataAbertura().getTime()));
        pstm.setFloat(10, conta.getDiaRendimento());
        pstm.setString(11,conta.getNomeGerente());
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
		
		String sql ="SELECT * FROM conta WHERE id = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		
		ResultSet rs = pstm.executeQuery();
    	Conta conta = null;
    	if(rs.next()){
    		conta=new Conta();
    		conta.setId(rs.getLong("id"));
    		conta.setTipo(rs.getString("tipo"));
    		conta.setNumero(rs.getString("numero"));
    		conta.setSaldo(rs.getFloat("saldo"));
    		conta.setLimite(rs.getFloat("limite"));
    		conta.setTaxaServico(rs.getFloat("taxaServico"));
    		conta.setTaxaJuros(rs.getFloat("taxaJuros"));
    		conta.setTaxaRendimento(rs.getFloat("taxaRendimento"));
    		 if(rs.getDate("dataAbertura") != null){
    		   conta.setDataAbertura(new java.util.Date(rs.getDate("dataAbertura").getTime()));	 
    		 }
    		conta.setDiaRendimento(rs.getFloat("diaRendimento"));
    		conta.setNomeGerente(rs.getString("nomeGerente"));
    		
    	}
		
		return conta;
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
		
		String sql ="SELECT * FROM conta ";
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs =pstm.executeQuery();
		Conta conta;
		List<Conta> contas = new ArrayList<Conta>();
		 while(rs.next()){
			 conta=new Conta();
	    		conta.setId(rs.getLong("id"));
	    		conta.setTipo(rs.getString("tipo"));
	    		conta.setNumero(rs.getString("numero"));
	    		conta.setSaldo(rs.getFloat("saldo"));
	    		conta.setLimite(rs.getFloat("limite"));
	    		conta.setTaxaServico(rs.getFloat("taxaServico"));
	    		conta.setTaxaJuros(rs.getFloat("taxaJuros"));
	    		conta.setTaxaRendimento(rs.getFloat("taxaRendimento"));
	    		 if(rs.getDate("dataAbertura") != null){
	    		   conta.setDataAbertura(new java.util.Date(rs.getDate("dataAbertura").getTime()));	 
	    		 }
	    		conta.setDiaRendimento(rs.getFloat("diaRendimento"));
	    		conta.setNomeGerente(rs.getString("nomeGerente"));
	    		
	    		contas.add(conta);
		 }
		
		return contas;
	}

	

}
