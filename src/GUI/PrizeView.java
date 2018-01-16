 
package GUI;

import NapakalakiGame.Prize;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class PrizeView extends javax.swing.JPanel {
    Prize prizeModel;
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize p) {
        prizeModel=p;
        levels.setText(Integer.toString(prizeModel.getLevel()));
        treasures.setText(Integer.toString(prizeModel.getTreasures()));
        repaint();
        revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        treasures = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();

        jLabel1.setText("Treasures:");

        jLabel2.setText("Levels:");

        treasures.setText("treasures");

        levels.setText("levels");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levels)
                    .addComponent(treasures))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(treasures))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(levels))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel treasures;
    // End of variables declaration//GEN-END:variables
}
