package dev.omuzalevska.toyfactory.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class ConsoleViewTest {

    private ConsoleView consoleView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        consoleView = new ConsoleView();

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testDisplayMainMenu() {

        consoleView.displayMainMenu();
        List<String> expectedLines = List.of(
                "Log in to work as:",
                "1. Elf",
                "2. Santa Claus",
                "3. Exit");

        List<String> actualLines = Arrays.asList(outputStream.toString().split("\\r?\\n"));

        assertLinesMatch(expectedLines, actualLines);
        // String expectedOutput = "Log in to work as:\n" +
        //                         "1. Elf\n" +
        //                         "2. Santa Claus\n" +
        //                         "3. Exit\n";
        // String actualOutput = outputStream.toString();//.trim();
       // assertEquals(expectedOutput, actualOutput);
        //assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testDisplayMenuForElf() {

        consoleView.displayMenuForElf();
        
        List<String> expectedLines = List.of(
                "Toy Manager (Session Type: Elf)",
                "1. Add toy",
                "2. See all toys",
                "3. Delete toy",
                "4. Sign out");

        List<String> actualLines = Arrays.asList(outputStream.toString().split("\\r?\\n"));
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    void testDisplayMenuForSanta() {

        consoleView.displayMenuForSanta();

        List<String> expectedLines = List.of(
                "Toy Manager (Session Type: Santa)",
                "1. See list of GOOD children's toys",
                "2. See list of BAD children's toys",
                "3. Save list of all toys (.csv)",
                "4. Sign out");

        List<String> actualLines = Arrays.asList(outputStream.toString().split("\\r?\\n"));
        assertLinesMatch(expectedLines, actualLines);
    }
}
