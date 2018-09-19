/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.*;
import models.*;
import controllers.*;
/**
 *
 * @author ninte
 */
public class Main {
   
    private static ViewEditorTexto viewEditorTexto;
    private static ModelEditorTexto modelEditorTexto;
    private static ControllerEditorTexto controllerEditorTexto;
    private static ViewPrincipal viewPrincipal;
    private static ModelPrincipal modelPrincipal;
    private static ControllerPrincipal controllerPrincipal;
    
    public static void main(String[]er){
      
        viewEditorTexto = new ViewEditorTexto();
        modelEditorTexto = new ModelEditorTexto();
        controllerEditorTexto = new ControllerEditorTexto (viewEditorTexto, modelEditorTexto);
        modelPrincipal = new ModelPrincipal();
        viewPrincipal = new ViewPrincipal();
        controllerPrincipal = new ControllerPrincipal(viewPrincipal, viewEditorTexto, modelPrincipal);
    }
}
