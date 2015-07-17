
package com.elle.analyster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Louis W.
 */
public class AddRecords extends JFrame {

    // attributes
    private String[] columnNames;
    private String tableName;
    private int numRowsAdded;  // number of rows added counter
    
    // components
    @Autowired
    private Analyster analyster;
    private LogWindow logWindow;
    private Logger logger;
    private GUI gui;
    private DefaultTableModel model;

    /**
     * Creates new form ReportWin <-- does it really?
     */
    public AddRecords() {
        
        // initialize components
        initComponents();
        analyster = Analyster.getInstance();
        logWindow = analyster.getLogwind();
        logger = LoggerFactory.getLogger(AddRecords.class);
        gui = new GUI();
        
        // set this window to appear in the middle of Analyster
        this.setLocationRelativeTo(analyster);
        
        // set the selected table name
        tableName = analyster.getSelectedTab();
        
        // get column names for selected Analyster table
        columnNames = analyster.getTabs().get(tableName).getTableColNames();
        
        // initialize the table data with 10 empty rows
        Object[][] data = {{},{},{},{},{},{},{},{},{},{}}; 
        
        // we don't want the ID column 
        columnNames = Arrays.copyOfRange(columnNames, 1, columnNames.length); 
        
        // set the table model
        model = new DefaultTableModel(data, columnNames);
        
        // add the table model to the table
        table.setModel(model);
        
        // sets the keyboard focus manager
        setKeyboardFocusManager(); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSubmit = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jAddRow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 200));

        scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setMaximumSize(new java.awt.Dimension(260, 100));
        scrollpane.setMinimumSize(new java.awt.Dimension(130, 50));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "symbol", "analyst", "priority", "dateAssigned", "note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        scrollpane.setViewportView(table);

        jSubmit.setText("Submit");
        jSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubmitActionPerformed(evt);
            }
        });

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jAddRow.setText("+");
        jAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jAddRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(jCancel)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubmit)
                    .addComponent(jCancel)
                    .addComponent(jAddRow))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubmitActionPerformed
//        Vector data, row = new Vector();
        String title = " (";    // element of Sql statement
        ArrayList<String> rows = new ArrayList<>();
        String rowData;
        boolean flag = false;   // if add successfully, set it true

        int i = 0, j = 0, num = 0;
        int colNum = table.getColumnCount();

        for (i = 0; i < colNum - 1; i++) {
            title += columnNames[i] + ",";
        }
        title += columnNames[colNum - 1] + ") ";

        // rows comprise all the new information for inserting
        i = 0;

        numRowsAdded = 0; // reset numRowsAdded counter
        
        while (i != table.getRowCount() && table.getValueAt(i, 0) != null) {    // within accessible rows && not null next line
            rowData = "(";

            while (j < colNum - 1) {
                // first, check date format if it's date column
                if (columnNames[j].equals("dateAssigned") || columnNames[j].equals("analysisDate")) {     
                    if (table.getValueAt(i, j).toString().matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
                        rowData += "'" + table.getValueAt(i, j).toString() + "',";
                    } else if (table.getValueAt(i, j).toString() == null) {
                        rowData += null + ",";    // default date for null input
                    } else {
                        JOptionPane.showMessageDialog(null, "Date format is incorrect!");
                        break;
                    }
                // second, check if null
                } else if (table.getValueAt(i, j) == null) {      
                    rowData += null + ",";
                } else {
                    rowData += "'" + table.getValueAt(i, j).toString() + "',";
                }
                j++;
            }
            if (table.getValueAt(i, j) == null) {
                rowData += null + ")";
            } else {
                rowData += "'" + table.getValueAt(i, j).toString() + "')";
            }
            rows.add(rowData);
            numRowsAdded++; // increment a row added to row added counter
            i++;
            j = 0;
        }
        num = i;

        // insert the new rows one by one
        for (i = 0; i < num; i++) {
            try {
                String sqlChange = "INSERT INTO " + tableName + title + " VALUES " + rows.get(i);
                System.out.println(sqlChange);
                gui.stmt.executeUpdate(sqlChange);
                logWindow.sendMessages(sqlChange);
                flag = true;
            } catch (SQLException ex) {
                ex.getErrorCode();
                JOptionPane.showMessageDialog(null, "Upload failed! ");
            } catch (Exception ex) {
                logger.error("Error: ", ex);
                JOptionPane.showMessageDialog(null, "Error!");
                ex.getStackTrace();
            }
        }

        if (flag) {
            JOptionPane.showMessageDialog(null, "Add successfully!");
            analyster.loadData();
            analyster.setLastUpdateTime();
            
            // update total records with new records added
            analyster.getTabs().get(analyster.getSelectedTab()).addToTotalRowCount(numRowsAdded);
        }
        this.dispose();
    }//GEN-LAST:event_jSubmitActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

    }//GEN-LAST:event_tableMouseClicked

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jCancelActionPerformed

    private void jAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRowActionPerformed

        // add an empty row to the table
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jAddRowActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed
   
    /**
     * setKeyboardFocusManager
     * Sets the Keyboard Focus Manager
     */
    private void setKeyboardFocusManager() {
        
        /*
         No Tab key-pressed or key-released events are received by the key event listener. This is because the focus subsystem 
         consumes focus traversal keys, such as Tab and Shift Tab. To solve this, apply the following to the component that is 
         firing the key events 
         */
        table.setFocusTraversalKeysEnabled(false);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {// Allow to TAB-

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getComponent() instanceof JTable) {
                        JTable table = (JTable) e.getComponent();
                        int row = table.getSelectedRow();
                        int column = table.getSelectedColumn();
                        if (column == table.getRowCount() || column == 0) {
                            return false;
                        } else {
                            table.getComponentAt(row, column).requestFocus();
                            table.editCellAt(row, column);
                            JTextField selectCom = (JTextField) table.getEditorComponent();
                            selectCom.requestFocusInWindow();
                            selectCom.selectAll();
                        }
                    }

                } else if (e.getKeyCode() == KeyEvent.VK_D && e.isControlDown()) {
                    JTable table = (JTable) e.getComponent().getParent();
                    int column = table.getSelectedColumn();
                    if (table.getColumnName(column).toLowerCase().contains("date")) {
                        if (e.getID() != 401) {
                            return false;
                        } else {
                            JTextField selectCom = (JTextField) e.getComponent();
                            selectCom.requestFocusInWindow();
                            selectCom.selectAll();
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date();
                            String today = dateFormat.format(date);
                            selectCom.setText(today);
                        }// default date input with today's date}
                    }

                }
                return false; 
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddRow;
    private javax.swing.JButton jCancel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jSubmit;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
