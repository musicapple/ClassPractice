package game4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Player p1 = new Player(300, 100, 200, 0, 100, 0, 1, 300);
        Dungeon dungeon = new Dungeon();
        Market market = new Market();
        while (true) {
            System.out.println("[1] 던전");
            System.out.println("[2] 상점");
            System.out.println("어디를 가시겠습니까?");
            int number = sc.nextInt();
            if (number == 1) {
                dungeon.enter(p1);  // 던전입장
            } else if (number == 2) {
                market.enter(p1);
            }
        }
    }
}
