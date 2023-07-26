package main.java.com.renan.jogogourmet.entities;

public class Food {

    private String name;

    private Food match;

    private Food noMatch;


    public Food() {
    }

    public Food(String name, Food match, Food noMatch) {
        this.name = name;
        this.match = match;
        this.noMatch = noMatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getMatch() {
        return match;
    }

    public void setMatch(Food match) {
        this.match = match;
    }

    public Food getNoMatch() {
        return noMatch;
    }

    public void setNoMatch(Food noMatch) {
        this.noMatch = noMatch;
    }
}
