public class BrickBreaker
{         
    public static void main(String[] args)
    {   
    	
    	GameArena template = new GameArena(1000,600); // Creates window of specified dimensions
    	
    	Rectangle menu = new Rectangle(500,300,1000,600,"202C4F");
    	Rectangle level1 = new Rectangle(150,300,80,80,"#478687");
    	Rectangle level1border = new Rectangle(150,300,85,85,"#000000");
    	
    	Rectangle level2 = new Rectangle(350,300,80,80,"#478687");
    	Rectangle level2border = new Rectangle(350,300,85,85,"#000000");
    	
    	Text brickTitleMenu = new Text("B R I C K",350,80,70,"FFFFFF");
    	Text breakerTitleMenu = new Text("B R E A K E R",275,165,70,"FFFFFF");
    	
    	Text brickTitleMenuBorder = new Text("B R I C K",358,80,70,"000000");
    	Text breakerTitleMenuBorder = new Text("B R E A K E R",282,165,70,"000000");
    	
        Text level1Text = new Text("I",142,315,40,"000000");
        Text level2Text = new Text("II",334,315,40,"000000");
    	
    	template.addRectangle(menu);
    	template.addRectangle(level1border);
    	template.addRectangle(level1);
    	template.addRectangle(level2border);
    	template.addRectangle(level2);
    	
    	template.addText(brickTitleMenuBorder);
    	template.addText(breakerTitleMenuBorder);
    	
    	template.addText(brickTitleMenu);
    	template.addText(breakerTitleMenu);
    	
    	template.addText(level1Text);
    	template.addText(level2Text);

    	template.update();
    	
    	
    	while (true)
    	{
    		if(template.leftPressed())
    		{
    			level2.setColour("#478687");
    			level1.setColour("#ea6c0b");
    		}
    		
    		if (template.rightPressed())
    		{
    			level2.setColour("#ea6c0b");
    			level1.setColour("#478687");
    		}
    		
    		if(template.spacePressed() && level1.getColour() == "#ea6c0b")
    		{
    	    	template.removeRectangle(menu);
    	    	template.removeRectangle(level1border);
    	    	template.removeRectangle(level1);
    	    	template.removeRectangle(level2border);
    	    	template.removeRectangle(level2);
    	    	
    	    	template.removeText(brickTitleMenuBorder);
    	    	template.removeText(breakerTitleMenuBorder);
    	    	
    	    	template.removeText(brickTitleMenu);
    	    	template.removeText(breakerTitleMenu);
    	    	
    	    	template.removeText(level1Text);
    	    	template.removeText(level2Text);
    	    	
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
    	       
    	        template.addText(Title1);
    	        template.addText(Title2);
    	        template.addText(AIM);
    	        template.addText(AndPress);
    	        template.addText(SPACE);
    	        
    	        

    	    		
    	    	Arrow aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);
    	    	
    	    	Rectangle points = new Rectangle(865,580,170,0,"b87333");
    	    	template.addRectangle(points);

    	    	
    	    	
    	    	
    	        Text[] life = new Text[25];
    	      
    	        Rectangle[] brick = new Rectangle[25];
    	    	    
    	        int marginX = 0;
    	        int marginY = 0;
    	        int textmarginX = -5;
    	        int textmarginY = 5;
    	      
    	        for (int counter1 = 0; counter1 < 25; counter1++)
    	        {
    	     	    if (counter1 == 5 || counter1 == 10 || counter1 == 15 || counter1 == 20)
    	     	    {
    	                marginX = 0;
    	                marginY = marginY + 40;
    	            }
    	     	 
    	            if ((counter1 >= 0 && counter1 < 5) || (counter1 > 19 && counter1 < 25))
    	            {
    	            	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#b87333");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("1", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	            	
    	     	    }
    	     	    else if ((counter1 > 4 && counter1 < 11) || (counter1 > 13 && counter1 < 20))
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#5a5b5e");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("2", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	     	    else if ((counter1 == 11) || (counter1 == 13))
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#D4AF37");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("3", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	     	    else if ((counter1 == 12))
    	     	    {
    	     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#dce1ea");
    	                template.addRectangle(brick[counter1]);
    	                
    	                life[counter1] = new Text("4", 200 + marginX + textmarginX, 200 + marginY + textmarginY, 15, "000000");
    	            	template.addText(life[counter1]);
    	     	    }
    	          
    	            marginX = marginX + 90;
    	            template.update();
    	            
    	        }
    	               
    	        
    	        
    	        boolean change = false;
    	        
    	        Ball[] b = new Ball[8];
    	        
    	        for (int valcount = 0; valcount < 8; valcount++)
    	        {
    	        	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
    	        }
    	        
    	        
    	        int pause = 0;
    	        
    	        double eq1 = 0;
    	        double eq2 = 0;
    	        
    	        int[] directionX = new int[8];
    	        int[] directionY = new int[8];
    	        
    	       for (int valcount = 0; valcount < 8; valcount++)
    	       {
    	    	   directionX[valcount] = 1;
    	    	   directionY[valcount] = 1;
    	       }
    	       
    	       boolean[] singlebounce = new boolean[25];
    	       
    	       for (int assign = 0; assign < 25; assign++)
    	       {
    	    	   singlebounce[assign] = false;
    	       }
    	       
    	       double speed = 2;
    	       
    	       int set1 = 0;
    	       int set2 = 0;
    	       

    	      
    	    	    while (true)
    	            {   
    	    	    	  
    	                 while ((aim.getStartX() <= aim.getEndX()) && (change == false))
    	                 {
    	                	 
    	                	 if (template.spacePressed())
    	                     {
    	                		 aim.setColour("000000");
    	                         
    	                		 for (int counter = 0; counter < 8; counter++)
    	                		 {
    	                			 template.addBall(b[counter]);
    	                		 }
    	                		 
    	                		 template.addText(progress1);
    	              	         
    	              	         change = true;
    	                     }
    	                	 
    	                	 
    	                	 if (template.leftPressed() )
    	            	     {
    	            		     aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() - 1);
    	            	     }
    	                	 
    	                	 if ((aim.getEndY() < 578) && (template.rightPressed()))
    	                	 {
    	            		     aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() + 1);
    	                	 }
    	                
    	                       template.update();
    	                 }
    	                 

    	                 while ((aim.getStartX() > aim.getEndX()) && (change == false))
    	                 {     
    	                	 
    	                	 
    	                	 if (template.spacePressed())
    	                     {
    	             	         aim.setColour("000000");

    	             	        for (int counter = 0; counter < 8; counter++)
    	               		    {
    	               			     template.addBall(b[counter]);
    	               		    } 
    	             	        
    	             	       template.addText(progress1);

    	              	         change = true;       
    	                     }
    	                	      	 
    	                	 
    	            	       if (template.rightPressed())
    	            	       {
    	            		       aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() - 1);
    	            	       }
    	            	           
    	            	       if ((aim.getEndY() < 578) && (template.leftPressed()))
    	                       {
    	            	           aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() + 1);
    	            	       }

    	                       template.update();
    	                 }
    	                 
    	                 
    	                 while (change == true)
    	                 {
    	                	 
    	                     template.removeText(AIM);
    	                     template.removeText(AndPress);
    	                     template.removeText(SPACE);
    	                     
    	                     
    	                     if (aim.getStartX() > aim.getEndX())
    	                     {
    	                    	 eq1 = Math.sqrt(aim.getStartX() - aim.getEndX());
    	                     }
    	                     else if (aim.getStartX() < aim.getEndX())
    	                     {
    	                    	 eq1 =  - (Math.sqrt(aim.getEndX() - aim.getStartX()));
    	                     }
    	                     else 
    	                     {
    	                    	 eq1 = 0;
    	                     }
    	                     
    	                     eq2 = Math.sqrt(aim.getStartY() - aim.getEndY());
    	                     
    	                     
    	                     int nextBall = 0;
    	                     
    	                     for (int ballTrack = 0; ballTrack < 8; ballTrack++)
    	                     {
    	                    	 if (pause >= nextBall)
    	                         {                 
    	                             if (b[ballTrack].getXPosition() > 0 && b[ballTrack].getXPosition() < 754 && b[ballTrack].getYPosition() > 0)
    	                             {
    	                            	 b[ballTrack].setXPosition(b[ballTrack].getXPosition() - (eq1 * directionX[ballTrack]) * speed);
    	                            	 b[ballTrack].setYPosition(b[ballTrack].getYPosition() - (eq2 * directionY[ballTrack]) * speed);
    	                             }
    	                             
    	                             if (b[ballTrack].getXPosition() >= 742)
    	                             {
    	                            	 directionX[ballTrack] = - directionX[ballTrack];
    	                             }
    	                             
    	                             if (b[ballTrack].getXPosition() <= 12)
    	                             {
    	                            	 directionX[ballTrack] = - directionX[ballTrack];
    	                             }
    	                             
    	                             if (b[ballTrack].getYPosition() <= 12)
    	                             {
    	                            	 directionY[ballTrack] = - directionY[ballTrack];
    	                             }
    	                         }
    	                    	 
    	                    	 nextBall = nextBall + 7;
    	                     }
    	                         	                     
    	                     pause = pause + 1;
    	                     
    	                    
    	                     
    	                     int margin1 = set1;
    	                     int margin2 = set2;                    
    	                     
    	                     int totalBricks = 0;
    	              	            
    	                     
    	                     for (int brickCount = 0; brickCount < 5; brickCount++)
    	                     {
    	                    	 margin1 = 0;
    	                    	 
    	                    	 for (int brickCount2 = 0; brickCount2 < 5; brickCount2++)
    	                    	 {
    	                    		 for (int counter = 0; counter < 8; counter++)
    	                             {
    	                    			    
    	                        	 	 if ( (b[counter].getXPosition() > 155 + margin1 && b[counter].getXPosition() < 166 + margin1) && 
    	                        			  (b[counter].getYPosition() > 190 + margin2 && b[counter].getYPosition() < 220 + margin2) &&
    	                        			   singlebounce[totalBricks] == false)
    	                                 {
    	                                	
    	                                	 directionX[counter] = - directionX[counter];
    	                                	                            
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;
    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                       	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;
    	                                	 }
    	                                	 
    	                                 }
    	                        		 else if ( (b[counter].getXPosition() > 230 + margin1 && b[counter].getXPosition() < 246 + margin1) && 
    	                        			       (b[counter].getYPosition() > 190 + margin2 && b[counter].getYPosition() < 220 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {

    	                                	 directionX[counter] = - directionX[counter];
    	                                	                                                    	                                               	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;
    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;
    	                                	 }
    	                                	 
    	                                 } 
    	                        		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
    	                        			       (b[counter].getYPosition() > 178 + margin2 && b[counter].getYPosition() < 192 + margin2) &&
    	                        			        singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];
    	                                                        	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;
    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                           	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;
    	                                	 }
    	                                	 
    	                                 }	 
    	                        		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
    	                        			       (b[counter].getYPosition() > 215 + margin2 && b[counter].getYPosition() < 225 + margin2) &&
    	                        			       singlebounce[totalBricks] == false)
    	                                 {
    	                        			 
    	                                	 directionY[counter] = - directionY[counter];
    	                                                         	 
    	                                	 int shift = Integer.parseInt(life[totalBricks].getText());
    	                                	 shift = shift - 1;
    	                                	 
    	                                	 String shift2 = String.valueOf(shift);                        	 
    	                                	 life[totalBricks].setText(shift2);
    	                                	 
    	                                	 if (shift == 0)
    	                                	 {
    	                                		 template.removeRectangle(brick[totalBricks]);
    	                                		 
    	                                		 points.setHeight(points.getHeight() + 11.2);
    	                                    	 points.setYPosition(points.getYPosition() - 5.6);
    	                                    	 
    	                                    	 singlebounce[totalBricks] = true;
    	                                	 }
    	                                 } 
    	                             }    
    	                    		 
    	                        	 margin1 = margin1 + 90;
    	                        	 totalBricks = totalBricks + 1;
    	                    	 }   
    	                    	 
    	                    	 margin2 = margin2 + 40;               	 
    	                     }
    	                     
    	                     
    	                     
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
    	                        		 
    	                        		  brick[counter].setYPosition(brick[counter].getYPosition() + 40);
    	                            	  life[counter].setYPosition(life[counter].getYPosition() + 40); 
    	                            	  
    	                            
    	                             }
    	                        	 

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
    	                            set2 = set2 + 40;
    	                            
    	                             
    	                        	change = false;
    	                         
    	                     }
    	                     
    	                     
    	                     
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


                                                              


