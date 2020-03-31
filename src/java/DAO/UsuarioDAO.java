package DAO;

import Modelos.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author asrg2
 */
@Stateless
public class UsuarioDAO {
    
    private final static Logger LOGGER = Logger.getLogger("UsuarioDAO");
    
    private EntityManagerFactory factory;
    
    private EntityManager em;
    
    public void crear(Usuario entity){
        em.persist(entity);
    }
    
    public void editar(Usuario entity){
        em.merge(entity);
    }
    
    public void eliminar(Usuario entity){
        em.remove(em.merge(entity));
    }
    
    public Usuario encontrarUsuario(String correo){
        return em.find(Usuario.class, correo);
    }
    
    public Usuario encontrarUsuarioPorLogin(String correo, String clave){
        crearConexion();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :mail AND u.clave = :pass");
        q.setParameter("mail", correo);
        q.setParameter("pass", clave);
        try{
            return (Usuario)q.getSingleResult();//covertir object a Usuario
        }catch(NoResultException e){
            LOGGER.severe("ERROR AL CONSULTAR");
            //cerrarConexion();
            return null;
        }finally{
            LOGGER.severe("CONEXIÓN CERRADA");
            cerrarConexion();
        }
    }
    
    public void crearConexion(){
        factory = Persistence.createEntityManagerFactory("databasePracticePU");
        em = factory.createEntityManager();
    }
    
    public void cerrarConexion(){
        em.close();
    }
    
    public List<Usuario> listar(){
        
        crearConexion();
        Query q = em.createQuery("SELECT u FROM Usuario u");
        
        try{
            return q.getResultList();
        }catch(Exception e){
            LOGGER.severe("ERROR AL CONSULTAR");
            return null;
        }finally{
            LOGGER.severe("CONEXIÓN CERRADA");
            cerrarConexion();
        }
    }
    
    
}
