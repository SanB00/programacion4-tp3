package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



import entidad.Categoria;

public class DaoCategoria {
	
	private String host="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String pass="root";
	private String dbName="bdinventario";
	
	public DaoCategoria() {}
	
	public int agregarCategoria(Categoria categoria) {
		String query = "INSERT INTO Categorias(Nombre) VALUES('"+categoria.getNombre()+"')";
		
		Connection cn = null;
		int filas = 0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return filas;
	}
	public Categoria getCategoria(int id) {
		Categoria cat= new Categoria();
		String query="select * from categorias where IdCategoria=?";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			cat.setIdCategoria(rs.getInt("IdCategoria"));
			cat.setNombre(rs.getString("Nombre"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cat;		
	}
	public ArrayList<Categoria> getCategorias(){
		ArrayList<Categoria> lcat=new ArrayList<Categoria>();
		String query="select * from categorias";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			Statement st=(Statement) cn.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				Categoria cat= new Categoria();
				cat.setIdCategoria(rs.getInt("IdCategoria"));
				cat.setNombre(rs.getString("Nombre"));
				lcat.add(cat);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lcat;
	}
	public int modificarCategoria(int categoria,String nombre) {
		String query="update categorias set Nombre=? where IdCategoria=?";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, categoria);
			return ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public int eliminarCategoria(int idCategoria) {
		String query="Delete from categorias where IdCategoria=?";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setInt(1, idCategoria);
			return ps.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

}
