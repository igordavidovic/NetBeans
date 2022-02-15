/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tablica.view;

/**
 *
 * @author Igor
 */
public class Tablica extends javax.swing.JFrame {

    /**
     * Creates new form Tablica
     */
    private int proizvod;
    private int d = 1;
    private int m = 0;

    public Tablica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void kreiranjeTablice(int r, int s) {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[r][s],
                new String[s]
        ));
        proizvod = r * s;
        punjenjeTablice(r, s);
    }

    private void punjenjeTablice(int r, int s) {
        while (true) {
            if (d > proizvod) {
                break;
            }
            ddDesnoLijevo(r, s);
            if (d > proizvod) {
                break;
            }
            dlLijevoGore(r, s);
            if (d > proizvod) {
                break;
            }
            glLijevoDesno(r, s);
            if (d > proizvod) {
                break;
            }
            gdDesnoDolje(r, s);
            m++;
        }
    }

    private void ddDesnoLijevo(int r, int s) {

        for (int y = s - (1 + m); y >= m; y--) {
            if (d > proizvod) {
                break;
            }
            jTable1.setValueAt(d, r - (1 + m), y);
            d++;
        }
    }

    private void dlLijevoGore(int r, int s) {

        for (int x = r - (2 + m); x > m; x--) {
            if (d > proizvod) {
                break;
            }
            jTable1.setValueAt(d, x, m);
            d++;
        }
    }

    private void glLijevoDesno(int r, int s) {
        for (int y = m; y < s - m; y++) {
            if (d > proizvod) {
                break;
            }
            jTable1.setValueAt(d, m, y);
            d++;
        }
    }

    private void gdDesnoDolje(int r, int s) {
        for (int x = (1 + m); x < r - (1 + m); x++) {
            if (d > proizvod) {
                break;
            }
            jTable1.setValueAt(d, x, s - (1 + m));
            d++;
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
            java.util.logging.Logger.getLogger(Tablica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
