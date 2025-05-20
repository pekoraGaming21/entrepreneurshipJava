public class Artifact{
    private String type;
    private String main;
    private double mainValue;

    private Substat[] substats = new Substat[4];

    public Artifact(String mn, double mstat, Substat one, Substat two, Substat three, Substat four){
        main = mn;
        mainValue = mstat;
        substats[0] = one;
        substats[1] = two;
        substats[2] = three;
        substats[3] = four;
    }

    public String getMain(){
        return main;
    }

    public double getMainV(){
        return mainValue;
    }

    public double getATK(double base){
        double returner = 0.0;
        for (Substat s: substats){
            if (s.getStat().equals("ATK")){
                returner += s.getValue();
            }
            if (s.getStat().equals("PATK")){
                returner += s.getValue()*base;
            }
        }
        return returner;
    }

    public double getDEF(double base){
        double returner = 0.0;
        for (Substat s: substats){
            if (s.getStat().equals("DEF")){
                returner += s.getValue();
            }
            if (s.getStat().equals("PDEF")){
                returner += s.getValue()*base;
            }
        }
        return returner;
    }

    public double getHP(double base){
        double returner = 0.0;
        for (Substat s: substats){
            if (s.getStat().equals("HP")){
                returner += s.getValue();
            }
            if (s.getStat().equals("PHP")){
                returner += s.getValue()*base;
            }
        }
        return returner;
    }

    public double getEM(){
        double returner = 0.0;
        for (Substat s: substats){
            if (s.getStat().equals("EM")){
                returner += s.getValue();
            }
        }
        return returner;
    }

    public String getElemental(){
        for (Substat s: substats){
            if ("PHDMG, PDMG, HDMG, ADMG, EDMG, DDMG, CDMG, GDMG".indexOf(s.getStat()) > 0){
                return s.getStat();
            }
        }
        return "ERRRRRRROR";
    }

    public double getElementalDMG(String element){
        double returner = 0.0;
        for (Substat s: substats){
            if (s.getStat().equals(element)){
                s.getValue();
            }
        }
        return returner;
    }
}