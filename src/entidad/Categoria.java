package entidad;

public class Categoria {
		private int IdCategoria;
		private String Nombre;
		
	    // Constructores
		
		public Categoria() {
	
		}
		
		public Categoria(String Nombre) {
			this.Nombre = Nombre;
		}
		
		public Categoria(int IdCategoria) {
			this.IdCategoria = IdCategoria;
		}
		
		public Categoria(int IdCategoria,String Nombre) {
			this.IdCategoria = IdCategoria;
			this.Nombre = Nombre;
		}
		
	    // Getters y Setters
		
		public int getIdCategoria() {
			return IdCategoria;
		}
		public void setIdCategoria(int idCategoria) {
			IdCategoria = idCategoria;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		
	    // ToString
		
		@Override
		public String toString() {
			return "Categoria [IdCategoria=" + IdCategoria + ", Nombre=" + Nombre + "]";
		}
}
