package biathlon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.Buffer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiathlonResults {

   public static List<Athlete> parseCSV(String csv){
       List<Athlete> athletes=new ArrayList<>();
       try(BufferedReader reader = new BufferedReader(new StringReader(csv))){
            String line;
            while((line= reader.readLine())!=null){
                String[] separator=line.split(",");
                int athletNumbert=Integer.parseInt(separator[0]);
                String athletName=separator[1];
                String country=separator[2];
                Duration skiTime=parseDurantion(separator[3]);
                String [] shooting={separator[4],separator[5],separator[6]};
                athletes.add(new Athlete(athletNumbert,athletName,country,skiTime,shooting));

            }
       }
       catch  (Exception e) {
           e.getMessage();
       }
       return athletes;
   }
    public static Duration parseDurantion(String s){
       String[] time=s.split(":");
       int min=Integer.parseInt(time[0]);
       int sec=Integer.parseInt(time[1]);
       return Duration.ofMinutes(min).plusSeconds(sec);
    }
    public static List<Athlete> getTopThreeAthletes(List<Athlete> athletes) {
        Collections.sort(athletes);
        return athletes;
    }

    public static void main(String[] args) {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = BiathlonResults.parseCSV(csvData);
        List<Athlete> topThree = BiathlonResults.getTopThreeAthletes(athletes);

        System.out.println("Winner - " + topThree.get(0));
        System.out.println("Runner-up - " + topThree.get(1));
        System.out.println("Third Place - " + topThree.get(2));
    }
}