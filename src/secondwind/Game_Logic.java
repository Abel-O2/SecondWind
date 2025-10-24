package secondwind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game_Logic {
    private int Chara;
    private int Turns;
    private String playerName;
    private static final String HIGHSCORE_FILE = "highscores.txt";
    
    public void setTurns(int Turns){
        this.Turns=Turns;
    }

    public int getTurns(){
        return Turns;
    }
    
    public void displayTurns(){
        System.out.println("===============(Turn: "+getTurns()+")===============");
        //pnl(2);
    }
    
    public void setClass(int choice){
        Chara=choice;
    }

    public int getChara(){
        return Chara;
    }

    //Character Select
    public int CharSelect(){
        SecondWind_ SW = new SecondWind_();
        System.out.print("Choose a CEO: ");
        int choice= SW.getChara();
        switch (choice) {
            case 1:
                return 1;
            
            case 2:
                
                return 2;
            
            case 3:
                
                return 3;
        }
        return 0;
    }

    //Start Game
    public void Play(){
        int choice = CharSelect();
        setClass(choice);

        //Story objStory = new Story();
        //secondwind.Character hero = new Elon();
        switch (choice) {
            case 1:
                
                break;
            case 2:
                //hero = new Jeff();
                break;
            case 3:
                //hero = new Mark();
                break;
            default:
                break;
        }
        //objStory.introPart2();

        //Start of Game
        //Stages newStage = new Stages();
        SecondWind SW = new SecondWind();
        //Minion 1
        //hero.setEnergy(0);
        //objStory.stage1Part1();
        //SW.Stage1Part1(hero);
        //Minion 2
        /*if (hero.getHealth()>0){
            hero.setHP(100);
            newStage.Stage1Part2(hero);
        }
        else{
            gameOver();
            clearConsole();
        }
        //Minion 3
        if (hero.getHealth()>0){
            hero.setHP(100);
            newStage.Stage1Part3(hero);
        }
        else{
            gameOver();
            clearConsole();
        }
        hero.setHP(100);
        //General Part 1
        if (choice==1 && hero.getHealth()>0){
            newStage.Stage2PartMark(hero);
        }
        else if (choice==2 && hero.getHealth()>0){
            newStage.Stage2PartElon(hero);
        }
        else if (choice==3 && hero.getHealth()>0){
            newStage.Stage2PartElon(hero);
        }
        // Check if dead
        if (hero.getHealth()==0){
            gameOver();
            clearConsole();
        }
        else {
            clearConsole();
            //printL(y+"Your health went up by 50!\nYour mana replenished!"+res);
            clearConsole();
            hero.setHP(150);
            hero.setEnergy(100);
            //General Part 2
            if (choice==1 && hero.getHealth()>0){
                newStage.Stage2PartJeff(hero);
            }
            else if (choice==2 && hero.getHealth()>0){
                newStage.Stage2PartMark(hero);
            }
            else if (choice==3 && hero.getHealth()>0){
                newStage.Stage2PartJeff(hero);
            }
            //Check if dead
            if (hero.getHealth()==0){
                gameOver();
                clearConsole();
            }
            else {
                clearConsole();
                //printL(y+"Your health went up by 50!\nYour mana replenished!"+res);
                clearConsole();
                hero.setHP(200);
                hero.setEnergy(100);
                //Alien King Boss
                newStage.Stage3(hero);
                if (hero.getHealth()==0){
                gameOver();
                clearConsole();
                }
            }
        }*/
        setPlayerName();
        //Save Score
        String Name=getPlayerName();
        saveHighscore(Name,this.Turns);
    }

    //Name
    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\t\tEnter your name: ");
        String Name=scanner.nextLine();
        this.playerName=Name;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    //HighScore 
     public void saveHighscore(String playerName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(HIGHSCORE_FILE, true))) {
            writer.println(playerName + "," + score);
        } catch (IOException e) {
            System.err.println("Error writing to the highscore file: " + e.getMessage());
        }
    }

    public void displayHighscores() {
        System.out.println("Highscores:");

        try (Scanner scanner = new Scanner(new File(HIGHSCORE_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String pName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    System.out.println(pName + ": " + score);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Highscore file not found: " + e.getMessage());
        }
    }
}
