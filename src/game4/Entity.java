package game4;

public class Entity {
    private int hp;
    private int defaultAttack;
    private int specialAttack;
    private int exp;

    public Entity(int hp, int defaultAttack, int specialAttack, int exp) {
        this.hp = hp;
        this.defaultAttack = defaultAttack;
        this.specialAttack = specialAttack;
        this.exp = exp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefaultAttack() {
        return defaultAttack;
    }

    public void setDefaultAttack(int defaultAttack) {
        this.defaultAttack = defaultAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}