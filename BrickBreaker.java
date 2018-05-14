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
                    
                     template.update();
          	         
          	         change = true;
                 }
            	 
            	 
            	 if (template.leftPressed() )
        	     {
        		     aim.setEnd(aim.getEndX() - 1.2, aim.getEndY() - 1);
        	     }
            	 
            	 if ((aim.getEndY() < 568) && (template.rightPressed()))
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
                    
                     template.update();
          	         
          	         change = true;       
                 }
            	      	 
            	 
        	       if (template.rightPressed())
        	       {
        		       aim.setEnd(aim.getEndX() + 1.2, aim.getEndY() - 1);
        	       }
        	           
        	       if ((aim.getEndY() < 568) && (template.leftPressed()))
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
     		         paddle1.setXPosition(paddle1.getXPosition() + 10);
     		         paddle2.setXPosition(paddle2.getXPosition() + 10);
     		         paddle3.setXPosition(paddle3.getXPosition() + 10);
     	         }
                
                if ((template.leftPressed()) && (paddle1.getXPosition() > 55))
     	         {
     		         paddle1.setXPosition(paddle1.getXPosition() - 10);
     		         paddle2.setXPosition(paddle2.getXPosition() - 10);
     		         paddle3.setXPosition(paddle3.getXPosition() - 10);
     	         }
                 
                 
                template.pause();
                template.update();
             }       
        }  
    }
}


                                                              

