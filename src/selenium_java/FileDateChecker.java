package selenium_java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileDateChecker {
    public static void main(String[] args) {
        // File name
        String fileName = "Template Bot CARPs DROP 6.19";

        // Extract date and month from the file name
        String[] parts = fileName.split(" ");
        String datePart = parts[parts.length - 1];
        String[] dateParts = datePart.split("\\.");

        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);

        // Get today's date
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentDay = today.getDayOfMonth();

        // Check if the extracted date matches today's date
        if (month == currentMonth && day == currentDay) {
            System.out.println("The file is for today's date: " + today.format(DateTimeFormatter.ofPattern("MM-dd")));
        } else {
            System.out.println("The file is not for today's date. It is for: " + String.format("%02d-%02d", month, day));
        }
    }
}
