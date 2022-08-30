package hu.adamsan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    Application appTest = new Application();
    List<String> options=new ArrayList<>(){{
        add("rock");add("paper");add("scissors");
    }};



    @Test
    void checkInputTrue() {
        assertTrue(appTest.CheckInput("scissors"));
        assertTrue(appTest.CheckInput("rock"));
        assertTrue(appTest.CheckInput("paper"));
        //assertTrue(appTest.CheckInput("12458"));
    }
    @Test
    void checkInputFalse() {
        assertFalse(appTest.CheckInput("12458"));
    }

    @Test
    void ComputerMove() {
        assertTrue(options.contains(appTest.ComputerMove()));
        assertTrue(options.contains(appTest.ComputerMove()));
        assertTrue(options.contains(appTest.ComputerMove()));
    }

    @Test
    void checkWinner() {
        assertEquals(appTest.CheckWinner("rock","scissors").get(1),"Player");
        assertEquals(appTest.CheckWinner("rock","paper").get(1),"Computer");
        assertEquals(appTest.CheckWinner("scissors","paper").get(1),"Player");
    }
}