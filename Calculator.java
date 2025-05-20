public class Calculator{
    private double baseDMG;
    private double baseMult;
    private double baseAddDMG;
    
    private double bonusDMGMult;

    private double targetDefMult;
    private double targetResMult;

    private double ampMult;

    private double critDMG;

    public Calculator(){
        System.out.println("jenshin");
    }

    public void setBase(double dmg, double mult, double add){
        baseDMG = dmg;
        baseMult = mult;
        baseAddDMG = add;
    }

    public void setBonus(double bonus){
        bonusDMGMult = bonus;
    }

    public void setTarget(double def, double res){
        targetDefMult = def;
        targetResMult = res;
    }

    public void setAmp(double in){
        ampMult = in;
    }

    public void setCritDMG(double crit){
        critDMG = crit;
    }

    public void calculate(){
        System.out.println(((baseDMG * baseMult) + baseAddDMG)* bonusDMGMult * targetDefMult * targetResMult * ampMult);
    }
}