package lesson5;

public class ValueData {
    private String header;
    private int data;
    private int data1;

    public ValueData(String header, int data, int data1) {
        this.header = header;
        this.data = data;
        this.data1 = data1;
    }

    public String toString() {
        return header + " " + data + " " + data1;
    }
}