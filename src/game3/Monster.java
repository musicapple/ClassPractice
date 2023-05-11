package game3;

import java.util.Random;

public class Monster {
    private final String name;
    private int hp;
    private final int defaultAttack;
    private final int specialAttack;
    private final int exp;
    private int cnt;
    private int allCnt;
    private final int minMoney;
    private final int maxMoney;

    public Monster(String name, int hp, int defaultAttack, int specialAttack, int exp, int minMoney, int maxMoney) {
        this.name = name;
        this.hp = hp;
        this.defaultAttack = defaultAttack;
        this.specialAttack = specialAttack;
        this.exp = exp;
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDefaultAttack() {
        return defaultAttack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int dropMoney() {
        return new Random().nextInt(maxMoney - minMoney + 1) + minMoney;
    }

    public void death(Player killer) {
        System.out.println("------------------------------");
        System.out.println("몬스터가 죽었습니다!");

        killer.setExp(killer.getExp() + exp); // player 경험치 획득

        System.out.println("현재 경험치: " + killer.getExp());
        System.out.println(name + "처치 횟수: " + (cnt + 1));
        System.out.println("총 몬스터 처치 횟수: " + (++allCnt));
        int money = dropMoney();
        System.out.print("$" + money + " 금화를 획득하였습니다!");
        killer.setMoney(killer.getMoney() + money);
        System.out.println(" / 보유 금화: " + killer.getMoney());
    }
}