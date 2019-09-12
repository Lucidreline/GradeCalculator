import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {
    public static void main(String args[]) throws FileNotFoundException {
        List<Section> sections = new ArrayList<>();
        readFileAndLoadList(sections);
        for (int i = 0; i < sections.size(); i++) {
            System.out.println(sections.get(i).name);
        }
    }

    public static void readFileAndLoadList(List<Section> _sections) throws FileNotFoundException {
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
                List<Double> grades = new ArrayList<>();
                name = line;
                percentWorth = Double.parseDouble(fileScanner.nextLine());
                line = fileScanner.nextLine();
                possiblePointsPerAssignment = Double.parseDouble(line);
                // System.out.println("--- Name: " + name);
                // System.out.println("--- Worth: " + percentWorth);
                // System.out.println("--- Points: " + possiblePointsPerAssignment);
                while(!line.equals("***") && fileScanner.hasNextLine()){
                    line = fileScanner.nextLine();
                    if(line.equals("***")){
                        //Do nothing SON!
                        //For som reason this would not work with !line.equals("***")
                    }else{
                        // System.out.println("--- Grade: " + line);
                        grades.add(Double.parseDouble(line.trim()));
                    }
                }
                
                _sections.add(new Section(name, percentWorth, possiblePointsPerAssignment, grades));
                System.out.println("Element 0 name: " + _sections.get(0).name);
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