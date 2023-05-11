package game2;

public class Monster extends Entity {
    private final String name;
    private final int minMoney;
    private final int maxMoney;
    private int count;

    public Monster(String name, int hp, int defaultAttack, int specialAttack, int exp, int minMoney, int maxMoney) {
        super(hp, defaultAttack, specialAttack, exp);
        this.name = name;
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
        this.count = 0;
    }

}
