public class BrickBreaker
{         
    public static void main(String[] args)
    {   
    	
    	GameArena template = new GameArena(1000,600);  // Creates window of specified dimensions
    	
    	
    	// Create menu UI through calling classes 
    
    	Rectangle menu = new Rectangle(500,300,1000,600,"202C4F"); 
    	Rectangle level1 = new Rectangle(150,300,80,80,"#ea6c0b");  
    	Rectangle level1border = new Rectangle(150,300,85,85,"#000000");  
    	
    	Rectangle level2 = new Rectangle(350,300,80,80,"#478687");  
    	Rectangle level2border = new Rectangle(350,300,85,85,"#000000"); 
    	
    	Rectangle level3 = new Rectangle(550,300,80,80,"#478687");  
    	Rectangle level3border = new Rectangle(550,300,85,85,"#000000"); 
    	
    	Text brickTitleMenu = new Text("B R I C K",350,80,70,"FFFFFF");  
    	Text breakerTitleMenu = new Text("B R E A K E R",275,165,70,"FFFFFF");  
    	
    	Text brickTitleMenuBorder = new Text("B R I C K",358,80,70,"000000");  
    	Text breakerTitleMenuBorder = new Text("B R E A K E R",282,165,70,"000000"); 
    	
        Text level1Text = new Text("I",142,315,40,"000000");
        Text level2Text = new Text("II",334,315,40,"000000");
        Text level3Text = new Text("III",526,315,40,"000000");
    	
        
        // Display menu UI
        
    	template.addRectangle(menu);
    	template.addRectangle(level1border);
    	template.addRectangle(level1);
    	template.addRectangle(level2border);
    	template.addRectangle(level2);
    	template.addRectangle(level3border);
    	template.addRectangle(level3);
    	
    	template.addText(brickTitleMenuBorder);
    	template.addText(breakerTitleMenuBorder);
    	
    	template.addText(brickTitleMenu);
    	template.addText(breakerTitleMenu);
    	
    	template.addText(level1Text);
    	template.addText(level2Text);
    	template.addText(level3Text);

    	template.update();
    	
    	
    	// "While" loop to check for which level selected
    	
    	while (true)
    	{
    		if(template.leftPressed() && level3.getColour() == "#404040")      // If left pressed, set Level 1 colour to orange "Selected"
    		{                                   // and de-select Level 2 by making colour blue again
    			level3.setColour("#478687");
    			level2.setColour("#ea6c0b");
    			level1.setColour("#478687");

    		}
    		else if(template.leftPressed() && level2.getColour() == "#ea6c0b")
    		{
    			level3.setColour("#478687");
    			level2.setColour("#478687");
    			level1.setColour("#ea6c0b");

    		}
    		
    		if (template.rightPressed() && level1.getColour() == "#ea6c0b" )        // If right pressed, vice-versa 
    		{                                   // (Level 2 grayed out)
    			level3.setColour("#478687");
    			level2.setColour("#ea6c0b");
    			level1.setColour("#478687");

    		}
    		else if (template.rightPressed() && level2.getColour() == "#ea6c0b" )
    		{
    			level3.setColour("#404040");
    			level2.setColour("#478687");
    			level1.setColour("#478687");
 
    		}
    		
			template.hold();
			
    		if(template.spacePressed() && level1.getColour() == "#ea6c0b")    // If space is pressed when 
    		{           													  // when Level 1 is selected
    						
    			// Remove menu UI
    			
    	    	template.removeRectangle(menu); 							  
    	    	template.removeRectangle(level1border);
    	    	template.removeRectangle(level1);
    	    	template.removeRectangle(level2border);
    	    	template.removeRectangle(level2);
    	    	template.removeRectangle(level3border);
    	    	template.removeRectangle(level3);
    	    	
    	    	template.removeText(brickTitleMenuBorder);
    	    	template.removeText(breakerTitleMenuBorder);
    	    	
    	    	template.removeText(brickTitleMenu);
    	    	template.removeText(breakerTitleMenu);
    	    	
    	    	template.removeText(level1Text);
    	    	template.removeText(level2Text);
    	    	template.removeText(level3Text);
    	    	
    	    	
    	    	// Create Level 1 UI 
    	    	
    	    	Rectangle rightColumn = new Rectangle(880,500,250,1000,"#202C4F"); 
    	        Rectangle pointsBar = new Rectangle(865,440,170,280,"#020202");
    	        template.addRectangle(rightColumn);
    	        template.addRectangle(pointsBar);
    	        
    	        Text Title1 = new Text("B R I C K",784,70,40,"FFFFFF");
    	        Text Title2 = new Text("B R E A K E R",810,110,20,"FFFFFF");
    	        
    	        Text AIM = new Text("AIM",850,180,24,"FFFFFF");
    	        Text AndPress = new Text("AND PRESS",826,210,16,"FFFFFF");
    	        Text SPACE = new Text("S P A C E",810,250,26,"FFFFFF");
    	        
    	        Text Try = new Text("TRY",850,180,22,"FFFFFF");
    	        Text Again = new Text("A G A I N ?",800,220,26,"FFFFFF");
    	        
    	        Text Game = new Text("G A M E", 90, 150, 150, "FFFFFF");
    	        Text Over = new Text("O V E R", 90, 520, 150, "FFFFFF");
    	        
    	        Text Winner = new Text("W I N N E R !", 35, 320, 100, "FFFFFF");
    	        
    	        Text progress1 = new Text("!",968,578,30,"#b87333");
    	        Text progress2 = new Text("!",968,508,30,"#5a5b5e");
    	        Text progress3 = new Text("!",968,438,30,"#D4AF37");
    	        Text progress4 = new Text("!",968,368,30,"#dce1ea");
    	        Text progress5 = new Text("!!!",960,310,25,"#dce1ea");  
    	        
    	    	Arrow aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);
    	    	
    	    	Rectangle points = new Rectangle(865,580,170,0,"b87333");
    	       
 
    	        // Display Level 1 UI
    	        
    	        template.addText(Title1);
    	        template.addText(Title2);
    	        template.addText(AIM);
    	        template.addText(AndPress);
    	        template.addText(SPACE);   	           	     
    	    	template.addRectangle(points);

    	    	
    	    	
    	    	// Create and display the bricks and text (life of brick) that comes with it
    	    	    	    	
    	        Text[] life = new Text[25];               // Array of text to go with 
    	                                                  // same size array of bricks
    	        Rectangle[] brick = new Rectangle[25];
    	    	    
    	        int marginX = 0;
    	        int marginY = 0;
    	        int textmarginX = -5;     // Adjusting text on x and y axis
    	        int textmarginY = 5;
    	      
    	        
    	        for (int counter1 = 0; counter1 < 25; counter1++)         // Assign a brick and number value to every slot in array
    	        {
    	     	    if (counter1 == 5 || counter1 == 10 || counter1 == 15 || counter1 == 20)   // Looks out to create new row 
    	     	    { 																		   // after 5 bricks
    	                marginX = 0;
    	                marginY = marginY + 34;
    	            }
    	     	 
    	     	    
    	     	   // Creates bronze bricks of life 1
    	     	    
    	            if ((counter1 >= 0 && counter1 < 5) || (counter1 > 19 && counter1 < 25))  
    	            {
    	            	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#b87333");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("1", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	            	
    	     	    }
    	            
    	            
    	            // Creates silver bricks of life 3  
    	            
    	     	    else if ((counter1 > 4 && counter1 < 11) || (counter1 > 13 && counter1 < 20))       
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#5a5b5e");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("3", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	            
    	            
    	            // Creates gold bricks of life 5
    	            
    	     	    else if ((counter1 == 11) || (counter1 == 13))                                 
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#D4AF37");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("5", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	            
    	              	            
    	            // Creates single platinum brick of life 7
    	            
    	     	    else if ((counter1 == 12))
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#dce1ea");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("7", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	          
    	            marginX = marginX + 84;     // Move along x axis to next column
    	            template.update();
    	            
    	        }
    	               
    	        
    	        
    	        boolean change = false;     // Allows for entrance into next "while" loop when space has been 
    	         							// pressed to shoot the balls
    	        
    	        
    	        // Create balls and assign them size, colour and location
    	        
    	        Ball[] b = new Ball[8];
    	        
    	        for (int valcount = 0; valcount < 8; valcount++)
    	        {
    	        	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
    	        }
    	        
    	        
    	        int pause = 0;      // Creates spacing between the balls 
    	        
    	        double eq1 = 0;     // X axis movement of the balls
    	        double eq2 = 0;     // Y axis movement of the balls
    	        
    	        
    	        // Creates X and Y movement directions for each ball
    	        // to allow independent movement
    	        
    	        int[] directionX = new int[8];
    	        int[] directionY = new int[8];
    	        
    	        for (int valcount = 0; valcount < 8; valcount++)
    	        {
    	    	    directionX[valcount] = 1;
    	    	    directionY[valcount] = 1;
    	        }
    	        
    	        
    	        // A boolean variable to validate whether a brick has been hit or not
    	       
    	        boolean[] singlebounce = new boolean[25];
    	       
    	        for (int assign = 0; assign < 25; assign++)
    	        {
    	     	   singlebounce[assign] = false;
    	        }
    	        
    	        
    	       
    	        double speed = 2;    // To adjust the speed of the balls
    	          	        
    	        int set1 = 0;        // Resets brick margins when checking for 
    	        int set2 = 0;        // ball impacting bricks
    	       

    	      
    	    	    while (true)
    	            {   
    	    	    	  
    	    	    	// While the arrow is pointing straight or to the right
    	    	    	
    	                 while ((aim.getStartX() <= aim.getEndX()) && (change == false))     
    	                 {																	
    	                	 
    	                	 
    	                	 if (template.spacePressed())                            // If space is pressed, make the 
    	                     {														 // arrow invisible and add the balls
    	                		 aim.setColour("000000");                    
    	                         
    	                		 for (int counter = 0; counter < 8; counter++)
    	                		 {
    	                			 template.addBall(b[counter]);
    	                		 }
    	                		 
    	                		 template.addText(progress1);
    	              	         
    	              	         change = true;                                      // Moves onto next "while" loop
    	                     }
 
    	                	 
    	                	 
    	                	 if (template.leftPressed() )                               // If left is pressed, adjust the
    	            	     { 															// arrow to point leftwards
    	            		     aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() - 1);
    	            	     }
    	                	 
    	                	 
    	                	 if ((aim.getEndY() < 578) && (template.rightPressed()))    // If right is pressed and doesn't exceed
    	                	 {															// movement cap, move the arrow point rightwards
    	            		     aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() + 1); 
    	                	 }
    	                
    	                       template.update();
    	                 }
    	                 

    	                 
    	                 // While the arrow is pointing to the left
    	                 
    	                 while ((aim.getStartX() > aim.getEndX()) && (change == false))
    	                 {     
    	                	 
    	                	 
    	                	 if (template.spacePressed())                             // If space is pressed, make the
    	                     {														  // arrow invisible and add the balls
    	             	         aim.setColour("000000");

    	             	        for (int counter = 0; counter < 8; counter++)  
    	               		    {
    	               			     template.addBall(b[counter]);
    	               		    } 
    	             	        
    	             	       template.addText(progress1);

    	              	         change = true;       								// Moves onto next "while" loop
    	                     }
    	                	      	 
    	                	 
    	            	       if (template.rightPressed())                               // If right is pressed, adjust the
    	            	       {          												  // arrow to point rightwards
    	            		       aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() - 1);
    	            	       }
    	            	       
    	            	           
    	            	       if ((aim.getEndY() < 578) && (template.leftPressed()))     // If left is pressed and doesn't exceed
    	                       {														  // movement cap, the arrow points leftwards
    	            	           aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() + 1);
    	            	       }

    	                       template.update();
    	                 }
    	                 
    	                 
    	                 
    	                 // "While" loop to shoot and direct the balls
    	                 
    	                 while (change == true)
    	                 {
    	                	 
    	                	 
    	                	 // Remove AIM text
    	                	 
    	                     template.removeText(AIM);
    	                     template.removeText(AndPress);
    	                     template.removeText(SPACE);
    	                     
    	                        	      
    	                     
    	                     // Determines which direction the balls should move based on
    	                     // whether the arrow is pointing left or right based on Pythagoras' theorem
    	                 
    	                     
    	                     if (aim.getStartX() > aim.getEndX())     // If arrow is pointing left
    	                     {
    	                    	 eq1 = Math.sqrt(aim.getStartX() - aim.getEndX());
    	                     }
    	                     else if (aim.getStartX() < aim.getEndX())      // If arrow is pointing right
    	                     {
    	                    	 eq1 =  - (Math.sqrt(aim.getEndX() - aim.getStartX()));    
    	                     }
    	                     else                                      // If arrow is pointing straight
    	                     { 										   // set x movement to 0
    	                    	 eq1 = 0;
    	                     }
    	                     
    	                     eq2 = Math.sqrt(aim.getStartY() - aim.getEndY());
    	                     

    	                     
    	                     
    	                     int nextBall = 0;
    	                     
    	                     for (int ballTrack = 0; ballTrack < 8; ballTrack++)
    	                     {
    	                    	 if (pause >= nextBall)      // Shoots the next balls
    	                         {   
    	                    		 
    	                    		 
    	                    		 // If ball within the boundaries of the walls, move the ball by eq1 (x cord) and eq2 (y cord)
    	                    		 
    	                             if (b[ballTrack].getXPosition() > 0 && b[ballTrack].getXPosition() < 754 && b[ballTrack].getYPosition() > 0)
    	                             {
    	                            	 b[ballTrack].setXPosition(b[ballTrack].getXPosition() - (eq1 * directionX[ballTrack]) * speed);
    	                            	 b[ballTrack].setYPosition(b[ballTrack].getYPosition() - (eq2 * directionY[ballTrack]) * speed);
    	                             }
    	                             
    	                             
    	                             
    	                             
    	                             if (b[ballTrack].getXPosition() >= 742)                  // If ball hits the right wall 
    	                             {
    	                            	 directionX[ballTrack] = - directionX[ballTrack];     // multiply the x movement by -1
    	                             }
    	                             
    	                             if (b[ballTrack].getXPosition() <= 12)                   // If ball hits the left wall
    	                             {  
    	                            	 directionX[ballTrack] = - directionX[ballTrack];     // multiply the x movement by -1
    	                             } 
    	                             
    	                             if (b[ballTrack].getYPosition() <= 12)                   // If ball hits the top wall
    	                             {
    	                            	 directionY[ballTrack] = - directionY[ballTrack];     // multiply the y movement by -1
    	                             }
    	                         }
    	                    	 
    	                    	 nextBall = nextBall + 7;    // Allows for space between ball just release and the next one
    	                     }
    	                         	                     
    	                     pause = pause + 1;       // Incrementing look-out value to create space between balls
    	                     
 
    	                     
    	                     
   
    	                     // Reduce the life number of bricks hit, and remove if depleted to 0
    	                     
    	                     int margin1 = set1;
    	                     int margin2 = set2;                    
    	                     
    	                     int totalBricks = 0;
    	              	            
    	                     
    	                     for (int brickCount = 0; brickCount < 5; brickCount++)
    	                     {
    	                    	 margin1 = 0;       // Reset to column 1
    	                    	 
    	                    	 for (int brickCount2 = 0; brickCount2 < 5; brickCount2++)
    	                    	 {
    	                    		 
    	                    		 for (int counter = 0; counter < 8; counter++)     // Check every ball for impact on brick
    	                             {
    	                    			 
    	                    			 
    	                    			 
    	                    			 // If the left side of the brick is hit
    	                    			 
    	                        	 	 if ( (b[counter].getXPosition() >= 156 + margin1 && b[counter].getXPosition() <= 168 + margin1) &&       
    	                        			  (b[counter].getYPosition() >= 190 + margin2 && b[counter].getYPosition() <= 220 + margin2) &&
    	                        			   singlebounce[totalBricks] == false)
    	                                 {
    	                                	
    	                                	 directionX[counter] = - directionX[counter];     // Change X direction of ball 
    	                                	 
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                       	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 }
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the right side of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 233 + margin1 && b[counter].getXPosition() <= 245 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 190 + margin2 && b[counter].getYPosition() <= 220 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {

    	                                	 directionX[counter] = - directionX[counter];     // Change X direction of ball 
    	                                	  
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 } 
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the top of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 160 + margin1 && b[counter].getXPosition() <= 240 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 181 + margin2 && b[counter].getYPosition() <= 193 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];     // Change Y direction of ball 
    	                                      
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 }	 
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the bottom of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 160 + margin1 && b[counter].getXPosition() <= 240 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 207 + margin2 && b[counter].getYPosition() <= 219 + margin2) &&
    	                        			       singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];     // Change X direction of ball 
    	                                     
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                        	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	  
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                 }     	                        	 	     	                        	 	     	                        	 	     	                        	 	 
    	                             }    
    	                    		 
    	                        	 margin1 = margin1 + 84;             // Go to brick in next column
    	                        	 totalBricks = totalBricks + 1;      // Next brick in array
    	                    	 }   
    	                    	 
    	                    	 margin2 = margin2 + 34;                 // Go to brick in next row      	 
    	                     }
    	                     
    	                     
    	                     
    	                     // Changes colour and shows "!" of progress, as more bricks are destroyed
    	                     
    	                     if (points.getHeight() >= 278)
    	                     {
    	                    	 template.addText(progress5);
    	                     }
    	                     else if (points.getHeight() >= 210)
    	                     {
    	                    	 points.setColour("#dce1ea");
    	                    	 template.addText(progress4);
    	                     }
    	                     else if (points.getHeight() >= 140)
    	                     {
    	                    	 points.setColour("#D4AF37");
    	                    	 template.addText(progress3);
    	                     }
    	                     else if (points.getHeight() >= 70)
    	                     {
    	                    	 points.setColour("#5a5b5e");
    	                    	 template.addText(progress2);
    	                     }
    	                     else if (points.getHeight() >= 0)
    	                     {
    	                    	 points.setColour("#b87333");
    	                     }
    	                     
    	                     
    	                     
    	                     // Checks if any bricks left, if so, proceeds to next round
    	                     
    	                     if (b[0].getYPosition() >= 720 &&
    	                         b[1].getYPosition() >= 720 &&
    	                    	 b[2].getYPosition() >= 720 &&
    	                    	 b[3].getYPosition() >= 720 &&
    	                    	 b[4].getYPosition() >= 720 &&
    	                    	 b[5].getYPosition() >= 720 &&
    	                    	 b[6].getYPosition() >= 720 &&
    	                    	 b[7].getYPosition() >= 720 &&
    	                    	 points.getHeight() < 278)
    	                     {
    	                    	 
    	                        	 for (int counter = 0; counter < 25; counter++)
    	                             {    
    	                     	         
    	                        		 // If brick that hasn't been hit reaches the bottom, end game
    	                        		 
    	                        		 if (brick[counter].getYPosition() >= 520 && singlebounce[counter] == false)
    	                     	         {
    	                     		 
    	                     	             template.addText(Game);
    	                     	             template.addText(Over);
    	                     	             template.addText(Try);
    	                     	             template.addText(Again);
    	                     	                                 	                                        	                     	                        	    
    	                                     template.update();
    	                     	     
    	                     	             while (true)
    	                     	             { }
    	                     	         }
    	                        		    	                        		 
    	                        		 
    	                        		 // Drops the remaining bricks down a row
    	                        		 
    	                        		  brick[counter].setYPosition(brick[counter].getYPosition() + 40); 
    	                            	  life[counter].setYPosition(life[counter].getYPosition() + 40); 
    	                            	  
    	                            
    	                             }
    	                        	 
    	                        	 
    	                        	 // Re-displays the arrow, resets the balls, and sets
    	                        	 // required values back to 0
    	                        	

    	                        	 aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);
    	                        	 
    	                             for (int valcount = 0; valcount < 8; valcount++)
    	                             {
    	                             	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
    	                             }
    	                             
    	                             pause = 0;
    	                     	    
    	                             eq1 = 0;
    	                             eq2 = 0;
    	                             
    	                            for (int valcount = 0; valcount < 8; valcount++)
    	                            {
    	                         	   directionX[valcount] = 1;
    	                         	   directionY[valcount] = 1;
    	                            }


    	                            set1 = 0;
    	                            set2 = set2 + 40;   // Everything has been reset the same as the first round   	                            
    	                            					// except for the bricks having dropped a row
    	                             
    	                        	change = false;      // Exits current "while" loop and enters arrow "while" loop
    	                         
    	                     }
    	                     
    	                     
    	                     
    	                     // Checks for a win. If all the balls are out of the game
    	                     // and points are at max, then display "Winner"
    	                     
    	                     if (b[0].getYPosition() >= 720 &&
    	                             b[1].getYPosition() >= 720 &&
    	                        	 b[2].getYPosition() >= 720 &&
    	                        	 b[3].getYPosition() >= 720 &&
    	                        	 b[4].getYPosition() >= 720 &&
    	                        	 b[5].getYPosition() >= 720 &&
    	                        	 b[6].getYPosition() >= 720 &&
    	                        	 b[7].getYPosition() >= 720 &&
    	                        	 points.getHeight() >= 278)
    	                     {
    	                    	 template.addText(Winner);
    	                     }
    	                    	 
    	                    	                                                                                                   	            
    	                     template.update();
    	                 }       
    	            }
    		}
    		
    		else if (template.spacePressed() && level2.getColour() == "#ea6c0b")    // If space is pressed when 
    		{                                                                  // when Level 1 is selected)
    			// Remove menu UI
    			
    	    	template.removeRectangle(menu); 							  
    	    	template.removeRectangle(level1border);
    	    	template.removeRectangle(level1);
    	    	template.removeRectangle(level2border);
    	    	template.removeRectangle(level2);
    	    	template.removeRectangle(level3border);
    	    	template.removeRectangle(level3);
    	    	
    	    	template.removeText(brickTitleMenuBorder);
    	    	template.removeText(breakerTitleMenuBorder);
    	    	
    	    	template.removeText(brickTitleMenu);
    	    	template.removeText(breakerTitleMenu);
    	    	
    	    	template.removeText(level1Text);
    	    	template.removeText(level2Text);
    	    	template.removeText(level3Text);
    	    	
    	    	
    	    	// Create Level 1 UI 
    	    	
    	    	Rectangle rightColumn = new Rectangle(880,500,250,1000,"#202C4F"); 
    	        Rectangle pointsBar = new Rectangle(865,440,170,280,"#020202");
    	        template.addRectangle(rightColumn);
    	        template.addRectangle(pointsBar);
    	        
    	        Text Title1 = new Text("B R I C K",784,70,40,"FFFFFF");
    	        Text Title2 = new Text("B R E A K E R",810,110,20,"FFFFFF");
    	        
    	        Text AIM = new Text("AIM",850,180,24,"FFFFFF");
    	        Text AndPress = new Text("AND PRESS",826,210,16,"FFFFFF");
    	        Text SPACE = new Text("S P A C E",810,250,26,"FFFFFF");
    	        
    	        Text Try = new Text("TRY",850,180,22,"FFFFFF");
    	        Text Again = new Text("A G A I N ?",800,220,26,"FFFFFF");
    	        
    	        Text Game = new Text("G A M E", 90, 150, 150, "FFFFFF");
    	        Text Over = new Text("O V E R", 90, 520, 150, "FFFFFF");
    	        
    	        Text Test = new Text("O V E R", 90, 520, 150, "FFFFFF");
    	        
    	        Text Winner = new Text("W I N N E R !", 35, 320, 100, "FFFFFF");
    	        
    	        Text progress1 = new Text("!",968,578,30,"#b87333");
    	        Text progress2 = new Text("!",968,508,30,"#5a5b5e");
    	        Text progress3 = new Text("!",968,438,30,"#D4AF37");
    	        Text progress4 = new Text("!",968,368,30,"#dce1ea");
    	        Text progress5 = new Text("!!!",960,310,25,"#dce1ea");  
    	        
    	    	Arrow aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);
    	    	
    	    	Rectangle points = new Rectangle(865,580,170,0,"b87333");
    	       
 
    	        // Display Level 1 UI
    	        
    	        template.addText(Title1);
    	        template.addText(Title2);
    	        template.addText(AIM);
    	        template.addText(AndPress);
    	        template.addText(SPACE);   	           	     
    	    	template.addRectangle(points);

    	    	
    	    	
    	    	// Create and display the bricks and text (life of brick) that comes with it
    	    	    	    	
    	        Text[] life = new Text[72];               // Array of text to go with 
    	                                                  // same size array of bricks
    	        Rectangle[] brick = new Rectangle[72];
    	    	    
    	        int marginX = 0;
    	        int marginY = 0;
    	        int textmarginX = -5;     // Adjusting text on x and y axis
    	        int textmarginY = 5;
    	       
    	        int totalCount = 0;
    	        
    	        
    	        for (int counterRow = 0; counterRow < 8; counterRow++)         // Assign a brick and number value to every slot in array
    	        {
    	           marginX = 0;
    	           
    	     	   for (int counterColumn = 0; counterColumn < 9; counterColumn++)
    	     	   {
    	     		   
    	     		    if (counterRow == 0 && (counterColumn == 0 || counterColumn == 1 || counterColumn == 3 ||  counterColumn == 5 ||  counterColumn == 7 || counterColumn == 8))
    	     		    {
        	     		    
    	     		    	brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
        	                template.addRectangle(brick[totalCount]);
        	                
        	                life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
        	            	template.addText(life[totalCount]);
        	            	

        	     		    
    	     		    }
    	     		    
    	     		   if (counterRow == 0 && (counterColumn == 2 || counterColumn == 4 || counterColumn == 6))
   	     		       {
    	     			   
       	     		        
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#D4AF37");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("5", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	     		        }
    	     		   
    	     		   
    	     		       		   
   	     		        if (counterRow == 1 && (counterColumn == 0 || counterColumn == 8))
   	     		        {
   	     		        	
   	    	     		    
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	     		        }  	  
   	     		        
   	     		        
   	     		        
   	     		        if (counterRow == 2 && (counterColumn == 0 || counterColumn == 8))
   	     		        {
   	     		        	
   	    	     		    
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	     		        }  	 
   	     		        
   	     		        
   	     		           	     		           	     		        
   	     		        if (counterRow == 3 && (counterColumn == 0 || counterColumn == 2 || counterColumn == 6 || counterColumn == 8))
   	     		        {
   	     		        	
   	    	     		    
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#b87333");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("1", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	    	     		    
   	     		        }  
   	     		        
   	     		        if (counterRow == 3 && (counterColumn == 3 || counterColumn == 5))
   	     		        {
   	     		        	
   	    	     		    
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#D4AF37");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("5", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	     		        }  
   	     		        
   	     		        if (counterRow == 3 && (counterColumn == 4))
   	     		        {
   	     		        	
   	    	     		    
   	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#dce1ea");
       	                    template.addRectangle(brick[totalCount]);
       	                
       	                    life[totalCount] = new Text("7", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
       	            	    template.addText(life[totalCount]);
       	            	    

   	     		        }    
   	     		        
   	     		        
   	     		        
   	     		           	     		           	     		        
   	     		        if (counterRow == 4 && (counterColumn == 0 || counterColumn == 2 || counterColumn == 6 || counterColumn == 8))
	     		        { 	     		        	
   	    	     		    
	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#b87333");
   	                        template.addRectangle(brick[totalCount]);
   	                
   	                        life[totalCount] = new Text("1", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
   	            	        template.addText(life[totalCount]);
   	            	        

   	    	     		    
	     		        }  
	     		        
	     		        if (counterRow == 4 && (counterColumn == 3 || counterColumn == 5))
	     		        {	     		   
	    	     		    
	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#D4AF37");
   	                        template.addRectangle(brick[totalCount]);
   	                
   	                        life[totalCount] = new Text("5", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
   	            	        template.addText(life[totalCount]);
   	            	        

	    	     		    
	     		        }  
	     		        
	     		        if (counterRow == 4 && (counterColumn == 4))
	     		        {
	    	     		    
	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#dce1ea");
   	                        template.addRectangle(brick[totalCount]);
   	                
   	                        life[totalCount] = new Text("7", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
   	            	        template.addText(life[totalCount]);
	     		        	

	     		        }     	     
	     		        
	     		        
	     		           	     		        
	     		        if (counterRow == 5 && (counterColumn == 0 || counterColumn == 8))
	     		        {
	    	     		    
	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
   	                        template.addRectangle(brick[totalCount]);
   	                
   	                        life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
   	            	        template.addText(life[totalCount]);   	            	        
	     		        	

	     		        }  
	     		        
	     		        
	     		        
	     		        	     		        
	     		        if (counterRow == 6 && (counterColumn == 0 || counterColumn == 8))
	     		        {
	    	     		    
	     		    	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
   	                        template.addRectangle(brick[totalCount]);
   	                
   	                        life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
   	            	        template.addText(life[totalCount]);   	            	        
	     		        	

	     		        }  	  
	     		        
	     		           		        
	     		        
	     		           	     		        
	     		        if (counterRow == 7 && (counterColumn == 0 || counterColumn == 3 || counterColumn == 4 ||  counterColumn == 5 ||  counterColumn == 8))
     		            {

	    	     		    
     		        	    brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#5a5b5e");
	                        template.addRectangle(brick[totalCount]);
	                
	                        life[totalCount] = new Text("3", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
	                	    template.addText(life[totalCount]);
	     		        	

     		            }
     		        
     		            if (counterRow == 7 && (counterColumn == 1 || counterColumn == 2 || counterColumn == 6 || counterColumn == 7))
     		            {
        	     		    
     		                brick[totalCount] = new Rectangle(42 + marginX, 18 + marginY, 80, 30, "#b87333");
	                        template.addRectangle(brick[totalCount]);
	                
	                        life[totalCount] = new Text("1", 42 + marginX + textmarginX, 18 + marginY + textmarginY, 15, "000000");
	            	        template.addText(life[totalCount]);
     		            	

     		             }
	     		      
     		            
   	     		        totalCount = totalCount + 1;
    	     		    marginX = marginX + 84;
        	            template.update();
    	     	   }
    	     	   
    	           marginY = marginY + 34;
    	            
    	        }
    	               
    	        
    	        
    	        boolean change = false;     // Allows for entrance into next "while" loop when space has been 
    	         							// pressed to shoot the balls
    	        
    	        
    	        // Create balls and assign them size, colour and location
    	        
    	        Ball[] b = new Ball[8];
    	        
    	        for (int valcount = 0; valcount < 8; valcount++)
    	        {
    	        	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
    	        }
    	        
    	        
    	        int pause = 0;      // Creates spacing between the balls 
    	        
    	        double eq1 = 0;     // X axis movement of the balls
    	        double eq2 = 0;     // Y axis movement of the balls
    	        
    	        
    	        // Creates X and Y movement directions for each ball
    	        // to allow independent movement
    	        
    	        int[] directionX = new int[8];
    	        int[] directionY = new int[8];
    	        
    	        for (int valcount = 0; valcount < 8; valcount++)
    	        {
    	    	    directionX[valcount] = 1;
    	    	    directionY[valcount] = 1;
    	        }
    	        
    	        
    	        // A boolean variable to validate whether a brick has been hit or not
    	       
    	        boolean[] singlebounce = new boolean[72];
    	       
    	        for (int assign = 0; assign < 72; assign++)
    	        {
    	     	   singlebounce[assign] = false;
    	        }
    	        
    	        
    	       
    	        double speed = 2;    // To adjust the speed of the balls
    	          	        
    	        int set1 = 0;        // Resets brick margins when checking for 
    	        int set2 = 0;        // ball impacting bricks
    	        
    	       

    	      
    	    	    while (true)
    	            {   
    	    	    	  
    	    	    	// While the arrow is pointing straight or to the right
    	    	    	
    	                 while ((aim.getStartX() <= aim.getEndX()) && (change == false))     
    	                 {																	
    	                	 
    	                	 
    	                	 if (template.spacePressed())                            // If space is pressed, make the 
    	                     {														 // arrow invisible and add the balls
    	                		 aim.setColour("000000");                    
    	                         
    	                		 for (int counter = 0; counter < 8; counter++)
    	                		 {
    	                			 template.addBall(b[counter]);
    	                		 }
    	                		 
    	                		 template.addText(progress1);
    	              	         
    	              	         change = true;                                      // Moves onto next "while" loop
    	                     }
 
    	                	 
    	                	 
    	                	 if (template.leftPressed() )                               // If left is pressed, adjust the
    	            	     { 															// arrow to point leftwards
    	            		     aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() - 1);
    	            	     }
    	                	 
    	                	 
    	                	 if ((aim.getEndY() < 578) && (template.rightPressed()))    // If right is pressed and doesn't exceed
    	                	 {															// movement cap, move the arrow point rightwards
    	            		     aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() + 1); 
    	                	 }
    	                
    	                       template.update();
    	                 }
    	                 

    	                 
    	                 // While the arrow is pointing to the left
    	                 
    	                 while ((aim.getStartX() > aim.getEndX()) && (change == false))
    	                 {     
    	                	 
    	                	 
    	                	 if (template.spacePressed())                             // If space is pressed, make the
    	                     {														  // arrow invisible and add the balls
    	             	         aim.setColour("000000");

    	             	        for (int counter = 0; counter < 8; counter++)  
    	               		    {
    	               			     template.addBall(b[counter]);
    	               		    } 
    	             	        
    	             	       template.addText(progress1);

    	              	         change = true;       								// Moves onto next "while" loop
    	                     }
    	                	      	 
    	                	 
    	            	       if (template.rightPressed())                               // If right is pressed, adjust the
    	            	       {          												  // arrow to point rightwards
    	            		       aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() - 1);
    	            	       }
    	            	       
    	            	           
    	            	       if ((aim.getEndY() < 578) && (template.leftPressed()))     // If left is pressed and doesn't exceed
    	                       {														  // movement cap, the arrow points leftwards
    	            	           aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() + 1);
    	            	       }

    	                       template.update();
    	                 }
    	                 
    	                 
    	                 
    	                 // "While" loop to shoot and direct the balls
    	                 
    	                 while (change == true)
    	                 {
    	                	 
    	                	 
    	                	 // Remove AIM text
    	                	 
    	                     template.removeText(AIM);
    	                     template.removeText(AndPress);
    	                     template.removeText(SPACE);
    	                     
    	                        	      
    	                     
    	                     // Determines which direction the balls should move based on
    	                     // whether the arrow is pointing left or right based on Pythagoras' theorem
    	                 
    	                     
    	                     if (aim.getStartX() > aim.getEndX())     // If arrow is pointing left
    	                     {
    	                    	 eq1 = Math.sqrt(aim.getStartX() - aim.getEndX());
    	                     }
    	                     else if (aim.getStartX() < aim.getEndX())      // If arrow is pointing right
    	                     {
    	                    	 eq1 =  - (Math.sqrt(aim.getEndX() - aim.getStartX()));    
    	                     }
    	                     else                                      // If arrow is pointing straight
    	                     { 										   // set x movement to 0
    	                    	 eq1 = 0;
    	                     }
    	                     
    	                     eq2 = Math.sqrt(aim.getStartY() - aim.getEndY());
    	                     

    	                     
    	                     
    	                     int nextBall = 0;
    	                     
    	                     for (int ballTrack = 0; ballTrack < 8; ballTrack++)
    	                     {
    	                    	 if (pause >= nextBall)      // Shoots the next balls
    	                         {   
    	                    		 
    	                    		 
    	                    		 // If ball within the boundaries of the walls, move the ball by eq1 (x cord) and eq2 (y cord)
    	                    		 
    	                             if (b[ballTrack].getXPosition() > 0 && b[ballTrack].getXPosition() < 754 && b[ballTrack].getYPosition() > 0)
    	                             {
    	                            	 b[ballTrack].setXPosition(b[ballTrack].getXPosition() - (eq1 * directionX[ballTrack]) * speed);
    	                            	 b[ballTrack].setYPosition(b[ballTrack].getYPosition() - (eq2 * directionY[ballTrack]) * speed);
    	                             }    	                             
    	                             
    	                             
    	                             
    	                             if (b[ballTrack].getXPosition() >= 742)                  // If ball hits the right wall 
    	                             {
    	                            	 directionX[ballTrack] = - directionX[ballTrack];     // multiply the x movement by -1
    	                             }
    	                             
    	                             if (b[ballTrack].getXPosition() <= 12)                   // If ball hits the left wall
    	                             {  
    	                            	 directionX[ballTrack] = - directionX[ballTrack];     // multiply the x movement by -1
    	                             } 
    	                             
    	                             if (b[ballTrack].getYPosition() <= 12)                   // If ball hits the top wall
    	                             {
    	                            	 directionY[ballTrack] = - directionY[ballTrack];     // multiply the y movement by -1
    	                             }
    	                         }
    	                    	 
    	                    	 nextBall = nextBall + 7;    // Allows for space between ball just release and the next one
    	                     }
    	                         	                     
    	                     pause = pause + 1;       // Incrementing look-out value to create space between balls
    	                     
 
    	                     
    	                     
   
    	                     // Reduce the life number of bricks hit, and remove if depleted to 0
    	                     
    	                     int margin1 = set1;
    	                     int margin2 = set2;                    
    	                     
    	                    	 
    	                    	 for (int totalBricks = 0; totalBricks < 72; totalBricks++)
    	                    	 {
    	                    		 
    	                    		 if (  (totalBricks == 9) || (totalBricks == 18) || (totalBricks == 27) || (totalBricks == 36) || (totalBricks == 45) ||
    	                    			   (totalBricks == 54) || (totalBricks == 63))
    	                    		 {
    	                             	   margin2 = margin2 + 34;                 // Go to brick in next row   
    	                             	   margin1 = 0;
    	                    		 }
    	                    		 
	                    			 if (  (totalBricks >= 10 && totalBricks <= 16)  || (totalBricks >= 19 && totalBricks <= 25) || (totalBricks == 28) || (totalBricks == 34) ||
 	                    				   (totalBricks == 37) || (totalBricks == 43) || (totalBricks >= 46 && totalBricks <= 52) || (totalBricks >= 55 && totalBricks <= 61))
 	                    			 {
 	                    				  singlebounce[totalBricks] = true;
 	                    			 }
    	                    		        	
    	                    		 
    	                    		 for (int counter = 0; counter < 8; counter++)     // Check every ball for impact on brick
    	                             {   	               
    	                    			     	                    			 
    	                    			 // If the left side of the brick is hit
    	                    			 
    	                        	 	 if ( (b[counter].getXPosition() >= 0 + margin1 && b[counter].getXPosition() <= 14 + margin1) &&       
    	                        			  (b[counter].getYPosition() >= 8 + margin2 && b[counter].getYPosition() <= 30 + margin2) &&
    	                        			   singlebounce[totalBricks] == false)
    	                                 {
    	                                	
    	                                	 directionX[counter] = - directionX[counter];     // Change X direction of ball 
    	                                	 
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                       	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 7);
    	                                    	 points.setYPosition(points.getYPosition() - 3.5);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 }
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the right side of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 75 + margin1 && b[counter].getXPosition() <= 90 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 32 + margin2 && b[counter].getYPosition() <= 62 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {

    	                                	 directionX[counter] = - directionX[counter];     // Change X direction of ball 
    	                                	  
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 7);
    	                                    	 points.setYPosition(points.getYPosition() - 3.5);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 } 
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the top of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 0 + margin1 && b[counter].getXPosition() <= 80 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 0 + margin2 && b[counter].getYPosition() <= 14 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];     // Change Y direction of ball 
    	                                      
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 7);
    	                                    	 points.setYPosition(points.getYPosition() - 3.5);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                	 
    	                                 }	 
    	                        	 	 
    	                        	 	 
    	                        	 	 
    	                        	 	 // If the bottom of the brick is hit
    	                        	 	 
    	                        		 else if ( (b[counter].getXPosition() >= 0 + margin1 && b[counter].getXPosition() <= 80 + margin1) && 
    	                        			       (b[counter].getYPosition() >= 25 + margin2 && b[counter].getYPosition() <= 39 + margin2) &&
    	                        			       singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];     // Change X direction of ball 
    	                                     
    	                                	 
    	                                	 // Gets string life value of brick, converts to integer, decrements it, and returns it to string
    	                                	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                        	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 
    	                                	 // If life is reduced to 0, remove brick and increase points bar
    	                                	  
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 7);
    	                                    	 points.setYPosition(points.getYPosition() - 3.5);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;     // Brick[totalBricks] has been hit
    	                                	 }
    	                                 }     	                        	 	     	                        	 	     	                        	 	     	                        	 	 
    	                             }    
    	                    		 
    	                        	 margin1 = margin1 + 84;             // Go to brick in next column
    	                    	 }   
    	                    	 
   	 
    	                     
    	        	               
    	                    
    	                     
    	                     
    	                     // Changes colour and shows "!" of progress, as more bricks are destroyed
    	                     
    	                     if (points.getHeight() >= 278)
    	                     {
    	                    	 template.addText(progress5);
    	                     }
    	                     else if (points.getHeight() >= 210)
    	                     {
    	                    	 points.setColour("#dce1ea");
    	                    	 template.addText(progress4);
    	                     }
    	                     else if (points.getHeight() >= 140)
    	                     {
    	                    	 points.setColour("#D4AF37");
    	                    	 template.addText(progress3);
    	                     }
    	                     else if (points.getHeight() >= 70)
    	                     {
    	                    	 points.setColour("#5a5b5e");
    	                    	 template.addText(progress2);
    	                     }
    	                     else if (points.getHeight() >= 0)
    	                     {
    	                    	 points.setColour("#b87333");
    	                     }
    	                     
    	                     
    	                     
    	                     // Checks if any bricks left, if so, proceeds to next round
    	                     
    	                     if (b[0].getYPosition() >= 720 &&
    	                         b[1].getYPosition() >= 720 &&
    	                    	 b[2].getYPosition() >= 720 &&
    	                    	 b[3].getYPosition() >= 720 &&
    	                    	 b[4].getYPosition() >= 720 &&
    	                    	 b[5].getYPosition() >= 720 &&
    	                    	 b[6].getYPosition() >= 720 &&
    	                    	 b[7].getYPosition() >= 720 &&
    	                    	 points.getHeight() < 278)
    	                     {    	                    	   	    	                     
        	                    	    	                    	 
	                        	 for (int counter = 63; counter < 72; counter++)
	                             {    
	                     	         
	                        		 // If brick that hasn't been hit reaches the bottom, end game
	                        		 
	                        		 if (brick[counter].getYPosition() >= 520 && singlebounce[counter] == false)
	                     	         {
	                     		 
	                     	             template.addText(Game);
	                     	             template.addText(Over);
	                     	             template.addText(Try);
	                     	             template.addText(Again);
	                     	                                 	                                        	                     	                        	    
	                                     template.update();
	                     	     
	                     	             while (true)
	                     	             { }
	                     	         }
	                        		    	                        		 
	                        		 
	                        		 // Drops the remaining bricks down a row
	                        		 
	                        		  brick[counter].setYPosition(brick[counter].getYPosition() + 34); 
	                            	  life[counter].setYPosition(life[counter].getYPosition() + 34); 
	                            	  
	                            
	                             }
	                        	 
                        	  
	                        	 for (int counter = 0; counter < 9; counter++)
	                             {    
	                     	         
	                        		 // If brick that hasn't been hit reaches the bottom, end game
	                        		 
	                        		 if (brick[counter].getYPosition() >= 520 && singlebounce[counter] == false)
	                     	         {
	                     		 
	                     	             template.addText(Game);
	                     	             template.addText(Over);
	                     	             template.addText(Try);
	                     	             template.addText(Again);
	                     	                                 	                                        	                     	                        	    
	                                     template.update();
	                     	     
	                     	             while (true)
	                     	             { }
	                     	         }
	                        		    	                        		 
	                        		 
	                        		 // Drops the remaining bricks down a row
	                        		 
	                        		  brick[counter].setYPosition(brick[counter].getYPosition() + 34); 
	                            	  life[counter].setYPosition(life[counter].getYPosition() + 34); 
	                            	  
	                            
	                             }
	                        	 
	                        	 
	                        	 // Re-displays the arrow, resets the balls, and sets
	                        	 // required values back to 0
	                        	

	                        	 aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);
	                        	 
	                             for (int valcount = 0; valcount < 8; valcount++)
	                             {
	                             	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
	                             }
	                             
	                             pause = 0;
	                     	    
	                             eq1 = 0;
	                             eq2 = 0;
	                             
	                            for (int valcount = 0; valcount < 8; valcount++)
	                            {
	                         	   directionX[valcount] = 1;
	                         	   directionY[valcount] = 1;
	                            }


	                            set1 = 0;
	                            set2 = set2 + 40;   // Everything has been reset the same as the first round   	                            
	                            					// except for the bricks having dropped a row
	                             
	                        	change = false;      // Exits current "while" loop and enters arrow "while" loop
	                        	
	                    	  	template.update();
	                         
	                         }
    	                     
    	                     
    	                     
    	                     
    	                     // Checks for a win. If all the balls are out of the game
    	                     // and points are at max, then display "Winner"
    	                     
    	                     if (b[0].getYPosition() >= 720 &&
    	                             b[1].getYPosition() >= 720 &&
    	                        	 b[2].getYPosition() >= 720 &&
    	                        	 b[3].getYPosition() >= 720 &&
    	                        	 b[4].getYPosition() >= 720 &&
    	                        	 b[5].getYPosition() >= 720 &&
    	                        	 b[6].getYPosition() >= 720 &&
    	                        	 b[7].getYPosition() >= 720 &&
    	                        	 points.getHeight() >= 278)
    	                     {
    	                    	 template.addText(Winner);
    	                     }
    	                    	 
    	                    	                                                                                                   	            
    	                     template.update();
    	                 }         	                 
    	    	    	
    	            }

    		}    		
    		
    	  	template.update();

    	}
    	
    }
}


                                                              


