package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.repository.validator.BusyFlightsValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BusyFlightsRepositoryTests {


    private static final BusyFlightsRepositoryTestable class2 = mock(BusyFlightsRepositoryTestable.class);

    @Mock
    RestTemplate restTemplate;

    @Mock
    BusyFlightsConverter busyFlightsConverter;

    @Mock
    BusyFlightsValidator busyFlightsValidator;

    @Test
    public void getSupplierResponse(){
        class2.getSupplierResponse("",null,null);

    }

    class BusyFlightsRepositoryTestable extends BusyFlightsRepository {

        @Autowired
        public BusyFlightsRepositoryTestable(BusyFlightsConverter busyFlightsConverter, BusyFlightsValidator busyFlightsValidator, RestTemplate restTemplate) {
            super(busyFlightsConverter, busyFlightsValidator, restTemplate);
        }

        @Override
        public SuppliersResponse[] search(BusyFlightsRequest request) {
            return new SuppliersResponse[0];
        }

        @Override
        protected <T, R extends T> T getSupplierResponse(String urlTemplate, Class<R> responseType, Object[] uriArguments) {
            return super.getSupplierResponse(urlTemplate, responseType, uriArguments);
        }
    }
}
