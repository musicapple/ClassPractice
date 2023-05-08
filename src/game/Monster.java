package game;

import java.util.Random;

public class Monster {
    private String name;
    private int hp;
    private int defaultAttack;
    private int specialAttack;
    private int exp;
    private int cnt;
    private int allCnt;
    private int money;
    private int minMoney;
    private int maxMoney;

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
        if (killer.getExp() > killer.getMaxExp()) {        //몬스터를 죽여서 얻은 경험치가 총 경험치 창보다 많으면 레벨업. 문제는 레벨업하고도 남은 경험치는 어떻게 더할것인지
            int surplus = killer.getExp() - killer.getMaxExp();
            killer.levelUp();
            killer.setExp(surplus);
        }
        System.out.println("현재 경험치: " + killer.getExp());
        System.out.println(name + "처치 횟수: " + (cnt + 1));
        System.out.println("총 몬스터 처치 횟수: " + (++allCnt));
        money = dropMoney();
        System.out.print("$" + money + " 금화를 획득하였습니다!");
        killer.setMoney(killer.getMoney() + money);
        System.out.println(" / 보유 금화: " + killer.getMoney());
    }
}