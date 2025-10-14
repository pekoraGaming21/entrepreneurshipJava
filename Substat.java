public class Substat{
    private String stat;
    private double value;
    private int roll;

    public Substat(String s, double v, int r){
        stat = s;
        value = v;
        roll = r;
    }

    public String toString(){
        return "[" + roll + "] " + stat + " - " + String.valueOf(value);
    }

    public String getStat(){
        return stat;
    }

    public double getValue(){
        return value;
    }

    public int getRoll(){
        return roll;
    }
}