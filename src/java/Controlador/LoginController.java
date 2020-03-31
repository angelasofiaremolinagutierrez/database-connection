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
    private List<Usuario> listaUsuarios;
    
    @EJB
    private UsuarioDAO ejbDao;
    
    public LoginController() {
    }
    
    public void login() throws IOException{
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ex = context.getExternalContext();
        ex.redirect("home");
        
        user = null;
        
        for(Usuario u:listaUsuarios){
            if(u.getCorreo().equals(user.getCorreo())&& u.getClave().equals(user.getClave())){
                user = u;
                break;
            }
        }
    }

    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
