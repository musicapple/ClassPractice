package game3;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static Player p1 = new Player(300,100,200,0,2,0,30,1,300);

    public static void main(String[] args) {

        while(true){
            System.out.println("[1] 던전");
            System.out.println("[2] 상점");
            System.out.println("어디를 가시겠습니까?");
            int number = sc.nextInt();
            if(number == 1) {
                Dungeon.enter(p1);
            } else if(number == 2){
                Market.enter(p1);
            }
        }
    }
}