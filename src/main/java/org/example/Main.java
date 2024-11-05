package org.example;

import org.example.entity.Usuario;
import org.example.service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        // Crear un usuario nuevo
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuarioService.crearUsuario(usuario);

        // Leer un usuario por ID
        Usuario usuarioObtenido = usuarioService.obtenerUsuarioPorId(1L);
        System.out.println("Nombre del usuario: " + usuarioObtenido.getNombre());
//
//        // Actualizar el nombre del usuario
        usuarioObtenido.setNombre("Juan Actualizado");
        usuarioService.actualizarUsuario(usuarioObtenido);
//
        // Eliminar el usuario
        usuarioService.eliminarUsuario(1L);
    }
}
