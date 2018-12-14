import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LineChartSample extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis(1979.0, 2017.0, 1);
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year");
        yAxis.setLabel("Population");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("NYC Population (1979-2017)");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("");
        //populating the series with data
        File file = new File("src/Water_Consumption_In_The_New_York_City.csv");
        CSVUtilities data = new CSVUtilities(file);
        List<Integer> years = data.getDataInt(0);
        List<Double> population = data.getDataDouble(1);
        for (int i = 0; i < years.size(); i++) {
            series.getData().add(new XYChart.Data(years.get(i), population.get(i)));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}