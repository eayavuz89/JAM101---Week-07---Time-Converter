import java.util.Scanner;

public  class main {


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Converter converter = new Converter();
        String inputTime;
        do{
            System.out.println("\n\nPlease enter a time in valid format (HH:mm hh:mm tt), to exit enter empty string: ");
            inputTime = scn.nextLine();
            try {
                System.out.println(converter.Convert(inputTime));
            }
            catch (Exception ex)
            {
                System.out.println(ex.toString());
            }

        }while(!inputTime.isBlank());
    }
}
