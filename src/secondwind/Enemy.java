package secondwind;

import java.util.*;

public abstract class Enemy{
    protected String name;
    protected int hp;
    Random random;
    protected int damage;

    public int getDamage() {
        return damage;
    }
    
    
    //Colors
    String res = "\u001B[0m"; //Reset
    String r = "\u001B[31m"; //Red
    String g = "\u001B[32m"; //Green
    String b = "\u001B[34m"; //Blue
    String y = "\u001B[33m"; //Yellow

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.random = new Random();
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
    
    public abstract void attackHero(Character hero);
    public abstract void skill(Character hero);

   public int attack() {
        random = new Random();
        int dmg=random.nextInt(5) + 1;
        damage=dmg;
        return  dmg;// Random damage between 1 and 10
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return hp;
    }
    
    public void clearConsole(){
        System.out.print("\033c");
    }
    
    public void printL(String line)throws InterruptedException{
        for (int i=0;i<line.length();i++){
            System.out.print(line.charAt(i));
            Thread.sleep(80);
        }
    }
}

class alterBoss extends Enemy {
    public alterBoss() {
        super("Alien King", 500); // Boss's health (subjected to change)
    }

    @Override
    public int attack() {
        int dmg = random.nextInt(5) + 1;
        damage = dmg;
        return  dmg; // Regular attack
    }

    @Override
    public void attackHero(Character hero) {
        int damage = attack() + 15; // Increase regular attack damage by 20
        hero.takeDamage(damage);
        System.out.println(r+getName() + " attacks " + hero.getName() + " for " + damage + " damage!"+res);
    }
    //Hero did not Defend
    @Override
    public void skill(Character hero){
        int damage = random.nextInt(20)+80;
        System.out.println(y+name + " uses a special skill!"+res);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"I HAVE NO USE FOR A TAINTED WORLD.\"\n"+res);
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"The Alien King dealt "+damage+" damage!"+res);
        System.out.println();
        hero.takeDamage(damage);
    }
    //Hero Defended
    public void skillDef(Character hero){
        int damage = random.nextInt(20)+20;
        System.out.println(y+name + " uses a special skill!"+res);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"I HAVE NO USE FOR A TAINTED WORLD.\"\n");
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"The Alien King dealt "+damage+" damage!"+res);
        System.out.println();
        hero.takeDamage(damage);
    }
    
}

class Minion extends Enemy{


    public Minion(String name,int hp) {
        super(name, hp); //Minion's health (subjected to change)
    }
    @Override
    public void attackHero(Character hero) {

        int damage = attack();
        hero.takeDamage(damage);
        System.out.println(r+getName() + " attacks " + hero.getName() + " for " + damage + " damage!"+res);
    }
    @Override
    public void skill(Character hero) {
        /*int damage = random.nextInt(50)+50;
        System.out.println(name + " uses a special skill!");
        hero.takeDamage(damage);*/
    }
}

class enemyAssassin extends Enemy{
    public enemyAssassin(){
        super("Alter I", 250); //Minion's health (subjected to change)
    }
    
    @Override
    public int attack() {
        random = new Random();
        return random.nextInt(20) + 1; // Random damage between 1 and 10
    }
    @Override
    public void attackHero(Character hero) {

        int damage = attack();
        hero.takeDamage(damage);
        System.out.println(r+getName() + " attacks " + hero.getName() + " for " + damage + " damage!"+res);
    }
    //Hero did not Defend
    @Override
    public void skill(Character hero){
        int damage= 20+(attack()/**2*/);
        System.out.println(y+name + " uses a special skill!"+res);
        hero.takeDamage(damage);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"Orbital strike, SpaceEX!\"\n"+res);
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"Alien Elon dealt "+damage+" damage!"+res);
        System.out.println();
        hero.takeDamage(damage);
    }
    //Hero defended
    public void skillDef(Character hero){
        int damage= 10+(attack());
        System.out.println(y+name + " uses a special skill!"+res);
        hero.takeDamage(damage);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"Orbital strike, SpaceEX!\"\n"+res);
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"Alien Elon dealt "+damage+" damage!"+res);
        System.out.println();
        hero.takeDamage(damage);
    }
}

class enemyShielder extends Enemy{
    public enemyShielder(){
        super("Alter H", 300); //Minion's health (subjected to change)
    }
    
    @Override
    public int attack() {
        random = new Random();
        return random.nextInt(10) + 10; // Random damage between 1 and 10
    }
    @Override
    public void attackHero(Character hero) {

        int damage = attack();
        hero.takeDamage(damage);
        System.out.println(r+getName() + " attacks " + hero.getName() + " for " + damage + " damage!"+res);
    }
    @Override
    public void skill(Character hero){
        boolean successfulDefense = random.nextDouble() < 1;
        if (successfulDefense) {
            System.out.println(r+name + " will block the next attack!"+res);
        } else {
            int damageTaken = random.nextInt(10) + 1;
            takeDamage(damageTaken);
            System.out.println(g+name + " fails to defend against the attack and takes " + damageTaken + " damage!"+res);
        }
    }
}

class enemyMage extends Enemy{
    public enemyMage(){
        super("Alter E", 200); //Minion's health (subjected to change)
    }
    
    @Override
    public int attack() {
        random = new Random();
        return random.nextInt(10) + 10; // Random damage between 1 and 10
    }
    @Override
    public void attackHero(Character hero) {

        int damage = attack();
        hero.takeDamage(damage);
        System.out.println(r+getName() + " attacks " + hero.getName() + " for " + damage + " damage!"+res);
    }
    //Hero did not defend
    @Override
    public void skill(Character hero){
        int damage;
        int total_dmg=0;
        System.out.println(y+name + " uses a special skill!\n"+res);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"The vision of the future, METAVERSE!\"\n"+res);
        System.out.print(y+"============================================\n"+res);
        for (int i=1;i<=5;i++){
            damage = random.nextInt(20)+1;
            System.out.println(r+"Hit #"+i+": " + damage + " damage!"+res);
            System.out.println();
            total_dmg+=damage;
            hero.takeDamage(damage);
        }
        System.out.println(r+"Alien Mark dealt "+total_dmg+" damage!"+res);
        System.out.println();
    }
    //Hero Defends
    public void skillDef(Character hero){
        int damage;
        int total_dmg=0;
        System.out.println(y+name + " uses a special skill!\n"+res);
        clearConsole();
        System.out.print(y+"============================================\n"+res);
        System.out.println(r+"\"The vision of the future, METAVERSE!\"\n"+res);
        System.out.print(y+"============================================\n"+res);
        for (int i=1;i<=5;i++){
            damage = random.nextInt(10)+1;
            System.out.println(r+"Hit #"+i+": " + damage + " damage!"+res);
            System.out.println();
            total_dmg+=damage;
            hero.takeDamage(damage);
        }
        System.out.println(r+"Alien Mark dealt "+total_dmg+" damage!"+res);
        System.out.println();
    }
}