package checkBook;

import java.util.Scanner;

public class Student {
    private static Scanner sc = new Scanner(System.in);
    private static CheckBook[] book = new CheckBook[9];

    public static void main(String[] args) {
        book[0] = new CheckBook(1,"챈들러",20151234);
        book[1] = new CheckBook(1,"포이리에",20152314);
        book[2] = new CheckBook(1,"타이슨",20155132);

        book[3] = new CheckBook(2,"이순신",20149876);
        book[4] = new CheckBook(2,"김구",20145712);
        book[5] = new CheckBook(2,"세종",20141563);

        book[6] = new CheckBook(3,"박효신",20132648);
        book[7] = new CheckBook(3,"카리나",20131346);
        book[8] = new CheckBook(3,"안유진",20136974);

        System.out.print("몇학년의 출석부를 보시겠습니까?");
        while(true) {
            int grade = sc.nextInt();
            if (grade == 1) {
                grade1();
                break;
            } else if (grade == 2) {
                grade2();
                break;
            } else if (grade == 3) {
                grade3();
                break;
            } else
                System.out.println("다시 입력하세요.");
        }
    }
    private static void grade1() {
        for(int i=0; i<book.length;i++) {
            if(book[i].getGrade()==1) {
                System.out.println(book[i].getName());
            }
        }
    }
    private static void grade2() {
        for(int i=0; i<book.length;i++) {
            if(book[i].getGrade()==2) {
                System.out.println(book[i].getName());
            }
        }
    }
    private static void grade3() {
        for(int i=0; i<book.length;i++) {
            if(book[i].getGrade()==3) {
                System.out.println(book[i].getName());
            }
        }
    }
}
