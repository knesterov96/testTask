package com.nka;

import com.nka.dto.Ticket;
import com.nka.dto.Tickets;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logika {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);

    public String getPriceInfo(Tickets tickets) {
        if (tickets == null) {
            return null;
        }

        List<Double> prices = new ArrayList<>();

        Map<String, Duration> aviaInfo = new HashMap<>();
        for (Ticket ticket : tickets.getTicketList()) {
            if (!Constants.VVO.equals(ticket.getOrigin())) {
                continue;
            }
            if (!Constants.TLV.equals(ticket.getDestination())) {
                continue;
            }

            prices.add(ticket.getPrice());
            Duration curranDuration = calculateDuration(ticket);
            Duration oldDuration = aviaInfo.get(ticket.getCarrier());
            if (oldDuration == null) {
                aviaInfo.put(ticket.getCarrier(), curranDuration);
                continue;
            }
            if (curranDuration.compareTo(oldDuration) >= 0) {
                continue;
            }

            aviaInfo.put(ticket.getCarrier(), curranDuration);
        }

        double avgPrice = avgPrice(prices);
        double median = medianPrice(prices);

        return printResult(aviaInfo, avgPrice - median);
    }

    private Duration calculateDuration(Ticket ticket) {
        LocalDateTime departure = LocalDateTime.parse(ticket.getDepartureDate() + " " + ticket.getDepartureTime(), FORMATTER);
        LocalDateTime arrival = LocalDateTime.parse(ticket.getArrivalDate() + " " + ticket.getArrivalTime(), FORMATTER);

        return Duration.between(departure, arrival);
    }

    private double avgPrice(List<Double> prices) {
        double avgPrice = 0;
        for (Double price : prices) {
            avgPrice += price;
        }
        return avgPrice / prices.size();
    }

    public double medianPrice(List<Double> prices) {
        prices.sort(Double::compareTo);
        double median = prices.get(prices.size() / 2);
        if (prices.size() % 2 == 0) {
            median = prices.get(prices.size() / 2) + prices.get((prices.size() / 2) - 1);
            median = median / 2;
        }
        return median;
    }

    private String printResult(Map<String, Duration> aviaInfo, double difference) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Duration> entry : aviaInfo.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(": ")
                    .append(getTime(entry.getValue()))
                    .append("\r\n");
        }

        stringBuilder.append("\r\n").append(difference);

        return stringBuilder.toString();
    }

    private String getTime(Duration duration) {
        long seconds = duration.getSeconds();
        return String.format(Constants.TIME_PRINT_FORMAT,
                seconds / 3600,
                (seconds % 3600) / 60
        );
    }
}
