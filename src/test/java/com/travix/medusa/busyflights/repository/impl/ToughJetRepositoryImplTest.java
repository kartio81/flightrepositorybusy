package com.travix.medusa.busyflights.repository.impl;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToughJetRepositoryImplTest {

    @InjectMocks
    ToughJetRepositoryImpl sut;

    @Mock
    BusyFlightsConverter busyFlightsConverter;

    @Test
    public void search(){
        when(busyFlightsConverter.toToughJetRequest(anyObject())).thenReturn(mockToughJetRequest());

        when(sut.getToughJetSupplier(anyObject())).thenReturn(null);
    }

    public ToughJetRequest mockToughJetRequest(){
        ToughJetRequest toughJetRequest = new ToughJetRequest();

        toughJetRequest.setFrom("EXA");
        toughJetRequest.setTo("AXE");
        toughJetRequest.setOutboundDate(generateLocalDate("2016-11-10"));
        toughJetRequest.setInboundDate(generateLocalDate("2016-12-12"));
        toughJetRequest.setNumberOfAdults(2);

        return toughJetRequest;
    }

    public SuppliersResponse[] mockSuppliersResponses(){
        SuppliersResponse[] suppliersResponses = new SuppliersResponse[2];


        suppliersResponses[0] = null;

        return suppliersResponses;
    }

    public CrazyAirResponse mockCrazyAirResponse(){
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        return crazyAirResponse;
    }

    public static LocalDate generateLocalDate(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDate.parse(str, formatter);
    }


}
