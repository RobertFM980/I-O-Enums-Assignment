package biathlon;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;

public class Athlete implements Comparable<Athlete>{
    private int id;
    private String name;
    private String country;
    private Duration skiTimeResults;
    private String[] shootingResults;
    private Duration totalTimeResults;

    public Athlete(int id, String name, String country, Duration skiTimeResults,String [] shootingResults) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.skiTimeResults = skiTimeResults;
        this.shootingResults=shootingResults;
        this.totalTimeResults = calculationTime();
    }

    private Duration calculationTime(){
        int penaltySecond=0;
        for(String s:shootingResults){
            for(int i=0;i<=s.length()-1;i++)
                if(s.charAt(i)=='o')penaltySecond+=10;
        }
        return skiTimeResults.plusSeconds(penaltySecond);
    }
    public String getName() {
        return name;
    }
    public Duration getTotalTimeResults(){
        return totalTimeResults;
    }

    @Override
    public int compareTo(Athlete o) {
        return this.totalTimeResults.compareTo(o.totalTimeResults);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", skiTimeResults=" + skiTimeResults +
                ", shootingResults=" + Arrays.toString(shootingResults) +
                ", totalTimeResults=" + totalTimeResults +
                '}';
    }
}