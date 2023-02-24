
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dell
 */
public class Userpodcasts extends javax.swing.JFrame {

    /**
     * Creates new form Userpodcasts
     */
    int userid=-1;
    int fist=0;
    int dis=0;
                String lastnameee=null;
                String firstnameee=null;
                String dateofbirthhh=null;
                String passw=null;
                String occupoo=null;
                String emailee=null;
                int sexee=0;
                int y=0;
                
                
                 JLabel labeltime = new javax.swing.JLabel();
        JSlider progressbar = new javax.swing.JSlider();
        JProgressBar prog = new javax.swing.JProgressBar();
        
        
        AudioFormat formate;
        Clip clip;
        long framecont;
        double duratttion;
        boolean playiing=false;
        
        boolean ignoreStateChange=false;
        
        Audio aud;
        
        
        
        
        
        
        
        public void updateState(){
            ignoreStateChange=true;
            int frame=clip.getFramePosition();
            int progress=(int)(((double) frame) / (double) framecont * 100);
            progressbar.setValue(progress);
            prog.setValue(progress);
            labeltime.setText(""+getCurrentTime());
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
                
                
    public Userpodcasts() {
        initComponents();
        labellogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(labellogo.getWidth(), labellogo.getHeight(), Image.SCALE_SMOOTH)));
        getpodcastexplore();
        jScrollPane3.setVisible(true);
        panelpodexpl.setVisible(true);
        panelpoddef.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
    }
    
    
    
    
     public class Editepisode extends javax.swing.JDialog{
         
         String ide;
         String title;
         String description;
         String path;
         String idp;
         
         
         ArrayList<Integer> first=new ArrayList<Integer>();
                   String durattion;
         javax.swing.JTextField episodetitle;
         javax.swing.JLabel erroraddepisode;
        javax.swing.JLabel errordescription;
        javax.swing.JLabel errorepisodetitle;
         javax.swing.JLabel errorpodcastchose;
         javax.swing.JPanel jPanel1;
         javax.swing.JScrollPane jScrollPane1;
        javax.swing.JSeparator jSeparator1;
         javax.swing.JLabel labeladdaudio;
         javax.swing.JLabel labelepisodepath;
         javax.swing.JLabel labellogoo;
         javax.swing.JLabel labelpodcastch;
         javax.swing.JLabel labelupload;
         javax.swing.JPanel panellogo;
         javax.swing.JComboBox<String> podcastchose;
         javax.swing.JTextArea textepisodedescription;
         JLabel labelsave = new JLabel();
         byte[]img;
         
         
         
         
         
         public Editepisode(java.awt.Frame parent, boolean modal,String idp,String ide,String title,String description,String path) {
            super(parent, modal);
            this.ide=ide;
            this.idp=idp;
            this.title=title;
            this.description=description;
            this.path=path;
            initComponent9();
            labellogoo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH)));

        }
         
         
         
         
         void initComponent9() {
            
            for(int i=0;i<2;i++){
                first.add(1);
            }
 
        panellogo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        episodetitle = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        erroraddepisode = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textepisodedescription = new javax.swing.JTextArea();
        errorepisodetitle = new javax.swing.JLabel();
        labeladdaudio = new javax.swing.JLabel();
        podcastchose = new javax.swing.JComboBox<>();
        errordescription = new javax.swing.JLabel();
        labelpodcastch = new javax.swing.JLabel();
        labelepisodepath = new javax.swing.JLabel();
        errorpodcastchose = new javax.swing.JLabel();
        labelsave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panellogo.setBackground(new java.awt.Color(233, 242, 245));
        panellogo.setPreferredSize(new java.awt.Dimension(800, 101));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 170, 80));

        getContentPane().add(panellogo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 601));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        episodetitle.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        episodetitle.setForeground(Color.black);
        episodetitle.setText(title);
        episodetitle.setBorder(null);
        episodetitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errorepisodetitle.setText("");
                    if(first.get(0)==0){
                    episodetitle.setText("");
                    episodetitle.setForeground(Color.black);
                    first.set(0, 1);
                    }
                
            }
        });
        jPanel1.add(episodetitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 420, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 420, 10));

        erroraddepisode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        erroraddepisode.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(erroraddepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 430, 30));

        textepisodedescription.setColumns(20);
        textepisodedescription.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textepisodedescription.setForeground(Color.black);
        textepisodedescription.setRows(5);
        textepisodedescription.setText(description);
        textepisodedescription.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errordescription.setText("");
                    if(first.get(1)==0){
                    textepisodedescription.setText("");
                    textepisodedescription.setForeground(Color.black);
                    first.set(1, 1);
                    }
                
            }
        });
        jScrollPane1.setViewportView(textepisodedescription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 420, 120));

        errorepisodetitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errorepisodetitle.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorepisodetitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 420, 30));

        labeladdaudio.setBackground(new java.awt.Color(238, 238, 238));
        labeladdaudio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeladdaudio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeladdaudio.setText("Add episode audio");
        labeladdaudio.setOpaque(true);
        
        labeladdaudio.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                labeladdaudio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                File f=null;
                JFileChooser filechose= new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV","wav");
                filechose.addChoosableFileFilter(filter);
                int res=filechose.showOpenDialog(null);
                if(res==JFileChooser.APPROVE_OPTION){
                    f=filechose.getSelectedFile();
                    labelepisodepath.setText(f.getAbsolutePath());
                    
                }
            }
            
            
            @Override
            public void mouseExited(MouseEvent evt){
                labeladdaudio.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        
        jPanel1.add(labeladdaudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 160, 40));

        podcastchose.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        podcastchose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        
        Connection cn;
        PreparedStatement pr;
        ResultSet rs;
        class.forName("com.mysql.jdbc.Driver");
        podcastchose.removeAllItems();
            try {
                cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                pr=cn.prepareStatement("SELECT idpod,titre,image FROM podcast WHERE iduser=?");
                pr.setString(1, String.valueOf(userid));
                rs=pr.executeQuery();
                while(rs.next()){
                    podcastchose.addItem(rs.getString(1)+"- "+rs.getString(2));
                    img=rs.getBytes(3);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        jPanel1.add(podcastchose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 240, 30));

        errordescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errordescription.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errordescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 420, 30));

        labelpodcastch.setBackground(new java.awt.Color(238, 238, 238));
        labelpodcastch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelpodcastch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelpodcastch.setText("Podcast channel");
        labelpodcastch.setOpaque(true);
        jPanel1.add(labelpodcastch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 326, 150, 40));

        labelepisodepath.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labelepisodepath.setForeground(new java.awt.Color(102, 102, 102));
        labelepisodepath.setText(path);
        jPanel1.add(labelepisodepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 436, 250, 30));

        errorpodcastchose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errorpodcastchose.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorpodcastchose, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 430, 30));

        labelsave.setBackground(new java.awt.Color(55, 115, 228));
        labelsave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelsave.setForeground(new java.awt.Color(255, 255, 255));
        labelsave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelsave.setText("Save");
        labelsave.setOpaque(true);
        
        labelsave.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                boolean title=false;
                boolean description=false;
                boolean addepisodeaudio=false;
                if(episodetitle.getText().equals("") || episodetitle.getText().equals("Episode title")){
                    title=false;
                    errorepisodetitle.setText("Error Episode title is required");
                }
                else{
                    title=true;
                }
                
                if(textepisodedescription.getText().equals("") || textepisodedescription.getText().contains("Episode description") ){
                    description=false;
                    errordescription.setText("Error Episode description is required");
                }
                else{
                    description=true;
                }
                
                if(labelepisodepath.getText().equals("Episode audio path")){
                    addepisodeaudio=false;
                    erroraddepisode.setText("Error podcast image is required");
                }
                else{
                    addepisodeaudio=true;
                    File f=new File(labelepisodepath.getText());
                InputStream ff;
                    try {
                         ff=new FileInputStream(f);
                         InputStream buffred= new BufferedInputStream(ff);
                        AudioInputStream audioinput=AudioSystem.getAudioInputStream(buffred);
                        AudioFormat format= audioinput.getFormat();
                        long length=f.length();
                        long framesize=audioinput.getFrameLength();
                        float framerate=format.getFrameRate();
                        double duratt= (((double)framesize) / framerate);
                        int min=(int) (duratt/60);
                        int secend= (int) (duratt%60);
                        durattion=""+min+":"+secend+" min";
                        
                    } catch (UnsupportedAudioFileException | IOException ex ) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                if(title && description && addepisodeaudio){
                    Connection cn;
                    PreparedStatement pr;
                    int rs;
                    class.forName("com.mysql.jdbc.Driver");
                    
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("UPDATE episode SET idpod=?, title=?,description=?,lenght=?,path=? WHERE idepisode=?");
                       
                        String pod=null;
                        int i;
                        pod=podcastchose.getSelectedItem().toString();
                        for(i=0;i<pod.length();i++){
                            if(pod.charAt(i)=='-')
                                break;
                        }
                        pod=pod.substring(0, i);
                        pr.setString(1,pod);
                         pr.setString(2,episodetitle.getText());
                        pr.setString(3,textepisodedescription.getText());
                        pr.setString(4,durattion);
                        pr.setString(5,labelepisodepath.getText());
                        pr.setString(6,ide);
                        rs=pr.executeUpdate();
                        if(rs>0){
                            JOptionPane.showMessageDialog(null, "Your Episode was modified  successfuly");
                            jScrollPane4.setVisible(false);
                            panelpoddef.setVisible(false);
                            panelpoddefsouht.removeAll();
                            getepisodes(Integer.parseInt(idp), 1,img);
                            jScrollPane4.setVisible(true);
                            panelpoddef.setVisible(true);
                            dispose();
                        }
                        else{
                            System.out.println("erreur updating episode \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelsave.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                labelsave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        
        jPanel1.add(labelsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 150, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
         
         
     }
    
    
    
    
    
    
    public class Upload extends javax.swing.JDialog{
        
        ArrayList<Integer> first=new ArrayList<Integer>();
                   String durattion;
         javax.swing.JTextField episodetitle;
         javax.swing.JLabel erroraddepisode;
        javax.swing.JLabel errordescription;
        javax.swing.JLabel errorepisodetitle;
         javax.swing.JLabel errorpodcastchose;
         javax.swing.JPanel jPanel1;
         javax.swing.JScrollPane jScrollPane1;
        javax.swing.JSeparator jSeparator1;
         javax.swing.JLabel labeladdaudio;
         javax.swing.JLabel labelepisodepath;
         javax.swing.JLabel labellogoo;
         javax.swing.JLabel labelpodcastch;
         javax.swing.JLabel labelupload;
         javax.swing.JPanel panellogo;
         javax.swing.JComboBox<String> podcastchose;
         javax.swing.JTextArea textepisodedescription;
        
        
        
        public Upload(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponent8();
            labellogoo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH)));
        }
        
        
        void initComponent8() {
            
            for(int i=0;i<2;i++){
                first.add(0);
            }
 
        panellogo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        episodetitle = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        erroraddepisode = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textepisodedescription = new javax.swing.JTextArea();
        errorepisodetitle = new javax.swing.JLabel();
        labeladdaudio = new javax.swing.JLabel();
        podcastchose = new javax.swing.JComboBox<>();
        errordescription = new javax.swing.JLabel();
        labelpodcastch = new javax.swing.JLabel();
        labelepisodepath = new javax.swing.JLabel();
        errorpodcastchose = new javax.swing.JLabel();
        labelupload = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panellogo.setBackground(new java.awt.Color(233, 242, 245));
        panellogo.setPreferredSize(new java.awt.Dimension(800, 101));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 170, 80));

        getContentPane().add(panellogo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 601));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        episodetitle.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        episodetitle.setForeground(new java.awt.Color(153, 153, 153));
        episodetitle.setText("Episode title");
        episodetitle.setBorder(null);
        episodetitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errorepisodetitle.setText("");
                    if(first.get(0)==0){
                    episodetitle.setText("");
                    episodetitle.setForeground(Color.black);
                    first.set(0, 1);
                    }
                
            }
        });
        jPanel1.add(episodetitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 420, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 420, 10));

        erroraddepisode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        erroraddepisode.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(erroraddepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 430, 30));

        textepisodedescription.setColumns(20);
        textepisodedescription.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textepisodedescription.setForeground(new java.awt.Color(153, 153, 153));
        textepisodedescription.setRows(5);
        textepisodedescription.setText(" Episode description");
        textepisodedescription.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errordescription.setText("");
                    if(first.get(1)==0){
                    textepisodedescription.setText("");
                    textepisodedescription.setForeground(Color.black);
                    first.set(1, 1);
                    }
                
            }
        });
        jScrollPane1.setViewportView(textepisodedescription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 420, 120));

        errorepisodetitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errorepisodetitle.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorepisodetitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 420, 30));

        labeladdaudio.setBackground(new java.awt.Color(238, 238, 238));
        labeladdaudio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeladdaudio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeladdaudio.setText("Add episode audio");
        labeladdaudio.setOpaque(true);
        
        labeladdaudio.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                labeladdaudio.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                File f=null;
                InputStream ff;
                JFileChooser filechose= new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV","wav");
                filechose.addChoosableFileFilter(filter);
                int res=filechose.showOpenDialog(null);
                if(res==JFileChooser.APPROVE_OPTION){
                    f=filechose.getSelectedFile();
                    labelepisodepath.setText(f.getAbsolutePath());
                    try {
                         ff=new FileInputStream(f);
                         InputStream buffred= new BufferedInputStream(ff);
                        AudioInputStream audioinput=AudioSystem.getAudioInputStream(buffred);
                        AudioFormat format= audioinput.getFormat();
                        long length=f.length();
                        long framesize=audioinput.getFrameLength();
                        float framerate=format.getFrameRate();
                        double duratt= (((double)framesize) / framerate);
                        int min=(int) (duratt/60);
                        int secend= (int) (duratt%60);
                        durattion=""+min+":"+secend+" min";
                        
                    } catch (UnsupportedAudioFileException | IOException ex ) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
            @Override
            public void mouseExited(MouseEvent evt){
                labeladdaudio.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        
        jPanel1.add(labeladdaudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 160, 40));

        podcastchose.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        podcastchose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        
        Connection cn;
        PreparedStatement pr;
        ResultSet rs;
        class.forName("com.mysql.jdbc.Driver");
        podcastchose.removeAllItems();
            try {
                cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                pr=cn.prepareStatement("SELECT idpod,titre FROM podcast WHERE iduser=?");
                pr.setString(1, String.valueOf(userid));
                rs=pr.executeQuery();
                while(rs.next()){
                    podcastchose.addItem(rs.getString(1)+"- "+rs.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        jPanel1.add(podcastchose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 240, 30));

        errordescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errordescription.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errordescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 420, 30));

        labelpodcastch.setBackground(new java.awt.Color(238, 238, 238));
        labelpodcastch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelpodcastch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelpodcastch.setText("Podcast channel");
        labelpodcastch.setOpaque(true);
        jPanel1.add(labelpodcastch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 326, 150, 40));

        labelepisodepath.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labelepisodepath.setForeground(new java.awt.Color(102, 102, 102));
        labelepisodepath.setText("Episode audio path");
        jPanel1.add(labelepisodepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 436, 250, 30));

        errorpodcastchose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        errorpodcastchose.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errorpodcastchose, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 430, 30));

        labelupload.setBackground(new java.awt.Color(55, 115, 228));
        labelupload.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelupload.setForeground(new java.awt.Color(255, 255, 255));
        labelupload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelupload.setText("Upload");
        labelupload.setOpaque(true);
        
        labelupload.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                boolean title=false;
                boolean description=false;
                boolean addepisodeaudio=false;
                if(episodetitle.getText().equals("") || episodetitle.getText().equals("Episode title")){
                    title=false;
                    errorepisodetitle.setText("Error Episode title is required");
                }
                else{
                    title=true;
                }
                
                if(textepisodedescription.getText().equals("") || textepisodedescription.getText().contains("Episode description") ){
                    description=false;
                    errordescription.setText("Error Episode description is required");
                }
                else{
                    description=true;
                }
                
                if(labelepisodepath.getText().equals("Episode audio path")){
                    addepisodeaudio=false;
                    erroraddepisode.setText("Error podcast image is required");
                }
                else{
                    addepisodeaudio=true;
                }
                
                
                if(title && description && addepisodeaudio){
                    Connection cn;
                    PreparedStatement pr;
                    int rs;
                    class.forName("com.mysql.jdbc.Driver");
                    
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("INSERT INTO episode (idpod,iduser,title,description,lenght,path) VALUES (?,?,?,?,?,?)");
                        String pod=null;
                        int i;
                        pod=podcastchose.getSelectedItem().toString();
                        for(i=0;i<pod.length();i++){
                            if(pod.charAt(i)=='-')
                                break;
                        }
                        pod=pod.substring(0, i);
                        pr.setString(1,pod);
                        pr.setString(2, String.valueOf(userid));
                        pr.setString(3, episodetitle.getText());
                        pr.setString(4,textepisodedescription.getText());
                        pr.setString(5,durattion);
                        pr.setString(6,labelepisodepath.getText());
                        rs=pr.executeUpdate();
                        if(rs>0){
                            JOptionPane.showMessageDialog(null, "Your Episode was uploaded  successfuly");
                            dispose();
                        }
                        else{
                            System.out.println("erreur inserting episode \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelupload.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                labelupload.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        
        jPanel1.add(labelupload, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 150, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
        
        
        
        
    }
    
    
    
    
    
    public class Editpodcast extends javax.swing.JDialog{
        
        
        ArrayList<Integer> first=new ArrayList<Integer>();
        javax.swing.JPanel jPanel1;
             javax.swing.JScrollPane jScrollPane1;
            javax.swing.JSeparator jSeparator1;
             javax.swing.JLabel labeladdimage;
             javax.swing.JLabel labelsave;
             javax.swing.JLabel labelimagepath;
             javax.swing.JLabel labellogoo;
            javax.swing.JTextField labeltitle;
             javax.swing.JPanel panellogo;
             javax.swing.JTextArea textdexription;
               javax.swing.JLabel erroraddimage;
               javax.swing.JLabel errordescription1;
               javax.swing.JLabel errortitle1;
               InputStream img;
               byte[]imgg;
               String podtitle=null;
               String poddescription=null;
               int podid=-1;
               String imagepath=null;
        
        
        
        
        public Editpodcast(java.awt.Frame parent, boolean modal,int podid,String podtitle,String poddescription) {
            super(parent, modal);
            this.podid=podid;
            this.podtitle=podtitle;
            this.poddescription=poddescription;
            initComponent7();
            labellogoo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
        }
        
      void initComponent7(){
        for(int i=0;i<2;i++){
                first.add(1);
            }
        panellogo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labeltitle = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textdexription = new javax.swing.JTextArea();
        labeladdimage = new javax.swing.JLabel();
        labelimagepath = new javax.swing.JLabel();
        labelsave = new javax.swing.JLabel();
        erroraddimage = new javax.swing.JLabel();
        errortitle1 = new javax.swing.JLabel();
        errordescription1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panellogo.setBackground(new java.awt.Color(233, 242, 245));
        panellogo.setPreferredSize(new java.awt.Dimension(800, 121));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 6, 200, 100));

        getContentPane().add(panellogo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 581));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        labeltitle.setFont(new java.awt.Font("Segoe UI", 0, 15));
        labeltitle.setForeground(Color.black);
        labeltitle.setText(podtitle);
        labeltitle.setBorder(null);
        labeltitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errortitle1.setText("");
                    if(first.get(0)==0){
                    labeltitle.setText("");
                    labeltitle.setForeground(Color.black);
                    first.set(0, 1);
                    }
                
            }
        });
        jPanel1.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 420, 50));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 420, 20));
        
        errortitle1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        errortitle1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errortitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 420, 20));
        
        textdexription.setColumns(20);
        textdexription.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textdexription.setForeground(Color.black);
        textdexription.setRows(5);
        textdexription.setText(poddescription);
        textdexription.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errordescription1.setText("");
                    if(first.get(1)==0){
                    textdexription.setText("");
                    textdexription.setForeground(Color.black);
                    first.set(1, 1);
                    }
                
            }
        });
        
        jScrollPane1.setViewportView(textdexription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 420, 140));
        
        errordescription1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        errordescription1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errordescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 420, 20));
        
        labeladdimage.setBackground(new java.awt.Color(238, 238, 238));
        labeladdimage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeladdimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeladdimage.setText("Add image");
        labeladdimage.setOpaque(true);
        labeladdimage.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                labeladdimage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                File f=null;
                JFileChooser filechose= new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG JPEG","png","jpg","jpeg");
                filechose.addChoosableFileFilter(filter);
                int res=filechose.showOpenDialog(null);
                if(res==JFileChooser.APPROVE_OPTION){
                    f=filechose.getSelectedFile();
                    labelimagepath.setText(f.getAbsolutePath());
                    try {
                        img=new FileInputStream(f);
                        try {
                            imgg=img.readAllBytes();
                        } catch (IOException ex) {
                            Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
            @Override
            public void mouseExited(MouseEvent evt){
                labeladdimage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        jPanel1.add(labeladdimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 386, 150, 40));

        labelimagepath.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelimagepath.setForeground(new Color(102,102,102));
        labelimagepath.setText("Image path");
        jPanel1.add(labelimagepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 386, 390, 40));
        
        erroraddimage.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        erroraddimage.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(erroraddimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 420, 20));
        
        labelsave.setBackground(new java.awt.Color(55, 115, 228));
        labelsave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelsave.setForeground(new java.awt.Color(255, 255, 255));
        labelsave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelsave.setText("Save");
        labelsave.setOpaque(true);
        labelsave.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                boolean title=false;
                boolean description=false;
                boolean addimage=false;
                if(labeltitle.getText().equals("") || labeltitle.getText().equals("Podcast title")){
                    title=false;
                    errortitle1.setText("Error podcast title is required");
                }
                else{
                    title=true;
                }
                
                if(textdexription.getText().equals("") || textdexription.getText().contains("Podcast description") ){
                    description=false;
                    errordescription1.setText("Error podcast description is required");
                }
                else{
                    description=true;
                }
                
                if(labelimagepath.getText().equals("Image path")){
                    addimage=false;
                    erroraddimage.setText("Error podcast image is required");
                }
                else{
                    addimage=true;
                }
                
                if(title && description && addimage){
                    Connection cn;
                    PreparedStatement pr;
                    int rs;
                    class.forName("com.mysql.jdbc.Driver");
                    
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("UPDATE podcast SET titre=?,description=?,image=? WHERE idpod=?");
                        pr.setString(1, labeltitle.getText());
                        pr.setString(2,textdexription.getText());
                        pr.setBytes(3, imgg);
                        pr.setString(4, String.valueOf(podid));
                        rs=pr.executeUpdate();
                        if(rs>0){
                            JOptionPane.showMessageDialog(null, "Your podcast was modified sucssufuly");
                             panelpodexpl.setVisible(false);
                                jScrollPane3.setVisible(false);
                                jScrollPane2.setVisible(false);
                                panelsubscribtion.setVisible(false);
                                jScrollPane5.setVisible(false);
                                panelmypodcast.setVisible(false);
                                jScrollPane6.setVisible(false);
                                panelrecherche.setVisible(false);
                                jScrollPane4.setVisible(false);
                                panelpoddef.setVisible(false);
                                panelpoddefnorth.removeAll();
                                panelpoddefsouht.removeAll();
                                if(userid>-1){
                                    creatpanelpoddefinition(podid, imgg, labeltitle.getText(), lastnameee+" "+firstnameee+" ",textdexription.getText(), -1);
                                    getepisodes(podid,1,imgg);
                                }
                                else{
                                    creatpanelpoddefinition(podid, imgg, labeltitle.getText(),lastnameee+" "+firstnameee+" ", textdexription.getText(), 0);
                                    getepisodes(podid,0,imgg);
                                }

                                jScrollPane4.setVisible(true);
                                panelpoddef.setVisible(true);
                            
                            dispose();
                        }
                        else{
                            System.out.println("erreur inserting podcast \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelsave.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                labelsave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        jPanel1.add(labelsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 260, 50));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
        
    }
    
    
    
    
    public class Creatpod extends javax.swing.JDialog{
        
        ArrayList<Integer> first=new ArrayList<Integer>();
        javax.swing.JPanel jPanel1;
             javax.swing.JScrollPane jScrollPane1;
            javax.swing.JSeparator jSeparator1;
             javax.swing.JLabel labeladdimage;
             javax.swing.JLabel labelcreate;
             javax.swing.JLabel labelimagepath;
             javax.swing.JLabel labellogoo;
            javax.swing.JTextField labeltitle;
             javax.swing.JPanel panellogo;
             javax.swing.JTextArea textdexription;
               javax.swing.JLabel erroraddimage;
               javax.swing.JLabel errordescription1;
               javax.swing.JLabel errortitle1;
               InputStream img;
        
        
        public Creatpod(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponent6();
            labellogoo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
        }
        
        
        void initComponent6() {
            
            for(int i=0;i<2;i++){
                first.add(0);
            }
        panellogo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labeltitle = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textdexription = new javax.swing.JTextArea();
        labeladdimage = new javax.swing.JLabel();
        labelimagepath = new javax.swing.JLabel();
        labelcreate = new javax.swing.JLabel();
        erroraddimage = new javax.swing.JLabel();
        errortitle1 = new javax.swing.JLabel();
        errordescription1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panellogo.setBackground(new java.awt.Color(233, 242, 245));
        panellogo.setPreferredSize(new java.awt.Dimension(800, 121));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 6, 200, 100));

        getContentPane().add(panellogo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 581));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        labeltitle.setFont(new java.awt.Font("Segoe UI", 0, 15));
        labeltitle.setForeground(new java.awt.Color(153, 153, 153));
        labeltitle.setText("Podcast title");
        labeltitle.setBorder(null);
        labeltitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errortitle1.setText("");
                    if(first.get(0)==0){
                    labeltitle.setText("");
                    labeltitle.setForeground(Color.black);
                    first.set(0, 1);
                    }
                
            }
        });
        jPanel1.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 420, 50));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 420, 20));
        
        errortitle1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        errortitle1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errortitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 420, 20));
        
        textdexription.setColumns(20);
        textdexription.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textdexription.setForeground(new java.awt.Color(153, 153, 153));
        textdexription.setRows(5);
        textdexription.setText("  Podcast description");
        textdexription.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                    errordescription1.setText("");
                    if(first.get(1)==0){
                    textdexription.setText("");
                    textdexription.setForeground(Color.black);
                    first.set(1, 1);
                    }
                
            }
        });
        
        jScrollPane1.setViewportView(textdexription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 420, 140));
        
        errordescription1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        errordescription1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(errordescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 420, 20));
        
        labeladdimage.setBackground(new java.awt.Color(238, 238, 238));
        labeladdimage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeladdimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeladdimage.setText("Add image");
        labeladdimage.setOpaque(true);
        labeladdimage.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                labeladdimage.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                File f=null;
                JFileChooser filechose= new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG JPG JPEG","png","jpg","jpeg");
                filechose.addChoosableFileFilter(filter);
                int res=filechose.showOpenDialog(null);
                if(res==JFileChooser.APPROVE_OPTION){
                    f=filechose.getSelectedFile();
                    labelimagepath.setText(f.getAbsolutePath());
                    try {
                        img=new FileInputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
            @Override
            public void mouseExited(MouseEvent evt){
                labeladdimage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        jPanel1.add(labeladdimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 386, 150, 40));

        labelimagepath.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelimagepath.setForeground(new java.awt.Color(102, 102, 102));
        labelimagepath.setText("Image path");
        jPanel1.add(labelimagepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 386, 390, 40));
        
        erroraddimage.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        erroraddimage.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(erroraddimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 420, 20));
        
        labelcreate.setBackground(new java.awt.Color(55, 115, 228));
        labelcreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelcreate.setForeground(new java.awt.Color(255, 255, 255));
        labelcreate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcreate.setText("Create");
        labelcreate.setOpaque(true);
        labelcreate.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                boolean title=false;
                boolean description=false;
                boolean addimage=false;
                if(labeltitle.getText().equals("") || labeltitle.getText().equals("Podcast title")){
                    title=false;
                    errortitle1.setText("Error podcast title is required");
                }
                else{
                    title=true;
                }
                
                if(textdexription.getText().equals("") || textdexription.getText().contains("Podcast description") ){
                    description=false;
                    errordescription1.setText("Error podcast description is required");
                }
                else{
                    description=true;
                }
                
                if(labelimagepath.getText().equals("Image path")){
                    addimage=false;
                    erroraddimage.setText("Error podcast image is required");
                }
                else{
                    addimage=true;
                }
                
                if(title && description && addimage){
                    Connection cn;
                    PreparedStatement pr;
                    int rs;
                    class.forName("com.mysql.jdbc.Driver");
                    
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("INSERT INTO podcast (iduser,titre,description,image) VALUES(?,?,?,?)");
                        pr.setString(1,String.valueOf(userid));
                        pr.setString(2, labeltitle.getText());
                        pr.setString(3,textdexription.getText());
                        pr.setBlob(4,img);
                        rs=pr.executeUpdate();
                        if(rs>0){
                            JOptionPane.showMessageDialog(null, "Your podcast was created sucssufuly");
                            jPanel8.setBackground(Color.decode("#E9F2F5"));
                            jPanel10.setBackground(Color.decode("#E9F2F5"));
                            jPanel9.setBackground(Color.decode("#7BB8F1"));
                            jScrollPane3.setVisible(false);
                            panelpodexpl.setVisible(false);
                            jScrollPane4.setVisible(false);
                            panelpoddef.setVisible(false);
                            jScrollPane2.setVisible(false);
                            panelsubscribtion.setVisible(false);
                            jScrollPane6.setVisible(false);
                            panelrecherche.setVisible(false);
                            jScrollPane5.setVisible(false);
                            panelmypodcast.setVisible(false);
                            panelmypodcast.removeAll();
                            JPanel jPanel2=new JPanel();
                            JLabel jLabel1=new JLabel();
                            jPanel2.setBackground(new java.awt.Color(241, 241, 241));
                            jPanel2.setPreferredSize(new java.awt.Dimension(1074, 101));
                            jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                            jLabel1.setBackground(new java.awt.Color(241, 241, 241));
                            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel1.setText("Your Podcasts Channels");
                            jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 390, 40));
                            panelmypodcast.add(jPanel2);
                            getmypod(userid);
                            jScrollPane5.setVisible(true);
                            panelmypodcast.setVisible(true);
                            
                            dispose();
                        }
                        else{
                            System.out.println("erreur inserting podcast \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelcreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                labelcreate.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
        });
        jPanel1.add(labelcreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 260, 50));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
        
    }
    
    
    
    
    public class Editprofile extends javax.swing.JDialog{
        String lastnamee;
        String firstnamee;
        String emaile;
        String dateofbirthh;
        String passwordd;
        String occupationo;
        
        ArrayList<Integer> first=new ArrayList<Integer>();
                
                 javax.swing.ButtonGroup buttonGroup1;
                 javax.swing.JTextField dateofbirth;
                 javax.swing.JTextField email;
                 javax.swing.JLabel errordate;
                 javax.swing.JLabel erroremail1;
                 javax.swing.JLabel errorpassword;
                 javax.swing.JTextField firstname;
                 javax.swing.JLabel jLabel1;
                javax.swing.JPanel jPanel2;
                javax.swing.JSeparator jSeparator1;
                 javax.swing.JSeparator jSeparator2;
                javax.swing.JSeparator jSeparator3;
                javax.swing.JSeparator jSeparator4;
                 javax.swing.JSeparator jSeparator5;
                 javax.swing.JSeparator jSeparator6;
                 javax.swing.JLabel labellogooo;
                 javax.swing.JTextField lastname;
                javax.swing.JRadioButton men;
                 javax.swing.JTextField occupation;
                javax.swing.JPanel panellogooo;
                 javax.swing.JPasswordField password;
                 javax.swing.JLabel save;
                 javax.swing.JRadioButton women;
                  javax.swing.JLabel errorlastname1;
                 javax.swing.JLabel errorfirstname;
                   javax.swing.JLabel erroroccup;
                    javax.swing.JLabel errorsexe;

        
        int sexe;
         public Editprofile(java.awt.Frame parent, boolean modal,String lastname,String firstname,String email,String dateofbirth,String password,String occupation,int sexe) {
            super(parent, modal);
            this.lastnamee=lastname;
            this.firstnamee=firstname;
            this.emaile=email;
            this.dateofbirthh=dateofbirth;
            this.passwordd=password;
            this.occupationo=occupation;
            this.sexe=sexe;
            initComponent5();
             labellogooo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(180, 100, Image.SCALE_SMOOTH)));
        }
         
         
          void initComponent5() {
           for(int i=0;i<6;i++)
            first.add(0);
        
           buttonGroup1 = new javax.swing.ButtonGroup();
        panellogooo = new javax.swing.JPanel();
        labellogooo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        occupation = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lastname = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        dateofbirth = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        password = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        men = new javax.swing.JRadioButton();
        women = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        errordate = new javax.swing.JLabel();
        errorpassword = new javax.swing.JLabel();
        erroremail1 = new javax.swing.JLabel();
        errorlastname1 = new javax.swing.JLabel();
        errorfirstname = new javax.swing.JLabel();
         erroroccup = new javax.swing.JLabel();
         errorsexe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 870));

        panellogooo.setBackground(new java.awt.Color(233, 242, 245));
        panellogooo.setPreferredSize(new java.awt.Dimension(800, 126));
        panellogooo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogooo.add(labellogooo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 180, 100));

        getContentPane().add(panellogooo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 576));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstname.setForeground(Color.black);
        firstname.setText(firstnamee);
        firstname.setBorder(null);
        firstname.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorfirstname.setText("");
                if(first.get(1)==0){
                    firstname.setText("");
                    firstname.setForeground(Color.black);
                    first.set(1, 1);
                }
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 270, 40));
        
        errorfirstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorfirstname.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errorfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 340, 40));
        
        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 270, 20));

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setForeground(Color.black);
        email.setText(emaile);
        email.setBorder(null);
        email.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                erroremail1.setText("");
                if(first.get(2)==0){
                    email.setText("");
                    email.setForeground(Color.black);
                    first.set(2, 1);
                }
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 270, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 270, 20));

        occupation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        occupation.setForeground(Color.black);
        occupation.setText(occupationo);
        occupation.setBorder(null);
        occupation.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                erroroccup.setText("");
                if(first.get(5)==0){
                    occupation.setText("");
                    occupation.setForeground(Color.black);
                    first.set(5, 1);
                }
            }
        });
        jPanel2.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 270, 40));
        
        erroroccup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        erroroccup.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(erroroccup, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 340, 40));
        
        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 270, 20));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastname.setForeground(Color.black);
        lastname.setText(lastnamee);
        lastname.setBorder(null);
        lastname.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorlastname1.setText("");
                if(first.get(0)==0){
                    lastname.setText("");
                    lastname.setForeground(Color.black);
                    first.set(0, 1);
                }
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 40));
        
        errorlastname1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorlastname1.setForeground(new java.awt.Color(255, 0, 0));
       jPanel2.add(errorlastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 370, 40));
        
        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 20));

        dateofbirth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateofbirth.setForeground(Color.black);
        dateofbirth.setText(dateofbirthh);
        dateofbirth.setBorder(null);
        dateofbirth.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errordate.setText("");
                if(first.get(3)==0){
                    dateofbirth.setText("");
                    dateofbirth.setForeground(Color.black);
                    first.set(3, 1);
                }
            }
        });
        jPanel2.add(dateofbirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 270, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 270, 20));

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("Password");
        password.setBorder(null);
        password.setEchoChar((char)0);
        password.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorpassword.setForeground(Color.black);
                errorpassword.setText("your password must not exeed 8 caractere");
                password.setEchoChar('*');
                if(first.get(4)==0){
                    password.setText("");
                    password.setForeground(Color.black);
                    first.set(4, 1);
                }
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 312, 270, 40));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 270, 20));

        buttonGroup1.add(men);
        men.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        men.setText("Men");
        if(sexe==1)
            men.setSelected(true);
        men.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorsexe.setText("");
            }
        });
        jPanel2.add(men, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        buttonGroup1.add(women);
        women.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        women.setText("Women");
        if(sexe==0)
            women.setSelected(true);
        women.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorsexe.setText("");
            }
        });
        jPanel2.add(women, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Sexe    :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 60, 40));
        
        errorsexe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorsexe.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errorsexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 400, 40));
        
        save.setBackground(new java.awt.Color(55, 115, 228));
        save.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Save");
        save.setOpaque(true);
        save.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                save.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            
            @Override
            public void mouseClicked(MouseEvent evt){
                String regexemail="^(.+)@(.+)[.](.+)$";
                String regexdate="[0-9]{1,2}[/][0-9]{1,2}[/][0-9]{4}";
                Pattern pattern= Pattern.compile(regexemail);
                Pattern pattern2= Pattern.compile(regexdate);
                Matcher matcher=pattern.matcher(email.getText());
                Matcher matcher2= pattern2.matcher(dateofbirth.getText());
                String psw=new String(password.getPassword());
                boolean lastnamee;
                boolean firstnamee;
                boolean emaile=false;
                boolean date=false;
                boolean pasww=false;
                boolean occup=false;
                boolean sex=false;
                int sexx=0;
                
                if(lastname.getText().equals("Last name") || lastname.getText().equals("")){
                    lastnamee=false;
                    errorlastname1.setText("Error your Last name is required");
                }
                else{
                    lastnamee=true;
                }
                
                if(firstname.getText().equals("") || firstname.getText().equals("First name")){
                    firstnamee=false;
                    errorfirstname.setText("Error your First name is required");
                }
                else{
                    firstnamee=true;
                }
                if(occupation.getText().equals("") || occupation.getText().equals("Occupation")){
                    occup=false;
                    erroroccup.setText("Error your Occupation is required");
                }
                else{
                    occup=true;
                }
                
                if(matcher.matches()){
                    Connection cn;
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("SELECT email FROM user WHERE email=?");
                        pr.setString(1,email.getText());
                        rs=pr.executeQuery();
                        if(rs.next() && !rs.getString(1).equals(emailee)){
                            emaile=false;
                            erroremail1.setText("Error this rmail exist you must enter another email or Log in to your account");
                        }
                        else{
                            emaile=true;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    emaile=false;
                    erroremail1.setText("Error you must enter a valid email expression ");
                }
                
                if(matcher2.matches()){
                    date=true;
                }
                else{
                    date=false;
                    errordate.setText("Error you must enter a valid date like this dd/mm/yyyy");
                }
                
                if(psw.length()<=8 && psw.length()!=0 && !psw.equals("Password")){
                    pasww=true;
                }
                else{
                    pasww=false;
                    errorpassword.setForeground(Color.red);
                    errorpassword.setText("you must enter a password who don't exeed 8 caracter");
                }
                
                if(!men.isSelected()&& !women.isSelected()){
                    sex=false;
                    errorsexe.setText("Error you must select your sexe gender");
                }
                else{
                    sex=true;
                    if(men.isSelected()){
                        sexx=1;
                    }
                    else{
                        sexx=0;
                    }
                }
                
                if(lastnamee && firstnamee && emaile && date && pasww && occup && sex){
                    Connection cn;
                    PreparedStatement pr;
                    ResultSet rs;
                    int res;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("UPDATE user SET lastname=?,firstname=?,dateofbirth=?,email=?,password=?,occupation=?,sexe=? WHERE iduser=?");
                        pr.setString(1, lastname.getText());
                        pr.setString(2, firstname.getText());
                        pr.setString(3, dateofbirth.getText());
                        pr.setString(4, email.getText());
                        pr.setString(5, psw);
                        pr.setString(6, occupation.getText());
                        pr.setString(7, String.valueOf(sexx));
                        pr.setString(8,String.valueOf(userid));
                        res=pr.executeUpdate();
                        if(res>0){
                            JOptionPane.showMessageDialog(null, "Your Profile information was edited sucssefuly");
                            firstnameee=firstname.getText();
                            lastnameee=lastname.getText();
                            labellogin.setText(firstname.getText()+" ");
                            dispose();
                                    
                        }
                        else{
                            System.out.println("erreur inserting user register \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
            
             @Override
            public void mouseExited(MouseEvent evt){
                save.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 180, 40));

        errordate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errordate.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errordate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 340, 40));

        errorpassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorpassword.setForeground(new java.awt.Color(102, 102, 102));
        errorpassword.setText("your password must not exeed 8 caractere");
        jPanel2.add(errorpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 370, 40));

        erroremail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        erroremail1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(erroremail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 370, 40));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
         
    }
    
    
    
    
    public class Profile extends javax.swing.JDialog{
        
        javax.swing.ButtonGroup buttonGroup1;
                 javax.swing.JTextField dateofbirth;
                 javax.swing.JTextField email;
                 javax.swing.JTextField firstname;
                 javax.swing.JLabel jLabel1;
                javax.swing.JPanel jPanel2;
                javax.swing.JSeparator jSeparator1;
                 javax.swing.JSeparator jSeparator2;
                javax.swing.JSeparator jSeparator3;
                javax.swing.JSeparator jSeparator4;
                 javax.swing.JSeparator jSeparator5;
                 javax.swing.JLabel labellogoooo;
                 javax.swing.JTextField lastname;
                javax.swing.JRadioButton men;
                 javax.swing.JTextField occupation;
                javax.swing.JPanel panellogooo;
                 javax.swing.JLabel edit;
                 javax.swing.JRadioButton women;
        
        
        public Profile(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponent4();
             labellogoooo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(180, 100, Image.SCALE_SMOOTH)));
        }
        
        
        
        void initComponent4() {
            
            Connection cn;
            PreparedStatement pr;
            ResultSet rs;
            
        
           buttonGroup1 = new javax.swing.ButtonGroup();
        panellogooo = new javax.swing.JPanel();
        labellogoooo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        occupation = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lastname = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        dateofbirth = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        men = new javax.swing.JRadioButton();
        women = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        String psw=null;
        int sexe=0;


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 870));
        
        
        class.forName("com.mysql.jdbc.Driver");
            try {
                cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                pr=cn.prepareStatement("SELECT lastname,firstname,dateofbirth,email,password,occupation,sexe FROM user WHERE iduser=?");
                pr.setString(1, String.valueOf(userid));
                rs=pr.executeQuery();
                if(rs.next()){
                    lastname.setText(rs.getString(1));
                    firstname.setText(rs.getString(2));
                    dateofbirth.setText(rs.getString(3));
                    email.setText(rs.getString(4));
                    psw=rs.getString(5);
                    occupation.setText(rs.getString(6));
                    sexee=rs.getInt(7);
                    if(rs.getInt(7)==1){
                        men.setSelected(true);
                    }
                    else{
                        women.setSelected(true);
                    }
                    men.setEnabled(false);
                    women.setEnabled(false);
                }
                else{
                    System.out.println("erreur selecting data from user \n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
            }

        panellogooo.setBackground(new java.awt.Color(233, 242, 245));
        panellogooo.setPreferredSize(new java.awt.Dimension(800, 126));
        panellogooo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogooo.add(labellogoooo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 180, 100));

        getContentPane().add(panellogooo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 576));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstname.setForeground(Color.black);
        firstname.setEditable(false);
        firstname.setBorder(null);

        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 270, 40));
        

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 270, 20));

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setForeground(Color.black);
        email.setEditable(false);
        email.setBorder(null);

        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 270, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 270, 20));

        occupation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        occupation.setForeground(Color.black);
        occupation.setEditable(false);
        occupation.setBorder(null);

        jPanel2.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 312, 270, 40));
        
        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 270, 20));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastname.setForeground(Color.black);
        lastname.setEditable(false);
        lastname.setBorder(null);
 
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 40));
        
        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 20));

        dateofbirth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateofbirth.setForeground(Color.black);
        dateofbirth.setEditable(false);
        dateofbirth.setBorder(null);

        jPanel2.add(dateofbirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 270, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 270, 20));
        
        buttonGroup1.add(men);
        men.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        men.setText("Men");
        jPanel2.add(men, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        buttonGroup1.add(women);
        women.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        women.setText("Women");
        jPanel2.add(women, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Sexe    :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 60, 40));

        
                 lastnameee=lastname.getText();
                 firstnameee=firstname.getText();
                 dateofbirthhh=dateofbirth.getText();
                 passw=psw;
                 occupoo=occupation.getText();
                 emailee=email.getText();
        
        edit.setBackground(new java.awt.Color(55, 115, 228));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        edit.setText("           Edit your profile information");
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editw.png")));
        edit.setOpaque(true);
        edit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                
                    new Editprofile(null,true, lastnameee, firstnameee, emailee, dateofbirthhh,passw, occupoo, sexee).show();
                    dispose();
            }
            
             @Override
            public void mouseEntered(MouseEvent evt){
                edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
             @Override
            public void mouseExited(MouseEvent evt){
                edit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
            
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 250, 40));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        
        }
        
        
        
    }
    
    
    
    
    public class Register extends javax.swing.JDialog{
        
                ArrayList<Integer> first=new ArrayList<Integer>();
                
                 javax.swing.ButtonGroup buttonGroup1;
                 javax.swing.JTextField dateofbirth;
                 javax.swing.JTextField email;
                 javax.swing.JLabel errordate;
                 javax.swing.JLabel erroremail1;
                 javax.swing.JLabel errorpassword;
                 javax.swing.JTextField firstname;
                 javax.swing.JLabel jLabel1;
                javax.swing.JPanel jPanel2;
                javax.swing.JSeparator jSeparator1;
                 javax.swing.JSeparator jSeparator2;
                javax.swing.JSeparator jSeparator3;
                javax.swing.JSeparator jSeparator4;
                 javax.swing.JSeparator jSeparator5;
                 javax.swing.JSeparator jSeparator6;
                 javax.swing.JLabel labellogooo;
                 javax.swing.JTextField lastname;
                javax.swing.JRadioButton men;
                 javax.swing.JTextField occupation;
                javax.swing.JPanel panellogooo;
                 javax.swing.JPasswordField password;
                 javax.swing.JLabel signup;
                 javax.swing.JRadioButton women;
                  javax.swing.JLabel errorlastname1;
                 javax.swing.JLabel errorfirstname;
                   javax.swing.JLabel erroroccup;
                    javax.swing.JLabel errorsexe;

        
        
        public Register(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponent3();
             labellogooo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(180, 100, Image.SCALE_SMOOTH)));
        }
        
        
        void initComponent3() {
           for(int i=0;i<6;i++)
            first.add(0);
        
           buttonGroup1 = new javax.swing.ButtonGroup();
        panellogooo = new javax.swing.JPanel();
        labellogooo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        occupation = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lastname = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        dateofbirth = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        password = new javax.swing.JPasswordField();
        jSeparator6 = new javax.swing.JSeparator();
        men = new javax.swing.JRadioButton();
        women = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        signup = new javax.swing.JLabel();
        errordate = new javax.swing.JLabel();
        errorpassword = new javax.swing.JLabel();
        erroremail1 = new javax.swing.JLabel();
        errorlastname1 = new javax.swing.JLabel();
        errorfirstname = new javax.swing.JLabel();
         erroroccup = new javax.swing.JLabel();
         errorsexe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 870));

        panellogooo.setBackground(new java.awt.Color(233, 242, 245));
        panellogooo.setPreferredSize(new java.awt.Dimension(800, 126));
        panellogooo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogooo.add(labellogooo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 180, 100));

        getContentPane().add(panellogooo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 576));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstname.setForeground(new java.awt.Color(153, 153, 153));
        firstname.setText("First name");
        firstname.setBorder(null);
        firstname.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorfirstname.setText("");
                if(first.get(1)==0){
                    firstname.setText("");
                    firstname.setForeground(Color.black);
                    first.set(1, 1);
                }
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 270, 40));
        
        errorfirstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorfirstname.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errorfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 340, 40));
        
        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 270, 20));

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("Email");
        email.setBorder(null);
        email.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                erroremail1.setText("");
                if(first.get(2)==0){
                    email.setText("");
                    email.setForeground(Color.black);
                    first.set(2, 1);
                }
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 270, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 270, 20));

        occupation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        occupation.setForeground(new java.awt.Color(153, 153, 153));
        occupation.setText("Occupation");
        occupation.setBorder(null);
        occupation.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                erroroccup.setText("");
                if(first.get(5)==0){
                    occupation.setText("");
                    occupation.setForeground(Color.black);
                    first.set(5, 1);
                }
            }
        });
        jPanel2.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 270, 40));
        
        erroroccup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        erroroccup.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(erroroccup, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 340, 40));
        
        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 270, 20));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastname.setForeground(new java.awt.Color(153, 153, 153));
        lastname.setText("Last name");
        lastname.setBorder(null);
        lastname.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorlastname1.setText("");
                if(first.get(0)==0){
                    lastname.setText("");
                    lastname.setForeground(Color.black);
                    first.set(0, 1);
                }
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 40));
        
        errorlastname1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorlastname1.setForeground(new java.awt.Color(255, 0, 0));
       jPanel2.add(errorlastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 370, 40));
        
        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 20));

        dateofbirth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateofbirth.setForeground(new java.awt.Color(153, 153, 153));
        dateofbirth.setText("Date of birth dd/mm/yyyy");
        dateofbirth.setBorder(null);
        dateofbirth.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errordate.setText("");
                if(first.get(3)==0){
                    dateofbirth.setText("");
                    dateofbirth.setForeground(Color.black);
                    first.set(3, 1);
                }
            }
        });
        jPanel2.add(dateofbirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 270, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 270, 20));

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("Password");
        password.setBorder(null);
        password.setEchoChar((char)0);
        password.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorpassword.setForeground(Color.black);
                errorpassword.setText("your password must not exeed 8 caractere");
                password.setEchoChar('*');
                if(first.get(4)==0){
                    password.setText("");
                    password.setForeground(Color.black);
                    first.set(4, 1);
                }
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 312, 270, 40));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 270, 20));

        buttonGroup1.add(men);
        men.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        men.setText("Men");
        men.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorsexe.setText("");
            }
        });
        jPanel2.add(men, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        buttonGroup1.add(women);
        women.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        women.setText("Women");
        women.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                errorsexe.setText("");
            }
        });
        jPanel2.add(women, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Sexe    :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 60, 40));
        
        errorsexe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorsexe.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errorsexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 400, 40));
        
        signup.setBackground(new java.awt.Color(55, 115, 228));
        signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signup.setText("Sign up");
        signup.setOpaque(true);
        signup.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            
            @Override
            public void mouseClicked(MouseEvent evt){
                String regexemail="^(.+)@(.+)[.](.+)$";
                String regexdate="[0-9]{1,2}[/][0-9]{1,2}[/][0-9]{4}";
                Pattern pattern= Pattern.compile(regexemail);
                Pattern pattern2= Pattern.compile(regexdate);
                Matcher matcher=pattern.matcher(email.getText());
                Matcher matcher2= pattern2.matcher(dateofbirth.getText());
                String psw=new String(password.getPassword());
                boolean lastnamee;
                boolean firstnamee;
                boolean emaile=false;
                boolean date=false;
                boolean pasww=false;
                boolean occup=false;
                boolean sex=false;
                int sexx=0;
                
                if(lastname.getText().equals("Last name") || lastname.getText().equals("")){
                    lastnamee=false;
                    errorlastname1.setText("Error your Last name is required");
                }
                else{
                    lastnamee=true;
                }
                
                if(firstname.getText().equals("") || firstname.getText().equals("First name")){
                    firstnamee=false;
                    errorfirstname.setText("Error your First name is required");
                }
                else{
                    firstnamee=true;
                }
                if(occupation.getText().equals("") || occupation.getText().equals("Occupation")){
                    occup=false;
                    erroroccup.setText("Error your Occupation is required");
                }
                else{
                    occup=true;
                }
                
                if(matcher.matches()){
                    Connection cn;
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("SELECT email FROM user WHERE email=?");
                        pr.setString(1,email.getText());
                        rs=pr.executeQuery();
                        if(rs.next()){
                            emaile=false;
                            erroremail1.setText("Error this rmail exist you must enter another email or Log in to your account");
                        }
                        else{
                            emaile=true;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    emaile=false;
                    erroremail1.setText("Error you must enter a valid email expression ");
                }
                
                if(matcher2.matches()){
                    date=true;
                }
                else{
                    date=false;
                    errordate.setText("Error you must enter a valid date like this dd/mm/yyyy");
                }
                
                if(psw.length()<=8 && psw.length()!=0 && !psw.equals("Password")){
                    pasww=true;
                }
                else{
                    pasww=false;
                    errorpassword.setForeground(Color.red);
                    errorpassword.setText("you must enter a password who don't exeed 8 caracter");
                }
                
                if(!men.isSelected()&& !women.isSelected()){
                    sex=false;
                    errorsexe.setText("Error you must select your sexe gender");
                }
                else{
                    sex=true;
                    if(men.isSelected()){
                        sexx=1;
                    }
                    else{
                        sexx=0;
                    }
                }
                
                if(lastnamee && firstnamee && emaile && date && pasww && occup && sex){
                    Connection cn;
                    PreparedStatement pr;
                    ResultSet rs;
                    int res;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("INSERT INTO user (lastname,firstname,dateofbirth,email,password,occupation,sexe) VALUES(?,?,?,?,?,?,?)");
                        pr.setString(1, lastname.getText());
                        pr.setString(2, firstname.getText());
                        pr.setString(3, dateofbirth.getText());
                        pr.setString(4, email.getText());
                        pr.setString(5, psw);
                        pr.setString(6, occupation.getText());
                        pr.setString(7, String.valueOf(sexx));
                        res=pr.executeUpdate();
                        if(res>0){
                            pr=cn.prepareStatement("SELECT iduser FROM user WHERE email=?");
                            pr.setString(1, email.getText());
                            rs=pr.executeQuery();
                           if(rs.next()){
                            userid=rs.getInt(1);
                            lastnameee=lastname.getText();
                            firstnameee=firstname.getText();
                                    labelreg.setVisible(false);
                                    labellogin.setVisible(false);
                                    labelreg.setText("Log out");
                                    labellogin.setBackground(Color.decode("#E9F2F5"));
                                    labellogin.setOpaque(true);
                                    labellogin.setForeground(Color.black);
                                    labellogin.setText(firstname.getText()+" ");
                                     labelreg.setVisible(true);
                                    labellogin.setVisible(true);
                                        jPanel9.setBackground(Color.decode("#E9F2F5"));
                                        jPanel10.setBackground(Color.decode("#E9F2F5"));
                                        jPanel8.setBackground(Color.decode("#7BB8F1"));
                                        labelexplore.setBackground(Color.decode("#7BB8F1"));
                                        labelexplore.setBackground(Color.decode("#E9F2F5"));
                                        jScrollPane4.setVisible(false);
                                        panelpoddef.setVisible(false);
                                        jScrollPane5.setVisible(false);
                                        panelmypodcast.setVisible(false);
                                        jScrollPane2.setVisible(false);
                                        panelsubscribtion.setVisible(false);
                                        jScrollPane6.setVisible(false);
                                        panelrecherche.setVisible(false);
                                        jScrollPane3.setVisible(false);
                                        panelpodexpl.setVisible(false);
                                        panelpodexpl.removeAll();
                                        getpodcastexplore();
                                         jScrollPane3.setVisible(true);
                                        panelpodexpl.setVisible(true);
                                    dispose();
                           }
                                    
                        }
                        else{
                            System.out.println("erreur inserting user register \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
            
             @Override
            public void mouseExited(MouseEvent evt){
                signup.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 180, 40));

        errordate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errordate.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errordate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 340, 40));

        errorpassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorpassword.setForeground(new java.awt.Color(102, 102, 102));
        errorpassword.setText("your password must not exeed 8 caractere");
        jPanel2.add(errorpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 370, 40));

        erroremail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        erroremail1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(erroremail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 370, 40));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
        
        
        
    }
    
    
    
    public class Login extends javax.swing.JDialog{
        
         javax.swing.JLabel jLabellogin;
         javax.swing.JLabel jLabel2;
         javax.swing.JLabel jLabel3;
         javax.swing.JPanel jPanel2;
         javax.swing.JSeparator jSeparator1;
         javax.swing.JSeparator jSeparator2;
         javax.swing.JLabel labellogoo;
         javax.swing.JPanel panellogoo;
         javax.swing.JPasswordField password;
         javax.swing.JTextField textemail;
        
        
        
        public Login(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponent2();
            labellogoo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(160, 80, Image.SCALE_SMOOTH)));
        }
        
        
         void initComponent2() {

        panellogoo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        textemail = new javax.swing.JTextField();
        jLabellogin = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 701));

        panellogoo.setBackground(new java.awt.Color(233, 242, 245));
        panellogoo.setPreferredSize(new java.awt.Dimension(800, 101));
        panellogoo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogoo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, 80));

        getContentPane().add(panellogoo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 440, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 440, 10));

        textemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textemail.setForeground(new java.awt.Color(153, 153, 153));
        textemail.setText("Email");
        textemail.setBorder(null);
        textemail.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                textemail.setText("");
                jLabel3.setText("");
                textemail.setForeground(Color.black);
            }
        });
        jPanel2.add(textemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 440, 40));

        jLabellogin.setBackground(new java.awt.Color(55, 115, 228));
        jLabellogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabellogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabellogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabellogin.setText("Login");
        jLabellogin.setOpaque(true);
        jLabellogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                String regex="^(.+)@(.+)[.](.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(textemail.getText());
                String psw=new String(password.getPassword());
                if(psw.length()>8 || psw.length()==0){
                    jLabel2.setText("Error you must enter a password of 8 character maximum");
                }
                if(matcher.matches()){
                    
                    if(psw.length()<=8){
                        if(!textemail.getText().equals("admin.admin@podcasthightech.com") || !psw.equals("admin")){
                         Connection cn;
                        PreparedStatement pr;
                        ResultSet rs;
                        int iduser;
                        String lastname;
                        String firstname;

                        class.forName("com.mysql.jdbc.Driver");
                        try {
                            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                            pr=cn.prepareStatement("SELECT * FROM user WHERE email=?");
                            pr.setString(1, textemail.getText());
                            rs=pr.executeQuery();
                            if(rs.next()){
                                if(rs.getString(6).equals(psw)){
                                    userid=rs.getInt(1);
                                    lastnameee=rs.getString(2);
                                    firstnameee=rs.getString(3);
                                    labelreg.setVisible(false);
                                    labellogin.setVisible(false);
                                    labelreg.setText("Log out");
                                    labellogin.setBackground(Color.decode("#E9F2F5"));
                                    labellogin.setOpaque(true);
                                    labellogin.setForeground(Color.black);
                                    labellogin.setText(firstnameee+" ");
                                     labelreg.setVisible(true);
                                    labellogin.setVisible(true);
                                        jPanel9.setBackground(Color.decode("#E9F2F5"));
                                        jPanel10.setBackground(Color.decode("#E9F2F5"));
                                        jPanel8.setBackground(Color.decode("#7BB8F1"));
                                        labelexplore.setBackground(Color.decode("#7BB8F1"));
                                        labelexplore.setBackground(Color.decode("#E9F2F5"));
                                        jScrollPane4.setVisible(false);
                                        panelpoddef.setVisible(false);
                                        jScrollPane5.setVisible(false);
                                        panelmypodcast.setVisible(false);
                                        jScrollPane2.setVisible(false);
                                        panelsubscribtion.setVisible(false);
                                        jScrollPane6.setVisible(false);
                                        panelrecherche.setVisible(false);
                                        jScrollPane3.setVisible(false);
                                        panelpodexpl.setVisible(false);
                                        panelpodexpl.removeAll();
                                        getpodcastexplore();
                                         jScrollPane3.setVisible(true);
                                        panelpodexpl.setVisible(true);
                                    dispose();
                                    
                                }
                                else{
                                    jLabel2.setText("This is the wrong password please enter your correct password");
                                }
                            }
                            else{
                                jLabel3.setText("This email don't exist you have to creat a ancount");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        else{
                            Adminpodcast admin= new Adminpodcast();
                            admin.setVisible(true);
                            dispose();
                            dis=1;
                            
                        }
                    }
                    else{
                        jLabel2.setText("Error you must enter a password of 8 character maximum");
                    }
                }
                else{
                    jLabel3.setText("Error you must enter a valid email expression ");
                }
            }
        });
        jPanel2.add(jLabellogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 450, 50));

        password.setColumns(8);
        password.setBorder(null);
        password.setEchoChar((char) 0);
        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("Password");
        password.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                jLabel2.setText("");
                password.setForeground(Color.black);
                password.setEchoChar('*');
                password.setText("");
                
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 302, 440, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 440, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 440, 40));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
        
    }
    
    
    
    
    
    
    public class Comment extends javax.swing.JDialog{
        
        
                    javax.swing.JLabel jLabel1;
                    javax.swing.JLabel jLabel2;
                    javax.swing.JScrollPane jScrollPane1;
                    javax.swing.JScrollPane jScrollPane2;
                    javax.swing.JPanel paneladdcomment;
                    javax.swing.JPanel panelcomment;
                    javax.swing.JPanel panellogo;
                    javax.swing.JTextArea textcomment;
                    int episod;
                    int first=0;
        
        public Comment(java.awt.Frame parent, boolean modal,int episodeid) {
        super(parent, modal);
        this.episod=episodeid;
        initComponent();
        jLabel1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/log.png")).getImage().getScaledInstance(140, 80, Image.SCALE_SMOOTH)));
        getcommentsepisode(episodeid);
    }
        
        
        
        
        void creatcommentpanel(String lastnam,String firstnam,String content){
        JPanel commentpanel=new JPanel();
        JLabel labelname=new JLabel();
        JLabel twoplab=new JLabel();
        JTextArea textcomments=new JTextArea();
        JScrollPane jScrollPane8 =new JScrollPane();
        commentpanel.setBackground(new java.awt.Color(255, 255, 255));
        commentpanel.setPreferredSize(new java.awt.Dimension(panelcomment.getWidth(), 101));
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

        textcomments.setColumns(20);
        textcomments.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textcomments.setForeground(new java.awt.Color(51, 51, 51));
        textcomments.setLineWrap(true);
        textcomments.setRows(5);
        textcomments.setWrapStyleWord(true);
        textcomments.setEditable(false);
        jScrollPane8.setViewportView(textcomments);
        textcomments.setText(content);
        commentpanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 400, 80));
        commentpanel.setVisible(true);

        panelcomment.add(commentpanel);
    }
        
        
        
        
        
        void getcommentsepisode(int episodeid){
            Connection cn;
            PreparedStatement pr;
            PreparedStatement pr2;
            ResultSet rs;
            ResultSet rs2;
            int iduser;
            String lastname;
            String firstname;
            String content;
            
            class.forName("com.mysql.jdbc.Driver");
                        try {
                            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                            pr=cn.prepareStatement("SELECT * FROM comment WHERE idepisode=?");
                            pr.setString(1, String.valueOf(episodeid));
                            rs=pr.executeQuery();
                            while(rs.next()){
                                iduser=rs.getInt(2);
                                content=rs.getString(4);
                                pr2=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                                pr2.setString(1,String.valueOf(iduser));
                                rs2=pr2.executeQuery();
                                if(rs2.next()){
                                    lastname=rs2.getString(1);
                                    firstname=rs2.getString(2);
                                    creatcommentpanel(lastname, firstname, content);
                                }
                                else{
                                    System.out.println("erreur id user comment \n");
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                        }
            
        }

        
        private void initComponent() {

        paneladdcomment = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textcomment = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        panellogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelcomment = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        paneladdcomment.setPreferredSize(new java.awt.Dimension(537, 101));
        paneladdcomment.setBackground(Color.WHITE);
        paneladdcomment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textcomment.setColumns(20);
        textcomment.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textcomment.setForeground(new java.awt.Color(153, 153, 153));
        textcomment.setLineWrap(true);
        textcomment.setRows(5);
        textcomment.setText("\n  Add your comment");
        textcomment.setWrapStyleWord(true);
        textcomment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        textcomment.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                if(first==0){
                textcomment.setForeground(Color.black);
                textcomment.setText("");
                first=1;
                }
            }
        });
        jScrollPane2.setViewportView(textcomment);

        paneladdcomment.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 350, 60));

        jLabel2.setBackground(new java.awt.Color(55, 115, 228));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Submit");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                if(userid>-1){
                if(textcomment.getText().equals("\n  Add your comment") || textcomment.getText().equals("") ){
                    JOptionPane.showMessageDialog(null, "Error your comment is required to submit ");
                }
                else{
                Connection cn;
                PreparedStatement pr;
                ResultSet rs;
                String lname;
                String fname;
                class.forName("com.mysql.jdbc.Driver");
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                    pr=cn.prepareStatement("INSERT INTO comment (iduser,idepisode,content) VALUES (?,?,?)");
                    pr.setString(1, String.valueOf(userid));
                    pr.setString(2, String.valueOf(episod));
                    pr.setString(3, textcomment.getText());
                    int res=pr.executeUpdate();
                    pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                    pr.setString(1,String.valueOf(userid));
                    rs=pr.executeQuery();
                    if(rs.next()){
                        lname=rs.getString(1);
                        fname=rs.getString(2);
                        panelcomment.setVisible(false);
                        creatcommentpanel(lname, fname, textcomment.getText());
                        panelcomment.setVisible(true);
                    }
                    else{
                        System.out.println("erreur selecting in user id comment \n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "You must Log in to submit your comment");
                }
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                jLabel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        paneladdcomment.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 120, 60));

        getContentPane().add(paneladdcomment, java.awt.BorderLayout.PAGE_END);

        panellogo.setBackground(new java.awt.Color(233, 242, 245));
        panellogo.setPreferredSize(new java.awt.Dimension(537, 101));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        panellogo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 10, 140, 80));

        getContentPane().add(panellogo, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 101));

        panelcomment.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelcomment.setBackground(Color.WHITE);
        jScrollPane1.setViewportView(panelcomment);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    void creatpanelepisodes(int podid,int episodeid,int userid,String titleepisode,String episodedescription,String lenghtepisode,String audiopath,int nblike,int like,int v,byte[]imggg){
        
       JPanel panelepisode = new javax.swing.JPanel();
        JPanel panelnbepisode = new javax.swing.JPanel();
        JLabel labelnbepisode = new javax.swing.JLabel();
       JPanel  panellikelengthcomment = new javax.swing.JPanel();
        JLabel labellike = new javax.swing.JLabel();
        JLabel jLabeleditepisode = new javax.swing.JLabel();
        JLabel jLabeldelepisode = new javax.swing.JLabel();
        JLabel labelcomment = new javax.swing.JLabel();
        JLabel labellenght = new javax.swing.JLabel();
        JLabel jlabel4 = new javax.swing.JLabel();
        JLabel jlabel5 = new javax.swing.JLabel();
        JPanel paneltitledescription = new javax.swing.JPanel();
        JLabel labeltitleepisode = new javax.swing.JLabel();
        JLabel labelaudiopath = new JLabel();
        JScrollPane jScrollPane5 = new javax.swing.JScrollPane();
       JTextArea textepisode = new javax.swing.JTextArea();
        
        panelepisode.setBackground(new java.awt.Color(255, 255, 255));
        panelepisode.setPreferredSize(new java.awt.Dimension(832, 101));
        panelepisode.setLayout(new java.awt.BorderLayout());

        panelnbepisode.setBackground(new java.awt.Color(255, 255, 255));
        panelnbepisode.setPreferredSize(new java.awt.Dimension(58, 102));
        panelnbepisode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelnbepisode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelnbepisode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnbepisode.setText(""+episodeid);
        panelnbepisode.add(labelnbepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));
        
        labelaudiopath.setText(audiopath);
        labelaudiopath.setVisible(false);
        panelnbepisode.add(labelaudiopath, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, 10));

        panellikelengthcomment.setBackground(new java.awt.Color(255, 255, 255));
        panellikelengthcomment.setPreferredSize(new java.awt.Dimension(153, 102));
        panellikelengthcomment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        if(userid>-1){
            if(like==1){
                labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thumbs-up.png")));
                jlabel4.setText("1");
            } // NOI18N
            else{
                labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/like.png")));
                jlabel4.setText("0");
            }
            jlabel4.setVisible(false);
            jlabel5.setText(String.valueOf(nblike));
            jlabel5.setVisible(false);
            panelnbepisode.add(jlabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 30, -1));
            panelnbepisode.add(jlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 10, 30, -1));// NOI18N
            panelepisode.add(panelnbepisode, java.awt.BorderLayout.LINE_START);
            labellike.setText(nblike+"   Like");
            labellike.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent evt){
                    labellike.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    labellike.setVisible(false);
                    labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thumbs-up.png")));
                    labellike.setVisible(true);
                }
                
                
                @Override
                public void mouseClicked(MouseEvent evt){
                    Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    int res;
                    int nblik;
                    class.forName("com.mysql.jdbc.Driver");
                    if(jlabel4.getText().equals("0")){
                        try {
                            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                            pr=cn.prepareStatement("INSERT INTO liker (iduser,idepisode) VALUES (?,?)");
                            pr.setString(1,String.valueOf(userid));
                            pr.setString(2,String.valueOf(episodeid));
                            res=pr.executeUpdate();
                            if(res>0){
                                jlabel4.setText("1");
                                labellike.setVisible(false);
                                labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thumbs-up.png")));
                                nblik=Integer.parseInt(jlabel5.getText());
                                nblik++;
                                jlabel5.setText(String.valueOf(nblik));
                                labellike.setText(nblik+"   Like");
                                labellike.setVisible(true);
                            }
                            else{
                                System.out.println("erreur inserting liker \n");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        try {
                            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                            pr=cn.prepareStatement("DELETE FROM liker WHERE iduser=? AND idepisode=?");
                            pr.setString(1,String.valueOf(userid));
                            pr.setString(2,String.valueOf(episodeid));
                            res=pr.executeUpdate();
                            if(res>0){
                                jlabel4.setText("0");
                                labellike.setVisible(false);
                                nblik=Integer.parseInt(jlabel5.getText());
                                nblik--;
                                jlabel5.setText(String.valueOf(nblik));
                                labellike.setText(nblik+"   Like");
                                labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/like.png")));
                                labellike.setVisible(true);
                            }
                            else{
                                System.out.println("erreur deleting liker \n");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                @Override
                public void mouseExited(MouseEvent evt){
                    labellike.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    if(jlabel4.getText().equals("0")){
                    labellike.setVisible(false);
                    labellike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/like.png")));
                    labellike.setVisible(true);
                    }
                }
            });
            panellikelengthcomment.add(labellike, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));
        }
        else{
            labellike.setVisible(false);
        }
        

        labelcomment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comments.png"))); // NOI18N
        labelcomment.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                new Comment(null,true,episodeid).show();
            }
        });
        panellikelengthcomment.add(labelcomment, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 40, 30));
        if(v==1){
        jLabeleditepisode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png"))); // NOI18N
        jLabeleditepisode.addMouseListener(new MouseAdapter(){
            
             @Override
            public void mouseClicked(MouseEvent evt){
                new Editepisode(null, true,String.valueOf(podid),String.valueOf(episodeid) ,titleepisode,episodedescription,labelaudiopath.getText()).show();
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                jLabeleditepisode.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            
             @Override
            public void mouseExited(MouseEvent evt){
                jLabeleditepisode.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        panellikelengthcomment.add(jLabeleditepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 30, 30));
        
        jLabeldelepisode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trash.png"))); // NOI18N
        jLabeldelepisode.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                int rese=JOptionPane.showConfirmDialog(null, "Are you sure to delete this episode ?", "Delting episode", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               if(rese==JOptionPane.YES_OPTION){    
                Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    int res;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("DELETE FROM episode WHERE idepisode=?");
                        pr.setString(1, String.valueOf(episodeid));
                        res=pr.executeUpdate();
                        if(res>0){
                            jScrollPane1.setVisible(false);
                            panelpoddefsouht.setVisible(false);
                            panelpoddefsouht.removeAll();
                            getepisodes(podid, v,imggg);
                            jScrollPane1.setVisible(true);
                            panelpoddefsouht.setVisible(true);
                        }
                        else{
                            System.out.println("erreur deleting episode \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
                    
            }
        });
        panellikelengthcomment.add(jLabeldelepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 30, 30));
        }
        labellenght.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labellenght.setText(lenghtepisode);
        panellikelengthcomment.add(labellenght, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        panelepisode.add(panellikelengthcomment, java.awt.BorderLayout.LINE_END);

        paneltitledescription.setBackground(new java.awt.Color(255, 255, 255));
        paneltitledescription.setPreferredSize(new java.awt.Dimension(674, 103));
        paneltitledescription.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitleepisode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labeltitleepisode.setText(titleepisode);
        paneltitledescription.add(labeltitleepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 20));

        textepisode.setColumns(20);
        textepisode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textepisode.setForeground(new java.awt.Color(51, 51, 51));
        textepisode.setRows(5);
        textepisode.setText(episodedescription);
        textepisode.setEditable(false);
        jScrollPane5.setViewportView(textepisode);

        paneltitledescription.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 30, 610, 60));

        panelepisode.add(paneltitledescription, java.awt.BorderLayout.CENTER);
        panelepisode.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                panelepisode.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                /* JPanel jPanel2=new JPanel();
                    JLabel labeltitleepo = new javax.swing.JLabel();
        JLabel labeltitlepod = new javax.swing.JLabel();
        JLabel labelname = new javax.swing.JLabel();
        JLabel labelplaypause = new javax.swing.JLabel();
        JLabel labeldis = new javax.swing.JLabel();
        JLabel labeladvanse = new javax.swing.JLabel();
       
        JLabel labeldurattion = new javax.swing.JLabel();
        
                */ 
             
                if(y==1){                 
                        aud.close();
                        jPanel1.setVisible(false);
                        BorderLayout layout = (BorderLayout)jPanel1.getLayout();
                        jPanel1.remove(layout.getLayoutComponent(BorderLayout.SOUTH));
                  }/*

                                        ignoreStateChange=false;
                                        playiing=false;
                                         System.out.println(playiing+"\n");
                Timer playtimer;
                Timer delayedUpdate = new Timer(250,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int frame=getDesiredFrame();
                        clip.setFramePosition(frame);
                        double time= getCurrentTime();
                        labeltime.setText(""+time);
                    }
                    });
               
                
                String podname=null;
                Connection cn;
                PreparedStatement pr;
                ResultSet rs;
                class.forName("com.mysql.jdbc.Driver");
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                    pr=cn.prepareStatement("SELECT titre FROM podcast WHERE idpod=?");
                    pr.setString(1, String.valueOf(podid));
                    rs=pr.executeQuery();
                    if(rs.next()){
                        podname=rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                }
                AudioInputStream ais=null;    
                File file= new File(labelaudiopath.getText().replace('\\','/' ));
                
                try {
                    ais=AudioSystem.getAudioInputStream(file);
                    formate=ais.getFormat();
                    framecont=ais.getFrameLength();
                    duratttion=((double) framecont) / formate.getFrameRate();
                    
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
                                if (event.getType().equals(Type.STOP)
                                                || event.getType().equals(Type.CLOSE)) {
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

        labeltitleepo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labeltitleepo.setText(titleepisode);
        jPanel2.add(labeltitleepo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 360, 30));

        labeltitlepod.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labeltitlepod.setText(podname);
        jPanel2.add(labeltitlepod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 290, 30));
        
        prog.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(prog, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1080, 10));
        
        labelname.setForeground(new java.awt.Color(51, 51, 51));
        labelname.setText("By "+lastnameee+" "+firstnameee);
        jPanel2.add(labelname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, -1));

        labelplaypause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
         System.out.println(playiing+"\n");
        labelplaypause.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
               
                if (playiing==false) {
                     System.out.println(playiing+"\n");
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

        labeldis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alternate Undo.png"))); // NOI18N
        jPanel2.add(labeldis, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, 50));

        labeladvanse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alternate Redo2.png"))); // NOI18N
        jPanel2.add(labeladvanse, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, 50));

        labeltime.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jPanel2.add(labeltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 40, 90, 40));
        
        labeldurattion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labeldurattion.setText("/ "+duratttion);
        jPanel2.add(labeldurattion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 60, 40));
        
       
        
        jPanel2.add(progressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1)); */

                    jPanel1.setVisible(false);
                 aud= new Audio(labelaudiopath.getText().replace('\\', '/'),titleepisode,podid,imggg);
                  JLabel labelcloseepisode = new javax.swing.JLabel();   
                 JPanel panelee= aud.createpanele(labelaudiopath.getText().replace('\\', '/'));
                   
                    labelcloseepisode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelcloseepisode.setForeground(new java.awt.Color(55, 115, 228));
        labelcloseepisode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcloseepisode.setText("Close episode");
        labelcloseepisode.setBackground(Color.white);
        labelcloseepisode.setOpaque(true);
        labelcloseepisode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        labelcloseepisode.addMouseListener(new MouseAdapter(){
            
            
            @Override
            public void mouseClicked(MouseEvent evt){
               jPanel1.setVisible(false);
                        BorderLayout layout = (BorderLayout)jPanel1.getLayout();
                        jPanel1.remove(layout.getLayoutComponent(BorderLayout.SOUTH));
                        aud.close();
                        y=0;
                        jPanel1.setVisible(true);
            }
            
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                labelcloseepisode.setCursor(new Cursor(Cursor.HAND_CURSOR));
                 labelcloseepisode.setForeground(Color.white);
                 labelcloseepisode.setBackground(new java.awt.Color(55, 115, 228));
                 labelcloseepisode.setOpaque(true);
            }
            
            
            
            
            
             @Override
            public void mouseExited(MouseEvent evt){
                labelcloseepisode.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                 labelcloseepisode.setForeground(new java.awt.Color(55, 115, 228));
                 labelcloseepisode.setBackground(Color.white);
                 labelcloseepisode.setOpaque(true);
            }
        });
        
        panelee.add(labelcloseepisode, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 150, 40));
                   
        
        panelee.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                panelpodexpl.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane2.setVisible(false);
                panelsubscribtion.setVisible(false);
                jScrollPane5.setVisible(false);
                panelmypodcast.setVisible(false);
                jScrollPane6.setVisible(false);
                panelrecherche.setVisible(false);
                jScrollPane4.setVisible(false);
                panelpoddef.setVisible(false);
                panelpoddefnorth.removeAll();
                panelpoddefsouht.removeAll();
                 int id=0;
                                      Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                        String titl=null;
                        String desc=null;
                        int mod=0;
                         String lname=null;
                        String fname=null;
                
                try {
                    cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                     pr=cn.prepareStatement("SELECT iduser,titre,description FROM podcast WHERE idpod=?");
                            pr.setString(1,String.valueOf(podid));
                            rs=pr.executeQuery();
                            if(rs.next()){
                                id=rs.getInt(1);
                                 titl=rs.getString(2);
                                 desc=rs.getString(3);
                                if(id==userid)
                                    mod=1;
                                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                                pr.setString(1, String.valueOf(id));
                                rs=pr.executeQuery();
                                if(rs.next()){
                                    lname=rs.getString(1);
                                     fname=rs.getString(2);
                                }
                            }
                if(userid>-1){

                    class.forName("com.mysql.jdbc.Driver");
                    
                       
                       
                       
                        pr=cn.prepareStatement("SELECT * FROM follow WHERE iduser=? AND idpod=?");
                        pr.setString(1, String.valueOf(userid));
                        pr.setString(2, String.valueOf(podid));
                        rs=pr.executeQuery();
                        if(rs.next()){
                           
                             creatpanelpoddefinition(podid, imggg, titl, lname+" "+fname, desc, 1);
                             getepisodes(podid,0,imggg);
                            

                        }
                        else{
                            if(mod==1){
                            creatpanelpoddefinition(podid, imggg, titl, lname+" "+fname, desc, -1);
                            getepisodes(podid,0,imggg);
                            }
                        else{
                                creatpanelpoddefinition(podid, imggg, titl, lname+" "+fname, desc, 0);
                            getepisodes(podid,0,imggg);
                                    }
                        }
      
                   
                }
                else{
                    creatpanelpoddefinition(podid, imggg, titl, lname+" "+fname, desc, 0);
                    getepisodes(podid,0,imggg);
                }
                
                } catch (SQLException ex) {
                    Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                }
                       
                jScrollPane4.setVisible(true);
                panelpoddef.setVisible(true);
            }
            
            
            @Override
            public void mouseEntered(MouseEvent evt){
                panelee.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelee.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
                    jPanel1.add(panelee,BorderLayout.SOUTH);
                    y=1;
                    jPanel1.setVisible(true);
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelepisode.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        panelpoddefsouht.add(panelepisode);
    }
    
    
    
    
    void createpanelpodresearched(int podid,String podtitle,String podaut,String poddescription,byte[]img){
        JPanel panelpod=new JPanel();
        JLabel labelimg=new JLabel();
        JLabel labeltitle=new JLabel();
        JLabel labelaut=new JLabel();
        ImageIcon im;
        panelpod.setBackground(new java.awt.Color(255, 255, 255));
        panelpod.setPreferredSize(new java.awt.Dimension(240, 270));
        panelpod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimg.setIcon(im);
        
        panelpod.add(labelimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 160));

        labeltitle.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);
        panelpod.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelaut.setForeground(new java.awt.Color(153, 153, 153));
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);
        panelpod.add(labelaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));
        panelpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelpod.setBackground(Color.decode("#3773E4"));
                labeltitle.setBackground(Color.decode("#3773E4"));
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.white);
                labelaut.setBackground(Color.decode("#3773E4"));
                labelaut.setOpaque(true);
                labelaut.setForeground(Color.white);
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                panelpodexpl.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane2.setVisible(false);
                panelsubscribtion.setVisible(false);
                jScrollPane5.setVisible(false);
                panelmypodcast.setVisible(false);
                jScrollPane6.setVisible(false);
                panelrecherche.setVisible(false);
                jScrollPane4.setVisible(false);
                panelpoddef.setVisible(false);
                panelpoddefnorth.removeAll();
                panelpoddefsouht.removeAll();
                if(userid>-1){
                     Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("SELECT * FROM follow WHERE iduser=? AND idpod=?");
                        pr.setString(1, String.valueOf(userid));
                        pr.setString(2, String.valueOf(podid));
                        rs=pr.executeQuery();
                        if(rs.next()){
                             creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 1);
                             getepisodes(podid,0,img);
                        }
                        else{
                            creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                            getepisodes(podid,0,img);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else{
                    creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                    getepisodes(podid,0,img);
                }
                
                jScrollPane4.setVisible(true);
                panelpoddef.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                panelpod.setBackground(Color.white);
                labeltitle.setBackground(Color.white);
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.black);
                labelaut.setBackground(Color.white);
                labelaut.setOpaque(true);
                labelaut.setForeground(new Color(153, 153, 153));
            }
            
            
        });
        panelrecherche.add(panelpod);
                
    }
    
    
    
    
    
    
    void getpodresearched(int iduser){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        String poddescription=null;
        int podid;
        int userid;
        String lastename;
        String firstname;
        byte[] imgd=null;
        class.forName("com.mysql.jdbc.Driver");
        
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM podcast WHERE titre LIKE ? OR description LIKE ? ");
            pr.setString(1,"%"+textrech.getText()+"%");
            pr.setString(2,"%"+textrech.getText()+"%");
            rs=pr.executeQuery();
            while(rs.next()){
                podid=rs.getInt(1);
                userid=rs.getInt(2);
              if(userid!=this.userid){
                podtitle=rs.getString(3);
                poddescription=rs.getString(4);
                imgd=rs.getBytes(5);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1,String.valueOf(userid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    lastename=rs2.getString(1);
                    firstname=rs2.getString(2);
                    podaut=lastename+" "+firstname+" ";
                    createpanelpodresearched(podid, podtitle, podaut,poddescription, imgd);
                }
                else{
                    System.out.println("erreur user id podcast \n");
                }
              }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    void creatpanelpodfollowed(int podid,String podtitle,String podaut,String poddescription,byte[]img){
        JPanel panelpod=new JPanel();
        JLabel labelimg=new JLabel();
        JLabel labeltitle=new JLabel();
        JLabel labelaut=new JLabel();
        ImageIcon im;
        panelpod.setBackground(new java.awt.Color(255, 255, 255));
        panelpod.setPreferredSize(new java.awt.Dimension(240, 270));
        panelpod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimg.setIcon(im);
        
        panelpod.add(labelimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 160));

        labeltitle.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);
        panelpod.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelaut.setForeground(new java.awt.Color(153, 153, 153));
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);
        panelpod.add(labelaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));
        panelpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelpod.setBackground(Color.decode("#3773E4"));
                labeltitle.setBackground(Color.decode("#3773E4"));
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.white);
                labelaut.setBackground(Color.decode("#3773E4"));
                labelaut.setOpaque(true);
                labelaut.setForeground(Color.white);
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                panelpodexpl.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane2.setVisible(false);
                panelsubscribtion.setVisible(false);
                jScrollPane5.setVisible(false);
                panelmypodcast.setVisible(false);
                jScrollPane6.setVisible(false);
                panelrecherche.setVisible(false);
                jScrollPane4.setVisible(false);
                panelpoddef.setVisible(false);
                panelpoddefnorth.removeAll();
                panelpoddefsouht.removeAll();
                if(userid>-1){
                     Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("SELECT * FROM follow WHERE iduser=? AND idpod=?");
                        pr.setString(1, String.valueOf(userid));
                        pr.setString(2, String.valueOf(podid));
                        rs=pr.executeQuery();
                        if(rs.next()){
                             creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 1);
                             getepisodes(podid,0,img);
                        }
                        else{
                            creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                            getepisodes(podid,0,img);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else{
                    creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                    getepisodes(podid,0,img);
                }
                
                jScrollPane4.setVisible(true);
                panelpoddef.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                panelpod.setBackground(Color.white);
                labeltitle.setBackground(Color.white);
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.black);
                labelaut.setBackground(Color.white);
                labelaut.setOpaque(true);
                labelaut.setForeground(new Color(153, 153, 153));
            }
            
            
        });
        panelsubscribtion.add(panelpod);
    }
    
    
    
    void creatpanelmypod(int podid,String podtitle,String podaut,String poddescription,byte[]img){
        JPanel panelpod=new JPanel();
        JLabel labelimg=new JLabel();
        JLabel labeltitle=new JLabel();
        JLabel labelaut=new JLabel();
        ImageIcon im;
        panelpod.setBackground(new java.awt.Color(255, 255, 255));
        panelpod.setPreferredSize(new java.awt.Dimension(240, 270));
        panelpod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimg.setIcon(im);
        
        panelpod.add(labelimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 160));

        labeltitle.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);
        panelpod.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelaut.setForeground(new java.awt.Color(153, 153, 153));
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);
        panelpod.add(labelaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));
        panelpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelpod.setBackground(Color.decode("#3773E4"));
                labeltitle.setBackground(Color.decode("#3773E4"));
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.white);
                labelaut.setBackground(Color.decode("#3773E4"));
                labelaut.setOpaque(true);
                labelaut.setForeground(Color.white);
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                panelpodexpl.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane2.setVisible(false);
                panelsubscribtion.setVisible(false);
                jScrollPane5.setVisible(false);
                panelmypodcast.setVisible(false);
                jScrollPane6.setVisible(false);
                panelrecherche.setVisible(false);
                jScrollPane4.setVisible(false);
                panelpoddef.setVisible(false);
                panelpoddefnorth.removeAll();
                panelpoddefsouht.removeAll();
                if(userid>-1){
                     Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, -1);
                    getepisodes(podid,1,img);
                }
                else{
                    creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                    getepisodes(podid,0,img);
                }
                
                jScrollPane4.setVisible(true);
                panelpoddef.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                panelpod.setBackground(Color.white);
                labeltitle.setBackground(Color.white);
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.black);
                labelaut.setBackground(Color.white);
                labelaut.setOpaque(true);
                labelaut.setForeground(new Color(153, 153, 153));
            }
            
            
        });
        panelmypodcast.add(panelpod);
    }
    
    
    void getmypod(int userid){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        String poddescription=null;
        int podid;
        int userpod;
        String lastename;
        String firstname;
        byte[] imgd=null;
        class.forName("com.mysql.jdbc.Driver");
        
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM podcast WHERE iduser=?");
            pr.setString(1,String.valueOf(userid));
            rs=pr.executeQuery();
            while(rs.next()){
                podid=rs.getInt(1);
                userpod=rs.getInt(2);
                podtitle=rs.getString(3);
                poddescription=rs.getString(4);
                imgd=rs.getBytes(5);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1,String.valueOf(userpod));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    lastename=rs2.getString(1);
                    firstname=rs2.getString(2);
                    podaut=lastename+" "+firstname+" ";
                    creatpanelmypod(podid, podtitle, podaut,poddescription, imgd);
                }
                else{
                    System.out.println("erreur user id podcast \n");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    void getpodfollowed(int userid){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        ResultSet rs3;
        String podtitle=null;
        String podaut=null;
        String poddescription=null;
        int podid;
        int userpod;
        String lastename;
        String firstname;
        byte[] imgd=null;
        class.forName("com.mysql.jdbc.Driver");
        
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM follow WHERE iduser=?");
            pr.setString(1, String.valueOf(userid));
            rs=pr.executeQuery();
            while(rs.next()){
                podid=rs.getInt(2);
                pr=cn.prepareStatement("SELECT * FROM podcast WHERE idpod=?");
                pr.setString(1, String.valueOf(podid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    userpod=rs2.getInt(2);
                    podtitle=rs2.getString(3);
                    poddescription=rs2.getString(4);
                    imgd=rs2.getBytes(5);
                    pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                    pr.setString(1,String.valueOf(userpod));
                    rs3=pr.executeQuery();
                    if(rs3.next()){
                        lastename=rs3.getString(1);
                        firstname=rs3.getString(2);
                        podaut=lastename+" "+firstname+" ";
                        creatpanelpodfollowed(podid, podtitle, podaut,poddescription, imgd);
                    }
                    else{
                        System.out.println("erreur user id podcast \n");
                    }
                }
                else{
                    System.out.println("erreur selecting pod id \n");
                }
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void getepisodes(int podid,int v,byte[]imggg){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        String episodetitle=null;
        String episodedescription=null;
        String audiopath=null;
        int episodeid;
        String lenghtepisode;
        class.forName("com.mysql.jdbc.Driver");
        
        try {
            cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
            pr=cn.prepareStatement("SELECT * FROM episode WHERE idpod=?");
            pr.setString(1,String.valueOf(podid));
            rs=pr.executeQuery();
            int like=0;
            while(rs.next()){
                episodeid=rs.getInt(1);
                episodetitle=rs.getString(4);
                episodedescription=rs.getString(5);
                lenghtepisode=rs.getString(6);
                audiopath=rs.getString(7);
                int nblike=0;
                
                int id;
                if(userid>-1){
                    Connection cnk; 
                    PreparedStatement pr2;
                    ResultSet rs3;

                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cnk= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr2=cn.prepareStatement("SELECT * FROM liker WHERE idepisode=?");
                        pr2.setString(1,String.valueOf(episodeid));
                        rs3=pr2.executeQuery();
                        while(rs3.next()){
                            id=rs3.getInt(1);
                            if(id==userid){
                                like=1;
                            }
                            nblike++;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
                if(v==1)
                     creatpanelepisodes(podid,episodeid, userid, episodetitle, episodedescription, lenghtepisode,audiopath, nblike, like,1,imggg);
                else
                    creatpanelepisodes(podid,episodeid, userid, episodetitle, episodedescription, lenghtepisode,audiopath, nblike, like,0,imggg);
                
                like=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adminpodcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    void creatpanelpoddefinition(int podid,byte[]img,String title,String aut,String description,int v){
        JPanel panelpoddefinition = new javax.swing.JPanel();
       JPanel jPanel6 = new javax.swing.JPanel();
        JLabel labelimgpod = new javax.swing.JLabel();
        JPanel jPanel7 = new javax.swing.JPanel();
        JPanel panelsubscription = new javax.swing.JPanel();
       JLabel jLabel3 = new javax.swing.JLabel();
       JLabel jLabeledit = new javax.swing.JLabel();
       JLabel jLabeldelete = new javax.swing.JLabel();
       JPanel  paneltitleaut = new javax.swing.JPanel();
       JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
       JPanel  paneldescription = new javax.swing.JPanel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JTextArea jTextArea1 = new javax.swing.JTextArea();
        ImageIcon im;
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(240,230, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        panelpoddefinition.setPreferredSize(new java.awt.Dimension(830, 261));
        panelpoddefinition.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(272, 261));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelimgpod.setIcon(im);
        jPanel6.add(labelimgpod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 230));

        panelpoddefinition.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setPreferredSize(new java.awt.Dimension(558, 261));
        jPanel7.setLayout(new java.awt.BorderLayout());

        panelsubscription.setBackground(new java.awt.Color(255, 255, 255));
        panelsubscription.setPreferredSize(new java.awt.Dimension(558, 49));
        panelsubscription.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
      if(userid>-1){
        if(v==0){
        jLabel3.setBackground(new java.awt.Color(55, 115, 228));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check(1).png"))); // NOI18N
        jLabel3.setText("      Subscribe");
        jLabel3.setOpaque(true);
        panelsubscription.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, 30));
        }
        else if(v==1){
            jLabel3.setBackground(new java.awt.Color(255, 255, 255));
            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(55, 115, 228));
            jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check.png"))); // NOI18N
            jLabel3.setText("      Subscribed");
            jLabel3.setOpaque(true);
            panelsubscription.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, 30));
        }
        else{
            jLabeledit.setBackground(new java.awt.Color(255, 255, 255));
            jLabeledit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabeledit.setForeground(new java.awt.Color(55, 115, 228));
            jLabeledit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png"))); // NOI18N
            jLabeledit.setText("           Edit");
            jLabeledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
            jLabeledit.setOpaque(true);
            jLabeledit.addMouseListener(new MouseAdapter(){
                
                @Override
                public void mouseClicked(MouseEvent evt){
                    if(userid>-1){
                        new Editpodcast(null, true, podid, title, description).show();
                    }
                }
                
                @Override
                public void mouseEntered(MouseEvent evt){
                    jLabeledit.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    jLabeledit.setVisible(false);
                    jLabeledit.setBackground(new java.awt.Color(55, 115, 228));
                    jLabeledit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabeledit.setForeground(new java.awt.Color(255, 255, 255));
                    jLabeledit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editw.png"))); // NOI18N
                    jLabeledit.setOpaque(true);
                    jLabeledit.setVisible(true);
                    
                }
                
                @Override
                public void mouseExited(MouseEvent evt){
                    jLabeledit.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    jLabeledit.setVisible(false);
                    jLabeledit.setBackground(new java.awt.Color(255, 255, 255));
                    jLabeledit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabeledit.setForeground(new java.awt.Color(55, 115, 228));
                    jLabeledit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png"))); // NOI18N
                    jLabeledit.setOpaque(true);
                    jLabeledit.setVisible(true);
                    
                }
            });
             panelsubscription.add(jLabeledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));
            
            jLabeldelete.setBackground(new java.awt.Color(255, 255, 255));
            jLabeldelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabeldelete.setForeground(new java.awt.Color(255, 0, 0));
            jLabeldelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trash.png"))); // NOI18N
            jLabeldelete.setText("          Delete");
            jLabeldelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));
            jLabeldelete.setOpaque(true);
            jLabeldelete.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent evt){
                    jLabeldelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    jLabeldelete.setVisible(false);
                    jLabeldelete.setBackground(new java.awt.Color(255, 0, 0));
                    jLabeldelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabeldelete.setForeground(new java.awt.Color(255, 255, 255));
                    jLabeldelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trashw.png"))); // NOI18N
                    jLabeldelete.setOpaque(true);
                    jLabeldelete.setVisible(true);
                    
                }
                
                @Override
                public void mouseClicked(MouseEvent evt){
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
                        pr.setString(1, String.valueOf(podid));
                        res=pr.executeUpdate();
                        if(res>0){
                            jScrollPane3.setVisible(false);
                            panelpodexpl.setVisible(false);
                            jScrollPane4.setVisible(false);
                            panelpoddef.setVisible(false);
                            jScrollPane2.setVisible(false);
                            panelsubscribtion.setVisible(false);
                            jScrollPane5.setVisible(false);
                            panelmypodcast.setVisible(false);
                            panelmypodcast.removeAll();
                            JPanel jPanel2=new JPanel();
                            JLabel jLabel1=new JLabel();
                            jPanel2.setBackground(new java.awt.Color(241, 241, 241));
                            jPanel2.setPreferredSize(new java.awt.Dimension(1074, 101));
                            jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                            jLabel1.setBackground(new java.awt.Color(241, 241, 241));
                            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            jLabel1.setText("Your Podcasts Channels");
                            jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 390, 40));
                            panelmypodcast.add(jPanel2);
                            getmypod(userid);
                            jScrollPane5.setVisible(true);
                            panelmypodcast.setVisible(true);
                        }
                        else{
                            System.out.println("erreur deleting podcast in my podcast panel \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   }
                }
                
                
                @Override
                public void mouseExited(MouseEvent evt){
                    jLabeldelete.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    jLabeldelete.setVisible(false);
                    jLabeldelete.setBackground(new java.awt.Color(255, 255, 255));
                    jLabeldelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabeldelete.setForeground(new java.awt.Color(255, 0, 0));
                    jLabeldelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trash.png"))); // NOI18N
                    jLabeldelete.setOpaque(true);
                    jLabeldelete.setVisible(true);
                    
                }
            });
             panelsubscription.add(jLabeldelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 180, 40));
        }
        jLabel3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                if(jLabel3.getText().contains("Subscribed")){
                    jLabel3.setVisible(false);
                    jLabel3.setBackground(new java.awt.Color(55, 115, 228));
                    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check(1).png"))); // NOI18N
                    jLabel3.setOpaque(true);
                    jLabel3.setVisible(true);
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                Connection cn; 
                PreparedStatement pr;
                int rs;
                class.forName("com.mysql.jdbc.Driver");
                if(jLabel3.getText().contains("Subscribed")){
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("DELETE FROM follow WHERE idpod=?");
                        pr.setString(1,String.valueOf(podid));
                        rs=pr.executeUpdate();
                        if(rs>0){
                            jLabel3.setVisible(false);
                            jLabel3.setBackground(new java.awt.Color(55, 115, 228));
                            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check(1).png"))); // NOI18N
                            jLabel3.setText("      Subscribe");
                            jLabel3.setOpaque(true);
                            jLabel3.setVisible(true);
                        }
                        
                        else{
                            System.out.println("erreur deleting follow \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("INSERT INTO follow  VALUES (?,?)");
                        pr.setString(1,String.valueOf(userid));
                        pr.setString(2,String.valueOf(podid));
                        rs=pr.executeUpdate();
                        if(rs>0){
                            jLabel3.setVisible(false);
                            jLabel3.setBackground(new java.awt.Color(255, 255, 255));
                            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                            jLabel3.setForeground(new java.awt.Color(55, 115, 228));
                            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check.png"))); // NOI18N
                            jLabel3.setText("      Subscribed");
                            jLabel3.setOpaque(true);
                            jLabel3.setVisible(true);
                        }
                        else{
                            System.out.println("erreur inserting follow \n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                if(jLabel3.getText().contains("Subscribed")){
                    jLabel3.setVisible(false);
                    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
                    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                    jLabel3.setForeground(new java.awt.Color(55, 115, 228));
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Check.png"))); // NOI18N
                    jLabel3.setOpaque(true);
                    jLabel3.setVisible(true);
                }
            }
        });
        
      }
        jPanel7.add(panelsubscription, java.awt.BorderLayout.PAGE_END);

        paneltitleaut.setBackground(new java.awt.Color(255, 255, 255));
        paneltitleaut.setPreferredSize(new java.awt.Dimension(558, 69));
        paneltitleaut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText(title);
        jLabel1.setOpaque(true);
        paneltitleaut.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText(aut);
        jLabel2.setOpaque(true);
        paneltitleaut.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 260, 40));

        jPanel7.add(paneltitleaut, java.awt.BorderLayout.PAGE_START);

        paneldescription.setPreferredSize(new java.awt.Dimension(558, 144));
        paneldescription.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(51, 51, 51));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setText(description);
        jScrollPane2.setViewportView(jTextArea1);

        paneldescription.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 140));

        jPanel7.add(paneldescription, java.awt.BorderLayout.CENTER);

        panelpoddefinition.add(jPanel7, java.awt.BorderLayout.CENTER);

        panelpoddefnorth.add(panelpoddefinition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 830, 260));
    }
    
    
    void creatpanelpod(int podid,String podtitle,String podaut,String poddescription,byte[]img){
        JPanel panelpod=new JPanel();
        JLabel labelimg=new JLabel();
        JLabel labeltitle=new JLabel();
        JLabel labelaut=new JLabel();
        ImageIcon im;
        panelpod.setBackground(new java.awt.Color(255, 255, 255));
        panelpod.setPreferredSize(new java.awt.Dimension(240, 270));
        panelpod.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(200, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimg.setIcon(im);
        
        panelpod.add(labelimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 160));

        labeltitle.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);
        panelpod.add(labeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelaut.setForeground(new java.awt.Color(153, 153, 153));
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);
        panelpod.add(labelaut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));
        panelpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelpod.setBackground(Color.decode("#3773E4"));
                labeltitle.setBackground(Color.decode("#3773E4"));
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.white);
                labelaut.setBackground(Color.decode("#3773E4"));
                labelaut.setOpaque(true);
                labelaut.setForeground(Color.white);
            }
            
            @Override
            public void mouseClicked(MouseEvent evt){
                panelpodexpl.setVisible(false);
                jScrollPane3.setVisible(false);
                jScrollPane2.setVisible(false);
                panelsubscribtion.setVisible(false);
                jScrollPane5.setVisible(false);
                panelmypodcast.setVisible(false);
                jScrollPane4.setVisible(false);
                panelpoddef.setVisible(false);
                panelpoddefnorth.removeAll();
                panelpoddefsouht.removeAll();
                if(userid>-1){
                     Connection cn; 
                    PreparedStatement pr;
                    ResultSet rs;
                    class.forName("com.mysql.jdbc.Driver");
                    try {
                        cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                        pr=cn.prepareStatement("SELECT * FROM follow WHERE iduser=? AND idpod=?");
                        pr.setString(1, String.valueOf(userid));
                        pr.setString(2, String.valueOf(podid));
                        rs=pr.executeQuery();
                        if(rs.next()){
                             creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 1);
                             getepisodes(podid,0,img);
                        }
                        else{
                            creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                            getepisodes(podid,0,img);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else{
                    creatpanelpoddefinition(podid, img, podtitle, podaut, poddescription, 0);
                    getepisodes(podid,0,img);
                }
                
                jScrollPane4.setVisible(true);
                panelpoddef.setVisible(true);
                
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                panelpod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                panelpod.setBackground(Color.white);
                labeltitle.setBackground(Color.white);
                labeltitle.setOpaque(true);
                labeltitle.setForeground(Color.black);
                labelaut.setBackground(Color.white);
                labelaut.setOpaque(true);
                labelaut.setForeground(new Color(153, 153, 153));
            }
            
            
        });
        panelpodexpl.add(panelpod);
    }
    
    void getpodcastexplore(){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        String poddescription=null;
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
              if(userid!=this.userid){
                podtitle=rs.getString(3);
                poddescription=rs.getString(4);
                imgd=rs.getBytes(5);
                pr=cn.prepareStatement("SELECT lastname,firstname FROM user WHERE iduser=?");
                pr.setString(1,String.valueOf(userid));
                rs2=pr.executeQuery();
                if(rs2.next()){
                    lastename=rs2.getString(1);
                    firstname=rs2.getString(2);
                    podaut=lastename+" "+firstname+" ";
                    creatpanelpod(podid, podtitle, podaut,poddescription, imgd);
                }
                else{
                    System.out.println("erreur user id podcast \n");
                }
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

        menubar = new javax.swing.JPanel();
        logopanel = new javax.swing.JPanel();
        labellogo = new javax.swing.JLabel();
        panelreglog = new javax.swing.JPanel();
        labelreg = new javax.swing.JLabel();
        labellogin = new javax.swing.JLabel();
        panelrechcreatupload = new javax.swing.JPanel();
        panelrech = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textrech = new javax.swing.JTextField();
        labelrech = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelcreatupload = new javax.swing.JPanel();
        labelcreatpod = new javax.swing.JLabel();
        labelupload = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        labelexplore = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        labelmypod = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelsubscription = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelpodexpl = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelpoddef = new javax.swing.JPanel();
        panelpoddefnorth = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelpoddefsouht = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelsubscribtion = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        panelmypodcast = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        panelrecherche = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 241, 241));

        menubar.setBackground(new java.awt.Color(233, 242, 245));
        menubar.setPreferredSize(new java.awt.Dimension(982, 101));
        menubar.setLayout(new java.awt.BorderLayout());

        logopanel.setBackground(new java.awt.Color(233, 242, 245));
        logopanel.setPreferredSize(new java.awt.Dimension(147, 102));
        logopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labellogo.setPreferredSize(new java.awt.Dimension(80, 80));
        logopanel.add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 80));

        menubar.add(logopanel, java.awt.BorderLayout.LINE_START);

        panelreglog.setBackground(new java.awt.Color(233, 242, 245));
        panelreglog.setPreferredSize(new java.awt.Dimension(177, 102));
        panelreglog.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 18));

        labelreg.setBackground(new java.awt.Color(255, 255, 255));
        labelreg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelreg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelreg.setText("Register");
        labelreg.setOpaque(true);
        labelreg.setPreferredSize(new java.awt.Dimension(68, 22));
        labelreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelregMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelregMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelregMouseExited(evt);
            }
        });
        panelreglog.add(labelreg);

        labellogin.setBackground(new java.awt.Color(55, 115, 228));
        labellogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labellogin.setForeground(new java.awt.Color(255, 255, 255));
        labellogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labellogin.setText("Log in");
        labellogin.setOpaque(true);
        labellogin.setPreferredSize(new java.awt.Dimension(68, 22));
        labellogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelloginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelloginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelloginMouseExited(evt);
            }
        });
        panelreglog.add(labellogin);

        menubar.add(panelreglog, java.awt.BorderLayout.LINE_END);

        panelrechcreatupload.setBackground(new java.awt.Color(233, 242, 245));
        panelrechcreatupload.setPreferredSize(new java.awt.Dimension(658, 102));
        panelrechcreatupload.setLayout(new java.awt.GridLayout(2, 1));

        panelrech.setBackground(new java.awt.Color(233, 242, 245));
        panelrech.setPreferredSize(new java.awt.Dimension(664, 51));
        panelrech.setLayout(new javax.swing.BoxLayout(panelrech, javax.swing.BoxLayout.LINE_AXIS));

        jLabel8.setText("             ");
        panelrech.add(jLabel8);

        jLabel9.setText("          ");
        panelrech.add(jLabel9);

        jLabel10.setText("           ");
        panelrech.add(jLabel10);

        textrech.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textrech.setForeground(new java.awt.Color(102, 102, 102));
        textrech.setText("Research a podcast or enter a tag");
        textrech.setPreferredSize(new java.awt.Dimension(100, 22));
        textrech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textrechMouseClicked(evt);
            }
        });
        panelrech.add(textrech);

        labelrech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        labelrech.setPreferredSize(new java.awt.Dimension(37, 20));
        labelrech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelrechMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelrechMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelrechMouseExited(evt);
            }
        });
        panelrech.add(labelrech);

        jLabel6.setText("             ");
        panelrech.add(jLabel6);

        jLabel7.setText("       ");
        panelrech.add(jLabel7);

        panelrechcreatupload.add(panelrech);

        panelcreatupload.setBackground(new java.awt.Color(233, 242, 245));
        panelcreatupload.setPreferredSize(new java.awt.Dimension(664, 51));
        panelcreatupload.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 17, 17));

        labelcreatpod.setBackground(new java.awt.Color(55, 115, 228));
        labelcreatpod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelcreatpod.setForeground(new java.awt.Color(255, 255, 255));
        labelcreatpod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        labelcreatpod.setText("Creat a new podcast channel");
        labelcreatpod.setOpaque(true);
        labelcreatpod.setPreferredSize(new java.awt.Dimension(225, 30));
        labelcreatpod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcreatpodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelcreatpodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelcreatpodMouseExited(evt);
            }
        });
        panelcreatupload.add(labelcreatpod);

        labelupload.setBackground(new java.awt.Color(255, 255, 255));
        labelupload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Upload.png"))); // NOI18N
        labelupload.setText("Upload a new episode");
        labelupload.setOpaque(true);
        labelupload.setPreferredSize(new java.awt.Dimension(200, 30));
        labelupload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labeluploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labeluploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labeluploadMouseExited(evt);
            }
        });
        panelcreatupload.add(labelupload);

        panelrechcreatupload.add(panelcreatupload);

        menubar.add(panelrechcreatupload, java.awt.BorderLayout.CENTER);

        getContentPane().add(menubar, java.awt.BorderLayout.PAGE_START);

        sidebar.setBackground(new java.awt.Color(233, 242, 245));
        sidebar.setPreferredSize(new java.awt.Dimension(149, 540));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelexplore.setBackground(new java.awt.Color(233, 242, 245));
        labelexplore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelexplore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Compass.png"))); // NOI18N
        labelexplore.setText("  Explore");
        labelexplore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelexploreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelexploreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelexploreMouseExited(evt);
            }
        });
        sidebar.add(labelexplore, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 40));

        jPanel8.setBackground(new java.awt.Color(123, 184, 241));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 10, 40));

        labelmypod.setBackground(new java.awt.Color(233, 242, 245));
        labelmypod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelmypod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Microphone.png"))); // NOI18N
        labelmypod.setText(" My podcast");
        labelmypod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelmypodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelmypodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelmypodMouseExited(evt);
            }
        });
        sidebar.add(labelmypod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 140, 40));

        jPanel9.setBackground(new java.awt.Color(233, 242, 245));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 10, 40));

        labelsubscription.setBackground(new java.awt.Color(233, 242, 245));
        labelsubscription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelsubscription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermometer.png"))); // NOI18N
        labelsubscription.setText("Subscribtion");
        labelsubscription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelsubscriptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelsubscriptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelsubscriptionMouseExited(evt);
            }
        });
        sidebar.add(labelsubscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 130, 150, 40));

        jPanel10.setBackground(new java.awt.Color(233, 242, 245));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 10, 40));

        getContentPane().add(sidebar, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(895, 537));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(241, 241, 241));
        jPanel3.setPreferredSize(new java.awt.Dimension(895, 436));
        jPanel3.setLayout(new java.awt.CardLayout());

        jScrollPane3.setBackground(new java.awt.Color(241, 241, 241));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane3.setViewportView(panelpodexpl);

        panelpodexpl.setBackground(new java.awt.Color(241, 241, 241));
        panelpodexpl.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelpodexpl.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane3.setViewportView(panelpodexpl);

        jPanel3.add(jScrollPane3, "card2");

        jScrollPane4.setBackground(new java.awt.Color(241, 241, 241));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane4.setViewportView(panelpoddef);

        panelpoddef.setBackground(new java.awt.Color(241, 241, 241));
        panelpoddef.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelpoddef.setLayout(new java.awt.BorderLayout());

        panelpoddefnorth.setBackground(new java.awt.Color(255, 255, 255));
        panelpoddefnorth.setPreferredSize(new java.awt.Dimension(1000, 281));
        panelpoddefnorth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelpoddef.add(panelpoddefnorth, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane1.setViewportView(panelpoddefsouht);

        panelpoddefsouht.setBackground(new java.awt.Color(245, 245, 245));
        panelpoddefsouht.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelpoddefsouht.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 27, 20));
        jScrollPane1.setViewportView(panelpoddefsouht);

        panelpoddef.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jScrollPane4.setViewportView(panelpoddef);

        jPanel3.add(jScrollPane4, "card3");

        jScrollPane2.setBackground(new java.awt.Color(241, 241, 241));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane2.setViewportView(panelsubscribtion);

        panelsubscribtion.setBackground(new java.awt.Color(241, 241, 241));
        panelsubscribtion.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelsubscribtion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane2.setViewportView(panelsubscribtion);

        jPanel3.add(jScrollPane2, "card4");

        jScrollPane5.setBackground(new java.awt.Color(241, 241, 241));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane5.setViewportView(panelmypodcast);

        panelmypodcast.setBackground(new java.awt.Color(241, 241, 241));
        panelmypodcast.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelmypodcast.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane5.setViewportView(panelmypodcast);

        jPanel3.add(jScrollPane5, "card5");

        jScrollPane6.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane6.setViewportView(panelrecherche);

        panelrecherche.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelrecherche.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane6.setViewportView(panelrecherche);

        jPanel3.add(jScrollPane6, "card6");

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelexploreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelexploreMouseClicked
        // TODO add your handling code here:

        jPanel9.setBackground(Color.decode("#E9F2F5"));
        jPanel10.setBackground(Color.decode("#E9F2F5"));
        jPanel8.setBackground(Color.decode("#7BB8F1"));
        labelexplore.setBackground(Color.decode("#7BB8F1"));
        labelexplore.setBackground(Color.decode("#E9F2F5"));
        jScrollPane4.setVisible(false);
        panelpoddef.setVisible(false);
        jScrollPane5.setVisible(false);
        panelmypodcast.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
        jScrollPane6.setVisible(false);
        panelrecherche.setVisible(false);
        jScrollPane3.setVisible(false);
        panelpodexpl.setVisible(false);
        panelpodexpl.removeAll();
        getpodcastexplore();
         jScrollPane3.setVisible(true);
        panelpodexpl.setVisible(true);
        
    }//GEN-LAST:event_labelexploreMouseClicked

    private void labelexploreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelexploreMouseEntered
        // TODO add your handling code here:
        labelexplore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelexplore.setBackground(Color.decode("#BEFFFF"));
        labelexplore.setOpaque(true);
    }//GEN-LAST:event_labelexploreMouseEntered

    private void labelexploreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelexploreMouseExited
        // TODO add your handling code here:
        labelexplore.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        labelexplore.setBackground(Color.decode("#E9F2F5"));
        labelexplore.setOpaque(true);
    }//GEN-LAST:event_labelexploreMouseExited

    private void labelmypodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelmypodMouseClicked
        // TODO add your handling code here:
        if(userid>-1){
        jPanel8.setBackground(Color.decode("#E9F2F5"));
        jPanel10.setBackground(Color.decode("#E9F2F5"));
        jPanel9.setBackground(Color.decode("#7BB8F1"));
        jScrollPane3.setVisible(false);
        panelpodexpl.setVisible(false);
        jScrollPane4.setVisible(false);
        panelpoddef.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
        jScrollPane6.setVisible(false);
        panelrecherche.setVisible(false);
        jScrollPane5.setVisible(false);
        panelmypodcast.setVisible(false);
        panelmypodcast.removeAll();
        JPanel jPanel2=new JPanel();
        JLabel jLabel1=new JLabel();
        jPanel2.setBackground(new java.awt.Color(241, 241, 241));
        jPanel2.setPreferredSize(new java.awt.Dimension(1074, 101));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setBackground(new java.awt.Color(241, 241, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Podcasts Channels");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 390, 40));
        panelmypodcast.add(jPanel2);
        getmypod(userid);
        jScrollPane5.setVisible(true);
        panelmypodcast.setVisible(true);
        }
        else{
            new Login(this,true).show();
        }
    }//GEN-LAST:event_labelmypodMouseClicked

    private void labelmypodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelmypodMouseEntered
        labelmypod.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelmypod.setBackground(Color.decode("#BEFFFF"));
        labelmypod.setOpaque(true);
    }//GEN-LAST:event_labelmypodMouseEntered

    private void labelmypodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelmypodMouseExited
         labelmypod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        labelmypod.setBackground(Color.decode("#E9F2F5"));
         labelmypod.setOpaque(true);
    }//GEN-LAST:event_labelmypodMouseExited

    private void labelsubscriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelsubscriptionMouseClicked
        // TODO add your handling code here:
        if(userid>-1){
        jPanel8.setBackground(Color.decode("#E9F2F5"));
        jPanel9.setBackground(Color.decode("#E9F2F5"));
        jPanel10.setBackground(Color.decode("#7BB8F1"));
        jScrollPane3.setVisible(false);
        panelpodexpl.setVisible(false);
        jScrollPane4.setVisible(false);
        panelpoddef.setVisible(false);
        jScrollPane5.setVisible(false);
        panelmypodcast.setVisible(false);
        jScrollPane6.setVisible(false);
        panelrecherche.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
        panelsubscribtion.removeAll();
        JPanel jPanel2=new JPanel();
        JLabel jLabel1=new JLabel();
        jPanel2.setBackground(new java.awt.Color(241, 241, 241));
        jPanel2.setPreferredSize(new java.awt.Dimension(1074, 101));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setBackground(new java.awt.Color(241, 241, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Subscribtion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 390, 40));
        panelsubscribtion.add(jPanel2);
        getpodfollowed(userid);
        jScrollPane2.setVisible(true);
        panelsubscribtion.setVisible(true);
        }
        else{
            new Login(this,true).show();
        }
        
    }//GEN-LAST:event_labelsubscriptionMouseClicked

    private void labelsubscriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelsubscriptionMouseEntered
        // TODO add your handling code here:
        labelsubscription.setCursor(new Cursor(Cursor.HAND_CURSOR));
         labelsubscription.setBackground(Color.decode("#BEFFFF"));
        labelsubscription.setOpaque(true);
    }//GEN-LAST:event_labelsubscriptionMouseEntered

    private void labelsubscriptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelsubscriptionMouseExited
        // TODO add your handling code here:
         labelsubscription.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        labelsubscription.setBackground(Color.decode("#E9F2F5"));
         labelsubscription.setOpaque(true);
    }//GEN-LAST:event_labelsubscriptionMouseExited

    private void labelloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelloginMouseEntered
        // TODO add your handling code here:
        labellogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelloginMouseEntered

    private void labelloginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelloginMouseExited
        // TODO add your handling code here:
        labellogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelloginMouseExited

    private void labelloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelloginMouseClicked
        // TODO add your handling code here:
        if(labellogin.getText().equals("Log in")){
            new Login(this,true).show();
            if(dis==1)
                dispose();
        }
        else{
            new Profile(this, true).show();
        }
    }//GEN-LAST:event_labelloginMouseClicked

    private void labelregMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregMouseEntered
        // TODO add your handling code here:
        labelreg.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelregMouseEntered

    private void labelregMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregMouseExited
        // TODO add your handling code here:
        labelreg.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelregMouseExited

    private void labelregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelregMouseClicked
        // TODO add your handling code here:
        if(labelreg.getText().equals("Register")){
            new Register(this, true).show();
        }
        else{
            labelreg.setText("Register");
            labellogin.setVisible(false);
            labellogin.setBackground(Color.decode("#3773E4"));
            labellogin.setForeground(Color.white);
            labellogin.setText("Log in");
            labellogin.setVisible(true);
            userid=-1;
            jPanel9.setBackground(Color.decode("#E9F2F5"));
        jPanel10.setBackground(Color.decode("#E9F2F5"));
        jPanel8.setBackground(Color.decode("#7BB8F1"));
        labelexplore.setBackground(Color.decode("#7BB8F1"));
        labelexplore.setBackground(Color.decode("#E9F2F5"));
        jScrollPane4.setVisible(false);
        panelpoddef.setVisible(false);
        jScrollPane5.setVisible(false);
        panelmypodcast.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
        jScrollPane6.setVisible(false);
        panelrecherche.setVisible(false);
        jScrollPane3.setVisible(false);
        panelpodexpl.setVisible(false);
        panelpodexpl.removeAll();
        getpodcastexplore();
         jScrollPane3.setVisible(true);
        panelpodexpl.setVisible(true);
        }
    }//GEN-LAST:event_labelregMouseClicked

    private void labelcreatpodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcreatpodMouseEntered
        // TODO add your handling code here:
        labelcreatpod.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_labelcreatpodMouseEntered

    private void labelcreatpodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcreatpodMouseExited
        // TODO add your handling code here:
        labelcreatpod.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcreatpodMouseExited

    private void labelcreatpodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcreatpodMouseClicked
        // TODO add your handling code here:
        if(userid>-1){
            new Creatpod(this, true).show();
        }
        else{
            new Login(this, true).show();
        }
    }//GEN-LAST:event_labelcreatpodMouseClicked

    private void labeluploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labeluploadMouseEntered
        // TODO add your handling code here:
        labelupload.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labeluploadMouseEntered

    private void labeluploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labeluploadMouseExited
        // TODO add your handling code here:
        labelupload.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labeluploadMouseExited

    private void labeluploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labeluploadMouseClicked
        // TODO add your handling code here:
        if(userid>-1){
            Connection cn;
            PreparedStatement pr;
            ResultSet rs;
            class.forName("com.mysql.jdbc.Driver");
            try {
                cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/podcasthightech","root","");
                pr=cn.prepareStatement("SELECT * FROM podcast WHERE iduser=?");
                pr.setString(1,String.valueOf(userid));
                rs=pr.executeQuery();
                if(rs.next()){
                    new Upload(this, true).show();
                }
                else{
                    JOptionPane.showMessageDialog(null, "You don't have any podcast channel , creat one so that you can upload an episode");
                    new Creatpod(this,true).show();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Userpodcasts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            new Login(this, true).show();
        }
    }//GEN-LAST:event_labeluploadMouseClicked

    private void labelrechMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelrechMouseEntered
        // TODO add your handling code here:
        labelrech.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }//GEN-LAST:event_labelrechMouseEntered

    private void labelrechMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelrechMouseExited
        // TODO add your handling code here:
        labelrech.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
    }//GEN-LAST:event_labelrechMouseExited

    private void labelrechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelrechMouseClicked
        // TODO add your handling code here:
        jPanel8.setBackground(Color.decode("#E9F2F5"));
        jPanel9.setBackground(Color.decode("#E9F2F5"));
        jScrollPane3.setVisible(false);
        panelpodexpl.setVisible(false);
        jScrollPane4.setVisible(false);
        panelpoddef.setVisible(false);
        jScrollPane5.setVisible(false);
        panelmypodcast.setVisible(false);
        jScrollPane2.setVisible(false);
        panelsubscribtion.setVisible(false);
        jScrollPane6.setVisible(false);
        panelrecherche.setVisible(false);
        panelrecherche.removeAll();
        JPanel jPanel2=new JPanel();
        JLabel jLabel1=new JLabel();
        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setPreferredSize(new java.awt.Dimension(1074, 101));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Research Result");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 390, 40));
        panelrecherche.add(jPanel2);
        getpodresearched(userid);
        jScrollPane6.setVisible(true);
        panelrecherche.setVisible(true);
    }//GEN-LAST:event_labelrechMouseClicked

    private void textrechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textrechMouseClicked
        // TODO add your handling code here:
        if(fist==0){
            textrech.setText("");
            textrech.setForeground(Color.black);
            fist=1;
        }
    }//GEN-LAST:event_textrechMouseClicked

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
            java.util.logging.Logger.getLogger(Userpodcasts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Userpodcasts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Userpodcasts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Userpodcasts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Userpodcasts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelcreatpod;
    private javax.swing.JLabel labelexplore;
    private javax.swing.JLabel labellogin;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labelmypod;
    private javax.swing.JLabel labelrech;
    private javax.swing.JLabel labelreg;
    private javax.swing.JLabel labelsubscription;
    private javax.swing.JLabel labelupload;
    private javax.swing.JPanel logopanel;
    private javax.swing.JPanel menubar;
    private javax.swing.JPanel panelcreatupload;
    private javax.swing.JPanel panelmypodcast;
    private javax.swing.JPanel panelpoddef;
    private javax.swing.JPanel panelpoddefnorth;
    private javax.swing.JPanel panelpoddefsouht;
    private javax.swing.JPanel panelpodexpl;
    private javax.swing.JPanel panelrech;
    private javax.swing.JPanel panelrechcreatupload;
    private javax.swing.JPanel panelrecherche;
    private javax.swing.JPanel panelreglog;
    private javax.swing.JPanel panelsubscribtion;
    private javax.swing.JPanel sidebar;
    private javax.swing.JTextField textrech;
    // End of variables declaration//GEN-END:variables
}
