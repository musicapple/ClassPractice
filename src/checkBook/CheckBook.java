package checkBook;

public class CheckBook {

    private int grade;
    private String name;
    private int number;

    public CheckBook(int grade,String name,int number) {
        this.grade = grade;
        this.name = name;
        this.number = number;
    }
    public int getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }
}
