/**
 Proyecto de Carlos Eduardo Castelán Vázquez ID:153794
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame implements ActionListener {
    private JButton botonSi;
    private JButton botonNo;
    private JLabel imagenLbl;
    private JTextArea texto;
    private  String[] preguntas = {"¿Es Hombre?\n", "\n¿Está vivo?\n", "\n¿Es americano?\n", "\n¿Usa Lentes?\n"};
    private ImageIcon icono;
    private String[] respuestas = new String[3];

    private int counter = 0;
    private int index = 0;

    public Interfaz(){

        setLayout(null);

        setSize(700, 500);

        addComponents();

        setDefaultCloseOperation(3);

        setVisible(true);

    }

    public void addComponents(){

        botonSi = new JButton("Si");
        botonSi.setBounds(370, 375, 75, 75);
        botonSi.addActionListener(this);
        add(botonSi);

        botonNo = new JButton("No");
        botonNo.setBounds(590, 375, 75, 75);
        botonNo.addActionListener(this);
        add(botonNo);



        texto = new JTextArea();
        texto.setEditable(false);





        texto.setBounds(350, 10, 340, 340);
        add(texto);

        icono = new ImageIcon("./IA.jpg");
        imagenLbl = new JLabel(icono);
        imagenLbl.setBounds(10, 10, 330, 330);
        add(imagenLbl);
        texto.append("Para jugar piense en alguno de los\n" +
                "personajes de la izquierda\n" +
                "Después conteste las siguientes preguntas\n" +
                "con los botones de abajo\n"+ "Para reiniciar el juego apriete alguno de los botones\n" +
                "depués de que adivinara el personaje\n");
        texto.append(preguntas[0]);
    }


    public void actionPerformed(ActionEvent action){

        String stringAction;
        stringAction = action.getActionCommand();

        if (counter >= preguntas.length) {
            return;
        }
        else {
            if (index < respuestas.length) {
                texto.append("\n" + stringAction + "\n");
                respuestas[index] = stringAction;
                mostrarPregunta(index);
                index++;
            }
            else{
                reiniciarJuego();
            }
        }
    }

    public void mostrarPregunta ( int index) {

        if(index == 0){
            texto.append(preguntas[1]);
        }
        else if(index == 1){
            if(respuestas[0].equals("Si")){
                texto.append(preguntas[3]);
            }
            else{
                texto.append(preguntas[2]);
            }
        }
        else{
            texto.append("\nOk!, dejame adivinar...\n");

            texto.append("\n" + ProjectDeductiveDatabase.getCharacter(String.join("", respuestas)));



        }
        counter++;
    }

    public void reiniciarJuego(){
        int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres jugar de nuevo?", "Reiniciar",JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION){
            index = 0;
            counter = 0;
            respuestas = new String[3];
            texto.setText(preguntas[0]);
        }
        else{
            System.exit(0);
        }
    }

}
