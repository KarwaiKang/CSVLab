import java.io.File;

public class Runner {
    public static void main(String[] args) {
        // Data from https://data.cityofnewyork.us/Environment/Water-Consumption-In-The-New-York-City/ia2d-e54m
        File file = new File("src/Water_Consumption_In_The_New_York_City.csv");
        CSVUtilities data = new CSVUtilities(file);

        System.out.println(data.getColumnHeaders());

        System.out.println(data.getDataInt(0));
        System.out.println(data.getDataString(1));
        System.out.println(data.getDataString(2));
        System.out.println(data.getDataString(3));
    }
}