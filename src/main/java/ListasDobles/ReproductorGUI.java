package ListasDobles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReproductorGUI extends JFrame {
    private ListaReproduccion lista = new ListaReproduccion();
    private JTextField campoTitulo = new JTextField(15);
    private JTextField campoArtista = new JTextField(15);
    private JTextArea areaLista = new JTextArea(10, 30);
    private JLabel etiquetaActual = new JLabel("Canción actual: ---");

    public ReproductorGUI() {
        super("Reproductor de Música");

        JButton btnAgregar = new JButton("Agregar Canción");
        JButton btnEliminar = new JButton("Eliminar Canción");
        JButton btnReproducir = new JButton("Reproducir");
        JButton btnSiguiente = new JButton("Siguiente");
        JButton btnAnterior = new JButton("Anterior");
        JButton btnLoop = new JButton("Loop");
        

        areaLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaLista);

        JPanel panelInputs = new JPanel();
        panelInputs.add(new JLabel("Título:"));
        panelInputs.add(campoTitulo);
        panelInputs.add(new JLabel("Artista:"));
        panelInputs.add(campoArtista);
        panelInputs.add(btnAgregar);
        panelInputs.add(btnEliminar);
        panelInputs.add(btnLoop);

        JPanel panelControles = new JPanel();
        panelControles.add(btnAnterior);
        panelControles.add(btnReproducir);
        panelControles.add(btnSiguiente);

        setLayout(new BorderLayout());
        add(panelInputs, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);
        add(etiquetaActual, BorderLayout.WEST);

        btnAgregar.addActionListener(e -> {
            String titulo = campoTitulo.getText().trim();
            String artista = campoArtista.getText().trim();
            if (!titulo.isEmpty() && !artista.isEmpty()) {
                lista.agregar(new Cancion(titulo, artista));
                areaLista.setText(lista.mostrarTodas());
                campoTitulo.setText("");
                campoArtista.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Complete the sentences.");
            }
        });

        btnLoop.addActionListener(e -> {
            lista.setLoop(!lista.isLoop());
            btnLoop.setText(lista.isLoop() ? "Desactivar Loop" : "Activar Loop");
        });

        btnEliminar.addActionListener(e -> {
            String titulo = campoTitulo.getText().trim();
            String artista = campoArtista.getText().trim();
            if (!titulo.isEmpty() && !artista.isEmpty()) {

                lista.eliminarActual();
                areaLista.setText(lista.mostrarTodas());
                etiquetaActual.setText("Canción actual: ---");

            } else {
                JOptionPane.showMessageDialog(this, "Complete the sentences.");
            }
        });

        btnReproducir.addActionListener(e -> {
            Cancion c = lista.getActual();
            if (c != null) {
                etiquetaActual.setText("Playing: " + c);
            } else {
                etiquetaActual.setText("There is no music.");
            }
        });

        btnSiguiente.addActionListener(e -> {
            Cancion c = lista.siguiente();
            if (c != null) {
                etiquetaActual.setText("Playing: " + c);
            } else {
                etiquetaActual.setText("End of the list.");
            }
        });

        btnAnterior.addActionListener(e -> {
            Cancion c = lista.anterior();
            if (c != null) {
                etiquetaActual.setText("Playing: " + c);
            } else {
                etiquetaActual.setText("Start of the list.");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReproductorGUI::new);
    }
}
