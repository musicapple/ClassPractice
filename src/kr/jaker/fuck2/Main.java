package kr.jaker.fuck2;

import kr.jaker.fuck2.entity.Monster;
import kr.jaker.fuck2.entity.Player;

import java.util.Scanner;

public class Main {

    // entity

    // 플레이어 -> hp, exp, lv, damage, special
    // 몬스터 -> hp, 주는 exp, damage

    // 객체 지향(oop)
    // -> 멤버 변수는 private

    private static int monsterHp =500;
    private static final int DEFAULT_ATTACK_DAMAGE = 50;
    private static final int SPECIAL_ATTACK_DAMAGE = 125;

    // 객체의 생성은 생성자를 반드시 호출해야만 생성할 수 있음

    public static void main(String[] args) {

        new Player();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.공격");
            System.out.println("2.특수");
            System.out.println("3.도망");
            int select = sc.nextInt();
            if(select == 3) break;
            else if(select != 1 && select != 2) System.out.println("다시입력");
            else {
                int hp = monster(select ==2 ? DEFAULT_ATTACK_DAMAGE : SPECIAL_ATTACK_DAMAGE);
                System.out.println("몬스터 체력 + hp");
            }
        }
        Player p1 =new Player(); // 500, 공격력 20
        Player p2 =new Player(); // 550, 공격력 20

        Monster m1 = new Monster("골렘",10000);
        Monster m2 = new Monster("마녀",200000,30000,4000);
        Monster m3 = new Monster("타노스");
    }

    private static int monster() {
        return monster(20);
    }

    private static double monster(double damage) {
        return monster((int) damage);
    }

    private static int monster(int attack) {

        System.out.println("---------");
        if(monsterHp == 0) {
            System.out.println("이미 죽은 몹");
            return 0;
        }

        if(monsterHp > 0)
            monsterHp -= attack;

        if(monsterHp <= 0) {
            monsterHp =0;
            System.out.println("죽었습니다.");
        }
        return monsterHp;
    }


}
