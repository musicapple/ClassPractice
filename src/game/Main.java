package game;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Monster m1 = new Monster("스톤골렘",500,50,150,50);
    private static Monster m2 = new Monster("주니어발록",3300,100,355,120);
    private static Monster m3 = new Monster("좀비버섯",250,15,35,40);

    private static Player p1 =new Player(300,25,125,0,2,0);
    private static int allCnt=0;
    static Random random = new Random();

    public static void main(String[] args) {

        while(true) {
            if(!Dungeon()) break;

        }
    }
    private static boolean Dungeon() {
        System.out.println("------------------------------");
        System.out.println("<#1.던전입구>");
        System.out.println("[1] 골렘 던전");
        System.out.println("[2] 발록 신전");
        System.out.println("[3] 개미굴");
        System.out.println("[4] 도망치기");

        System.out.print("던전을 발견했습니다! 어디로 들어가시겠습니까?");
        int number = sc.nextInt();
        if(number == 1) {
            System.out.println("골렘 던전으로 입장합니다.");
            menu(m1);
        } else if (number == 2) {
            System.out.println("발록 신전으로 입장합니다.");
            menu(m2);
        } else if (number == 3) {
            System.out.println("개미굴로 입장합니다.");
            menu(m3);
        } else if (number == 4) {
            System.out.println("도망쳤습니다.(프로그램 종료)");
            return false;
        }
        else {
            System.out.println("다시 입력하세요.");
        }
        return true;
    }
    private static boolean menu(Monster monsters) {
        while(true) {
            System.out.println("------------------------------");
            System.out.println("<#2.공격방법선택>");
            System.out.println("1.일반공격");
            System.out.println("2.특수공격");
            System.out.println("3.던전입구로 돌아가기");

            System.out.print(monsters.getName() + "을(를) 발견했습니다! 무엇을 하시겠습니까?");
            int number = sc.nextInt();
            int attack = 0;
            if (number == 1) {attack = p1.getDefaultAttack();}
            else if (number == 2) {attack = p1.getSpecialAttack();}
            else if (number == 3) {
                System.out.print("던전입구로 돌아왔습니다.");
                return true;
            }
            else {System.out.println("다시 입력하시오.");}
            if(number==1|number==2) {
                System.out.println("현재 몬스터 hp: " + monster(monsters, attack));
                System.out.println("플레이어 hp: " + p1.getHp());
            }
        }
    }
    private static int monster(Monster monsters, int attack) {
        System.out.println("------------------------------");
        if(monsters.getHp() == 0) {
            System.out.println("몬스터가 이미 죽었습니다!");
            return 0;
        }
        if(monsters.getHp() > 0) {
            monsters.setHp(monsters.getHp() - attack);
            p1.setHp(p1.getHp()-monsters.getDefaultAttack());
            if(p1.getHp()<=0) {
                p1.setHp(0);
                System.out.println("플레이어가 사망했습니다.");
            }
        }
        if(monsters.getHp() <= 0) {
            monsters.setHp(0);
            System.out.println("몬스터가 죽었습니다!");
            p1.setExp(p1.getExp()+monsters.getExp());
            p1.setMoney(p1.getMoney()+monsters.getMoney());
            System.out.println("금화를 $"+p1.getMoney()+"획득하였습니다!");
            System.out.println("player1의 현재 경험치: "+p1.getExp());
            System.out.println(monsters.getName()+" 처치 횟수: " + (monsters.getCnt()+1));

            // 우리가 변수에 값을 저장하고 싶음 ?
            //  변수에 값을 저장한다 -> 대입한다 -> 대입을 하려면 대입 연산자를 써야한다. ( = )
            //  +, -, *, /, % -> 연산자 -> 산술 연산자 -> 산술 연산자는 원본 값을 수정하는가 ? ( x )
            //  산술 연산자 + 대입 연산자 -> 복합 대입 연산자 -> 복합 대입 연산자는 산술 연산자 뒤에 대입연산자를 붙임 -> 원본 값을 수정한다.
            //  증감 연산자 -> 변수의 값을 1 증가 시키거나 감소시킬 수 있음. ( ++, -- )
            //      후순위(변수를 먼저 원래값을 사용하고 증가) , 선순위(증가 시키고 사용)

            System.out.println("총 몬스터 처치 횟수: " + (++allCnt));       // allCnt가 왜 누적이 안될까? 1,2,3,4,5
        }
        return monsters.getHp();
    }
}

