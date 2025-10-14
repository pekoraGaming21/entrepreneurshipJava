public class Runner{
    public static void main(String[] args){
        System.out.println("Running Code");

        String speed = "Fast";

        double probability;
        
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
        // Artifact[] ArtifactLoadout = {
        //     new Artifact("Flower", "HP",4780, new Substat("CD", 26.4), new Substat("CR", 7.4), new Substat("PATK", 0.105), new Substat("ATK",16)), 
        //     new Artifact("Feather", "ATK",311,new Substat("ER", 5.8),new Substat("CR", 7.0),new Substat("EM", 79), new Substat("CD", 13.2)),
        //     new Artifact("Sands", "EM", 186.5, new Substat("PDEF", 0.058), new Substat("CR", 8.6), new Substat("PHP", 0.041), new Substat("CD", 24.9)),
        //     new Artifact("Goblet", "CDMG", 0.466, new Substat("HP", 209), new Substat("ATK", 29), new Substat("EM", 42), new Substat("CD", 27.2)),
        //     new Artifact("Circlet", "CD", 62.2, new Substat("PATK", 0.105), new Substat("CR", 7.8), new Substat("ATK", 31), new Substat("EM", 42))
        // };

        //Mualani
        // 0.32% for better
        // Artifact[] ArtifactLoadout = {
        //     new Artifact("Flower", "HP", 4780, new Substat("PHP", 0.192), new Substat("CR", 6.2), new Substat("CD", 6.2), new Substat("EM",35)), 
        //     new Artifact("Feather", "ATK", 311,new Substat("PDEF", 0.051), new Substat("PHP", 0.140),new Substat("CD", 20.2), new Substat("EM", 44)),
        //     new Artifact("Sands", "PHP", 0.466, new Substat("HP", 538), new Substat("CR", 3.5), new Substat("EM", 40), new Substat("CD", 29.5)),
        //     new Artifact("Goblet", "HDMG", 0.466, new Substat("CR", 10.5), new Substat("PHP", 0.047), new Substat("ATK", 18), new Substat("CD", 21.0)),
        //     new Artifact("Circlet", "CD", 62.2, new Substat("EM", 16), new Substat("CR", 14.0), new Substat("PHP", 0.047), new Substat("DEF", 42))
        // };


        // "top 100" build (with hp circlet)
        Artifact[] ArtifactLoadout = {
            new Artifact("Flower", "HP", 4780, new Substat("PHP", 0.192), new Substat("CR", 6.2), new Substat("CD", 6.2), new Substat("EM",35), "Normal"), 
            new Artifact("Feather", "ATK", 311,new Substat("EM", 23), new Substat("HP", 448), new Substat("CR", 14.0), new Substat("CD", 14.0), "Normal"),
            new Artifact("Sands", "PHP", 0.466, new Substat("HP", 538), new Substat("CR", 3.5), new Substat("EM", 40), new Substat("CD", 29.5), "Normal"),
            new Artifact("Goblet", "HDMG", 0.466, new Substat("CR", 10.5), new Substat("PHP", 0.047), new Substat("ATK", 18), new Substat("CD", 21.0), "Normal"),
            new Artifact("Circlet", "PHP", 0.466, new Substat("CR", 3.5), new Substat("CD", 34.2), new Substat("EM", 42), new Substat("ER", 4.5), "Normal")
        };

        
        // Ganyu
        // String[] ExtraStatStat = {"CD", "ATK", "CR"};
        // double[] ExtraStatValues = {38.4, 1377.686, 66.1};

        // Mualani
        String[] ExtraStatNames = {"Ascension", "Artifact Set", "Weapon Substat", "Weapon Passive"};
        String[] ExtraStatStats = {"CR", "CR", "CD", "PHP"};
        double[] ExtraStatValues = {19.2, 40.0, 88.2, 0.20};


        //Character ganyu = new Character("Cryo", 90, 9796.73,334.85,630.21, "Hunter's Path", 541.83, ArtifactLoadout, ExtraStatStats, ExtraStatValues, speed);
        Character mualani = new Character("Hydro", 90, 15184.93, 181.78, 570.27, "Surf's Up", 541.83, ArtifactLoadout, ExtraStatStats, ExtraStatValues, speed);

        

        // Better Artifact test
        // BetterArtifacts test = new BetterArtifacts(mualani);
        // probability = test.randomize("Flower", speed);
        // System.out.println("Probability that a randomly generated Sands is better: " + probability);
        // System.out.println("Probability that a randomly generated Sands is worse: " + (1 - probability));





        //Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PHP", 0.058));
        //Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PATK", 0.058), new Substat("ATK", 19));
       
        // RV Test
        // String[] AcceptableStats = {"CR", "CD", "EM", "PHP"};
        // System.out.println(ArtifactLoadout[3].getRV(AcceptableStats));


        // NewArtifact Test
        // NewArtifact function = new NewArtifact(testartifact, mualani, 0);
        // System.out.println("Probability that this Artifact is better: " + function.Probability(speed));
        // System.out.println("");
        // System.out.println("Artifact Input: ");
        // System.out.println(testartifact);


        String[] Stats = {"HDMG", "CR", "CD"};

        Artifact newArtifact = ElixirArtifact.create("Goblet", Stats);
        System.out.print(newArtifact);

        System.out.println();


        BetterArtifactsElixir test = new BetterArtifactsElixir(mualani);
        probability = test.randomize("Goblet", Stats, speed);
        System.out.println("Probability that a randomly generated Goblet is better: " + probability);
        System.out.println("Probability that a randomly generated Goblet is worse: " + (1 - probability));

    }

   
    

}
