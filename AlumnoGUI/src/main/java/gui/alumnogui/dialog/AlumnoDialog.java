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

//    private void cancel(ActionEvent e) {
//        // TODO add your code here
//    }

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
                nombreTextField.setEditable(false);
                apellidoTextField.setEditable(false);
                fecNacDateChooser.setEnabled(false);
                legajoTextField.setEditable(false);
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(OKButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fecNacDateChooser, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(dniTextField)
                                    .addComponent(nombreTextField)
                                    .addComponent(legajoTextField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addComponent(apellidoTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dniTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(legajoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(apellidoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(fecNacDateChooser, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
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
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {

        dto.setDni(Integer.valueOf(dniTextField.getText()));
        dto.setLegajo(Integer.valueOf(legajoTextField.getText()));
        dto.setNombre(nombreTextField.getText());
        dto.setApellido(apellidoTextField.getText());
        
        Calendar calendar = fecNacDateChooser.getCalendar();
        LocalDate localDate = LocalDateTime.ofInstant(calendar.toInstant(), 
                calendar.getTimeZone().toZoneId()).toLocalDate();
        dto.setFecNac(localDate);
        confirmed = true;
        setVisible(false);
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
    // End of variables declaration//GEN-END:variables
}
