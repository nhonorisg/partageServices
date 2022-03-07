package org.sakdavong.partagedeservices.Metier;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Classe permettant de convertir des Dates sous for
public class UtilitaireDate {
    private static DateFormat dateFormatateFormat;
    private static DateFormat dateFormatateDateSeuleFormat;
    private static Calendar calendar;


    static {
        Locale.setDefault(Locale.FRANCE); TimeZone.setDefault(TimeZone.getTimeZone("FR"));
        dateFormatateFormat=new SimpleDateFormat("dd/MM/yy HH:mm");
        dateFormatateDateSeuleFormat=new SimpleDateFormat("dd/MM/yy");
        calendar = Calendar.getInstance(TimeZone.getTimeZone("FR"), Locale.FRANCE);
    }

    public static Date calculerDate(String date)
    {
        try {
            return dateFormatateFormat.parse(date);
        } catch (ParseException e) {
            return new Date(0L);
        }

    }

    public static String calculerDateString(int year, int month, int day, int hour, int minute)
    {
        calendar.set(year, month, day, hour, minute, 0);
        return  dateFormatateFormat.format(calendar.getTime());

    }

    public static String calculerDateStringMaintenant()
    {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("FR"), Locale.FRANCE);
        return  dateFormatateFormat.format(calendar.getTime());

    }

    public static String calculerDateSeuleString(Date date)
    {
        return  dateFormatateDateSeuleFormat.format(date);

    }

    public static String calculerHeureSeuleString(Date date)
    {
        calendar.setTime(date);
        String zeroAvant="", zeroApres="";

        if (calendar.get(Calendar.MINUTE)==0)
            zeroApres = "0";
        else
            if (calendar.get(Calendar.MINUTE)<10)
                zeroAvant = "0";
        return ""+calendar.get(Calendar.HOUR_OF_DAY)+":"+zeroAvant+calendar.get(Calendar.MINUTE)+zeroApres;
    }

    public static int calculerHeure(String date)
    {
        try {
            calendar.setTime(dateFormatateFormat.parse(date));
        } catch (ParseException e) {
            return 0;
        }
        return calendar.get(Calendar.HOUR_OF_DAY);

    }

    public static int calculerMinute(String date)
    {
        try {
            calendar.setTime(dateFormatateFormat.parse(date));
        } catch (ParseException e) {
            return 0;
        }
        return calendar.get(Calendar.MINUTE);

    }

    public static int calculerAnnee(String date)
    {
        try {
            calendar.setTime(dateFormatateFormat.parse(date));
        } catch (ParseException e) {
            return 0;
        }
        return calendar.get(Calendar.YEAR);

    }

    public static int calculerMois(String date)
    {
        try {
            calendar.setTime(dateFormatateFormat.parse(date));
        } catch (ParseException e) {
            return 0;
        }
        return calendar.get(Calendar.MONTH);

    }

    public static int calculerJour(String date)
    {
        try {
            calendar.setTime(dateFormatateFormat.parse(date));
        } catch (ParseException e) {
            return 0;
        }
        return calendar.get(Calendar.DAY_OF_MONTH);

    }
}
