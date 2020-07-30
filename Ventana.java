
package Ventana;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
        
/**
 *
 * @author Gino Ortiz  <ginojavier96@gmail.com>
 */
public class Ventana extends JFrame{
   private JPanel Panel;
   private final String[] Monedas = {"Lempira", "Euro", "Dolar", "Yuan", "Libra"};
   private String Moneda, Moneda2, Resultado;
   private JComboBox org, dst;
   private JTextField entrada;
   private double Calculo;
        
    public Ventana(){
        this.setSize(235,320);
        this.setTitle("Conversor de Monedas");
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200,270));
        iniciarTODO();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarTODO(){
        iniciarpanel();
        Stickers();
        menudesplegable();
        boton();
        texto();
    }
    
    private void iniciarpanel(){
        Panel= new JPanel ();
        Panel.setLayout(null);
        this.getContentPane().add(Panel);
    }
    
    private void Stickers(){
        JLabel Origen= new JLabel();
        Origen.setText("Seleccione Moneda de Origen: ");
        Origen.setBounds(20,10,180,20); //x,y,largo, ancho,
        Panel.add(Origen);
        JLabel Destino=new JLabel();
        Destino.setText("Seleccione Moneda de Destino: ");
        Destino.setBounds(20,80,180,20);
        Panel.add(Destino);
        JLabel Cantidad= new JLabel();
        Cantidad.setText("Cantidad:");
        Cantidad.setBounds(20,155,53,20);
        Panel.add(Cantidad);
        JLabel Respuesta =new JLabel();
        Respuesta.setText("Respuesta: ");
        Respuesta.setBounds(20,240,100,30);
        Panel.add(Respuesta);
    }
    
    private void menudesplegable(){
        org= new JComboBox(Monedas);
        org.setBounds(20,45,180,20);
        dst= new JComboBox(Monedas);
        dst.setBounds(20,115,180,20);
        Panel.add(org);
        Panel.add(dst);
    }
    
    private void boton(){
        JButton BT =new JButton("Convertir");
        JLabel Rps = new JLabel();
        JLabel Error = new JLabel ();
        Error.setText("     ");
        Rps.setText("     ");   
        Rps.setBounds(120,240,100,30);
        Panel.add(Rps);
        BT.setBounds(60,195,100,30);
        Panel.add(BT);
        Error.setBounds(84,167,130,30);
        Panel.add(Error);
        BT.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {       
        Moneda = (String) org.getItemAt(org.getSelectedIndex());
        Moneda2= (String) dst.getItemAt(dst.getSelectedIndex());
        
        boolean numero = true;
        try {
            Double num = Double.parseDouble(entrada.getText());
        } catch (NumberFormatException f) {
            numero = false;
        }

        if(numero){
        Error.setText("     ");
        Calculo = Double.parseDouble(entrada.getText());
        Resultado=String.valueOf(Calculo());
        Rps.setText(Resultado+" " + Moneda2);
        }else{
                Error.setForeground(Color.red);
                Error.setText("Error, solo numeros");
                }
       
        }
     });
        
    }
    
    private void texto(){
         entrada=new JTextField();
         entrada.setBounds(83,155,120,20);
         Panel.add(entrada);
    }
    
    private double Calculo(){
        double a = 0;
        double b=0;
        switch(Moneda){
            case "Lempira":{
                a=Calculo/24.7;
                break;
            }
            case "Euro":{
                a=Calculo/0.85;
                break;
            }
            case "Dolar":{
                a=Calculo*1;
                break;
            }
            case "Yuan":{
                a=Calculo/7;
                break;
            }
            case "Libra":{
                a=Calculo/0.7704;
                break;
            }
        }
       
        switch(Moneda2){
            case "Lempira":{
                b=a*24.7;
                break;
            }
            case "Euro":{
                b=a*0.85;
                break;
            }
            case "Dolar":{
                b=a*1;
                break;
            }
            case "Yuan":{
                b=a*7;
                break;
            }
            case "Libra":{
                b=a*0.7704;
                break;
            }
        }       
        b=Math.round(b*100.0)/100.0;
        return b;
    }
    
    
}
