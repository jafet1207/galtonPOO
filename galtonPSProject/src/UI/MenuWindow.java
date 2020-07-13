/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JOptionPane;
import processing.core.PApplet;

/**
 *
 * @author 
 */
public class MenuWindow extends javax.swing.JFrame {

    /**
     * Creates new form MenuWindow
     */
    public MenuWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jPanelPantalla = new javax.swing.JPanel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPascal.setBackground(new java.awt.Color(0, 0, 0));
        btnPascal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPascal.setForeground(new java.awt.Color(255, 255, 255));
        btnPascal.setText("Pascal");
        getContentPane().add(btnPascal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

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
        getContentPane().add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 100, 40));

        btnDiagonales.setBackground(new java.awt.Color(0, 0, 0));
        btnDiagonales.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDiagonales.setForeground(new java.awt.Color(255, 255, 255));
        btnDiagonales.setText("Diagonales");
        getContentPane().add(btnDiagonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btnSumasHorizontales.setBackground(new java.awt.Color(0, 0, 0));
        btnSumasHorizontales.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSumasHorizontales.setForeground(new java.awt.Color(255, 255, 255));
        btnSumasHorizontales.setText("Suma Horizontal");
        getContentPane().add(btnSumasHorizontales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btnSierpinski.setBackground(new java.awt.Color(0, 0, 0));
        btnSierpinski.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSierpinski.setForeground(new java.awt.Color(255, 255, 255));
        btnSierpinski.setText("Pares e Impares");
        getContentPane().add(btnSierpinski, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btnSimetría.setBackground(new java.awt.Color(0, 0, 0));
        btnSimetría.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSimetría.setForeground(new java.awt.Color(255, 255, 255));
        btnSimetría.setText("Simetría");
        getContentPane().add(btnSimetría, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        btnFibonacci.setBackground(new java.awt.Color(0, 0, 0));
        btnFibonacci.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnFibonacci.setForeground(new java.awt.Color(255, 255, 255));
        btnFibonacci.setText("Fibonacci");
        getContentPane().add(btnFibonacci, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        btnGalton.setBackground(new java.awt.Color(0, 0, 0));
        btnGalton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnGalton.setForeground(new java.awt.Color(255, 255, 255));
        btnGalton.setText("Aparato de Galton");
        btnGalton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaltonActionPerformed(evt);
            }
        });
        getContentPane().add(btnGalton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jPanelPantalla.setBackground(new java.awt.Color(0, 0, 0));
        jPanelPantalla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelPantalla.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelPantallaLayout = new javax.swing.GroupLayout(jPanelPantalla);
        jPanelPantalla.setLayout(jPanelPantallaLayout);
        jPanelPantallaLayout.setHorizontalGroup(
            jPanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanelPantallaLayout.setVerticalGroup(
            jPanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 590, 560));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1019, 675));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        JOptionPane.showMessageDialog(null, "En esta ventana se muestran los botones necesarios para el funcionamiento del programa:\n"
                + "Diagonales\n"
                + "Pares e impares\n"
                + "Suma horizontal\n"
                + "Simetría\n"
                + "Sucesión de Fibonacci\n"
                + "Aparato de Galton\n");
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGaltonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaltonActionPerformed
        // TODO add your handling code here:
        PApplet.main(new String[]{classesPS.galton.class.getName()});
    }//GEN-LAST:event_btnGaltonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiagonales;
    private javax.swing.JButton btnFibonacci;
    private javax.swing.JButton btnGalton;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnPascal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSierpinski;
    private javax.swing.JButton btnSimetría;
    private javax.swing.JButton btnSumasHorizontales;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanelPantalla;
    // End of variables declaration//GEN-END:variables
}
