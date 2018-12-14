import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtilities {
    private ArrayList<String> CSVData;
    private int numColumns;

    public CSVUtilities(File csv) {
        this.CSVData = new ArrayList<>();
        Path pathToFile = Paths.get(csv.getPath());
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            this.numColumns = line.split(",").length;
            while (line != null) {
                CSVData.add(line);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * @return an ArrayList with the headers for each column
     */
    public List<String> getColumnHeaders() {
        return new ArrayList<>(Arrays.asList(this.CSVData.get(0).split(",")));
    }

    /**
     * @param column the number column to get data from
     * @return an ArrayList with the data for a column specified
     */
    public List<String> getDataString(int column) {
        ArrayList<String> out = new ArrayList<String>();
        for (int i = 1; i < this.CSVData.size(); i++)
            out.add(this.CSVData.get(i).split(",")[column]);
        return out;
    }

    /**
     * @param column the number column to get data from
     * @return an ArrayList with the data converted to Integer
     */
    public List<Integer> getDataInt(int column) {
        List<String> list = getDataString(column);
        List<Integer> out = new ArrayList<Integer>();
        for (String s : list)
            out.add(Integer.parseInt(s));
        return out;
    }

    /**
     * @param column the number column to get data from
     * @return an ArrayList with the data converted to Double
     */
    public List<Double> getDataDouble(int column) {
        List<String> list = getDataString(column);
        List<Double> out = new ArrayList<Double>();
        for (String s : list)
            out.add(Double.parseDouble(s));
        return out;
    }
}