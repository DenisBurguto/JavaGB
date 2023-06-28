package OOPHomeTask1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Animals {
    private String name;

    public Animals(String name, String breed, int age, double height, double weight, String voice, int positionX) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.voice = voice;
        this.positionX = positionX;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", voice='" + voice + '\'' +
                ", positionX=" + positionX +
                '}';
    }

    private String breed;
    private int age;
    private double height;
    private double weight;
    private String voice;
    private int positionX;

    protected void eatMeal(double mealWeight) {
        this.weight += mealWeight;
    }

    protected void letsMakeSomeNoiceB() {
        System.out.println(voice);
    }

    protected void move(int moveMeters) {
        this.positionX += moveMeters;
    }

}
