public class Substat{
    private String stat;
    private double value;

    public Substat(String s, double v){
        stat = s;
        value = v;
    }

    public String getStat(){
        return stat;
    }

    public double getValue(){
        return value;
    }
}