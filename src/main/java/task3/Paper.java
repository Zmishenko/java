package task3;

import java.util.Random;

public class Paper {
    public String author = null;
    String name = null;
    public int views = 0;
    public int number = 0;
    public int year = 0;
    int month = 0;
    Rubric rubric = Rubric.first;

    public Paper(String author, String name, int views, int numbers, int year, int month, Rubric rubric) {
        this.author = author;
        this.name = name;
        this.views = views;
        this.number = numbers;
        this.year = year;
        this.month = month;
        this.rubric = rubric;
    }

    public static Paper genPaper() {
        int randomRange = 10;
        Random rand = new Random();
        Paper tempPaper = new Paper(
                "author" + rand.nextInt(randomRange),
                "name" + rand.nextInt(randomRange),
                rand.nextInt(randomRange),
                rand.nextInt(randomRange),
                rand.nextInt(randomRange),
                rand.nextInt(randomRange),
                Rubric.values()[rand.nextInt(1)]
        );
        return tempPaper;
    }

    @Override
    public String toString() {
        return this.author + "\t" + this.name + "\tViews: " + this.views + "\tYear: " + this.year;
    }

}
