import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateTest {

    public static long randomNum(long min, long max) {

        return (long) (Math.random() * (max - min) + min);
    }

    static HashMap<Long , Long> rawData = new HashMap<>();
    static HashMap<String , Long> finalData = new HashMap<>();

    public static void main(String[] args) {
        //First day of last month
        Calendar mycalander = Calendar.getInstance();

        mycalander.add(Calendar.MONTH, -1);
        mycalander.set(Calendar.DATE, 1);
        mycalander.set(Calendar.HOUR_OF_DAY, 0);
        mycalander.set(Calendar.MINUTE, 0);
        mycalander.set(Calendar.SECOND, 0);
        mycalander.set(Calendar.MILLISECOND, 0);

        Date lastMonth1Date = mycalander.getTime();
        long epochTime1Date = lastMonth1Date.getTime();


        Calendar mysecondCal = Calendar.getInstance();

        mysecondCal.add(Calendar.MONTH, -1);
        mysecondCal.set(Calendar.DATE, mysecondCal.getActualMaximum(Calendar.DATE));
        mysecondCal.set(Calendar.HOUR_OF_DAY, 23);
        mysecondCal.set(Calendar.MINUTE, 59);
        mysecondCal.set(Calendar.SECOND, 59);
        mysecondCal.set(Calendar.MILLISECOND, 999);

        Date lastMonthLastDate = mysecondCal.getTime();

        long epochTimeLastDate = lastMonthLastDate.getTime();

        for(int i = 0; i< 500; i++){
            rawData.put( randomNum( epochTime1Date , epochTimeLastDate ) , randomNum( 10, 20 ) );
        }

        for( int d = 1; d <= mysecondCal.getActualMaximum(Calendar.DATE) ; d++ ){
            String key =  d+ "/" + (mysecondCal.get(Calendar.MONTH)+1) + "/" + mysecondCal.get(Calendar.YEAR);
            finalData.put( key, 0L );
        }


        for( Long ll : rawData.keySet() ){
//            System.out.println( ll );
            Calendar cal = Calendar.getInstance();
            cal.setTime( new Date(ll));
            String key =  cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);

//            System.out.println(key);
//            if(finalData.get(key) != null){
            try{
                finalData.put( key , finalData.get(key) + rawData.get(ll) );
            } catch (Exception d){
                System.out.println("err start");
                System.out.println(key);
                System.out.println("err end");
            }
        }

        for( String ss : finalData.keySet()){
            System.out.println( ss+ " : " + finalData.get(ss) );
        }
    }
}
