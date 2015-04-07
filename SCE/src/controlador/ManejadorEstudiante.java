/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.RegistroEstudiantes;
import vista.*;

/**
 *
 * @author ronald
 */
public class ManejadorEstudiante extends Controlador{

     RegistroEstudiantes registro;
     GUIAdminEstudiante gUIAdminEstudiante;
     GUIEstudiante gUIEstudiante;
     PanelListado panelListado;

    public ManejadorEstudiante(RegistroEstudiantes registro, GUIAdminEstudiante gUIAdminEstudiante) {
        this.registro = registro;
        this.gUIAdminEstudiante = gUIAdminEstudiante;

    }

    public ManejadorEstudiante(RegistroEstudiantes registro, GUIAdminEstudiante gUIAdminEstudiante, GUIEstudiante gUIEstudiante) {
        this.registro = registro;
        this.gUIAdminEstudiante = gUIAdminEstudiante;
        this.gUIEstudiante = gUIEstudiante;

        
    }  
     
     @Override
     
    public void actionPerformed(ActionEvent evento) {
        
       if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMantenimiento.BOTON_TYPE_AGREGAR)){
           GUIEstudiante gUIEstudiante=new GUIEstudiante();
           gUIEstudiante.init(Ventana.TYPE_VENTANA_AGREGAR, registro, gUIAdminEstudiante);
           gUIEstudiante.setVisible(true);
       }else{
           if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMantenimiento.BOTON_TYPE_ELIMINAR)){
               
           }
          else
              if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesAccion.BOTON_TYPE_ACEPTAR) && gUIEstudiante.getTipo()==Ventana.TYPE_VENTANA_AGREGAR){
                  PanelEstudiante panel= new PanelEstudiante();
                  if(panel.verificar()==true){
                      System.out.println("VERIFICO");
                      if(registro.buscarEstudiante(panel.getJtIdentificado())==false){
                          try{
                              registro.agregar(panel.getEstudiante());
                          }catch(NumberFormatException ex){
                              System.out.println("agarro exepcion");
                          }
                          System.out.println("agrego");
                        }else{
                          System.out.println("ya existe");
                      }
                      
                    }
                }
        }
       
    }
    
}
