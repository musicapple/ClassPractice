package game4;

import java.util.Scanner;

public class Hunt {
    Scanner sc = new Scanner(System.in);

    public void fight(Player p1, Monster monster) {
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("<#2.공격방법선택>");
            System.out.println("1.일반공격");
            System.out.println("2.특수공격");
            System.out.println("3.던전입구로 돌아가기");
            if (monster.getHp() != 0) System.out.print(monster.getName() + "을(를) 발견했습니다! 무엇을 하시겠습니까?");
            else System.out.print(monster.getName() + "의 무덤을 발견했습니다! 무엇을 하시겠습니까?");
            int number = sc.nextInt();
            int attack = 0;
            if (number == 1) {
                attack = p1.getDefaultAttack();
            } else if (number == 2) {
                attack = p1.getSpecialAttack();
            } else if (number == 3) {
                System.out.print("던전입구로 돌아왔습니다.");
                return;
            } else {
                System.out.println("다시 입력하시오.");
                continue;
            }
            System.out.println("현재 몬스터 hp: " + monster(p1, monster, attack));
            System.out.println("플레이어 hp: " + p1.getHp());
        }
    }

    public int monster(Player p1, Monster monster, int attack) {
        System.out.println("------------------------------");
        if (monster.getHp() == 0) {
            System.out.println("몬스터가 이미 죽었습니다!");
            return 0;           // 몬스터가 죽었으면 함수 끝냄
        }
        if (monster.getHp() > 0) {
            monster.setHp(monster.getHp() - attack);
            if (monster.getHp() <= 0) {         // 플레이어가 공격하고 몬스터가 공격. 플레이어가 공격했을
                // 때 몬스터가 죽었는지 if문 발생.
                monster.setHp(0);
                monster.death(p1);

            } else {                                                // 몬스터가 죽지 않았다면 몬스터가 공격하는 코드 진행.
                p1.setHp(p1.getHp() - monster.getDefaultAttack());
                if (p1.getHp() <= 0) {
                    p1.setHp(0);
                    System.out.println("플레이어가 사망했습니다.");
                    System.exit(0);
                }
            }
        }
        return monster.getHp();
    }
}
