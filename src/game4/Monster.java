package game4;

import java.util.Random;

public class Monster extends Entity {
    private final String name;
    private final int minMoney;
    private final int maxMoney;

    public Monster(int hp, int defaultAttack, int specialAttack, int exp
            , String name, int minMoney, int maxMoney) {
        super(hp, defaultAttack, specialAttack, exp);
        this.name = name;
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
    }

    public String getName() {
        return name;
    }

    public void death(Player killer) {
        System.out.println("------------------------------");
        System.out.println("몬스터가 죽었습니다!");
        System.out.println(killer.getExp());        //  0
        System.out.println(super.getExp());         //  400
        killer.setExp(killer.getExp() + super.getExp()); // player 원래 경험치 + 몬스터 처치 경험치
        System.out.println("현재 경험치: " + killer.getExp());
        int money = dropMoney();
        System.out.print("$" + money + " 금화를 획득하였습니다!");
        killer.setMoney(killer.getMoney() + money);     // player 원래 돈 + 몬스터 처치하고 주운 돈
        System.out.println(" / 보유 금화: " + killer.getMoney());
    }

    public int dropMoney() {
        return new Random().nextInt(maxMoney - minMoney + 1) + minMoney;
    }

}
