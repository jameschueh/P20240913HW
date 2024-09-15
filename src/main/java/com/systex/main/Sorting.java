package com.systex.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.systex.model.MyDate;

public class Sorting {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<MyDate> dateList = new ArrayList<>();
        
        System.out.println("請輸入日期：");
        System.out.println("格式為 {day,month,year}，例如：{25,9,2024},{10,9,2024},{9,8,2024},{7,8,2024}");
        String input = scanner.nextLine().trim();

        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int currentMonth = today.get(Calendar.MONTH) + 1;
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        input = input.replaceAll("^\\{|\\}$", "");
        String[] dateStrings = input.split("\\},\\{");

        for (String dateString : dateStrings) {
            dateString = dateString.trim();
            if (dateString.isEmpty()) {
                continue;
            }

            String[] parts = dateString.split(",");
            if (parts.length != 3) {
                System.out.println("無效的格式，請使用 {day,month,year} 的格式，例如：{10,9,2024}");
                continue;
            }

            try {
                int day = Integer.parseInt(parts[0].trim());
                int month = Integer.parseInt(parts[1].trim());
                int year = Integer.parseInt(parts[2].trim());

                // 檢查日期的有效性
                if (!isValidDate(day, month, year, currentYear, currentMonth, currentDay)) {
                    System.out.println("無效的日期：" + dateString);
                    continue;
                }

                dateList.add(new MyDate(day, month, year));
            } catch (NumberFormatException e) {
                System.out.println("無效的數字格式：" + dateString);
            }
        }

        System.out.print("請輸入排序依據（day, month, year）：");
        String criteria = scanner.nextLine().trim().toLowerCase();

        System.out.print("請輸入排序方式（asc, desc）：");
        String order = scanner.nextLine().trim().toLowerCase();

        // 根據使用者輸入選擇排序依據
        Comparator<MyDate> comparator;
        switch (criteria) {
            case "day":
                comparator = MyDate.DAY_MONTH_YEAR_COMP; // 日 > 月 > 年
                break;
            case "month":
                comparator = MyDate.MONTH_DAY_YEAR_COMP; // 月 > 日 > 年
                break;
            case "year":
                comparator = MyDate.YEAR_MONTH_DAY_COMP; // 年 > 月 > 日
                break;
            default:
                System.out.println("無效的排序依據，預設使用year排序");
                comparator = MyDate.YEAR_MONTH_DAY_COMP;
        }

        if ("desc".equals(order)) {
            comparator = comparator.reversed();
        }

        Collections.sort(dateList, comparator);

        System.out.println("排序結果：");
        for (MyDate date : dateList) {
            System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
        }

        scanner.close();
    }

    private static boolean isValidDate(int day, int month, int year, int currentYear, int currentMonth, int currentDay) {

        if (year > currentYear) {
            return false;
        }

        if (year == currentYear) {
            if (month > currentMonth) {
                return false;
            }
            if (month == currentMonth && day > currentDay) {
                return false;
            }
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int maxDay;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDay = 31;
                break;
            case 4: case 6: case 9: case 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = (isLeapYear(year) ? 29 : 28);
                break;
            default:
                return false;
        }
        return day >= 1 && day <= maxDay;
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

