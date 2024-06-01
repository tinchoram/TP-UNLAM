package gui.alumnogui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.event.*;
import javax.swing.table.*;

import dao.DAO;
import dao.DAOFactory;
import dao.DaoException;
import dao.DaoFactoryException;
import gui.alumnogui.dialog.AlumnoDialog;
import gui.alumnogui.mappers.AlumnoMapper;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import static dao.DAOFactory.*;

public class AlumnoGUI extends javax.swing.JFrame {
    
    private static final int TIPO_TXT = 0;
    private static final int TIPO_SQL = 1;

    AlumnoTableModel alumnoModel = new AlumnoTableModel();

    /**
     * Creates new form AlumnoGUI
     */
    private void buttonLoadDataMouseClicked(MouseEvent e) throws PersonaException, SQLException, DaoFactoryException, DaoException {
        if (selectorRepoComboBox.getSelectedIndex()==TIPO_TXT) {
            browseButton.setVisible(true);
            fullpathTextField.setVisible(true);

            if (fullpathTextField.getText() == null || fullpathTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo de ruta no puede estar vacío. Por favor, ingrese una ruta válida.", "Ruta vacía", JOptionPane.WARNING_MESSAGE);
            } else {
                Boolean OnlyActiveUsers = jCheckBoxOnlyActiveUsers.isSelected();
                reloadTableFromTxt(fullpathTextField.getText(), OnlyActiveUsers);
            }

        }
        else {
            browseButton.setVisible(false);
            fullpathTextField.setVisible(false);

            // Cargo los datos en la tabla
            Boolean OnlyActiveUsers = jCheckBoxOnlyActiveUsers.isSelected();
            reloadTableSql(OnlyActiveUsers);

        }
    }

    private void jCheckBoxOnlyActiveUsersStateChanged(ChangeEvent e) {

    }

    public AlumnoGUI() {

        initComponents();
        setTitle("Alumno GUI");
        setLocationRelativeTo(null);
        disaleButtons();

        try {
            List<Alumno> alumnos = new ArrayList<>();
            alumnoModel.setAlumnos(alumnos);
            alumnosTable.setModel(alumnoModel);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Martin
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        alumnosTable = new JTable();
        crearButton = new JButton();
        modificarButton = new JButton();
        borrarButton = new JButton();
        jButton4 = new JButton();
        selectorRepoComboBox = new JComboBox<>();
        jLabel1 = new JLabel();
        browseButton = new JButton();
        fullpathTextField = new JTextField();
        jCheckBoxOnlyActiveUsers = new JCheckBox();
        buttonLoadData = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jScrollPane1 ========
        {

            //---- alumnosTable ----
            alumnosTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(alumnosTable);
        }

        //---- crearButton ----
        crearButton.setText("Crear");
        crearButton.addActionListener(e -> crearButtonActionPerformed(e));

        //---- modificarButton ----
        modificarButton.setText("Modificar");
        modificarButton.addActionListener(e -> {
            try {
                modificarButtonActionPerformed(e);
            } catch (PersonaException ex) {
                throw new RuntimeException(ex);
            }
        });

        //---- borrarButton ----
        borrarButton.setText("Borrar");
        borrarButton.addActionListener(e -> borrarButtonActionPerformed(e));

        //---- jButton4 ----
        jButton4.setText("Consultar");
        jButton4.addActionListener(e -> jButton4ActionPerformed(e));

        //---- selectorRepoComboBox ----
        selectorRepoComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "TXT",
            "SQL"
        }));
        selectorRepoComboBox.addActionListener(e -> {
            try {
                selectorRepoComboBoxActionPerformed(e);
            } catch (PersonaException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (DaoFactoryException ex) {
                throw new RuntimeException(ex);
            } catch (DaoException ex) {
                throw new RuntimeException(ex);
            }
        });

        //---- jLabel1 ----
        jLabel1.setText("Seleccione repositorio:");

        //---- browseButton ----
        browseButton.setText("...");
        browseButton.addActionListener(e -> browseButtonActionPerformed(e));

        //---- fullpathTextField ----
        fullpathTextField.setEditable(false);
        fullpathTextField.setBackground(new Color(0xcccccc));

        //---- jCheckBoxOnlyActiveUsers ----
        jCheckBoxOnlyActiveUsers.setText("Solo los activos");
        jCheckBoxOnlyActiveUsers.addChangeListener(e -> jCheckBoxOnlyActiveUsersStateChanged(e));

        //---- buttonLoadData ----
        buttonLoadData.setText("Cargar");
        buttonLoadData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    buttonLoadDataMouseClicked(e);
                } catch (PersonaException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (DaoFactoryException ex) {
                    throw new RuntimeException(ex);
                } catch (DaoException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(crearButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(borrarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jCheckBoxOnlyActiveUsers, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(fullpathTextField, GroupLayout.Alignment.LEADING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(selectorRepoComboBox, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonLoadData)
                                            .addGap(65, 65, 65)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 84, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(selectorRepoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(buttonLoadData))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fullpathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(browseButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                    .addComponent(jCheckBoxOnlyActiveUsers)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(crearButton)
                            .addGap(18, 18, 18)
                            .addComponent(modificarButton)
                            .addGap(18, 18, 18)
                            .addComponent(borrarButton)
                            .addGap(26, 26, 26)
                            .addComponent(jButton4)))
                    .addGap(102, 102, 102))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        File dir = new File("C:\\Users\\g.guzman\\Documents\\NetBeansProjects\\2024\\Unificado\\TestDao");
        chooser.setCurrentDirectory(dir);
        int resp = chooser.showOpenDialog(jLabel1);
        if (resp!=JFileChooser.APPROVE_OPTION) {
            return;
        }
        fullpathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        crearButton.setEnabled(true);
        modificarButton.setEnabled(true);
    }//GEN-LAST:event_browseButtonActionPerformed

    private void selectorRepoComboBoxActionPerformed(java.awt.event.ActionEvent evt) throws PersonaException, SQLException, DaoFactoryException, DaoException {
        if (selectorRepoComboBox.getSelectedIndex()==TIPO_TXT) {
            browseButton.setVisible(true);
            fullpathTextField.setVisible(true);
        }
        else {
            browseButton.setVisible(false);
            fullpathTextField.setVisible(false);
        }
    }

    private void reloadTableFromTxt(String pathFile, Boolean onlyActiveUsers) throws DaoFactoryException, PersonaException, SQLException, DaoException {

        try {
            DAOFactory factory = DAOFactory.getInstance();
            Map<String, String> configMap = new HashMap<>();
            configMap.put(TIPO_DAO, TIPO_DAO_TXT);
            configMap.put(FULL_PATH, pathFile);
            DAO daoTxt = factory.crearDAO(configMap);

            List<Alumno> alumnos = daoTxt.findAll(onlyActiveUsers);
            alumnoModel.setAlumnos(alumnos);
            alumnosTable.setModel(alumnoModel);
            alumnoModel.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void reloadTableSql(Boolean onlyActiveUsers) {

        try {
            DAOFactory factory = DAOFactory.getInstance();
            Map<String, String> configMap = new HashMap<>();
            configMap.put(TIPO_DAO, TIPO_DAO_SQL);
            configMap.put(URL_DB, "jdbc:postgresql://localhost:5432/unlam");
            configMap.put(USER_DB, "postgres");
            configMap.put(PWD_DB, "postgres");

            DAO daoSql = factory.crearDAO(configMap);

            List<Alumno> alumnos = daoSql.findAll(onlyActiveUsers);
            alumnoModel.setAlumnos(alumnos);
            alumnosTable.setModel(alumnoModel);
            alumnoModel.fireTableDataChanged();

        } catch (PersonaException ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DaoFactoryException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) throws PersonaException {//GEN-FIRST:event_modificarButtonActionPerformed
        int rowSlected = alumnosTable.getSelectedRow();
        if (rowSlected<0) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un alumno", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // TODO ...
        Alumno alumno = getAlumnoSeleccionado(rowSlected);
        
        AlumnoDialog alumnoDialog = new AlumnoDialog(this, true, AlumnoDialog.UPDATE);
        alumnoDialog.setDto(AlumnoMapper.alumno2Dto(alumno));
        alumnoDialog.setVisible(true); // se suspende la ejecución
        
        Map<String, String> configMap = new HashMap<>();
        configMap.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
        String fullpath = fullpathTextField.getText();
        configMap.put(DAOFactory.FULL_PATH, fullpath);
        try {
            // Recupero los datos cargador en el diálogo
            dao.DAO dao = DAOFactory.getInstance().crearDAO(configMap);
        } catch (DaoFactoryException ex) {
            Logger.getLogger(AlumnoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //dao.update(AlumnoMapper.dto2Alumno(alumnoDialog.getDto()));
        alumno = AlumnoMapper.dto2Alumno(alumnoDialog.getDto());
        System.out.println("alumno a persistir ==> "+alumno.getDni() + "- "+alumno.getNombre()+ "- "+alumno.getFechaNac());
                
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        int rowSlected = alumnosTable.getSelectedRow();
        if (rowSlected<0) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado un alumno", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Alumno alumno = getAlumnoSeleccionado(rowSlected);
            
            int resp = JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar el alumno "
                    + "("+alumno.getDni()+" - " +alumno.getNombre()+")?", "Confirmación de borrado", JOptionPane.OK_CANCEL_OPTION);
            if (resp!=JOptionPane.OK_OPTION) {
                return;
            }
            System.out.println("Se borra el alumno");
            // Borrar
        }
    }//GEN-LAST:event_borrarButtonActionPerformed

    private Alumno getAlumnoSeleccionado(int rowSlected) {
        AlumnoTableModel alumnoTableModel = (AlumnoTableModel) alumnosTable.getModel();
        List<Alumno> alumnos = alumnoTableModel.getAlumnos();
        Alumno alumno = alumnos.get(rowSlected);
        return alumno;
    }

    private void crearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearButtonActionPerformed
        AlumnoDialog alumnoDialog = new AlumnoDialog(this, true, AlumnoDialog.CREATE);
        alumnoDialog.setVisible(true);
        
        System.out.println("Se cerró el modal");
    }//GEN-LAST:event_crearButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        AlumnoDialog alumnoDialog = new AlumnoDialog(this, true, AlumnoDialog.READ);
        alumnoDialog.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Martin
    private JScrollPane jScrollPane1;
    private JTable alumnosTable;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton borrarButton;
    private JButton jButton4;
    private JComboBox<String> selectorRepoComboBox;
    private JLabel jLabel1;
    private JButton browseButton;
    private JTextField fullpathTextField;
    private JCheckBox jCheckBoxOnlyActiveUsers;
    private JButton buttonLoadData;
    // End of variables declaration//GEN-END:variables

    private void disaleButtons() {
        crearButton.setEnabled(true);
        modificarButton.setEnabled(true);
    }
}
