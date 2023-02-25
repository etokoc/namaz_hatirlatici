package com.ertugrul.myjava.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Extentions {
    /**
     * Index ile gün adlarını alma
     */
    public static String getDateWithIndex(Integer dayIndex) {
        if (dayIndex != null && dayIndex < 7 && dayIndex > -1) {
            return DaysEnum.values()[dayIndex].name();
        } else return DaysEnum.CUMA.name();
    }

    /**
     * Tarihi almak
     */
    public static String getDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        return format.format(date);
    }

    /**
     * Hicri tarihi almak- (eğer android versiyon O'dan düşük ise normal tarih verir. )
     */
    public static String getHijraDate() {
        HijrahDate hijraDate;
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate localeDate = LocalDate.now();
            hijraDate = HijrahDate.from(localeDate);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
            return hijraDate.format(dateTimeFormatter);
        } else {
            date = Calendar.getInstance().getTime();
            return format.format(date);
        }
    }
}
