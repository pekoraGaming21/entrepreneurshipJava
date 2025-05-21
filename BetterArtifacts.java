public class BetterArtifacts {
    Character character;

    public BetterArtifacts(Character c){
        character = c;
    }

    public double randomize(String type){
        Artifact old = character.getArtifact(type);
        int numWorse = 0;

        Calculator damage = new Calculator();
        damage.setBase(character.getTotalATK() * 2.805, 1, 0);
        damage.setBonus(1.586);
        damage.setTarget(103, 90, 0.1, 0);
        damage.setAmp(character.getEM(), "Reverse Melt", 0);
        damage.setCritDMG("Average", character.getCR(), character.getCD());
        double oldDamage = damage.calculate();

        int sampledArtifacts = 100;

        for (int i = 0; i < sampledArtifacts; i++){
            Artifact newArtifact = RandomArtifact(type);

            character.setArtifact(type, newArtifact);
            
            damage.setBase(character.getTotalATK() * 2.805, 1, 0);
            damage.setBonus(1.586);
            damage.setTarget(103, 90, 0.1, 0);
            damage.setAmp(character.getEM(), "Reverse Melt", 0);
            damage.setCritDMG("Average", character.getCR(), character.getCD());
            double newDamage = damage.calculate();

            if (newDamage <= oldDamage){
                numWorse ++;
                // System.out.println("increment worse artifacts");
            }
        }

        character.setArtifact(type, old);

        return (double) numWorse / sampledArtifacts;
    }
}
