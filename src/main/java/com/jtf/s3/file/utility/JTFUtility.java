package com.jtf.s3.file.utility;

import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class JTFUtility {

    private static final String Date_format = "yyyyMMddHHmmssSSS";

    public static String generateTransactionId() {
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        int p = vmName.indexOf("@");
        String pid = vmName.substring(0, p);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtTmFormater = DateTimeFormatter.ofPattern(Date_format);
        String formattedDate = localDateTime.format(dtTmFormater);
        return String.valueOf(pid).concat(formattedDate);
    }

}
