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
	    
	    Ball b1 = new Ball(385, 560, 6, "FFFFFF");
	    Ball b2 = new Ball(385, 560, 6, "FFFFFF");
	    Ball b3 = new Ball(385, 560, 6, "FFFFFF");
	    Ball b4 = new Ball(385, 560, 6, "FFFFFF");
	    Ball b5 = new Ball(385, 560, 6, "FFFFFF");
	    
	    int pause = 0;
	    
        double eq1 = 0;
        double eq2 = 0;
        
        int directionX1 = 1;
        int directionY1 = 1;
        
        int directionX2 = 1;
        int directionY2 = 1;
        
        int directionX3 = 1;
        int directionY3 = 1;
        
        int directionX4 = 1;
        int directionY4 = 1;
        
        int directionX5 = 1;
        int directionY5 = 1;
        
	            
        
	    while (true)
        {   
             while ((aim.getStartX() <= aim.getEndX()) && (change == false))
             {
            	 
            	 if (template.spacePressed())
                 {
            		 aim.setColour("000000");
                     
                     template.addBall(b1);
                     template.addBall(b2);
                     template.addBall(b3);
                     template.addBall(b4);
                     template.addBall(b5);
                    
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

                     template.addBall(b1);
                     template.addBall(b2);
                     template.addBall(b3);
                     template.addBall(b4);
                     template.addBall(b5);
                    
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
                 
                 if (b1.getXPosition() > 6 && b1.getXPosition() < 750 && b1.getYPosition() > 0)
                 {
                     b1.setXPosition(b1.getXPosition() - (eq1 * directionX1));
                     b1.setYPosition(b1.getYPosition() - eq2 * directionY1);
                 }
                 
                 if (b1.getXPosition() >= 743)
                 {
                	 directionX1 = - directionX1;
                 }
                 
                 if (b1.getXPosition() <= 10)
                 {
                	 directionX1 = - directionX1;
                 }
                 if (b1.getYPosition() <= 10)
                 {
                	 directionY1 = - directionY1;
                 }
                 
                 pause = pause + 1;
                 
                 if (pause >= 10)
                 {                 
                     if (b2.getXPosition() > 6 && b2.getXPosition() < 750 && b2.getYPosition() > 0)
                     {
                    	 b2.setXPosition(b2.getXPosition() - (eq1 * directionX2));
                    	 b2.setYPosition(b2.getYPosition() - eq2 * directionY2);
                     }
                     
                     if (b2.getXPosition() >= 743)
                     {
                    	 directionX2 = - directionX2;
                     }
                     
                     if (b2.getXPosition() <= 10)
                     {
                    	 directionX2 = - directionX2;
                     }
                     if (b2.getYPosition() <= 10)
                     {
                    	 directionY2 = - directionY2;
                     }
                 }
                 
                 if (pause >= 20)
                 {                 
                     if (b3.getXPosition() > 6 && b3.getXPosition() < 750 && b3.getYPosition() > 0)
                     {
                    	 b3.setXPosition(b3.getXPosition() - (eq1 * directionX3));
                    	 b3.setYPosition(b3.getYPosition() - eq2 * directionY3);
                     }
                     
                     if (b3.getXPosition() >= 743)
                     {
                    	 directionX3 = - directionX3;
                     }
                     
                     if (b3.getXPosition() <= 10)
                     {
                    	 directionX3 = - directionX3;
                     }
                     if (b3.getYPosition() <= 10)
                     {
                    	 directionY3 = - directionY3;
                     }
                 }
                 
                 if (pause >= 30)
                 {                 
                     if (b4.getXPosition() > 6 && b4.getXPosition() < 750 && b4.getYPosition() > 0)
                     {
                    	 b4.setXPosition(b4.getXPosition() - (eq1 * directionX4));
                    	 b4.setYPosition(b4.getYPosition() - eq2 * directionY4);
                     }
                     
                     if (b4.getXPosition() >= 743)
                     {
                    	 directionX4 = - directionX4;
                     }
                     
                     if (b4.getXPosition() <= 10)
                     {
                    	 directionX4 = - directionX4;
                     }
                     
                     if (b4.getYPosition() <= 10)
                     {
                    	 directionY4 = - directionY4;
                     }
                 }
                 
                 if (pause >= 40)
                 {                 
                     if (b5.getXPosition() > 6 && b5.getXPosition() < 750 && b5.getYPosition() > 0)
                     {
                    	 b5.setXPosition(b5.getXPosition() - (eq1 * directionX5));
                    	 b5.setYPosition(b5.getYPosition() - eq2 * directionY5);
                     }
                     
                     if (b5.getXPosition() >= 743)
                     {
                    	 directionX5 = - directionX5;
                     }
                     
                     if (b5.getXPosition() <= 10)
                     {
                    	 directionX5 = - directionX5;
                     }
                     
                     if (b5.getYPosition() <= 10)
                     {
                    	 directionY5 = - directionY5;
                     }
                 }
                 
                 
                 template.pause();
                 template.update();
             }       
        }  
    }
}


                                                              


