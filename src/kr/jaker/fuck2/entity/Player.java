package kr.jaker.fuck2.entity;

// 플레이어 -> hp, exp, lv, damage, special damage

public class Player {

    private int hp;
    private int exp;
    private int level;
    private int damage;
    private int specialDamage;

    // 생성자 (객체가 생성될 때 자동으로 실행되는 함수)
    public Player() {
        hp = 500;
        exp = 0;
        level =0;
        damage =20;
        specialDamage= 55;
    }
}
