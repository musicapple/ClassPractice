package game2;

public class Main {

    public static void main(String[] args) {
        Entity entity1 = new Player(50, 20, 50, 0, 50, 20, 100, 1, 100);
        Entity entity2 = new Monster("몬스터1", 50, 10, 20, 100, 50, 200);


        System.out.println("entity1 : +50 exp");
        entity1.setExp(55);
        System.out.println("entity2 : +50 exp");
        entity2.setExp(55);



    }

}
