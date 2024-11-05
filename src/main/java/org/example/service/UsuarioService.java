package org.example.service;

import org.example.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    // Crear un usuario
    public void crearUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);  // Agrega la entidad a la base de datos
        em.getTransaction().commit();
        em.close();
    }

    // Leer (buscar) un usuario por ID
    public Usuario obtenerUsuarioPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    // Actualizar un usuario
    public void actualizarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);  // Actualiza la entidad existente
        em.getTransaction().commit();
        em.close();
    }

    // Eliminar un usuario
    public void eliminarUsuario(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);  // Elimina la entidad de la base de datos
        }
        em.getTransaction().commit();
        em.close();
    }
}
