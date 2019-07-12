package avl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Brayan
 */
public class Ventana extends JFrame {

    AVL a=new AVL();

    public Ventana() {
        setSize(900, 600);
        setTitle("AVL");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1000, 1000, 1000, 1000);
        this.getContentPane().add(panel);
        JButton insertarPropietario = new JButton("1.Insertar ");
        //JButton insertarPropiedad = new JButton("2.Insertar Propiedad");
        JButton retirarPropiedad = new JButton("3.Retirar ");
        //JButton retirarPropietario = new JButton("4. Retirar Propietario");
        JButton imprimir = new JButton("5.Imprimir");
        JLabel numero = new JLabel("Dato:");
        //JLabel nom = new JLabel("Nombre:");
        //JLabel val = new JLabel("Valor:");
        //JLabel resultado = new JLabel();

   
  
        numero.setBounds(10, 180, 50, 20);
        //nom.setBounds(235, 100, 50, 20);
        //val.setBounds(430, 100, 50, 20);
        //resultado.setBounds(250, 300, 500, 20);

        insertarPropietario.setBounds(10, 50, 200, 20);
        //insertarPropiedad.setBounds(230, 50, 200, 20);
        retirarPropiedad.setBounds(10, 90, 200, 20);
        //retirarPropietario.setBounds(660, 50, 200, 20);
        imprimir.setBounds(10, 130, 100, 20);
        panel.add(insertarPropietario);
        //panel.add(insertarPropiedad);
        panel.add(retirarPropiedad);
        //panel.add(retirarPropietario);
        panel.add(numero);
        //panel.add(resultado);

        panel.add(imprimir);
        //panel.add(nom);
        //panel.add(val);
        JTextField dato = new JTextField();
        //JTextField nombre = new JTextField();
        //JTextField valor = new JTextField();
        dato.setBounds(60, 180, 100, 20);
        //nombre.setBounds(300, 100, 100, 20);
        //valor.setBounds(480, 100, 100, 20);
        panel.add(dato);
        //panel.add(nombre);
        //panel.add(valor);
        ActionListener accioninsertar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //System.out.println(a.insAVL(Integer.parseInt(dato.getText())));
                
            }
        };
        insertarPropietario.addActionListener(accioninsertar);

  

        

        ActionListener accionretirar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(a.retirarAVL(Integer.parseInt(dato.getText())));

            }
        };
        retirarPropiedad.addActionListener(accionretirar);
        
        ActionListener imprimirMl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        };
        imprimir.addActionListener(imprimirMl);

    }



}