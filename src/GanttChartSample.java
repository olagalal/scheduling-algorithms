import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import osproject.GanttChart.ExtraData;
import static osproject.SJF.a;
import static osproject.SJF.numOfProcess;

// TODO: use date for x-axis
public class GanttChartSample extends Application {
    
    public String color(){
        double x = (Math.random()*10);
        if(x<2)
            return "status-red";
        else if (x<5)
            return "status-green";
        else if (x<8)
            return "status-yellow";
        return "status-blue";
    }
    
    @Override public void start(Stage stage) {

        stage.setTitle("Gantt Chart ");
        
        String[] labels = new String[numOfProcess];
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

        final GanttChart<Number,String> chart = new GanttChart<>(xAxis,yAxis);
        xAxis.setLabel("");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(5);

        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        
        
        for (int i = 0 ; i < numOfProcess ; i++){
            labels[i] = a[i].pid;
        }
        
        
       yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(labels)));
       
        chart.setTitle("Gantt Chart");
        chart.setLegendVisible(false);
        chart.setBlockHeight(50);
        String Label;
        
        
        for (int i = 0 ; i < numOfProcess ; i++){
            Label = labels[i];
            XYChart.Series series1 = new XYChart.Series();
            series1.getData().add(new XYChart.Data(a[i].start_time, Label, new ExtraData( a[i].service_time, color())));
            chart.getData().addAll(series1);
        }
        
        chart.getStylesheets().add(getClass().getResource("ganttchart.css").toExternalForm());

        Scene scene  = new Scene(chart,620,350);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}