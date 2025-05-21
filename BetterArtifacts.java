import java.util.ArrayList;

public class BetterArtifacts {
    Character character;

    public BetterArtifacts(Character c){
        character = c;
    }

    public double randomize(String type){
        ArrayList<Artifact> BetterArtifacts = new ArrayList<Artifact>();

        Artifact old = character.getArtifact(type);
        int numWorse = 0;

        Calculator damage = new Calculator();
        damage.setBase(character.getTotalATK() * 2.805, 1, 0);
        damage.setBonus(1.586);
        damage.setTarget(103, 90, 0.1, 0);
        damage.setAmp(character.getEM(), "Reverse Melt", 0);
        damage.setCritDMG("Average", character.getCR(), character.getCD());
        double oldDamage = damage.calculate();

        int sampledArtifacts = 10000;

        for (int i = 0; i < sampledArtifacts; i++){
            if (i % 1000 == 0){
                System.out.println("Artifact #" + i + 1);
            }
            Artifact newArtifact = RandomArtifact.create(type);

            character.setArtifact(type, newArtifact);
           

            damage.setBase(character.getTotalATK() * 2.805, 1, 0);
            damage.setBonus(1.586);
            damage.setTarget(103, 90, 0.1, 0);
            damage.setAmp(character.getEM(), "Reverse Melt", 0);
            damage.setCritDMG("Average", character.getCR(), character.getCD());
            double newDamage = damage.calculate();
            
           
            
            if (newDamage <= oldDamage){
                numWorse++;
                // System.out.println("increment worse artifacts")
            }
            else
            {

                BetterArtifacts.add(newArtifact);
                // System.out.println(newArtifact);
                // System.out.println("Char ATK after set: " + character.getTotalATK());
                // System.out.println("Char EM after set: " + character.getEM());
                // System.out.println("Char CR after set: " + character.getCR());
                // System.out.println("Char CD after set: " + character.getCD());
            }
            
        }

        character.setArtifact(type, old);
        System.out.println();
        System.out.println("Artifacts worse: " + numWorse);
        System.out.println();
        System.out.println("Sample Artifact better: ");
        System.out.println(BetterArtifacts.get(0));
        System.out.println();
        return (double) numWorse / sampledArtifacts;
    }
}

