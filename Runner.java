public class Runner{
    public static void main(String[] args){
        // Calculator calc = new Calculator();
        // calc.setBase(820*.867, 1.0, 0.0);
        // calc.setBonus(1.35);
        // calc.setTarget(0.48346, 0.7);

        // calc.setAmp(1.0);
        // calc.calculate();
        Artifact[] list = {
            new Artifact("Flower", "HP",4780, new Substat("CD", 26.4), new Substat("CR", 7.4), new Substat("PATK", 0.105), new Substat("ATK",16)), 
            new Artifact("Feather", "ATK",311,new Substat("ER", 5.8),new Substat("CR", 7.0),new Substat("EM", 79), new Substat("CD", 13.2)),
            new Artifact("Sands", "EM", 187, new Substat("PDEF", 0.058), new Substat("CR", 8.6), new Substat("PHP", 0.041), new Substat("CD", 24.9)),
            new Artifact("Goblet", "CDMG", 0.466, new Substat("HP", 209), new Substat("ATK", 29), new Substat("EM", 42), new Substat("CD", 27.2)),
            new Artifact("Circlet", "CD", 62.2, new Substat("PATK", 0.105), new Substat("CR", 7.8), new Substat("ATK", 31), new Substat("EM", 42))
        };
        
        String[] ExtraStatNames = {"ATK", "CR"};
        double[] ExtraStatValues = {1377.686, 66.1};

        Character ganyu = new Character("Cryo", 90, 9796.73,334.85,630.21, "Hunter's Path", 541.83, list, "CD", 38.4, ExtraStatNames, ExtraStatValues);
        // System.out.println(ganyu.getTotalATK());

        BetterArtifacts test = new BetterArtifacts(ganyu);

        System.out.println("Probability that a randomly generated Circlet is worse: " + test.randomize("Circlet"));
        // for (int i = 0; i < 1000000; i++)
        // {
        //     if (i % 10000 == 0)
        //     {
        //         System.out.println("i " + i);
        //     }
        //     Artifact newArtifact = RandomArtifact.create(null);
            
        // }
    }
    
}