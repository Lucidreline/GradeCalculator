import java.util.ArrayList;
import java.util.List;

public class Section {
    
    public Section(String _name, Double _percentWorth, Double _totalPosPointsPerAssignment, List<Double> _grades){
        name = _name;
        percentWorth = _percentWorth;
        totalPosPointsPerAssignment = _totalPosPointsPerAssignment;
        grades = _grades;
        CalculateSectionPercent();
    }

    public void CalculateSectionPercent(){
        Double totalPoints = 0.0;
        for (int i = 0; i < grades.size(); i++)
            totalPoints += grades.get(i);
            
        Double percentage = totalPoints/(grades.size() * totalPosPointsPerAssignment);
        sectionPercentage = percentage * 100;
    }
    
    public List<Double> grades = new ArrayList<>();
    public String name;
    public Double percentWorth, sectionPercentage,totalPosPointsPerAssignment ;

}