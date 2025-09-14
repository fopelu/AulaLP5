/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author u1845853
 */
public class Util {
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);           
        }
    }
    public static void limpar(JComponent ... componentes){  
        for (int i = 0; i < componentes.length; i++) {
            //Como o JtextField é pai do formatted e do password não precisa do instanceof para eles
            if (componentes[i] instanceof JTextField) { //Vê se o componentes pode ou já foi um JTextField/ JComboBox e etc
                ((JTextField) componentes[i]).setText("");//Transforma o componentes[i] que é JComponent que não tem setText em jTextField que tem setText
            }
            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1); 
            }
            if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            }
            
        }     
    }
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }
    public static boolean perguntar(String cad){
        int opcao = JOptionPane.showConfirmDialog(null, cad, cad, JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }
    public static int strToInt(String cad){
        return Integer.parseInt(cad);
    }
    public static String intToStr(int num){
        return String.valueOf(num);
    }
    public static double strToDouble(String cad){
        return Double.parseDouble(cad);
    }
    public static String DoubleToStr(double num){
        return String.valueOf(num);
    }
    public static Date strToDate(String cad){
        try {
            SimpleDateFormat dataNascFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dataNascFormat.parse(cad);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String dateToStr(Date dataNasc){
        if(dataNasc == null )return "";
        SimpleDateFormat dataNascFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dataNascFormat.format(dataNasc);
    } 
}

