import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
// importing awt classes
public class paint1_final extends JComponent {
	public MouseListener lastmouselistener;
	public MouseMotionListener freedraw;
	int a=0;int b=0;int c=0;int d=0;// initialising variables for all methods used in  paint to get 
	int a1=0;int b1=0;int c1=0;int d1=0;//X,Y co-ordinates where mouse has been pressed and where mouse has been released
	int a2=0;int b2=0;int c2=0;int d2=0;
	int a3=0;int b3=0;int c3=0;int d3=0;
	int a4=0;int b4=0;int c4=0;int d4=0;
	int a5=0;int b5=0;int c5=0;int d5=0;
	int a6=0;int b6=0;int c6=0;int d6=0;
	int a7=0;int b7=0;int c7=0;int d7=0;
	int a8=0;int b8=0;int c8=0;int d8=0;
	
	
	private Image image;
	private Color color=(Color.WHITE);// initially setting value of color as white
	
	
	private Graphics2D g2;//initialising graphics 


	
	public paint1_final(){
		//Sets whether this component should use a buffer to paint
		
		}
		
		protected void paintComponent(Graphics g) {
		    if (image == null) {

		      image = createImage(getSize().width, getSize().height);
		      g2 = (Graphics2D) image.getGraphics();

		      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		      clear();
		    }

		    g.drawImage(image, 0, 0, null);//creating the work area to draw the graphics
		  }
		 
		 // this method is implemented when the clear button is pressed
		  public void clear() {
		    g2.setPaint(Color.white);

		    g2.fillRect(0, 0, getSize().width, getSize().height);//replaces the workspace with a white image of the 
		   
		    g2.setPaint(Color.black);//same size as the workspace
		    repaint();//this method is called to get a component to repaint itself.
		  }
		  public void coloured(){
			  color=JColorChooser.showDialog(null, "The Color Box", color);
				if(color==null)
				{color=Color.BLACK;}//default color is set as black
				
				
				g2.setColor(color);//changing the current color to the selected color
		  }
		  //this method is used to draw a straight line
		  public void draw_line() {
				if(lastmouselistener!=null)//if any mouselistener of another method is activated
					removeMouseListener(lastmouselistener);//then remove that mouselistener
			  	if(freedraw!=null)
					removeMouseMotionListener(freedraw);
			  MouseListener draw_line_listener = new MouseAdapter() {

				  public void mousePressed(MouseEvent e) {//this method returns x,y co-ordinates when mouse is pressed
					  a = e.getX();
					  b = e.getY();

				  }

				  public void mouseReleased(MouseEvent e) {//this method returns x,y co-ordinates when mouse is released
					  c = e.getX();
					  d = e.getY();

					  if (g2 != null) {//the leftmost upper corner has the co-ordinates (0,0)

						  g2.drawLine(a, b, c, d);// draws a line from (a,b) to (c,d) co-ordinates
						  repaint();//this method is called to get a component to repaint itself.
							
					  }
				  }
			  };
		  addMouseListener(draw_line_listener);//adds this method's mouse listener to the screen
		  lastmouselistener=draw_line_listener;//this stores this methods mouse listener to last mouse listener
		  }
				
		  public void free_draw(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener mouseListener_freedraw=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a4=e.getX();
						b4=e.getY();
						
					}
					
							
							
					
				};
			  addMouseListener(mouseListener_freedraw);
				MouseMotionListener free_draw_motion=new MouseAdapter(){
					public void mouseDragged(MouseEvent e){//this method returns x,y co-ordinates when mouse is dragged
						c4=e.getX();
						d4=e.getY();
						
						if(g2!=null){
							
							g2.drawLine(a4, b4, c4, d4);//this method draws a line from (a4,b4) to (c4,d4)
							repaint();//this method is called to get a component to repaint itself.
							a4=c4;
							b4=d4;
							
						}
					}
				};
			  addMouseMotionListener(free_draw_motion);//adds mouse motion listener to the screen
			  lastmouselistener=mouseListener_freedraw;//saves the current mouse listener as last mouse listener
			  freedraw=free_draw_motion;
		  }
		  
		  //this method is for the eraser component in paint
		  public void eraser(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener eraser_mouse=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a1=e.getX();
						b1=e.getY();
						
					}
				};
			  addMouseListener(eraser_mouse);// adds mouse listener to the screen
				MouseMotionListener eraser_mouse_motion=new MouseAdapter(){
					public void mouseDragged(MouseEvent e){//this method returns x,y co-ordinates when mouse is dragged
						c1=e.getX();
						d1=e.getY();
						
						if(g2!=null){
							g2.setColor(Color.WHITE);
							
							g2.drawLine(a1, b1, c1, d1);
							g2.setColor(color);
							repaint();//this method is called to get a component to repaint itself.
							g2.setColor(Color.black);
							a1=c1;
							b1=d1;
							
						}
					}
				};
			  addMouseMotionListener(eraser_mouse_motion);// adds mouse motion listener to the screen
			  lastmouselistener=eraser_mouse;// saves the current mouselistener to the screen
			  freedraw=eraser_mouse_motion;
		  }
		  
		  // this method is used to draw a round rectangle
		  public void draw_roundrect(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener draw_round_mouse=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a2=e.getX();
						b2=e.getY();
						
					}
				
				
					public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
						c2=e.getX();
						d2=e.getY();
						
						if(g2!=null){ //this method takes the x,y co-ordinate,the length,the breadth,the radius of arc,arc distance as attributes
							if(a2<c2&& b2>d2)
							g2.drawRoundRect(a2, d2, c2-a2, b2-d2,(c2-a2)/3,(b2-d2)/3);
							
							 
							else if(a2>c2&& b2>d2)
								g2.drawRoundRect(c2, d2,a2-c2,b2-d2,(a2-c2)/3,(b2-d2)/3);
							else if(a2>c2 && b2<d2)
								g2.drawRoundRect(c2, b2, a2-c2, d2-b2,(a2-c2)/3,(d2-b2)/3 );
							else if(a2<c2 && b2<d2)
								g2.drawRoundRect(a2, b2, c2-a2, d2-b2, (c2-a2)/3, ( d2-b2)/3);}
						
							repaint();//this method is called to get a component to repaint itself.
							
							
							
						
					}
				};
			  addMouseListener(draw_round_mouse);// adds mouse listener to the screen
		  lastmouselistener=draw_round_mouse;//sets last mouse listener as draw_round_mouse
		  }
		  //this method draws a rectangle 
		  public void draw_rect(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener draw_rect_mouse=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a5=e.getX();
						b5=e.getY();
						
					}
				
				
					public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
						c5=e.getX();
						d5=e.getY();
						
						if(g2!=null){//this method takes the x,y coordinate from where to start,the length and the breadth as attributes
							if(a5<c5&& b5>d5)
							g2.drawRect(a5, d5, c5-a5, b5-d5);
							
							 
							else if(a5>c5&& b5>d5)
								g2.drawRect(c5, d5,a5-c5,b5-d5);
							else if(a5>c5 && b5<d5)
								g2.drawRect(c5, b5, a5-c5, d5-b5);
							else if(a5<c5 && b5<d5)
								g2.drawRect(a5, b5, c5-a5, d5-b5);}
				
						repaint();//this method is called to get a component to repaint itself.
							
							
							
						
					}
				};
			  addMouseListener(draw_rect_mouse);//adds mouse listener to the screen
			  lastmouselistener=draw_rect_mouse;//sets last mouse listener as draw_rect_mouse
		  }
		  //this method is used to draw a rectangle filled with chosen color
		  public void fill_rect(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener fill_rect_mouse=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a6=e.getX();
						b6=e.getY();
						
					}
				
				
					public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
						c6=e.getX();
						d6=e.getY();
						
						if(g2!=null){//this method uses attributes x,y,length,breadth
							if(a6<c6&& b6>d6)
							g2.fillRect(a6, d6, c6-a6, b6-d6);
							
							 
							else if(a6>c6&& b6>d6)
								g2.fillRect(c6, d6,a6-c6,b6-d6);
							else if(a6>c6 && b6<d6)
								g2.fillRect(c6, b6, a6-c6, d6-b6 );
							else if(a6<c6 && b6<d6)
								g2.fillRect(a6, b6, c6-a6, d6-b6);}
						 
							repaint();//this method is called to get a component to repaint itself.
							
							
							
						
					}
				};
			  addMouseListener(fill_rect_mouse);//adds mouse listener to the screen
			  lastmouselistener=fill_rect_mouse;//sets last mouse listener as fill_rect_mouse
		  }
		  //this method draws a filled oval on the screen
		  public void fill_oval(){
			  if(lastmouselistener!=null)//if any mouselistener of another method is activated
				  removeMouseListener(lastmouselistener);//then remove that mouselistener
			  if(freedraw!=null)
				  removeMouseMotionListener(freedraw);
			  MouseListener fill_ooval_mouse=new MouseAdapter(){
					
					public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						a3=e.getX();
						b3=e.getY();
						
					}
				
				
					
						public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
							c3=e.getX();
							d3=e.getY();
							
							if(g2!=null){//this method takes attributes same as that of rectangle
								if(a3<c3&& b3>d3)
								g2.fillOval(a3, d3, c3-a3, b3-d3);
								
								 
								else if(a3>c3&& b3>d3)
									g2.fillOval(c3, d3,a3-c3,b3-d3);
								else if(a3>c3 && b3<d3)
									g2.fillOval(c3, b3, a3-c3, d3-b3 );
								else if(a3<c3 && b3<d3)
									g2.fillOval(a3, b3, c3-a3, d3-b3);
								repaint();//this method is called to get a component to repaint itself.
								
					
								
								
							
						}
						
							
						}
					
				};
		  addMouseListener(fill_ooval_mouse);//this adds mouse listener to the screen
			  lastmouselistener=fill_ooval_mouse;//sets last mouse listener as fill_ooval_mouse
		  }
			// this method is used to draw an oval  
			  public void draw_oval(){
				  if(lastmouselistener!=null)//if any mouselistener of another method is activated
					  removeMouseListener(lastmouselistener);//then remove that mouselistener
				  if(freedraw!=null)
					  removeMouseMotionListener(freedraw);
				  MouseListener draw_oval_mouse=new MouseAdapter(){
						
						public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
							a7=e.getX();
							b7=e.getY();
							
						}
					
					
						
							public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
								c7=e.getX();
								d7=e.getY();
								
								if(g2!=null){// this method takes the same attributes as that of a rectangle
									if(a7<c7&& b7>d7)
									g2.drawOval(a7, d7, c7-a7, b7-d7);
									
									 
									else if(a7>c7&& b7>d7)
										g2.drawOval(c7, d7,a7-c7,b7-d7);
									else if(a7>c7 && b7<d7)
										g2.drawOval(c7, b7, a7-c7, d7-b7 );
									else if(a7<c7 && b7<d7)
										g2.drawOval(a7, b7, c7-a7, d7-b7);
									repaint();//this method is called to get a component to repaint itself.
									
							}
							}
						
					};
				  addMouseListener(draw_oval_mouse);//adds mouse listener to the screen
				  lastmouselistener=draw_oval_mouse;//sets last mouse listener as draw_oval_mouse

		  }
			  
			  //this method is used both by rectangle and oval
			  public void shape_command(){
				  if(lastmouselistener!=null)//if any mouselistener of another method is activated
					  removeMouseListener(lastmouselistener);//then remove that mouselistener
				  if(freedraw!=null)
					  removeMouseMotionListener(freedraw);
				  MouseListener shape_command_mouse=new MouseAdapter(){
						
						public void mousePressed(MouseEvent e){//this method returns x,y co-ordinates when mouse is pressed
						 a8 = e.getX();
							b8=e.getY();
							
						}
					
					
						
							public void mouseReleased(MouseEvent e){//this method returns x,y co-ordinates when mouse is released
								c8=e.getX();
								d8=e.getY();
							
								
									repaint();//this method is called to get a component to repaint itself.
									
						
									
							}
							
							
								
							
						
					};
			  addMouseListener(shape_command_mouse);//adds mouse listener to teh screen
				  lastmouselistener=shape_command_mouse;//sets the last mouse listener tto shape_command_mouse
			  }
			  
			  //the given method below set the stroke size of the shape/lines
			  
			  public void stroke_1(){
				  g2.setStroke(new BasicStroke(1));
			  }
			  public void stroke_2(){
				  g2.setStroke(new BasicStroke(5));
			  }
			  public void stroke_3(){
				  g2.setStroke(new BasicStroke(10));
			  }
			  public void stroke_4(){
				  g2.setStroke(new BasicStroke(15));
			  }
			 public void stroke_5(){
				  g2.setStroke(new BasicStroke(20));
			  }
			 public void stroke_6(){
				  g2.setStroke(new BasicStroke(25));
			  }
			  public void stroke_7(){
				  g2.setStroke(new BasicStroke(30));
			  }
			  public void stroke_8(){
				  g2.setStroke(new BasicStroke(35));
			  }
			  public void stroke_9(){
				  g2.setStroke(new BasicStroke(40));
			  }
			  public void stroke_10(){
				  g2.setStroke(new BasicStroke(45));
			  }

}
