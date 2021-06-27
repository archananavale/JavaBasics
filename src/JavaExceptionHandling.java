import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }

}

public class JavaExceptionHandling {
    public void checkCountry(String country) throws CustomException {
        List<String>  list= new ArrayList<>(Arrays.asList("India","Germany","USA","Canada","Shrilanka")) ;
        if(list.contains(country)){
            throw new CustomException("country already exists ");
        }else{
            list.add(country);
            System.out.println("Country added successfully");
        }
    }
    public static void main(String[] args)   {
        JavaExceptionHandling obj= new JavaExceptionHandling();
      try {
          obj.checkCountry("uk");
      }catch (CustomException e)
      {
          System.out.println(e.getMessage());
      }
    }

}
