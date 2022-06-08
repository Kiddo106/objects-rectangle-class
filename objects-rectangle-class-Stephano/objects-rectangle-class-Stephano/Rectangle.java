/*Stephano Ghdaye
 * ICS3U
 * October 23, 2018
 * This program will take in the dimensions and coordinates on two rectangle and tell the user their
 * length, width, area, perimeter, etc.
 */



class Rectangle{
  //Variables
  private int left;
  private int bottom;
  private int width;
  private int height;
  
  
  Rectangle(){ //Rectangle contructor method
  //Initializing variables
    left = 0;
   bottom = 0;
    width = 0;
    height = 0;
  }
  
  Rectangle (int left, int bottom, int width, int height){ //Second Rectangle contructor method
    this.left = left;
     this.bottom = bottom;
     this.width = width;
     this.height = height;
    set (left,  bottom,  width,  height);
  }
  public void set(int left, int bottom, int width, int height){ //Mutator method 
     if (width < 0){
     width = 0; 
    } 
    else if (height < 0){
      height = 0;
    }

  }
  
  public String toString(){ //Returns the outbut for the user
  return "base: ("+left+ ","+bottom+") w:"+width+" h:"+height;
  
  }
  public int area(int width, int height){ //Instance method that returns the area for the user
  
  return width * height;
  }
  public int perimeter (int width, int height){ //Returns perimeter of the rectangle
  return (2*width + 2*height);
  }
  
  
  
    //Instance method contains
  public boolean contains(Rectangle other){
  
  
 return bottom <=other.bottom && left <= other.left && bottom +height >= other.bottom + other.height && left +width >= other.left +other.width;
  }
  //Class method totalPerimeter
  public static int totalPerimeter(Rectangle rA, Rectangle rB){
  Rectangle rC = new Rectangle();
    if (rA.contains(rB)){
      
      return rA.perimeter(rA.width,rA.height);
    }
    else if(rB.contains(rA) ) {
      
    return rB.perimeter(rB.width, rB.height);
    }
    else if (intersection(rA,rB).width == 0 || intersection(rA,rB).height == 0) {
    
      return rA.perimeter(rA.width, rA.height) + rB.perimeter(rB.width, rB.height) - intersection(rA,rB).perimeter(rB.width,rB.height) *2;
    }
    else{
    
    return rA.perimeter(rA.width, rA.height) + rB.perimeter(rB.width, rB.height) - rC.perimeter(rC.width, rC.height);
    }
    
  }
  

  
  
  //Class method intersection
  public static Rectangle intersection(Rectangle rA, Rectangle rB){
   Rectangle rC = new Rectangle();

   
   //Checks if the rectangles do NOT intersect
   if (rA.bottom > rB.bottom + rB.height || rB.bottom > rA.bottom + rA.height || rA.left > rB.left +rB.width || rA.left + rA.width < rB.left){
   
   return rC;
   
   }
   else{ // If the rectangles only touch
   
     int recXR = Math.min (rA.left + rA.width, rB.left + rB.width);
     int recXL = Math.max(rA.left,rB.left);
     int recYB = Math.max (rA.bottom, rB.bottom);
     int recYT = Math.min (rA.bottom + rA.height, rB.bottom +rB.height);
       
       
   return rC = new Rectangle(recXL, recYB, recXR - recXL, recYT - recYB);
   }
   
  } 
  
}
//End program