package secondwind;

import java.util.*;

public class Stages extends GameLogic{
    Random random;
    SecondWind_ SW;
    Minion minion;
    GameLogic objGL;
    int currentTurns = super.getTurns();
    //Colors
    String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
    
    //STAGE 1 PART 1
    public void Stage1Part1(Character hero) throws InterruptedException{
        super.setTurns(1);
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        Minion minion = new Minion("Google",50);
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.EncounterArt();
        printL(y+"Battle against Minion starts!"+res);
        pnl(2);
        clearConsole();

        int action;
        boolean hasDefended=false;
        SW.pbPlayerHP.setMaximum(hero.getHealth());
        while (hero.isAlive() && minion.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+minion.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+minion.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            SW.pbPlayerHP.setValue(hero.getHealth());
            SW.pbPlayerMP.setValue(hero.getEnergy());
            SW.lblNameP.setText(hero.getName());
            SW.lblNameP.repaint();
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemy(minion);
                        pnl(1);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skill(minion);
                        break;
            }
            if (minion.isAlive() && hasDefended==false) {
                minion.attackHero(hero);
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + minion.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + minion.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    //STAGE 1 PART 2
    public void Stage1Part2(Character hero) throws InterruptedException{
        super.setTurns(1);
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        Minion minion = new Minion("Facebook",75);
        clearConsole();
        objGL = new GameLogic();
        objGL.EncounterArt();
        printL(y+"Battle against Minion starts!"+res);
        pnl(2);
        clearConsole();

        int action;
        boolean hasDefended=false;
        while (hero.isAlive() && minion.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+minion.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+minion.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemy(minion);
                        pnl(1);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skill(minion);
                        break;
            }
            if (minion.isAlive() && hasDefended==false) {
                minion.attackHero(hero);
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + minion.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + minion.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    //STAGE 1 PART 3
    public void Stage1Part3(Character hero) throws InterruptedException{
        super.setTurns(1);
        //Scanner me = new Scanner(System.in);
        SW = new SecondWind_();
        minion = new Minion("Amazon",100);
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.EncounterArt();
        printL(y+"Battle against Minion starts!"+res);
        pnl(2);
        clearConsole();

        int action;
        boolean hasDefended=false;
        while (hero.isAlive() && minion.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+minion.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+minion.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemy(minion);
                        pnl(1);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skill(minion);
                        break;
            }
            if (minion.isAlive() && hasDefended==false) {
                minion.attackHero(hero);
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + minion.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + minion.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    public void Stage2PartJeff(Character hero) throws InterruptedException{
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        boolean jeffDef=false;
        boolean hasDefended=false;
        Enemy general= new enemyShielder();
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.EncounterArt();
        printL("Battle against "+general.getName()+" starts!");
        pnl(2);
        clearConsole();

        int action;
        int SP=1;
        while (hero.isAlive() && general.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+general.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+general.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: if (jeffDef==false){
                            hero.attackEnemyG(general);
                        }
                        else{
                            printL(y+"Jeff's Drone Shield is active, blocking the attack!\n"+res);
                            jeffDef=false;
                        }
                        pnl(1);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skillG(general);
                        break;
            }
            if (general.isAlive() && hasDefended==false) {
                SP++;
                if (SP%3==0){
                    general.skill(hero);
                    jeffDef=true; 
                }
                else {
                    general.attackHero(hero);
                }
            }  
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + general.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + general.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    
    public void Stage2PartMark(Character hero) throws InterruptedException{
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        enemyMage general= new enemyMage();
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.EncounterArt();
        printL("Battle against "+general.getName()+" starts!");
        pnl(2);
        clearConsole();

        int action;
        int SP=1;
        boolean hasDefended=false;
        while (hero.isAlive() && general.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+general.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+general.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemyG(general);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skillG(general);
                        break;
                default: break;
            }
            if (general.isAlive()){
                SP++;
                if (SP%6==0 && hasDefended==false){
                    general.skill(hero);
                }
                else if (hasDefended==false){
                    general.attackHero(hero);
                }
                else if (SP%6==0 && hasDefended==true){
                    general.skillDef(hero);
                }
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + general.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + general.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    
    public void Stage2PartElon(Character hero) throws InterruptedException{
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        enemyAssassin general= new enemyAssassin();
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.EncounterArt();
        printL("Battle against "+general.getName()+" starts!");
        pnl(2);
        clearConsole();

        int action;
        int SP=1;
        boolean hasDefended=false;
        //random = new Random();
        while (hero.isAlive() && general.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+general.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+general.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemyG(general);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skillG(general);
                        break;
            }
            if (general.isAlive()){
                SP++;
                if (SP%5==0 && hasDefended==false){
                    general.skill(hero);
                }
                else if (hasDefended==false){
                    general.attackHero(hero);
                }
                else if (SP%5==0 && hasDefended==true){
                    general.skillDef(hero);
                }
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + general.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + general.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
    
    public void Stage3(Character hero) throws InterruptedException{
        //Scanner me = new Scanner(System.in);
        SecondWind_ SW = new SecondWind_();
        alterBoss alienKing= new alterBoss();
        clearConsole();
        GameLogic objGL = new GameLogic();
        objGL.AlienKingSymbol();
        printL("The grand battle for humanity against "+alienKing.getName()+" begins!");
        pnl(2);
        clearConsole();
        printL(y+"============================================\n"+res);
        printL(r+"\"I AM THE ALPHA AND THE OMEGA.\"\n"+res);
        printL(y+"============================================\n"+res);
        clearConsole();
        int action;
        int SP=1;
        boolean hasDefended=false;
        //random = new Random();
        while (hero.isAlive() && alienKing.isAlive()) {
            displayTurns();
            printL(hero.getName()+y+ "\t\t vs \t\t" +res+alienKing.getName()+" "+hero.getName());
            pnl(1);
            printL(g+"HP: "+hero.getHealth()+res+"\t\t\t\t"+r+"HP: "+alienKing.getHealth()+res);
            pnl(1);
            printL(b+"MP: "+hero.getEnergy()+res);
            pnl(3);
            System.out.println("Choose Action: \n"+b+"1- Normal attack[10~20DMG & Regain 20MP] \n"+res+g+"2- Defend[Regain 10MP] \n"+res+y+"3- Special Attack [Needs 100MP]"+res);
            action = SW.getAction();
            switch (action){
                case 1: hero.attackEnemyG(alienKing);                        
                        break;
                case 2: hero.defend();
                        hasDefended=true;
                        break;
                case 3: hero.skillG(alienKing);
                        break;
            }
            if (alienKing.isAlive()){
                SP++;
                if (SP%8==0 && hasDefended==false){
                    alienKing.skill(hero);
                }
                else if (hasDefended==false){
                    alienKing.attackHero(hero);
                }
                else if (SP%8==0 && hasDefended==true){
                    alienKing.skillDef(hero);
                }
            }
            hasDefended=false;
            Thread.sleep(5000);
            //Global Turns Counter
            currentTurns++;
            super.setTurns(currentTurns);
            clearConsole();
        }

        if (hero.isAlive()) {
            clearConsole();
            System.out.println(y+hero.getName() + " defeated " + alienKing.getName() + "!"+res);
            Thread.sleep(5000);
        } else {
            clearConsole();
            System.out.println(y+hero.getName() + " was defeated by " + alienKing.getName() + "."+res);
            Thread.sleep(5000);
        }
    }
}
