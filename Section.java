import java.util.ArrayList;
import java.util.List;

public class Section {
    
    public Section(String _name, Double _percentWorth, Double _totalPosPointsPerAssignment, List<Double> _grades){
        name = _name;
        percentWorth = _percentWorth;
        totalPosPointsPerAssignment = _totalPosPointsPerAssignment;
        grades = _grades;
    }

    public static void CalculateSectionPercent(){
        Double totalPoints = 0.0;
        for (int i = 0; i < grades.size(); i++)
            totalPoints += grades.get(i);
            
        Double percentage = totalPoints/(grades.size() * totalPosPointsPerAssignment);
        sectionPercentage = percentage * 100;
    }
    
    public static List<Double> grades = new ArrayList<>();
    public static String name;
    public static Double percentWorth, sectionPercentage,totalPosPointsPerAssignment ;

}