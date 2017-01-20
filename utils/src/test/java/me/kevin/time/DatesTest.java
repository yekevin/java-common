package me.kevin.time;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class DatesTest {

    @Test
    public void now() {
        Date expect = new Date();
        assertThat(Dates.now().getTime()).isBetween(expect.getTime(), expect.getTime() + 10);
    }

    @Test
    public void format() {
        Date date = new Date();
        String expectFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        assertThat(expectFormat).isEqualToIgnoringWhitespace(Dates.format(date));
        assertThat(expectFormat).isEqualToIgnoringWhitespace(Dates.format(date.getTime()));

        expectFormat = new SimpleDateFormat("yyyy-MM-dd").format(date);
        assertThat(expectFormat).isEqualToIgnoringWhitespace(Dates.format(date, "yyyy-MM-dd"));
        assertThat(expectFormat).isEqualToIgnoringWhitespace(Dates.format(date.getTime(), "yyyy-MM-dd"));
    }

    @Test
    public void toDate() throws ParseException {
        String dateTimeStr = "2015-11-23 10:41:00";
        Date expectDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeStr);

        assertThat(Dates.toDate(dateTimeStr).getTime()).isEqualTo(expectDate.getTime());
        assertThat(Dates.toDate(dateTimeStr, "yyyy-MM-dd HH:mm:ss").getTime()).isEqualTo(expectDate.getTime());

        Date date = new Date();
        assertThat(Dates.toDate(date.getTime()).getTime()).isEqualTo(date.getTime());
    }

    @Test
    public void timeInterval() throws ParseException {
        String start = "2017-01-20 15:45:00";
        String end = "2017-01-20 16:00:00";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        long interval = Dates.timeInterval(Dates.toDate(start), Dates.toDate(end));
        assertThat(interval).isEqualTo((endDate.getTime() - startDate.getTime()) / 1000);
    }

    @Test
    public void startOfDay() throws ParseException {
        String dateStr = "2017-01-20";
        String expectDateStr = "2017-01-20 00:00:00";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        Date expectDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expectDateStr);

        assertThat(Dates.startOfDay(date).getTime()).isEqualTo(expectDate.getTime());
    }

    @Test
    public void endOfDay() throws ParseException {
        String dateStr = "2017-01-20";
        String expectDateStr = "2017-01-20 23:59:59";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        Date expectDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expectDateStr);

        assertThat(Dates.endOfDay(date).getTime() / 1000).isEqualTo(expectDate.getTime() / 1000);
    }

    @Test
    public void addMinutes() {
        Date date = new Date();
        // 5分钟
        Date expect = new Date(date.getTime() + 5 * 60 * 1000L);

        assertThat(Dates.addMinutes(date, 5).getTime()).isEqualTo(expect.getTime());
    }

    @Test
    public void addHour() {
        Date date = new Date();
        // 5小时
        Date expect = new Date(date.getTime() + 5 * 60 * 60 * 1000L);

        assertThat(Dates.addHours(date, 5).getTime()).isEqualTo(expect.getTime());
    }

    @Test
    public void addDay() {
        Date date = new Date();
        // 5天
        Date expect = new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000L);

        assertThat(Dates.addDays(date, 5).getTime()).isEqualTo(expect.getTime());
    }

    @Test
    public void addWeek() {
        Date date = new Date();
        // 5周
        Date expect = new Date(date.getTime() + 5 * 7 * 24 * 60 * 60 * 1000L);

        assertThat(Dates.addWeeks(date, 5).getTime()).isEqualTo(expect.getTime());
    }

    @Test
    public void addYear() {
        Date date = new Date();
        // 1年
        Date expect = new Date(date.getTime() + 1 * 365 * 24 * 60 * 60 * 1000L);

        assertThat(Dates.addYears(date, 1).getTime()).isEqualTo(expect.getTime());
    }

    @Test
    public void isAfter() {
        Date start = new Date();
        Date end = new Date(start.getTime() + 10000L);

        assertThat(end.after(start)).isEqualTo(Dates.isAfter(end, start));
        assertThat(end.after(start)).isEqualTo(Dates.isAfterNow(end));
    }

    @Test
    public void isBefore() {
        Date start = new Date();
        Date end = new Date(start.getTime() + 10000L);

        assertThat(start.before(end)).isEqualTo(Dates.isBefore(start, end));
        assertThat(end.before(start)).isEqualTo(Dates.isBeforeNow(end));
    }

    @Test
    public void isBetween() {
        Date now = new Date();
        Date start = new Date(now.getTime() - 10000L);
        Date end = new Date(now.getTime() + 10000L);

        assertThat(true).isEqualTo(Dates.isBetween(now, start, end));
    }

    @Test
    public void startDateOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String expect = Dates.format(calendar.getTime(), "yyyy-MM-dd");

        assertThat(expect).isEqualToIgnoringWhitespace(Dates.format(Dates.startDateOfMonth(new Date()), "yyyy-MM-dd"));
    }

    @Test
    public void endDateOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String expect = Dates.format(calendar.getTime(), "yyyy-MM-dd");

        assertThat(expect).isEqualToIgnoringWhitespace(Dates.format(Dates.endDateOfMonth(new Date()), "yyyy-MM-dd"));
    }

    @Test
    public void startDateOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        String expect = Dates.format(calendar.getTime(), "yyyy-MM-dd");

        assertThat(expect).isEqualToIgnoringWhitespace(Dates.format(Dates.startDateOfWeek(new Date()), "yyyy-MM-dd"));

    }

    @Test
    public void endDateOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        String expect = Dates.format(calendar.getTime(), "yyyy-MM-dd");

        assertThat(expect).isEqualToIgnoringWhitespace(Dates.format(Dates.endDateOfWeek(new Date()), "yyyy-MM-dd"));

    }
}
