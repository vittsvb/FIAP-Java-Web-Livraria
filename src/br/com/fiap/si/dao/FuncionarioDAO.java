package br.com.fiap.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.si.bean.Funcionario;
import br.com.fiap.si.factory.ConnectionFactory;

public class FuncionarioDAO {

	Connection conn = null;
	
	public FuncionarioDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public void insert(Funcionario f){

		String sql = "INSERT INTO FUNCIONARIOS(CPF, NOME, SALARIO) VALUES(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, f.getCpf());
			stmt.setString(2, f.getNome());
			stmt.setDouble(3, f.getSalario());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		
	}

	public void delete(String cpf){

		String sql = "DELETE FROM FUNCIONARIOS WHERE CPF = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, cpf);
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		
	}
	
	public void udpate(Funcionario f){

		String sql = "UPDATE FUNCIONARIOS SET NOME = ?, SALARIO = ? WHERE CPF = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, f.getNome());
			stmt.setDouble(2, f.getSalario());
			stmt.setString(3, f.getCpf());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		
	}
	
	public List<Funcionario> getAll(){

		String sql = "SELECT * FROM FUNCIONARIOS ORDER BY SALARIO DESC";
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
					
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Funcionario f = new Funcionario();
				
				f.setCpf(rs.getString("CPF"));
				f.setNome(rs.getString("NOME"));
				f.setSalario(rs.getDouble("SALARIO"));
				
				funcionarios.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}

		return funcionarios;		
	}
	
	public List<Funcionario> getFuncionarioByPk(String cpf){

		String sql = "SELECT * FROM FUNCIONARIOS WHERE CPF = ?";
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);		
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Funcionario f = new Funcionario();
				
				f.setCpf(rs.getString("CPF"));
				f.setNome(rs.getString("NOME"));
				f.setSalario(rs.getDouble("SALARIO"));
				
				funcionarios.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}

		return funcionarios;		
	}
	
	public List<Funcionario> getFuncionarioByNome(String nome){

		String sql = "SELECT * FROM FUNCIONARIOS WHERE NOME LIKE ?";
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");		
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Funcionario f = new Funcionario();
				
				f.setCpf(rs.getString("CPF"));
				f.setNome(rs.getString("NOME"));
				f.setSalario(rs.getDouble("SALARIO"));
				
				funcionarios.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}

		return funcionarios;		
	}
}
