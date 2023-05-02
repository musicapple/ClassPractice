package game;

import java.util.Random;

public class Monster {
    private String name;
    private int hp;
    private int defaultAttack;
    private int specialAttack;
    private int exp;
    private int cnt;
    private int money;

    public Monster(String name,int hp,int defaultAttack,int specialAttack, int exp) {
        this.name = name;
        this.hp = hp;
        this.defaultAttack = defaultAttack;
        this.specialAttack = specialAttack;
        this.exp = exp;
    }

    public String getName() {return name;}
    public int getHp() {return hp;}
    public int getDefaultAttack() {return defaultAttack;}
    public int getSpecialAttack() {return specialAttack;}
    public int getExp() {return exp;}
    public void setHp(int hp) {this.hp = hp;}
    public int getCnt() {return cnt;}
    public int getMoney() {return new Random().nextInt(401) +100; }

}
