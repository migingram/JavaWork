public class BrickBreaker
{         
    public static void main(String[] args)
    {   
    	
    	GameArena template = new GameArena(1000,600); // Creates window of specified dimensions
    	
    	Rectangle rightColumn = new Rectangle(880,500,250,1000,"#202C4F"); 
        Rectangle pointsBar = new Rectangle(865,440,170,280,"#020202");
        template.addRectangle(rightColumn);
        template.addRectangle(pointsBar);
        
        Text Title1 = new Text("B R I C K",784,70,40,"FFFFFF");
        Text Title2 = new Text("B R E A K E R",810,110,20,"FFFFFF");
       
        template.addText(Title1);
        template.addText(Title2);
        
    	Text[] t = new Text[25];
    		
    	Arrow aim = new Arrow(380,580,380,550,2,"#FFFFFF",template);

    	    
    	
        Rectangle[] brick = new Rectangle[25];
    	    
        int marginX = 0;
        int marginY = 0;
      
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
     	    }
     	    else if ((counter1 > 4 && counter1 < 11) || (counter1 > 13 && counter1 < 20))
     	    {
     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#5a5b5e");
                template.addRectangle(brick[counter1]);
     	    }
     	    else if ((counter1 == 11) || (counter1 == 13))
     	    {
     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#D4AF37");
                template.addRectangle(brick[counter1]);
     	    }
     	    else if ((counter1 == 12))
     	    {
     	    	brick[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#dce1ea");
                template.addRectangle(brick[counter1]);
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
                    
                     template.update();
          	         
          	         change = true;
                 }
            	 
            	 
            	 if (template.leftPressed() )
        	     {
        		     aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() - 1);
        	     }
            	 
            	 if ((aim.getEndY() < 575) && (template.rightPressed()))
            	 {
        		     aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() + 1);
            	 }
            
                   template.pause();
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
         	        
                     template.update();
          	         
          	         change = true;       
                 }
            	      	 
            	 
        	       if (template.rightPressed())
        	       {
        		       aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() - 1);
        	       }
        	           
        	       if ((aim.getEndY() < 575) && (template.leftPressed()))
                   {
        	           aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() + 1);
        	       }

                   template.pause();
                   template.update();
             }
             
             
             while (change == true)
             {
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
                         if (b[ballTrack].getXPosition() > 0 && b[ballTrack].getXPosition() < 750 && b[ballTrack].getYPosition() > 0)
                         {
                        	 b[ballTrack].setXPosition(b[ballTrack].getXPosition() - (eq1 * directionX[ballTrack]) * speed);
                        	 b[ballTrack].setYPosition(b[ballTrack].getYPosition() - (eq2 * directionY[ballTrack]) * speed);
                         }
                         
                         if (b[ballTrack].getXPosition() >= 743)
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
                 
                
                 
                 
                 int margin1 = 0;
                 int margin2 = 0;
                 
                 int totalBricks = 0;
          	            
                 
                 for (int brickCount = 0; brickCount < 5; brickCount++)
                 {
                	 margin1 = 0;
                	 
                	 for (int brickCount2 = 0; brickCount2 < 5; brickCount2++)
                	 {
                		 for (int counter = 0; counter < 8; counter++)
                         {
                			    
                    	 	 if ( (b[counter].getXPosition() > 158 + margin1 && b[counter].getXPosition() < 165 + margin1) && 
                    			  (b[counter].getYPosition() > 190 + margin2 && b[counter].getYPosition() < 220 + margin2) &&
                    			   singlebounce[totalBricks] == false)
                             {
                            	 template.removeRectangle(brick[totalBricks]);
                            	 directionX[counter] = - directionX[counter];
                            	 singlebounce[totalBricks] = true;
                             }
                    		 else if ( (b[counter].getXPosition() > 230 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                    			       (b[counter].getYPosition() > 190 + margin2 && b[counter].getYPosition() < 220 + margin2) &&
                    			        singlebounce[totalBricks] == false)
                             {
                            	 template.removeRectangle(brick[totalBricks]);
                            	 directionX[counter] = - directionX[counter];
                            	 singlebounce[totalBricks] = true;
                             } 
                    		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                    			       (b[counter].getYPosition() > 185 + margin2 && b[counter].getYPosition() < 192 + margin2) &&
                    			        singlebounce[totalBricks] == false)
                             {
                            	 template.removeRectangle(brick[totalBricks]);
                            	 directionY[counter] = - directionY[counter];
                            	 singlebounce[totalBricks] = true;
                             }	 
                    		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                    			       (b[counter].getYPosition() > 215 + margin2 && b[counter].getYPosition() < 222 + margin2) &&
                    			       singlebounce[totalBricks] == false)
                             {
                            	 template.removeRectangle(brick[totalBricks]);
                            	 directionY[counter] = - directionY[counter];
                            	 singlebounce[totalBricks] = true;
                             } 
                         }                    	 
                    	 margin1 = margin1 + 90;
                    	 totalBricks = totalBricks + 1;
                	 }                	 
                	 margin2 = margin2 + 40;               	 
                 }
            	 
            	 
            	 
                 template.pause();
                 template.update();
             }       
        }  
    }
}


                                                              


