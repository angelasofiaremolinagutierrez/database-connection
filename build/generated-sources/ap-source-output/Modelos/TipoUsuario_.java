package Modelos;

import Modelos.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-31T19:12:43")
@StaticMetamodel(TipoUsuario.class)
public class TipoUsuario_ { 

    public static volatile SingularAttribute<TipoUsuario, String> nombreTipo;
    public static volatile ListAttribute<TipoUsuario, Usuario> usuarioTipo;
    public static volatile SingularAttribute<TipoUsuario, Integer> id;

}