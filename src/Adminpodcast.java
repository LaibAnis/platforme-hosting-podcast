

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dell
 */
public class Adminpodcast extends javax.swing.JFrame {

    /**
     * Creates new form Adminpodcast
     */
    
    
    public Adminpodcast() {
        initComponents();
        labellogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(labellogo.getWidth(), labellogo.getHeight(), Image.SCALE_SMOOTH)));
        getpodcasts();
        getcomments();
        panelPodcats.setVisible(true);
        panelComments.setVisible(false);

        
        
    }
    
    
    void creatcommentpanel(int comid,String lastnam,String firstnam,String content){
        JPanel commentpanel=new JPanel();
        JLabel labelname=new JLabel();
        JLabel labeldel=new JLabel();
        JLabel twoplab=new JLabel();
        JTextArea textcomment=new JTextArea();
        JScrollPane jScrollPane1 =new JScrollPane();
        commentpanel.setBackground(new java.awt.Color(255, 255, 255));
        commentpanel.setPreferredSize(new java.awt.Dimension(panelComments.getWidth(), 101));
        //commentpanel.setSize(panelComments.getWidth(), panelComments.getHeight());
        commentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelname.setText(lastnam+" "+firstnam+" ");
        commentpanel.add(labelname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 190, 70));

        twoplab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        twoplab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoplab.setText(":");
        commentpanel.add(twoplab, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 16, 10, 70));

        textcomment.setColumns(20);
        textcomment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textcomment.setForeground(new java.awt.Color(51, 51, 51));
        textcomment.setLineWrap(true);
        textcomment.setRows(5);
        textcomment.setWrapStyleWord(true);
        textcomment.setEditable(false);
        jScrollPane1.setViewportView(textcomment);
        textcomment.setText(content);
        commentpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 400, 80));

        labeldel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labeldel.setForeground(new java.awt.Color(255, 0, 0));
        labeldel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeldel.setText("Delete");
        labeldel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));
        labeldel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                  int rese=JOptionPane.showConfirmDialog(null, "Are you sure to delete this comment ?", "Delting comment", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               if(rese==JOptionPane.YES_OPTION){
                  
                  Connection cn; 
                PreparedStatement pr;
                ResultSet rs;
                ResultSet rs2;
                int res;
                class.forName("com.mysql.jdbc.Driver");
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                    pr=cn.prepareStatement("DELETE FROM comment WHERE idcomment=?");
                    pr.setString(1,String.valueOf(comid) );
                    res=pr.executeUpdate();
                    if(res >0){
                        panelComments.removeAll();
                        panelComments.setVisible(false);
                        pr=cn.prepareStatement("SELECT * FROM comment");
            rs=pr.executeQuery();
            while(rs.next()){
                int commentid=rs.getInt(1);
                int userid=rs.getInt(2);
                String contentt=rs.getString(4);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1, String.valueOf(userid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    String lastname=rs2.getString(1);
                    String firstname=rs2.getString(2);
                    creatcommentpanel(commentid, lastname, firstname, contentt);
                    
                }
                else{
                    System.out.println("ereur user id or statement");
                }
                
            }
            panelComments.setVisible(true);
                    }
                    else{
                        System.out.println("erreur during deleting comment");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
                
            }
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labeldel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                labeldel.setBackground(Color.red);
                labeldel.setOpaque(true);
                labeldel.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                labeldel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                labeldel.setBackground(Color.white);
                labeldel.setOpaque(true);
                labeldel.setForeground(Color.red);
            }
        });
         commentpanel.add(labeldel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 130, 20));
         commentpanel.setVisible(true);

        panelComments.add(commentpanel);
    }
    
    void getcomments(){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String lastname=null;
        String firstname=null;
        int commentid;
        int userid;
        int res;
        String content=null;
        class.forName("com.mysql.jdbc.Driver");
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM comment");
            rs=pr.executeQuery();
            while(rs.next()){
                commentid=rs.getInt(1);
                userid=rs.getInt(2);
                content=rs.getString(4);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1, String.valueOf(userid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    lastname=rs2.getString(1);
                    firstname=rs2.getString(2);
                    creatcommentpanel(commentid, lastname, firstname, content);
                }
                else{
                    System.out.println("ereur user id or statement");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    void creatpanel(int podid,String podtitle,String podaut,byte [] img){
        JPanel podcastpanel= new JPanel();
        JLabel labelimgpod = new JLabel();
        JLabel labeltitle = new JLabel();
        JLabel labelaut = new JLabel();
        JLabel deletlab = new JLabel();
        ImageIcon im;
        
        podcastpanel.setBackground(new java.awt.Color(255, 255, 255));

        labelimgpod.setPreferredSize(new java.awt.Dimension(38, 16));
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(188, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimgpod.setIcon(im);
        

        labeltitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);

        labelaut.setBackground(new java.awt.Color(255, 255, 255));
        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelaut.setForeground(new java.awt.Color(153, 153, 153));
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);

        deletlab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletlab.setForeground(new java.awt.Color(255, 0, 0));
        deletlab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletlab.setText("Delete");
        deletlab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));
        deletlab.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                  int rese=JOptionPane.showConfirmDialog(null, "Are you sure to delete this podcast ?", "Delting podcast", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(rese==JOptionPane.YES_OPTION){
                  Connection cn; 
                PreparedStatement pr;
                ResultSet rs;
                int res;
                class.forName("com.mysql.jdbc.Driver");
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                    pr=cn.prepareStatement("DELETE FROM podcast WHERE idpod=?");
                    pr.setString(1,String.valueOf(podid) );
                    res=pr.executeUpdate();
                    if(res >0){
                        System.out.println("deleted with sucseess");
                        ResultSet rs2;
                        panelPodcats.removeAll();
                        panelPodcats.setVisible(false);
                        pr=cn.prepareStatement("SELECT * FROM podcast");
                        rs=pr.executeQuery();
                         while(rs.next()){
                              int podidd=rs.getInt(1);
                              int userid=rs.getInt(2);
                              String podtitlee=rs.getString(3);
                              byte[] imgdd=rs.getBytes(5);
                              pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                              pr.setString(1,String.valueOf(userid));
                              rs2=pr.executeQuery();
                            if(rs2.next()){
                                String lastename=rs2.getString(1);
                                String firstname=rs2.getString(2);
                                String podaut=lastename+" "+firstname+" ";
                                creatpanel(podidd, podtitlee, podaut, imgdd);
                            }
                            else{
                                System.out.println("erreur user id podcast \n");
                            }
                           }
                         panelPodcats.setVisible(true);
                    }
                    else{
                        System.out.println("erreur during deleting");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deletlab.setBackground(Color.red);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                deletlab.setBackground(Color.white);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.red);
            }
        });

        javax.swing.GroupLayout podcastpanelLayout = new javax.swing.GroupLayout(podcastpanel);
        podcastpanel.setLayout(podcastpanelLayout);
        podcastpanelLayout.setHorizontalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletlab, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        podcastpanelLayout.setVerticalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelaut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletlab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelPodcats.add(podcastpanel);
    }
        void getpodcasts(){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        int podid;
        int userid;
        String lastename;
        String firstname;
        byte[] imgd=null;
        class.forName("com.mysql.jdbc.Driver");
        
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM podcast");
            rs=pr.executeQuery();
            while(rs.next()){
                podid=rs.getInt(1);
                userid=rs.getInt(2);
                podtitle=rs.getString(3);
                imgd=rs.getBytes(5);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1,String.valueOf(userid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    lastename=rs2.getString(1);
                    firstname=rs2.getString(2);
                    podaut=lastename+" "+firstname+" ";
                    creatpanel(podid, podtitle, podaut, imgd);
                }
                else{
                    System.out.println("erreur user id podcast \n");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menubarpanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        labellogout = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logopanel = new javax.swing.JPanel();
        labellogo = new javax.swing.JLabel();
        sidebarpanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelComments = new javax.swing.JLabel();
        labelPodcasts = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelPodcats = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelComments = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menubarpanel.setBackground(new java.awt.Color(233, 242, 245));
        menubarpanel.setPreferredSize(new java.awt.Dimension(185, 101));
        menubarpanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(233, 242, 245));
        jPanel4.setPreferredSize(new java.awt.Dimension(173, 102));

        labellogout.setBackground(new java.awt.Color(255, 255, 255));
        labellogout.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labellogout.setText(" Log out  ");
        labellogout.setOpaque(true);
        labellogout.setPreferredSize(new java.awt.Dimension(64, 25));
        labellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labellogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labellogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labellogoutMouseExited(evt);
            }
        });
        jPanel4.add(labellogout);

        jLabel2.setText("      ");
        jPanel4.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("admin    ");
        jPanel4.add(jLabel1);

        menubarpanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        logopanel.setBackground(new java.awt.Color(233, 242, 245));
        logopanel.setPreferredSize(new java.awt.Dimension(142, 101));
        logopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labellogo.setPreferredSize(new java.awt.Dimension(80, 80));
        logopanel.add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        menubarpanel.add(logopanel, java.awt.BorderLayout.LINE_START);

        getContentPane().add(menubarpanel, java.awt.BorderLayout.PAGE_START);

        sidebarpanel.setBackground(new java.awt.Color(233, 242, 245));
        sidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(233, 242, 245));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebarpanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 10, 40));

        jPanel7.setBackground(new java.awt.Color(123, 184, 241));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebarpanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 10, 40));

        labelComments.setBackground(new java.awt.Color(233, 242, 245));
        labelComments.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelComments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermometer.png"))); // NOI18N
        labelComments.setText("Comments");
        labelComments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCommentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCommentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCommentsMouseExited(evt);
            }
        });
        sidebarpanel.add(labelComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 140, 140, 40));

        labelPodcasts.setBackground(new java.awt.Color(233, 242, 245));
        labelPodcasts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPodcasts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Compass.png"))); // NOI18N
        labelPodcasts.setText("     Podcasts");
        labelPodcasts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseExited(evt);
            }
        });
        sidebarpanel.add(labelPodcasts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 40));

        getContentPane().add(sidebarpanel, java.awt.BorderLayout.LINE_START);

        jPanel9.setPreferredSize(new java.awt.Dimension(841, 413));
        jPanel9.setLayout(new java.awt.CardLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 1001));
        jScrollPane2.setViewportView(panelPodcats);

        panelPodcats.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelPodcats.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane2.setViewportView(panelPodcats);

        jPanel9.add(jScrollPane2, "card2");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane3.setViewportView(panelComments);

        panelComments.setBackground(new java.awt.Color(255, 255, 255));
        panelComments.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelComments.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane3.setViewportView(panelComments);

        jPanel9.add(jScrollPane3, "card3");

        getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelPodcastsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseEntered
        // TODO add your handling code here:
        labelPodcasts.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelPodcasts.setBackground(Color.decode("#BEFFFF"));
        labelPodcasts.setOpaque(true);
    }//GEN-LAST:event_labelPodcastsMouseEntered

    private void labelPodcastsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseExited
        // TODO add your handling code here:
        labelPodcasts.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         labelPodcasts.setBackground(Color.decode("#E9F2F5"));
         labelPodcasts.setOpaque(true);
    }//GEN-LAST:event_labelPodcastsMouseExited

    private void labelCommentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseEntered
        // TODO add your handling code here:
        labelComments.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelComments.setBackground(Color.decode("#BEFFFF"));
        labelComments.setOpaque(true);
    }//GEN-LAST:event_labelCommentsMouseEntered

    private void labelCommentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseExited
        // TODO add your handling code here:
        labelComments.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        labelComments.setBackground(Color.decode("#E9F2F5"));
        labelComments.setOpaque(true);
    }//GEN-LAST:event_labelCommentsMouseExited

    private void labelPodcastsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseClicked
        // TODO add your handling code here:
        jPanel7.setBackground(Color.decode("#7BB8F1"));
        jPanel6.setBackground(Color.decode("#E9F2F5"));
        panelComments.setVisible(false);
        jScrollPane3.setVisible(false);
        jScrollPane2.setVisible(true);
        panelPodcats.setVisible(true);
    }//GEN-LAST:event_labelPodcastsMouseClicked

    private void labelCommentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseClicked
        // TODO add your handling code here:
        jPanel6.setBackground(Color.decode("#7BB8F1"));
        jPanel7.setBackground(Color.decode("#E9F2F5"));
        panelPodcats.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane3.setVisible(true);
        panelComments.setVisible(true);
    }//GEN-LAST:event_labelCommentsMouseClicked

    private void labellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellogoutMouseEntered
        // TODO add your handling code here:
        labellogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labellogoutMouseEntered

    private void labellogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellogoutMouseExited
        // TODO add your handling code here:
        labellogout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labellogoutMouseExited

    private void labellogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellogoutMouseClicked
        // TODO add your handling code here:
        Userpodcasts userpod= new Userpodcasts();
        userpod.setVisible(true);
        dispose();
    }//GEN-LAST:event_labellogoutMouseClicked

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminpodcast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminpodcast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminpodcast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminpodcast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminpodcast().setVisible(true);
            }
        });
    }*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelComments;
    private javax.swing.JLabel labelPodcasts;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labellogout;
    private javax.swing.JPanel logopanel;
    private javax.swing.JPanel menubarpanel;
    private javax.swing.JPanel panelComments;
    private javax.swing.JPanel panelPodcats;
    private javax.swing.JPanel sidebarpanel;
    // End of variables declaration//GEN-END:variables
}
