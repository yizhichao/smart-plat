package com.allcam.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{
    @Override
    protected Object determineCurrentLookupKey()
    {
        System.out.println("determineCurrentLookupKey().datasource:[" + CustomerContextHolder.getCustomerType() + "]");
        return CustomerContextHolder.getCustomerType();
    }
}
