package game;

import java.util.Scanner;

public class Market {
    private static Scanner sc = new Scanner(System.in);
    static int stick_volume = 1;
    static int pyochang_volume = 1;
    public static void enter(Player p1) {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("[1] 빨강포션(체력회복+50) / $100");
            System.out.println("[2] 하인즈의 지팡이(특수공격력+100) / $125");
            System.out.println("[3] 일비 표창(일반 공격력+100) / $140");
            System.out.println("[4] 상점 나가기");
            int number = sc.nextInt();
            if (number == 1) {
                potion(p1);
            } else if (number == 2) {
                heinzStick(p1);
            } else if (number == 3) {
                pyochang(p1);
            } else if (number == 4) {
                break;
            }
        }
    }

    private static void potion(Player p1) {
        int cost = 100;
        if (p1.getMoney() < cost) {
            System.out.println("보유 금화가 부족하여 포션을 구매할 수 없습니다.");
        } else {
            if (p1.getHp() >= p1.getMaxHp()) {
                System.out.println("체력이 충분하여 포션을 구매할 수 없습니다.");
            } else {
                p1.setMoney(p1.getMoney() - cost);
                p1.setHp(p1.getHp() + 50);
                if (p1.getHp() > p1.getMaxHp())
                    p1.setHp(p1.getMaxHp());
                System.out.println("체력이 회복되었습니다. 현재 hp: " + p1.getHp());
            }
        }
    }

    private static void heinzStick(Player p1) {
        int cost = 125;
        if (p1.getMoney() < cost) {
            System.out.println("보유 금화가 부족하여 '하인즈의 지팡이'를 구매할 수 없습니다.");
        } else {
            if (stick_volume < 1) {
                System.out.println("물량이 부족하여 '하인즈의 지팡이'를 구매할 수 없습니다.");
            } else {
                p1.setMoney(p1.getMoney() - cost);
                stick_volume--;
                System.out.println(stick_volume);
                p1.setSpecialAttack(p1.getSpecialAttack() + 15);
                System.out.println("특수공격력이 +15올랐습니다. 현재 특수공격력: " + p1.getSpecialAttack());
            }
        }
    }

    private static void pyochang(Player p1) {
        int cost = 140;
        if (p1.getMoney() < cost) {
            System.out.println("보유 금화가 부족하여 '일비표창'을 구매할 수 없습니다.");
        } else {
            if (pyochang_volume < 1) {
                System.out.println("물량이 부족하여 '일비표창'을 구매할 수 없습니다.");
            } else {
                System.out.println(pyochang_volume);
                p1.setMoney(p1.getMoney() - cost);
                --pyochang_volume;
                System.out.println(pyochang_volume);
                p1.setDefaultAttack(p1.getDefaultAttack() + 15);
                System.out.println("일반공격력이 +15올랐습니다. 현재 특수공격력: " + p1.getDefaultAttack());
            }
        }
    }
}