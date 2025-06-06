public class Runner{
    public static void main(String[] args){
        System.out.println("Running Code");

        String speed = "Fast";


        
        String damageHitType = "NADMG";        
        String elementHitType = "Hydro";
        String critHitType = "Average";
        String charStat = "HP";
        double dmgMult = 1;
        double add = 0;
        double bonusDmgMult = 0; 
        int enemyLevel = 103;
        double enemyRes = 0.1;
        double resShred = 0;  
        String reaction = "Forward Vaporize"; 
        double reactionBonus = 0;

        // Object[] mixedArray = { "Hello", 123, true, 4.5 };


        //Ganyu
        // Artifact[] list = {
        //     new Artifact("Flower", "HP",4780, new Substat("CD", 26.4), new Substat("CR", 7.4), new Substat("PATK", 0.105), new Substat("ATK",16)), 
        //     new Artifact("Feather", "ATK",311,new Substat("ER", 5.8),new Substat("CR", 7.0),new Substat("EM", 79), new Substat("CD", 13.2)),
        //     new Artifact("Sands", "EM", 186.5, new Substat("PDEF", 0.058), new Substat("CR", 8.6), new Substat("PHP", 0.041), new Substat("CD", 24.9)),
        //     new Artifact("Goblet", "CDMG", 0.466, new Substat("HP", 209), new Substat("ATK", 29), new Substat("EM", 42), new Substat("CD", 27.2)),
        //     new Artifact("Circlet", "CD", 62.2, new Substat("PATK", 0.105), new Substat("CR", 7.8), new Substat("ATK", 31), new Substat("EM", 42))
        // };

        //Mualani
        Artifact[] list = {
            new Artifact("Flower", "HP", 4780, new Substat("PHP", 0.192), new Substat("CR", 6.2), new Substat("CD", 6.2), new Substat("EM",35)), 
            new Artifact("Feather", "ATK", 311,new Substat("PDEF", 0.051), new Substat("PHP", 0.140),new Substat("CD", 20.2), new Substat("EM", 44)),
            new Artifact("Sands", "PHP", 0.466, new Substat("HP", 538), new Substat("CR", 3.5), new Substat("EM", 40), new Substat("CD", 29.5)),
            new Artifact("Goblet", "HDMG", 0.466, new Substat("CR", 10.5), new Substat("PHP", 0.047), new Substat("ATK", 18), new Substat("CD", 21.0)),
            new Artifact("Circlet", "CD", 62.2, new Substat("EM", 16), new Substat("CR", 14.0), new Substat("PHP", 0.047), new Substat("DEF", 42))
        };

        
        // Ganyu
        // String[] ExtraStatNames = {"CD", "ATK", "CR"};
        // double[] ExtraStatValues = {38.4, 1377.686, 66.1};

        // Mualani
        String[] ExtraStatNames = {"CR", "CR", "CD", "PHP"};
        double[] ExtraStatValues = {19.2, 40.0, 88.2, 0.20};


        //Character ganyu = new Character("Cryo", 90, 9796.73,334.85,630.21, "Hunter's Path", 541.83, list, ExtraStatNames, ExtraStatValues, speed);
        Character mualani = new Character("Hydro", 90, 15184.93, 181.78, 570.27, "Surf's Up", 541.83, list, ExtraStatNames, ExtraStatValues, speed);

        // System.out.println(mualani.getTotalHP());
        // System.out.println(mualani.getEM());

        BetterArtifacts test = new BetterArtifacts(mualani);

        System.out.println("Probability that a randomly generated Circlet is worse: " + test.randomize("Circlet", speed));

        Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PHP", 0.058));
        
        //Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PATK", 0.058), new Substat("ATK", 19));
       




        NewArtifact function = new NewArtifact(testartifact, mualani, 0);
        System.out.println("Probability that this Artifact is better: " + function.Probability(speed));
        System.out.println("");
        System.out.println("Artifact Input: ");
        System.out.println(testartifact);
    }

   
    

}
