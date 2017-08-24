package econHelp.econModel.econMicro;


import java.text.DecimalFormat;

import javafx.beans.binding.Bindings;
import javafx.geometry.*;

import javafx.scene.chart.NumberAxis;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
/**
 * @author EconTeam(UMASS BOSTON)
 *This class is responsible for drawing the plot of slope according to the values passed on in constructor.
 *It also has public methods to Change the co-ordinates and get Pane that has the plot of the Slope graph.
 */
public class SlopeGraph {
	double x1;
	double x2;
	double y1;
	double y2;
	/**
	 * Constructor for the SlopeGraph.
	 * @param X1
	 * @param Y1
	 * @param X2
	 * @param Y2
	 */
	 public SlopeGraph(double X1, double Y1, double X2, double Y2){
		 this.x1 = X1;
		 this.x2 = X2;
		 this.y2 = Y2;
		 this.y1 = Y1;
		 }
	 /**
	  * Method to change the co-ordinates.
	  * @param X1
	  * @param Y1
	  * @param X2
	  * @param Y2
	  */
	 public void ChangeValues(double X1, double Y1, double X2, double Y2){
		 this.x1 = X1;
		 this.x2 = X2;
		 this.y2 = Y2;
		 this.y1 = Y1;
		 
	 }
	 
	 /**Creates a variable axis of type Axes which defines the X and Y axis.
	  * Creates a variable plot of type Plot which plots the graph on the axis.
	  * @return Stack Pane
	  */
	 public Pane get_plot(){
		 double max_axis = Math.abs(x2);
         double unit = 100;
         double adj_axis ;
         // Fining the maximum coordinate so that we can set the value of axes limit larger than the maximum coordinate value( +ve or -ve)
         // [Thats why we are using Math.abs()
         if (Math.abs(x1) > Math.abs(x2)) { max_axis = Math.abs(x1);}
         if (Math.abs(y1) > max_axis) { max_axis = Math.abs(y1);}
         if (Math.abs(y2) > max_axis) { max_axis = Math.abs(y2);}
         
         System.out.println ("max" + max_axis);
         if (x1 == 0 && x2 == 0 && y1 == 0 && y2 == 0){
        	 adj_axis = 1;
         }
         else {
         adj_axis = 1.5 * max_axis ;
         }
         int length = String.valueOf(adj_axis).length();
         System.out.println(length);
         System.out.println("adj axis " + adj_axis);
        
         System.out.println("tic unit " + unit);
         System.out.println("print spacing " + max_axis/10);
         Axes axes = new Axes(
      		   400, 400,
               -adj_axis, adj_axis, unit, // X axis units and unit spacing
               -adj_axis, adj_axis, unit  // y-axis units and unit spacing
        	   );

	      
	      Plot plot = new Plot( x1, x2, y1, y2, -adj_axis, adj_axis, max_axis/10, axes);    	              	   
	      StackPane layout = new StackPane(plot);
	      layout.setPadding(new Insets(20));
	      layout.setStyle("-fx-background-color:#0a1116;");
	      return layout;
		 
		 
	 }
	 /**
	  * 
	  *
	  */

    class Axes extends Pane {
        private NumberAxis xAxis;
        private NumberAxis yAxis;

        public Axes(
                int width, int height,
                double xLow, double xHi, double xTickUnit,
                double yLow, double yHi, double yTickUnit
        ) {
            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(width, height);
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            // x-Axis definitions:
            xAxis = new NumberAxis(xLow, xHi, 0);
            xAxis.setSide(Side.BOTTOM);
            xAxis.setMinorTickVisible(false);
            xAxis.setPrefWidth(width);
            xAxis.setLayoutY(height / 2);
            xAxis.setTickLabelFill(Color.web("#0a1116",1.0));
            
           //y - Axis definitions:
            yAxis = new NumberAxis(yLow, yHi, 0);
            yAxis.setTickLength(0);
            yAxis.setTickLabelFill(Color.web("#0a1116", 1.0));
            yAxis.setSide(Side.LEFT);
            yAxis.setMinorTickVisible(false);
            yAxis.setPrefHeight(height);
            yAxis.layoutXProperty().bind(
                Bindings.subtract(
                    (width / 2) + 1,
                    yAxis.widthProperty()
                )
            );

            getChildren().setAll(xAxis, yAxis);
        }

        public NumberAxis getXAxis() {
            return xAxis;
        }

        public NumberAxis getYAxis() {
            return yAxis;
        }
    }
/**
 * This class is responsible for plotting the Graph in the Axes
 * It implements the Class Pane.
 */
    class Plot extends Pane {
        /**
         * Constructor for a new Plot
         * @param x1
         * @param x2
         * @param y1
         * @param y2
         * @param Min
         * @param Max
         * @param Inc
         * @param axes
         */
    	public Plot(
               double x1, double x2, double y1, double y2,
                double Min, double Max, double Inc,
                Axes axes
        ) {
    		/**
    		 *  Scaling the arrow heads with respect to  Maximum axis value.
    		 */
            double scaleFactor = Max / 50; 
        	/**
        	 * Path defines the line connecting the two points for with the slope is being determined.
        	 */
            Path path = new Path();		 
            /**
             *  Defines the vertical line to the slope line.
             */
            Path line1 = new Path();
            /**
             * Defines the horizontal line to the slope line.
             */
            Path line2 = new Path();	
            /**
            *Description of path line
            */
            path.setStrokeWidth(1);
            path.setStroke(Color.ORANGE);
            path.setStrokeWidth(2);
            /**
             * Descriptions of line1 and line2.
             */
            line1.setStroke(Color.RED);
            line2.setStroke(Color.RED);                  
            line1.setStrokeWidth(0.5);
            line2.setStrokeWidth(0.5);
            /**
             * Defines the Rectangle where the all the plots will be drawn.
             */
            path.setClip(
                    new Rectangle(
                           0, 0, 
                            axes.getPrefWidth(), 
                            axes.getPrefHeight()
                    )
            );
            /**
             * Defines the slope of the line with given Co-ordinates.
             */
            double m = (y2 - y1)/(x2 - x1); 		 
            /**
             * Defines the y- intercept.
             */
            double c = y2 - (m * x2);			   
           /**
            *The Circle cc represents first point.
            **/
            Circle cc = new Circle(mapX(x1, axes), mapY(y1,axes), 2, Color.RED);   
            /**
             *The Circle cc2 represents the second point.
             **/
            Circle cc2 = new Circle(mapX(x2, axes), mapY(y2,axes), 2, Color.RED); 
            /**
             *This is for proper formatting of displayed coordinate numbers.
             *Example: 
             *If the Number is 5.0 is it displays 5. 
             *If the number is 5.671 it displays 5.67 on the graph.
             */
            DecimalFormat df = new DecimalFormat("###.##");
            /**
             * coordinate1 defines the text field where first coordinate will be displayed on the graph.
             */
            Text coordinate1 = new Text(mapX(x1+1*scaleFactor, axes), mapY(y1+1*scaleFactor, axes),"("+df.format(x1)+" , "+df.format(y1)+")");
            coordinate1.setFill(Color.WHITE);
            /**
             * coordinate1 defines the text field where second coordinate will be displayed on the graph.
             */
            Text coordinate2 = new Text(mapX(x2+1*scaleFactor, axes), mapY(y2+1*scaleFactor, axes),"("+df.format(x2)+" , "+df.format(y2)+")");
            coordinate2.setFill(Color.WHITE);
   
		     /**
		      * If x2 = x1 then there will be divide by zero error and the graph wont plot anything.
		       *But x1 = x2 means the graph must be perpendicular to the x-axis.
		       *So the "if-else" conditions are used to plot the perpendicular line, if the slope is infinity.
		       */
            if (x2 != x1) {
            	 	/**
            	 	 * Initializes the point to start of the graph which starts from the Min value as x
            	  	*/
            		double x = Min;
            		/**
            	 	 * initializes y coordinate, determined my the formula y = mx +c. 
                     * The values of m and c were previously calculated and stored respectively.
                     */  
            		double y = m*x + c;
                   
		            path.getElements().add(new MoveTo(mapX(x, axes), mapY(y, axes))); 
		            																     															   
		           /**
		           * x is incremented by a certain value that was passed to the function.
		           */
		            x += Inc;      
		            /**
		             * The while loop runs as long as x is less than Maximum value (i.e. adj_axis calculated above in the code).
		             */
		            while (x < Max) {    
		               /*
		                * Continually change value of y in each iteration of the loop.
		                */
		            	y = m*x + c;
		            	/**
		            	 * Draw new line to the next point.
		            	 */
		                path.getElements().add( new LineTo( mapX(x, axes), mapY(y, axes)));	
		                /**
		                 * x is incremented by a certain value tha in each iteration of the loop.
		                 */
		                x += Inc;
		            }
		           /**
		            * Temporary variable used for substution.
		            */
		            double Sub;
		           /**
		            * //This if statement is for the red lines to ALWAYS be below the main slope line.
		            */
		            if(y1 < y2) {			
		               	Sub = x1; x1 = x2; x2 = Sub;
		            	Sub = y1; y1 = y2; y2 = Sub;
		            	line1.getElements().add(new MoveTo(mapX(x1, axes), mapY(y2, axes)));
				        line2.getElements().add(new MoveTo(mapX(x1, axes), mapY(y2, axes)));
				       }
		        	line1.getElements().add(new MoveTo(mapX(x1, axes), mapY(y2, axes)));
			        line2.getElements().add(new MoveTo(mapX(x1, axes), mapY(y2, axes)));
				    line1.getElements().add(new LineTo(mapX(x1, axes), mapY(y1, axes)));                                                                        
				    line2.getElements().add(new LineTo(mapX(x2, axes), mapY(y2, axes)));
				       
				    Sub = x1; x1 = x2; x2 = Sub;
				    Sub = y1; y1 = y2; y2 = Sub;
            }
            /**
             * This Else statement is to  display the graph even if the value of slope becomes infinity.
             * When the value of m is infinity( x1 = x2 ) we wont be able to plot the graph.
             * The following code draws a line parallel to the Y-Axis with a constant value of x.
             * It is independent of m as we are not using m anywhere inside this else statement.
             */
            else if(x1 == x2 && y1 != y2){		
            	double x = x1;
            	double y = Min;
            	
             path.getElements().add(new MoveTo(mapX(x, axes), mapY(y, axes)));
             y += Inc;
             while (y < Max) {
            	 path.getElements().add( new LineTo( mapX(x, axes), mapY(y, axes) ));
	                y += Inc;
	            }  
            }
           
            Path xxx = new Path();
            xxx.setStroke(Color.TEAL);
            xxx.setStrokeWidth(1);
            xxx.getElements().add(new MoveTo(mapX(Min, axes), mapY(0, axes)));
            xxx.getElements().add(
                    new LineTo(
                            mapX(Max, axes), mapY(0, axes)
                    )
            );
            Path yyy = new Path();
            yyy.setStroke(Color.TEAL);
            yyy.setStrokeWidth(1);
            yyy.getElements().add(new MoveTo(mapX(0, axes), mapY(Min, axes)));
            yyy.getElements().add(
                    new LineTo(
                            mapX(0, axes), mapY(Max, axes)
                    )
            );
            

            Polygon upArrow = new Polygon();
            upArrow.getPoints().addAll(new Double[]{
            	   mapX(0,axes), mapY(Max+1*scaleFactor, axes),
            	   mapX(0-0.5*scaleFactor,axes), mapY(Max-2*scaleFactor, axes),
            	   mapX(0+0.5*scaleFactor,axes), mapY(Max-2*scaleFactor, axes)});
            upArrow.setFill(Color.TEAL);
            Text upYmarker = new Text(mapX(0, axes), mapY(Max+1*scaleFactor, axes),"Y");
            upYmarker.setFill(Color.RED);
            
            
            Polygon downArrow = new Polygon();
            downArrow.getPoints().addAll(new Double[]{
            	   mapX(0,axes), mapY(Min-1*scaleFactor, axes),
            	   mapX(0+0.5*scaleFactor,axes), mapY(Min+2*scaleFactor, axes),
            	   mapX(0-0.5*scaleFactor,axes), mapY(Min+2*scaleFactor, axes)});
            downArrow.setFill(Color.TEAL);
            Text downYmarker = new Text(mapX(0*scaleFactor, axes), mapY(Min-2*scaleFactor, axes),"-Y");
            downYmarker.setFill(Color.RED);
            
            
            Polygon leftArrow = new Polygon();
            leftArrow.getPoints().addAll(new Double[]{
            	   mapX(Min-1*scaleFactor,axes), mapY(0, axes),
            	   mapX(Min+2*scaleFactor,axes), mapY(0.5*scaleFactor, axes),
            	   mapX(Min+2*scaleFactor,axes), mapY(-0.5*scaleFactor, axes)});
            leftArrow.setFill(Color.TEAL);
            Text leftYmarker = new Text(mapX(Min-3*scaleFactor, axes), mapY(1*scaleFactor, axes),"-X");
            leftYmarker.setFill(Color.RED);
            
            Polygon rightArrow = new Polygon();
            rightArrow.getPoints().addAll(new Double[]{
            	   mapX(Max+1*scaleFactor,axes), mapY(0, axes),
            	   mapX(Max-2*scaleFactor,axes), mapY(0.5*scaleFactor, axes),
            	   mapX(Max-2*scaleFactor,axes), mapY(-0.5*scaleFactor, axes)});
            rightArrow.setFill(Color.TEAL);
            Text rightYmarker = new Text(mapX(Max+1*scaleFactor, axes), mapY(1*scaleFactor, axes),"X");
            rightYmarker.setFill(Color.RED);
            
            
            
            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            
			getChildren().setAll(axes, xxx, yyy, line1, line2, path, cc, cc2, coordinate1, coordinate2,
					upArrow, downArrow, leftArrow, rightArrow,
					upYmarker, downYmarker, leftYmarker, rightYmarker);
        }
    	/**
    	 * Maps the actual x coordinate to the coordinate in the X-Axes.
    	 * @param x
    	 * @param axes
    	 * @return double value
    	 */
        private double mapX(double x, Axes axes) {
            double tx = axes.getPrefWidth() / 2;
            double sx = axes.getPrefWidth() / (axes.getXAxis().getUpperBound() -  axes.getXAxis().getLowerBound());

            return x * sx + tx;
        }
        /**
         * Maps the actual y coordinate to the coordinate in the Y-Axes
         * @param y
         * @param axes
         * @return
         */
        private double mapY(double y, Axes axes) {
            double ty = axes.getPrefHeight() / 2;
            double sy = axes.getPrefHeight() / (axes.getYAxis().getUpperBound() -  axes.getYAxis().getLowerBound());

            return -y * sy + ty;
        }
    }
}
