public class BrickBreaker
{         
    public static void main(String[] args)
    {   
    	
    	GameArena template = new GameArena(1000,600); // Creates window of specified dimensions
    	
    	Rectangle rightColumn = new Rectangle(880,500,250,1000,"#202C4F"); 
        Rectangle pointsBar = new Rectangle(865,440,170,280,"#020202");
        template.addRectangle(rightColumn);
        template.addRectangle(pointsBar);
            
    	    
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
	    
        Ball[] b = new Ball[5];
        
        for (int valcount = 0; valcount < 5; valcount++)
        {
        	b[valcount] = new Ball(385, 560, 6, "FFFFFF");
        }
	    
	    
	    int pause = 0;
	    
        double eq1 = 0;
        double eq2 = 0;
        
        int[] directionX = new int[5];
        int[] directionY = new int[5];
        
       for (int valcount = 0; valcount < 5; valcount++)
       {
    	   directionX[valcount] = 1;
    	   directionY[valcount] = 1;
       }
       
       boolean[] singlebounce = new boolean[5];
       
       for (int assign = 0; assign < 5; assign++)
       {
    	   singlebounce[assign] = false;
       }
      
        
	    while (true)
        {   
             while ((aim.getStartX() <= aim.getEndX()) && (change == false))
             {
            	 
            	 if (template.spacePressed())
                 {
            		 aim.setColour("000000");
                     
            		 for (int counter = 0; counter < 5; counter++)
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

         	        for (int counter = 0; counter < 5; counter++)
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
                 
                 
                 
                 
                 if (b[0].getXPosition() > 6 && b[0].getXPosition() < 750 && b[0].getYPosition() > 0)
                 {
                	 b[0].setXPosition(b[0].getXPosition() - (eq1 * directionX[0]));
                	 b[0].setYPosition(b[0].getYPosition() - eq2 * directionY[0]);
                 }
                 
                 if (b[0].getXPosition() >= 743)
                 {
                	 directionX[0] = - directionX[0];
                 }
                 
                 if (b[0].getXPosition() <= 13)
                 {
                	 directionX[0] = - directionX[0];
                 }
                 if (b[0].getYPosition() <= 12)
                 {
                	 directionY[0] = - directionY[0];
                 }
                 
             	   
                    	 
                 
                 pause = pause + 1;
                 
                 
                 
                 
                 if (pause >= 10)
                 {                 
                     if (b[1].getXPosition() > 6 && b[1].getXPosition() < 750 && b[1].getYPosition() > 0)
                     {
                    	 b[1].setXPosition(b[1].getXPosition() - (eq1 * directionX[1]));
                    	 b[1].setYPosition(b[1].getYPosition() - eq2 * directionY[1]);
                     }
                     
                     if (b[1].getXPosition() >= 743)
                     {
                    	 directionX[1] = - directionX[1];
                     }
                     
                     if (b[1].getXPosition() <= 10)
                     {
                    	 directionX[1] = - directionX[1];
                     }
                     if (b[1].getYPosition() <= 10)
                     {
                    	 directionY[1] = - directionY[1];
                     }
                 }
                 
                 
                 
                 
                 if (pause >= 20)
                 {                 
                     if (b[2].getXPosition() > 6 && b[2].getXPosition() < 750 && b[2].getYPosition() > 0)
                     {
                    	 b[2].setXPosition(b[2].getXPosition() - (eq1 * directionX[2]));
                    	 b[2].setYPosition(b[2].getYPosition() - eq2 * directionY[2]);
                     }
                     
                     if (b[2].getXPosition() >= 743)
                     {
                    	 directionX[2] = - directionX[2];
                     }
                     
                     if (b[2].getXPosition() <= 10)
                     {
                    	 directionX[2] = - directionX[2];
                     }
                     if (b[2].getYPosition() <= 10)
                     {
                    	 directionY[2] = - directionY[2];
                     }  
                 }
                 
                 
                 
                 
                 if (pause >= 30)
                 {                 
                     if (b[3].getXPosition() > 6 && b[3].getXPosition() < 750 && b[3].getYPosition() > 0)
                     {
                    	 b[3].setXPosition(b[3].getXPosition() - (eq1 * directionX[3]));
                    	 b[3].setYPosition(b[3].getYPosition() - eq2 * directionY[3]);
                     }
                     
                     if (b[3].getXPosition() >= 743)
                     {
                    	 directionX[3] = - directionX[3];
                     }
                     
                     if (b[3].getXPosition() <= 10)
                     {
                    	 directionX[3] = - directionX[3];
                     }
                     
                     if (b[3].getYPosition() <= 10)
                     {
                    	 directionY[3] = - directionY[3];
                     }
                 }
                 
                 
                 
                 
                 if (pause >= 40)
                 {                 
                     if (b[4].getXPosition() > 6 && b[4].getXPosition() < 750 && b[4].getYPosition() > 0)
                     {
                    	 b[4].setXPosition(b[4].getXPosition() - (eq1 * directionX[4]));
                    	 b[4].setYPosition(b[4].getYPosition() - eq2 * directionY[4]);
                     }
                     
                     if (b[4].getXPosition() >= 743)
                     {
                    	 directionX[4] = - directionX[4];
                     }
                     
                     if (b[4].getXPosition() <= 10)
                     {
                    	 directionX[4] = - directionX[4];
                     }
                     
                     if (b[4].getYPosition() <= 10)
                     {
                    	 directionY[4] = - directionY[4];
                     } 
                 }
                 
                 
                 int margin1 = 0;
                 int margin2 = 0;
          	            
                 
                 for (int brickCount = 0; brickCount < 5; brickCount++)
                 {
                	 for (int counter = 0; counter < 5; counter++)
                     {
                      
                	 	 if ( (b[counter].getXPosition() > 158 + margin1 && b[counter].getXPosition() < 165 + margin1) && 
                			  (b[counter].getYPosition() > 190 && b[counter].getYPosition() < 220) &&
                			   singlebounce[brickCount] == false)
                         {
                        	 template.removeRectangle(brick[brickCount]);
                        	 directionX[counter] = - directionX[counter];
                        	 singlebounce[brickCount] = true;
                         }
                		 else if ( (b[counter].getXPosition() > 230 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                			       (b[counter].getYPosition() > 190 && b[counter].getYPosition() < 220) &&
                			        singlebounce[brickCount] == false)
                         {
                        	 template.removeRectangle(brick[brickCount]);
                        	 directionX[counter] = - directionX[counter];
                        	 singlebounce[brickCount] = true;
                         } 
                		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                			  (b[counter].getYPosition() > 185 && b[counter].getYPosition() < 192) &&
                			  singlebounce[brickCount] == false)
                         {
                        	 template.removeRectangle(brick[brickCount]);
                        	 directionY[counter] = - directionY[counter];
                        	 singlebounce[brickCount] = true;
                         }	 
                		 else if ( (b[counter].getXPosition() > 160 + margin1 && b[counter].getXPosition() < 240 + margin1) && 
                			  (b[counter].getYPosition() > 215 && b[counter].getYPosition() < 222) &&
                			  singlebounce[brickCount] == false)
                         {
                        	 template.removeRectangle(brick[brickCount]);
                        	 directionY[counter] = - directionY[counter];
                        	 singlebounce[brickCount] = true;
                         } 
                     }
                	 
                	 margin1 = margin1 + 90;
                 }
            	 
            	 
            	 
                 template.pause();
                 template.update();
             }       
        }  
    }
}


                                                              


