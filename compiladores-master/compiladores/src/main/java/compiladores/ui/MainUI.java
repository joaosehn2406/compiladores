package compiladores.ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 * `
 */
import compiladores.gals.Constants;
import static compiladores.gals.Constants.t_constanteFloat;
import static compiladores.gals.Constants.t_constanteInt;
import static compiladores.gals.Constants.t_constanteString;
import static compiladores.gals.Constants.t_identificador;
import compiladores.gals.Token;
import compiladores.gals.LexicalError;
import compiladores.gals.Lexico;
import compiladores.gals.ParserConstants;
import compiladores.gals.SemanticError;
import compiladores.gals.Semantico;
import compiladores.gals.Sintatico;
import compiladores.gals.SyntaticError;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png")));
        bt_novo.setText("Novo [Ctrl + N]");

        bt_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrir.png")));
        bt_abrir.setText("Abrir [Ctrl + O]");

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png")));
        bt_salvar.setText("Salvar [Ctrl + S]");

        bt_copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copiar.png")));
        bt_copiar.setText("Copiar [Ctrl + C]");

        bt_colar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/colar.png")));
        bt_colar.setText("Colar [Ctrl + V]");

        bt_recortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recortar.png")));
        bt_recortar.setText("Recortar [Ctrl + X]");

        bt_compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilar.png")));
        bt_compilar.setText("Compilar [F7]");

        bt_equipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equipe.png")));
        bt_equipe.setText("Equipe [F1]");

        JComponent root = getRootPane();

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "novo");
        root.getActionMap().put("novo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_novo.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), "abrir");
        root.getActionMap().put("abrir", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_abrir.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "salvar");
        root.getActionMap().put("salvar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_salvar.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "copiar");
        root.getActionMap().put("copiar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_copiar.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK), "colar");
        root.getActionMap().put("colar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_colar.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "recortar");
        root.getActionMap().put("recortar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_recortar.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "compilar");
        root.getActionMap().put("compilar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_compilar.doClick();
            }
        });

        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "equipe");
        root.getActionMap().put("equipe", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_equipe.doClick();
            }
        });
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

        toolbar.setBackground(new java.awt.Color(153, 153, 153));
        toolbar.setPreferredSize(new java.awt.Dimension(1500, 70));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toolbarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarLayout.createSequentialGroup()
                                .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bt_equipe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(bt_compilar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(bt_recortar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(bt_colar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(toolbarLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(bt_copiar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))))
                    .addGroup(toolbarLayout.createSequentialGroup()
                        .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_novo))
                        .addGap(18, 18, 18))))
        );

        jSplitPane1.setDividerLocation(460);
        jSplitPane1.setDividerSize(15);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ta_editor.setBackground(new java.awt.Color(242, 242, 242));
        ta_editor.setColumns(20);
        ta_editor.setRows(5);
        jScrollPane2.setViewportView(ta_editor);
        ta_editor.setBorder(new NumberedBorder ());

        jSplitPane1.setTopComponent(jScrollPane2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ta_log.setEditable(false);
        ta_log.setColumns(20);
        ta_log.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        ta_log.setRows(5);
        ta_log.setFocusable(false);
        jScrollPane1.setViewportView(ta_log);

        jSplitPane1.setBottomComponent(jScrollPane1);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ta_status.setBackground(new java.awt.Color(242, 242, 242));
        ta_status.setColumns(20);
        ta_status.setRows(5);
        ta_status.setPreferredSize(new java.awt.Dimension(272, 25));
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
        ta_log.setText("");

        String codigo = ta_editor.getText();

        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        Token token = null;
        lexico.setInput(codigo);

        try {
            sintatico.parse(lexico, semantico);
            ta_log.setText("programa compilado com sucesso");
        } catch (LexicalError e) {

            ta_log.setText("linha " + getLinhaCompilador(codigo, e.getPosition()) + ": " + e.getMessage());

        } catch (SyntaticError e) {
            String resultadoEncontrado;
            String resultadoEsperado = null;

            int posElementoErro = -1;
            String mensagemErroSintatico = e.getMessage();
            String mensagemErroSintaticoLC = mensagemErroSintatico.toLowerCase();
            int linhaErro = getLinhaCompilador(codigo, e.getPosition());
            lexico.setInput(codigo);
            while (true) {
                try {
                    token = lexico.nextToken();
                    if (!(token != null && token.getPosition() < e.getPosition())) {
                        break;
                    }
                } catch (LexicalError ex) {
                }
            }

            if (token == null || "$".equals(token.getLexeme())) {
                resultadoEncontrado = "EOF";
            } else if (token.getId() == Constants.t_constanteString) {
                resultadoEncontrado = "constante_string";
            } else {
                resultadoEncontrado = token.getLexeme();
            }

            for (int i = 0; i < ParserConstants.PARSER_ERROR.length; i++) {
                if (ParserConstants.PARSER_ERROR[i] != null && ParserConstants.PARSER_ERROR[i].equals(mensagemErroSintatico)) {
                    posElementoErro = i;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (posElementoErro >= ParserConstants.FIRST_NON_TERMINAL) {
                if (mensagemErroSintaticoLC.contains("<programa>")) {
                    resultadoEsperado = "esperado begin";
                } else if (mensagemErroSintaticoLC.contains("<lista_de_instrucoes>") || mensagemErroSintaticoLC.contains("<lista_de_instrucoes1>")) {
                    resultadoEsperado = "esperado identificador do list if print read tipo";
                } else if (mensagemErroSintaticoLC.contains("<tipo>") || mensagemErroSintaticoLC.contains("<tipos>")) {
                    resultadoEsperado = "esperado tipo";
                } else if (mensagemErroSintaticoLC.contains("<list_tipo>")) {
                    resultadoEsperado = "esperado list";
                } else if (mensagemErroSintaticoLC.contains("<lista_de_identificadores>")) {
                    resultadoEsperado = "esperado identificador";
                } else if (mensagemErroSintaticoLC.contains("atribuicao") || mensagemErroSintaticoLC.contains("manipulacao")) {
                    resultadoEsperado = "esperado = <- add delete";
                } else if (mensagemErroSintaticoLC.contains("<lista_de_entrada1>")) {
                    resultadoEsperado = "esperado , )";
                } else if (mensagemErroSintaticoLC.matches(".*<(expressao|expressao_|valor|relacional|relacional_|aritmetica|aritmetica_|termo|termo_|fator|fator_)>.*")) {
                    resultadoEsperado = "esperado expressão";
                } else {
                    int linha = posElementoErro - ParserConstants.FIRST_NON_TERMINAL;
                    if (linha >= 0 && linha < ParserConstants.PARSER_TABLE.length) {
                        for (int j = 1; j <= ParserConstants.PARSER_TABLE[linha].length; j++) {
                            if (ParserConstants.PARSER_TABLE[linha][j - 1] != -1) {
                                String name = nameHelper(j);
                                if (name == null || name.isEmpty()) {
                                    if (j < ParserConstants.PARSER_ERROR.length) {
                                        name = ParserConstants.PARSER_ERROR[j];
                                    } else {
                                        name = String.valueOf(j);
                                    }
                                }
                                if (sb.length() > 0) {
                                    sb.append(" ");
                                }
                                sb.append(name);
                            }
                        }
                    }
                    if (sb.length() > 0) {
                         resultadoEsperado = "esperado " + sb.toString();
                    }
                }
            } else if (posElementoErro > 0) {
                resultadoEsperado = mensagemErroSintatico.startsWith("esperado") ? mensagemErroSintatico : ("esperado " + mensagemErroSintatico);
            }

            if (resultadoEsperado == null || resultadoEsperado.trim().isEmpty()) {
                resultadoEsperado = "esperado";
            }

            ta_log.setText("linha " + linhaErro + ": encontrado " + resultadoEncontrado + " " + resultadoEsperado);
        } catch (SemanticError e) {
            // trata erros semânticos na parte 4
        }

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

    public String classHelper(int id) {
        switch (id) {
            case t_identificador:
                return "identificador";
            case t_constanteInt:
                return "contante_int";
            case t_constanteFloat:
                return "constante_float";
            case t_constanteString:
                return "constante_string";

            case Constants.t_pr_add:
            case Constants.t_pr_and:
            case Constants.t_pr_begin:
            case Constants.t_pr_bool:
            case Constants.t_pr_count:
            case Constants.t_pr_delete:
            case Constants.t_pr_do:
            case Constants.t_pr_elementOf:
            case Constants.t_pr_else:
            case Constants.t_pr_end:
            case Constants.t_pr_false:
            case Constants.t_pr_float:
            case Constants.t_pr_if:
            case Constants.t_pr_int:
            case Constants.t_pr_list:
            case Constants.t_pr_not:
            case Constants.t_pr_or:
            case Constants.t_pr_print:
            case Constants.t_pr_read:
            case Constants.t_pr_size:
            case Constants.t_pr_string:
            case Constants.t_pr_true:
            case Constants.t_pr_until:
                return "palavra reservada";

            case Constants.t_TOKEN_29:  // +
            case Constants.t_TOKEN_30:  // -
            case Constants.t_TOKEN_31:  // *
            case Constants.t_TOKEN_32:  // /
            case Constants.t_TOKEN_33:  // ==
            case Constants.t_TOKEN_34:  // ~=
            case Constants.t_TOKEN_35:  // <
            case Constants.t_TOKEN_36:  // >
            case Constants.t_TOKEN_37:  // =
            case Constants.t_TOKEN_38:  // <-
            case Constants.t_TOKEN_39:  // (
            case Constants.t_TOKEN_40:  // )
            case Constants.t_TOKEN_41:  // ;
            case Constants.t_TOKEN_42:  // ,
                return "símbolo especial";

        }

        return "símbolo não conhecido";
    }

    private String nameHelper(int constantsId) {
        switch (constantsId) {
            case Constants.DOLLAR:
                return "EOF";
            case Constants.t_identificador:
                return "identificador";
            case Constants.t_constanteInt:
                return "constante_int";
            case Constants.t_constanteFloat:
                return "constante_float";
            case Constants.t_constanteString:
                return "constante_string";

            case Constants.t_pr_add:
                return "add";
            case Constants.t_pr_and:
                return "and";
            case Constants.t_pr_begin:
                return "begin";
            case Constants.t_pr_bool:
                return "bool";
            case Constants.t_pr_count:
                return "count";
            case Constants.t_pr_delete:
                return "delete";
            case Constants.t_pr_do:
                return "do";
            case Constants.t_pr_elementOf:
                return "element_of";
            case Constants.t_pr_else:
                return "else";
            case Constants.t_pr_end:
                return "end";
            case Constants.t_pr_false:
                return "false";
            case Constants.t_pr_float:
                return "float";
            case Constants.t_pr_if:
                return "if";
            case Constants.t_pr_int:
                return "int";
            case Constants.t_pr_list:
                return "list";
            case Constants.t_pr_not:
                return "not";
            case Constants.t_pr_or:
                return "or";
            case Constants.t_pr_print:
                return "print";
            case Constants.t_pr_read:
                return "read";
            case Constants.t_pr_size:
                return "size";
            case Constants.t_pr_string:
                return "string";
            case Constants.t_pr_true:
                return "true";
            case Constants.t_pr_until:
                return "until";
            case Constants.t_TOKEN_29:
                return "+";
            case Constants.t_TOKEN_30:
                return "-";
            case Constants.t_TOKEN_31:
                return "*";
            case Constants.t_TOKEN_32:
                return "/";
            case Constants.t_TOKEN_33:
                return "==";
            case Constants.t_TOKEN_34:
                return "~=";
            case Constants.t_TOKEN_35:
                return "<";
            case Constants.t_TOKEN_36:
                return ">";
            case Constants.t_TOKEN_37:
                return "=";
            case Constants.t_TOKEN_38:
                return "<-";
            case Constants.t_TOKEN_39:
                return "(";
            case Constants.t_TOKEN_40:
                return ")";
            case Constants.t_TOKEN_41:
                return ";";
            case Constants.t_TOKEN_42:
                return ",";

            default:
                return null;
        }
    }

    private int getLinhaCompilador(String texto, int posicao) {
        int linha = 1;

        for (int i = 0; i < texto.length() && i < posicao; i++) {
            if (texto.charAt(i) == '\n') {
                linha++;
            }
        }
        return linha;
    }

    private String validarComentariosChaves(String texto) {
        ArrayDeque<Integer> pilha = new ArrayDeque<>();
        boolean dentroString = false;
        int linha = 1;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == '\n') {
                linha++;
                continue;
            }

            if (c == '"') {
                dentroString = !dentroString;
                continue;
            }
            if (dentroString) {
                continue;
            }

            if (c == '{') {
                pilha.push(linha);
                continue;
            }

            if (c == '}') {
                if (pilha.isEmpty()) {
                    return "linha " + linha + ": } comentário inválido ou não finalizado";
                }
                pilha.pop();
            }
        }

        if (!pilha.isEmpty()) {
            int linhaAbertura = pilha.peek();
            return "linha " + linhaAbertura + ": comentário inválido ou não finalizado";
        }

        return null; // OK
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MainUI().setVisible(true));
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

    private static class ta_editor extends JTextArea {

        public ta_editor() {

        }
    }
}
