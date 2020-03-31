/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioDAO;
import Modelos.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author asrg2
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable{

    private Usuario user;
    private Usuario usuarioAutenticado=null;
    
    @EJB
    private UsuarioDAO ejbDao;
    
    public LoginController() {
        user = new Usuario();
    }
    
    public void login() throws IOException{
        usuarioAutenticado = ejbDao.encontrarUsuarioPorLogin(user.getCorreo(), user.getClave());
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();
        
        if (usuarioAutenticado==null) {
            
            ex.redirect("index");
        }
        else{
            ex.redirect("home");
        }
        
        
    }

    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public UsuarioDAO getEjbDao() {
        return ejbDao;
    }

    public void setEjbDao(UsuarioDAO ejbDao) {
        this.ejbDao = ejbDao;
    }

}
