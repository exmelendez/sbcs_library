package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CurrentDate {

    private String date;

    public CurrentDate() {
        this.date = getISOCurrentDate();
    }

    public String getDate() {
        return date;
    }

    /**
         * Return an ISO 8601 date for current date
         *
         * @return String with format "yyyy-MM-dd"
         */
        public static String getISOCurrentDate() {
            Date now = new Date();
            return getISO8601StringForDate(now);
        }

        /**
         * Return an ISO 8601 date for specified date/time
         *
         * @param date
         *            Date
         * @return String with format "yyyy-MM-dd"
         */
        private static String getISO8601StringForDate(Date date) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
            return dateFormat.format(date);
        }

}
