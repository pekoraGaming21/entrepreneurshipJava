import java.util.ArrayList;
import java.util.Arrays;

class NewArtifact
{
    private Artifact newArtifact;
    private Character character;
    private int level;

    public NewArtifact(Artifact newArtifact, Character character, int level)
    {
        this.newArtifact = newArtifact;
        this.character = character;
        this.level = level;
    }

    public double Probability()
    {
        ArrayList<Artifact> ZeroDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FirstDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> SecondDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> ThirdDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FourthDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FifthDegreePossibleArtifacts = new ArrayList<Artifact>();

        ArrayList<Artifact> AllPossibleArtifacts = new ArrayList<Artifact>();


        

        String[] StatList = {
            "HP", "HP", "HP", "HP", "HP", "HP", 
            "PHP", "PHP", "PHP", "PHP", 
            "DEF", "DEF", "DEF", "DEF", "DEF", "DEF",
            "PDEF", "PDEF", "PDEF", "PDEF", 
            "ATK", "ATK", "ATK", "ATK", "ATK", "ATK", 
            "PATK", "PATK", "PATK", "PATK", 
            "EM", "EM", "EM", "EM", 
            "ER", "ER", "ER", "ER", 
            "CR", "CR", "CR", 
            "CD", "CD", "CD"};
        
        

            
        if (newArtifact.getSubstat4() != null)
        {
            ZeroDegreePossibleArtifacts.add(newArtifact);
            FirstDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(ZeroDegreePossibleArtifacts);
            SecondDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(FirstDegreePossibleArtifacts);
            ThirdDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(SecondDegreePossibleArtifacts);
            FourthDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(ThirdDegreePossibleArtifacts);
            FifthDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(FourthDegreePossibleArtifacts);

            System.out.println("Fifth Degree size: " + FifthDegreePossibleArtifacts.size());
            int ArtifactBetterCounter = 0;
            int counter = 0;


            Calculator damage = new Calculator();
            damage.setBase(character.getTotalATK() * 2.805, 1, 0);
            damage.setBonus(1.586);
            damage.setTarget(103, 90, 0.1, 0);
            damage.setAmp(character.getEM(), "Reverse Melt", 0);
            damage.setCritDMG("Average", character.getCR(), character.getCD());
            double oldDamage = damage.calculate();

            for (Artifact artifact : FifthDegreePossibleArtifacts)
            {
                counter++;
                if (counter % 10000 == 0)
                {
                    System.out.println("Counter: " + counter);
                }
                if (isBetterArtifact(artifact, artifact.getType(), character, oldDamage))
                    ArtifactBetterCounter += 1;
            }
            System.out.println("Num of Artifacts Better: " + ArtifactBetterCounter);
            return (double) ArtifactBetterCounter / FifthDegreePossibleArtifacts.size();
        }

        else // Three stats
        {

        }
            
            




            

        
        return -1580;
        // # If newArtifact has 3 stats
        // # First roll creates the 4th stat
        // # Roll the newArtifact 4 times
        // # # Cycle through: Choose first sub add first stat, choose first sub add 2nd stat
    }

    public ArrayList<Artifact> CreateDegreeListPossibleArtifact(ArrayList<Artifact> PastList)
    {
        ArrayList<Artifact> NewList = new ArrayList<Artifact>();

        for (Artifact testArtifact : PastList)
        {
            //Artifact testArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), testArtifact.getSubstat3(), testArtifact.getSubstat4()); 
            for (int sub = 1; sub <= 5; sub++)
            {
                
                for (int stat = 0; stat < 4; stat++)
                {
                    if (sub == 1)
                    {
                        double Adding = ChooseNumberStat(testArtifact.getSubstat1().getStat(), stat);
                        Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), new Substat(testArtifact.getSubstat1().getStat(), testArtifact.getSubstat1().getValue() + Adding), testArtifact.getSubstat2(), testArtifact.getSubstat3(), testArtifact.getSubstat4());
                        
                        NewList.add(addArtifact);
                        
                        // testArtifact.setSubstat1Value(testArtifact.getSubstat1().getValue() - Adding);
                    }    
                    if (sub == 2)
                    {
                        double Adding = ChooseNumberStat(testArtifact.getSubstat2().getStat(), stat);
                        // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() + Adding)

                        Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), new Substat(testArtifact.getSubstat2().getStat(), testArtifact.getSubstat2().getValue() + Adding), testArtifact.getSubstat3(), testArtifact.getSubstat4());

                        NewList.add(addArtifact);
                        // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() - Adding)
                    }
                    if (sub == 3)
                    {
                        double Adding = ChooseNumberStat(testArtifact.getSubstat3().getStat(), stat);
                        // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() + Adding)
                        Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), new Substat(testArtifact.getSubstat3().getStat(), testArtifact.getSubstat3().getValue() + Adding), testArtifact.getSubstat4());

                        NewList.add(addArtifact);
                        // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() - Adding)
                    }
                    if (sub == 4)
                    {
                        double Adding = ChooseNumberStat(testArtifact.getSubstat1().getStat(), stat);
                        // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() + Adding)
                        Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), testArtifact.getSubstat3(), new Substat(testArtifact.getSubstat4().getStat(), testArtifact.getSubstat4().getValue() + Adding));

                        NewList.add(addArtifact);
                        // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() - Adding)
                    }
                }
            }
        }
        return NewList;

    }
    
    
    
    public boolean isBetterArtifact(Artifact artifact, String artifactType, Character character, double oldDamage)
    {
        Artifact oldArtifact = character.getArtifact(artifactType);

        character.setArtifact(artifactType, artifact);
        Calculator damage = new Calculator();
        damage.setBase(character.getTotalATK() * 2.805, 1, 0);
        damage.setBonus(1.586);
        damage.setTarget(103, 90, 0.1, 0);
        damage.setAmp(character.getEM(), "Reverse Melt", 0);
        damage.setCritDMG("Average", character.getCR(), character.getCD());
        double newDamage = damage.calculate();
        character.setArtifact(artifactType, oldArtifact);

        if (newDamage <= oldDamage)
            {return false;}
        else
            {return true;}
    }

    // public RemoveSubstat(String stat, statlist):
    //     // Given the name of the stat and the stalist: 

    //     # Remove a stat completely from the statlist
    //     statcount=statlist.count(stat)
    //     for i in range(statcount):
    //         statlist.remove(stat)
    //     return statlist

    public double ChooseNumberStat(String Substatname, int index)
    {    // Given the name of substat

        // Return a random possible substat value
        double[] HPList ={209.13, 239.00, 269.88, 298.75};
        double[] PHPList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] DEFList = {16.20, 18.52, 20.83, 23.15};
        double[] PDEFList = {0.0510, 0.0583, 0.0656, 0.0729};
        double[] ATKList = {13.62, 15.56, 17.51, 19.45};
        double[] PATKList = {0.0408, 0.0466, 0.0525, 0.0583};
        double[] EMList = {16.32, 18.65, 20.98, 23.31};
        double[] ERList = {4.53, 5.18, 5.83, 6.48};
        double[] CRList = {2.72, 3.11, 3.50, 3.89};
        double[] CDList = {5.44, 6.22, 6.99, 7.77};

        if (Substatname == "HP")
            return HPList[index];
        else if (Substatname == "PHP")
            return PHPList[index];
        else if (Substatname == "DEF")
            return DEFList[index];
        else if (Substatname == "PDEF")
            return PDEFList[index];
        else if (Substatname == "ATK")
            return ATKList[index];
        else if (Substatname == "PATK")
            return PATKList[index];
        else if (Substatname == "EM")
            return EMList[index];
        else if (Substatname == "ER")
            return ERList[index];
        else if (Substatname == "CR")
            return CRList[index];
        else if (Substatname == "CD")
            return CDList[index];
        return -1;
    }

    public double getMainStatNumber(String statname, int level)
    {
            // Given the stat name and level of Artifact

            // Return the appropriate Main Stat Value
            if (statname.equals("HP"))
                return 4780;
            else if (statname.equals("ATK"))
                return 311;
            else if (statname.equals("PHP") || statname.equals("PATK"))
                return 0.466;
            else if (statname.equals("PDEF") || statname.equals("PHDMG"))
                return 0.583;
            else if (statname.equals("EM"))
                return 186.5;
            else if (statname.equals("ER"))
                return 51.8;
            else if (statname.equals("PDMG") || statname.equals("HDMG") || statname.equals("ADMG") || statname.equals("EDMG") || statname.equals("DDMG") || statname.equals("CDMG") || statname.equals("GDMG"))
                return 0.466;
            else if (statname.equals("CR"))
                return 31.1;
            else if (statname.equals("CD"))
                return 62.2;
            else if (statname.equals("HBONUS"))
                return 0.359;
            return -1;
    }
}