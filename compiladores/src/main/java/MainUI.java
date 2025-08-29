/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/** `
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainUI extends javax.swing.JFrame {

    private File currentFile;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        configurarAtalhos();
    }

    private void configurarAtalhos() {

        Action btNovoAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta_editor.setText("");
                ta_log.setText("");
                ta_status.setText("");
            }
        };
        bt_novo.setAction(btNovoAction);
        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png")));
        bt_novo.setText("Novo [Ctrl + N]");
        bt_novo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "novo");
        bt_novo.getActionMap().put("novo", btNovoAction);

        Action btAbrirAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_abrirActionPerformed(e);
            }
        };
        bt_abrir.setAction(btAbrirAction);
        bt_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrir.png")));
        bt_abrir.setText("Abrir [Ctrl + O]");
        bt_abrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), "abrir");
        bt_abrir.getActionMap().put("abrir", btAbrirAction);

        Action btSalvarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_salvarActionPerformed(e);
            }
        };
        bt_salvar.setAction(btSalvarAction);
        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png")));
        bt_salvar.setText("Salvar [Ctrl + S]");
        bt_salvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "salvar");
        bt_salvar.getActionMap().put("salvar", btSalvarAction);

        Action btCopiarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = ta_editor.getSelectedText();
                if (selectedText != null && !selectedText.isEmpty()) {
                    StringSelection stringSelection = new StringSelection(selectedText);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(null, "Texto copiado para a área de transferência.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione o texto para copiar.");
                }
            }
        };
        bt_copiar.setAction(btCopiarAction);
        bt_copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copiar.png")));
        bt_copiar.setText("Copiar [Ctrl + C]");
        bt_copiar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "copiar");
        bt_copiar.getActionMap().put("copiar", btCopiarAction);

        Action btColarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_colarActionPerformed(e);
            }
        };
        bt_colar.setAction(btColarAction);
        bt_colar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colar.png")));
        bt_colar.setText("Colar [Ctrl + V]");
        bt_colar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK), "colar");
        bt_colar.getActionMap().put("colar", btColarAction);

        Action btRecortarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_recortarActionPerformed(e);
            }
        };
        bt_recortar.setAction(btRecortarAction);
        bt_recortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recortar.png")));
        bt_recortar.setText("Recortar [Ctrl + X]");
        bt_recortar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "recortar");
        bt_recortar.getActionMap().put("recortar", btRecortarAction);

        Action btCompilarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_compilarActionPerformed(e);
            }
        };
        bt_compilar.setAction(btCompilarAction);
        bt_compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilar.png")));
        bt_compilar.setText("Compilar [F7]");
        bt_compilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "compilar");
        bt_compilar.getActionMap().put("compilar", btCompilarAction);

        Action btEquipeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_equipeActionPerformed(e);
            }
        };
        bt_equipe.setAction(btEquipeAction);
        bt_equipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equipe.png")));
        bt_equipe.setText("Equipe [F1]");
        bt_equipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "equipe");
        bt_equipe.getActionMap().put("equipe", btEquipeAction);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JPanel();
        bt_abrir = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        bt_colar = new javax.swing.JButton();
        bt_equipe = new javax.swing.JButton();
        bt_copiar = new javax.swing.JButton();
        bt_compilar = new javax.swing.JButton();
        bt_recortar = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_editor = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_log = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_status = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 800));
        setResizable(false);

        toolbar.setBackground(new java.awt.Color(0, 255, 255));

        bt_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrir.png"))); // NOI18N
        bt_abrir.setText("abrir [ctrl + o]");
        bt_abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_abrirActionPerformed(evt);
            }
        });

        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
        bt_novo.setText("novo [ctrl + n]");
        bt_novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_novo.setIconTextGap(0);
        bt_novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        bt_salvar.setText("salvar [ctrl + s]");
        bt_salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_colar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colar.png"))); // NOI18N
        bt_colar.setText("colar [ctrl + v]");
        bt_colar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_colar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_colar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_colarActionPerformed(evt);
            }
        });

        bt_equipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equipe.png"))); // NOI18N
        bt_equipe.setText("equipe [F1]");
        bt_equipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_equipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_equipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_equipeActionPerformed(evt);
            }
        });
        bt_equipe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_equipeKeyPressed(evt);
            }
        });

        bt_copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copiar.png"))); // NOI18N
        bt_copiar.setText("copiar [ctrl + c]");
        bt_copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_copiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_copiarActionPerformed(evt);
            }
        });

        bt_compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilar.png"))); // NOI18N
        bt_compilar.setText("compilar [F7]");
        bt_compilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_compilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_compilarActionPerformed(evt);
            }
        });

        bt_recortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recortar.png"))); // NOI18N
        bt_recortar.setText("recortar [ctrl + x]");
        bt_recortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_recortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_recortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_recortarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolbarLayout = new javax.swing.GroupLayout(toolbar);
        toolbar.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_copiar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_colar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_recortar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        toolbarLayout.setVerticalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_recortar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_colar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_copiar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(toolbarLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jSplitPane1.setDividerLocation(460);
        jSplitPane1.setDividerSize(15);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ta_editor.setBackground(new java.awt.Color(255, 255, 0));
        ta_editor.setColumns(20);
        ta_editor.setRows(5);
        jScrollPane2.setViewportView(ta_editor);

        jSplitPane1.setTopComponent(jScrollPane2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ta_log.setEditable(false);
        ta_log.setBackground(new java.awt.Color(255, 0, 255));
        ta_log.setColumns(20);
        ta_log.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        ta_log.setRows(5);
        ta_log.setFocusable(false);
        jScrollPane1.setViewportView(ta_log);

        jSplitPane1.setBottomComponent(jScrollPane1);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ta_status.setBackground(new java.awt.Color(51, 51, 255));
        ta_status.setColumns(20);
        ta_status.setRows(5);
        jScrollPane3.setViewportView(ta_status);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_abrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                ta_editor.setText(content.toString());
                ta_status.setText(currentFile.getAbsolutePath());
                ta_log.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + e.getMessage());
                currentFile = null;
            }
        }
    }//GEN-LAST:event_bt_abrirActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        if (!ta_editor.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Você tem alterações não salvas. Deseja salvar antes de criar um novo arquivo?",
                    "Salvar alterações?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                salvarArquivo();
            } else if (option == JOptionPane.NO_OPTION) {
                ta_editor.setText("");
                ta_log.setText("");
                ta_status.setText("");
                currentFile = null;
            }
        } else {
            ta_editor.setText("");
            ta_log.setText("");
            ta_status.setText("");
            currentFile = null;
        }
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvarArquivo();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_colarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_colarActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            String pastedText = (String) clipboard.getData(DataFlavor.stringFlavor);

            ta_editor.insert(pastedText, ta_editor.getCaretPosition());

        } catch (UnsupportedFlavorException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao colar o conteúdo: " + e.getMessage());
        }
    }//GEN-LAST:event_bt_colarActionPerformed

    private void bt_equipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_equipeActionPerformed
        ta_log.setText("Arthur Lopes Muxfeldt, Eduardo Essig, João Pedro Sehnem");
    }//GEN-LAST:event_bt_equipeActionPerformed

    private void bt_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_copiarActionPerformed
        String selectedText = ta_editor.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            StringSelection stringSelection = new StringSelection(selectedText);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);

            JOptionPane.showMessageDialog(null, "Texto copiado para a área de transferência.");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o texto para copiar.");
        }
    }//GEN-LAST:event_bt_copiarActionPerformed

    private void bt_compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_compilarActionPerformed
        ta_log.setText("Compilação de programas ainda não foi implementada");
    }//GEN-LAST:event_bt_compilarActionPerformed

    private void bt_recortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_recortarActionPerformed
        String selectedText = ta_editor.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            StringSelection stringSelection = new StringSelection(selectedText);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);

            ta_editor.replaceSelection("");

            JOptionPane.showMessageDialog(null, "Texto recortado e copiado para a área de transferência.");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o texto para recortar.");
        }
    }//GEN-LAST:event_bt_recortarActionPerformed

    private void bt_equipeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_equipeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            bt_equipeActionPerformed(null);
        }
    }//GEN-LAST:event_bt_equipeKeyPressed
    private void salvarArquivo() {
        if (currentFile == null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (!selectedFile.getName().toLowerCase().endsWith(".txt")) {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    writer.write(ta_editor.getText());
                    ta_log.setText("");
                    ta_status.setText(selectedFile.getAbsolutePath());
                    JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
                    currentFile = selectedFile;
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
                }
            }
        } else {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                writer.write(ta_editor.getText());
                ta_log.setText("");
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
            }
        }
    }

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_abrir;
    private javax.swing.JButton bt_colar;
    private javax.swing.JButton bt_compilar;
    private javax.swing.JButton bt_copiar;
    private javax.swing.JButton bt_equipe;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_recortar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea ta_editor;
    private javax.swing.JTextArea ta_log;
    private javax.swing.JTextArea ta_status;
    private javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
}
