/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.view;

import kata6.model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class HistogramDisplay extends ApplicationFrame{
    public Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        
        pack();
        
    }
   public void execute(){
       setVisible(true);
   }
   private JPanel createPanel(){
      ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
      setPreferredSize(new Dimension(500,400));
      return chartpanel;
   }
   private JFreeChart createChart(DefaultCategoryDataset dataSet){
       JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart","Dominios email"
               ,"Nº de emails",dataSet,PlotOrientation.VERTICAL,false,rootPaneCheckingEnabled, rootPaneCheckingEnabled);
       return chart;
   }
   private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet= new DefaultCategoryDataset();
        for(String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key),"",key);
        }
        return dataSet;
       
   }
   
    
}