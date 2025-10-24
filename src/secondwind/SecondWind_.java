package secondwind;

import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.table.DefaultTableModel;

class CustomProgressBarUI extends BasicProgressBarUI {

    private Color customBackgroundColor;
    private Color customTextColor;
    
    public CustomProgressBarUI(Color customBackgroundColor, Color customTextColor) {
        this.customBackgroundColor = customBackgroundColor;
        this.customTextColor = customTextColor;
    }

    public static ComponentUI createUI(JComponent c) {
        return new CustomProgressBarUI(Color.GREEN, Color.BLACK); // Change Color.GREEN to your desired color
    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);
        if (progressBar.isIndeterminate()) {
            paintIndeterminate(g, c);
        } else {
            Insets b = progressBar.getInsets();
            int barRectWidth = progressBar.getWidth() - (b.right + b.left);
            int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
            int amountFull = getAmountFull(b, barRectWidth, barRectHeight);
            
            g.setColor(customBackgroundColor); // Change background color here
            g.fillRect(b.left, b.top, amountFull, barRectHeight);
            
            String hpText = String.valueOf(progressBar.getValue()) + "%";
            g.setColor(customTextColor);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(hpText);
            int textHeight = fm.getAscent();
            int x = (c.getWidth() - textWidth) / 2;
            int y = ((c.getHeight() - textHeight) / 2) + fm.getAscent();
            g.drawString(hpText, x, y);
        }
    }
}
    
public class SecondWind_ extends javax.swing.JFrame implements SQL {

    /**
     * Creates new form MainMenu
     */
    int ctr=0;
    boolean activeBag = false;
    boolean activeAtk = false;
    boolean activePlayer = false;
    boolean failed = false;
    private int Chara; //Character Chosen
    private int opt;
    private int action; //Move chosen
    private int Score = 0;     //Based on Damage
    private int story = 0;
    boolean used1 = false;
    boolean used2 = false;
    boolean used3 = false;
    boolean used4 = false;

    public void setScore(int Score) {
        this.Score = Score;
    }
    
    public int getScore(){
        return this.Score;
    }
    
    Connection con;
    Statement st;
    ArrayList<Leaderboards>leaderboards=new ArrayList<>();
    
    public SecondWind_() {
        initComponents();
        fetch();
        //pnlTutorial.setVisible(false);
        pnlIntro.setVisible(false);
        lblIntro2.setVisible(false);
        lblIntro3.setVisible(false);
        lblIntro4.setVisible(false);
        lblIntro5.setVisible(false);
        lblIntro6.setVisible(false);
        lblIntro7.setVisible(false);
        lblAssassin.setVisible(false);
        pnlChapter1Hallway.setVisible(false);
        lblChapter1Elevator.setVisible(false);
        lblMonster.setVisible(false);
        //lblAssassin1.setVisible(false);
        pnlChapter2Elevator.setVisible(false);
        lblChapter2Hallway.setVisible(false);
        pnlChapter2Hallway.setVisible(false);
        lblChapter2Hallway1.setVisible(false);
//        lblMageAlter.setVisible(false);
        pnlChapter3Stair.setVisible(false);
      //  lblAssassin4.setVisible(false);
    //    lblMageAlter1.setVisible(false);
        pnlEnding.setVisible(false);
        pnlLeaderBoards.setVisible(false);
        lblShielder.setVisible(false);
        lblMage.setVisible(false);
        pnlChapter1Elevator.setVisible(false);
        pnlCharacterSelection.setVisible(false);
        pnlBattle.setVisible(false);
        
        
        
        pnlChapter2Elevator.setVisible(false);
        lblChapter2Hallway.setVisible(false);
        lblFamilliarC2E.setVisible(false);
        lblAssassinC2E.setVisible(false);
        lblShielderAlterC2E.setVisible(false);
        pnlChapter2Hallway.setVisible(false);
        lblChapter2Hallway1.setVisible(false);
        pnlEnding.setVisible(false);
        pnlLeaderBoards.setVisible(false);
        lblShielder.setVisible(false);
        lblMage.setVisible(false);
        pnlChapter1Elevator.setVisible(false);
        pnlCharacterSelection.setVisible(false);
        
        //Battle Characters
        pnlBattle.setVisible(false);
        lblMage1.setVisible(false);
        lblShielder1.setVisible(false);
        //Stage 1 & 3
        lblEnemy_Intro.setVisible(false);
        lblEnemy_dmg_Intro.setVisible(false);
        //Stage 2
        lblEnemy_C1H.setVisible(false);
        lblEnemy_dmg_C1H.setVisible(false);
        //Chapter2
        lblEnemy_C2E.setVisible(false);
        lblEnemyAvatar_C2E.setVisible(false);
        
        //Chapter1H
        lblAssassinC1H.setVisible(false);
        lblMageC1H.setVisible(false);
        lblShielderC1H.setVisible(false);
        
        //Chapter1E
        lblAssassinC1E.setVisible(false);
        lblMageC1E.setVisible(false);
        lblShielderC1E.setVisible(false);
        lblMonsterC1E.setVisible(false);
        //Chapter2E
        lblAssassinC2E.setVisible(false);
        lblMageC2E.setVisible(false);
        lblShielderC2E.setVisible(false);
        lblShielderAlterMarkC2E.setVisible(false);
        lblAssassinAlterMarkC2E.setVisible(false);
        lblMageAlterMarkC2E.setVisible(false);
        lblShielderAlterC2E.setVisible(false);
        lblAssassinAlterC2E.setVisible(false);
        lblMageAlterC2E.setVisible(false);
        
        lblEnemy_C2E.setVisible(false);
        lblEnemy_C2E1.setVisible(false);
        lblEnemy_C2E2.setVisible(false);
        lblEnemyAvatar_C2E.setVisible(false);
        lblEnemyAvatar_C2E1.setVisible(false);
        lblEnemyAvatar_C2E2.setVisible(false);
        
        
        //Chapter2H
        lblAssassinC2H.setVisible(false);
        lblMageC2H.setVisible(false);
        lblShielderC2H.setVisible(false);
        lblAssassinC2H.setVisible(false);
        lblMageAlterC2H.setVisible(false);
        lblShielderAlterC2H.setVisible(false);
        lblAssassinAlterC2H.setVisible(false);
        
        //Chapter3S
        
        pnlChapter3Stair.setVisible(false);
        lblAlienKingC3S.setVisible(false);
        lblC3SThrone.setVisible(false);
        lblC3SStair.setVisible(false);
        lblMageAlterC3S.setVisible(false);
        lblShielderAlterC3S.setVisible(false);
        lblAssassinAlterC3S.setVisible(false);
        
        lblAssassinC3S.setVisible(false);
        lblMageC3S.setVisible(false);
        lblShielderC3S.setVisible(false);
        lblC3SBlackScreen.setVisible(false);
        
        lblAlienKingAvatar.setVisible(false);
        lblAlienKing.setVisible(false);
        lblThrone.setVisible(false);
        lblC3SThrone.setVisible(false);
        
        //Chapter3E
        pnlChapter3Ending.setVisible(false);
        lblAlienKingC3E.setVisible(false);
        lblGoddessC3E.setVisible(false);
        lblC3EThrone1.setVisible(false);
        lblC3EThrone2.setVisible(false);
        lblC3EThrone3.setVisible(false);
        lblAssassinC3E.setVisible(false);
        lblShielderC3E.setVisible(false);
        lblMageC3E.setVisible(false);
        lblC3ESky.setVisible(false);
        lblC3ECredits.setVisible(false);
        
        //Battle UI
        lblSkill_S.setVisible(false);
        lblSkill_A.setVisible(false);
        lblSkill_M.setVisible(false);
        lblAtk.setVisible(false);
        
        
        //Battle Splash
        lblChapter1HBG.setVisible(false);
        lblChapter1EBG.setVisible(false);
        lblBattleFailed.setVisible(false);
        lblBattleFatal.setVisible(false);
        lblBattleFinished.setVisible(false);
        lblBattleStart.setVisible(false);
        
        
        pnlBag.setVisible(activeBag);
        pnlAttack.setVisible(activeAtk);
        pbEnemyHP.setValue(100);
        pbPlayerHP.setValue(100);
        pbEnemyHP.setUI(new CustomProgressBarUI(Color.RED, Color.WHITE));
        pbPlayerHP.setUI(new CustomProgressBarUI(Color.RED, Color.WHITE));
        pbPlayerMP.setValue(100);
        pbPlayerMP.setUI(new CustomProgressBarUI(Color.BLUE, Color.WHITE));

        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }
    
    private static Clip clip;
    void playMusic(String resourcePath){
        try{
            stopMusic();
            // load music from src path
            InputStream audioSrc = getClass().getResourceAsStream(resourcePath);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);

            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(1);//Clip.LOOP_CONTINUOUSLY
            clip.start();
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
    
    void stopMusic(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    Character hero;
    Minion minion;
    Enemy general;
    
    //Timer Object
    Timer timer;
    
    public void setChara(int Chara){
        this.Chara = Chara;
        switch (Chara) {
            case 1:
                hero = new Assassin();
                break;
            case 2:
                hero = new Shielder();
                break;
            case 3:
                hero = new Mage();
                break;
            default:
                break;
        }
    }

    public int getChara(){
        return Chara;
    }

    public int getOpt() {
        return opt;
    }

    public int getAction() {
        return action;
    }
    
    public void buttons(int active){
        if (active == 0){
            btnAttack.setEnabled(false);
            btnDefend.setEnabled(false);
            btnBag.setEnabled(false);
        }else {
            btnAttack.setEnabled(true);
            btnDefend.setEnabled(true);
            btnBag.setEnabled(true);
        }
    }
    
    public void checkWin(){
        if (story==0 || story==1 || story==2){
            if (hero.isAlive() && !minion.isAlive()) {
                lblLog.setText(hero.getName() + " defeated " + minion.getName() + "!");
                lblBattleFinished.setVisible(true);
                    timer = new Timer(1800, e -> {
                        lblBattleFinished.setVisible(false);
                    }); 
                    timer.setRepeats(false);
                    timer.start();
                ctr=0;
                story++;
                progress();
            }else if (!hero.isAlive() && minion.isAlive()){
                lblLog.setText(hero.getName() + " was defeated by " + minion.getName() + ".");
                lblBattleFailed.setVisible(true);
                timer = new Timer(1800, e-> {
                    stopMusic();
                    playMusic("/Music/Ending.wav");
                    pnlBattle.setVisible(false);
                    pnlEnding.setVisible(true);
                    failed = true;
                });
                timer.setRepeats(false);
                timer.start();
                ctr=0;
            }
        }else if (story==3){
            if (hero.isAlive() && !general.isAlive()) {
                lblLog.setText(hero.getName() + " defeated " + general.getName() + "!");
                lblBattleFinished.setVisible(true);
                    timer = new Timer(1800, e -> {
                        lblBattleFinished.setVisible(false);
                    }); 
                    timer.setRepeats(false);
                    timer.start();
                ctr=0;
                story++;
                progress();
            }else if (!hero.isAlive() && general.isAlive()){
                lblLog.setText(hero.getName() + " was defeated by " + general.getName() + ".");
                lblBattleFailed.setVisible(true);
                timer = new Timer(1800, e-> {
                    stopMusic();
                    playMusic("/Music/Ending.wav");
                    pnlBattle.setVisible(false);
                    pnlEnding.setVisible(true);
                    failed = true;
                });
                timer.setRepeats(false);
                timer.start();
                ctr=0;
            }
        }else if (story==4){
            if (hero.isAlive() && !general.isAlive()) {
                lblLog.setText(hero.getName() + " defeated " + general.getName() + "!");
                lblBattleFinished.setVisible(true);
                    timer = new Timer(1800, e -> {
                        lblBattleFinished.setVisible(false);
                    }); 
                    timer.setRepeats(false);
                    timer.start();
                ctr=0;
                story++;
                progress();
            }else if (!hero.isAlive() && general.isAlive()){
                lblLog.setText(hero.getName() + " was defeated by " + general.getName() + ".");
                lblBattleFailed.setVisible(true);
                timer = new Timer(1800, e-> {
                    stopMusic();
                    playMusic("/Music/Ending.wav");
                    pnlBattle.setVisible(false);
                    pnlEnding.setVisible(true);
                    failed = true;
                });
                timer.setRepeats(false);
                timer.start();
                ctr=0;
            }
        }else if (story==5){
            if (hero.isAlive() && !general.isAlive()) {
                lblLog.setText(hero.getName() + " defeated " + general.getName() + "!");
                lblBattleFinished.setVisible(true);
                    timer = new Timer(1800, e -> {
                        lblBattleFinished.setVisible(false);
                    }); 
                    timer.setRepeats(false);
                    timer.start();
                ctr=0;
                story++;
                progress();
            }else if (!hero.isAlive() && general.isAlive()){
                lblLog.setText(hero.getName() + " was defeated by " + general.getName() + ".");
                lblBattleFailed.setVisible(true);
                timer = new Timer(1800, e-> {
                    stopMusic();
                    playMusic("/Music/Ending.wav");
                    pnlBattle.setVisible(false);
                    pnlEnding.setVisible(true);
                    failed = true;
                });
                timer.setRepeats(false);
                timer.start();
                ctr=0;
            }
        }
        
    }
    
    public void progress(){
        lblLog.setText("");
        timer = new Timer(1800, e -> {
            if (story==1){
                pnlBattle.setVisible(false);
                pnlChapter1Hallway.setVisible(true);
                minion = new Minion("Murlock",100);
                pbEnemyHP.setValue(minion.getHealth());
            }else if (story==2) {
                pnlBattle.setVisible(false);
                pnlChapter1Elevator.setVisible(true);
                lblChapter1Elevator.setVisible(true);
                minion = new Minion("Krain",100);
                pbEnemyHP.setValue(minion.getHealth());
            }else if (story==3){
                pnlBattle.setVisible(false);
                pnlChapter2Elevator.setVisible(true);
                lblChapter2Elevator.setVisible(true);
                //Put General Here
                if(Chara==1)
                    general = new enemyShielder();
                else if (Chara==2)
                    general = new enemyMage();                  
                else if(Chara==3)
                    general = new enemyAssassin();
                pbEnemyHP.setMaximum(general.getHealth());
                pbEnemyHP.setValue(general.getHealth());
            }else if (story==4){
                pnlBattle.setVisible(false);
                pnlChapter2Hallway.setVisible(true);
                lblChapter2Hallway.setVisible(true);
                //Put General Here
                if(Chara==1)
                    general = new enemyMage();
                else if (Chara==2)
                    general = new enemyAssassin();                  
                else if(Chara==3)
                    general = new enemyShielder();
                pbEnemyHP.setMaximum(general.getHealth());
                pbEnemyHP.setValue(general.getHealth());
            }else if (story==5){
                pnlBattle.setVisible(false);
                pnlChapter3Stair.setVisible(true);
                lblC3SThrone.setVisible(true);
                //Alien King
                general = new alterBoss();
                pbEnemyHP.setMaximum(general.getHealth());
                pbEnemyHP.setValue(general.getHealth());
            }else {
                pnlBattle.setVisible(false);
                pnlChapter3Ending.setVisible(true);
                lblC3SThrone.setVisible(true);
            }
        });

        timer.setRepeats(false);
        timer.start(); 
    }
    
    public void turnAttack(int action){
        System.out.println("Score: "+getScore());
        
        buttons(0);
        boolean hasDefended=false;
        if (hero.isAlive() && minion.isAlive()) {

            //action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemy(minion);
                        lblLog.setText(hero.getName() + " performs a basic attack and deals " + hero.getDamage() + " damage!");
                        setScore(Score+=hero.getDamage());
                        lblAtk.setVisible(true);
                        //Damage Animation
                        if (story==0)
                            lblEnemy_dmg_Intro.setVisible(true);
                        else if (story==1)
                            lblEnemy_dmg_C1H.setVisible(true);
                        else if (story==2)
                            lblEnemy_dmg_Intro.setVisible(true);
                        buttons(0);
                        timer = new Timer(1600, e -> {
                            lblAtk.setVisible(false);
                            //Damage Animation
                            if (story==0)
                                lblEnemy_dmg_Intro.setVisible(false);
                            else if (story==1)
                                lblEnemy_dmg_C1H.setVisible(false);
                            else if (story==2)
                            lblEnemy_dmg_Intro.setVisible(false);
                            buttons(1);
                        });
                        timer.setRepeats(false);
                        timer.start();  
                        break;
                case 2: hero.defend();
                        if (hero.getDefend()){
                            lblLog.setText(hero.getName() + " successfully defends against the attack!");
                        }else {
                            lblLog.setText(hero.getName() + " fails to defend and takes " + hero.getDamageEnemy() + " damage!");
                        }
                        hasDefended=true;
                        buttons(1);
                        break;
                case 3: hero.skill(minion);
                        if (Chara==1 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            //Damage Animation
                            if (story==0)
                                lblEnemy_dmg_Intro.setVisible(true);
                            else if (story==1)
                                lblEnemy_dmg_C1H.setVisible(true);
                            else if (story==2)
                            lblEnemy_dmg_Intro.setVisible(true);
                            lblSkill_A.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                //Damage Animation
                                if (story==0)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                else if (story==1)
                                    lblEnemy_dmg_C1H.setVisible(false);
                                else if (story==2)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                lblSkill_A.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==2 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            //Damage Animation
                            if (story==0)
                                lblEnemy_dmg_Intro.setVisible(true);
                            else if (story==1)
                                lblEnemy_dmg_C1H.setVisible(true);
                            else if (story==2)
                            lblEnemy_dmg_Intro.setVisible(true);
                            lblSkill_S.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                //Damage Animation
                                if (story==0)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                else if (story==1)
                                    lblEnemy_dmg_C1H.setVisible(false);
                                else if (story==2)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                lblSkill_S.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==3 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            //Damage Animation
                            if (story==0)
                                lblEnemy_dmg_Intro.setVisible(true);
                            else if (story==1)
                                lblEnemy_dmg_C1H.setVisible(true);
                            else if (story==2)
                                lblEnemy_dmg_Intro.setVisible(true);
                            lblSkill_M.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                //Damage Animation
                                if (story==0)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                else if (story==1)
                                    lblEnemy_dmg_C1H.setVisible(false);
                                else if (story==2)
                                    lblEnemy_dmg_Intro.setVisible(false);
                                lblSkill_M.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else {
                            timer = new Timer(2000, e -> {
                                lblLog.setText(hero.getName() + " is out of energy!");
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        lblLog.setText(hero.getName() + " performs a special attack and deals " + hero.getDamage() + " damage!");
                        break;
            }
            if (minion.isAlive() && hasDefended==false) {
                minion.attackHero(hero);
                Timer timer = new Timer(2000, e -> {
                    lblLog.setText(minion.getName() + " attacks " + hero.getName() + " for " + minion.getDamage() + " damage!");
                    //pbPlayerHP.setValue(hero.getHealth());
                    buttons(1);
                });
                timer.setRepeats(false);
                timer.start();               
            }
            hasDefended=false;
            if (hero.getEnergy()<100){
            btnSPAtk.setEnabled(false);
            }else if (hero.getEnergy()==100){
                btnSPAtk.setEnabled(true);
            }
        }
        
        //Update UI Elements
        pbPlayerHP.setValue(hero.getHealth());
        pbPlayerMP.setValue(hero.getEnergy());
        lblNameP.setText(hero.getName());
        pbEnemyHP.setValue(minion.getHealth());
        checkWin();
    }

    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlMenu1 = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnHighScore = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblColumnL = new javax.swing.JLabel();
        lblColumnR = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pnlCharacterSelection = new javax.swing.JPanel();
        btnShielder = new javax.swing.JButton();
        btnMage = new javax.swing.JButton();
        btnArcher = new javax.swing.JButton();
        lblBG_CS = new javax.swing.JLabel();
        pnlIntro = new javax.swing.JPanel();
        btnNxt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDialogue = new javax.swing.JTextArea();
        lblDialogueBox = new javax.swing.JLabel();
        lblMage1 = new javax.swing.JLabel();
        lblShielder1 = new javax.swing.JLabel();
        lblAssassin = new javax.swing.JLabel();
        lblIntro7 = new javax.swing.JLabel();
        lblIntro6 = new javax.swing.JLabel();
        lblIntro5 = new javax.swing.JLabel();
        lblIntro4 = new javax.swing.JLabel();
        lblIntro3 = new javax.swing.JLabel();
        lblIntro2 = new javax.swing.JLabel();
        lblIntro1 = new javax.swing.JLabel();
        pnlEnding = new javax.swing.JPanel();
        pnlName = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblColumn1 = new javax.swing.JLabel();
        lblColumn2 = new javax.swing.JLabel();
        lblBG_Ending = new javax.swing.JLabel();
        pnlBattle = new javax.swing.JPanel();
        pnlTLayout = new javax.swing.JPanel();
        lblBattleFailed = new javax.swing.JLabel();
        lblBattleFatal = new javax.swing.JLabel();
        lblBattleFinished = new javax.swing.JLabel();
        lblBattleStart = new javax.swing.JLabel();
        lblSkill_M = new javax.swing.JLabel();
        lblSkill_S = new javax.swing.JLabel();
        lblSkill_A = new javax.swing.JLabel();
        lblAtk = new javax.swing.JLabel();
        pnlBag = new javax.swing.JPanel();
        btnHP1 = new javax.swing.JButton();
        btnHP2 = new javax.swing.JButton();
        btnMP1 = new javax.swing.JButton();
        btnMP2 = new javax.swing.JButton();
        lblBagUI = new javax.swing.JLabel();
        pnlAttack = new javax.swing.JPanel();
        btnAtk = new javax.swing.JButton();
        btnSPAtk = new javax.swing.JButton();
        lblAttackUI = new javax.swing.JLabel();
        lblNameE = new javax.swing.JLabel();
        lblEnemyBorder = new javax.swing.JLabel();
        lblAlienKingAvatar = new javax.swing.JLabel();
        lblEnemyAvatar_C2E = new javax.swing.JLabel();
        lblEnemyAvatar_C2E1 = new javax.swing.JLabel();
        lblEnemyAvatar_C2E2 = new javax.swing.JLabel();
        lblEnemyAvatar_C1H = new javax.swing.JLabel();
        lblEnemyAvatar_Intro = new javax.swing.JLabel();
        _____________ = new javax.swing.JPanel();
        lblHPBarE = new javax.swing.JLabel();
        pbEnemyHP = new javax.swing.JProgressBar();
        lblNameP = new javax.swing.JLabel();
        lblPlayerBorder = new javax.swing.JLabel();
        lblMage = new javax.swing.JLabel();
        lblShielder = new javax.swing.JLabel();
        lblAassassin = new javax.swing.JLabel();
        lblMPBar = new javax.swing.JLabel();
        pbPlayerMP = new javax.swing.JProgressBar();
        lblHPBarP = new javax.swing.JLabel();
        pbPlayerHP = new javax.swing.JProgressBar();
        btnAttack = new javax.swing.JButton();
        btnDefend = new javax.swing.JButton();
        btnBag = new javax.swing.JButton();
        lblLog = new javax.swing.JLabel();
        lblBattLog = new javax.swing.JLabel();
        lblBattleUI = new javax.swing.JLabel();
        ____________ = new javax.swing.JPanel();
        lblAlienKing = new javax.swing.JLabel();
        lblEnemy_C2E = new javax.swing.JLabel();
        lblEnemy_C2E1 = new javax.swing.JLabel();
        lblEnemy_C2E2 = new javax.swing.JLabel();
        lblEnemy_dmg_Intro = new javax.swing.JLabel();
        lblEnemy_Intro = new javax.swing.JLabel();
        lblEnemy_dmg_C1H = new javax.swing.JLabel();
        lblEnemy_C1H = new javax.swing.JLabel();
        ___________ = new javax.swing.JPanel();
        lblThrone = new javax.swing.JLabel();
        lblChapter2EBG = new javax.swing.JLabel();
        lblChapter1EBG = new javax.swing.JLabel();
        lblChapter1HBG = new javax.swing.JLabel();
        lblIntroBG = new javax.swing.JLabel();
        pnlChapter1Hallway = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDialogue1 = new javax.swing.JTextArea();
        lblDialogueBox1 = new javax.swing.JLabel();
        lblMageC1H = new javax.swing.JLabel();
        lblShielderC1H = new javax.swing.JLabel();
        lblAssassinC1H = new javax.swing.JLabel();
        lblMonster = new javax.swing.JLabel();
        lblChapter1E = new javax.swing.JLabel();
        pnlChapter1Elevator = new javax.swing.JPanel();
        btnNext1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDialogue2 = new javax.swing.JTextArea();
        lblDialogueBox2 = new javax.swing.JLabel();
        lblShielderC1E = new javax.swing.JLabel();
        lblMageC1E = new javax.swing.JLabel();
        lblAssassinC1E = new javax.swing.JLabel();
        lblMonsterC1E = new javax.swing.JLabel();
        lblChapter1Elevator = new javax.swing.JLabel();
        pnlChapter2Hallway = new javax.swing.JPanel();
        btnNext3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDialogueC2H = new javax.swing.JTextArea();
        lblDialogueBox4 = new javax.swing.JLabel();
        lblMageC2H = new javax.swing.JLabel();
        lblShielderC2H = new javax.swing.JLabel();
        lblAssassinC2H = new javax.swing.JLabel();
        lblAssassinAlterC2H = new javax.swing.JLabel();
        lblShielderAlterC2H = new javax.swing.JLabel();
        lblMageAlterC2H = new javax.swing.JLabel();
        lblChapter2Hallway1 = new javax.swing.JLabel();
        pnlChapter2Elevator = new javax.swing.JPanel();
        btnNext2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDialogue3 = new javax.swing.JTextArea();
        lblDialogueBox3 = new javax.swing.JLabel();
        lblShielderC2E = new javax.swing.JLabel();
        lblMageC2E = new javax.swing.JLabel();
        lblAssassinC2E = new javax.swing.JLabel();
        lblAssassinAlterMarkC2E = new javax.swing.JLabel();
        lblAssassinAlterC2E = new javax.swing.JLabel();
        lblMageAlterMarkC2E = new javax.swing.JLabel();
        lblMageAlterC2E = new javax.swing.JLabel();
        lblShielderAlterMarkC2E = new javax.swing.JLabel();
        lblShielderAlterC2E = new javax.swing.JLabel();
        lblFamilliarC2E = new javax.swing.JLabel();
        lblChapter2Hallway = new javax.swing.JLabel();
        lblChapter2Elevator = new javax.swing.JLabel();
        pnlChapter3Ending = new javax.swing.JPanel();
        lblC3ECredits = new javax.swing.JLabel();
        btnNext5 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDialogueC3E = new javax.swing.JTextArea();
        lblDialogueBoxC3E = new javax.swing.JLabel();
        lblMageC3E = new javax.swing.JLabel();
        lblShielderC3E = new javax.swing.JLabel();
        lblGoddessC3E = new javax.swing.JLabel();
        lblAssassinC3E = new javax.swing.JLabel();
        lblAlienKingC3E = new javax.swing.JLabel();
        lblC3EThrone3 = new javax.swing.JLabel();
        lblC3EThrone2 = new javax.swing.JLabel();
        lblC3EThrone1 = new javax.swing.JLabel();
        lblC3ESky = new javax.swing.JLabel();
        pnlChapter3Stair = new javax.swing.JPanel();
        btnNext4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDialogueC3S = new javax.swing.JTextArea();
        lblDialogueBox5 = new javax.swing.JLabel();
        lblShielderC3S = new javax.swing.JLabel();
        lblMageC3S = new javax.swing.JLabel();
        lblAssassinC3S = new javax.swing.JLabel();
        lblShielderAlterC3S = new javax.swing.JLabel();
        lblAssassinAlterC3S = new javax.swing.JLabel();
        lblAlienKingC3S = new javax.swing.JLabel();
        lblMageAlterC3S = new javax.swing.JLabel();
        lblC3SBlackScreen = new javax.swing.JLabel();
        lblC3SStair = new javax.swing.JLabel();
        lblC3SHall = new javax.swing.JLabel();
        lblC3SThrone = new javax.swing.JLabel();
        pnlLeaderBoards = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        pnlScore = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblScore = new javax.swing.JTable();
        lblLB_UI = new javax.swing.JLabel();
        lblBGLeaderBoards = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Second Wind");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("SecondWind"); // NOI18N
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        pnlMain.setBackground(new java.awt.Color(33, 19, 13));
        pnlMain.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlMenu1.setBackground(new java.awt.Color(135, 62, 35));
        pnlMenu1.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlMenu1.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlMenu1.setOpaque(false);
        pnlMenu1.setLayout(null);

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SecondWindLogo.png"))); // NOI18N
        lblLogo1.setMaximumSize(new java.awt.Dimension(1000, 1000));
        pnlMenu1.add(lblLogo1);
        lblLogo1.setBounds(380, 60, 500, 222);

        btnPlay.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnPlay.setText("Play");
        btnPlay.setContentAreaFilled(false);
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.setMaximumSize(new java.awt.Dimension(100, 50));
        btnPlay.setMinimumSize(new java.awt.Dimension(100, 50));
        btnPlay.setPreferredSize(new java.awt.Dimension(100, 50));
        btnPlay.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnPlay);
        btnPlay.setBounds(580, 340, 100, 50);

        btnHighScore.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnHighScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnHighScore.setText("Score");
        btnHighScore.setContentAreaFilled(false);
        btnHighScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHighScore.setMaximumSize(new java.awt.Dimension(100, 50));
        btnHighScore.setMinimumSize(new java.awt.Dimension(100, 50));
        btnHighScore.setPreferredSize(new java.awt.Dimension(100, 50));
        btnHighScore.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnHighScore.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnHighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighScoreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnHighScore);
        btnHighScore.setBounds(580, 400, 100, 50);

        btnExit.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setContentAreaFilled(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setMaximumSize(new java.awt.Dimension(100, 50));
        btnExit.setMinimumSize(new java.awt.Dimension(100, 50));
        btnExit.setPreferredSize(new java.awt.Dimension(100, 50));
        btnExit.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnExit);
        btnExit.setBounds(580, 460, 100, 50);

        lblColumnL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Column.png"))); // NOI18N
        pnlMenu1.add(lblColumnL);
        lblColumnL.setBounds(1110, 0, 168, 720);

        lblColumnR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Column.png"))); // NOI18N
        pnlMenu1.add(lblColumnR);
        lblColumnR.setBounds(0, 0, 168, 720);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EpicBG.gif"))); // NOI18N
        lblBackground.setMaximumSize(new java.awt.Dimension(1080, 720));
        lblBackground.setMinimumSize(new java.awt.Dimension(1080, 720));
        lblBackground.setPreferredSize(new java.awt.Dimension(1080, 720));
        pnlMenu1.add(lblBackground);
        lblBackground.setBounds(0, 0, 1280, 720);

        pnlMain.add(pnlMenu1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 1280, 720);

        pnlCharacterSelection.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlCharacterSelection.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlCharacterSelection.setOpaque(false);
        pnlCharacterSelection.setLayout(null);

        btnShielder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shielder_card.png"))); // NOI18N
        btnShielder.setMaximumSize(new java.awt.Dimension(390, 660));
        btnShielder.setMinimumSize(new java.awt.Dimension(390, 660));
        btnShielder.setPreferredSize(new java.awt.Dimension(390, 660));
        btnShielder.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shielder_card_selected.png"))); // NOI18N
        btnShielder.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shielder_card_hovered.png"))); // NOI18N
        btnShielder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShielderActionPerformed(evt);
            }
        });
        pnlCharacterSelection.add(btnShielder);
        btnShielder.setBounds(450, 30, 390, 660);

        btnMage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mage_card.png"))); // NOI18N
        btnMage.setMaximumSize(new java.awt.Dimension(390, 660));
        btnMage.setMinimumSize(new java.awt.Dimension(390, 660));
        btnMage.setPreferredSize(new java.awt.Dimension(390, 660));
        btnMage.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mage_card_selected.png"))); // NOI18N
        btnMage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mage_card_hovered.png"))); // NOI18N
        btnMage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMageActionPerformed(evt);
            }
        });
        pnlCharacterSelection.add(btnMage);
        btnMage.setBounds(870, 30, 390, 660);

        btnArcher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/assassin_card.png"))); // NOI18N
        btnArcher.setMaximumSize(new java.awt.Dimension(390, 660));
        btnArcher.setMinimumSize(new java.awt.Dimension(390, 660));
        btnArcher.setPreferredSize(new java.awt.Dimension(390, 660));
        btnArcher.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/assassin_card_selected.png"))); // NOI18N
        btnArcher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/assassin_card_hovered.png"))); // NOI18N
        btnArcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArcherActionPerformed(evt);
            }
        });
        pnlCharacterSelection.add(btnArcher);
        btnArcher.setBounds(30, 30, 390, 660);

        lblBG_CS.setMaximumSize(new java.awt.Dimension(1280, 720));
        lblBG_CS.setMinimumSize(new java.awt.Dimension(1280, 720));
        lblBG_CS.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlCharacterSelection.add(lblBG_CS);
        lblBG_CS.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlCharacterSelection);
        pnlCharacterSelection.setBounds(0, 0, 1280, 720);

        pnlIntro.setBackground(new java.awt.Color(25, 25, 25));
        pnlIntro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlIntro.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlIntro.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlIntro.setLayout(null);

        btnNxt.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNxt.setText("Next");
        btnNxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNxt.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNxt.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNxt.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNxt.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNxt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNxtActionPerformed(evt);
            }
        });
        pnlIntro.add(btnNxt);
        btnNxt.setBounds(1140, 620, 100, 40);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogue.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogue.setColumns(20);
        txtDialogue.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogue.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogue.setRows(5);
        txtDialogue.setFocusable(false);
        jScrollPane1.setViewportView(txtDialogue);

        pnlIntro.add(jScrollPane1);
        jScrollPane1.setBounds(200, 580, 910, 90);

        lblDialogueBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlIntro.add(lblDialogueBox);
        lblDialogueBox.setBounds(20, 540, 1236, 162);

        lblMage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlIntro.add(lblMage1);
        lblMage1.setBounds(350, 80, 596, 641);

        lblShielder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlIntro.add(lblShielder1);
        lblShielder1.setBounds(410, 50, 483, 673);

        lblAssassin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlIntro.add(lblAssassin);
        lblAssassin.setBounds(480, 60, 382, 666);

        lblIntro7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/gate.png"))); // NOI18N
        pnlIntro.add(lblIntro7);
        lblIntro7.setBounds(0, 0, 1280, 720);

        lblIntro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/ruined_city.png"))); // NOI18N
        pnlIntro.add(lblIntro6);
        lblIntro6.setBounds(0, 0, 1280, 720);

        lblIntro5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/Black.png"))); // NOI18N
        pnlIntro.add(lblIntro5);
        lblIntro5.setBounds(0, 0, 1280, 720);

        lblIntro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/death.png"))); // NOI18N
        pnlIntro.add(lblIntro4);
        lblIntro4.setBounds(0, 0, 1280, 720);

        lblIntro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/shine.png"))); // NOI18N
        pnlIntro.add(lblIntro3);
        lblIntro3.setBounds(0, 0, 1280, 720);

        lblIntro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/three_heroes.png"))); // NOI18N
        pnlIntro.add(lblIntro2);
        lblIntro2.setBounds(0, 0, 1280, 720);

        lblIntro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/light.png"))); // NOI18N
        pnlIntro.add(lblIntro1);
        lblIntro1.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlIntro);
        pnlIntro.setBounds(0, 0, 1280, 720);

        pnlEnding.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlEnding.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlEnding.setOpaque(false);
        pnlEnding.setLayout(null);

        pnlName.setMaximumSize(new java.awt.Dimension(380, 150));
        pnlName.setOpaque(false);
        pnlName.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Joystix Monospace", 0, 14)); // NOI18N
        jLabel6.setText("Enter your name");
        jLabel6.setMaximumSize(new java.awt.Dimension(200, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(200, 50));
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        pnlName.add(jLabel6);
        jLabel6.setBounds(100, 20, 200, 50);

        txtName.setBackground(new java.awt.Color(116, 63, 58));
        txtName.setFont(new java.awt.Font("Joystix Monospace", 0, 18)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtName.setMaximumSize(new java.awt.Dimension(280, 50));
        txtName.setMinimumSize(new java.awt.Dimension(280, 50));
        txtName.setPreferredSize(new java.awt.Dimension(280, 50));
        pnlName.add(txtName);
        txtName.setBounds(50, 70, 280, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Ending_UI.png"))); // NOI18N
        pnlName.add(jLabel7);
        jLabel7.setBounds(0, 0, 380, 150);

        pnlEnding.add(pnlName);
        pnlName.setBounds(460, 180, 380, 150);

        btnSubmit.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.setBorderPainted(false);
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSubmit.setMaximumSize(new java.awt.Dimension(100, 50));
        btnSubmit.setMinimumSize(new java.awt.Dimension(100, 50));
        btnSubmit.setPreferredSize(new java.awt.Dimension(100, 50));
        btnSubmit.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnSubmit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnlEnding.add(btnSubmit);
        btnSubmit.setBounds(600, 350, 100, 50);

        lblColumn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Column.png"))); // NOI18N
        pnlEnding.add(lblColumn1);
        lblColumn1.setBounds(880, 0, 168, 720);

        lblColumn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Column.png"))); // NOI18N
        pnlEnding.add(lblColumn2);
        lblColumn2.setBounds(240, 0, 168, 720);

        lblBG_Ending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EpicBG.gif"))); // NOI18N
        pnlEnding.add(lblBG_Ending);
        lblBG_Ending.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlEnding);
        pnlEnding.setBounds(0, 0, 1280, 720);

        pnlBattle.setBackground(new java.awt.Color(25, 25, 25));
        pnlBattle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlBattle.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlBattle.setLayout(new java.awt.BorderLayout());

        pnlTLayout.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.setOpaque(false);
        pnlTLayout.setLayout(null);

        lblBattleFailed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/battle_failed.gif"))); // NOI18N
        pnlTLayout.add(lblBattleFailed);
        lblBattleFailed.setBounds(0, 0, 1280, 720);

        lblBattleFatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/battle_fatal.gif"))); // NOI18N
        pnlTLayout.add(lblBattleFatal);
        lblBattleFatal.setBounds(0, 0, 1280, 720);

        lblBattleFinished.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/battle_finished.gif"))); // NOI18N
        pnlTLayout.add(lblBattleFinished);
        lblBattleFinished.setBounds(0, 0, 1280, 720);

        lblBattleStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/battle_started.gif"))); // NOI18N
        pnlTLayout.add(lblBattleStart);
        lblBattleStart.setBounds(0, 0, 1280, 720);

        lblSkill_M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Skills/mage_skill.gif"))); // NOI18N
        lblSkill_M.setMaximumSize(new java.awt.Dimension(1280, 720));
        lblSkill_M.setMinimumSize(new java.awt.Dimension(1280, 720));
        lblSkill_M.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.add(lblSkill_M);
        lblSkill_M.setBounds(390, 0, 500, 720);

        lblSkill_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Skills/shielder_skill.gif"))); // NOI18N
        lblSkill_S.setMaximumSize(new java.awt.Dimension(1280, 720));
        lblSkill_S.setMinimumSize(new java.awt.Dimension(1280, 720));
        lblSkill_S.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.add(lblSkill_S);
        lblSkill_S.setBounds(390, 0, 500, 720);

        lblSkill_A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Skills/assassin_skill.gif"))); // NOI18N
        lblSkill_A.setMaximumSize(new java.awt.Dimension(1280, 720));
        lblSkill_A.setMinimumSize(new java.awt.Dimension(1280, 720));
        lblSkill_A.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.add(lblSkill_A);
        lblSkill_A.setBounds(390, 0, 500, 720);

        lblAtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Skills/atk.gif"))); // NOI18N
        lblAtk.setMaximumSize(new java.awt.Dimension(1280, 720));
        lblAtk.setMinimumSize(new java.awt.Dimension(1280, 720));
        lblAtk.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnlTLayout.add(lblAtk);
        lblAtk.setBounds(390, 0, 500, 720);

        pnlBag.setMaximumSize(new java.awt.Dimension(170, 240));
        pnlBag.setMinimumSize(new java.awt.Dimension(170, 240));
        pnlBag.setOpaque(false);
        pnlBag.setLayout(null);

        btnHP1.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnHP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/HP.png"))); // NOI18N
        btnHP1.setContentAreaFilled(false);
        btnHP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHP1.setMaximumSize(new java.awt.Dimension(100, 50));
        btnHP1.setMinimumSize(new java.awt.Dimension(100, 50));
        btnHP1.setPreferredSize(new java.awt.Dimension(100, 50));
        btnHP1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnHP1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnHP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHP1ActionPerformed(evt);
            }
        });
        pnlBag.add(btnHP1);
        btnHP1.setBounds(50, 50, 50, 60);

        btnHP2.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnHP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/HP.png"))); // NOI18N
        btnHP2.setToolTipText("");
        btnHP2.setContentAreaFilled(false);
        btnHP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHP2.setMaximumSize(new java.awt.Dimension(100, 50));
        btnHP2.setMinimumSize(new java.awt.Dimension(100, 50));
        btnHP2.setPreferredSize(new java.awt.Dimension(100, 50));
        btnHP2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnHP2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnHP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHP2ActionPerformed(evt);
            }
        });
        pnlBag.add(btnHP2);
        btnHP2.setBounds(120, 50, 50, 60);

        btnMP1.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnMP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/MP.png"))); // NOI18N
        btnMP1.setContentAreaFilled(false);
        btnMP1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMP1.setMaximumSize(new java.awt.Dimension(100, 50));
        btnMP1.setMinimumSize(new java.awt.Dimension(100, 50));
        btnMP1.setPreferredSize(new java.awt.Dimension(100, 50));
        btnMP1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnMP1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnMP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMP1ActionPerformed(evt);
            }
        });
        pnlBag.add(btnMP1);
        btnMP1.setBounds(120, 130, 50, 60);

        btnMP2.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnMP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/MP.png"))); // NOI18N
        btnMP2.setContentAreaFilled(false);
        btnMP2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMP2.setMaximumSize(new java.awt.Dimension(100, 50));
        btnMP2.setMinimumSize(new java.awt.Dimension(100, 50));
        btnMP2.setPreferredSize(new java.awt.Dimension(100, 50));
        btnMP2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnMP2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnMP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMP2ActionPerformed(evt);
            }
        });
        pnlBag.add(btnMP2);
        btnMP2.setBounds(50, 130, 50, 60);

        lblBagUI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_BagUI.png"))); // NOI18N
        pnlBag.add(lblBagUI);
        lblBagUI.setBounds(0, 0, 220, 240);

        pnlTLayout.add(pnlBag);
        pnlBag.setBounds(190, 440, 220, 240);

        pnlAttack.setMaximumSize(new java.awt.Dimension(170, 240));
        pnlAttack.setMinimumSize(new java.awt.Dimension(170, 240));
        pnlAttack.setOpaque(false);
        pnlAttack.setLayout(null);

        btnAtk.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnAtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnAtk.setText("Attack");
        btnAtk.setContentAreaFilled(false);
        btnAtk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtk.setMaximumSize(new java.awt.Dimension(100, 50));
        btnAtk.setMinimumSize(new java.awt.Dimension(100, 50));
        btnAtk.setPreferredSize(new java.awt.Dimension(100, 50));
        btnAtk.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnAtk.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnAtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtkActionPerformed(evt);
            }
        });
        pnlAttack.add(btnAtk);
        btnAtk.setBounds(60, 60, 100, 50);

        btnSPAtk.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnSPAtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnSPAtk.setText("SP.ATK");
        btnSPAtk.setContentAreaFilled(false);
        btnSPAtk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSPAtk.setMaximumSize(new java.awt.Dimension(100, 50));
        btnSPAtk.setMinimumSize(new java.awt.Dimension(100, 50));
        btnSPAtk.setPreferredSize(new java.awt.Dimension(100, 50));
        btnSPAtk.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnSPAtk.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnSPAtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPAtkActionPerformed(evt);
            }
        });
        pnlAttack.add(btnSPAtk);
        btnSPAtk.setBounds(60, 130, 100, 50);

        lblAttackUI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_AtkUI.png"))); // NOI18N
        pnlAttack.add(lblAttackUI);
        lblAttackUI.setBounds(0, 0, 220, 240);

        pnlTLayout.add(pnlAttack);
        pnlAttack.setBounds(190, 440, 220, 240);

        lblNameE.setFont(new java.awt.Font("Joystix Monospace", 0, 18)); // NOI18N
        lblNameE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameE.setText("Enemy");
        lblNameE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNameE.setMaximumSize(new java.awt.Dimension(110, 20));
        lblNameE.setMinimumSize(new java.awt.Dimension(110, 20));
        lblNameE.setPreferredSize(new java.awt.Dimension(110, 20));
        lblNameE.setRequestFocusEnabled(false);
        pnlTLayout.add(lblNameE);
        lblNameE.setBounds(1090, 660, 110, 20);

        lblEnemyBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_EnemyBorder.png"))); // NOI18N
        pnlTLayout.add(lblEnemyBorder);
        lblEnemyBorder.setBounds(1070, 500, 150, 150);

        lblAlienKingAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Boss 2nd Phase Icon.png"))); // NOI18N
        lblAlienKingAvatar.setMaximumSize(new java.awt.Dimension(110, 110));
        lblAlienKingAvatar.setMinimumSize(new java.awt.Dimension(110, 110));
        lblAlienKingAvatar.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblAlienKingAvatar);
        lblAlienKingAvatar.setBounds(1080, 500, 140, 160);

        lblEnemyAvatar_C2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/shielder_alter_icon.png"))); // NOI18N
        lblEnemyAvatar_C2E.setMaximumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E.setMinimumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblEnemyAvatar_C2E);
        lblEnemyAvatar_C2E.setBounds(1040, 520, 180, 140);

        lblEnemyAvatar_C2E1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/assassin_alter_icon.png"))); // NOI18N
        lblEnemyAvatar_C2E1.setMaximumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E1.setMinimumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E1.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblEnemyAvatar_C2E1);
        lblEnemyAvatar_C2E1.setBounds(1070, 520, 150, 140);

        lblEnemyAvatar_C2E2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage_alter_icon.png"))); // NOI18N
        lblEnemyAvatar_C2E2.setMaximumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E2.setMinimumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C2E2.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblEnemyAvatar_C2E2);
        lblEnemyAvatar_C2E2.setBounds(1050, 520, 170, 140);

        lblEnemyAvatar_C1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_1_icon.png"))); // NOI18N
        lblEnemyAvatar_C1H.setMaximumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C1H.setMinimumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_C1H.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblEnemyAvatar_C1H);
        lblEnemyAvatar_C1H.setBounds(1090, 520, 110, 110);

        lblEnemyAvatar_Intro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_2_icon.png"))); // NOI18N
        lblEnemyAvatar_Intro.setMaximumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_Intro.setMinimumSize(new java.awt.Dimension(110, 110));
        lblEnemyAvatar_Intro.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblEnemyAvatar_Intro);
        lblEnemyAvatar_Intro.setBounds(1090, 520, 110, 110);

        _____________.setOpaque(false);

        javax.swing.GroupLayout _____________Layout = new javax.swing.GroupLayout(_____________);
        _____________.setLayout(_____________Layout);
        _____________Layout.setHorizontalGroup(
            _____________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        _____________Layout.setVerticalGroup(
            _____________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlTLayout.add(_____________);
        _____________.setBounds(920, 180, 10, 10);

        lblHPBarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_PlayerHP.png"))); // NOI18N
        pnlTLayout.add(lblHPBarE);
        lblHPBarE.setBounds(1070, 460, 150, 32);

        pbEnemyHP.setBackground(new java.awt.Color(255, 255, 255));
        pbEnemyHP.setFont(new java.awt.Font("Joystix Monospace", 0, 10)); // NOI18N
        pbEnemyHP.setForeground(new java.awt.Color(0, 0, 0));
        pbEnemyHP.setValue(100);
        pbEnemyHP.setBorderPainted(false);
        pbEnemyHP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pbEnemyHP.setMaximumSize(new java.awt.Dimension(130, 10));
        pbEnemyHP.setMinimumSize(new java.awt.Dimension(130, 10));
        pbEnemyHP.setPreferredSize(new java.awt.Dimension(130, 10));
        pbEnemyHP.setStringPainted(true);
        pnlTLayout.add(pbEnemyHP);
        pbEnemyHP.setBounds(1080, 460, 130, 30);

        lblNameP.setFont(new java.awt.Font("Joystix Monospace", 0, 18)); // NOI18N
        lblNameP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameP.setText("Player");
        lblNameP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNameP.setMaximumSize(new java.awt.Dimension(110, 20));
        lblNameP.setMinimumSize(new java.awt.Dimension(110, 20));
        lblNameP.setPreferredSize(new java.awt.Dimension(110, 20));
        lblNameP.setRequestFocusEnabled(false);
        pnlTLayout.add(lblNameP);
        lblNameP.setBounds(260, 670, 110, 20);

        lblPlayerBorder.setBackground(new java.awt.Color(33, 28, 27));
        lblPlayerBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_PlayerBorder.png"))); // NOI18N
        lblPlayerBorder.setName(""); // NOI18N
        pnlTLayout.add(lblPlayerBorder);
        lblPlayerBorder.setBounds(240, 520, 150, 150);

        lblMage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/mage_icon.png"))); // NOI18N
        lblMage.setMaximumSize(new java.awt.Dimension(110, 110));
        lblMage.setMinimumSize(new java.awt.Dimension(110, 110));
        lblMage.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblMage);
        lblMage.setBounds(260, 540, 110, 110);

        lblShielder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/shielder_icon.png"))); // NOI18N
        lblShielder.setMaximumSize(new java.awt.Dimension(110, 110));
        lblShielder.setMinimumSize(new java.awt.Dimension(110, 110));
        lblShielder.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblShielder);
        lblShielder.setBounds(260, 540, 110, 110);

        lblAassassin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PlaceHolder_PlayeAvatar.png"))); // NOI18N
        lblAassassin.setMaximumSize(new java.awt.Dimension(110, 110));
        lblAassassin.setMinimumSize(new java.awt.Dimension(110, 110));
        lblAassassin.setPreferredSize(new java.awt.Dimension(110, 110));
        pnlTLayout.add(lblAassassin);
        lblAassassin.setBounds(260, 540, 110, 110);

        lblMPBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_PlayerHP.png"))); // NOI18N
        pnlTLayout.add(lblMPBar);
        lblMPBar.setBounds(240, 485, 150, 32);

        pbPlayerMP.setBackground(new java.awt.Color(255, 255, 255));
        pbPlayerMP.setFont(new java.awt.Font("Joystix Monospace", 0, 10)); // NOI18N
        pbPlayerMP.setForeground(new java.awt.Color(0, 0, 0));
        pbPlayerMP.setBorderPainted(false);
        pbPlayerMP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pbPlayerMP.setMaximumSize(new java.awt.Dimension(130, 10));
        pbPlayerMP.setMinimumSize(new java.awt.Dimension(130, 10));
        pbPlayerMP.setPreferredSize(new java.awt.Dimension(130, 10));
        pbPlayerMP.setStringPainted(true);
        pnlTLayout.add(pbPlayerMP);
        pbPlayerMP.setBounds(250, 485, 130, 30);

        lblHPBarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_PlayerHP.png"))); // NOI18N
        pnlTLayout.add(lblHPBarP);
        lblHPBarP.setBounds(240, 450, 150, 32);

        pbPlayerHP.setBackground(new java.awt.Color(255, 255, 255));
        pbPlayerHP.setFont(new java.awt.Font("Joystix Monospace", 0, 10)); // NOI18N
        pbPlayerHP.setForeground(new java.awt.Color(0, 0, 0));
        pbPlayerHP.setValue(100);
        pbPlayerHP.setBorderPainted(false);
        pbPlayerHP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pbPlayerHP.setMaximumSize(new java.awt.Dimension(130, 10));
        pbPlayerHP.setMinimumSize(new java.awt.Dimension(130, 10));
        pbPlayerHP.setPreferredSize(new java.awt.Dimension(130, 10));
        pbPlayerHP.setStringPainted(true);
        pnlTLayout.add(pbPlayerHP);
        pbPlayerHP.setBounds(250, 450, 130, 30);

        btnAttack.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnAttack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnAttack.setText("Attack");
        btnAttack.setContentAreaFilled(false);
        btnAttack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAttack.setMaximumSize(new java.awt.Dimension(100, 50));
        btnAttack.setMinimumSize(new java.awt.Dimension(100, 50));
        btnAttack.setPreferredSize(new java.awt.Dimension(100, 50));
        btnAttack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnAttack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttackActionPerformed(evt);
            }
        });
        pnlTLayout.add(btnAttack);
        btnAttack.setBounds(80, 460, 100, 50);

        btnDefend.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnDefend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnDefend.setText("Defend");
        btnDefend.setContentAreaFilled(false);
        btnDefend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDefend.setMaximumSize(new java.awt.Dimension(100, 50));
        btnDefend.setMinimumSize(new java.awt.Dimension(100, 50));
        btnDefend.setPreferredSize(new java.awt.Dimension(100, 50));
        btnDefend.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnDefend.setRequestFocusEnabled(false);
        btnDefend.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnDefend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefendActionPerformed(evt);
            }
        });
        pnlTLayout.add(btnDefend);
        btnDefend.setBounds(80, 540, 100, 50);

        btnBag.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnBag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnBag.setText("Bag");
        btnBag.setContentAreaFilled(false);
        btnBag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBag.setMaximumSize(new java.awt.Dimension(100, 50));
        btnBag.setMinimumSize(new java.awt.Dimension(100, 50));
        btnBag.setPreferredSize(new java.awt.Dimension(100, 50));
        btnBag.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnBag.setRequestFocusEnabled(false);
        btnBag.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnBag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBagActionPerformed(evt);
            }
        });
        pnlTLayout.add(btnBag);
        btnBag.setBounds(80, 620, 100, 50);

        lblLog.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        lblLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLog.setMaximumSize(new java.awt.Dimension(530, 150));
        lblLog.setMinimumSize(new java.awt.Dimension(530, 150));
        lblLog.setPreferredSize(new java.awt.Dimension(530, 150));
        pnlTLayout.add(lblLog);
        lblLog.setBounds(467, 496, 530, 150);

        lblBattLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_InventoryUI..png"))); // NOI18N
        pnlTLayout.add(lblBattLog);
        lblBattLog.setBounds(420, 450, 620, 240);

        lblBattleUI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BattleUI_Background_300.png"))); // NOI18N
        pnlTLayout.add(lblBattleUI);
        lblBattleUI.setBounds(0, 420, 1280, 300);

        ____________.setOpaque(false);

        javax.swing.GroupLayout ____________Layout = new javax.swing.GroupLayout(____________);
        ____________.setLayout(____________Layout);
        ____________Layout.setHorizontalGroup(
            ____________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ____________Layout.setVerticalGroup(
            ____________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlTLayout.add(____________);
        ____________.setBounds(920, 180, 10, 10);

        lblAlienKing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Boss 2nd Phase.png"))); // NOI18N
        pnlTLayout.add(lblAlienKing);
        lblAlienKing.setBounds(160, -50, 950, 770);

        lblEnemy_C2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder Alter.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_C2E);
        lblEnemy_C2E.setBounds(400, -50, 490, 770);

        lblEnemy_C2E1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin Alter.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_C2E1);
        lblEnemy_C2E1.setBounds(400, -50, 490, 770);

        lblEnemy_C2E2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage Alter.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_C2E2);
        lblEnemy_C2E2.setBounds(400, -50, 490, 770);

        lblEnemy_dmg_Intro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_2_damaged.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_dmg_Intro);
        lblEnemy_dmg_Intro.setBounds(400, 0, 820, 619);

        lblEnemy_Intro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_2.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_Intro);
        lblEnemy_Intro.setBounds(400, 0, 820, 619);

        lblEnemy_dmg_C1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_1_damaged.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_dmg_C1H);
        lblEnemy_dmg_C1H.setBounds(250, -50, 820, 619);

        lblEnemy_C1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_1.png"))); // NOI18N
        pnlTLayout.add(lblEnemy_C1H);
        lblEnemy_C1H.setBounds(250, -50, 820, 619);

        ___________.setOpaque(false);

        javax.swing.GroupLayout ___________Layout = new javax.swing.GroupLayout(___________);
        ___________.setLayout(___________Layout);
        ___________Layout.setHorizontalGroup(
            ___________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ___________Layout.setVerticalGroup(
            ___________Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pnlTLayout.add(___________);
        ___________.setBounds(920, 180, 10, 10);

        lblThrone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/lair.png"))); // NOI18N
        pnlTLayout.add(lblThrone);
        lblThrone.setBounds(0, 0, 1280, 720);

        lblChapter2EBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_2.png"))); // NOI18N
        pnlTLayout.add(lblChapter2EBG);
        lblChapter2EBG.setBounds(0, 0, 1280, 720);

        lblChapter1EBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_elevator.png"))); // NOI18N
        pnlTLayout.add(lblChapter1EBG);
        lblChapter1EBG.setBounds(0, 0, 1280, 720);

        lblChapter1HBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway.png"))); // NOI18N
        pnlTLayout.add(lblChapter1HBG);
        lblChapter1HBG.setBounds(0, 0, 1280, 720);

        lblIntroBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/gate_alt.png"))); // NOI18N
        pnlTLayout.add(lblIntroBG);
        lblIntroBG.setBounds(0, 0, 1280, 720);

        pnlBattle.add(pnlTLayout, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlBattle);
        pnlBattle.setBounds(0, 0, 1280, 720);

        pnlChapter1Hallway.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter1Hallway.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter1Hallway.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter1Hallway.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter1Hallway.setLayout(null);

        btnNext.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext.setText("Next");
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlChapter1Hallway.add(btnNext);
        btnNext.setBounds(1140, 620, 100, 40);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogue1.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogue1.setColumns(20);
        txtDialogue1.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogue1.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogue1.setRows(5);
        jScrollPane2.setViewportView(txtDialogue1);

        pnlChapter1Hallway.add(jScrollPane2);
        jScrollPane2.setBounds(200, 580, 910, 90);

        lblDialogueBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter1Hallway.add(lblDialogueBox1);
        lblDialogueBox1.setBounds(20, 540, 1236, 162);

        lblMageC1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter1Hallway.add(lblMageC1H);
        lblMageC1H.setBounds(340, 70, 690, 673);

        lblShielderC1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter1Hallway.add(lblShielderC1H);
        lblShielderC1H.setBounds(410, 50, 540, 673);

        lblAssassinC1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter1Hallway.add(lblAssassinC1H);
        lblAssassinC1H.setBounds(480, 60, 382, 666);

        lblMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_1.png"))); // NOI18N
        pnlChapter1Hallway.add(lblMonster);
        lblMonster.setBounds(200, 0, 850, 720);

        lblChapter1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway.png"))); // NOI18N
        pnlChapter1Hallway.add(lblChapter1E);
        lblChapter1E.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter1Hallway);
        pnlChapter1Hallway.setBounds(0, 0, 1280, 720);

        pnlChapter1Elevator.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter1Elevator.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter1Elevator.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter1Elevator.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter1Elevator.setLayout(null);

        btnNext1.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext1.setText("Next");
        btnNext1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext1.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext1.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext1.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });
        pnlChapter1Elevator.add(btnNext1);
        btnNext1.setBounds(1140, 620, 100, 40);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogue2.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogue2.setColumns(20);
        txtDialogue2.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogue2.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogue2.setRows(5);
        jScrollPane3.setViewportView(txtDialogue2);

        pnlChapter1Elevator.add(jScrollPane3);
        jScrollPane3.setBounds(200, 580, 910, 90);

        lblDialogueBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter1Elevator.add(lblDialogueBox2);
        lblDialogueBox2.setBounds(20, 540, 1236, 162);

        lblShielderC1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter1Elevator.add(lblShielderC1E);
        lblShielderC1E.setBounds(380, 70, 600, 666);

        lblMageC1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter1Elevator.add(lblMageC1E);
        lblMageC1E.setBounds(380, 70, 600, 666);

        lblAssassinC1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter1Elevator.add(lblAssassinC1E);
        lblAssassinC1E.setBounds(480, 60, 382, 666);

        lblMonsterC1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/monster_1.png"))); // NOI18N
        pnlChapter1Elevator.add(lblMonsterC1E);
        lblMonsterC1E.setBounds(200, 0, 850, 720);

        lblChapter1Elevator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_elevator.png"))); // NOI18N
        pnlChapter1Elevator.add(lblChapter1Elevator);
        lblChapter1Elevator.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter1Elevator);
        pnlChapter1Elevator.setBounds(0, 0, 1280, 720);

        pnlChapter2Hallway.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter2Hallway.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter2Hallway.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter2Hallway.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter2Hallway.setLayout(null);

        btnNext3.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext3.setText("Next");
        btnNext3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext3.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext3.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext3.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext3ActionPerformed(evt);
            }
        });
        pnlChapter2Hallway.add(btnNext3);
        btnNext3.setBounds(1140, 620, 100, 40);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogueC2H.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogueC2H.setColumns(20);
        txtDialogueC2H.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogueC2H.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogueC2H.setRows(5);
        jScrollPane5.setViewportView(txtDialogueC2H);

        pnlChapter2Hallway.add(jScrollPane5);
        jScrollPane5.setBounds(200, 580, 910, 90);

        lblDialogueBox4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter2Hallway.add(lblDialogueBox4);
        lblDialogueBox4.setBounds(20, 540, 1236, 162);

        lblMageC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter2Hallway.add(lblMageC2H);
        lblMageC2H.setBounds(360, 60, 660, 673);

        lblShielderC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter2Hallway.add(lblShielderC2H);
        lblShielderC2H.setBounds(360, 50, 680, 673);

        lblAssassinC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter2Hallway.add(lblAssassinC2H);
        lblAssassinC2H.setBounds(480, 60, 382, 666);

        lblAssassinAlterC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder Alter.png"))); // NOI18N
        pnlChapter2Hallway.add(lblAssassinAlterC2H);
        lblAssassinAlterC2H.setBounds(360, 50, 630, 673);

        lblShielderAlterC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder Alter.png"))); // NOI18N
        pnlChapter2Hallway.add(lblShielderAlterC2H);
        lblShielderAlterC2H.setBounds(380, 50, 610, 673);

        lblMageAlterC2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage Alter.png"))); // NOI18N
        pnlChapter2Hallway.add(lblMageAlterC2H);
        lblMageAlterC2H.setBounds(360, 60, 630, 673);

        lblChapter2Hallway1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_2.png"))); // NOI18N
        pnlChapter2Hallway.add(lblChapter2Hallway1);
        lblChapter2Hallway1.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter2Hallway);
        pnlChapter2Hallway.setBounds(0, 0, 1280, 720);

        pnlChapter2Elevator.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter2Elevator.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter2Elevator.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter2Elevator.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter2Elevator.setLayout(null);

        btnNext2.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext2.setText("Next");
        btnNext2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext2.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext2.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext2.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });
        pnlChapter2Elevator.add(btnNext2);
        btnNext2.setBounds(1140, 620, 100, 40);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogue3.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogue3.setColumns(20);
        txtDialogue3.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogue3.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogue3.setRows(5);
        jScrollPane4.setViewportView(txtDialogue3);

        pnlChapter2Elevator.add(jScrollPane4);
        jScrollPane4.setBounds(200, 580, 910, 90);

        lblDialogueBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter2Elevator.add(lblDialogueBox3);
        lblDialogueBox3.setBounds(20, 540, 1236, 162);

        lblShielderC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter2Elevator.add(lblShielderC2E);
        lblShielderC2E.setBounds(390, 80, 720, 641);

        lblMageC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter2Elevator.add(lblMageC2E);
        lblMageC2E.setBounds(390, 90, 720, 641);

        lblAssassinC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter2Elevator.add(lblAssassinC2E);
        lblAssassinC2E.setBounds(480, 60, 382, 666);

        lblAssassinAlterMarkC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/assassin_alter_zoom.png"))); // NOI18N
        pnlChapter2Elevator.add(lblAssassinAlterMarkC2E);
        lblAssassinAlterMarkC2E.setBounds(0, 190, 1280, 121);

        lblAssassinAlterC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin Alter.png"))); // NOI18N
        pnlChapter2Elevator.add(lblAssassinAlterC2E);
        lblAssassinAlterC2E.setBounds(480, 90, 610, 641);

        lblMageAlterMarkC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/mage_alter_zoom.png"))); // NOI18N
        pnlChapter2Elevator.add(lblMageAlterMarkC2E);
        lblMageAlterMarkC2E.setBounds(0, 190, 1280, 121);

        lblMageAlterC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage Alter.png"))); // NOI18N
        pnlChapter2Elevator.add(lblMageAlterC2E);
        lblMageAlterC2E.setBounds(370, 90, 610, 641);

        lblShielderAlterMarkC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/shielder_alter_zoom.png"))); // NOI18N
        pnlChapter2Elevator.add(lblShielderAlterMarkC2E);
        lblShielderAlterMarkC2E.setBounds(0, 190, 1280, 121);

        lblShielderAlterC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder Alter.png"))); // NOI18N
        pnlChapter2Elevator.add(lblShielderAlterC2E);
        lblShielderAlterC2E.setBounds(390, 50, 460, 673);

        lblFamilliarC2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/familliar.png"))); // NOI18N
        pnlChapter2Elevator.add(lblFamilliarC2E);
        lblFamilliarC2E.setBounds(80, 20, 1100, 720);

        lblChapter2Hallway.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_2.png"))); // NOI18N
        pnlChapter2Elevator.add(lblChapter2Hallway);
        lblChapter2Hallway.setBounds(0, 0, 1280, 720);

        lblChapter2Elevator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/elevator.png"))); // NOI18N
        pnlChapter2Elevator.add(lblChapter2Elevator);
        lblChapter2Elevator.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter2Elevator);
        pnlChapter2Elevator.setBounds(0, 0, 1280, 720);

        pnlChapter3Ending.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter3Ending.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter3Ending.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter3Ending.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter3Ending.setLayout(null);

        lblC3ECredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BattleGIF/Credits.gif"))); // NOI18N
        pnlChapter3Ending.add(lblC3ECredits);
        lblC3ECredits.setBounds(0, 0, 1300, 770);

        btnNext5.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext5.setText("Next");
        btnNext5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext5.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext5.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext5.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext5ActionPerformed(evt);
            }
        });
        pnlChapter3Ending.add(btnNext5);
        btnNext5.setBounds(1140, 620, 100, 40);

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogueC3E.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogueC3E.setColumns(20);
        txtDialogueC3E.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogueC3E.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogueC3E.setRows(5);
        jScrollPane8.setViewportView(txtDialogueC3E);

        pnlChapter3Ending.add(jScrollPane8);
        jScrollPane8.setBounds(200, 580, 910, 90);

        lblDialogueBoxC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter3Ending.add(lblDialogueBoxC3E);
        lblDialogueBoxC3E.setBounds(20, 540, 1236, 162);

        lblMageC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter3Ending.add(lblMageC3E);
        lblMageC3E.setBounds(360, 70, 630, 666);

        lblShielderC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter3Ending.add(lblShielderC3E);
        lblShielderC3E.setBounds(420, 50, 550, 673);

        lblGoddessC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/goddess.png"))); // NOI18N
        pnlChapter3Ending.add(lblGoddessC3E);
        lblGoddessC3E.setBounds(170, 50, 930, 673);

        lblAssassinC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter3Ending.add(lblAssassinC3E);
        lblAssassinC3E.setBounds(480, 60, 382, 666);

        lblAlienKingC3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Boss 1st Ohase.png"))); // NOI18N
        pnlChapter3Ending.add(lblAlienKingC3E);
        lblAlienKingC3E.setBounds(130, 50, 1110, 673);

        lblC3EThrone3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/lair_restore_2.png"))); // NOI18N
        pnlChapter3Ending.add(lblC3EThrone3);
        lblC3EThrone3.setBounds(0, 0, 1280, 720);
        pnlChapter3Ending.add(lblC3EThrone2);
        lblC3EThrone2.setBounds(0, 0, 0, 0);

        lblC3EThrone1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/lair.png"))); // NOI18N
        pnlChapter3Ending.add(lblC3EThrone1);
        lblC3EThrone1.setBounds(0, 0, 1280, 720);

        lblC3ESky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/ending.png"))); // NOI18N
        pnlChapter3Ending.add(lblC3ESky);
        lblC3ESky.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter3Ending);
        pnlChapter3Ending.setBounds(0, 0, 1280, 720);

        pnlChapter3Stair.setBackground(new java.awt.Color(25, 25, 25));
        pnlChapter3Stair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlChapter3Stair.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlChapter3Stair.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlChapter3Stair.setLayout(null);

        btnNext4.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnNext4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_up.png"))); // NOI18N
        btnNext4.setText("Next");
        btnNext4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext4.setMaximumSize(new java.awt.Dimension(100, 40));
        btnNext4.setMinimumSize(new java.awt.Dimension(100, 40));
        btnNext4.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_down.png"))); // NOI18N
        btnNext4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/button_hover.png"))); // NOI18N
        btnNext4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext4ActionPerformed(evt);
            }
        });
        pnlChapter3Stair.add(btnNext4);
        btnNext4.setBounds(1140, 620, 100, 40);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtDialogueC3S.setBackground(new java.awt.Color(250, 235, 215));
        txtDialogueC3S.setColumns(20);
        txtDialogueC3S.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        txtDialogueC3S.setForeground(new java.awt.Color(188, 132, 29));
        txtDialogueC3S.setRows(5);
        jScrollPane6.setViewportView(txtDialogueC3S);

        pnlChapter3Stair.add(jScrollPane6);
        jScrollPane6.setBounds(200, 580, 910, 90);

        lblDialogueBox5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/dialogue_box.png"))); // NOI18N
        pnlChapter3Stair.add(lblDialogueBox5);
        lblDialogueBox5.setBounds(20, 540, 1236, 162);

        lblShielderC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder.png"))); // NOI18N
        pnlChapter3Stair.add(lblShielderC3S);
        lblShielderC3S.setBounds(400, 90, 560, 641);

        lblMageC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage.png"))); // NOI18N
        pnlChapter3Stair.add(lblMageC3S);
        lblMageC3S.setBounds(350, 90, 560, 641);

        lblAssassinC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin.png"))); // NOI18N
        pnlChapter3Stair.add(lblAssassinC3S);
        lblAssassinC3S.setBounds(480, 60, 382, 666);

        lblShielderAlterC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Shielder Alter.png"))); // NOI18N
        pnlChapter3Stair.add(lblShielderAlterC3S);
        lblShielderAlterC3S.setBounds(400, 60, 630, 673);

        lblAssassinAlterC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Assassin Alter.png"))); // NOI18N
        pnlChapter3Stair.add(lblAssassinAlterC3S);
        lblAssassinAlterC3S.setBounds(450, 60, 630, 673);

        lblAlienKingC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Boss 1st Ohase.png"))); // NOI18N
        pnlChapter3Stair.add(lblAlienKingC3S);
        lblAlienKingC3S.setBounds(130, 50, 1110, 673);

        lblMageAlterC3S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Character/Mage Alter.png"))); // NOI18N
        pnlChapter3Stair.add(lblMageAlterC3S);
        lblMageAlterC3S.setBounds(360, 60, 630, 673);

        lblC3SBlackScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/Black.png"))); // NOI18N
        pnlChapter3Stair.add(lblC3SBlackScreen);
        lblC3SBlackScreen.setBounds(0, 0, 1280, 720);

        lblC3SStair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/steps.png"))); // NOI18N
        pnlChapter3Stair.add(lblC3SStair);
        lblC3SStair.setBounds(0, 0, 1280, 720);

        lblC3SHall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/hallway_2.png"))); // NOI18N
        pnlChapter3Stair.add(lblC3SHall);
        lblC3SHall.setBounds(0, 0, 1280, 720);

        lblC3SThrone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dialogue/Backgrounds/lair.png"))); // NOI18N
        pnlChapter3Stair.add(lblC3SThrone);
        lblC3SThrone.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlChapter3Stair);
        pnlChapter3Stair.setBounds(0, 0, 1280, 720);

        pnlLeaderBoards.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnlLeaderBoards.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnlLeaderBoards.setOpaque(false);
        pnlLeaderBoards.setLayout(null);

        btnBack.setFont(new java.awt.Font("Joystix Monospace", 0, 12)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setMaximumSize(new java.awt.Dimension(100, 50));
        btnBack.setMinimumSize(new java.awt.Dimension(100, 50));
        btnBack.setPreferredSize(new java.awt.Dimension(100, 50));
        btnBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Pressed.png"))); // NOI18N
        btnBack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Button_BattleUI_Hovered.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlLeaderBoards.add(btnBack);
        btnBack.setBounds(600, 570, 100, 50);

        pnlScore.setToolTipText("");
        pnlScore.setEnabled(false);
        pnlScore.setFocusable(false);
        pnlScore.setOpaque(false);
        pnlScore.setLayout(new java.awt.GridLayout(1, 0));

        tblScore.setBackground(new java.awt.Color(0, 153, 204));
        tblScore.setFont(new java.awt.Font("Joystix Monospace", 0, 18)); // NOI18N
        tblScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblScore.setGridColor(new java.awt.Color(0, 153, 204));
        tblScore.setMaximumSize(new java.awt.Dimension(150, 80));
        tblScore.setMinimumSize(new java.awt.Dimension(150, 80));
        tblScore.setOpaque(false);
        tblScore.getTableHeader().setResizingAllowed(false);
        tblScore.getTableHeader().setReorderingAllowed(false);
        tblScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScoreMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblScore);

        pnlScore.add(jScrollPane7);

        pnlLeaderBoards.add(pnlScore);
        pnlScore.setBounds(290, 40, 720, 500);

        lblLB_UI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/LeaderBoards_UI.png"))); // NOI18N
        pnlLeaderBoards.add(lblLB_UI);
        lblLB_UI.setBounds(275, 25, 752, 532);

        lblBGLeaderBoards.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG_LeaderBoards.png"))); // NOI18N
        pnlLeaderBoards.add(lblBGLeaderBoards);
        lblBGLeaderBoards.setBounds(0, 0, 1280, 720);

        getContentPane().add(pnlLeaderBoards);
        pnlLeaderBoards.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNxtActionPerformed
        // TODO add your handling code here:
        switch (ctr) {
            case 0:
                //playMusic("/Music/ost_1.wav");
                txtDialogue.setText("A blinding light.");
                break;
            case 1:
                txtDialogue.setText("Their ruler, the alien king, proclaimed that they should rule all beings on earth.\nHumans opposed and it was not long till humanity was forced to fight \na battle for survival. ");
                break;
            case 2:
                lblIntro2.setVisible(true);
                lblIntro1.setVisible(false);
                txtDialogue.setText("Three close adventurers, a Mage, a Shielder, and an Assassin found themselves at \nthe forefront of humanity's defense against the extraterrestrial menace. ");
                break;
            case 3:
                txtDialogue.setText("The alien king, a formidable foe, led an army of minions. Despite being hailed as \nthe Strongest Party, the Adventurers realized they were severely outmatched.");
                break;
            case 4:
                txtDialogue.setText("Faced with the impending doom, the trio took a desperate gamble.");
                break;
            case 5:
                txtDialogue.setText("With a unified decision, they called upon the Goddess, \na mysterious entity rumored to possess the power to turn the tide \nagainst the alien invaders. ");
                break;
            case 6:
                lblIntro3.setVisible(true);
                lblIntro2.setVisible(false);
                txtDialogue.setText("The Goddess appeared before them in a shimmering light,\nher eyes glowing with a celestial intensity.");
                break;
            case 7:
                txtDialogue.setText("\"I can only grant one of you my blessing,\"");
                break;
            case 8:
                txtDialogue.setText("her voice echoing through the desolate battlefield");
                break;
            case 9:
                txtDialogue.setText("The Adventurer’s exchanged glances, understanding \nthe gravity of the choice before them");
                break;
            case 10:
                txtDialogue.setText("The fate of Earth rested on the shoulders of the chosen hero.");
                break;
            case 11:
                txtDialogue.setText("After a moment of tense deliberation, the Adventurer’s made their decision.");
                btnNxt.setEnabled(false);
                timer = new Timer(2000, e -> {
                    btnNxt.setEnabled(true);
                    pnlCharacterSelection.setVisible(true);
                }); timer.setRepeats(false);
                timer.start();
                break;
            case 12:
                txtDialogue.setText("The Goddess raised her hand, and a blinding light enveloped the chosen one");
                break;
            case 13:
                lblIntro4.setVisible(true);
                lblIntro3.setVisible(false);
                txtDialogue.setText("The three heroes then set to battle the alien king.\nThe Mage, the Shielder and the Assassin, despite their \nbrilliance, fell in battle");
                break;
            case 14:
                lblIntro5.setVisible(true);
                lblIntro4.setVisible(false);
                //playMusic("");
                txtDialogue.setText("The world was plunged into darkness.");
                break;
            case 15:
                txtDialogue.setText("10 Years Later...");
                lblIntro6.setVisible(true);
                lblIntro5.setVisible(false);
                break;
            case 16:
                txtDialogue.setText("True to the Goddess words. You have been reincarnated along with the \nskills you have been promised.");
                break;
            case 17:
                txtDialogue.setText("The world is vastly different from what you know.");
                break;
            case 18:
                txtDialogue.setText("Every structure you encounter is crumbling and everything was \nfilled with despair.");
                break;
            case 19:
                txtDialogue.setText("Through the information you have gathered, you learned \nthat the Alien King has made the Tower of Hope its lair.");
                break;
            case 20:
                txtDialogue.setText("As the newly reincarnated Hero, you set out on a venture to save the world.");
                break;
            case 21:
                lblIntro7.setVisible(true);
                lblIntro6.setVisible(false);
                txtDialogue.setText("You reached the gates of the Tower of Hope. \nOnce a majestic monument, now a crumbling visage of what it once was.");
                break;
            case 22:
                txtDialogue.setText("There is an enemy in formt of the gate");
                break;
            case 23:
                if (Chara == 1)
                    lblAssassin.setVisible(true);
                else if (Chara == 2)
                    lblShielder1.setVisible(true);
                else
                    lblMage1.setVisible(true);
                txtDialogue.setText("A basic mob... good for a warm up");
                break;
            case 24:
                lblChapter2EBG.setVisible(false);
                lblEnemyAvatar_C1H.setVisible(false);
                minion = new Minion("Satyr",100);
                lblEnemy_Intro.setVisible(true);
                lblNameE.setText(minion.getName());
                pnlIntro.setVisible(false);
                pnlBattle.setVisible(true);
                lblBattleStart.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleStart.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/battle_ost1.wav");
                break;
            default:
                break;
        }
        ctr++;
    }//GEN-LAST:event_btnNxtActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        switch (ctr) {
            case 0:
                stopMusic();
                playMusic("/Music/ost6Sus2.wav");
                txtDialogue1.setText("You reached the hallway of the building. It is littered with dead bodies. ");
                break;
            case 1:
                lblMonster.setVisible(true);
                txtDialogue1.setText("in the middle is another alien");
                break;
            case 2:
                if(Chara==1){
                    lblAssassinC1H.setVisible(true);
                    //lblIconAssassinC1E.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC1H.setVisible(true);
                }
                else{
                    lblMageC1H.setVisible(true);
                }
                lblMonster.setVisible(false);
                txtDialogue1.setText("“Alien Scum”");
                break;
            case 3:
                txtDialogue1.setText("You decided to engaged it!");
                break;
            case 4:
                lblNameE.setText(minion.getName());
                pnlChapter1Hallway.setVisible(false);
                pnlBattle.setVisible(true);
                lblChapter1HBG.setVisible(true);
                
                lblEnemy_Intro.setVisible(false);
                lblEnemy_dmg_Intro.setVisible(false);
                lblEnemyAvatar_Intro.setVisible(false);
                lblEnemy_C1H.setVisible(true);
                lblEnemyAvatar_C1H.setVisible(true);
                lblBattleStart.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleStart.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/battle_ost1.wav");
            default:
                break;
        }
        ctr++;
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        switch (ctr) {
            case 0:
                stopMusic();
                playMusic("/Music/ost6Sus2.wav");
                if(Chara==1){
                    lblAssassinC1E.setVisible(true);
                    //lblIconAssassinC1E.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC1E.setVisible(true);
                }
                else{
                    lblMageC1E.setVisible(true);
                }
                txtDialogue2.setText("“I remember there were those devices installed in this building that uses levitating \nstones to traverse, elevators I think they were called.”");
                break;
            case 1:
                //lblMonster1.setVisible(true);
                //lblAssassin2.setVisible(false);
                //lblIconAssassin2.setVisible(false);
                lblMonsterC1E.setVisible(true);
                if(Chara==1){
                    lblAssassinC1E.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC1E.setVisible(false);
                }
                else{
                    lblMageC1E.setVisible(false);
                }
                txtDialogue2.setText("There is an alien blocking the way to the elevator");
                break;
            case 2:
                //lblAssassin2.setVisible(true);
                //lblMonster1.setVisible(false);
                //lblIconAssassin2.setVisible(true);
                if(Chara==1){
                    lblAssassinC1E.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC1E.setVisible(true);
                }
                else{
                    lblMageC1E.setVisible(true);
                }
                lblMonsterC1E.setVisible(false);
                txtDialogue2.setText("You spent minutes looking for other ways to pass, but there were none.");
                break;
            case 3:
                txtDialogue2.setText("Swallowing your fear, you decided to face it head on!");
                lblNameE.setText(minion.getName());
                pnlChapter1Elevator.setVisible(false);
                pnlBattle.setVisible(true);
                lblChapter1EBG.setVisible(true);
                
                lblEnemy_Intro.setVisible(true);
                lblEnemy_dmg_Intro.setVisible(false);
                lblEnemyAvatar_Intro.setVisible(true);
                lblEnemy_C1H.setVisible(false);
                lblEnemy_dmg_C1H.setVisible(false);
                lblEnemyAvatar_C1H.setVisible(false);
                lblBattleStart.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleStart.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/battle_ost1.wav");
                break;
            default:
                break;
        }
        ctr++;
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        // TODO add your handling code here:
        switch (ctr) {
            case 0:
                stopMusic();
                playMusic("/Music/Ending.wav");
                txtDialogue3.setText("As you waited for the elevator to reach the top. \nThe memories of your comrades flashed back you begin to cry");
                break;
            case 1:
                if(Chara==1){
                    lblAssassinC2E.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(true);
                }
                else{
                    lblMageC1E.setVisible(true);
                }
                txtDialogue3.setText("“*sob* God, these memories are from long ago', you said. \nWhy am i remembering these now”");
                break;
            case 2:
                stopMusic();
                if(Chara==1){
                    lblAssassinC2E.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(false);
                }
                else{
                    lblMageC2E.setVisible(false);
                }
                txtDialogue3.setText("A sudden noise interrupts your reminiscing, followed \nby the sensation of the floor leaving your foot behind");
                break;
            case 3:
                if(Chara==1){
                    lblAssassinC2E.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(true);
                }
                else{
                    lblMageC1E.setVisible(true);
                }
                txtDialogue3.setText("The elevator is falling apart. I need to get out of here");
                break;
            case 4:
                if(Chara==1){
                    lblAssassinC2E.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(false);
                }
                else{
                    lblMageC2E.setVisible(false);
                }
                txtDialogue3.setText("You jumped out of the moving elevator into a floor \njust levels before the top floor");
                break;
            case 5:
                lblChapter2Hallway.setVisible(true);
                lblChapter2Elevator.setVisible(false);
                txtDialogue3.setText("You lay there exhausted and tired. but you \nunderstood the responsibility the goddess has given you.");
                break;
            case 6:
                txtDialogue3.setText("So you willed yourself to rise");
                break;
            case 7:
                stopMusic();
                playMusic("/Music/ost7Sus3.wav");
                lblFamilliarC2E.setVisible(true);
                txtDialogue3.setText("As you raise your head, a familiar visage stood \nbefore you");
                break;
            case 8:
                if(Chara==1){
                    lblShielderAlterC2E.setVisible(true);
                }
                else if(Chara==2){
                    lblMageAlterC2E.setVisible(true);
                }
                else{
                    lblAssassinAlterC2E.setVisible(true);
                }
                lblFamilliarC2E.setVisible(false);
                txtDialogue3.setText("It was your friend from a distant past, but there is something different about him.");
                break;
            case 9:
                if(Chara==1){
                    lblAssassinC2E.setVisible(true);
                    lblShielderAlterC2E.setVisible(false);
                    txtDialogue3.setText("“Shielder… ... is that you? It's me! The Assassin!”");
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(true);
                    lblMageAlterC2E.setVisible(false);
                    txtDialogue3.setText("“Mage… ... is that you? It's me! The Assassin!”");
                }
                else{
                    lblMageC2E.setVisible(true);
                    lblAssassinAlterC2E.setVisible(false);
                    txtDialogue3.setText("“Assassin… ... is that you? It's me! The Assassin!”");
                }
                break;
            case 10:
                if(Chara==1){
                    lblAssassinC2E.setVisible(false);
                    lblShielderAlterC2E.setVisible(true);
                    txtDialogue3.setText("But Shielder was only fixated on attacking you.");
                }
                else if(Chara==2){
                    lblShielderC2E.setVisible(false);
                    lblMageAlterC2E.setVisible(true);
                    txtDialogue3.setText("But Assassin was only fixated on attacking you.");
                }
                else{
                    lblMageC2E.setVisible(false);
                    lblAssassinAlterC2E.setVisible(true);
                    txtDialogue3.setText("But Assassin was only fixated on attacking you.");
                }
                break;
            case 11:
                txtDialogue3.setText("You dodged the barrage of attacks unleashed by your past friend.");
                break;
            case 12:
                txtDialogue3.setText("It was then you noticed. The mark of the alien king on her facec.");
                break;
            case 13:
                if(Chara==1){
                    lblShielderAlterMarkC2E.setVisible(true);
                }
                else if(Chara==2){
                    lblMageAlterMarkC2E.setVisible(true);
                }
                else{
                    lblAssassinAlterMarkC2E.setVisible(true);
                }
                txtDialogue3.setText("");
                break;
            case 14:
                txtDialogue3.setText("You realized your friend is gone.");
                break;
            case 15:
                txtDialogue3.setText("What appears before you is nothing but a puppet, \na shell of your friend, being puppeteered by the evil alien king.");
                break;
            case 16:
                lblShielderAlterMarkC2E.setVisible(false);
                lblMageAlterMarkC2E.setVisible(false);
                lblAssassinAlterMarkC2E.setVisible(false);
                txtDialogue3.setText("So you engaged her.");
                lblNameE.setText(general.getName());
                pnlChapter2Elevator.setVisible(false);
                pnlBattle.setVisible(true);
                lblChapter2EBG.setVisible(true);
                
                lblEnemy_Intro.setVisible(false);
                lblEnemy_dmg_Intro.setVisible(false);
                lblEnemyAvatar_Intro.setVisible(false);
                //New Enemy
                if (Chara==1)
                    lblEnemy_C2E.setVisible(true);
                else if (Chara==2)
                    lblEnemy_C2E2.setVisible(true);
                else if (Chara==3)
                    lblEnemy_C2E1.setVisible(true);
                lblEnemy_dmg_C1H.setVisible(false);
                if (Chara==1)
                    lblEnemyAvatar_C2E.setVisible(true);
                else if (Chara==2)
                    lblEnemyAvatar_C2E2.setVisible(true);
                else if (Chara==3)
                    lblEnemyAvatar_C2E1.setVisible(true);
                lblBattleStart.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleStart.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/battle_ost1.wav");
                break;
            default:
                break;
        }
        
        ctr++;
    }//GEN-LAST:event_btnNext2ActionPerformed
    boolean shielderDef=false;
    int SP=1;
    
    public void turnShielder(int action){
        System.out.println("Score: "+getScore());
        buttons(0);
        boolean hasDefended=false;
        if (hero.isAlive() && general.isAlive()) {

            //action = SW.getAction();
            switch (action){
                 case 1: if (shielderDef==false){
                            hero.attackEnemyG(general);
                            lblLog.setText(hero.getName() + " performs a basic attack and deals " + hero.getDamage() + " damage!");
                            setScore(Score+=hero.getDamage());
                            lblAtk.setVisible(true);
                            buttons(0);
                            timer = new Timer(1600, e -> {
                                lblAtk.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();  
                        }
                        else{
                            buttons(0);
                            timer = new Timer(1600, e -> {
                                lblLog.setText("Shielder's Forcefield is active, blocking the attack!\n");
                                shielderDef=false;
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }                        
                        break;
                case 2: hero.defend();
                        if (hero.getDefend()){
                            lblLog.setText(hero.getName() + " successfully defends against the attack!");
                        }else {
                            lblLog.setText(hero.getName() + " fails to defend and takes " + hero.getDamageEnemy() + " damage!");
                        }
                        hasDefended=true;
                        buttons(1);
                        break;
                case 3: hero.skillG(general);
                        if (Chara==1 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_A.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {

                                lblSkill_A.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==2 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_S.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                
                                lblSkill_S.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==3 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            
                            lblSkill_M.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                lblSkill_M.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else {
                            timer = new Timer(2000, e -> {
                                lblLog.setText(hero.getName() + " is out of energy!");
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        lblLog.setText(hero.getName() + " performs a special attack and deals " + hero.getDamage() + " damage!");
                        break;
            }
            if (general.isAlive() && hasDefended==false) {
                SP++;
                if (SP%3==0){
                    general.skill(hero);
                    lblLog.setText(general.getName() + " will block the next attack!");
                    shielderDef=true; 
                }
                else {
                    general.attackHero(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();  
                }             
            }
            hasDefended=false;
            if (hero.getEnergy()<100){
            btnSPAtk.setEnabled(false);
            }else if (hero.getEnergy()==100){
                btnSPAtk.setEnabled(true);
            }
        }
        
        //Update UI Elements
        pbPlayerHP.setValue(hero.getHealth());
        pbPlayerMP.setValue(hero.getEnergy());
        lblNameP.setText(hero.getName());
        pbEnemyHP.setValue(general.getHealth());
        checkWin();
    }
    
    int SP2=1;
    public void turnMage(int action){
        System.out.println("Score: "+getScore());
        
        buttons(0);
        boolean hasDefended=false;
        if (hero.isAlive() && general.isAlive()) {

            //action = SW.getAction();
            switch (action){
                 case 1:
                        hero.attackEnemyG(general);
                        lblLog.setText(hero.getName() + " performs a basic attack and deals " + hero.getDamage() + " damage!");
                        setScore(Score+=hero.getDamage());
                        lblAtk.setVisible(true);
                        buttons(0);
                        timer = new Timer(1600, e -> {
                            lblAtk.setVisible(false);
                            buttons(1);
                        });
                        timer.setRepeats(false);
                        timer.start();                        
                        break;
                case 2: hero.defend();
                        if (hero.getDefend()){
                            lblLog.setText(hero.getName() + " successfully defends against the attack!");
                        }else {
                            lblLog.setText(hero.getName() + " fails to defend and takes " + hero.getDamageEnemy() + " damage!");
                        }
                        hasDefended=true;
                        buttons(1);
                        break;
                case 3: hero.skillG(general);
                        if (Chara==1 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_A.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {

                                lblSkill_A.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==2 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_S.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                
                                lblSkill_S.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==3 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            
                            lblSkill_M.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                lblSkill_M.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else {
                            timer = new Timer(2000, e -> {
                                lblLog.setText(hero.getName() + " is out of energy!");
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        lblLog.setText(hero.getName() + " performs a special attack and deals " + hero.getDamage() + " damage!");
                        break;
            }
            if (general.isAlive() && hasDefended==false) {
                SP2++;
                if (SP2%6==0 && hasDefended==false){
                    general.skill(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();  
                }
                else if (hasDefended==false){
                    general.attackHero(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start(); 
                    }    
            }
            hasDefended=false;
            if (hero.getEnergy()<100){
                btnSPAtk.setEnabled(false);
            }else if (hero.getEnergy()==100){
                btnSPAtk.setEnabled(true);
            }
        }
        
        //Update UI Elements
        pbPlayerHP.setValue(hero.getHealth());
        pbPlayerMP.setValue(hero.getEnergy());
        lblNameP.setText(hero.getName());
        pbEnemyHP.setValue(general.getHealth());
        checkWin();
    }
    
    int SP3=1;
    public void turnAssassin(int action){
        System.out.println("Score: "+getScore());
        
        buttons(0);
        boolean hasDefended=false;
        if (hero.isAlive() && general.isAlive()) {

            //action = SW.getAction();
            switch (action){
                 case 1:
                        hero.attackEnemyG(general);
                        lblLog.setText(hero.getName() + " performs a basic attack and deals " + hero.getDamage() + " damage!");
                        setScore(Score+=hero.getDamage());
                        lblAtk.setVisible(true);
                        buttons(0);
                        timer = new Timer(1600, e -> {
                            lblAtk.setVisible(false);
                            buttons(1);
                        });
                        timer.setRepeats(false);
                        timer.start();                        
                        break;
                case 2: hero.defend();
                        if (hero.getDefend()){
                            lblLog.setText(hero.getName() + " successfully defends against the attack!");
                        }else {
                            lblLog.setText(hero.getName() + " fails to defend and takes " + hero.getDamageEnemy() + " damage!");
                        }
                        hasDefended=true;
                        buttons(1);
                        break;
                case 3: hero.skillG(general);
                        if (Chara==1 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_A.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {

                                lblSkill_A.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==2 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_S.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                
                                lblSkill_S.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==3 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            
                            lblSkill_M.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                lblSkill_M.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else {
                            timer = new Timer(2000, e -> {
                                lblLog.setText(hero.getName() + " is out of energy!");
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        lblLog.setText(hero.getName() + " performs a special attack and deals " + hero.getDamage() + " damage!");
                        break;
            }
            if (general.isAlive() && hasDefended==false) {
                SP3++;
                if (SP3%5==0 && hasDefended==false){
                    general.skill(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();  
                }
                else if (hasDefended==false){
                    general.attackHero(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();     
                }
          
            }
            hasDefended=false;
            if (hero.getEnergy()<100){
                btnSPAtk.setEnabled(false);
            }else if (hero.getEnergy()==100){
                btnSPAtk.setEnabled(true);
            }
        }
        
        //Update UI Elements
        pbPlayerHP.setValue(hero.getHealth());
        pbPlayerMP.setValue(hero.getEnergy());
        lblNameP.setText(hero.getName());
        pbEnemyHP.setValue(general.getHealth());
        checkWin();
    }
    
    int SP4=1;
    public void turnAlien(int action){
        System.out.println("Score: "+getScore());
        
        buttons(0);
        boolean hasDefended=false;
        if (hero.isAlive() && general.isAlive()) {

            //action = SW.getAction();
            switch (action){
                 case 1:
                        hero.attackEnemyG(general);
                        lblLog.setText(hero.getName() + " performs a basic attack and deals " + hero.getDamage() + " damage!");
                        setScore(Score+=hero.getDamage());
                        lblAtk.setVisible(true);
                        buttons(0);
                        timer = new Timer(1600, e -> {
                            lblAtk.setVisible(false);
                            buttons(1);
                        });
                        timer.setRepeats(false);
                        timer.start();                        
                        break;
                case 2: hero.defend();
                        if (hero.getDefend()){
                            lblLog.setText(hero.getName() + " successfully defends against the attack!");
                        }else {
                            lblLog.setText(hero.getName() + " fails to defend and takes " + hero.getDamageEnemy() + " damage!");
                        }
                        hasDefended=true;
                        buttons(1);
                        break;
                case 3: hero.skillG(general);
                        if (Chara==1 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_A.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {

                                lblSkill_A.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==2 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());

                            lblSkill_S.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                
                                lblSkill_S.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else if (Chara==3 && hero.getSkillSuccess()){
                            hero.setSkillSuccess(false);
                            setScore(Score+=hero.getDamage());
                            
                            lblSkill_M.setVisible(true);
                            buttons(0);
                            timer = new Timer(2000, e -> {
                                lblSkill_M.setVisible(false);
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }else {
                            timer = new Timer(2000, e -> {
                                lblLog.setText(hero.getName() + " is out of energy!");
                                buttons(1);
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        lblLog.setText(hero.getName() + " performs a special attack and deals " + hero.getDamage() + " damage!");
                        break;
            }
            if (general.isAlive() && hasDefended==false) {
                SP4++;
                if (SP4%8==0 && hasDefended==false){
                    general.skill(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();  
                }
                else if (hasDefended==false){
                    general.attackHero(hero);
                    Timer timer = new Timer(2000, e -> {
                        lblLog.setText(general.getName() + " attacks " + hero.getName() + " for " + general.getDamage() + " damage!");
                        //pbPlayerHP.setValue(hero.getHealth());
                        buttons(1);
                    });
                    timer.setRepeats(false);
                    timer.start();     
                }
            }
            hasDefended=false;
            if (hero.getEnergy()<100){
                btnSPAtk.setEnabled(false);
            }else if (hero.getEnergy()==100){
                btnSPAtk.setEnabled(true);
            }
        }
        
        //Update UI Elements
        pbPlayerHP.setValue(hero.getHealth());
        pbPlayerMP.setValue(hero.getEnergy());
        lblNameP.setText(hero.getName());
        pbEnemyHP.setValue(general.getHealth());
        checkWin();
    }
    private void btnNext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext3ActionPerformed
        lblChapter2Hallway1.setVisible(true);
        switch (ctr) {
            case 0:
                stopMusic();
                playMusic("/Music/ost5Sus.wav");
                txtDialogueC2H.setText("As your once ally laid there, another figure stepped in the shadow.");
                break;
            case 1:
                if(Chara==1){
                    lblMageAlterC2H.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC2H.setVisible(true);
                }
                else{
                    lblShielderAlterC2H.setVisible(true);
                }
                txtDialogueC2H.setText("");
                break;
            case 2:
                if(Chara==1){
                    txtDialogueC2H.setText("The once greatest Mage now branded with the alien kings seal.");
                }
                else if(Chara==2){
                    txtDialogueC2H.setText("The once greatest Assassin now branded with the alien kings seal.");
                }
                else{
                    txtDialogueC2H.setText("The once greatest Shielder now branded with the alien kings seal.");
                }
                break;
            case 3:
                if(Chara==1){
                    lblMageAlterC2H.setVisible(false);
                    lblAssassinC2H.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC2H.setVisible(false);
                    lblShielderC2H.setVisible(true);
                }
                else{
                    lblShielderAlterC2H.setVisible(false);
                    lblMageC2H.setVisible(true);
                }
                txtDialogueC2H.setText("You readied yourself, but then something unexpected happened.");
                break;
            case 4:
                stopMusic();
                if(Chara==1){
                    lblAssassinC2H.setVisible(false);
                    txtDialogueC2H.setText("She spoke.");
                }
                else if(Chara==2){
                    lblShielderC2H.setVisible(false);
                    txtDialogueC2H.setText("He spoke.");
                }
                else{
                    lblMageC2H.setVisible(false);
                    txtDialogueC2H.setText("She spoke.");
                }
                break;
            case 5:
                if(Chara==1){
                    lblMageAlterC2H.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC2H.setVisible(true);
                }
                else{
                    lblShielderAlterC2H.setVisible(true);
                }
                txtDialogueC2H.setText("Struggling, yes, but you can still make out the words.");
                break;
            case 6:
                if(Chara==1){
                    txtDialogueC2H.setText("“Assassin…end…me”");
                }
                else if(Chara==2){
                    txtDialogueC2H.setText("“Shielder…end…me”");
                }
                else{
                    txtDialogueC2H.setText("“Mage…end…me”");
                }
                break;
            case 7:
                txtDialogueC2H.setText("Your friend, even though under the spell of the alien king, \nkept on fighting all these years");
                break;
            case 8:
                txtDialogueC2H.setText("“I...can't..stop..it...anymore”");
                break;
            case 9:
                txtDialogueC2H.setText("Her withered soul pleaded for death.");
                break;
            case 10:
                if(Chara==1){
                    lblMageAlterC2H.setVisible(false);
                    lblAssassinC2H.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC2H.setVisible(false);
                    lblShielderC2H.setVisible(true);
                }
                else{
                    lblShielderAlterC2H.setVisible(false);
                    lblMageC2H.setVisible(true);
                }
                txtDialogueC2H.setText("Though it pains you, you granted your friends wish.");
                break;
            case 11:
                lblShielderAlterMarkC2E.setVisible(false);
                lblMageAlterMarkC2E.setVisible(false);
                lblAssassinAlterMarkC2E.setVisible(false);
                //txtDialogue3.setText("So you engaged her.");
                lblNameE.setText(general.getName());
                pnlChapter2Elevator.setVisible(false);
                pnlBattle.setVisible(true);
                lblChapter2EBG.setVisible(true);
                
                lblEnemy_Intro.setVisible(false);
                lblEnemy_dmg_Intro.setVisible(false);
                lblEnemyAvatar_Intro.setVisible(false);
                //New Enemy
                if (Chara==1){
                    lblEnemy_C2E.setVisible(false);
                    lblEnemy_C2E2.setVisible(true);
                }
                else if (Chara==2){
                    lblEnemy_C2E2.setVisible(false);
                    lblEnemy_C2E1.setVisible(true);
                }            
                else if (Chara==3){
                        lblEnemy_C2E1.setVisible(false);
                        lblEnemy_C2E.setVisible(true);
                }
                
                if (Chara==1){
                    lblEnemyAvatar_C2E.setVisible(false);
                    lblEnemyAvatar_C2E2.setVisible(true);
                }
                else if (Chara==2){
                    lblEnemyAvatar_C2E2.setVisible(false);
                    lblEnemyAvatar_C2E1.setVisible(true);
                }
                else if (Chara==3){
                        lblEnemyAvatar_C2E1.setVisible(false);
                        lblEnemyAvatar_C2E.setVisible(true);
                }
                pnlChapter2Hallway.setVisible(false);
                lblBattleStart.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleStart.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/battle_ost1.wav");
                break;
            default:
                break;
        }
        ctr++;
    }//GEN-LAST:event_btnNext3ActionPerformed

    private void btnNext4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext4ActionPerformed
        switch (ctr) {
            case 0:
                lblThrone.setVisible(false);
                stopMusic();
                playMusic("/Music/ost2SNOWFLAKE.wav");
                lblC3SHall.setVisible(true);
                txtDialogueC3S.setText("As your friend was laying on the floor, you immediately approached him.");
                break;
            case 1:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(true);
                    txtDialogueC3S.setText("'Damn...Assassin'");
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(true);
                    txtDialogueC3S.setText("'Damn...Shielder'");
                }
                else{
                    lblShielderAlterC3S.setVisible(true);
                    txtDialogueC3S.setText("'Damn...Mage'");
                }
                break;
            case 2:
                txtDialogueC3S.setText("'I didn't even think...you would actually...reach here'");
                break;
            case 3:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(false);
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(false);
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblShielderAlterC3S.setVisible(false);
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("'Stop talking, i can still save up you' ");
                break;
            case 4:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(true);
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(true);
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblShielderAlterC3S.setVisible(true);
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("'Nah, keep it... you will need it.. for the final fight'");
                break;
            case 5:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(false);
                    txtDialogueC3S.setText("Mage breath comes slower and slower as each minute passes.");
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(false);
                    txtDialogueC3S.setText("Assassin breath comes slower and slower as each minute passes.");
                }
                else{
                    lblShielderAlterC3S.setVisible(false);
                    txtDialogueC3S.setText("Shielder breath comes slower and slower as each minute passes.");
                }
                break;
            case 6:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(true);
                }
                else{
                    lblShielderAlterC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“You know what... ”");
                break;
            case 7:
                txtDialogueC3S.setText("“Its the memories of us three... our adventures, “");
                break;
            case 8:
                txtDialogueC3S.setText("“that made my mind...  resist the alien kings mind control”");
                break;
            case 9:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(false);
                }
                else{
                    lblShielderAlterC3S.setVisible(false);
                }
                txtDialogueC3S.setText("Tears starts falling down your eyes, a melancholic smile forms on his face");
                break;
            case 10:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(true);
                }
                else{
                    lblShielderAlterC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“Go on friend... make us proud...the rest is in your hands”");
                break;
            case 11:
                if(Chara==1){
                    lblMageAlterC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblAssassinAlterC3S.setVisible(false);
                }
                else{
                    lblShielderAlterC3S.setVisible(false);
                }
                txtDialogueC3S.setText("You held your dear friend in your arms as he draws his final breath.");
                break;
            case 12:
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“I'll carry on your wishes”");
                break;
            case 13:
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“I'll see this through”");
                stopMusic();
                break;
            case 14:
                stopMusic();
                lblC3SHall.setVisible(false);
                lblC3SStair.setVisible(true);
                txtDialogueC3S.setText("The environment drastically changes as you near the top floor");
                break;
            case 15:
                txtDialogueC3S.setText("Dead souls litter the stais, trapped in cages for eternity");
                break;
            case 16:
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“This is messed up”");
                break;
            case 17:
                txtDialogueC3S.setText("“What even is the purpose of this?”");
                break;
            case 18:
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("The door to the top floor is now in sight, an \noverwhelming feeling of fear comes upon you");
                break;
            case 19:
                txtDialogueC3S.setText("With every step you take, the feeling of dread increases; \nthough as if you going straight to impending doom. ");
                break;
            case 20:
                txtDialogueC3S.setText("You reached the door of the Alien Kings lair.");
                break;
            case 21:
                txtDialogueC3S.setText("A mix of fear and anger fills you inside. The primal urge \nto run away is screaming inside your body");
                break;
            case 22:
                txtDialogueC3S.setText("But your determination is stronger.");
                break;
            case 23:
                txtDialogueC3S.setText("Your pushed through that door with your might. The cold \nfeel of heavy metal against the heat of your raging body. ");
                break;
            case 24:
                lblC3SStair.setVisible(false);
                lblC3SBlackScreen.setVisible(true);
                txtDialogueC3S.setText("It opened at last.");
                break;
            case 25:
                lblC3SBlackScreen.setVisible(false);
                lblC3SThrone.setVisible(true);
                txtDialogueC3S.setText("Upon you is a throne room, with the accursed alien king sitting in the middle.");
                break;
            case 26:
                playMusic("/Music/ost7Sus3.wav");
                lblAlienKingC3S.setVisible(true);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“'I never thought i'd see you again”");
                break;
            case 27:
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“I'm here to take back what's ours. Our World”");
                break;
            case 28:
                lblAlienKingC3S.setVisible(true);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“Take back?”");
                break;
            case 29:
                txtDialogueC3S.setText("“What a hilarious sentence! You are actually killing me with this”");
                break;
            case 30:
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("The alien king continues laughing, his bellowing laughs echoing on the vast space.");
                break;
            case 31:
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“What's so funny?”");
                break;
            case 32:
                lblAlienKingC3S.setVisible(true);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“You want in on a little secret, Assassin?”");
                break;
            case 33:
                txtDialogueC3S.setText("“It was never yours to begin with.”");
                break;
            case 34:
                txtDialogueC3S.setText("“Have you ever thought about how life starts?”");
                break;
            case 35:
                txtDialogueC3S.setText("“The odds of a life containing a planet is 1 in a 100 million”");
                break;
            case 36:
                txtDialogueC3S.setText("“Did you honestly believe that this planet, which \nwas once a molten ball of flame, managed \nto be the 1 planet that life sprung upon?”");
                break;
            case 37:
                txtDialogueC3S.setText("“The answer is no.”");
                break;
            case 38:
                txtDialogueC3S.setText("“We made it happen, We, the Qlipthos”");
                break;
            case 39:
                txtDialogueC3S.setText("“We terraformed this planet, shaped it to be something \nsuitable for life”");
                break;
            case 40:
                txtDialogueC3S.setText("“You see, we have this Qlipoth tradition. A fun past \ntime for those who reached the peak of civillization; if you will”");
                break;
            case 41:
                txtDialogueC3S.setText("“We create hundreds of life on planets, such as this \none, in hopes that they will surpass us; Coming back after millions of years. \nWe even go as far as going into cryostasis to even out the playing field”");
                break;
            case 42:
                txtDialogueC3S.setText("“Qlipthos is actually a product of the same tradition”");
                break;
            case 43:
                txtDialogueC3S.setText("“But you see, thats the difference between us. We succeeded in overthrowing our creators. You humans didn't.”");
                break;
            case 44:
                txtDialogueC3S.setText("“You humans spent millions of years evolving just to kill each other instead.”");
                break;
            case 45:
                stopMusic();
                playMusic("/Music/ost1EOR.wav");
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“That's where you are wrong, we fight to protect our ideals.”");
                break;
            case 46:
                txtDialogueC3S.setText("“To ignore past that is a kin to a cherry picker only picking the ripest fruit”");
                break;
            case 47:
                txtDialogueC3S.setText("“You see what you want to see, to justify your massacre!”");
                break;
            case 48:
                lblAlienKingC3S.setVisible(true);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“So what are you gonna do about it?”");
                break;
            case 49:
                txtDialogueC3S.setText("“Can you still fight learning you are about to fight your God?”");
                break;
            case 50:
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“I will, and if i fail, another one will come and take you down.”");
                break;
            case 51:
                lblAlienKingC3S.setVisible(true);
                if(Chara==1){
                    lblAssassinC3S.setVisible(false);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(false);
                }
                else{
                    lblMageC3S.setVisible(false);
                }
                txtDialogueC3S.setText("“Then come maggots, i'll atleast give your life purpose \nby coverting your souls to fuel source; My final gift to your kind!”");
                break;
            case 52:
                txtDialogueC3S.setText("“HAHAHAHAHAHAHAHA!!!”");
                break;
            case 53:
                lblAlienKingC3S.setVisible(false);
                if(Chara==1){
                    lblAssassinC3S.setVisible(true);
                }
                else if(Chara==2){
                    lblShielderC3S.setVisible(true);
                }
                else{
                    lblMageC3S.setVisible(true);
                }
                txtDialogueC3S.setText("“Not on my watch you sadistic fuck, lets go!”");
                
                break;
            case 54:
                lblEnemy_C2E.setVisible(false);
                lblEnemy_C2E1.setVisible(false);
                lblEnemy_C2E2.setVisible(false);
                
                lblEnemyAvatar_C2E.setVisible(false);
                lblEnemyAvatar_C2E1.setVisible(false);
                lblEnemyAvatar_C2E2.setVisible(false);
                
                lblAlienKingAvatar.setVisible(true);
                lblAlienKing.setVisible(true);
                lblThrone.setVisible(true);
                lblBattleFatal.setVisible(true);
                pnlBattle.setVisible(true);
                timer = new Timer(1800, e -> {
                    lblBattleFatal.setVisible(false);
                }); 
                timer.setRepeats(false);
                timer.start();
                stopMusic();
                playMusic("/Music/ost3Battle.wav");
            default:
                break;
        }
        ctr++;
    }//GEN-LAST:event_btnNext4ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String Name = txtName.getText().trim(); //trim() method removes whitespace from both ends of a string.
        //int Score = 0;

        if (!Name.isEmpty()) {
            try { //try catch to check if database in connected
                Class.forName("com.mysql.cj.jdbc.Driver");//jdbc connector
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboards", "root", "1388582293"); //localhost mysql port, database name, username and password
                String sql = "select * from tblscore where Name='" + Name + "'"; //query to check last name to the database records
                st = con.createStatement(); //create connection
                ResultSet rs = st.executeQuery(sql); //executes the sql

                if(rs.next()==true){ //checks if the last name already exist in the database table
                    alert("You overwrite this record...");
                }
                else{
                    addPlayer(Name/*,Score*/); //calls saveUser method to save new record to the database
                    fetch(); //calls fetch method to update the GUI table
                    alert("You are now in the LeaderBoards.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SecondWind_.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alert("There is nothing to update :(");
        }
        
        pnlLeaderBoards.setVisible(true);
        pnlEnding.setVisible(false);
        new SecondWind_().setVisible(true);
        stopMusic();
        SecondWind_.this.dispose();
        playMusic("/Music/Intro.wav");
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        pnlMain.setVisible(true);
        pnlLeaderBoards.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScoreMouseClicked
        int i = tblScore.getSelectedRow();
        TableModel model = tblScore.getModel();
        /*txtID.setText(model.getValueAt(i, 0).toString());
        txtLastName.setText(model.getValueAt(i, 1).toString());
        txtFirstName.setText(model.getValueAt(i, 2).toString());
        txtAge.setText(model.getValueAt(i, 3).toString());
        */
    }//GEN-LAST:event_tblScoreMouseClicked

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        //opt = 1;
        stopMusic();
        playMusic("/Music/ost_1.wav");
        pnlMain.setVisible(false);
        pnlIntro.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnHighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighScoreActionPerformed
        // TODO add your handling code here:
        pnlMain.setVisible(false);
        pnlLeaderBoards.setVisible(true);
    }//GEN-LAST:event_btnHighScoreActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnShielderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShielderActionPerformed
        // TODO add your handling code here:
        pnlCharacterSelection.setVisible(false);
        lblNameP.setText("Hilma");
        lblShielder.setVisible(true);
        setChara(2);
        btnNext.setEnabled(true);
    }//GEN-LAST:event_btnShielderActionPerformed

    private void btnMageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMageActionPerformed
        // TODO add your handling code here:
        pnlCharacterSelection.setVisible(false);
        lblNameP.setText("Elfa");
        lblMage.setVisible(true);
        setChara(3);
        btnNext.setEnabled(true);
    }//GEN-LAST:event_btnMageActionPerformed

    private void btnArcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArcherActionPerformed
        // TODO add your handling code here:
        pnlCharacterSelection.setVisible(false);
        lblNameP.setText("Issiah");
        lblAassassin.setVisible(true);
        setChara(1);
        btnNext.setEnabled(true);
    }//GEN-LAST:event_btnArcherActionPerformed

    private void btnAtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtkActionPerformed
        // TODO add your handling code here:
        action = 1;
        activeAtk = !activeAtk;
        pnlAttack.setVisible(activeAtk);
        if(story<3)
            turnAttack(action);
        else if (story==3){
            if (Chara==1)
                turnShielder(action);
            else if (Chara==2)
                turnMage(action);
            else if (Chara==3)
                turnAssassin(action);
        }
        else if (story==4){
            if (Chara==1)
                turnMage(action);
            else if (Chara==2)
                turnAssassin(action);
            else if (Chara==3)
                turnShielder(action);
        }     
        else if (story==5)
            turnAlien(action);
    }//GEN-LAST:event_btnAtkActionPerformed

    private void btnSPAtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPAtkActionPerformed
        // TODO add your handling code here:
        action = 3;
        activeAtk = !activeAtk;
        pnlAttack.setVisible(activeAtk);
        if(story<3)
            turnAttack(action);
        else if (story==3){
            if (Chara==1)
                turnShielder(action);
            else if (Chara==2)
                turnMage(action);
            else if (Chara==3)
                turnAssassin(action);
        }
        else if (story==4){
            if (Chara==1)
                turnMage(action);
            else if (Chara==2)
                turnAssassin(action);
            else if (Chara==3)
                turnShielder(action);
        }     
        else if (story==5)
            turnAlien(action);
    }//GEN-LAST:event_btnSPAtkActionPerformed

    private void btnAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttackActionPerformed
        // TODO add your handling code here:
        activeAtk = !activeAtk;
        pnlAttack.setVisible(activeAtk);

    }//GEN-LAST:event_btnAttackActionPerformed

    private void btnDefendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefendActionPerformed
        // TODO add your handling code here:
        action = 2;
        if(story<3)
            turnAttack(action);
        else if (story==3){
            if (Chara==1)
                turnShielder(action);
            else if (Chara==2)
                turnMage(action);
            else if (Chara==3)
                turnAssassin(action);
        }
        else if (story==4){
            if (Chara==1)
                turnMage(action);
            else if (Chara==2)
                turnAssassin(action);
            else if (Chara==3)
                turnShielder(action);
        }     
        else if (story==5)
            turnAlien(action);
    }//GEN-LAST:event_btnDefendActionPerformed

    private void btnBagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBagActionPerformed
        // TODO add your handling code here:
        activeBag = !activeBag;
        pnlBag.setVisible(activeBag);
    }//GEN-LAST:event_btnBagActionPerformed

    private void btnNext5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext5ActionPerformed
        // TODO add your handling code here:
        switch (ctr) {
            case 0:
                stopMusic();
            lblC3EThrone1.setVisible(true);
            txtDialogueC3E.setText("The alien king slowly turn to ashes.");
            break;
            case 1:
            txtDialogueC3E.setText("And the throne returns to its former glory");
            break;
            case 2:
            lblC3EThrone2.setVisible(true);
            lblC3EThrone1.setVisible(false);
            txtDialogueC3E.setText("");
            break;
            case 3:
            lblC3EThrone3.setVisible(true);
            lblC3EThrone2.setVisible(false);
            txtDialogueC3E.setText("");
            break;
            case 4:
            txtDialogueC3E.setText("All of a sudden you were on your knees, bleeding. You knew fighting the alien king will have repercussions. ");
            break;
            case 5:

            txtDialogueC3E.setText("You layed down on the floor gravely wounded, accepting your death.");
            break;
            case 6:
                playMusic("/Music/ost4Moment.wav");
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("'Light?'");
            break;
            case 7:
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("A ray of light showers over you and a beautiful woman is forming in your vision. ");
            break;
            case 8:
            txtDialogueC3E.setText("It's the goddess. You felt your wounds heal as you bask over the light.");
            break;
            case 9:
            lblGoddessC3E.setVisible(true);
            txtDialogueC3E.setText("“'Well done, my chosen hero. “");
            break;
            case 10:
            txtDialogueC3E.setText("“You have slayed the alien king. ”");
            break;
            case 11:
            txtDialogueC3E.setText("“You have averted humanity's crisis. What is it that you seek and i'll grant it”");
            break;
            case 12:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("“'Can you bring back my friends?”");
            break;
            case 13:
            lblGoddessC3E.setVisible(true);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("'Sadly i can't interfere with life and death. An immense price is to be paid when you disrupt the cycle.");
            break;
            case 14:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("“Maybe its for the best. Knowing them, they wouldnt wish to be revived anyway if it means hurting another.”");
            break;
            case 15:
            lblGoddessC3E.setVisible(true);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("“Do you have any other wishes?”");
            break;
            case 16:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("'Nah' You said with a smile.");
            break;
            case 17:
            txtDialogueC3E.setText("This response perplexed the goddess.");
            break;
            case 18:
            lblGoddessC3E.setVisible(true);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("“Don't you wish for other things? Money and success?”");
            break;
            case 19:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3S.setText("“Throughout this journey i've realized there is more to life. ”");
            break;
            case 20:
            txtDialogueC3E.setText("The goddess smiled accepting defeat.");
            break;
            case 21:
            lblGoddessC3E.setVisible(true);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("“So, hero.... what comes after this?”");
            break;
            case 22:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("“I don't know? A journey perhaps? I can't gain what i've lost. But i can build another one”");
            break;
            case 23:
            lblGoddessC3E.setVisible(true);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
                txtDialogueC3S.setText("“'I wish you best Assassin, Humanity's saviour, on your journey'”");
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
                txtDialogueC3S.setText("“'I wish you best Shielder, Humanity's saviour, on your journey'”");
            }
            else{
                lblMageC3E.setVisible(false);
                txtDialogueC3E.setText("“'I wish you best Mage, Humanity's saviour, on your journey'”");
            }
            break;
            case 24:
            lblGoddessC3E.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(true);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(true);
            }
            else{
                lblMageC3E.setVisible(true);
            }
            txtDialogueC3E.setText("“Thanks”");
            break;
            case 25:
            lblC3ESky.setVisible(true);
            lblC3EThrone3.setVisible(false);
            if(Chara==1){
                lblAssassinC3E.setVisible(false);
            }
            else if(Chara==2){
                lblShielderC3E.setVisible(false);
            }
            else{
                lblMageC3E.setVisible(false);
            }
            txtDialogueC3E.setText("The goddess watched over you as you walked out of the tower. The hero, he who was selfless enough to risk his life for humanity, sets out into the horizon.");
            break;
            case 26:
                lblC3ECredits.setVisible(true);
                timer = new Timer(30000, e -> {
                    lblC3ECredits.setVisible(false);
                    stopMusic();
                    playMusic("/Music/ostCredits.wav");
                }); 
                timer.setRepeats(false);
                timer.start();
            case 27:
                pnlEnding.setVisible(true);
            default:
            break;
        }
        ctr++;
    }//GEN-LAST:event_btnNext5ActionPerformed

    private void btnHP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHP1ActionPerformed
        // TODO add your handling code here:
        hero.setHP(100);
        pbPlayerHP.setValue(100);
        btnHP1.setEnabled(false);
    }//GEN-LAST:event_btnHP1ActionPerformed

    private void btnHP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHP2ActionPerformed
        // TODO add your handling code here:
        hero.setHP(100);
        pbPlayerHP.setValue(100);
        btnHP2.setEnabled(false);
    }//GEN-LAST:event_btnHP2ActionPerformed

    private void btnMP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMP1ActionPerformed
        // TODO add your handling code here:
        hero.setEnergy(100);
        pbPlayerMP.setValue(100);
        btnMP1.setEnabled(false);
    }//GEN-LAST:event_btnMP1ActionPerformed

    private void btnMP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMP2ActionPerformed
        // TODO add your handling code here:
        hero.setEnergy(100);
        pbPlayerMP.setValue(100);
        btnMP2.setEnabled(false);
    }//GEN-LAST:event_btnMP2ActionPerformed

    @Override
    public void addPlayer(String Name/*,int Score*/) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboards", "root", "1388582293");
            String sql = "INSERT INTO `tblscore`(`Name`,`Score`) "
            + "VALUES ('" + Name + "','" + Score + "')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SecondWind_.class.getName()).log(Level.SEVERE, null, ex);
        }
        fetch();
    }
    
    
    @Override
    public void fetch() {
        leaderboards.clear();
        DefaultTableModel model1 = (DefaultTableModel) tblScore.getModel();
        model1.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboards", "root", "1388582293"); //localhost port, databasename, username, password
            String sql = "select * from tblscore order by Score desc";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Leaderboards user = new Leaderboards(rs.getString("Name"), rs.getInt("Score")); //Calling the Students class
            leaderboards.add(user);
        }
        DefaultTableModel model2 = (DefaultTableModel) tblScore.getModel();
        for ( Leaderboards user : leaderboards) { //
            Object[] row = new Object[2];
            row[0] = user.getName();
            row[1] = user.getScore();
            
            model2.addRow(row);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SecondWind_.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to show an info alert
    @Override
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
   //method to show an error alert
    @Override
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecondWind_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecondWind_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecondWind_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecondWind_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecondWind_().setVisible(true);
                SecondWind_ sw = new SecondWind_();
                sw.playMusic("/Music/Intro.wav");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ___________;
    private javax.swing.JPanel ____________;
    private javax.swing.JPanel _____________;
    private javax.swing.JButton btnArcher;
    private javax.swing.JButton btnAtk;
    private javax.swing.JButton btnAttack;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBag;
    private javax.swing.JButton btnDefend;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHP1;
    private javax.swing.JButton btnHP2;
    private javax.swing.JButton btnHighScore;
    private javax.swing.JButton btnMP1;
    private javax.swing.JButton btnMP2;
    private javax.swing.JButton btnMage;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnNext3;
    private javax.swing.JButton btnNext4;
    private javax.swing.JButton btnNext5;
    private javax.swing.JButton btnNxt;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSPAtk;
    private javax.swing.JButton btnShielder;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblAassassin;
    private javax.swing.JLabel lblAlienKing;
    private javax.swing.JLabel lblAlienKingAvatar;
    private javax.swing.JLabel lblAlienKingC3E;
    private javax.swing.JLabel lblAlienKingC3S;
    private javax.swing.JLabel lblAssassin;
    private javax.swing.JLabel lblAssassinAlterC2E;
    private javax.swing.JLabel lblAssassinAlterC2H;
    private javax.swing.JLabel lblAssassinAlterC3S;
    private javax.swing.JLabel lblAssassinAlterMarkC2E;
    private javax.swing.JLabel lblAssassinC1E;
    private javax.swing.JLabel lblAssassinC1H;
    private javax.swing.JLabel lblAssassinC2E;
    private javax.swing.JLabel lblAssassinC2H;
    private javax.swing.JLabel lblAssassinC3E;
    private javax.swing.JLabel lblAssassinC3S;
    private javax.swing.JLabel lblAtk;
    private javax.swing.JLabel lblAttackUI;
    private javax.swing.JLabel lblBGLeaderBoards;
    private javax.swing.JLabel lblBG_CS;
    private javax.swing.JLabel lblBG_Ending;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBagUI;
    private javax.swing.JLabel lblBattLog;
    private javax.swing.JLabel lblBattleFailed;
    private javax.swing.JLabel lblBattleFatal;
    private javax.swing.JLabel lblBattleFinished;
    private javax.swing.JLabel lblBattleStart;
    private javax.swing.JLabel lblBattleUI;
    private javax.swing.JLabel lblC3ECredits;
    private javax.swing.JLabel lblC3ESky;
    private javax.swing.JLabel lblC3EThrone1;
    private javax.swing.JLabel lblC3EThrone2;
    private javax.swing.JLabel lblC3EThrone3;
    private javax.swing.JLabel lblC3SBlackScreen;
    private javax.swing.JLabel lblC3SHall;
    private javax.swing.JLabel lblC3SStair;
    private javax.swing.JLabel lblC3SThrone;
    private javax.swing.JLabel lblChapter1E;
    private javax.swing.JLabel lblChapter1EBG;
    private javax.swing.JLabel lblChapter1Elevator;
    private javax.swing.JLabel lblChapter1HBG;
    private javax.swing.JLabel lblChapter2EBG;
    private javax.swing.JLabel lblChapter2Elevator;
    private javax.swing.JLabel lblChapter2Hallway;
    private javax.swing.JLabel lblChapter2Hallway1;
    private javax.swing.JLabel lblColumn1;
    private javax.swing.JLabel lblColumn2;
    private javax.swing.JLabel lblColumnL;
    private javax.swing.JLabel lblColumnR;
    private javax.swing.JLabel lblDialogueBox;
    private javax.swing.JLabel lblDialogueBox1;
    private javax.swing.JLabel lblDialogueBox2;
    private javax.swing.JLabel lblDialogueBox3;
    private javax.swing.JLabel lblDialogueBox4;
    private javax.swing.JLabel lblDialogueBox5;
    private javax.swing.JLabel lblDialogueBoxC3E;
    private javax.swing.JLabel lblEnemyAvatar_C1H;
    private javax.swing.JLabel lblEnemyAvatar_C2E;
    private javax.swing.JLabel lblEnemyAvatar_C2E1;
    private javax.swing.JLabel lblEnemyAvatar_C2E2;
    private javax.swing.JLabel lblEnemyAvatar_Intro;
    private javax.swing.JLabel lblEnemyBorder;
    private javax.swing.JLabel lblEnemy_C1H;
    private javax.swing.JLabel lblEnemy_C2E;
    private javax.swing.JLabel lblEnemy_C2E1;
    private javax.swing.JLabel lblEnemy_C2E2;
    private javax.swing.JLabel lblEnemy_Intro;
    private javax.swing.JLabel lblEnemy_dmg_C1H;
    private javax.swing.JLabel lblEnemy_dmg_Intro;
    private javax.swing.JLabel lblFamilliarC2E;
    private javax.swing.JLabel lblGoddessC3E;
    private javax.swing.JLabel lblHPBarE;
    private javax.swing.JLabel lblHPBarP;
    private javax.swing.JLabel lblIntro1;
    private javax.swing.JLabel lblIntro2;
    private javax.swing.JLabel lblIntro3;
    private javax.swing.JLabel lblIntro4;
    private javax.swing.JLabel lblIntro5;
    private javax.swing.JLabel lblIntro6;
    private javax.swing.JLabel lblIntro7;
    private javax.swing.JLabel lblIntroBG;
    private javax.swing.JLabel lblLB_UI;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblMPBar;
    private javax.swing.JLabel lblMage;
    private javax.swing.JLabel lblMage1;
    private javax.swing.JLabel lblMageAlterC2E;
    private javax.swing.JLabel lblMageAlterC2H;
    private javax.swing.JLabel lblMageAlterC3S;
    private javax.swing.JLabel lblMageAlterMarkC2E;
    private javax.swing.JLabel lblMageC1E;
    private javax.swing.JLabel lblMageC1H;
    private javax.swing.JLabel lblMageC2E;
    private javax.swing.JLabel lblMageC2H;
    private javax.swing.JLabel lblMageC3E;
    private javax.swing.JLabel lblMageC3S;
    private javax.swing.JLabel lblMonster;
    private javax.swing.JLabel lblMonsterC1E;
    public javax.swing.JLabel lblNameE;
    public javax.swing.JLabel lblNameP;
    private javax.swing.JLabel lblPlayerBorder;
    private javax.swing.JLabel lblShielder;
    private javax.swing.JLabel lblShielder1;
    private javax.swing.JLabel lblShielderAlterC2E;
    private javax.swing.JLabel lblShielderAlterC2H;
    private javax.swing.JLabel lblShielderAlterC3S;
    private javax.swing.JLabel lblShielderAlterMarkC2E;
    private javax.swing.JLabel lblShielderC1E;
    private javax.swing.JLabel lblShielderC1H;
    private javax.swing.JLabel lblShielderC2E;
    private javax.swing.JLabel lblShielderC2H;
    private javax.swing.JLabel lblShielderC3E;
    private javax.swing.JLabel lblShielderC3S;
    private javax.swing.JLabel lblSkill_A;
    private javax.swing.JLabel lblSkill_M;
    private javax.swing.JLabel lblSkill_S;
    private javax.swing.JLabel lblThrone;
    public javax.swing.JProgressBar pbEnemyHP;
    public javax.swing.JProgressBar pbPlayerHP;
    public javax.swing.JProgressBar pbPlayerMP;
    private javax.swing.JPanel pnlAttack;
    private javax.swing.JPanel pnlBag;
    private javax.swing.JPanel pnlBattle;
    private javax.swing.JPanel pnlChapter1Elevator;
    private javax.swing.JPanel pnlChapter1Hallway;
    private javax.swing.JPanel pnlChapter2Elevator;
    private javax.swing.JPanel pnlChapter2Hallway;
    private javax.swing.JPanel pnlChapter3Ending;
    private javax.swing.JPanel pnlChapter3Stair;
    private javax.swing.JPanel pnlCharacterSelection;
    private javax.swing.JPanel pnlEnding;
    private javax.swing.JPanel pnlIntro;
    private javax.swing.JPanel pnlLeaderBoards;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu1;
    private javax.swing.JPanel pnlName;
    private javax.swing.JPanel pnlScore;
    private javax.swing.JPanel pnlTLayout;
    private javax.swing.JTable tblScore;
    private javax.swing.JTextArea txtDialogue;
    private javax.swing.JTextArea txtDialogue1;
    private javax.swing.JTextArea txtDialogue2;
    private javax.swing.JTextArea txtDialogue3;
    private javax.swing.JTextArea txtDialogueC2H;
    private javax.swing.JTextArea txtDialogueC3E;
    private javax.swing.JTextArea txtDialogueC3S;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
