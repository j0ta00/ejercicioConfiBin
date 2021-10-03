package vista;

import com.sun.tools.javac.Main;
import main.Principal;

import javax.swing.*;
import java.awt.event.*;
import java.nio.channels.IllegalBlockingModeException;
import java.util.Locale;

public class Vista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton btnMostrarDatos;
    private JButton btnBooleano;
    private JButton btnCadena;
    private JButton btnDecimal;
    private JButton btnCaracter;
    private JTextField txtCadena;
    private JTextField txtCacracter;
    private JTextField txtDecimal;
    private JTextField txtBooleano;
    private JLabel txtOpcion2;
    private JLabel txtOpcion1;
    private JLabel txtOpcion3;
    private JLabel txtOpcion4;
    private JLabel txtOpcion5;
    private JLabel lblDatos;

    public Vista() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnCadena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCadena.getText().isEmpty()) {
                    Principal.opcionCambiarCadena(txtCadena.getText());
                }
            }
        });
        btnCaracter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char caracter;
                if(!txtCacracter.getText().isEmpty()) {
                    caracter=txtCacracter.getText().charAt(0);
                    Principal.opcionCambiarCaracter(caracter);
                }
            }
        });
        btnDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtDecimal.getText().isEmpty()) {
                    Principal.opcionCambiarDecimal(Double.valueOf(txtDecimal.getText()));
                }
            }
        });
        txtDecimal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();}
            }
        });
        btnBooleano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean booleano=true;
                if(!txtBooleano.getText().isEmpty()) {
                    if(txtBooleano.getText().toLowerCase(Locale.ROOT).equals("false")){
                        booleano=false;
                    }
                }

                Principal.opcionCambiarBooleano(booleano);
            }
        });
        btnMostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal.LlamarALeerDatos();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void mostrarDatos(String cadena,char caracter,double decimalm,boolean booleano){
        lblDatos.setText(String.format("Los datos son: \n Cadena: %s \n carácter: %s \n decimal: %s \n booleano: %s",cadena,String.valueOf(caracter),
                String.valueOf(decimalm),String.valueOf(booleano)));
    }
}
