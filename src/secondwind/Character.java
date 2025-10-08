/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package secondwind;

/**
 *
 * @author Samuel
 */
import java.util.*;
public abstract class Character extends GameLogic{
    private int HP;
    private int Energy;
    Random random;
    //Colors
    String res = "\u001B[0m"; //Reset
        String r = "\u001B[31m"; //Red
        String g = "\u001B[32m"; //Green
        String b = "\u001B[34m"; //Blue
        String y = "\u001B[33m"; //Yellow

    public Character(int HP, int Energy) {
        //this.name = name;
        this.HP = HP;
        this.Energy = Energy;
        this.random = new Random();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int Energy) {
        if (Energy>100)
            this.Energy=100;
        else
            this.Energy = Energy;
    }

    public abstract void defend();

    public abstract void attackEnemy(Minion minion);
    public abstract void attackEnemyG(Enemy general);

    public abstract void skill(Minion minion)throws InterruptedException;
    public abstract void skillG(Enemy general)throws InterruptedException;

    public abstract void takeDamage(int damage);

    public abstract String getName();

    public boolean isAlive() {
        return HP > 0;
    }
    int getHealth() {
        return HP;
    }
}

class Elon extends Character{
    private final String name = "Elon";

    //Elon Stats

    public Elon() {
        super(100, 100);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attackEnemy(Minion minion){
        int health=getHealth();
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        minion.takeDamage(damage);
        energy += 20;
        setEnergy(energy);
        health+=damage/2;
        setHP(health);
        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        System.out.println(g+name + " steals "+(damage/2)+" HP"+res);
    }
    @Override
    public void attackEnemyG(Enemy general){
        int health=getHealth();
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        general.takeDamage(damage);
        energy += 20;
        setEnergy(energy);
        health+=damage/2;
        setHP(health);
        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        System.out.println(g+name + " steals "+(damage/2)+" HP"+res);
    }
    @Override
    public void defend(){
        int energy=getEnergy();
        boolean successfulDefense = random.nextDouble() < 0.95;
        if (successfulDefense) {
            energy += 10;
            setEnergy(energy);
            System.out.println(g+name + " successfully defends against the attack!"+res);
        } else {
            int damageTaken = random.nextInt(10) + 1;
            takeDamage(damageTaken);
            energy += 10;
            setEnergy(energy);
            System.out.println(r+name + " fails to defend against the attack and takes " + damageTaken + " damage!"+res);
        }
    }
    @Override
    public void skill(Minion minion) throws InterruptedException{
        int damage = random.nextInt(50);
        int skill= 30+(damage*2);
        if (getEnergy() == 100) {
            System.out.println(y+name + " uses a special skill!"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Behold an orbital nightmare, SpaceEX!\"\n"+res);
            System.out.print(y+"============================================\n"+res);
            printL(g+"Elon dealt "+damage+" damage!"+res);
            System.out.println();
            minion.takeDamage(skill);
            setEnergy(0);
        } else {
            System.out.println(r+name + " doesn't have enough energy to use the skill."+res);
        }
    }
    @Override
    public void skillG(Enemy general) throws InterruptedException{
        int damage = random.nextInt(50);
        int skill= 30+(damage*2);
        if (getEnergy() == 100) {
            System.out.println(y+name + " uses a special skill!"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Behold an orbital nightmare, SpaceEX!\"\n"+res);
            System.out.print(y+"============================================\n"+res);
            printL(g+"Elon dealt "+damage+" damage!"+res);
            System.out.println();
            general.takeDamage(skill);
            setEnergy(0);
        } else {
            System.out.println(r+name + " doesn't have enough energy to use the skill."+res);
        }
    }

    @Override
    public void takeDamage(int damage) {
        int health=getHP();
        health -= damage;

        if (health < 0) {
            health = 0;
            setHP(health);
        }
        else {
            setHP(health);
        }
    }
}

class Jeff extends Character{
    private final String name = "Jeff";
    private boolean droneShieldActive;

    public Jeff() {
        super(100, 100);
        droneShieldActive = false;
    }

    @Override
    public String getName() {
        return name;
    }

    //Setter for Drone Shield
    public void setDroneShieldActive(boolean active) {
        this.droneShieldActive = active;
    }

    //Getter for Drone Shield 
    public boolean isDroneShieldActive() {
        return droneShieldActive;
    }

    @Override
    public void attackEnemy(Minion minion){
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        minion.takeDamage(damage);
        energy += 20;
        setEnergy(energy);
    }

    @Override
    public void attackEnemyG(Enemy general){
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        general.takeDamage(damage);
        energy += 10;
        setEnergy(energy);
    }
    @Override
    public void defend(){
        int energy=getEnergy();
        boolean successfulDefense = random.nextDouble() < 0.95;
        if (successfulDefense) {
            energy += 10;
            setEnergy(energy);
            System.out.println(g+name + " successfully defends against the attack!"+res);
        } else {
            int damageTaken = random.nextInt(10) + 1;
            takeDamage(damageTaken);
            energy += 10;
            setEnergy(energy);
            System.out.println(r+name + " fails to defend against the attack and takes " + damageTaken + " damage!"+res);
        }
    }

    @Override
    public void skill(Minion minion) throws InterruptedException {
        int damage = 0;
        if (getEnergy() == 100) {
            printL(y+name + " uses a special skill!\n"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Grant me the strength to protect. Manifest thyself!\\nAmazon Prime Shield!\"\\n"+res);
            System.out.print(y+"============================================\n"+res);

            // Block all damage for the current turn
            setDroneShieldActive(true);
            setEnergy(0);

            // Jeff's skill will replenish his health over the next 5 turns
            for (int i = 1; i <= 5; i++) {
                int heal = getHealth();
                heal += 10;
                setHP(heal);

                printL(name + " heals for 10 HP!");
                pnl(1);

                //Turns();
            }

            // Turn off the shield after 5 turns
            setDroneShieldActive(false);
        } else {
            printL(name + " doesn't have enough energy to use the skill.\n");
        }
    }

    @Override
    public void skillG(Enemy general) throws InterruptedException {
        int damage = 0;
        if (getEnergy() == 100) {
            printL(y+name + " uses a special skill!\n"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Amazon Prime Shield activated!\"\n"+res);
            System.out.print(y+"============================================\n"+res);

            // Block all damage for the current turn
            setDroneShieldActive(true);
            setEnergy(0);

            // Jeff's skill will replenish his health over the next 5 turns
            for (int i = 1; i <= 5; i++) {
                int heal = getHealth();
                heal += 10;
                setHP(heal);

                printL(name + " heals for 10 HP!");
                pnl(1);

                //Turns();
            }

            // Turn off the shield after 5 turns
            setDroneShieldActive(false);
        } else {
            printL(name + " doesn't have enough energy to use the skill.\n");
        }
    }

    @Override
    public void takeDamage(int damage) {
        int health=getHP();
        health -= damage;

        if (health < 0) {
            health = 0;
            setHP(health);
        }
        else {
            setHP(health);
        }
    }
}

class Mark extends Character{
    private final String name = "Mark";

    //Mark Stats
    public Mark() {
        super(100,100);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attackEnemy(Minion minion){
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        minion.takeDamage(damage);
        energy += 20;
        setEnergy(energy);
    }
    @Override
    public void attackEnemyG(Enemy general){
        int damage = random.nextInt(10)+10;
        int energy=getEnergy();
        //Enemy objEnemy = new Enemy("Hi",0);

        System.out.println(b+name + " performs a basic attack and deals " + damage + " damage!"+res);
        general.takeDamage(damage);
        energy += 20;
        setEnergy(energy);
    }
    @Override
    public void defend(){
        int energy=getEnergy();
        boolean successfulDefense = random.nextDouble() < 0.95;
        if (successfulDefense) {
            energy += 10;
            setEnergy(energy);
            System.out.println(g+name + " successfully defends against the attack!"+res);
        } else {
            int damageTaken = random.nextInt(10) + 1;
            takeDamage(damageTaken);
            energy += 10;
            setEnergy(energy);
            System.out.println(r+name + " fails to defend against the attack and takes " + damageTaken + " damage!"+res);
        }
    }
    @Override
    public void skill(Minion minion) throws InterruptedException{
        int damage=0;
        int total_dmg=0;
        if (getEnergy() == 100) {
            printL(y+name + " uses a special skill!\n"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Witness my domain, METAVERSE!\"\n"+res);
            System.out.print(y+"============================================\n"+res);
            for (int i=1;i<=5;i++){
                damage = random.nextInt(25)+1;
                printL(g+"Hit #"+i+": " + damage + " damage!"+res);
                pnl(1);
                total_dmg+=damage;
                minion.takeDamage(damage);
            }
            printL(g+"Mark dealt "+total_dmg+" damage!"+res);
            System.out.println();
            //clearConsole();
            printL(g+"Mark heals himself for 20 HP.\n"+res);
            int heal=getHealth();
            heal+=20;
            setHP(heal);
            setEnergy(0);
        } else {
            printL(r+name + " doesn't have enough energy to use the skill.\n"+res);
        }
    }
    
    @Override
     public void skillG(Enemy general) throws InterruptedException{
        int damage=0;
        int total_dmg=0;
        if (getEnergy() == 100) {
            printL(y+name + " uses a special skill!\n"+res);
            clearConsole();
            System.out.print(y+"============================================\n"+res);
            printL(g+"\"Witness my domain, METAVERSE!\"\n"+res);
            System.out.print(y+"============================================\n"+res);
            for (int i=1;i<=5;i++){
                damage = random.nextInt(25)+1;
                printL(g+"Hit #"+i+": " + damage + " damage!"+res);
                pnl(1);
                total_dmg+=damage;
                general.takeDamage(damage);
            }
            printL(r+"Mark dealt "+total_dmg+" damage!"+res);
            System.out.println();
            //clearConsole();
            printL(g+"Mark heals himself for 20 HP.\n"+res);
            int heal=getHealth();
            heal+=20;
            setHP(heal);
            setEnergy(0);
        } else {
            printL(r+name + " doesn't have enough energy to use the skill.\n"+res);
        }
    }

    @Override
    public void takeDamage(int damage) {
        int health=getHP();
        health -= damage;

        if (health < 0) {
            health = 0;
            setHP(health);
        }
        else {
            setHP(health);
        }
    }
}