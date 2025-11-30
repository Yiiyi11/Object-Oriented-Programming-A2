import java.util.Comparator;

/**
 * Comparator for Visitor objects - sort by age (ascending) then fast pass (descending)
 * Part 4B: Implement sorting for ride history
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * Compare two Visitor objects based on 2 instance variables:
     * 1. First: Age (ascending order - younger visitors first)
     * 2. Second: Fast pass status (descending order - visitors with fast pass first)
     * @param v1 First Visitor to compare
     * @param v2 Second Visitor to compare
     * @return Negative integer, zero, or positive integer as v1 is less than, equal to, or greater than v2
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Step 1: Compare by age (ascending)
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison; // Return age comparison result if ages are different
        }

        // Step 2: If ages are equal, compare by fast pass status (descending: true > false)
        return Boolean.compare(v2.isHasFastPass(), v1.isHasFastPass());
    }
}