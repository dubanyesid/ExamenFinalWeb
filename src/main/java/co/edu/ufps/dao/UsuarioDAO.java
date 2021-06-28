package co.edu.ufps.dao;

import co.edu.ufps.entities.Usuario;
import co.edu.ufps.util.Conexion;

public class UsuarioDAO extends Conexion<Usuario> implements GenericDao<Usuario>{
	public UsuarioDAO (){
		super(Usuario.class);
	}
}