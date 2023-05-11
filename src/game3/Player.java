package game3;

public class Player {
    private int hp;
    private int defaultAttack;
    private int specialAttack;
    private int exp;
    private int maxExp;
    private int critical;
    private int money;
    private int level;
    private int maxHp;


    public Player(int hp, int defaultAttack, int specialAttack, int exp, int critical, int money, int maxExp, int level, int maxHp) {
        this.hp = hp;
        this.defaultAttack = defaultAttack;
        this.specialAttack = specialAttack;
        this.exp = exp;
        this.critical = critical;
        this.money = money;
        this.maxExp = maxExp;
        this.level = level;
        this.maxHp = maxHp;

    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
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
        if (exp >= maxExp) {
            int sub = maxExp - exp;
            levelUp();
            this.exp = sub;
        } else {
            this.exp = exp;
        }
    }

    public int getCritical() {
        return critical;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void levelUp() {
        System.out.println("------------------------------");
        maxHp += maxHp;               // 레벨업시 maxhp를 2배로 올려줌
        hp = maxHp;                   // 레벨업시 손상된 hp를 maxhp로 회복시켜줌
        exp = 0;                      // 경험치 0으로 초기화
        defaultAttack += 15;
        specialAttack += 15;
        maxExp += 30;
        ++level;
        System.out.println("축하합니다! level이 " + level + "이 되었습니다!");
        System.out.println("hp가 " + hp + "로 증가했습니다!");
        System.out.println("기본공격력이 " + defaultAttack + "로 향상했습니다!");
        System.out.println("특수공격력이 " + specialAttack + "로 향상했습니다!");
    }
}