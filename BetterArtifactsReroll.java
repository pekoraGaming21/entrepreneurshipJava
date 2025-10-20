import java.util.ArrayList;

public class BetterArtifactsReroll 
{
    Character character;

    public BetterArtifactsReroll(Character c){
        character = c;
    }

    public double randomize(Artifact Artifact, String[] Stats, int NumberOfGuarenteedStats, String speed)
    {
        // Take in a level 0 artifact, the two priority substats (and the character)
        // 


        ArrayList<Artifact> ZeroDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FirstDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> SecondDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> ThirdDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FourthDegreePossibleArtifacts = new ArrayList<Artifact>();
        ArrayList<Artifact> FifthDegreePossibleArtifacts = new ArrayList<Artifact>();

        //ArrayList<Artifact> AllPossibleArtifacts = new ArrayList<Artifact>();
        
        
        long duration = 0;
            
        if (Artifact.getSubstat4().getRoll() == 0) // four stat artifact level 0
        {
            System.out.println("Four Substat Artifact");
            // First Degree rolls add up to 1

            ZeroDegreePossibleArtifacts.add(Artifact);
            FirstDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(ZeroDegreePossibleArtifacts, NumberOfGuarenteedStats, Stats);
            NumberOfGuarenteedStats--;
        }
        else // Three stats, level 0;
        {
            // First degree rolls add up to 0
            Artifact FirstArtifact = new Artifact(Artifact.getType(), Artifact.getMain(), Artifact.getMainV(), Artifact.getSubstat1(), Artifact.getSubstat2(), Artifact.getSubstat3(), new Substat(Artifact.getSubstat4().getStat(), Artifact.getSubstat4().getValue(), Artifact.getSubstat4().getRoll() + 1), Artifact.getSet(), Artifact.getSpecial());
            FirstDegreePossibleArtifacts.add(FirstArtifact);

            
        }

        System.out.println("Created First Degree");
        // System.out.println("Artifacts:");
        // for (Artifact artifact : FirstDegreePossibleArtifacts)
        // {
        //     System.out.println(artifact);
        // }
        SecondDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(FirstDegreePossibleArtifacts, NumberOfGuarenteedStats, Stats);
        NumberOfGuarenteedStats--;
        System.out.println("Created Second Degree");
        ThirdDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(SecondDegreePossibleArtifacts, NumberOfGuarenteedStats, Stats);
        NumberOfGuarenteedStats--;
        System.out.println("Created Third Degree (length + " + ThirdDegreePossibleArtifacts.size() + ")");
        FourthDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(ThirdDegreePossibleArtifacts, NumberOfGuarenteedStats, Stats);
        NumberOfGuarenteedStats--;
        System.out.println("Created Fourth Degree (length + " + FourthDegreePossibleArtifacts.size() + ")");
        FifthDegreePossibleArtifacts = CreateDegreeListPossibleArtifact(FourthDegreePossibleArtifacts, NumberOfGuarenteedStats, Stats);
        System.out.println("Created Fifth Degree");



        // if (level == 20)
        // {FifthDegreePossibleArtifacts = ZeroDegreePossibleArtifacts};

        // int artifactcounter = 0;
        // for (Artifact artifact : SecondDegreePossibleArtifacts)
        // {   
        //     artifactcounter++;
        //     if (artifactcounter < 300)
        //     {
        //         System.out.println(artifact);
        //     }
        // }

        System.out.println("Array size: " + FifthDegreePossibleArtifacts.size());
        int ArtifactBetterCounter = 0;
        int counter = 0;


        Calculator damage = new Calculator();

        double oldDamage = damage.calculateDamage("CADMG", "Cryo", "Average", character, "ATK", 2.805, 1, 0, 1.586, 103, 0.1, 0, "Reverse Melt", 0);
        //double oldDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);

        System.out.println("Begin NewArtifact calc");
        for (Artifact artifact : FifthDegreePossibleArtifacts)
        {
            long startTime = System.currentTimeMillis();
            
            counter++;
            if (counter % 500000 == 0)
            {
                System.out.println("Counter: " + counter);
                System.out.println("Total Execution time: " + duration / 1000 + " seconds");
                //System.out.println(artifact);
                
            }
            if (isBetterArtifact(artifact, artifact.getType(), character, oldDamage, speed))
                ArtifactBetterCounter += 1;

            long endTime = System.currentTimeMillis();
            duration += (endTime - startTime); // in nanoseconds
        }
        System.out.println("");
        System.out.println("Num of Artifacts Better: " + ArtifactBetterCounter);
        return (double) ArtifactBetterCounter / FifthDegreePossibleArtifacts.size();
    }

    public ArrayList<Artifact> CreateDegreeListPossibleArtifact(ArrayList<Artifact> PastList, int GuarenteedRolls, String[] GuarenteedStats)
    {
        ArrayList<Artifact> NewList = new ArrayList<Artifact>();

        // 

        for (Artifact testArtifact : PastList)
        {
            if (GuarenteedRolls > 0)
            {
                int[] GuarenteedSubstatNumbers = {testArtifact.getSubstatNumber(GuarenteedStats[0]), testArtifact.getSubstatNumber(GuarenteedStats[1])};
                for (int sub = 0; sub < 2; sub++)
                {
                    for (int stat = 0; stat < 4; stat++) // Cycle through all 4 different number stats of that substat
                    {
                        
                        if (GuarenteedSubstatNumbers[sub] == 1)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat1().getStat(), stat);
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), new Substat(testArtifact.getSubstat1().getStat(), testArtifact.getSubstat1().getValue() + Adding, testArtifact.getSubstat1().getRoll() + 1), testArtifact.getSubstat2(), testArtifact.getSubstat3(), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());
                            
                            NewList.add(addArtifact);
                            
                            // testArtifact.setSubstat1Value(testArtifact.getSubstat1().getValue() - Adding);
                        }    
                        else if (GuarenteedSubstatNumbers[sub] == 2)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat2().getStat(), stat);
                            // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() + Adding)

                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), new Substat(testArtifact.getSubstat2().getStat(), testArtifact.getSubstat2().getValue() + Adding, testArtifact.getSubstat2().getRoll() + 1), testArtifact.getSubstat3(), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() - Adding)
                        }
                        else if (GuarenteedSubstatNumbers[sub] == 3)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat3().getStat(), stat);
                            // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() + Adding)
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), new Substat(testArtifact.getSubstat3().getStat(), testArtifact.getSubstat3().getValue() + Adding, testArtifact.getSubstat3().getRoll() + 1), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() - Adding)
                        }
                        else if (GuarenteedSubstatNumbers[sub] == 4)
                        {
                            
                            double Adding = ChooseNumberStat(testArtifact.getSubstat4().getStat(), stat);
                            
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() + Adding)
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), testArtifact.getSubstat3(), new Substat(testArtifact.getSubstat4().getStat(), testArtifact.getSubstat4().getValue() + Adding, testArtifact.getSubstat4().getRoll() + 1), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() - Adding)
                        }                
                    }
                }
                // Determine what substat corresponds with the wanted stats
                // Cycle through just those two substats, along with the 4 different number stats
            }
            else
            {
                for (int sub = 1; sub <= 4; sub++) // Cycle through Substats
                {
                    

                    for (int stat = 0; stat < 4; stat++) // Cycle through all 4 different number stats of that substat
                    {
                        if (testArtifact.getSubstat4().getRoll() == -1)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat4().getStat(), stat);
                            
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() + Adding)
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), testArtifact.getSubstat3(), new Substat(testArtifact.getSubstat4().getStat(), testArtifact.getSubstat4().getValue() + Adding, testArtifact.getSubstat4().getRoll() + 1), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() - Adding)
                        }
                        
                        else if (sub == 1)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat1().getStat(), stat);
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), new Substat(testArtifact.getSubstat1().getStat(), testArtifact.getSubstat1().getValue() + Adding, testArtifact.getSubstat1().getRoll() + 1), testArtifact.getSubstat2(), testArtifact.getSubstat3(), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());
                            
                            NewList.add(addArtifact);
                            
                            // testArtifact.setSubstat1Value(testArtifact.getSubstat1().getValue() - Adding);
                        }    
                        else if (sub == 2)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat2().getStat(), stat);
                            // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() + Adding)

                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), new Substat(testArtifact.getSubstat2().getStat(), testArtifact.getSubstat2().getValue() + Adding, testArtifact.getSubstat2().getRoll() + 1), testArtifact.getSubstat3(), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat2().setValue(testArtifact.getSubstat2().getValue() - Adding)
                        }
                        else if (sub == 3)
                        {
                            double Adding = ChooseNumberStat(testArtifact.getSubstat3().getStat(), stat);
                            // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() + Adding)
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), new Substat(testArtifact.getSubstat3().getStat(), testArtifact.getSubstat3().getValue() + Adding, testArtifact.getSubstat3().getRoll() + 1), testArtifact.getSubstat4(), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat3().setValue(testArtifact.getSubstat3().getValue() - Adding)
                        }
                        else if (sub == 4)
                        {
                            
                            double Adding = ChooseNumberStat(testArtifact.getSubstat4().getStat(), stat);
                            
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() + Adding)
                            Artifact addArtifact = new Artifact(testArtifact.getType(), testArtifact.getMain(), testArtifact.getMainV(), testArtifact.getSubstat1(), testArtifact.getSubstat2(), testArtifact.getSubstat3(), new Substat(testArtifact.getSubstat4().getStat(), testArtifact.getSubstat4().getValue() + Adding, testArtifact.getSubstat4().getRoll() + 1), testArtifact.getSet(), testArtifact.getSpecial());

                            NewList.add(addArtifact);
                            // testArtifact.getSubstat4().setValue(testArtifact.getSubstat4().getValue() - Adding)
                        }                
                    }
                }
            }
        }
        return NewList;

    }
    
    
    
    public boolean isBetterArtifact(Artifact artifact, String artifactType, Character character, double oldDamage, String speed)
    {
        
        Artifact oldArtifact = character.getArtifact(artifactType);
        
        character.setArtifact(artifactType, oldArtifact, artifact, speed);

        Calculator damage = new Calculator();

        double newDamage = damage.calculateDamage("CADMG", "Cryo", "Average", character, "ATK", 2.805, 1, 0, 1.586, 103, 0.1, 0, "Reverse Melt", 0);
        //double newDamage = damage.calculateDamage("NADMG", "Hydro", "Average", character, "HP", 0.7811, 1, 0, 1.586, 103, 0.1, 0, "Forward Vaporize", 0);
        
        // System.out.println("-------------------");
        // System.out.println("NEW CHARACTER");
        // System.out.println(character);

        character.setArtifact(artifactType, artifact, oldArtifact, speed);
        
        // System.out.println("OLD CHARACTER");
        // System.out.println(character);

        // System.out.println("-------------------");

        // System.out.println("New Damage: " + newDamage);
        // System.out.println("Old Damage: " + oldDamage);
        if (newDamage <= oldDamage)
            {
            //System.out.println("Old Damage: " + oldDamage + " is more than New Damage: " + newDamage);
            return false;}
        else
            // System.out.println("BETTER ARTIFACT: ");
            // System.out.println(artifact);
            {return true;}
            
    }

    public ArrayList<String> RemoveStatFromArray(String Stat, ArrayList<String> StatList)
    {
        // Remove all of a certain stat in the list
        int count = 0;
        for (String stat : StatList)
        {
            if (stat.equals(Stat))
            {count++;}
        }
        for (int i = 0; i < count; i++)
            {StatList.remove(Stat);}

        return StatList;
    }

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
}