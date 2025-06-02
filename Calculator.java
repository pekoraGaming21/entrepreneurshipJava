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
    //public double calculateDamage(Object[] DamageStuff)
    public double calculateDamage(String damageHitType, String elementHitType, String critHitType, Character character, String charStat, double charMult, double dmgMult, double add, double bonusDmgMult, int enemyLevel, double enemyRes, double resShred,  String reaction, double reactionBonus)
    {
        if (charStat.equals("ATK"))
        {
            baseDMG = character.getTotalATK() * charMult;
        }
        else if (charStat.equals("HP"))
        {
            baseDMG = character.getTotalHP() * charMult;
        }
        else if (charStat.equals("DEF"))
        {
            baseDMG = character.getTotalDEF() * charMult;
        }
            //baseDMG = (double) DamageStuff[0] * (double) DamageStuff[1];
        baseMult = dmgMult;
        //baseMult = (double) DamageStuff[2];
        baseAddDMG = add;
        //baseAddDMG = (double) DamageStuff[3];

        this.bonusDMGMult = bonusDmgMult;
        //bonusDmgMult = (double) DamageStuff[4];
        bonusDMGMult += character.getElementalDMG(elementHitType);
        // Add NA damage, elemental dmg from goblets etc.

        targetDefMult = (double) (character.getLevel() + 100)/(1 * (enemyLevel + 100) + (character.getLevel() + 100));
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

        if ((reaction.equals("Reverse Melt")) || (reaction.equals("Reverse Vaporize"))){
            ampMult = 1.5 * (1 + 2.78*(character.getEM() / (character.getEM() + 1400)) + reactionBonus);
        } else if ((reaction.equals("Forward Melt")) || (reaction.equals("Forward Vaporize"))){
            ampMult = 2 * (1 + 2.78*(character.getEM() / (character.getEM() + 1400)) + reactionBonus);
        } else {
            ampMult = 1;
        }

        hitType = critHitType;
        critRate = character.getCR();
        if (critRate > 100){
            critRate = 100;
        }
        critDMG = character.getCD();



        // System.out.println("Base DMG: " + baseDMG * baseMult);



        double nonCrit = ((baseDMG * baseMult) + baseAddDMG)* bonusDMGMult * targetDefMult * targetResMult * ampMult;
        if (hitType.equals("NonCrit")){
            return nonCrit;
        } else if (hitType.equals("Average")){
            return (critRate/100) * (1 + (critDMG/100)) * nonCrit + ((100-critRate)/100) * nonCrit;
        } else if (hitType.equals("Crit")){
            return nonCrit * (1 + critDMG/100);
        }
        System.out.println("SOMETHING WRONG WITH CALCULATOR.JAVA");
        return -1;

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