package main;

import dao.DaoCategoria;
import entidad.Categoria;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		System.out.println("LISTADO de CATEGORIAS");
		DaoCategoria daoCategoria = new DaoCategoria();
		ArrayList<Categoria> listadoCategorias =  daoCategoria.getCategorias();

		Iterator<Categoria> iterator = listadoCategorias.iterator();
		while (iterator.hasNext()) {
			Categoria categoria = iterator.next();
			System.out.println(categoria);
		}
	}

}
