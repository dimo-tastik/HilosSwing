import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElInterfaz extends JFrame {
    private JButton btnSinHilos;
    private JButton btnConHilos;
    private JProgressBar pbProgreso;
    private JTextArea textAreaTexto;
    private JPanel panelPrincipal;

    public ElInterfaz() {

    }

    public void inicializarVentana() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(panelPrincipal.getPreferredSize());
        setLocationRelativeTo(null);
        inicializarBotones();

        setVisible(true);
    }

    private void inicializarBotones() {
        btnSinHilos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnSinHilosMouseClicked(e);
            }
        });
        btnConHilos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnConHilosMouseClicked(e);
            }
        });
    }

    private void btnSinHilosMouseClicked(java.awt.event.MouseEvent evt) {
        int suma = 0;
        for (int i = 0; i < 2000; i++) {
            suma = suma + i;
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("Error, hilo interrumpido");
            } /*Fin del catch*/
        } /* Fin del for*/
    }

    private void btnConHilosMouseClicked(java.awt.event.MouseEvent evt) {
        TareaParalelizada t = new TareaParalelizada(this.pbProgreso, 1, 2000);
        t.execute();
    }


}
