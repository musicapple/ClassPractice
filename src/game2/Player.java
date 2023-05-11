package game2;

public class Player extends Entity {
    private int maxExp;
    private int critical;
    private int money;
    private int level;
    private int maxHp;

    public Player(int hp, int defaultAttack, int specialAttack, int exp,
                  int maxExp, int critical, int money, int level, int maxHp) {
        super(hp, defaultAttack, specialAttack, exp);
        this.maxExp = maxExp;
        this.critical = critical;
        this.money = money;
        this.level = level;
        this.maxHp = maxHp;
    }

    @Override
    public void setExp(int exp) {
        if (exp >= maxExp) {
            level++;
            System.out.println("레벨 업!");
            super.setExp(0);
        } else super.setExp(exp);
    }
}
