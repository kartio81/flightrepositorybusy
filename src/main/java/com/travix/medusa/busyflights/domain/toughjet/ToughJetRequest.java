package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.SuppliersRequest;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToughJetRequest implements SuppliersRequest{

    @Size(min = 3, max = 3)
    private String from;
    @Size(min = 3, max = 3)
    private String to;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate outboundDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate inboundDate;
    private int numberOfAdults;

    public ToughJetRequest() {

    }

    public ToughJetRequest(String from, String to, LocalDate outboundDate, LocalDate inboundDate, int numberOfAdults) {
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public LocalDate getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public Object[] getSupplierParameters() {
        List<String> out = new ArrayList<>();

        out.add(this.from);
        out.add(this.to);
        out.add(this.outboundDate.toString());
        out.add(this.inboundDate.toString());
        out.add(String.valueOf(this.numberOfAdults));

        return out.toArray();
    }

    @Override
    public String toString() {
        return "ToughJetRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", outboundDate=" + outboundDate +
                ", inboundDate=" + inboundDate +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
