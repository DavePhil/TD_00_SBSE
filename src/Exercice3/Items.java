package Exercice3;

public class Items {
    private int value;
    private int weight;

    public Items(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
