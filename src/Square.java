/**
 * Created by Aravind on 3/31/15.
 */
public class Square {
    public String color;
    public int number;

    public void setNumber(int num) {
        number = num;
    }
    public void setColor(String play) {
        color = play;
    }
    public int getNumber() {
        return number;
    }
    public String getColor() {
        return color;
    }
    public Square(int num, String play) {
        number = num;
        color = play;
    }
    public Square() {
        color = "n";
        number = 0;
    }

}
