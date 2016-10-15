import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
public class paint_main_final {
	 JButton setting_color;  //declaring buttons for lines and color chooser
	  JButton clear_option;
	  JButton line_draw;
	  paint1_final drawArea;  
	 JComboBox list_oval;//declaring list for shapes
	 
	  JButton eraser_option;
	  JButton free_option;
	  JComboBox list_rectangle;
	  static String[] shapename={"Rectangle","Round","Simple","Fill"};//contents of list_rectangle
	  static String[] shapename1={"Oval","Simple","Fill"};//contents of list_oval
	  
	  

	  
	 ItemListener itemListener=new ItemListener(){//when an item selection in the list occurs the itemStateChanged method is invoked
		  public void itemStateChanged(ItemEvent ie){
			  if(shapename[list_rectangle.getSelectedIndex()].equals("Round")){
				  drawArea.draw_roundrect();//if round rectangle is selected then calls method draw_roundrect
			  }
			  else if(shapename[list_rectangle.getSelectedIndex()].equals("Simple")){
				  drawArea.draw_rect();
			  }//if simple rectangle is selected then draw_rect() is called
			  else if(shapename[list_rectangle.getSelectedIndex()].equals("Fill")){
				  drawArea.fill_rect();
			  }//if fill rectangle is selected then fill_rect is called
			  else if(shapename1[list_oval.getSelectedIndex()].equals("Simple")){
				  drawArea.draw_oval();
			  }//if simple oval is selected then draw_oval() is called
			  else if(shapename1[list_oval.getSelectedIndex()].equals("Fill")){
				  drawArea.fill_oval();
			  }//if fill oval is selected then fill_oval is called
			  else if(shapename1[list_oval.getSelectedIndex()].equals("Oval")){
				  drawArea.shape_command();
			  }//if oval is selected then shape_command() is called
			  else if(shapename1[list_rectangle.getSelectedIndex()].equals("Rectangle")){
				  drawArea.shape_command();
			  }//if rectangle is selected shape_command() is called
		  }
	  };
	  
	  
	  ActionListener actionListener = new ActionListener() {//when a button is selected the method actionPerformed is invoked
	 
	  public void actionPerformed(ActionEvent e) {
	      if (e.getSource() ==clear_option) {
	        drawArea.clear();// if clear is selected then clear() is called
	      }
	      else if(e.getSource()==setting_color){
	    	  drawArea.coloured();// if setting_color is selected then colored() is called
	      }
	      else if(e.getSource()==line_draw){
	    	drawArea.draw_line();// if line_draw is selected then draw_line() is called
	      }
	     
	     
	      else if(e.getSource()==eraser_option){
	    	  drawArea.eraser();// if eraser_option is selected then eraser() is called
	      }
	      else if(e.getSource()==free_option){
	    	  drawArea.free_draw();//if free_option is selected then free_draw() is called
	      }
	    }
	  };
	 
	  public static void main(String[] args) {//in the main method the show() method is called
	    new paint_main_final().show();
	  }
	 
	  public void show() {
        
	    JFrame frame = new JFrame("Swing Paint");//creating the JFrame
	    Container content = frame.getContentPane();
//objects are added to the content pane layer of the container
	    content.setLayout(new BorderLayout());
// BorderLayout sets the components in five regions: north,south,east,west,center
	    drawArea = new paint1_final();
//creates an object of class paint1_final
	    content.add(drawArea, BorderLayout.CENTER);
	 //adds drawArea to the center of the container
	    JPanel controls = new JPanel();
	    
	    JSlider slider=new JSlider(0,9,0);
	    //creates a slider which has 10 distinct values and initially set at 0
	    slider.setPreferredSize(new Dimension(150, 50));
	    //set the preferred size of the JSlider
	    drawArea.free_draw();//when the applet runs, initially the free_draw option has been chosen
	   
	    
	    
	    ChangeListener changeListener= event -> {
         int value = slider.getValue();// used to get different values for the stroke 
         if (value == 0) {
           drawArea.stroke_1();
         } else if (value==1) {
             drawArea.stroke_2();
         } else if (value==2) {
             drawArea.stroke_3();
         } else if(value==3){
             drawArea.stroke_4();
         }
         else if(value==4){
             drawArea.stroke_5();
         }
         else if(value==5){
             drawArea.stroke_6();
         }
         else if(value==6){
             drawArea.stroke_7();
         }
         else if(value==7){
             drawArea.stroke_8();
         }
         else if(value==8){
             drawArea.stroke_9();
         }
         else if(value==9){
             drawArea.stroke_10();
         }
       };
		      slider.addChangeListener(changeListener);//adds the changelistener to the JSlider
	    
	    slider.setMinorTickSpacing(1);
	    slider.setSnapToTicks(true);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);// to display the level of strokes
	    Hashtable labels = new Hashtable();
       labels.put(0, new JLabel("Min"));//sets the labels of maximum value as max and that of minimum value as min
       labels.put(9, new JLabel("Max"));
	    slider.setLabelTable(labels);//adds labels to JSlider
	    setting_color=new JButton("Color Chooser");//creating button for color chooser
	    setting_color.addActionListener(actionListener);//adding action listener to color chooser
	    clear_option = new JButton("Clear");//creating button for clear option
	  clear_option.addActionListener(actionListener);//adding action listener to clear option
	   line_draw=new JButton("Line");//creating button for drawing line
	   line_draw.addActionListener(actionListener);//adding action listener to line_draw
		
		 
		eraser_option=new JButton("Eraser");//creating button for eraser
		eraser_option.addActionListener(actionListener);//adding action listener to eraser
		free_option=new JButton("Free draw");//creating button for free draw
		free_option.addActionListener(actionListener);//adding action listener to free draw
		 controls.add(slider);//adds JSlider to the JPanel
	   controls.add(free_option);//adds free draw to JPanel
	   controls.add(eraser_option);//adds eraser to JPanel
	 
	   controls.add(clear_option);//adds clear option to JPanel
	   controls.add(setting_color);//adds setting_color option to JPanel
	   controls.add(line_draw);//adds line_draw to JPanel
	 
	   list_rectangle=new JComboBox(shapename);//creates a list which has elements of the array shapename
	   list_rectangle.addItemListener(itemListener);//adds itemlistener to the list_rectangle

	   list_oval=new JComboBox(shapename1);//creates a list which has elements of the array shapename1
	   list_oval.addItemListener(itemListener);//adds itemlistener to the list_oval
	   controls.add( list_oval);//adds the list_recatngle to JPanel
		controls.add(list_rectangle);//adds the list_oval to the JPanel
		
	   
	    content.add(controls, BorderLayout.NORTH);//adds JPanel to the container
	 
	    frame.setSize(1000,750);//sets the size of the JFrame

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the apllication
	  
	    frame.setVisible(true);//sets the JFrame visible









	    

	  }

}
