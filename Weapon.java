public class Weapon {
    
    private String type;
    private String name;
    private int level;
    private double ATK;

    private String SubstatName;
    private double SubstatValue;

    private String[] SubSubstatName;
    private double[] SubSubstatValue;

    public Weapon(String type, String name, int level, double ATK, String SubstatName, double SubstatValue, String[] SubSubstatName, double[] SubsubstatValue)
    {
        this.type = type;
        this.name = name;
        this.level = level;
        this.ATK = ATK;

        this.SubstatName = SubstatName;
        this.SubstatValue = SubstatValue;

        this.SubSubstatName = SubSubstatName;
        this.SubSubstatValue = SubsubstatValue;
    }


    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public int getLevel()
    {
        return level;
    }

    public double getATK()
    {
        return ATK;
    }

    public String getSubstatName()
    {
        return SubstatName;
    }

    public double getSubstatValue()
    {
        return SubstatValue;
    }

    public String[] getSubSubstatName()
    {
        return SubSubstatName;
    }

    public double[] getSubSubstatValue()
    {
        return SubSubstatValue;
    }
}




