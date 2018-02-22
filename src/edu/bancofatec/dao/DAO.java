package edu.bancofatec.dao;

import java.sql.SQLException;
import java.util.List;


public interface DAO {
	public int inserir( Object obj ) throws SQLException;
	public Object pesquisarPorId( long id ) throws SQLException;
	public Object pesquisarPorNome( String nome ) throws SQLException;
	public List pesquisarTodos() throws SQLException;
}


