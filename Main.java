import java.util.*;
import java.io.*;
/*
 * 1. What are the meta data for the given data? please list all
 * -rank2024,rank2023,institutionName,location,classificationLocation,classificationSize,classificationFocus,classificationResearch;
    classificationStatus,academicReputationScore,academicReputationRank,employerReputationScore,employerReputationRank;
    facultyStudentScore,facultyStudentRank,citationsPerFacultyScore,citationsPerFacultyRank,internationalFacultyScore,internationalFacultyRank
    internationalStudentsScore,internationalStudentsRank,internationalResearchNetworkScore,internationalResearchNetworkRank,employmentOutcomesScore
    employmentOutcomesRank,sustainabilityScore,sustainabilityRank,overallScore
 * 2. List all the data type of each attribute.
 * - all of these attribute are String.
 */

public class Main{

    static UniData[] university = new UniData[2000];
    static int count = 0;
    public static void main(String[] args)throws FileNotFoundException {
        
        File f = new File("2024 QS World University Rankings 1.2 (For qs.com).csv");
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()){
            String dataL = sc.nextLine();
            StringTokenizer uni = new StringTokenizer(dataL.trim(), ",");
            
            Vector<String> temp = new Vector<>();//columns
            for (int i = 0; i < 28; i++) {
                if (uni.hasMoreTokens()) {
                    temp.add(uni.nextToken().trim());
                } else {
                    temp.add("");
                }
            }

            university[count++] = new UniData(temp);//store
            System.out.println(dataL);
        }
        sc.close();
        Print("ChiangMai University");
        
    }
     public static void Print(String UniversityName) throws FileNotFoundException {
        File file = new File("QS_World University Ranking 2024.csv");//ยัดข้อมูล
        boolean found = false;

        for (int i=0; i<count; i++) {
            if (university[i].getInstitutionName().equalsIgnoreCase(UniversityName)) {
                PrintWriter output = new PrintWriter(file);
                output.print(university[i]);
                output.close();
                found = true;

                break;
            }
        }

        if (!found) {
            System.out.println("University not found");
        }
    }
}
