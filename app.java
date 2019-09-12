import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {
    public static void main(String args[]) throws FileNotFoundException {
        Section s = new Section("quizes", 10.0, 10.0);
        
        // add all sections into a list called sections to be looped through and added
        // together in overal percentage

        List<Section> sections = new ArrayList<>();
        sections.add(s);
        sections.get(0).EnterGrade(8.0);
        sections.get(0).EnterGrade(10.0);
        System.out.println(CalculateOverallPercentage(sections));

        readFile();

    }

    public static void readFile() throws FileNotFoundException {
        File file = new File("Grades.txt");
        Scanner fileScanner = new Scanner(file);
        boolean enableScan = false;
        String line = "", name = "";
        Double percentWorth, possiblePointsPerAssignment;


        while(fileScanner.hasNextLine()){
            line = fileScanner.nextLine().trim();
            if(line.equals("***") && !enableScan)
                enableScan = true;
            else if(enableScan){
                name = line;
                percentWorth = Double.parseDouble(fileScanner.nextLine());
                line = fileScanner.nextLine();
                possiblePointsPerAssignment = Double.parseDouble(line);
                System.out.println("--- Name: " + name);
                System.out.println("--- Worth: " + percentWorth);
                System.out.println("--- Points: " + possiblePointsPerAssignment);
                while(!line.equals("***") && fileScanner.hasNextLine()){
                    line = fileScanner.nextLine();
                    if(line.equals("***")){
                        //Do nothing SON!
                    }else{
                        System.out.println("--- Grade: " + line);
                    }
                    
                    
                }
                //System.out.println(line);
            }
            
        }
    }


    public static Double CalculateOverallPercentage(List<Section> _sections){
        Double totalAwardedPercent = 0.0, totalPossiblePercent = 0.0;
        for (int i = 0; i < _sections.size(); i++) {
            totalAwardedPercent += (_sections.get(i).percentWorth * (_sections.get(i).sectionPercentage/100));
            totalPossiblePercent += _sections.get(i).percentWorth;
        }
        return (totalAwardedPercent/totalPossiblePercent) * 100;
    }
}