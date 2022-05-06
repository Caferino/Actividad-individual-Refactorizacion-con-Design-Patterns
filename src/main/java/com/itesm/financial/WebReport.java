package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WebReport {

    // CREATES FILE IN ASCII FORMAT (For Console use only)
    public String createContentASCII(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeadersASCII("\n\t\t\t\t Taxi Report \n"));
        builder.append(createTableHeadersASCII());
        rides.forEach( ride -> {
            builder.append(addRideASCII(ride));
        });
        builder.append(closeTableHeadersASCII());

        return builder.toString();
    }

    private String createHeadersASCII(String title){
        return "\t" + title;
    }

    private String createTableHeadersASCII() {
        return "--------------------------------------------------------------------------------------------------------------------" +
                "\n" +
                    "TaxiID" +
                    "\tPickup time" +
                    "\t\t\tDropoff time" +
                    "\t\t   Passengers" +
                    " Distance" +
                    " Total" +
                "\n";
    }

    private String closeTableHeadersASCII() {
        return "----------------------------------------------- END OF TABLE -------------------------------------------------------";
    }

    private String addRideASCII(Ride ride) {
        return "\n" +
                ride.getTaxiId() +
                "\t" + ride.getPickUpTime() +
                "\t" + ride.getDropOffTime() +
                "\t" + ride.getPassengerCount() +
                "\t" + ride.getTripDistance() +
                "\t" + ride.getTollsAmount() +
                "\n";
    }

    // CREATES FILE IN HTML FORMAT
    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeaders("Taxi Report"));
        builder.append(createTableHeaders());
        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });
        builder.append(closeTableHeaders());

        return builder.toString();
    }

    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.html");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    private String createHeaders(String title){
        return "<h1>" + title + "</h1>";
    }

    private String createTableHeaders() {
        return "<table>" +
                "<tr>" +
                    "<th> TaxiID </th>" +
                    "<th> Pickup time </th>" +
                    "<th> Dropoff time </th>" +
                    "<th> Passenger count </th>" +
                    "<th> Trip Distance </th>" +
                    "<th> Total amount </th>" +
                "</tr>";
    }

    private String closeTableHeaders() {
        return "</table>";
    }

    private String addRide(Ride ride) {
        return "<tr>" +
                "<td>" + ride.getTaxiId() + "</td>" +
                "<td>" + ride.getPickUpTime() + "</td>" +
                "<td>" + ride.getDropOffTime() + "</td>" +
                "<td>" + ride.getPassengerCount() + "</td>" +
                "<td>" + ride.getTripDistance() + "</td>" +
                "<td>" + formatAmount(ride.getTollsAmount()) + "</td>" +
                "</tr>";
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "<span style='color:red'>" + amount + "</span>";
        }
        return Double.toString(amount);
    }
}
