package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.util.Functions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusyFlightsConverterTests {

    @InjectMocks
    BusyFlightsConverter sut;

    @Mock
    ToughJetResponse thoughJetResponse;

    @Before
    public void setUp() {
        mockThoughJetResponse();
    }

    @Test
    public void getBusyFlightResponse(){
        BusyFlightsResponse busyFlightsResponse = sut.getBusyFlightResponse(thoughJetResponse);
        assertThat(busyFlightsResponse.getAirline(), is("TOU1"));
        assertThat(busyFlightsResponse.getSupplier(), is("ToughJet"));
        assertThat(busyFlightsResponse.getFare(), is(37.42));
        assertThat(busyFlightsResponse.getDepartureAirportCode(), is("AIC"));
        assertThat(busyFlightsResponse.getDestinationAirportCode(), is("CIA"));
        assertThat(busyFlightsResponse.getDepartureDate(),
                is(LocalDateTime.ofInstant(thoughJetResponse.getOutboundDateTime(), ZoneOffset.UTC)));
        assertThat(busyFlightsResponse.getArrivalDate(),
                is(LocalDateTime.ofInstant(thoughJetResponse.getInboundDateTime(), ZoneOffset.UTC)));
    }

    private void mockThoughJetResponse(){
        when(thoughJetResponse.getCarrier()).thenReturn("TOU1");
        when(thoughJetResponse.getSupplierType()).thenReturn("ToughJet");
        when(thoughJetResponse.getBasePrice()).thenReturn(20.11);
        when(thoughJetResponse.getTax()).thenReturn(2.2);
        when(thoughJetResponse.getDiscount()).thenReturn(3.1);
        when(thoughJetResponse.getDepartureAirportName()).thenReturn("AIC");
        when(thoughJetResponse.getArrivalAirportName()).thenReturn("CIA");
        when(thoughJetResponse.getOutboundDateTime()).thenReturn(Functions.generateInstant("2017-08-17T01:33:56.123Z"));
        when(thoughJetResponse.getInboundDateTime()).thenReturn(Functions.generateInstant("2017-09-26T09:24:45.455Z"));
    }
}
