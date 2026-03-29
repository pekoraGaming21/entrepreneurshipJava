import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Team {

    private Character character1;
    private Character character2;
    private Character character3;
    private Character character4;

    private String[] ExtraChar1StatNames;
    private String[] ExtraChar1StatValues;
    private String[] ExtraChar2StatNames;
    private String[] ExtraChar2StatValues;
    private String[] ExtraChar3StatNames;
    private String[] ExtraChar3StatValues;
    private String[] ExtraChar4StatNames;
    private String[] ExtraChar4StatValues;

    private String[] ExtraTeamStatNames;
    private double[] ExtraTeamStatValues;


    public Team(Character character1, Character character2, Character character3, Character character4)
    {
        this.character1 = character1;
        this.character2 = character2;
        this.character3 = character3;
        this.character4 = character4;

    }

    public void Run()
    {
        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        while (run)
        {
            System.out.println("What do");
            System.out.println("Calculate | Add Char | Remove Char | Add Artifact | Change Character");
            String Decision = scanner.nextLine();

            switch (Decision)
            {
                case "Calculate":
                    System.out.println("What do");
                    System.out.println("Calc for Real | Enable/Disable Talents");
                    String CalcDecision = scanner.nextLine();

                    switch (CalcDecision)
                    {
                        case "Calc for Real":
                        case "Enable/Disable Talents":
                        
                    }
                    break;
                case "Add Char":

                    System.out.println("Input Character Name");
                    String Name = scanner.nextLine();
                    // Input a character name to add
                    // Adds a character farthest right that doesnt leave space inbetween
                    // This character has no weapon, no artifacts, lowest upgrades and level 1
                    break;
                case "Remove Char":
                    // Select what team position to remove
                    // Move over all teamates to the right
                    break;
                case "Add Artifact":
                    // Add artifact to an arraylist
                    break;
                case "Change Character":
                    System.out.println("Which Character");
                    String TeamPosition = scanner.nextLine();

                    System.out.println("What do");
                    System.out.println("Calculate | Add Char | Remove Char | Add Artifact | Change Character");
                    String CharDecision = scanner.nextLine();

                    switch (CharDecision)
                    {
                        case "Change Artifact":

                            break;
                        case "Change Weapon":
                            System.out.println("This doesnt work yet it does nothing");
                            break;
                        case "Change Stat":
                            System.out.println("This doesn't work yet it does nothing (the next input does nothing)");
                            System.out.println("What do");
                            System.out.println("Change Level | Change Talent | Change Constellation");
                            String StatDecision = scanner.nextLine();
                            switch (StatDecision)
                            {
                                case "Change Level":

                                    break;
                                case "Change Talent":

                                    break;
                                case "Change Constellation":

                                    break;
                            }


                    }
                    break;
            }
        }



        scanner.close();
    }

    public void ElementalResonance()
    {
        // get elements of 4 characters, add stats to characters
    }


    // public double[] getCharacter() // Think about creating a file specifically for long datasets like these
    // {
    //     Map<String,double[]> myMap = new HashMap<String,double[]>();
    //     // myMap.put();
    //     // myMap.put("Amber", "d");
    // }

    // public Weapon getWeapon()
    // {

    // }

    public Artifact AskArtifact()
    {
        Scanner ArtifactScanner = new Scanner(System.in);

        System.out.println("Artifact Set ");
        String ArtifactSet = ArtifactScanner.nextLine();
        
        System.out.println("Normal or Elixir");
        String Special = ArtifactScanner.nextLine();

        System.out.println("Artifact Type");
        String ArtifactType = ArtifactScanner.nextLine();        

        System.out.println("Main Stat Name: ");
        String MainStatName = ArtifactScanner.nextLine();
        System.out.println("Main Stat Value: ");
        String MainStatValue = ArtifactScanner.nextLine(); 

        System.out.println("Stat 1 Name: ");
        String StatName1 = ArtifactScanner.nextLine();
        System.out.println("Stat 1 Value: ");
        String StatValue1 = ArtifactScanner.nextLine(); 
        System.out.println("Stat 1 Roll: ");
        String StatRoll1 = ArtifactScanner.nextLine();

        System.out.println("Stat 2 Name: ");
        String StatName2 = ArtifactScanner.nextLine();
        System.out.println("Stat 2 Value: ");
        String StatValue2 = ArtifactScanner.nextLine(); 
        System.out.println("Stat 1 Roll: ");
        String StatRoll2 = ArtifactScanner.nextLine();

        System.out.println("Stat 3 Name: ");
        String StatName3 = ArtifactScanner.nextLine();
        System.out.println("Stat 3 Value: ");
        String StatValue3 = ArtifactScanner.nextLine(); 
        System.out.println("Stat 1 Roll: ");
        String StatRoll3 = ArtifactScanner.nextLine();

        System.out.println("Stat 4 Name: ");
        String StatName4 = ArtifactScanner.nextLine();
        System.out.println("Stat 4 Value: ");
        String StatValue4 = ArtifactScanner.nextLine(); 
        System.out.println("Stat 1 Roll: ");
        String StatRoll4 = ArtifactScanner.nextLine();

        ArtifactScanner.close();

        Artifact artifact = new Artifact(ArtifactType, MainStatName, Double.parseDouble(MainStatValue), new Substat(StatName1, Double.parseDouble(StatValue1), Integer.parseInt(StatRoll1)), new Substat(StatName2, Double.parseDouble(StatValue2), Integer.parseInt(StatRoll2)), new Substat(StatName3, Double.parseDouble(StatValue3), Integer.parseInt(StatRoll3)), new Substat(StatName4, Double.parseDouble(StatValue4), Integer.parseInt(StatRoll4)), ArtifactSet, Special);
        return artifact;
    }
}
