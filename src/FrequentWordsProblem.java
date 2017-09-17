import java.util.ArrayList;
import java.util.Scanner;
class BioInfomatics{
String Name;
int Index;
private void Tester() {
	

}	
}

public class FrequentWordsProblem {
    public static void main(String[] args) {
    	BioInfomatics BioTest = new BioInfomatics();
    	BioTest.Name = "Suganya solution";
    	System.out.println(BioTest.Name);
        String dna = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        System.out.println("Enetr a value");
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        
       
        System.out.println(k);

        ArrayList<String> flow = makeResult(dna, k);

        for (String Make : flow) {
            System.out.print(Make + " "+ "result ");
        }
    }




    public static ArrayList<String> makeResult(String dna, int k) {
        ArrayList<String> flow = new ArrayList<String>();
        int max = 0;

      int Index = dna.length() - k;
        
        
        
        for (int i = 0; i <= Index; i++) {
            String Make = dna.substring(i, k+i); // get a serial pattern.

            if(flow.contains(Make)) // if we were observed this pattern, just continue loop.
                continue;

            // Count pattern occurred times.
            int occurredCount = getPatternPositions(Make, i, dna).size();

            if(occurredCount > max) {
                flow.clear();
                flow.add(Make);
                max = occurredCount;
            } else if(occurredCount == max) {
                flow.add(Make);
            }
        }

        return flow;
    }

    public static ArrayList<Integer> getPatternPositions(String pattern, int startIndex, String genome) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int lastOccurredIndex = startIndex;
        while (lastOccurredIndex != -1) {
            indexes.add(lastOccurredIndex);
            lastOccurredIndex = genome.indexOf(pattern, lastOccurredIndex + 1);
        }
        return indexes;
    }
}