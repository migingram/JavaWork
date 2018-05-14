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

    	    
        Rectangle[] b = new Rectangle[25];
    	    
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
     	        b[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#b87333");
                template.addRectangle(b[counter1]);
     	    }
     	    else if ((counter1 > 4 && counter1 < 11) || (counter1 > 13 && counter1 < 20))
     	    {
     	  	    b[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#5a5b5e");
                template.addRectangle(b[counter1]);
     	    }
     	    else if ((counter1 == 11) || (counter1 == 13))
     	    {
     		    b[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#D4AF37");
                template.addRectangle(b[counter1]);
     	    }
     	    else if ((counter1 == 12))
     	    {
     		    b[counter1] = new Rectangle(200 + marginX, 200 + marginY, 80, 30, "#dce1ea");
                template.addRectangle(b[counter1]);
     	    }
          
            marginX = marginX + 90;
            template.update();
            
        }
        
        
        
        boolean change = false;
        
        Rectangle paddle1 = new Rectangle(385, 580, 80, 10, "FFFFFF");
	    Rectangle paddle2 = new Rectangle(352, 585, 14, 20, "FFFFFF");
	    Rectangle paddle3 = new Rectangle(418, 585, 14, 20, "FFFFFF");
	    
	    Ball ball = new Ball(385, 560, 6, "FFFFFF");
	    
	    
        double eq1 = 0;
        int direction1 = 1;
        int direction2 = 1;
	            
        
	    while (true)
        {   
             while ((aim.getStartX() <= aim.getEndX()) && (change == false))
             {
            	 
            	 if (template.spacePressed())
                 {
            		 aim.setColour("000000");
         	         
         	         template.addRectangle(paddle1);
                     template.addRectangle(paddle2);
                     template.addRectangle(paddle3);
                     
                     template.addBall(ball);
                    
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
         	         
         	         template.addRectangle(paddle1);
                     template.addRectangle(paddle2);
                     template.addRectangle(paddle3);
                     
                     template.addBall(ball);
                    
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
            	 if ((template.rightPressed()) && (paddle1.getXPosition() < 700))
     	         {
     		         paddle1.setXPosition(paddle1.getXPosition() + 12);
     		         paddle2.setXPosition(paddle2.getXPosition() + 12);
     		         paddle3.setXPosition(paddle3.getXPosition() + 12);
     	         }
                
                if ((template.leftPressed()) && (paddle1.getXPosition() > 55))
     	         {
     		         paddle1.setXPosition(paddle1.getXPosition() - 12);
     		         paddle2.setXPosition(paddle2.getXPosition() - 12);
     		         paddle3.setXPosition(paddle3.getXPosition() - 12);
     	         }
                
               
                
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
                 
                 double eq2 = Math.sqrt(aim.getStartY() - aim.getEndY());
                 
                 if (ball.getXPosition() > 6 && ball.getXPosition() < 750 && ball.getYPosition() > 0)
                 {
                     ball.setXPosition(ball.getXPosition() - (eq1 * direction1));
                     ball.setYPosition(ball.getYPosition() - eq2 * direction2);
                 }
                 
                 if (ball.getXPosition() >= 743)
                 {
                	 direction1 = - direction1;
                 }
                 
                 if (ball.getXPosition() <= 10)
                 {
                	 direction1 = - direction1;
                 }
                 if (ball.getYPosition() <= 10)
                 {
                	 direction2 = - direction2;
                 }
                 
                 if ((ball.getYPosition() == paddle1.getYPosition()) && (ball.getXPosition() == paddle1.getXPosition()))
                 {
                	 direction2 = - direction2;
                 }
                 
                 template.pause();
                 template.update();
             }       
        }  
    }
}


                                                              

