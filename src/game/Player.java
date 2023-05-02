package game;

public class Player {
    private int hp;
    private int defaultAttack;
    private int specialAttack;
    private int exp;
    private int critical;
    private int money;


    public Player(int hp,int defaultAttack,int specialAttack, int exp, int critical,int money) {
        this.hp = hp;
        this.defaultAttack = defaultAttack;
        this.specialAttack = specialAttack;
        this.exp = exp;
        this.critical = critical;
        this.money=money;
    }
    public int getHp() {return hp;}
    public int getDefaultAttack() {return defaultAttack;}
    public int getSpecialAttack() {return specialAttack;}
    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp = exp;}
    public int getCritical() {return critical;}
    public void setHp(int hp) {this.hp = hp;}
    public int getMoney() {return money;}
    public void setMoney(int money) {this.money=money;}
}