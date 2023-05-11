package game4;

import java.util.Scanner;

public class Dungeon {

    Scanner sc = new Scanner(System.in);
    Monster m1 = new Monster(300, 100, 200, 60, "스톤골렘", 1000, 2000);
    Monster m2 = new Monster(320, 120, 200, 70, "드레이크", 2500, 3000);
    Monster m3 = new Monster(350, 50, 100, 50, "좀비버섯", 900, 1900);
    Monster m4 = new Monster(500, 150, 200, 130, "혼테일", 10000, 20000);
    Hunt hunt = new Hunt();

    public void enter(Player p1) {
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("<#1. 던전입구>");
            if (m1.getHp() != 0 | m2.getHp() != 0 | m3.getHp() != 0) {
                System.out.println("[1] 골렘 던전");
                System.out.println("[2] 드레이크 던전");
                System.out.println("[3] 개미굴");
            }
            if (m1.getHp() == 0 & m2.getHp() == 0 & m3.getHp() == 0) {
                System.out.println("용의 신전이 열렸습니다.");
                System.out.println("[0] 용의 신전");
            }

            System.out.println("[4] 도망치기(마을로 이동)");
            System.out.println("던전을 발견했습니다! 어디로 들어가시겠습니까?");
            int number = sc.nextInt();

            if (m1.getHp() != 0 | m2.getHp() != 0 | m3.getHp() != 0) {

                if (number == 1) {
                    System.out.println("골렘 던전으로 입장합니다.");
                    hunt.fight(p1, m1);
                } else if (number == 2) {
                    System.out.println("드레이크 던전으로 입장합니다.");
                    hunt.fight(p1, m2);
                } else if (number == 3) {
                    System.out.println("개미굴로 입장합니다.");
                    hunt.fight(p1, m3);
                } else if (number == 4) {
                    System.out.println("도망쳤습니다.(마을로 이동)");
                    break;
                } else
                    System.out.println("다시 입력하세요.");
            }
            if (m1.getHp() == 0 & m2.getHp() == 0 & m3.getHp() == 0) {
                if (number == 0) {
                    System.out.println("용의 신전으로 입장합니다.");
                    hunt.fight(p1, m4);
                } else if (number == 4) {
                    System.out.println("도망쳤습니다.(마을로 이동)");
                    break;
                }
            }
        }
    }
}
