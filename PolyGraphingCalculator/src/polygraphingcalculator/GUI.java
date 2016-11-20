package polygraphingcalculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class GUI extends javax.swing.JFrame {
    List<Polynomial> storedPolynomials = new ArrayList();
    DefaultComboBoxModel polyBox1Model = new DefaultComboBoxModel();
    DefaultComboBoxModel polyBox2Model = new DefaultComboBoxModel(); 
    String mode = "Addition";
    //Centre of the screen (x, y)
    double centreX = 0;
    double centreY = 0;
    //How many units the axis continues past the centre
    double zoom = 10;
    
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        graphButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        storeButton = new javax.swing.JButton();
        polyBox1 = new javax.swing.JComboBox<>();
        polyBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        operationLabel = new javax.swing.JLabel();
        ModeBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        calculateButton = new javax.swing.JButton();
        rescaleButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        graphButton.setText("Graph");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });
        getContentPane().add(graphButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 653, 71, -1));

        jTextField1.setText("x^2 - 5x + 6");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 655, 376, -1));

        jButton2.setText("Derivative");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 624, -1, -1));

        jButton3.setText("Integral");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1081, 624, -1, -1));

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 640));
        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1MouseWheelMoved(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 637));

        storeButton.setText("Store");
        storeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(storeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 653, -1, -1));

        polyBox1.setModel(polyBox1Model);
        getContentPane().add(polyBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 93, -1, -1));

        polyBox2.setModel(polyBox2Model);
        getContentPane().add(polyBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 157, -1, -1));

        jLabel1.setText("y=");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 658, -1, -1));

        jButton1.setText("Clear All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGraphs(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1081, 653, -1, -1));

        jLabel2.setText("Polynomial 1:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 99, -1, -1));

        jLabel3.setText("Polynomial 2:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 160, -1, -1));

        jLabel4.setText("Result:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 237, -1, -1));

        operationLabel.setText("Added With:");
        getContentPane().add(operationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, -1, -1));

        ModeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Addition", "Subtraction", "Multiplication", "Division", "Derivative", "Integral" }));
        ModeBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ModeBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(ModeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 47, -1, -1));

        jLabel6.setText("Mode");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 50, -1, -1));

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, -1, -1));

        rescaleButton.setText("Rescale");
        rescaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescaleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rescaleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 624, -1, -1));

        resultLabel.setText("0");
        getContentPane().add(resultLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 237, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void redraw(Graphics g){
        Image graph = getGraphImage();
        g.drawImage(graph, 0, 0, rootPane);         
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    private void storeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeButtonActionPerformed
        String text = jTextField1.getText();
        storedPolynomials.add( new Polynomial(text) );
        this.remodel();
    }//GEN-LAST:event_storeButtonActionPerformed
    public void remodel(){
        polyBox1Model.removeAllElements();
        polyBox2Model.removeAllElements();
        
        for(Polynomial poly: storedPolynomials){
            polyBox1Model.addElement(poly);
            polyBox2Model.addElement(poly);
        }
        polyBox1.setModel(polyBox1Model);
        polyBox2.setModel(polyBox2Model);        
    }
    
    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        this.zoom = 10;
        Graphics g = jPanel1.getGraphics();
        redraw(g);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void clearGraphs(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearGraphs
        this.zoom = 10;
        this.centreX = 0;
        this.centreY = 0;
        storedPolynomials = new ArrayList();
        Graphics g = jPanel1.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
    }//GEN-LAST:event_clearGraphs

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        //NEEDS WORK
        Polynomial result = null;
        if(mode.equals("Addition")){
            Polynomial p1 = (Polynomial)polyBox1.getSelectedItem();
            Polynomial p2 = (Polynomial)polyBox2.getSelectedItem();
            result = p1.polyAdd(p2);
        }
        else if(mode.equals("Subtraction")){
            Polynomial p1 = (Polynomial)polyBox1.getSelectedItem();
            Polynomial p2 = (Polynomial)polyBox2.getSelectedItem();
            result = p1.polySubtract(p2);
        }
        else if(mode.equals("Multiplication")){
            Polynomial p1 = (Polynomial)polyBox1.getSelectedItem();
            Polynomial p2 = (Polynomial)polyBox2.getSelectedItem();
            result = p1.polyMultiply(p2);
        }
        else if(mode.equals("Derivative")){
            //TODO code
        }
        else{ //guessinig this is integral
            //TODO code
        }
        resultLabel.setText(result.toString());
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void jPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1MouseWheelMoved
        if (evt.getWheelRotation() < 0)
            this.zoom /= 2;
        else
            this.zoom *= 2;
        Graphics g = jPanel1.getGraphics();
        redraw(g);      
    }//GEN-LAST:event_jPanel1MouseWheelMoved

    private void rescaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescaleButtonActionPerformed
        this.zoom = 10;
        this.centreX = 0;
        this.centreY = 0;
        Graphics g = jPanel1.getGraphics();
        redraw(g);
    }//GEN-LAST:event_rescaleButtonActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        //this.centreX = evt.getX(); DO NOT USE THIS CODE
        //this.centreY = evt.getY(); IT DOESN'T WORK
        Graphics g = jPanel1.getGraphics();
        redraw(g);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void ModeBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ModeBoxItemStateChanged
        mode = (String)ModeBox.getSelectedItem();
        boolean visible = true;
        if(mode.equals("Addition")){
            operationLabel.setText("Added With:");
        }
        else if(mode.equals("Subtraction")){
            operationLabel.setText("Subtracted By:");
        }
        else if(mode.equals("Multiplication")){
            operationLabel.setText("Multiplied With:");
        }
        else if(mode.equals("Division")){
            operationLabel.setText("Divided By:");
        }
        else{
            visible = false;
        }
        operationLabel.setVisible(visible);
        jLabel3.setVisible(visible);
        polyBox2.setVisible(visible);
        
    }//GEN-LAST:event_ModeBoxItemStateChanged

    public Image getGraphImage(){
        double yMin = centreY - zoom;
        double yMax = centreY + zoom;
        double xMin = centreX - zoom;
        double xMax = centreX + zoom;
        int w = jPanel1.getWidth();
        int h = jPanel1.getHeight();     
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);        
        Graphics2D g = (Graphics2D) bi.getGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.black);
        
        for (Polynomial f: storedPolynomials){
            int[] xValues = new int[(int)(w*(xMax - xMin)/(2*zoom))+1];
            int[] yValues = new int[xValues.length];
            int i = 0;
            for (double x=xMin; x<xMax; x+=(double)2*zoom/w){
                double y = f.evaluateAt(x);
                xValues[i] = (int) Math.round(w*(x - xMin)/(xMax-xMin));
                yValues[i] = (int) Math.round(h*(yMax - y)/(yMax - yMin));
                i++;
            }
            g.drawPolyline(xValues, yValues, w);
        }                
        return bi;
    }
    
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ModeBox;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton graphButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel operationLabel;
    private javax.swing.JComboBox<String> polyBox1;
    private javax.swing.JComboBox<String> polyBox2;
    private javax.swing.JButton rescaleButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton storeButton;
    // End of variables declaration//GEN-END:variables
}
