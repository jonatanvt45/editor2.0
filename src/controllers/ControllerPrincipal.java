/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.*;
import models.*;
/**
 *
 * @author ninte
 */
public class ControllerPrincipal {
    ViewPrincipal viewPrincipal;
    ViewEditorTexto viewEditorTexto;

    ModelPrincipal modelPrincipal;
    public ControllerPrincipal(ViewPrincipal viewPrincipal, ViewEditorTexto viewEditorTexto, ModelPrincipal modelPrincipal){
        this.viewPrincipal = viewPrincipal;
        this.viewEditorTexto = viewEditorTexto;
        this.modelPrincipal = modelPrincipal;
        this.viewPrincipal.jmi_bloc.addActionListener(e->jmi_bloc_click());
        initView();
    }
    
    
    public void jmi_bloc_click(){
        this.viewPrincipal.setContentPane(viewEditorTexto);
        this.viewPrincipal.revalidate();
        this.viewPrincipal.repaint();
    }
    private void initView(){
        this.viewPrincipal.setTitle("EDitor 2.0");
        this.viewPrincipal.setLocationRelativeTo(null);
        this.viewPrincipal.setVisible(true);
    }
}
