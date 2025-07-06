enum Day {
    MONDAY(){
    // Enum constants are implemented as anonymous inner classes behind the scenes.
      @Override
      public String getNumberOfDay(){
        return "1st day of a weak";
      }
    },
    TUESDAY(){ 
      @Override
      public String getNumberOfDay(){
        return "2nd day of a weak";
      }
    },
    WEDNESDAY(){
      @Override
      public String getNumberOfDay(){
        return "3rd day of a weak";
      }
    },
    THURSDAY(){
      @Override
      public String getNumberOfDay(){
        return "4th day of a weak"; 
      }   
    },
    FRIDAY(){ 
      @Override
      public String getNumberOfDay(){
        return "5th day of a weak";
      }
    },
    SATURDAY(){
      @Override
      public String getNumberOfDay(){
        return "6th day of a weak";
      }
    },
    SUNDAY() {
      @Override
      public String getNumberOfDay(){
        return "7th day of a weak";
      }
    };

  public abstract String getNumberOfDay();
}

public class Enum4Abstract {
    public Day day;

    //Using anonymous class here
    public Enum4Abstract(Day day) {
        this.day = day;
    };

    public static void main (String[] args) {
      Enum4Abstract daynum = new Enum4Abstract(Day.MONDAY );
      System.out.println("The "+daynum.day.name()+" is "+daynum.day.getNumberOfDay());
      
      daynum = new Enum4Abstract(Day.SATURDAY );
      System.out.println("The "+daynum.day.name()+" is "+daynum.day.getNumberOfDay());
    }  
}
