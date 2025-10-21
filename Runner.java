import java.util.stream.IntStream;

public class Runner{
    public static void main(String[] args){
        System.out.println("Running Code");

        String speed = "Fast";

        double probability;
        
        // String damageHitType = "NADMG";        
        // String elementHitType = "Hydro";
        // String critHitType = "Average";
        // String charStat = "HP";
        // double dmgMult = 1;
        // double add = 0;
        // double bonusDmgMult = 0; 
        // int enemyLevel = 103;
        // double enemyRes = 0.1;
        // double resShred = 0;  
        // String reaction = "Forward Vaporize"; 
        // double reactionBonus = 0;

        // Object[] mixedArray = { "Hello", 123, true, 4.5 };


        //Ganyu
        Artifact[] GanyuArtifactLoadout = {
            new Artifact("Flower", "HP",4780, new Substat("CR", 10.5, 2), new Substat("CD", 24.9, 3), new Substat("EM", 19, 0), new Substat("PATK", 0.058, 0), "Wanderer's Troupe", "Normal"), 

            //new Artifact("Flower", "HP",4780, new Substat("CR", 10.1, 2), new Substat("CD", 21.8, 2), new Substat("EM", 40, 1), new Substat("PHP", 0.058, 0), "Normal"), 
            new Artifact("Feather", "ATK",311,new Substat("CD", 14.0, 1),new Substat("CR", 9.7, 2),new Substat("ER", 5.2,0), new Substat("EM", 65, 2), "Wanderer's Troupe", "Normal"),
            new Artifact("Sands", "EM", 186.5, new Substat("ATK", 16,0), new Substat("HP", 209, 0), new Substat("CD", 21.8, 2), new Substat("PATK", 0.163, 2), "Wanderer's Troupe", "Normal"),
            new Artifact("Goblet", "CDMG", 0.466, new Substat("HP", 209,0), new Substat("ATK", 29, 1), new Substat("EM", 42, 1), new Substat("CD", 27.2, 3), "Wanderer's Troupe", "Normal"),
            new Artifact("Circlet", "CD", 62.2, new Substat("ATK", 14, 0), new Substat("PHP", 0.058,0), new Substat("EM", 82, 3), new Substat("CR", 9.7, 2), "Shimenawa's Reminiscence", "Normal")
        };

        // "top 100" build (with hp circlet)
        Artifact[] MualaniArtifactLoadout = {
            new Artifact("Flower", "HP", 4780, new Substat("PHP", 0.192, 3), new Substat("CR", 6.2, 1), new Substat("CD", 6.2, 0), new Substat("EM",35, 1), "Obsidian Codex", "Normal"), 
            new Artifact("Feather", "ATK", 311,new Substat("EM", 23, 0), new Substat("HP", 448, 1), new Substat("CR", 14.0, 3), new Substat("CD", 14.0, 1), "Obsidian Codex", "Normal"),
            new Artifact("Sands", "PHP", 0.466, new Substat("HP", 538, 1), new Substat("CR", 3.5,0), new Substat("EM", 40, 1), new Substat("CD", 29.5, 3), "Wanderer's Troupe", "Normal"),
            new Artifact("Goblet", "HDMG", 0.466, new Substat("CR", 10.5, 2), new Substat("PHP", 0.047, 0), new Substat("ATK", 18, 0), new Substat("CD", 21.0, 2), "Obsidian Codex", "Normal"),
            new Artifact("Circlet", "PHP", 0.466, new Substat("CR", 3.5,0), new Substat("CD", 34.2, 4), new Substat("EM", 42, 1), new Substat("ER", 4., 0), "Obsidian Codex", "Normal")
        };

        
        // Ganyu
        //String[] ExtraStatNames = {"Ascension", "Bennett Burst", "Weapon Substat", "CharacterTalent1", "Weapon Subsubstat", "Artifact"};
        // String[] ExtraStatStats = {"CD", "ATK", "CR", "CR", "CDMG", "EM"};
        // double[] ExtraStatValues = {38.4, 1377.686, 44.1, 20.0, 0.12, 80};

        
        String[] ExtraStatNames = {"Ascension", "Bennett Burst", "Weapon Substat", "CharacterTalent1", "Weapon Subsubstat", "Artifact"};
        String[] ExtraStatStats = {"CD", "CR", "CR", "CDMG", "EM"};
        double[] ExtraStatValues = {38.4, 44.1, 20.0, 0.12, 80};

        // Mualani
        //String[] ExtraStatNames = {"Ascension", "Artifact Set", "Weapon Substat", "Weapon Subsubstat"};
        // String[] ExtraStatStats = {"CR", "CR", "CD", "PHP"};
        // double[] ExtraStatValues = {19.2, 40.0, 88.2, 0.20};



        Character ganyu = new Character("Cryo", 90, 9796.73,334.85,630.21, "Bow", "Hunter's Path", 541.83, GanyuArtifactLoadout, ExtraStatStats, ExtraStatValues, speed);
        Character mualani = new Character("Hydro", 90, 15184.93, 181.78, 570.27, "Catalyst", "Surf's Up", 541.83, MualaniArtifactLoadout, ExtraStatStats, ExtraStatValues, speed);

        

        // Better Artifact test
        // BetterArtifacts test = new BetterArtifacts(mualani);
        // probability = test.randomize("Flower", speed);
        // System.out.println("Probability that a randomly generated Sands is better: " + probability);
        // System.out.println("Probability that a randomly generated Sands is worse: " + (1 - probability));





        //Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PHP", 0.058));
        //Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("CR", 3.9), new Substat("EM", 23), new Substat("PATK", 0.058), new Substat("ATK", 19));
        Artifact testartifact = new Artifact("Circlet", "CD", 62.2, new Substat("PATK", 0.041, 0), new Substat("PDEF", 0.073, 0), new Substat("CR", 2.7, 0), new Substat("EM", 16, 0), "Emblem of Severed Fate", "Normal");

        // RV Test
        String[] AcceptableStats = {"CR", "CD", "EM", "PATK"};
        // System.out.println(ArtifactLoadout[3].getRV(AcceptableStats));


        // NewArtifact Test
        // NewArtifact function = new NewArtifact(testartifact, mualani, 0);
        // System.out.println("Probability that this Artifact is better: " + function.Probability(speed));
        // System.out.println("");
        // System.out.println("Artifact Input: ");
        // System.out.println(testartifact);


        //String[] Stats = {"HDMG", "CR", "CD"};
        String[] Stats = {"CDMG", "EM", "CD"};
        String[] WantedStats = {"PATK", "EM"};
        // Artifact newArtifact = ElixirArtifact.create("Goblet", Stats);
        // System.out.print(newArtifact);

        System.out.println();


        // BetterArtifactsElixir test = new BetterArtifactsElixir(ganyu);
        // probability = test.randomize("Wanderer's Troupe", "Goblet", Stats, speed);
        // System.out.println("Probability that a randomly generated Goblet is better: " + probability);
        // System.out.println("Probability that a randomly generated Goblet is worse: " + (1 - probability));

        ganyu.AdvancedPrint();

        // BetterArtifactsReroll test = new BetterArtifactsReroll(ganyu);
        // probability = test.randomize(testartifact, WantedStats, 2  , speed);
        // System.out.println("Probability that a randomly generated Circlet is better: " + probability);
        // System.out.println("Probability that a randomly generated Circlet is worse: " + (1 - probability));
        

    }
}
