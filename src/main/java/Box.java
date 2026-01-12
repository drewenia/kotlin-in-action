public class Box {
    private int weight;

    public Box(int weight) {
        this.weight = weight;
    }

    public Box addWeight(int extra){
        return new Box(this.weight + extra);
    }

    public int getWeight() {
        return weight;
    }
}
