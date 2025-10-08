/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package secondwind;

/**
 *
 * @author Samuel
 */
public class SecondWind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
        GameLogic objGL = new GameLogic();
        Story objStory = new Story();
        Stages objStage = new Stages();
        int opt=0;

        while (opt!=3){
            objGL.clearConsole();
            objStory.Menu();
            opt=objGL.getUserInput();

            if (opt==1){
                objGL.clearConsole();
                //objStory.Intro();
                objGL.Play();        
            }
            else if (opt==2){
                objGL.clearConsole();
                objStage.displayHighscores();
                objGL.enterContinue();
            }
        }
    }
    
}
