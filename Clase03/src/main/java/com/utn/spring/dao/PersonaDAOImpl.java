package com.utn.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.utn.spring.beans.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO{
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private Connection con = null;
	private PreparedStatement stmt = null;

	public Persona busacarPersona(int idPersona) {
		
		Persona persona = null;
		String sql = "SELECT * FROM personas WHERE ID = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_personas";
			con = DriverManager.getConnection(url, "root", "");
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idPersona);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next() == true){
				int id = rs.getInt("id");
				int dni = rs.getInt("dni");
				String nombre = rs.getString("nombre");
				
				persona = new Persona(id, dni, nombre);
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally{
			
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return persona;
	}
	
	
	public int cantidadPersonas(){
		String sql = "SELECT COUNT(*) FROM personas";
		return jdbcTemplate.queryForObject(sql , Integer.class);
	}
	
	public String buscarNombre (int id){
		String sql = "SELECT nombre FROM personas WHERE ID=?";
		return jdbcTemplate.queryForObject( sql, new Object[] { id }  ,  String.class );
	}
	
	
	public Persona buscarPersona (int id){
		
		String sql = "SELECT * FROM personas WHERE ID=?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { id }  ,  new PersonaMapper() );
		
	}
	
	public List<Persona> buscarPersonas (){
		String sql = "SELECT * FROM personas";
		return jdbcTemplate.query(sql, new PersonaMapper() );
	}
	
	public void insertarPersona (Persona persona){
		String sql = "INSERT INTO personas () VALUES (? , ? , ?)";
		jdbcTemplate.update(sql, new Object[] { null,persona.getNombre(), persona.getDni()} );
	}
	
	
	private static final class PersonaMapper implements RowMapper<Persona>{

		@Override
		public Persona mapRow(ResultSet resulSet, int rowNumber) throws SQLException {
			Persona persona = new Persona();
			
			persona.setId(resulSet.getInt("id"));
			persona.setDni(resulSet.getInt("dni"));
			persona.setNombre(resulSet.getString("nombre"));
			
			return persona;
		}
		
	}

	
	

}
