/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.controlcyberv1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;



/**
 *
 * @author SITRAYAS
 */
public class jframe extends javax.swing.JFrame {

      private Timer timer;
    private int segundos1 = 0, segundos2 = 0, segundos3 = 0, segundos4 = 0, segundos5 = 0, segundos6 = 0;
    private Date horaInicio1, horaInicio2, horaInicio3, horaInicio4, horaInicio5, horaInicio6;
    private Date horaFin1, horaFin2, horaFin3, horaFin4, horaFin5, horaFin6;
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    // Campos para mostrar tiempo transcurrido y costo
    private JLabel[] labelsTiempo = new JLabel[6];
    private JTextField[] camposCobrar = new JTextField[6];

  
   
    
    public jframe() {
      
        initComponents();
        setLocationRelativeTo(null);
        inicializarComponentesTiempo();
        iniciarTimer();
    }

    
    
    private void inicializarComponentesTiempo() {
        // Asignar los labels y campos de texto para tiempo transcurrido y costo
        labelsTiempo[0] = txt_transcurrido1;
        labelsTiempo[1] = txt_transcurrido2;
        labelsTiempo[2] = txt_transcurridoE;
        labelsTiempo[3] = txt_transcurridoA;
        labelsTiempo[4] = txt_transcurridoS;
        labelsTiempo[5] = txt_transcurridoG;

        camposCobrar[0] = txt_cobrar1;
        camposCobrar[1] = txt_cobrar2;
        camposCobrar[2] = txt_cobrarE;
        camposCobrar[3] = txt_cobrarA;
        camposCobrar[4] = txt_cobrarS;
        camposCobrar[5] = txt_cobrarG;
    }

    private void iniciarTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btn1.isSelected()) segundos1++;
                if (btn2.isSelected()) segundos2++;
                if (btnE.isSelected()) segundos3++;
                if (btnA.isSelected()) segundos4++;
                if (btnS.isSelected()) segundos5++;
                if (btnG.isSelected()) segundos6++;

                actualizarTiempoTranscurrido();
            }
        });

        timer.start();
    }

    private void actualizarTiempoTranscurrido() {
        actualizarTiempo(labelsTiempo[0], camposCobrar[0], horaInicio1, segundos1);
        actualizarTiempo(labelsTiempo[1], camposCobrar[1], horaInicio2, segundos2);
        actualizarTiempo(labelsTiempo[2], camposCobrar[2], horaInicio3, segundos3);
        actualizarTiempo(labelsTiempo[3], camposCobrar[3], horaInicio4, segundos4);
        actualizarTiempo(labelsTiempo[4], camposCobrar[4], horaInicio5, segundos5);
        actualizarTiempo(labelsTiempo[5], camposCobrar[5], horaInicio6, segundos6);
    }

    private void actualizarTiempo(JLabel label, JTextField cobrarField, Date horaInicio, int segundos) {
        if (horaInicio != null) {
            Date horaActual = new Date();
            long tiempoTranscurridoMillis = horaActual.getTime() - horaInicio.getTime();
            long tiempoTranscurridoSegundos = tiempoTranscurridoMillis / 1000;
            long horasTranscurridas = tiempoTranscurridoSegundos / 3600;
            long minutosTranscurridos = (tiempoTranscurridoSegundos % 3600) / 60;
            long segundosTranscurridos = tiempoTranscurridoSegundos % 60;

            String tiempoTranscurrido = String.format("%02d:%02d:%02d", horasTranscurridas, minutosTranscurridos, segundosTranscurridos);
            label.setText(tiempoTranscurrido);

            // Obtener las tarifas guardadas desde JFrame_IngresarTarifa
            double[] tarifas = JFrame_IngresarTarifa.obtenerTarifasGuardadas();

            // Calcular el costo basado en las tarifas
            double costo = horasTranscurridas * tarifas[3]; // Costo por hora (asumo que se usa la tarifa de 45-60 min por defecto)
            if (minutosTranscurridos > 0 && minutosTranscurridos <= 15) {
                costo += tarifas[0];
            } else if (minutosTranscurridos > 15 && minutosTranscurridos <= 30) {
                costo += tarifas[1];
            } else if (minutosTranscurridos > 30 && minutosTranscurridos <= 45) {
                costo += tarifas[2];
            } else if (minutosTranscurridos > 45 && minutosTranscurridos <= 60) {
                costo += tarifas[3];
            }
            cobrarField.setText(String.format("$%.2f", costo));
        }
    }
private double calcularCostoPorIntervalo(long minutosTranscurridos, double[] tarifas) {
        double costo = 0.0;

        if (minutosTranscurridos > 0 && minutosTranscurridos <= 15) {
            costo += tarifas[0];
        } else if (minutosTranscurridos > 15 && minutosTranscurridos <= 30) {
            costo += tarifas[1];
        } else if (minutosTranscurridos > 30 && minutosTranscurridos <= 45) {
            costo += tarifas[2];
        } else if (minutosTranscurridos > 45 && minutosTranscurridos <= 60) {
            costo += tarifas[3];
        }

        return costo;
    
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_estado1 = new javax.swing.JLabel();
        txt_cobrar1 = new javax.swing.JTextField();
        txt_ini1 = new javax.swing.JLabel();
        txt_fin1 = new javax.swing.JLabel();
        txt_transcurrido1 = new javax.swing.JLabel();
        btn1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        txt_estado2 = new javax.swing.JLabel();
        txt_cobrar2 = new javax.swing.JTextField();
        txt_ini2 = new javax.swing.JLabel();
        txt_fin2 = new javax.swing.JLabel();
        txt_transcurrido2 = new javax.swing.JLabel();
        btn2 = new javax.swing.JToggleButton();
        jPanel11 = new javax.swing.JPanel();
        txt_estadoE = new javax.swing.JLabel();
        txt_cobrarE = new javax.swing.JTextField();
        txt_iniE = new javax.swing.JLabel();
        txt_finE = new javax.swing.JLabel();
        txt_transcurridoE = new javax.swing.JLabel();
        btnE = new javax.swing.JToggleButton();
        jPanel9 = new javax.swing.JPanel();
        txt_estadoA = new javax.swing.JLabel();
        txt_cobrarA = new javax.swing.JTextField();
        txt_iniA = new javax.swing.JLabel();
        txt_finA = new javax.swing.JLabel();
        txt_transcurridoA = new javax.swing.JLabel();
        btnA = new javax.swing.JToggleButton();
        jPanel8 = new javax.swing.JPanel();
        txt_estadoS = new javax.swing.JLabel();
        txt_cobrarS = new javax.swing.JTextField();
        txt_iniS = new javax.swing.JLabel();
        txt_finS = new javax.swing.JLabel();
        txt_transcurridoS = new javax.swing.JLabel();
        btnS = new javax.swing.JToggleButton();
        jPanel10 = new javax.swing.JPanel();
        txt_estadoG = new javax.swing.JLabel();
        txt_cobrarG = new javax.swing.JTextField();
        txt_iniG = new javax.swing.JLabel();
        txt_finG = new javax.swing.JLabel();
        txt_transcurridoG = new javax.swing.JLabel();
        btnG = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_IngresarTarifa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EQUIPO");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ESTADO");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HORA INICIO");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HORA FIN ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TRANSCURRIDO");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TOTAL ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        txt_estado1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estado1.setText("---");

        txt_cobrar1.setEditable(false);
        txt_cobrar1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_cobrar1.setForeground(new java.awt.Color(255, 0, 51));
        txt_cobrar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cobrar1.setBorder(null);

        txt_ini1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ini1.setText("------");

        txt_fin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_fin1.setText("------");

        txt_transcurrido1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_transcurrido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurrido1.setText("------");

        btn1.setText("PC1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ini1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_fin1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurrido1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cobrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_cobrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_estado1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ini1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_fin1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_transcurrido1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        txt_estado2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estado2.setText("---");

        txt_cobrar2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_ini2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ini2.setText("------");

        txt_fin2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_fin2.setText("------");

        txt_transcurrido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurrido2.setText("------");

        btn2.setText("PC2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ini2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_fin2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurrido2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cobrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estado2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ini2)
                    .addComponent(txt_fin2)
                    .addComponent(txt_transcurrido2)
                    .addComponent(txt_cobrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        txt_estadoE.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estadoE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estadoE.setText("---");

        txt_cobrarE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_iniE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_iniE.setText("------");

        txt_finE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_finE.setText("------");

        txt_transcurridoE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurridoE.setText("------");

        btnE.setText("PC3");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_iniE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_finE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurridoE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cobrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_iniE)
                    .addComponent(txt_finE)
                    .addComponent(txt_transcurridoE)
                    .addComponent(txt_cobrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        txt_estadoA.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estadoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estadoA.setText("---");

        txt_cobrarA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_iniA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_iniA.setText("------");

        txt_finA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_finA.setText("------");

        txt_transcurridoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurridoA.setText("------");

        btnA.setText("PC4");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_iniA, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_finA, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurridoA, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cobrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_iniA)
                    .addComponent(txt_finA)
                    .addComponent(txt_transcurridoA)
                    .addComponent(txt_cobrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        txt_estadoS.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estadoS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estadoS.setText("---");

        txt_cobrarS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cobrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cobrarSActionPerformed(evt);
            }
        });

        txt_iniS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_iniS.setText("------");

        txt_finS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_finS.setText("------");

        txt_transcurridoS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurridoS.setText("------");

        btnS.setText("PC5");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estadoS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_iniS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_finS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurridoS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cobrarS, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estadoS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_iniS)
                    .addComponent(txt_finS)
                    .addComponent(txt_transcurridoS)
                    .addComponent(txt_cobrarS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        txt_estadoG.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        txt_estadoG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_estadoG.setText("---");

        txt_cobrarG.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_iniG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_iniG.setText("------");

        txt_finG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_finG.setText("------");

        txt_transcurridoG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_transcurridoG.setText("------");

        btnG.setText("PC6");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_estadoG, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_iniG, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_finG, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_transcurridoG, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cobrarG, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_estadoG, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_iniG)
                    .addComponent(txt_finG)
                    .addComponent(txt_transcurridoG)
                    .addComponent(txt_cobrarG, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        jMenu1.setText("Equipos");

        jMenuItem1.setText("Agregar Equipo");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(" Tarifa");

        jMenuItem_IngresarTarifa.setText("Ingresar Tarifa");
        jMenuItem_IngresarTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_IngresarTarifaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_IngresarTarifa);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_IngresarTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_IngresarTarifaActionPerformed

        JFrame_IngresarTarifa it = new JFrame_IngresarTarifa();
        it.show();

    }//GEN-LAST:event_jMenuItem_IngresarTarifaActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

        if (btn1.isSelected()) {
            btn1.setText("pc 1 ");
            txt_estado1.setText("ACTIVADO");
            horaInicio1 = new Date();
            txt_ini1.setText(formatoHora.format(horaInicio1));
            txt_estado1.setForeground(Color.GREEN);
            // Reiniciar el contador txt_fin1
            txt_fin1.setText("------");
        } else {
            if (horaInicio1 != null) {
                btn1.setText("PC 1");
                txt_estado1.setText("DESACTIVADO");
                horaFin1 = new Date();
                txt_fin1.setText(formatoHora.format(horaFin1));
                txt_estado1.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurrido1, txt_cobrar1, horaInicio1, segundos1);
                horaInicio1 = null;
            }
        }

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed

        if (btn2.isSelected()) {
            btn2.setText("pc 2");
            txt_estado2.setText("ACTIVADO");
            horaInicio2 = new Date();
            txt_ini2.setText(formatoHora.format(horaInicio2));
            txt_estado2.setForeground(Color.GREEN);
            // Reiniciar el contador txt_fin1
            txt_fin2.setText("------");
        } else {
            if (horaInicio2 != null) {
                btn2.setText("PC2");
                txt_estado2.setText("DESACTIVADO");
                horaFin2 = new Date();
                txt_fin2.setText(formatoHora.format(horaFin2));
                txt_estado2.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurrido2, txt_cobrar2, horaInicio2, segundos2);
                horaInicio2 = null;
            }
        }

    }//GEN-LAST:event_btn2ActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        if (btnE.isSelected()) {
            btnE.setText("PC 3");
            txt_estadoE.setText("ACTIVADO");
            horaInicio3 = new Date();
            txt_iniE.setText(formatoHora.format(horaInicio3));
            txt_estadoE.setForeground(Color.GREEN);
            txt_finE.setText("------");
        } else {
            if (horaInicio3 != null) {
                btnE.setText("PC3");
                txt_estadoE.setText("DESACTIVADO");
                horaFin3 = new Date();
                txt_finE.setText(formatoHora.format(horaFin3));
                txt_estadoE.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurridoE, txt_cobrarE, horaInicio3, segundos3);
                horaInicio3 = null;
            }
        }
    }//GEN-LAST:event_btnEActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        if (btnA.isSelected()) {
            btnA.setText("PC 4");
            txt_estadoA.setText("ACTIVADO");
            horaInicio4 = new Date();
            txt_iniA.setText(formatoHora.format(horaInicio4));
            txt_estadoA.setForeground(Color.GREEN);
            txt_finA.setText("------");
        } else {
            if (horaInicio4 != null) {
                btnA.setText("PC4");
                txt_estadoA.setText("DESACTIVADO");
                horaFin4 = new Date();
                txt_finA.setText(formatoHora.format(horaFin4));
                txt_estadoA.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurridoA, txt_cobrarA, horaInicio4, segundos4);
                horaInicio4 = null;
            }
        }
    }//GEN-LAST:event_btnAActionPerformed

    private void txt_cobrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cobrarSActionPerformed

    }//GEN-LAST:event_txt_cobrarSActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        if (btnS.isSelected()) {
            btnS.setText("PC 5");
            txt_estadoS.setText("ACTIVADO");
            horaInicio5 = new Date();
            txt_iniS.setText(formatoHora.format(horaInicio5));
            txt_estadoS.setForeground(Color.GREEN);
            txt_finS.setText("------");
        } else {
            if (horaInicio5 != null) {
                btnS.setText("PC5");
                txt_estadoS.setText("DESACTIVADO");
                horaFin5 = new Date();
                txt_finS.setText(formatoHora.format(horaFin5));
                txt_estadoS.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurridoS, txt_cobrarS, horaInicio5, segundos5);
                horaInicio5 = null;
            }
        }
    }//GEN-LAST:event_btnSActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        if (btnG.isSelected()) {
            btnG.setText("PC 6");
            txt_estadoG.setText("ACTIVADO");
            horaInicio6 = new Date();
            txt_iniG.setText(formatoHora.format(horaInicio6));
            txt_estadoG.setForeground(Color.GREEN);
            txt_finG.setText("------");
        } else {
            if (horaInicio6 != null) {
                btnG.setText("PC6");
                txt_estadoG.setText("DESACTIVADO");
                horaFin6 = new Date();
                txt_finG.setText(formatoHora.format(horaFin6));
                txt_estadoG.setForeground(Color.BLACK);
                actualizarTiempo(txt_transcurridoG, txt_cobrarG, horaInicio6, segundos6);
                horaInicio6 = null;
            }
        }
    }//GEN-LAST:event_btnGActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn1;
    private javax.swing.JToggleButton btn2;
    private javax.swing.JToggleButton btnA;
    private javax.swing.JToggleButton btnE;
    private javax.swing.JToggleButton btnG;
    private javax.swing.JToggleButton btnS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_IngresarTarifa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txt_cobrar1;
    private javax.swing.JTextField txt_cobrar2;
    private javax.swing.JTextField txt_cobrarA;
    private javax.swing.JTextField txt_cobrarE;
    private javax.swing.JTextField txt_cobrarG;
    private javax.swing.JTextField txt_cobrarS;
    private javax.swing.JLabel txt_estado1;
    private javax.swing.JLabel txt_estado2;
    private javax.swing.JLabel txt_estadoA;
    private javax.swing.JLabel txt_estadoE;
    private javax.swing.JLabel txt_estadoG;
    private javax.swing.JLabel txt_estadoS;
    private javax.swing.JLabel txt_fin1;
    private javax.swing.JLabel txt_fin2;
    private javax.swing.JLabel txt_finA;
    private javax.swing.JLabel txt_finE;
    private javax.swing.JLabel txt_finG;
    private javax.swing.JLabel txt_finS;
    private javax.swing.JLabel txt_ini1;
    private javax.swing.JLabel txt_ini2;
    private javax.swing.JLabel txt_iniA;
    private javax.swing.JLabel txt_iniE;
    private javax.swing.JLabel txt_iniG;
    private javax.swing.JLabel txt_iniS;
    private javax.swing.JLabel txt_transcurrido1;
    private javax.swing.JLabel txt_transcurrido2;
    private javax.swing.JLabel txt_transcurridoA;
    private javax.swing.JLabel txt_transcurridoE;
    private javax.swing.JLabel txt_transcurridoG;
    private javax.swing.JLabel txt_transcurridoS;
    // End of variables declaration//GEN-END:variables
}
