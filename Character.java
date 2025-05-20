public class Character {
    private double baseHP;
    private double baseATK;
    private double baseDEF;

    private double totalHP;
    private double totalATK;
    private double totalDEF;
    private double EM;

    private double CR;
    private double CD;

    private double ER;   

    // PHDMG, PDMG, HDMG, ADMG, EDMG, DDMG, CDMG, GDMG
    private double[] elementalDMG = {0, 0, 0, 0, 0, 0, 0, 0};

    private Artifact[] arts = new Artifact[5];

    // In a future update, make it so you can set
    // your character and level and it'll autofill
    public Character(double bhp, double bat, double bdf, Artifact[] a){
        baseHP = bhp;
        baseATK = bat;
        baseDEF = bdf;
        arts = a;

        totalHP = bhp;
        totalATK = bat;
        totalDEF = bdf;

        for (Artifact ar: a){
            totalATK += ar.getATK(baseATK);
            totalDEF += ar.getDEF(baseDEF);
            totalHP += ar.getHP(baseHP);
            switch (ar.getMain()){
                case "HP":
                    totalHP += ar.getMainV();
                    break;
                case "DEF":
                    totalDEF += ar.getMainV();
                    break;
                case "ATK":
                    totalATK += ar.getMainV();
                    break;
                case "PHP":
                    totalHP += ar.getMainV()*baseHP;
                    break;
                case "PDEF":
                    totalDEF += ar.getMainV()*baseDEF;
                    break;
                case "PATK":
                    totalATK += ar.getMainV()*baseATK;
                    break;
                case "EM":
                    EM += ar.getMainV();
                    break;
                case "ER":
                    ER += ar.getMainV();
                    break;
                case "CR":
                    CR += ar.getMainV();
                    break;
                case "CD":
                    CD += ar.getMainV();
                    break;
                case "PHDMG":
                    elementalDMG[0] += ar.getMainV();
                    break;
                case "PDMG":
                    elementalDMG[1] += ar.getMainV();
                    break;
                case "HDMG":
                    elementalDMG[2] += ar.getMainV();
                    break;
                case "ADMG":
                    elementalDMG[3] += ar.getMainV();
                    break;
                case "EDMG":
                    elementalDMG[4] += ar.getMainV();
                    break;
                case "DDMG":
                    elementalDMG[5] += ar.getMainV();
                    break;
                case "CDMG":
                    elementalDMG[6] += ar.getMainV();
                    break;
                case "GDMG":
                    elementalDMG[7] += ar.getMainV();
                    break;
            }
            System.out.println(totalATK);
            System.out.println(totalDEF);
            System.out.println(totalHP);


        }
    }

    public double getTotalATK(){
        return totalATK;
    }

    
}
