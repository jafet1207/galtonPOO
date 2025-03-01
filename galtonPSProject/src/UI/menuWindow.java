/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Excepciones.miExcepcion;
import classesPS.galton;
import classesPS.trianguloPascal;
import javax.swing.JOptionPane;

/**
 * Ventana donde se muestran todas las funcionalidades de Pascal y Galton
 * @author Priscilla Chacón
 * @author Álvaro Moreira
 * @author Jafet Valverde
 */
public class menuWindow extends javax.swing.JFrame {

    int opc = 0;
    int altura = 0;
    int diagonal = 0;

    /**
     * Creates new form MenuWindow
     */
    public menuWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnIniciar.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPascal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnDiagonales = new javax.swing.JButton();
        btnSumasHorizontales = new javax.swing.JButton();
        btnSierpinski = new javax.swing.JButton();
        btnSimetría = new javax.swing.JButton();
        btnFibonacci = new javax.swing.JButton();
        btnGalton = new javax.swing.JButton();
        cboDiags = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        lblAltura = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPascal.setBackground(new java.awt.Color(0, 0, 0));
        btnPascal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPascal.setForeground(new java.awt.Color(255, 255, 255));
        btnPascal.setText("Pascal");
        btnPascal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPascalActionPerformed(evt);
            }
        });
        getContentPane().add(btnPascal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, -1));

        btnInfo.setBackground(new java.awt.Color(0, 0, 0));
        btnInfo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnInfo.setText("Info");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 100, 40));

        btnDiagonales.setBackground(new java.awt.Color(0, 0, 0));
        btnDiagonales.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDiagonales.setForeground(new java.awt.Color(255, 255, 255));
        btnDiagonales.setText("Diagonales");
        btnDiagonales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagonalesActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiagonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btnSumasHorizontales.setBackground(new java.awt.Color(0, 0, 0));
        btnSumasHorizontales.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSumasHorizontales.setForeground(new java.awt.Color(255, 255, 255));
        btnSumasHorizontales.setText("Suma Horizontal");
        btnSumasHorizontales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumasHorizontalesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSumasHorizontales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        btnSierpinski.setBackground(new java.awt.Color(0, 0, 0));
        btnSierpinski.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSierpinski.setForeground(new java.awt.Color(255, 255, 255));
        btnSierpinski.setText("Pares e Impares");
        btnSierpinski.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSierpinskiActionPerformed(evt);
            }
        });
        getContentPane().add(btnSierpinski, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btnSimetría.setBackground(new java.awt.Color(0, 0, 0));
        btnSimetría.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSimetría.setForeground(new java.awt.Color(255, 255, 255));
        btnSimetría.setText("Simetría");
        btnSimetría.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimetríaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimetría, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        btnFibonacci.setBackground(new java.awt.Color(0, 0, 0));
        btnFibonacci.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnFibonacci.setForeground(new java.awt.Color(255, 255, 255));
        btnFibonacci.setText("Fibonacci");
        btnFibonacci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFibonacciActionPerformed(evt);
            }
        });
        getContentPane().add(btnFibonacci, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        btnGalton.setBackground(new java.awt.Color(0, 0, 0));
        btnGalton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnGalton.setForeground(new java.awt.Color(255, 255, 255));
        btnGalton.setText("Aparato de Galton");
        btnGalton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaltonActionPerformed(evt);
            }
        });
        getContentPane().add(btnGalton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        cboDiags.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboDiags.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(cboDiags, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 50, 40));

        cboSize.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(cboSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 50, 30));

        lblAltura.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblAltura.setText("ALTURA");
        getContentPane().add(lblAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblText.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblText.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 570, 420));

        btnIniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 260, 80));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1019, 675));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        JOptionPane.showMessageDialog(null, "En esta ventana se muestran los botones necesarios para el funcionamiento del programa:\n"
                + "Pascal\n"
                + "Diagonales\n"
                + "Pares e impares\n"
                + "Suma horizontal\n"
                + "Simetría\n"
                + "Sucesión de Fibonacci\n"
                + "Aparato de Galton\n"
                + "Al seleccionar un botón se muestra una pequeña descripción de la funcionalidad y se habilita el botón de inicio"
        );
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaltonActionPerformed
        // TODO add your handling code here:
        lblText.setText("<html>A continuación se muestra el Aparato de Galton: <br>	"
                + "Esta asombrosa máquina (aparato de Galton1o quincunce), fue creada por Sir Francis Galton y\n"
                + "es un triángulo de Pascal hecho con palos. Con el aparato de Galton se pueden crear experiencias\n"
                + "aleatorias. Sobre un tablero inclinado se encuentran distribuidos regularmente un sistema de\n"
                + "clavos que permiten deslizar un gran número de bolas que proceden de un depósito superior.\n"
                + "Las bolas, al chocar con los clavos, se alejan más o menos de la línea central de la caída,\n"
                + "según la ley del azar.</html>");
        btnIniciar.setVisible(true); opc = 7;
    }//GEN-LAST:event_btnGaltonActionPerformed

    private void btnPascalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPascalActionPerformed
        lblText.setText("<html>A continuación se muestra el triángulo de Pascal:<br>"
                + "Este es un triángulo de números enteros, infinito y simétrico.<br>"
                + "Se empieza con un 1 en la primera fila, y en las filas siguientes se van colocando "
                + "números de forma que cada uno de ellos sea la suma de los dos números que tiene encima.");
        btnIniciar.setVisible(true); opc = 1;
    }//GEN-LAST:event_btnPascalActionPerformed

    private void btnDiagonalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagonalesActionPerformed
        lblText.setText("<html>A continuación se muestra las diagonales:<br>	"
                + "     *La primera diagonal muestra solo unos(1).<br>"
                + "	*La segunda diagonal muestra todos los números consecutivos(1,2,3...).<br>"
                + "	*La tercera diagonal muestra los números triangulares.<br>"
                + "	*La cuarta diagonal muestra los números tetraédricos.</html>");
        btnIniciar.setVisible(true); opc = 2;
    }//GEN-LAST:event_btnDiagonalesActionPerformed

    private void btnSierpinskiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSierpinskiActionPerformed
        // TODO add your handling code here:
        lblText.setText("<html>A continuación se muestra los pares e impares<br>	"
                + "Se muestran los números impares y los pares en diferente color de modo\n"
                + "que se obtiene un patrón igual al del Triángulo de Sierpienski. <br>Este triángulo en específico\n"
                + "se construye dividiendo el mismo triángulo a la mitad, y diferencia cada una de las tres\n"
                + "esquinas; esto se debe de repetir con todos los triángulos más pequeños.</html>");
        btnIniciar.setVisible(true); opc = 3;
    }//GEN-LAST:event_btnSierpinskiActionPerformed

    private void btnSumasHorizontalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumasHorizontalesActionPerformed
        // TODO add your handling code here:
        lblText.setText("<html>A continuación se muestra la suma horizontal: <br>	"
                + "Se obtienen las potencias de 2</html>");
        btnIniciar.setVisible(true); opc = 4;
    }//GEN-LAST:event_btnSumasHorizontalesActionPerformed

    private void btnSimetríaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimetríaActionPerformed
        // TODO add your handling code here:
        lblText.setText("<html>A continuación se muestra la simetría: <br>	"
                + "El triángulo es simétrico, esto quiere decir que se ve igual desde la derecha que desde "
                + "la izquierda, es decir, una mitad es la imagen en un espejo de la otra mitad.</html>");
        btnIniciar.setVisible(true); opc = 5;
    }//GEN-LAST:event_btnSimetríaActionPerformed

    private void btnFibonacciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFibonacciActionPerformed
        // TODO add your handling code here:
        lblText.setText("<html>A continuación se muestra la sucesión de Fibonacci: <br>	"
                + "La sucesión de Fibonacci se obtiene aplicando la fórmula:<br>"
                + "fn = fn - 1 + fn - 2<br>"
                + "Partiendo de dos primeros valores predeterminados:<br>"
                + "f0 = 1<br>"
                + "f1 = 1.</html>");
        btnIniciar.setVisible(true); opc = 6;
    }//GEN-LAST:event_btnFibonacciActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        if (opc == 1) {
            trianguloPascal tp = new trianguloPascal(opc, Integer.parseInt(cboSize.getSelectedItem().toString()));
        } else if (opc == 2) {
            int altura = Integer.parseInt(cboSize.getSelectedItem().toString());
            int diagonal = Integer.parseInt(cboDiags.getSelectedItem().toString());
            if (altura < diagonal) {
                JOptionPane.showMessageDialog(null, new miExcepcion(1).getMessage());
            } else {
                trianguloPascal tp = new trianguloPascal(2, altura, diagonal); // 2 == Diagonales
            }
        } else if (opc == 3){
            trianguloPascal tp = new trianguloPascal(3, Integer.parseInt(cboSize.getSelectedItem().toString())); // 3 == Sierpinski
        } else if (opc == 4){
            trianguloPascal tp = new trianguloPascal(4, Integer.parseInt(cboSize.getSelectedItem().toString())); // 4 == Sumas
        } else if (opc == 5){
             trianguloPascal tp = new trianguloPascal(5, Integer.parseInt(cboSize.getSelectedItem().toString())); // 5 == Simetría
        } else if (opc == 6){
            trianguloPascal tp = new trianguloPascal(6, Integer.parseInt(cboSize.getSelectedItem().toString())); // 6 == Fibonacci
        } else if (opc == 7){
            galton gtn = new galton(Integer.parseInt(cboSize.getSelectedItem().toString()));
        }
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiagonales;
    private javax.swing.JButton btnFibonacci;
    private javax.swing.JButton btnGalton;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPascal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSierpinski;
    private javax.swing.JButton btnSimetría;
    private javax.swing.JButton btnSumasHorizontales;
    private javax.swing.JComboBox<String> cboDiags;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
