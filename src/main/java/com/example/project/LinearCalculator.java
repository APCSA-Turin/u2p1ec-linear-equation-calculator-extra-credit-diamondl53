package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        int beginningx1 = coord1.indexOf("(");//index of the first open paranthesis//
        int endx1 = coord1.indexOf(",");//index of the first comma//
        String Stringx1 = coord1.substring(beginningx1 + 1 , endx1);//everything from the index after first parenthesis to comma is x1//
        x1 = Integer.parseInt(Stringx1);
        
        int beginningy1 = endx1+1;//start from the index right after the comma//
        int endy1 = coord1.indexOf(")");//ends at the closed parenthesis//
        String Stringy1 = coord1.substring(beginningy1 , endy1);//everything from the index after the comma up to the closed parenthesis is y1//
        y1 = Integer.parseInt(Stringy1);

        int beginningx2 = coord2.indexOf("(");//repeats the same thing except this time its on the coord2 string//
        int endx2 = coord2.indexOf(",");
        String Stringx2 = coord2.substring(beginningx2 + 1, endx2);
        x2 = Integer.parseInt(Stringx2);
        
        int beginningy2 = endx2+1;
        int endy2 = coord2.indexOf(")");
        String Stringy2 = coord2.substring(beginningy2 , endy2);
        y2 = Integer.parseInt(Stringy2);
        
        // String[] point1 = coord1.replace("(", "").replace(")", "").split(", ");
        // this.x1 = Integer.parseInt(point1[0]);
        // this.y1 = Integer.parseInt(point1[1]);
        // String[] point2 = coord1.replace("(", "").replace(")", "").split(", ");
        // this.x2 = Integer.parseInt(point1[0]);
        // this.y2 = Integer.parseInt(point2[1]);
    }
    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){//all 4 getters returns the value of each variable//
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public void setX1(int newX1){//all 4 setters update the variable to the value inputted as a parameter in this setter method //
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.pow(Math.pow(x2- x1,2)+(Math.pow(y2-y1,2)),0.5);//distance formula//
        double distanceRounded = roundedToHundredth(distance);//calls the round method to the nearest hundredth//
        return distanceRounded;
    }

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double roundedX = Math.round(x*100.0)/100.0;//uses Math.round method to round to the nearest hundredth//
        return roundedX;
    }
    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double slope;
        double slopeRounded;
        if(x1==x2){//if the x values repeat then returns -999.99//
            slopeRounded = -999.99;

        }else{
            slope = (double)(y2-y1)/(double)(x2-x1);//if it is a function, then it uses rise over run formula to return slope//
        slopeRounded = roundedToHundredth(slope);//rounds slope to the nearest hundredth//
        }
        return slopeRounded;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double yInt;
        if(slope()==-999.99){//if there is no slope, yInt is also -999.99;
            yInt = -999.99;
        }else{

        
        if(x1==0){//if one of the points has an x value of 0, then its y-intercept is just that point's y value//
             yInt=(double)y1;
            
        } else if(x2==0){
             yInt= (double)y2;
        } else{
            yInt = roundedToHundredth(y1-x1*slope());//algebra to solve for the b value or y-intercept by plugging in values for y=mx+b formula//
            //  yInt = y2-(slope()*x2);
        }
    }
        return yInt;
        
    }
    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if(slope()==0.0){
            return "y="+(double)y1;//if slope is 0, it just returns the y-value//
        }else{

        
        if(slope()==-999.99){//if no slope, then equation is undefined//
            return "undefined";
        }else if(yInt()==0.0){
            return "y="+slope()+"x";//if y intercept if 0, then it only returns y=mx//

        }else if(yInt()<0){
            return "y="+slope()+"x"+yInt();//string form when y is negative//
        }
        else{
            return "y="+slope()+"x"+"+"+yInt();//string form when y is positive//
        }
    }
    }
    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    
    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if(x1==x2&&y1==-1*y2){//checks if the x values are equal and if the y values are opposite of each other//
            return "Symmetric about the x-axis";
        }else if(y1==y2&&x1==-1*x2){//checks if y values are equal and if x values are opposite of each other//
            return "Symmetric about the y-axis";
        }else if(x1==-1*x2&&y1==-1*y2){//checks if both the x and y values are opposite of each other//
            return "Symmetric about the origin";
        }else{
            return "No symmetry";
        }
        
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xmid;
        double ymid;
        xmid = (x1+x2)/2;//half of distance between these 2 points//
        ymid = (y1+y2)/2;//half of distance between these 2 points//
        
        return "The midpoint of this line is: ("+xmid+","+ymid+")";
    }
    
    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," +  y1 + ")";
        str += " and " + "(" + x2+ "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();//calls equation method//
        str += "\nThe slope of this line is: " +slope();//calls slope method//
        str += "\nThe y-intercept of the line is: " +yInt();//calls yInt method//
        str += "\nThe distance between the two points is: " +distance();//calls distance method//
        str += "\n"+findSymmetry();//method is added to str//
        str += "\n"+Midpoint();//method is added to str//
    
        return str;
    }
}



