package com.jovan;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;

public class BookingsCsvReader {
    public static void main(String[] args) throws Exception {
        String baseDir = System.getProperty("user.dir");
        String csv = "\\csvs\\books_MJCCA.csv";
        LinkedList<BookingRow> rows = parseCsv(baseDir + csv);

        // get tot bookings, and tot facilities booked per day
        HashMap<LocalDate, Integer> dateToBookingsNum = new HashMap<>();
        HashMap<LocalDate, HashSet<String>> dateToFacilityNum = new HashMap<>();
        HashSet<LocalDate> dates = new HashSet<>();
        for (BookingRow row : rows) {
            dates.add(row.date);

            // all bookings for said day for all facilities
            Integer count = dateToBookingsNum.get(row.date);
            if (count == null) {
                count = 0;
            }
            count += row.numBookings;
            dateToBookingsNum.put(row.date, count);

            // all facilities bookings are booked in
            HashSet<String> facIds = dateToFacilityNum.get(row.date);
            if (facIds == null) {
                facIds = new HashSet<>();
                dateToFacilityNum.put(row.date, facIds);
            }
            facIds.add(row.facilityId);
        }

        ArrayList<LocalDate> sortedDates = new ArrayList<>(dates);
        Collections.sort(sortedDates);

        FileWriter csvWriter = new FileWriter(baseDir + "\\csvs\\processed\\totBookingsDay.csv");
        csvWriter.append("date,bookings,facilities\n");
        for (LocalDate d : sortedDates) {
            csvWriter.append(d.toString() + "," + dateToBookingsNum.get(d) + "," + dateToFacilityNum.get(d).size() + "\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public static LinkedList<BookingRow> parseCsv(String pathToFile) throws Exception {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToFile));
        LinkedList<BookingRow> ret = new LinkedList<>();
        String row = csvReader.readLine(); // read first line out so headers don't error out
        while((row = csvReader.readLine()) != null) {
            ret.add(new BookingRow(row));
        }
        csvReader.close();
        return ret;
    }

    public static class BookingRow {
        public LocalDate date;
        public Integer numBookings;
        public String facilityName;
        public String facilityId;
        public String parentId;

        public BookingRow(String csvStuff) {
            String[] data = csvStuff.split(",");

            numBookings = Integer.valueOf(data[0]);

            String ds[] = data[1].split("/");
            date = LocalDate.of(Integer.valueOf(ds[2]), Integer.valueOf(ds[0]), Integer.valueOf(ds[1]));

            facilityName = data[2];
            facilityId = data[3];

            if (data.length == 5)
                parentId = data[4];
        }

        public String toString() {
            return "(" + numBookings + ", " + date + ", " + facilityName + ", " + facilityId + ", " + parentId + ")";
        }

    }


}
