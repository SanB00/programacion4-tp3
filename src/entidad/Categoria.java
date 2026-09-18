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
		
	    public void setIdCategoria(int idCategoria) {
			IdCategoria = idCategoria;
		}

		// Getters y Setters
		public int getIdCategoria() {
			return IdCategoria;
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
			return "Categoria N°" + IdCategoria + "| Nombre:" + Nombre;
		}
}
