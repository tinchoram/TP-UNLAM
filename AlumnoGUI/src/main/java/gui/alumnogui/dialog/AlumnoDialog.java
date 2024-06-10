package gui.alumnogui.dialog;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import com.toedter.calendar.*;
import gui.alumnogui.dto.AlumnoDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.JTextField;

public class AlumnoDialog extends javax.swing.JDialog {

    private boolean confirmed;
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String READ = "READ";
    
    private AlumnoDTO dto;

    public AlumnoDTO getDto() {
        return dto;
    }

    public void setDto(AlumnoDTO dto) {
        this.dto = dto;
    }

    public JTextField getDniTextField() {
        return dniTextField;
    }

    public void setDniTextField(JTextField dniTextField) {
        this.dniTextField = dniTextField;
    }

    public JTextField getNombreTextField() {
        return nombreTextField;
    }

    public void setNombreTextField(JTextField nombreTextField) {
        this.nombreTextField = nombreTextField;
    }


    private void cancelButtonMouseClicked(MouseEvent e) {
        confirmed = false;
        dispose();
    }

    /**
     * Creates new form AlumnoDialog
     */
    public AlumnoDialog(java.awt.Frame parent, boolean modal, String action) {
        super(parent, modal);
        initComponents();
        setTitle("Alumno Diálogo");
        setLocationRelativeTo(null);
        
        cancelButton.setVisible(!action.equals(READ));
        dniTextField.setEditable(action.equals(CREATE));
        disableTextFields(action);
        confirmed = false;
    }

    private void disableTextFields(String action) {

        switch (action) {
            case CREATE:
                dniTextField.setEditable(true);
                dniTextField.setEnabled(true);
                nombreTextField.setEditable(true);
                apellidoTextField.setEditable(true);
                fecNacDateChooser.setEnabled(true);
                legajoTextField.setEditable(true);
                legajoTextField.setEnabled(true);
                correoTextField.setEditable(true);
                telefonoTextField.setEditable(true);
                direccionTextField.setEditable(true);
                localidadTextField.setEditable(true);
                break;
            case UPDATE:
                dniTextField.setEditable(false);
                nombreTextField.setEditable(true);
                apellidoTextField.setEditable(true);
                fecNacDateChooser.setEnabled(true);
                legajoTextField.setEditable(false);
                break;
            case READ:
                dniTextField.setEditable(false);
                dniTextField.setEnabled(false);
                nombreTextField.setEditable(false);
                nombreTextField.setEnabled(false);
                apellidoTextField.setEnabled(false);
                apellidoTextField.setEditable(false);
                apellidoTextField.setEnabled(false);
                fecNacDateChooser.setEnabled(false);
                legajoTextField.setEditable(false);
                legajoTextField.setEnabled(false);
                correoTextField.setEditable(false);
                correoTextField.setEnabled(false);
                telefonoTextField.setEditable(false);
                telefonoTextField.setEnabled(false);
                direccionTextField.setEditable(false);
                direccionTextField.setEnabled(false);
                localidadTextField.setEditable(false);
                localidadTextField.setEnabled(false);
                generocomboBox.setEnabled(false);
                generocomboBox.setEnabled(false);
                cantidadAprobadaSpinner.setEnabled(false);
                cantidadAprobadaSpinner.setEnabled(false);
                break;
            default:
                dniTextField.setEditable(false);
                nombreTextField.setEditable(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Martin
    private void initComponents() {
        OKButton = new JButton();
        cancelButton = new JButton();
        jLabel1 = new JLabel();
        dniTextField = new JTextField();
        jLabel2 = new JLabel();
        nombreTextField = new JTextField();
        fecNacDateChooser = new JDateChooser();
        jLabel3 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        legajoTextField = new JTextField();
        apellidoTextField = new JTextField();
        correoTextField = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        telefonoTextField = new JTextField();
        label5 = new JLabel();
        direccionTextField = new JTextField();
        label6 = new JLabel();
        localidadTextField = new JTextField();
        label7 = new JLabel();
        generocomboBox = new JComboBox<>();
        label8 = new JLabel();
        cantidadAprobadaSpinner = new JSpinner();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                formWindowOpened(e);
            }
        });
        var contentPane = getContentPane();

        //---- OKButton ----
        OKButton.setText("OK");
        OKButton.addActionListener(e -> OKButtonActionPerformed(e));

        //---- cancelButton ----
        cancelButton.setText("Cancelar");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelButtonMouseClicked(e);
            }
        });

        //---- jLabel1 ----
        jLabel1.setText("DNI:");

        //---- dniTextField ----
        dniTextField.setEnabled(false);
        dniTextField.setEditable(false);

        //---- jLabel2 ----
        jLabel2.setText("Nombre:");

        //---- jLabel3 ----
        jLabel3.setText("Fecha Nac:");

        //---- label1 ----
        label1.setText("Legajo");

        //---- label2 ----
        label2.setText("Apellido");

        //---- legajoTextField ----
        legajoTextField.setEditable(false);
        legajoTextField.setEnabled(false);

        //---- label3 ----
        label3.setText("Correo");

        //---- label4 ----
        label4.setText("Telefono");

        //---- label5 ----
        label5.setText("Direccion");

        //---- label6 ----
        label6.setText("Localidad");

        //---- label7 ----
        label7.setText("Genero");

        //---- generocomboBox ----
        generocomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "X",
            "F",
            "M"
        }));

        //---- label8 ----
        label8.setText("Cantidad de Materias Aprobadas");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                            .addComponent(OKButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(direccionTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(dniTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(telefonoTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(localidadTextField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(correoTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(apellidoTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 53, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label7)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(fecNacDateChooser, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(generocomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(legajoTextField, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label8)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cantidadAprobadaSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(15, 15, 15)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(dniTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1)
                            .addComponent(legajoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(apellidoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(correoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)
                        .addComponent(generocomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fecNacDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(telefonoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(direccionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidadAprobadaSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(localidadTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(OKButton)
                        .addComponent(cancelButton))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        dniTextField.setText(String.valueOf(dto.getDni()));
        legajoTextField.setText(String.valueOf(dto.getLegajo()));
        nombreTextField.setText(dto.getNombre());
        apellidoTextField.setText(dto.getApellido());
        int year = dto.getFecNac().getYear();
        int month = dto.getFecNac().getMonthValue();
        int day = dto.getFecNac().getDayOfMonth();
        
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day);
        fecNacDateChooser.setCalendar(cal);

        correoTextField.setText(dto.getCorreo());
        telefonoTextField.setText(dto.getTelefono());
        direccionTextField.setText(dto.getDireccion());
        localidadTextField.setText(dto.getLocalidad());
        cantidadAprobadaSpinner.setValue(dto.getCantidadAprobadas());
        generocomboBox.setSelectedItem(String.valueOf(dto.getGenero()));


    }

    public boolean isConfirmed() {
        return confirmed;
    }
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {

        if (!validarCampos()) {
            return;
        }
        
        dto.setDni(Integer.valueOf(dniTextField.getText()));
        dto.setLegajo(Integer.valueOf(legajoTextField.getText()));
        dto.setNombre(nombreTextField.getText());
        dto.setApellido(apellidoTextField.getText());
        dto.setCorreo(correoTextField.getText());
        dto.setTelefono(telefonoTextField.getText());
        dto.setDireccion(direccionTextField.getText());
        dto.setLocalidad(localidadTextField.getText());
        dto.setGenero(generocomboBox.getSelectedItem().toString().charAt(0));
        dto.setCantidadAprobadas((Integer) cantidadAprobadaSpinner.getValue());
        
        Calendar calendar = fecNacDateChooser.getCalendar();
        LocalDate localDate = LocalDateTime.ofInstant(calendar.toInstant(), 
                calendar.getTimeZone().toZoneId()).toLocalDate();
        dto.setFecNac(localDate);
        confirmed = true;
        setVisible(false);
    }

    private boolean validarCampos() {
        // Validación DNI
        if (dniTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo DNI no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(dniTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo DNI debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (dniTextField.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "El campo DNI debe tener exactamente 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Legajo
        if (legajoTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Legajo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(legajoTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo Legajo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (legajoTextField.getText().length() != 4) {
            JOptionPane.showMessageDialog(this, "El campo Legajo debe tener exactamente 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Nombre
        if (nombreTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!nombreTextField.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "El campo Nombre solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (nombreTextField.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede tener más de 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Apellido
        if (apellidoTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Apellido no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!apellidoTextField.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "El campo Apellido solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (apellidoTextField.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "El campo Apellido no puede tener más de 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Fecha de Nacimiento
        if (fecNacDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "El campo Fecha de Nacimiento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Correo
        if (correoTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!correoTextField.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "El campo Correo debe ser un correo electrónico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (correoTextField.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "El campo Correo no puede tener más de 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Teléfono
        if (telefonoTextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!telefonoTextField.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "El campo Teléfono debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (telefonoTextField.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "El campo Teléfono no puede tener más de 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Dirección
        if (direccionTextField.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "El campo Dirección no puede tener más de 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Localidad
        if (localidadTextField.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "El campo Localidad no puede tener más de 50 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
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
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlumnoDialog dialog = new AlumnoDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Martin
    private JButton OKButton;
    private JButton cancelButton;
    private JLabel jLabel1;
    private JTextField dniTextField;
    private JLabel jLabel2;
    private JTextField nombreTextField;
    private JDateChooser fecNacDateChooser;
    private JLabel jLabel3;
    private JLabel label1;
    private JLabel label2;
    private JTextField legajoTextField;
    private JTextField apellidoTextField;
    private JTextField correoTextField;
    private JLabel label3;
    private JLabel label4;
    private JTextField telefonoTextField;
    private JLabel label5;
    private JTextField direccionTextField;
    private JLabel label6;
    private JTextField localidadTextField;
    private JLabel label7;
    private JComboBox<String> generocomboBox;
    private JLabel label8;
    private JSpinner cantidadAprobadaSpinner;
    // End of variables declaration//GEN-END:variables
}
