import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Formula derived from example outputs: (CGPA * 10) + (CodingScore * 0.5)
        this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
    }

    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }
    public double getCompositeScore() { return compositeScore; }

    @Override
    public int compareTo(Candidate other) {
        // Sort in descending order by comparing 'other' against 'this'
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class PlacementEngine {

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        
        System.out.println(shortlistAndRank(candidates));
    }

    /**
     * Overload 1: CGPA-only quick filter (Threshold: 7.0+)
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    /**
     * Overload 2: Combined filter for borderline cases (Threshold: CGPA 6.5+ AND Coding 60+)
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Filters eligible candidates, ranks them using Arrays.sort, and formats the output.
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null) return "";

        // Pass 1: Count eligible candidates to properly size the output array
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleCount++;
            }
        }

        // Pass 2: Populate the shortlisted array
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[index++] = c;
            }
        }

        // Delegate the entire ranking process to Java's highly optimized standard library
        Arrays.sort(shortlisted);

        // Format the final output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
            
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}