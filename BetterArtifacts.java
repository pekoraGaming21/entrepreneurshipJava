import java.util.ArrayList;

public class BetterArtifacts {
    Character character;

    public BetterArtifacts(Character c){
        character = c;
    }

    public double randomize(String type, String speed){
        ArrayList<Artifact> BetterArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> WorseArtifacts = new ArrayList<Artifact>();

        int numWorse = 0;
        int numBetter = 0;

        Artifact old = character.getArtifact(type);

        Calculator damage = new Calculator();

        double oldDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);

        int sampledArtifacts = 1000000;

        for (int i = 0; i < sampledArtifacts; i++){
            if (i % 100000 == 0){
                System.out.println("Artifact #" + i);
            }
            Artifact newArtifact = RandomArtifact.create(type);

            character.setArtifact(type, newArtifact, speed);

            double newDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);

            if (newDamage <= oldDamage)
            {
                numWorse++;
                WorseArtifacts.add(newArtifact);
            }

            else
            {
                BetterArtifacts.add(newArtifact);
                numBetter++;
                // if (Math.random() >= 0.99)
                // {
                //     System.out.println("BETTER Artifact: ");
                //     System.out.println(newArtifact);
                //     System.out.println("New Damage: " + newDamage);
                //     System.out.println("Old Damage: " + oldDamage);
                // }

            }
        }

        character.setArtifact(type, old, speed);
        System.out.println();
        System.out.println("Artifacts worse: " + numWorse);
        System.out.println();
        System.out.println("Sample Artifact better: ");
        System.out.println(BetterArtifacts.get(0));
        System.out.println();
        System.out.println("Sample Artifact worse: ");
        System.out.println(WorseArtifacts.get(0));

        return (double) numBetter / sampledArtifacts;
    }
}

