
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
public class Audio {
    JLabel labeltime = new javax.swing.JLabel();
        JSlider progressbar = new javax.swing.JSlider();
        JProgressBar prog = new javax.swing.JProgressBar();
        AudioFormat formate;
        Clip clip;
        long framecont;
        double duratttion;
        boolean playiing=false;
        
        boolean ignoreStateChange=false;
        JPanel jPanel2=new JPanel();
                    JLabel labeltitleepo = new javax.swing.JLabel();
        JLabel labeltitlepod = new javax.swing.JLabel();
        JLabel labelname = new javax.swing.JLabel();
        JLabel labelplaypause = new javax.swing.JLabel();
        JLabel labeldis = new javax.swing.JLabel();
        JLabel labeladvanse = new javax.swing.JLabel();
       JLabel labelimg = new javax.swing.JLabel();
        JLabel labeldurattion = new javax.swing.JLabel();
       
        String path=null;
        String title=null;
        String lname;
        String fname;
        int podid;
        byte[] img;
        int minute;
        int seconde;
        
        
        public  Audio(String path,String title,int podid,byte[]img){
            this.path=path;
            this.title=title;
            this.podid=podid;
            this.img=img;

        }
        
         public void updateState(){
            ignoreStateChange=true;
            int frame=clip.getFramePosition();
            int progress=(int)(((double) frame) / (double) framecont * 100);
            progressbar.setValue(progress);
            prog.setValue(progress);
            double time=getCurrentTime();
            int min=(int) (time/60);
            int seco=(int) (time%60);
            labeltime.setText(""+min+":"+seco);
            ignoreStateChange=false;
        }
         
         
         
          public double getCurrentTime(){
            int currentframe=clip.getFramePosition();
            double time=(double)currentframe / formate.getFrameRate();
            return time;
        }
        
        public int getDesiredFrame(){
            int progress=progressbar.getValue();
            double frame = ((double) framecont * ((double) progress / 100.0));
            return (int) frame;
        }
        
        public  JPanel createpanele(String path){
            Timer playtimer;
                Timer delayedUpdate = new Timer(250,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int frame=getDesiredFrame();
                        clip.setFramePosition(frame);
                        double time= getCurrentTime();
                        int min=(int) (time/60);
                        int seco=(int) (time%60);
                        labeltime.setText(""+min+":"+seco);
                        
                    }
                    });
                ImageIcon im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(90, 110, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimg.setIcon(im);
               
                
                String podname=null;
                Connection cn;
                PreparedStatement pr;
                ResultSet rs;
                class.forName("com.mysql.jdbc.Driver");
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                    pr=cn.prepareStatement("SELECT iduser,titre FROM podcast WHERE idpod=?");
                    pr.setString(1, String.valueOf(podid));
                    rs=pr.executeQuery();
                    if(rs.next()){
                        int id=rs.getInt(1);
                        podname=rs.getString(2);
                        pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                        pr.setString(1, String.valueOf(id));
                        rs=pr.executeQuery();
                        if(rs.next()){
                            lname=rs.getString(1);
                             fname=rs.getString(2);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                }
                AudioInputStream ais=null;    
                File file= new File(path);
                
                try {
                    ais=AudioSystem.getAudioInputStream(file);
                    formate=ais.getFormat();
                    framecont=ais.getFrameLength();
                    duratttion=((double) framecont) / formate.getFrameRate();
                     minute=(int) (duratttion/60);
                    seconde=(int) (duratttion%60);
                    
                    try {
                        
                        clip=AudioSystem.getClip();
                        clip.open(ais);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                prog.setForeground(Color.blue);
                
                 progressbar.setValue(0);
                 progressbar.setForeground(Color.blue);
                 progressbar.setPaintTicks(true);
                labeltime.setText("0");
                
                playtimer = new Timer(100,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateState();
                    }
                    });
                
                
                    delayedUpdate.setRepeats(false);
                    
                    progressbar.addChangeListener(new ChangeListener(){
                         @Override
                            public void stateChanged(ChangeEvent e) {
                                if (ignoreStateChange) {
                                    return;
                                }
                                delayedUpdate.restart();
                            }
                    });
                    
                    
                     clip.addLineListener(new LineListener() {
                            @Override
                            public void update(LineEvent event) {
                                if (event.getType().equals(Window.Type.STOP)
                                                || event.getType().equals(Window.Type.CLOSE)) {
                                    labelplaypause.setVisible(false);
                                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));                   
                                     labelplaypause.setVisible(true);
                                    playiing = false;
                                    playtimer.stop();
                                    updateState();
                                }
                            }
            });
                    
                    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 145));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        
        jPanel2.add(labelimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, 90, 110));
        
        labeltitleepo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labeltitleepo.setText(title);
       jPanel2.add(labeltitleepo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 360, 30));

        labeltitlepod.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labeltitlepod.setText(podname);
        jPanel2.add(labeltitlepod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 290, 30));
        
        prog.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(prog, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1080, 10));
        
        labelname.setForeground(new java.awt.Color(51, 51, 51));
        labelname.setText("By "+lname+" "+fname);
        jPanel2.add(labelname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 210, -1));

        
        
        
        labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        labelplaypause.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
               
                if (playiing==false) {
                        int frame = getDesiredFrame();
                        if (frame >= framecont) {
                            frame = 0;
                        }
                        clip.setFramePosition(frame);
                        clip.start();
                          labelplaypause.setVisible(false);
                                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));                   
                                     labelplaypause.setVisible(true);
                        playiing = true;
                        playtimer.start();
                    } else {
                        clip.stop();
                          labelplaypause.setVisible(false);
                                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));                   
                                     labelplaypause.setVisible(true);
                        playiing = false;
                        playtimer.stop();
                    }
                }
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelplaypause.setCursor(new Cursor(Cursor.HAND_CURSOR));
                labelplaypause.setVisible(false);
                if(playiing){
                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pauseblack.png")));                   
                }
                else{
                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playblack.png")));                   
                }
                labelplaypause.setVisible(true);
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                labelplaypause.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                labelplaypause.setVisible(false);
                if(playiing){
                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));                   
                }
                else{
                    labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));                   
                }
                labelplaypause.setVisible(true);
            }
        });
        jPanel2.add(labelplaypause, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, 50));

        

        labeltime.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labeltime.setForeground(Color.black);
        labeltime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(labeltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 40, 90, 40));
        
        labeldurattion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labeldurattion.setForeground(Color.black);
        labeldurattion.setText("/ "+minute+":"+seconde+" min");
        jPanel2.add(labeldurattion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 90, 40));
        
       
        
        jPanel2.add(progressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        return jPanel2;
        }
        
        
        void close(){
            clip.close();
            clip.flush();
        }
        
                
}
