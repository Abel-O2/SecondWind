/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package secondwind;

/**
 *
 * @author Samuel
 */
public class Story extends GameLogic{
    //static Scanner sc=new Scanner(System.in);
    
    //Java Text Colors:
    /*
    Blue: \u001B[34m

    Cyan: \u001B[36m

    Red: \u001B[31m

    Green: \u001B[32m

    White: \u001B[37m

    Yellow: \u001B[33m

    Black: \u001B[30m

    Magenta: \u001B[35m
    */
    public void Menu(){
        String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow
        System.out.println(y+"==========================================================================="+res);
        System.out.println(g+"\t ____      _                                  _           _ "+res);
        System.out.println(g+"\t|  _ \\ ___(_)_ __   ___ __ _ _ __ _ __   __ _| |_ ___  __| |"+res);
        System.out.println(g+"\t| |_) / _ \\ | '_ \\ / __/ _` | '__| '_ \\ / _` | __/ _ \\/ _` |"+res);
        System.out.println(g+"\t|  _ <  __/ | | | | (_| (_| | |  | | | | (_| | ||  __/ (_| |"+res);
        System.out.println(g+"\t|_| \\_\\___|_|_| |_|\\___\\__,_|_|  |_| |_|\\__,_|\\__\\___|\\__,_|"+res);
        System.out.println(g+"\t          __ _ ___       __ _       ___ ___  ___            "+res);
        System.out.println(g+"\t         / _` / __|     / _` |     / __/ _ \\/ _ \\           "+res);
        System.out.println(g+"\t        | (_| \\__ \\    | (_| |    | (_|  __/ (_) |          "+res);
        System.out.println(g+"\t         \\__,_|___/     \\__,_|     \\___\\___|\\___/           "+res);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(b+"\t\t\t     1. Play"+res);
        System.out.println(b+"\t\t\t     2. HighScore"+res);
        System.out.println(b+"\t\t\t     3. Exit"+res);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print(g+"\t\t\t     Enter Choice: "+res);
    }
    public void Intro()throws InterruptedException{
        System.out.println("------------------------------------------------------------------------");
        printL("Opening door 42-0...");
        Thread.sleep(200);
        pnl(2);
        clearConsole();
        printL("Scanning Data base...");
        Thread.sleep(200);
        pnl(2);
        clearConsole();
        printL("Recovering memory...");
        Thread.sleep(200);
        pnl(2);
        clearConsole();
        printL("Opening video file [Before the Invasion]...");
        enterContinue();
        clearConsole();
        printL("In the year 20XX, when the aliens invaded Earth, chaos reigned supreme.");
        Thread.sleep(200);
        pnl(2);
        printL("...");
        pnl(2);
        clearConsole();
        printL("Three tech CEOs, Elon, Mark, and Jeff, unwillingly found themselves at\n the forefront of humanity's defense against the extraterrestrial menace.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("The alien king, a formidable foe, led an army of minions, and \nthe situation grew dire.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("Despite their technological prowess, the CEOs realized they \nwere severely outmatched.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("Faced with the impending doom, the trio took a desperate gamble.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("With a unified decision, they called upon the Techno Goddess, \na mysterious entity rumored to possess the power to turn the tide against \nthe alien invaders.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("The Techno Goddess appeared before them in a shimmering \nholographic form, her eyes glowing with a celestial intensity.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("\"I can only save one of you,\" she intoned, her voice echoing \nthrough the desolate battlefield.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("The CEOs exchanged glances, understanding the gravity of the choice \nbefore them. The fate of Earth rested on the shoulders of the chosen hero.");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("After a moment of tense deliberation, the CEOs made their decision. ");
        pnl(2);
        Thread.sleep(200);
        printL("...");
        pnl(2);
        clearConsole();
        printL("The Techno Goddess raised her hand, and a blinding light \nenveloped the chosen one—");
        System.out.println();
        System.out.println();
        printL("\t1. Elon\n");
        printL("\t2. Jeff\n");
        printL("\t3. Mark\n");
    }
    public void introPart2()throws InterruptedException{
        printL("...");
        pnl(2);
        clearConsole();
        printL("However, the sacrifice was immense. Mark and Jeff, despite their \nbrilliance, fell in battle and were subsequently captured by the alien forces.\n");
        Thread.sleep(200);
        clearConsole();
        printL("The Alien King has made the Twin Towers, the pinnacle of human architecture, its lair.\n");
        printL("As the newly reincarnated CEO you set out on a venture to save your comrades and the world.\n");
        Thread.sleep(200);
    }
    public void stage1Part1()throws InterruptedException{
        clearConsole();
        printL("You reached the gates of the Twin Towers\n");
        printL("Once a majestic palace, now a crumbling visage of what it once was.\n");
        printL("You encountered an enemy!\n");
    }
    public void itemDropDialogue()throws InterruptedException{
        printL("Upon defeating the (Enemy name)"+"You saw it left an artifact as it turned to ash.\n");
        //if player has item already
        printL("Will you discard your current item for this item?\n");
        //else if the player doesnt have item
        printL("Are you gonna equip the item?\n");
    }
    
    public void stage1Part2()throws InterruptedException{
        printL("You reached the hallway of the building. It is littered with dead bodies.\n");
        printL("in the middle is another alien\n");
        printL("You decided to engaged it!\n");
    }
    
    public void stage1Part3()throws InterruptedException{
        printL("To reach the top fast, you decided to use the elevator. But there is an alien guarding the path\n");
        printL("You spent minutes looking for other ways to pass, but there were none.\n");
        printL("Swallowing your fear, you decided to face it head on!\n");
    }
    
    public void elevatorScene()throws InterruptedException{
        System.out.println("You stepped in the elevator\n");
        System.out.println("As you waited for the elevator to reach the top. The memories of" + "(CEO NAME)" + "flashed back");
        System.out.println("\nA beautiful lake with glistening water and three youthful, muscular men enjoying the time of their lives\n");
        System.out.println("Tears rolled down your eyes.\n");
        System.out.println("'These aren't even my memories', you said. 'Why is this making me cry'\n");
        System.out.println("A sudden noise interrupts your reminiscing, followed by the sensation of the floor leaving your foot behind\n");
        System.out.println("'The elevator is falling apart. I need to get out of here'\n");
        System.out.println("You jumped out of the moving elevator into a floor just levels before the top floor\n");
        System.out.println("You lay there exhausted and tired. but you understood the responsibility the goddess has given you.\n");
        System.out.println("So you willed yourself to rise\n");
        System.out.println("As you raise your head, a familiar visage stood before you\n");
        System.out.println("M-Ma-Masaka... It can't be... Why are you here\n");
    }
    
    public void stage2Part1 () throws InterruptedException{
        System.out.println("It was your nakama (tl note:ally), but there is something different about him.\n");
        System.out.println("Something sinister.\n");
        System.out.println("'Elon... is that you? It's me! Mark.' You said.\n");
        System.out.println("But Elon was only fixated on attacking you.\n");
        printL("You dodged the barrage of attacks unleashed by your past friend.\n");
        printL("It was then you noticed. The mark of the alien king on his neck.\n");
        printL("You realized your friend is gone.\n");
        printL("What appears before you is nothing but a puppet, a shell of your friend, being puppetered by the evil alien king. \n");
        printL("So you engaged him.\n");  
    }
    public void stage2Part2 () throws InterruptedException{
        printL("As your once ally laid there, another figure stepped in the shadow.\n");
        printL("It was jeff. The once greatest magician now branded with the alien kings seal.\n");
        printL("You readied yourself, but then something unexpected happened.\n");
        printL("He spoke.\n");
        printL("Struggling, yes, but you can still make out the words.\n");
        printL("'Mark...kill...me'. Your friend, even though under the spell of the alien king, kept on fighting all these years.\n");
        printL("'I...can't..stop..it...anymore'\n");
        printL("His withered soul pleaded for death.\n");
        printL("Though it pains you, you granted your friends wish.\n");
    }
    
    
    public void stage2End () throws InterruptedException{
        printL("As your friend was laying on the floor, you immediately approached him.\n");
        printL("'Damn...Mark'\n");
        printL("'I didn't even think...you would actually...reach here' Jeff jokingly said.\n");
        printL("'Stop talking, i can still save up you' You said as you were scrambling for healing potions.\n");
        printL("'Nah, keep it... you will need it.. for the final fight'\n");
        printL("'Jeff's breath comes slower and slower as each minute passes.\n");
        printL("'You know what... Its the memories of us three... being together that made my mind...  resist the alien kings mind control'\n");
        printL("Tears starts falling down your eyes, a melancholic smile forms on his face\n");
        printL("'Go on friend... make us proud...the rest is in your hands'\n");
        printL("You held your dear friend in your arms as he draws his final breath.\n\n");
        printL("An immense hatred was boiling deep inside you about to spill out.\n\n");
        printL("'You will pay for this Alien King, i swear i will make you pay'\n");
    }
        public void stage3Intro () throws InterruptedException{
        printL("You came across a stair littered with bodies that leads to the top floor.\n");
        printL("'I'm coming for you'\n");
        printL("With every step you take, the feeling of dread increases; though as if you going straight to impending doom.\n");
        printL("You reached the door of the Alien Kings lair.\n");
        printL("A mix of fear and anger fills you inside. The primal urge to run away is screaming inside your body\n");
        printL("But your determination is stronger\n");
        printL("Your pushed through that door with your might. The cold feel of heavy metal against the heat of your raging body.\n");
        printL("It opened at last.\n");
        printL("Upon you is a throne room, and a seemingly familliar figure is sitting in the middle.\n");
        printL("'I never thought i'd see you again' the man in the throne said.\n");
        printL("'I guess you really liked me that much huh?' You said mockingly.\n");
        printL("'You know Mark, i have great respect for you. Ever since that fight we had years ago you have left a very impressived mark on me.'\n");
        printL("'Not many of your kind can do that.'\n");
        printL("The figure stood up from the throne and walked into the light.\n");
        printL("It confirmed your suspicion.\n");
        printL("'So much so that i took on your form.'\n");
        printL("'You son of a bitch'\n");
        printL("'I have observed your kind for millenias now.'\n");
        printL("Savages.\n");
        printL("Brutes who lavish on murdering one another\n");
        printL("Hindering each other towards a better future\n");
        printL("'But i am a fair being you see.'\n");
        printL("I recognize the strong, the soecial'\n");
        printL("'Join me (ceo name).'");
        printL("\nLet's wipe the planet clean and start a world free from pain.\n");
        printL("Bullshit\n");
        printL("You just want to justify your massacres.\n");
        printL("");
        printL("");
        printL("");
        
    }
    public void stage3Ending () throws InterruptedException{
        printL("Everything is over, the alien king is gone");
    }
    
}