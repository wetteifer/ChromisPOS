/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.chromis.pos.sales;

import edu.emory.mathcs.backport.java.util.Collections;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import uk.chromis.pos.ticket.TicketInfo;

/**
 *
 * @author dario
 */
public class JDinersDialog extends JDialog {
    
    public enum DinerSelectionResult {
        CANCEL,
        OK
    }

    private final TicketInfo source;
    private final Map<String, TicketInfo> tickets;
    private DinerSelectionResult result;
    
    /**
     * Creates new form JDinersDialog
     * @param source
     * @param tickets
     */
    public JDinersDialog(TicketInfo source, Map<String, TicketInfo> tickets) {
        super((Frame) null, true);
        
        initComponents();
        
        this.source = source;
        this.tickets = tickets;
        this.result = DinerSelectionResult.CANCEL;
        
        String[] items = tickets.keySet()
                .stream()
                .toArray(String[]::new);        
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        model.setSelectedItem(source.getProperty("ticket.activediner"));
        
        BasicComboBoxRenderer renderer = new BasicComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(100, 50));
        
        mDinersList.setModel(model);
        mDinersList.setRenderer(renderer);
    }
    
    public DinerSelectionResult getResult() {
        return result;
    }
    
    public Map<String, TicketInfo> getTickets() {
        if (mSelectAllDiners.isSelected()) {
            return tickets;
        }
        
        if (mUniqueTicket.isSelected()) {
            return Collections.singletonMap("1", source);
        }
        
        String diner = (String) mDinersList.getSelectedItem();
        TicketInfo ticket = tickets.get(diner);
        
        return Collections.singletonMap(diner, ticket);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mDinersButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        mDinersList = new javax.swing.JComboBox<>();
        mOkButton = new javax.swing.JButton();
        mCancelButton = new javax.swing.JButton();
        mUniqueTicket = new javax.swing.JRadioButton();
        mSelectAllDiners = new javax.swing.JRadioButton();
        mSelectOneDiner = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        setTitle(bundle.getString("label.dinersdialog")); // NOI18N
        setModal(true);
        setResizable(false);

        jLabel1.setText(bundle.getString("label.selectdiner")); // NOI18N

        mDinersList.setPreferredSize(new java.awt.Dimension(52, 40));

        mOkButton.setText(bundle.getString("Button.OK")); // NOI18N
        mOkButton.setPreferredSize(new java.awt.Dimension(52, 40));
        mOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOkButtonActionPerformed(evt);
            }
        });

        mCancelButton.setText(bundle.getString("Button.Cancel")); // NOI18N
        mCancelButton.setPreferredSize(new java.awt.Dimension(52, 40));
        mCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCancelButtonActionPerformed(evt);
            }
        });

        mDinersButtonGroup.add(mUniqueTicket);
        mUniqueTicket.setText(bundle.getString("label.uniqueticket")); // NOI18N
        mUniqueTicket.setPreferredSize(new java.awt.Dimension(52, 40));
        mUniqueTicket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mUniqueTicketItemStateChanged(evt);
            }
        });

        mDinersButtonGroup.add(mSelectAllDiners);
        mSelectAllDiners.setText(bundle.getString("label.selectalldiners")); // NOI18N
        mSelectAllDiners.setPreferredSize(new java.awt.Dimension(52, 40));
        mSelectAllDiners.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mSelectAllDinersItemStateChanged(evt);
            }
        });

        mDinersButtonGroup.add(mSelectOneDiner);
        mSelectOneDiner.setSelected(true);
        mSelectOneDiner.setText(bundle.getString("label.selectonediner")); // NOI18N
        mSelectOneDiner.setPreferredSize(new java.awt.Dimension(52, 40));
        mSelectOneDiner.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mSelectOneDinerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mDinersList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 160, Short.MAX_VALUE)
                        .addComponent(mCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mSelectOneDiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mSelectAllDiners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mUniqueTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mDinersList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mSelectOneDiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mSelectAllDiners, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mUniqueTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOkButtonActionPerformed
        result = DinerSelectionResult.OK;
        dispose();
    }//GEN-LAST:event_mOkButtonActionPerformed

    private void mCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCancelButtonActionPerformed
        result = DinerSelectionResult.CANCEL;
        dispose();
    }//GEN-LAST:event_mCancelButtonActionPerformed

    private void mSelectOneDinerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mSelectOneDinerItemStateChanged
        mDinersList.setEnabled(true);
    }//GEN-LAST:event_mSelectOneDinerItemStateChanged

    private void mSelectAllDinersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mSelectAllDinersItemStateChanged
        mDinersList.setEnabled(false);
    }//GEN-LAST:event_mSelectAllDinersItemStateChanged

    private void mUniqueTicketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mUniqueTicketItemStateChanged
        mDinersList.setEnabled(false);
    }//GEN-LAST:event_mUniqueTicketItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mCancelButton;
    private javax.swing.ButtonGroup mDinersButtonGroup;
    private javax.swing.JComboBox<String> mDinersList;
    private javax.swing.JButton mOkButton;
    private javax.swing.JRadioButton mSelectAllDiners;
    private javax.swing.JRadioButton mSelectOneDiner;
    private javax.swing.JRadioButton mUniqueTicket;
    // End of variables declaration//GEN-END:variables

}
