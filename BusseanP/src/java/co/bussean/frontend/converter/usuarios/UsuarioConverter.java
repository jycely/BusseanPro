/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.frontend.converter.usuarios;

import co.bussean.backend.persistence.entity.Usuario;
import co.bussean.frontend.converter.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author User
 */
@FacesConverter(forClass = Usuario.class)

public class UsuarioConverter extends AbstractConverter {

    public UsuarioConverter() {
        this.nombreMBean = "usuariosManagedBean";
    }
}
