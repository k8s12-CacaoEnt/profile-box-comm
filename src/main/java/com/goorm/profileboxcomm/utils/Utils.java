package com.goorm.profileboxcomm.utils;

import com.goorm.profileboxcomm.enumeration.ExceptionEnum;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Utils {

    public static String dateToString(Date date) {
        return date.toString();
    }

    public static Date stringToDate(String date) {
        try{
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }catch (Exception e){
            throw new ApiException(ExceptionEnum.INVALID_DATE_FORMAT);
        }
    }

    public static Timestamp locaclDateToTimestamp(LocalDateTime date) {
        return Timestamp.valueOf(date);
    }
}
