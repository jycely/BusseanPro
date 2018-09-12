/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.frontend.converter.util;

import co.bussean.backend.persistence.entity.IEntity;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author User
 */
public class AbstractConverter implements Converter {

    protected String nombreMBean;

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         try {
            Integer i = Integer.valueOf(value);
            ManagedBean d = (ManagedBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, nombreMBean);
            System.out.println(d.getObject(i)+" ELEMENTO ESCOGIDO ");
            return d.getObject(i);
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage("Error! - No se puede Convertir el Objeto"));
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof IEntity) {
                IEntity conInt = (IEntity) value;
                System.out.println(conInt);
                return conInt.getId();
            }else{
                return null;
            }
        } catch (Exception e) {
            return " "+e.getMessage();
        }
    }
    
}
