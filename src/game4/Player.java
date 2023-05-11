package game4;

public class Player extends Entity {
    private int maxExp;
    private int money;
    private int level;
    private int maxHp;

    public Player(int hp, int defaultAttack, int specialAttack, int exp
            , int maxExp, int money, int level, int maxHp) {
        super(hp, defaultAttack, specialAttack, exp);
        this.maxExp = maxExp;
        this.money = money;
        this.level = level;
        this.maxHp = maxHp;
    }

    @Override
    public void setExp(int exp) {
        if (exp > maxExp) {
            int sub = exp - maxExp;       // 레벨업 후에 남은 경험치 더해줌.
            levelUp();
            System.out.println("sub: " + sub);
            super.setExp(sub);
        } else {
            super.setExp(exp);
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void levelUp() {
        System.out.println("------------------------------");
        maxHp += maxHp;               // 레벨업시 maxhp를 2배로 올려줌
        super.setHp(maxHp);                   // 레벨업시 손상된 hp를 maxhp로 회복시켜줌
        super.setExp(0);                     // 경험치 0으로 초기화
        super.setDefaultAttack(getDefaultAttack() + 15);
        super.setSpecialAttack(getSpecialAttack() + 15);
        maxExp += 30;
        ++level;
        System.out.println("축하합니다! level이 " + level + "이 되었습니다!");
        System.out.println("hp가 " + super.getHp() + "로 증가했습니다!");
        System.out.println("기본공격력이 " + super.getDefaultAttack() + "로 향상했습니다!");
        System.out.println("특수공격력이 " + super.getSpecialAttack() + "로 향상했습니다!");
    }

    public int getMaxHp() {
        return maxHp;
    }
}
