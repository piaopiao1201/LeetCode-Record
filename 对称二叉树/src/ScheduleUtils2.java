import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ScheduleUtils2 {
    /**
     * transform days and time options to cron expression
     *
     * @param tzOffset
     * @param daysOption
     * @param hourOption
     * @param minuteOption
     * @return
     */
    public static String optionsToCron(double tzOffset, String daysOption, String hourOption,String minuteOption) {
        Calendar cal = Calendar.getInstance();
        double serverOffset = (double)cal.get(Calendar.ZONE_OFFSET) / 1000 / 60 / 60;
        int[] check = convertTimeZone(tzOffset, serverOffset, Integer.valueOf(hourOption),Integer.valueOf(minuteOption));
        String[] daysOptionArr = daysOption.split("_");
        String res = "";
        switch (daysOptionArr[0]) {
            case "Everyday":
                res = "0 "+(check[1])+" " + (check[0]) + " * * ?";
                break;
            case "Point":
                int tmp = Integer.valueOf(daysOptionArr[1]) + check[2];
                if (tmp <= 0) {
                    tmp += 7;
                }
                if (tmp >= 8) {
                    tmp -= 7;
                }
                res = "0 "+(check[1])+" " + check[0] + " ? * " + (tmp);
                break;
            case "Weekday":
                res = "0 "+(check[1])+" " + check[0] + " ? * " + (2 + check[2]) + "-" + (6 + check[2]);
                break;
            case "Weekend":
                int i1 = 1 + check[2];
                if (i1 <= 0) {
                    i1 += 7;
                }
                int i2 = 7 + check[2];
                if (i2 >= 8) {
                    i2 -= 7;
                }
                res = "0 "+(check[1])+" " + check[0] + " ? * " + i1 + "," + i2;
                break;
        }
        return res;
    }

    /**
     * transform cron expressions to days and time options
     *
     * @param tzOffset
     * @param cronExpression
     * @return
     */
    public static Map<String, String> cronToOptions(double tzOffset, String cronExpression) {
        String[] cronArr = cronExpression.split(" ");
        Calendar cal = Calendar.getInstance();
        double serverOffset = (double)cal.get(Calendar.ZONE_OFFSET) / 1000 / 60 / 60;
        int[] check = convertTimeZone(serverOffset, tzOffset, Integer.valueOf(cronArr[2]),Integer.valueOf(cronArr[1]));
        Map<String, String> map = new HashMap<>();
        map.put("hour", String.valueOf(check[0]));
        map.put("minute", String.valueOf(check[1]));
        String timePeriod = cronArr[5];
        if (timePeriod.contains("?")) {
            map.put("days", "Everyday");
        } else if (timePeriod.contains("-")) {
            map.put("days", "Weekday");
        } else if (timePeriod.contains(",")) {
            map.put("days", "Weekend");
        } else {
            int outDay = Integer.valueOf(timePeriod) + check[2];
            if (outDay <= 0) {
                outDay += 7;
            }
            if (outDay >= 8) {
                outDay -= 7;
            }
            map.put("days", "Point_" + outDay);
        }
        return map;
    }

    /**
     * Calculate the current time and days difference
     *
     * @param curTimeZone
     * @param serverTimeZone
     * @param hour
     * @param minute
     * @return
     */
    public static int[] convertTimeZone(double curTimeZone, double serverTimeZone, int hour,int minute) {
        //第一个值代表转换后的时间，第二个值代表转换后的秒数，第三个值代表转换的天数 +1表示后一天 0表示当天 -1表示前一天
        int[] res = new int[3];
        double delta = serverTimeZone - curTimeZone;
        int integer=(int)delta;
        double decimal=delta-integer;
        int targetTime = hour + integer;
        if(decimal!=0){
            minute+=60*decimal;
            if(minute>=60){
                targetTime++;
                minute-=60;
            }else if(minute<0){
                targetTime--;
                minute+=60;
            }
        }
        if (targetTime >= 24) {
            targetTime -= 24;
            res[2] = 1;
        } else if (targetTime < 0) {
            targetTime += 24;
            res[2] = -1;
        }
        res[0] = targetTime;
        res[1]=minute;
        return res;
    }
}
