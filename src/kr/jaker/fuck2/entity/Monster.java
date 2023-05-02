package kr.jaker.fuck2.entity;

public class Monster {
    // 몬스터 -> name, hp, 주는 exp, damage
    private String name;
    private int hp;
    private int exp;
    private int damage;

    public Monster(String name) {
        this(name,0,0,0);
    }
    public Monster(String name,int exp) {
        this(name,0,exp,0);
    }

    public Monster(String name,int hp,int exp,int damage) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.damage = damage;
    }
}
