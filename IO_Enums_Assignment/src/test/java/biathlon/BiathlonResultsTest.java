package biathlon;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiathlonResultsTest {

    @Test
    public void testParseCSV() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = BiathlonResults.parseCSV(csvData);
        assertEquals(3, athletes.size());
        assertEquals("Umar Jorgson", athletes.get(0).getName());
        assertEquals("Jimmy Smiles", athletes.get(1).getName());
        assertEquals("Piotr Smitzer", athletes.get(2).getName());
    }

    @Test
    public void testGetTopThreeAthletes() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = BiathlonResults.parseCSV(csvData);
        List<Athlete> topThree = BiathlonResults.getTopThreeAthletes(athletes);

        assertEquals("Piotr Smitzer", topThree.get(0).getName());
        assertEquals(Duration.ofMinutes(30).plusSeconds(10), topThree.get(0).getTotalTimeResults());

        assertEquals("Jimmy Smiles", topThree.get(1).getName());
        assertEquals(Duration.ofMinutes(30).plusSeconds(15), topThree.get(1).getTotalTimeResults());

        assertEquals("Umar Jorgson", topThree.get(2).getName());
        assertEquals(Duration.ofMinutes(30).plusSeconds(57), topThree.get(2).getTotalTimeResults());
    }
}