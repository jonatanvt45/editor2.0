/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewEditorTexto;
import models.ModelEditorTexto;
import java.io.FileReader;
import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
/**
 *
 * @author ninte
 */
public class ControllerEditorTexto {
    ViewEditorTexto view_editortexto;
    ModelEditorTexto model_editortexto;
    FileReader fr = null;
    FileWriter fw = null;
    JFileChooser jfc = new JFileChooser();
    public ControllerEditorTexto (ViewEditorTexto viewEditorTexto, ModelEditorTexto model_editortexto){
        this.model_editortexto = model_editortexto;
        this.view_editortexto = viewEditorTexto;
        initView();
    }
    public void initView(){
        view_editortexto.jbtn_abrir.addActionListener(e -> jbtn_abrir());
        view_editortexto.jbtn_guardar.addActionListener(e -> jbtn_guardar());

    }
    private void jbtn_abrir(){
        try{
            jfc.showOpenDialog(view_editortexto);
            model_editortexto.setArchivo(jfc.getSelectedFile());
            fr = new FileReader(model_editortexto.getArchivo());
            int character = 0;
            String texto = "";
            while((character = fr.read())!= -1){
            texto +=(char) character;
        }
            fr.close();
            view_editortexto.jta_archivo.setText(texto);
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
        finally{
            try{
                fr.close();
            }
            catch(IOException err){
                System.err.println("Error al cerrar");
            }
        }
    }
    public void jbtn_guardar(){
        try{
            fw = new FileWriter(model_editortexto.getArchivo(),false);
            fw.write(view_editortexto.jta_archivo.getText());
            fw.close();
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado");
        }
        catch(IOException err){
            System.err.println("Error en el archivo");
        }
    }
}
