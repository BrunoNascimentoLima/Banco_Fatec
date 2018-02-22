package edu.bancofatec.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.bancofatec.entidades.Lancamento;

public class LancamentoDAO implements DAO {

	@Override
	public int inserir(Object obj) throws SQLException {
		Lancamento lancamento;
		if(obj instanceof Lancamento)
			lancamento=(Lancamento)obj;
		 else
			 lancamento =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" +
				"localhost:3306/bancofatec","root",""); 
		String sql ="INSERT INTO lancamento (id,idConta,tipo,descricao,saldoAnterior,saldoPosterior," +
				"valor,dataLancamento) VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setLong(1,lancamento.getId());
		pstm.setLong(2,lancamento.getIdConta());
		pstm.setString(3, lancamento.getTipo());
		pstm.setString(4, lancamento.getDescricao());
		pstm.setFloat(5,lancamento.getSaldoAnterior());
		pstm.setFloat(6,lancamento.getSaldoPosterior());
		pstm.setFloat(7, lancamento.getValor());
		pstm.setDate(8, new java.sql.Date(lancamento.getDataLancamento().getTime()));
	    
		int atualizado = pstm.executeUpdate();	
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
		 
		 String sql ="SELECT * FROM lancamento WHERE id =?";
		 PreparedStatement pstm =con.prepareStatement(sql);
		 pstm.setLong(1, id);
		 ResultSet rs = pstm.executeQuery();
		 Lancamento lancamento= null;
		 if(rs.next()){
			 lancamento = new Lancamento();
			 lancamento.setId(rs.getLong("id"));
			 lancamento.setIdConta(rs.getLong("idConta"));
			 lancamento.setTipo(rs.getString("tipo"));
			 lancamento.setDescricao(rs.getString("descricao"));
			 lancamento.setSaldoAnterior(rs.getFloat("saldoAnterior"));
			 lancamento.setSaldoPosterior(rs.getFloat("saldoPosterior"));
			 lancamento.setValor(rs.getFloat("valor"));
			 if(rs.getDate("dataLancamento") != null){
			  lancamento.setDataLancamento(new java.util.Date(rs.getDate("dataLancamento").getTime()));
			 }
		 }
		 
		return lancamento;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Connection con = DriverManager.getConnection("jdbc:mysql://" +
			 		"localhost:3306/bancofatec","root","");
			 
			 String sql ="SELECT * FROM lancamento";
			 PreparedStatement pstm =con.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 List<Lancamento> lancamentos = new ArrayList<Lancamento>();
			 while(rs.next()){
				 Lancamento lancamento = null;
			 	 lancamento = new Lancamento();
				 lancamento.setId(rs.getLong("id"));
				 lancamento.setIdConta(rs.getLong("idConta"));
				 lancamento.setTipo(rs.getString("tipo"));
				 lancamento.setDescricao(rs.getString("descricao"));
				 lancamento.setSaldoAnterior(rs.getFloat("saldoAnterior"));
				 lancamento.setSaldoPosterior(rs.getFloat("saldoPosterior"));
				 lancamento.setValor(rs.getFloat("valor"));
				 if(rs.getDate("dataLancamento") != null){
				  lancamento.setDataLancamento(new java.util.Date(rs.getDate("dataLancamento").getTime()));
		
               	}
				 lancamentos.add(lancamento);
              }
           return lancamentos;
	     }
	
	public List pesquisarEntreDatas(String dataInicio,String dataFim,long idConta) throws SQLException,ParseException {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	long data1=	df.parse(dataInicio).getTime();
    	long data2=	df.parse(dataFim).getTime();

		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Connection con = DriverManager.getConnection("jdbc:mysql://" +
			 		"localhost:3306/bancofatec","root","");
			 
			 
			 String sql ="SELECT * FROM lancamento WHERE idConta ="+idConta+" AND dataLancamento BETWEEN '"
			 +new java.sql.Date(data1)+"' AND '"+new java.sql.Date(data2)+"'";
			 
			 PreparedStatement pstm =con.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 List<Lancamento> lancamentos = new ArrayList<Lancamento>();
			 while(rs.next()){
				 Lancamento lancamento = null;
			 	 lancamento = new Lancamento();
				 lancamento.setId(rs.getLong("id"));
				 lancamento.setIdConta(rs.getLong("idConta"));
				 lancamento.setTipo(rs.getString("tipo"));
				 lancamento.setDescricao(rs.getString("descricao"));
				 lancamento.setSaldoAnterior(rs.getFloat("saldoAnterior"));
				 lancamento.setSaldoPosterior(rs.getFloat("saldoPosterior"));
				 lancamento.setValor(rs.getFloat("valor"));
				 if(rs.getDate("dataLancamento") != null){
				  lancamento.setDataLancamento(new java.util.Date(rs.getDate("dataLancamento").getTime()));
		
              	}
				 lancamentos.add(lancamento);
             }
          return lancamentos;
	     }

}