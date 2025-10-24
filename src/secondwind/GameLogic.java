package secondwind;

import java.util.*;
import java.io.*;

public class GameLogic {
    static Scanner sc=new Scanner(System.in);
    private int Chara;
    private int Turns;
    private String playerName;
    private static final String HIGHSCORE_FILE = "highscores.txt";
    
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(g+"-> "+res);
                userInput = scanner.nextInt();

                if (userInput < 1 || userInput > 3) {
                    System.out.println(g+"Invalid choice. Please enter 1, 2, or 3."+res);
                } else {
                    isValidInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(g+"Invalid choice. Please enter a valid choice."+res);
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        return userInput;
    }
    
    //Colors
    String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
    
    public void setTurns(int Turns){
        this.Turns=Turns;
    }

    public int getTurns(){
        return Turns;
    }
    
    //Monitor Turns/Score
    /*public void Turns(){
        int current;
        current=getTurns()+1;
        setTurns(current);
    }*/
    public void displayTurns(){
        System.out.println(y+"===============(Turn: "+getTurns()+")==============="+res);
        pnl(2);
    }
    
    public void setClass(int choice){
        Chara=choice;
    }

    public int getChara(){
        return Chara;
    }

    //Get user input with exception handling
    /*public int readInt(String prompt, int opt){
        int choice;

        do{
            System.out.println(prompt);
            try{
                choice=Integer.parseInt(sc.next());
            }catch(Exception e){
                choice = -1;
                System.out.println(y+"Please input an integer!"+res);
            }
        }while(choice == 1 || choice > opt);
        return choice;
    }*/
    //Clear console
    public void clearConsole(){
        System.out.print("\033c");
    }
    //Separator lines
    public void printSeparator(){
        for(int i=0;i<73;i++){
            System.out.print("=");
        }
        System.out.println();
    }
    //Enter to continue
    public void enterContinue()throws InterruptedException{
        Thread.sleep(80);
        pnl(5);
        printL(g+"Press Enter to continue..."+res);
        sc.nextLine();
    }

    //Print new lines
    public void pnl(int n){
        for (int i=0;i<n;i++){
            System.out.println();
        }
    }

    //Print lines
    public void printL(String line)throws InterruptedException{
        for (int i=0;i<line.length();i++){
            System.out.print(line.charAt(i));
            Thread.sleep(50);
        }
    }

    //Character Select
    public int CharSelect()throws InterruptedException{
        System.out.print(g+"Choose a CEO: "+res);
        int choice=getUserInput();
        clearConsole();
        switch (choice) {
            case 1:
                printL("...");
                pnl(2);
                printL(y+"Elon Musk, soon will be imbued with newfound strength and advanced technology, \nwill stand as the last hope for humanity."+res);
                
                return 1;
            
            case 2:
                printL("...");
                pnl(2);
                printL(y+"Jeff Bezos, soon will be imbued with newfound strength and advanced technology, \nwill stand as the last hope for humanity."+res);
                pnl(2);
                
                return 2;
            
            case 3:
                printL("...");
                pnl(2);
                printL(y+"Mark Zuckerburg, soon will be imbued with newfound strength and advanced technology, \nwill stand as the last hope for humanity."+res);
                
                return 3;
            
            default:
                System.out.println("...");
                pnl(2);
                printL(r+"None of them was chosen..."+res);
                clearConsole();
                printL(r+"Game Over!"+res);
                clearConsole();
            
        }
        return 0;
    }

    //Start Game
    public void Play()throws InterruptedException{
        int choice = CharSelect();
        setClass(choice);

        /*Story objStory = new Story();
        Character hero = new Elon();
        switch (choice) {
            case 1:
                hero = new Elon();
                break;
            case 2:
                hero = new Jeff();
                break;
            case 3:
                hero = new Mark();
                break;
            default:
                break;
        }
        objStory.introPart2();

        //Start of Game
        Stages newStage = new Stages();
        //Minion 1
        hero.setEnergy(0);
        objStory.stage1Part1();
        newStage.Stage1Part1(hero);
        //Minion 2
        if (hero.getHealth()>0){
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
            printL(y+"Your health went up by 50!\nYour mana replenished!"+res);
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
                printL(y+"Your health went up by 50!\nYour mana replenished!"+res);
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
        }
        setPlayerName();
        //Save Score
        String Name=getPlayerName();
        saveHighscore(Name,this.Turns);*/
    }
    
    public void gameOver () throws InterruptedException{
        printL(r+"The fate of humanity is sealed. Bad End..."+res);
        enterContinue();
    }
    //Name
    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(g+"\t\tEnter your name: "+res);
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
    
    //ASCII Art
    public void EncounterArt(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(g+"\t      &&&&&&&&&(                                               &&&&&&&&&&      "+res);
        System.out.println(g+"\t      &&&....../&&@                                         /&&.......&&&      "+res);
        System.out.println(g+"\t      &&&,,,.......&&&                                   &&&..........&&&      "+res);
        System.out.println(g+"\t      &&&///..........&&&                             &&&.........,//*&&&      "+res);
        System.out.println(g+"\t         &&////*.........&&&                       &&&.........///*&&&         "+res);
        System.out.println(g+"\t         &&&///*.........&&&                      .%%%.........///(&&&         "+res);
        System.out.println(g+"\t            &&&%//*.........&&&*               %&&&.........///&&&%            "+res);
        System.out.println(g+"\t               *&&&/**.........#&&&         &&&,.........*//&&&                "+res);
        System.out.println(g+"\t                   &&&///..........&&&   &&&..........///&&&                   "+res);
        System.out.println(g+"\t                      &&&///..........&&&&&&.......///&&&                      "+res);
        System.out.println(g+"\t                         &&&*/,,.........&&&&&&/,*/&&&                         "+res);
        System.out.println(g+"\t                         &&&///,.........&&&&&&(///&&&                         "+res);
        System.out.println(g+"\t                            @&&#//*.........&&&&&&&                            "+res);
        System.out.println(g+"\t                            @&&&&&&/,* . . ....%&&&                            "+res);
        System.out.println(g+"\t                         &&&.......&&&///. ........&&&                         "+res);
        System.out.println(g+"\t      &&&&&&          &&&..........///&&&*//..........&&&         ,&&&&&&      "+res);
        System.out.println(g+"\t   &&&//////&&&(   &&&.........*///&&&   &&&*//,.........&&&   &&&&//////&&&   "+res);
        System.out.println(g+"\t   &&&//////&@@(   @@@.........,***@@@   @@@***,.........@@@   &@@&//////&&&   "+res);
        System.out.println(g+"\t   &&&&&&//////#&&@.........///#&&&         &&&///*.........&&&(//////&&&&&&   "+res);
        System.out.println(g+"\t      &&&&&&///////&&&...///&&&*               %&&&///...&&&//////(&&&&&&      "+res);
        System.out.println(g+"\t         &&&&&&%//////&&&&&&&&&*               %&&&&&&/%//,*,//&&&&&&&         "+res);
        System.out.println(g+"\t         &&&///#&&&//////&&&                       &&&//////&&&///(&&&         "+res);
        System.out.println(g+"\t      &&&//////#&&&&&&//////&&&*               %&&&//////&&&&&&(//////&&&      "+res);
        System.out.println(g+"\t      @@&//,///#&&&&&&//////@@(*               %%&&//////&&&&&&///////@@@      "+res);
        System.out.println(g+"\t   &&&//////&&&&&&&&&&&&&//////%&&&            %&&&///&&&&&&&&&&&&&//////&&&   "+res);
        System.out.println(g+"\t&&&//////&&&&&&(      &&&&&&&&&*               %&&&&&&&&&      &&&&&&&//////&&&"+res);
        System.out.println(g+"\t&&%///&&&&&&             &&&                       &&&            ,&&&&&&////&&"+res);
        System.out.println(g+"\t   &&&&&&                                                             &&&&&&   "+res);
        pnl(2);
    }
    public void ElonSkill(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(g+"\t                                      .&&&                                      "+res);
        System.out.println(g+"\t                                    @,   ,*&#                                   "+res);
        System.out.println(g+"\t                                   @     .,*(&                                  "+res);
        System.out.println(g+"\t                                 @        ..,*/&                                "+res);
        System.out.println(g+"\t                               /@           .,*/&                               "+res);
        System.out.println(g+"\t                              @#**/(((/////(((###&*                             "+res);
        System.out.println(g+"\t                              @/             ..,/&*                             "+res);
        System.out.println(g+"\t                              @/   *%(/((#(%#*,,*&*                             "+res);
        System.out.println(g+"\t                              @/  &/&/*  ./%%#@,*&*                             "+res);
        System.out.println(g+"\t                              @/  &(@*...,,&&#&**&*                             "+res);
        System.out.println(g+"\t                              @/   @/(/@@@(#%@.**&*                             "+res);
        System.out.println(g+"\t                              @/     #@&&&&. ..**&*                             "+res);
        System.out.println(g+"\t                              @&@@          ..*&&&*                             "+res);
        System.out.println(g+"\t                              @#((////((/(//((###@*                             "+res);
        System.out.println(g+"\t                            &/(%@@&&@&&///@@@@@@&(((@                           "+res);
        System.out.println(g+"\t                         *@//(/%@   .#&/(/&. ,,/&(/(##&                         "+res);
        System.out.println(g+"\t                       @//////#%&,.,,%&///&,.**(%((//###&#                      "+res);
        System.out.println(g+"\t                       @//////(##&,@/%&/((@(#&*%((///(##&#                      "+res);
        System.out.println(g+"\t                       @/////(#%@  @,%&(((@*(&  &(///(##&#                      "+res);
        System.out.println(g+"\t                        &%///(#%@ &*,..@(@ ,*/& &(/((##@                        "+res);
        System.out.println(g+"\t                        &%//##@/  &*,..@#& ,**&  &#((#%@                        "+res);
        System.out.println(g+"\t                         *@/(#@/  &*,..@#& ,**&  &####&                         "+res);
        System.out.println(g+"\t                           @(#@/   @***&#@,*(&   &%##&                          "+res);
        System.out.println(g+"\t                           @@@@/    @(/@@@*&#    @@@@@                          "+res);
        System.out.println(g+"\t                                     #&***@.                                    "+res);
        System.out.println(g+"\t                                       @*&                                      "+res);
        System.out.println(g+"\t                                        /                                       "+res);
        pnl(2);
    }
    public void JeffSkill(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(g+"\t                                       ...                                      "+res);
        System.out.println(g+"\t                                     @(,.,(%                                    "+res);
        System.out.println(g+"\t                                  @@.//(((/*.@@                                 "+res);
        System.out.println(g+"\t                            (@@&..////@%**&////.,@@@.                           "+res);
        System.out.println(g+"\t             @#########%////(((((%%%%##(,  .//%%(/((*****#########%%            "+res);
        System.out.println(g+"\t             @#*,,(/////(@@@@&####%(((((,     .....%@@@&(/////(,,*#%            "+res);
        System.out.println(g+"\t             @(//(@###########((((((((((,          ...........&///(%            "+res);
        System.out.println(g+"\t             @(//(@#((((((((((((((((((((,                    .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#((((((((((((((((((((,                    .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#((((((((((((((((((((,.                   .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#(((((((((((((**@@@@@@@@@@@**             .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#((((((((((*%@@@@@@@@@@@@@@@@@/*          .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#((((((((*(@@@@@@************@@@**        .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#(((((((*%@@@@@@@@*@@@@@@@@*&@@@@*/       .&///(%            "+res);
        System.out.println(g+"\t             @(//(@#(((((((*@@@@@@@@@*/@@@@@@&*@@@@@@*       .&///(%            "+res);
        System.out.println(g+"\t             @(//(@,...... *@@@@@@@@@@*********@@@@@@*/**////(@///(%            "+res);
        System.out.println(g+"\t             @(//(@,.......*/@@@@@@@@@@********@@@@@*#///////(@///(%            "+res);
        System.out.println(g+"\t             @(//(@,........//@@@@@@@@@*&*@@**/@@@@*((///////(@///(%            "+res);
        System.out.println(g+"\t              %#//(@..........*/@@@@@@@@@@@@@@@@@**(////////(@(//#(             "+res);
        System.out.println(g+"\t              %#///@,............**&@@@@@@@@@#**////////////(@///#(             "+res);
        System.out.println(g+"\t               (%//(@,................../#((//(////////////#@(//&(              "+res);
        System.out.println(g+"\t                /&,,(@,.................*(///////////////((@(,,&.               "+res);
        System.out.println(g+"\t                 ,@////&,,..............*(////////////(((&////@.                "+res);
        System.out.println(g+"\t                    @/*/(@*,............*(//////////((#&//,/@                   "+res);
        System.out.println(g+"\t                      @/*/(&/,,.........*(////////(#&%(*,*@                     "+res);
        System.out.println(g+"\t                        *%/*//#(,.......*(/////((%#/**/#*                       "+res);
        System.out.println(g+"\t                           (#/*/(@@,,...*(/(#(@@//,/&#                          "+res);
        System.out.println(g+"\t                             *@/////((&@@@&(/(*///&.                            "+res);
        System.out.println(g+"\t                                ((#%#/(**/(/###((                               "+res);
        pnl(2);
    }
    public void MarkSkill(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(g+"\t"+res);
    }
    public void AlienKingSkill(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(g+"\t"+res);
    }
    public void AlienKingSymbol(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        clearConsole();
        System.out.println(b+"\t                                 *#&&&&&&&&&@&(.                                "+res);
        System.out.println(b+"\t                            .%&&&&&&&&&&&&&&&&&&&&&(                            "+res);
        System.out.println(b+"\t                          %&&&&&&&&&&&&&&&&&&&&&&&&&&&*                         "+res);
        System.out.println(b+"\t                        %&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&,                       "+res);
        System.out.println(b+"\t                       &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&(                      "+res);
        System.out.println(b+"\t                      &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&(                     "+res);
        System.out.println(b+"\t                     #&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&.                    "+res);
        System.out.println(b+"\t                     &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#                    "+res);
        System.out.println(b+"\t                    *&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&                    "+res);
        System.out.println(b+"\t                    #&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&                    "+res);
        System.out.println(b+"\t                    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&                    "+res);
        System.out.println(b+"\t                    #&&(&&&&&&&&&&&&&&&&&&&&&&&&&&&&%&&&%#&&                    "+res);
        System.out.println(b+"\t                    .&&.    (&&&&&&&&&&&&&&&&&&&&&&&,    (&&                    "+res);
        System.out.println(b+"\t                     %&#       (&&&&&&&&&&&&&&&&&,       &&,                    "+res);
        System.out.println(b+"\t                      &&&        *&&&&&&&&&&&&%        ,&&(                     "+res);
        System.out.println(b+"\t                       %&&%.       (&&&&&&&&&.       *&&&(                      "+res);
        System.out.println(b+"\t                        (&&&&&%*.    &&&&&&(    .(&&@&&&                        "+res);
        System.out.println(b+"\t                         .&&&&&&&&&&&&&&&&&&&&&&&&&&&&(                         "+res);
        System.out.println(b+"\t                           *&&&&&&&&&&&&&&&&&&&&&&&&&                           "+res);
        System.out.println(b+"\t                             #&&&&&&&&&&&&&&&&&&&&&.                            "+res);
        System.out.println(b+"\t                               #&&&&&&&&&&&&&&&&&,                              "+res);
        System.out.println(b+"\t                                 /&&&&&&&&&&&&%.                                "+res);
        System.out.println(b+"\t                                     (&&&&&,                                    "+res);
        pnl(2);
    }
}
