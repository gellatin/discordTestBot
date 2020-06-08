package reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import net.dv8tion.jda.api.EmbedBuilder;

public class reader {

    public static ArrayList<pilot> read() throws IOException {

        String fileName = "src/main/resources/pilots.csv";
        ArrayList<pilot> pilots = new ArrayList<pilot>();

        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis,
                     StandardCharsets.UTF_8);
             CSVReader reader = new CSVReader(isr)) {
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                pilot newPilot = new pilot(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5],nextLine[6],nextLine[7],nextLine[8],nextLine[9]);
                pilots.add(newPilot);
            }

            //remove title row
            pilots.remove(0);

        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

        return pilots;
    }
}