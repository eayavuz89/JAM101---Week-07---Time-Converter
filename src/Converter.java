import java.util.Arrays;

public class Converter {

    public Converter(){

    }

    public String Convert(String time) throws Exception {
        boolean amExists = time.toLowerCase().indexOf("am")>-1,
                pmExists = time.toLowerCase().indexOf("pm")>-1;

        if ( !amExists && !pmExists  ) // am ve pm yoksa valid format hatası dön
            throw new Exception("Please enter a valid time format");

        String[] s = time
                .replace("am", "")
                .replace("pm", "")
                .trim()
                .split(":");

        if(s.length!=2)
            throw new Exception( time + " has not a valid time format");

        String hour = padLeft( pmExists ?  HourConvert(s[0], pmExists ) : s[0]  , 2 , '0'),
                minute = padLeft(s[1],2,'0');

        HourValidation(hour ,amExists , pmExists);
        MinuteValidation(minute);
        return hour + ":" + minute;
    }

    private String HourConvert(String hour, Boolean pm) throws Exception{
        try {
            Integer i = Integer.parseInt(hour) ;
            if(pm && i < 12)
                i+=12;
            return padLeft(i.toString().trim(),2,'0');
        } catch(NumberFormatException e){
            throw  new Exception( hour + " is not a valid numeric value");
        }
    }


    private void HourValidation(String Hour , Boolean am, Boolean pm) throws Exception{
        if( Integer.parseInt(Hour)<0 || (am && Integer.parseInt(Hour)>12) || (pm && (Integer.parseInt(Hour) < 12 || Integer.parseInt(Hour)>23)))
            throw  new Exception( Hour.toString() + " is not a valid "+ (am ? "am" : "" ) +  (pm ? "pm" : "") +" hour value");
    }

    private void MinuteValidation(String Minute) throws Exception{
     if( Integer.parseInt(Minute)<0 ||  Integer.parseInt(Minute)>59)
         throw  new Exception( Minute.toString() + " is not a valid minute value");
    }

    /**
     * Verilen sayının önüne berlirilen miktar kadar gönderielen characterden koyar.
     * Böylece üretilen string tipinde sayı hep aynı karekter sayısında olur. Örn: 01, 10 , 93, 08
     *
     * @param  inputString Döbnüştürlecek sayı
     * @param  length SOnuçta üretilecek stringin toplamdaki karekter sayısı
     * @param  character Doldurulacak karekter
     * @return  the length of the sequence of characters represented by this
     *          object.
     */
    public String padLeft(String inputString, int length, char character) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(character);
        }
        sb.append(inputString);

        return sb.toString();
    }

}
