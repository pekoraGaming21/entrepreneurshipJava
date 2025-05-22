public class Calculator{
    private double baseDMG;
    private double baseMult;
    private double baseAddDMG;
    
    private double bonusDMGMult;

    private double targetDefMult;
    private double targetResMult;

    private double ampMult;

    private double critDMG;
    private double critRate;
    private String hitType;

    public void setBase(double dmg, double mult, double add){
        baseDMG = dmg;
        baseMult = mult;
        baseAddDMG = add;
    }

    public void setBonus(double bonus){
        bonusDMGMult = bonus;
    }

    public void setTarget(int enemyLevel, int charLevel, double enemyRes, double resShred){
        targetDefMult = (double) (charLevel + 100)/(1 * (enemyLevel + 100) + (charLevel + 100));
        targetResMult = enemyRes;
        
        double temp = resShred;
        if ((targetResMult >= 0.75 ) && (targetResMult - resShred > 0.75)){
            targetResMult = 1/(4* enemyRes + 1);
        } else if (targetResMult >= 0.75){
            targetResMult = 1/(4*enemyRes + 1);
        } else if ((targetResMult >= 0) && (targetResMult - resShred < 0)){
            temp = resShred - enemyRes;
            targetResMult = 1 - (-temp/2);
        } else if (targetResMult >= 0){
            targetResMult = 1 - enemyRes;
        } else if (targetResMult < 0){
            targetResMult = 1 - (enemyRes/2);
        }
    }

    public void setAmp(double em, String reaction, double reactionBonus){
        if ((reaction.equals("Reverse Melt")) || (reaction.equals("Reverse Vaporize"))){
            ampMult = 1.5 * (1 + 2.78*(em/(em+1400)) + reactionBonus);
        } else if ((reaction.equals("Forward Melt")) || (reaction.equals("Forward Vaporize"))){
            ampMult = 2 * (1 + 2.78*(em/(em+1400)) + reactionBonus);
        } else {
            ampMult = 1;
        }
    }

    public void setCritDMG(String critHit, double CR, double CD){
        hitType = critHit;
        critRate = CR;
        if (CR > 100){
            critRate = 100;
        }
        critDMG = CD;
    }

    public double calculate(){
        double nonCrit = ((baseDMG * baseMult) + baseAddDMG)* bonusDMGMult * targetDefMult * targetResMult * ampMult;
        if (hitType.equals("NonCrit")){
            return nonCrit;
        } else if (hitType.equals("Average")){
            return (critRate/100) * (1 + (critDMG/100)) * nonCrit + ((100-critRate)/100) * nonCrit;
        } else if (hitType.equals("Crit")){
            return nonCrit * (1 + critDMG/100);
        }
        System.out.println("SOMETHING WRONG WITH CALCULATOR.JAVA");
        return 0.0;
    }
}