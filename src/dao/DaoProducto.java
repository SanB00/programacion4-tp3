package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.Statement;

import entidad.Producto;

public class DaoProducto {
	private String host="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String pass="root";
	private String dbname="bdinventario";
	
	public DaoProducto() {}
	
	public int agregarProducto(Producto prod) {
		String query=("Insert into productos (Codigo,Nombre,Precio,Stock,IdCategoria) values(?,?,?,?,?)");
		Connection cn=null;
		int filas=0;
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setString(1,prod.getCodigo());
			ps.setString(2, prod.getNombre());
			ps.setDouble(3, prod.getPrecio());
			ps.setInt(4, prod.getStock());
			ps.setInt(5, prod.getIdCategoria());
			filas=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	public Producto getProducto(String Codigo) {
		String query="select * from productos where codigo=?";
		Connection cn=null;
		Producto prod=new Producto();
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			PreparedStatement ps=(PreparedStatement)cn.prepareStatement(query);	
			ps.setString(1,Codigo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			prod.setCodigo(rs.getString("Codigo"));
			prod.setNombre(rs.getString("Nombre"));
			prod.setPrecio(rs.getDouble("Precio"));
			prod.setStock(rs.getInt("Stock"));
			prod.setIdCategoria(rs.getInt("IdCategoria"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return prod;
	}
	public ArrayList<Producto> getProductos(){
		String query="Select * from productos";
		Connection cn=null;
		ArrayList<Producto> lprod= new ArrayList<Producto>();
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			Statement st=(Statement) cn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				Producto prod= new Producto();
				prod.setCodigo(rs.getString("Codigo"));
				prod.setNombre(rs.getString("Nombre"));
				prod.setPrecio(rs.getDouble("Precio"));
				prod.setStock(rs.getInt("Stock"));
				prod.setIdCategoria(rs.getInt("IdCategoria"));
				lprod.add(prod);
			}
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return lprod;
	}
	public int modificarProducto(String codigo,String nombre,double Precio,int stock,int IdCategoria ) {
		String query="Update Productos set Nombre=?,Precio=?,Stock=?,IdCategoria=? where codigo=?";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setDouble(2, Precio);
			ps.setInt(3, stock);
			ps.setInt(4, IdCategoria);
			ps.setString(5, codigo);
			return ps.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	public int eliminarProducto(String codigo) {
		String query="Delete from productos where codigo=?";
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(host+dbname,user,pass);
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(query);
			ps.setString(1, codigo);
			return ps.executeUpdate();	}
		catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
				
	}
	
	
}
