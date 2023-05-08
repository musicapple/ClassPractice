package game;

import java.util.Scanner;

public class Dungeon {

    private static Scanner sc = new Scanner(System.in);
    private static Monster m1 = new Monster("스톤골렘", 500, 50, 150, 50, 500, 1100);
    private static Monster m2 = new Monster("드레이크", 300, 100, 355, 120, 5000, 20000);
    private static Monster m3 = new Monster("좀비버섯", 250, 15, 35, 60, 300, 600);
    private static Monster m4 = new Monster("혼테일", 600, 40, 40, 50, 10000, 20000);

    public static void enter(Player p1) {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("<#1.던전입구>");
            if (m1.getHp() != 0 | m2.getHp() != 0 | m3.getHp() != 0) {
                System.out.println("[1] 골렘 던전");
                System.out.println("[2] 발록 신전");
                System.out.println("[3] 개미굴");
            }
            if (m1.getHp() == 0 & m2.getHp() == 0 & m3.getHp() == 0) {
                System.out.println("용의 신전이 열렸습니다.");
                System.out.println("[0] 용의 신전");
            }
            System.out.println("[4] 도망치기(마을로 이동)");

            System.out.print("던전을 발견했습니다! 어디로 들어가시겠습니까?");
            int number = sc.nextInt();
            if (m1.getHp() != 0 | m2.getHp() != 0 | m3.getHp() != 0) {
                if (number == 1) {
                    System.out.println("골렘 던전으로 입장합니다.");
                    menu(p1, m1);
                } else if (number == 2) {
                    System.out.println("드레이크 동굴 으로 입장합니다.");
                    menu(p1, m2);
                } else if (number == 3) {
                    System.out.println("개미굴로 입장합니다.");
                    menu(p1, m3);
                } else if (number == 4) {
                    System.out.println("도망쳤습니다.(마을로 이동)");
                    break;
                } else {
                    System.out.println("다시 입력하세요.");
                }
            }
            if (m1.getHp() == 0 & m2.getHp() == 0 & m3.getHp() == 0) {
                if(number == 0) {
                    System.out.println("용의 신전으로 입장합니다.");
                    menu(p1,m4);
                } else if (number == 4) {
                    System.out.println("도망쳤습니다.(마을로 이동)");
                    break;
                }
            }
        }
    }

    private static void menu(Player p1, Monster monster) {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("<#2.공격방법선택>");
            System.out.println("1.일반공격");
            System.out.println("2.특수공격");
            System.out.println("3.던전입구로 돌아가기");
            if (monster.getHp() != 0)
                System.out.print(monster.getName() + "을(를) 발견했습니다! 무엇을 하시겠습니까?");
            else
                System.out.print(monster.getName() + "의 무덤을 발견했습니다! 무엇을 하시겠습니까?");
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

    private static int monster(Player p1, Monster monster, int attack) {
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
        }                   // 플레이어가 공격하고 몬스터가 공격. 문제점은 플레이어의 공격으로 몬스터가 죽어도 몬스터가 공격하는 코드가 진행됨.
        return monster.getHp();
    }
}

