/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clockinsystem;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jj
 */
public class dashboard extends javax.swing.JDialog {

    /**
     * Creates new form dashboard
     */
    public dashboard(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        dataObjectForSubTable = new ArrayList<Object>();
        initComponents();
        getAllLogsIntoJTable();
    }
    // initial jtable
    public void getAllLogsIntoJTable(){
          //fill fade data before database implement
          ArrayList<Object> temp= new ArrayList<Object>();; 
          Object[] subTableNumberRow = new Object[]{"data","in time","out time"};
          
          temp.add(subTableNumberRow);
          temp.add(subTableNumberRow);
          temp.add(subTableNumberRow);
          temp.add(subTableNumberRow);
          temp.add(subTableNumberRow);
            
          this.addSubTableRowsToDataObject(temp);       
          Collections.reverse(dataObjectForSubTable);
          Object[][] finalData = dataObjectForSubTable.toArray(new Object[dataObjectForSubTable.size()][]);
          this.buildJtableAfterMapData(finalData);
          System.out.printf("updateJTable button pressed");
    }
    
    // reformat and validate the data from database
    public void addSubTableRowsToDataObject(ArrayList<Object> temp){
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy / MM / dd    E");
             
            for(int i=0;i<temp.size(); i++){
                temp.get(i);
                Object[] o = (Object[])temp.get(i);
                String t1 = o[0].toString();
                String t2 = o[1].toString();
                String t3 = o[2].toString();

                // catch exception for formating the database raw data 
//                try{
//                    t1=o[0].toString();
//                }catch(NullPointerException e){}
//                 try{
//                    Date date = new Date();
//                    date=(Date)o[1];
//                    t2=dateFormater.format(date);
//                }catch(NullPointerException e){}
//                  try{
//                    Date date = new Date();
//                    date=(Date)o[2];
//                    t3=dateFormater.format(date);
//                }catch(NullPointerException e){}
 
                
                Object[] s = new Object[]{t1, t2, t3};
                dataObjectForSubTable.add(s);
            }
    }
    
    // build jtable object after reformat the data
    public void buildJtableAfterMapData(Object[][] data) {
        DefaultTableModel model;
        final ColorTable colorTable;
        
        model = new DefaultTableModel(data,
                new Object[]{"ID", "Time in", "Time out"});
        colorTable = new ColorTable(model);
        colorTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        colorTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        colorTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        colorTable.setRowHeight(30);

        colorTable.getTableHeader().setReorderingAllowed(false);
        colorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        colorTable.setFillsViewportHeight(true);
        jScrollPane1.getViewport().add(colorTable);  
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Logs", jPanel3);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButton1.setText("Clock in");

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jButton2.setText("Clock out");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Time in/out", jPanel2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Object> dataObjectForSubTable;


}