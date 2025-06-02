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

        Artifact old = character.getArtifact(type);

        Calculator damage = new Calculator();

        double oldDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);


        // damage.setBase(character.getTotalATK() * 2.805, 1, 0);
        // damage.setBonus(1.586);
        // damage.setTarget(103, 90, 0.1, 0);
        // damage.setAmp(character.getEM(), "Reverse Melt", 0);
        // damage.setCritDMG("Average", character.getCR(), character.getCD());
        // double oldDamage = damage.calculate();

        int sampledArtifacts = 1000000;

        for (int i = 0; i < sampledArtifacts; i++){
            if (i % 100000 == 0){
                System.out.println("Artifact #" + i);
            }
            Artifact newArtifact = RandomArtifact.create(type);

            // System.out.println("------------");

            // System.out.println("CHARACTER BEFORE");
            // System.out.println("Character HP: " + character.getEM());
            // System.out.println("Character Ele DMG: " + character.getElementalDMG("Hydro"));

            character.setArtifact(type, newArtifact, speed);

            // System.out.println("CHARACTER AFTER");
            // System.out.println("Character HP: " + character.getCD());
            // System.out.println("Character Ele DMG: " + character.getElementalDMG("Hydro"));


            // System.out.println("------------");

            double newDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);


            // damage.setBase(character.getTotalATK() * 2.805, 1, 0);
            // damage.setBonus(1.586);
            // damage.setTarget(103, 90, 0.1, 0);
            // damage.setAmp(character.getEM(), "Reverse Melt", 0);
            // damage.setCritDMG("Average", character.getCR(), character.getCD());
            // double newDamage = damage.calculate();
            if (i % 500000 == 0){
                System.out.println("New Artifact: ");
                System.out.println(newArtifact);
                System.out.println("New Damage: " + newDamage);
                System.out.println("Old Damage: " + oldDamage);

            }
            if (newDamage <= oldDamage)
            {
                numWorse++;
                WorseArtifacts.add(newArtifact);
            }

            else
            {
                BetterArtifacts.add(newArtifact);
                // System.out.println("BETTER Artifact: ");
                // System.out.println(newArtifact);
                // System.out.println("New Damage: " + newDamage);
                // System.out.println("Old Damage: " + oldDamage);

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

        return (double) numWorse / sampledArtifacts;
    }
}

