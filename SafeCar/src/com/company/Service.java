package com.company;

import java.util.Date;

public class Service {

    private int service_id;
    private String vin;
    private String service_type;
    private Date service_date;
    private String serviceDateStringImpl;

    public Service() {
    }

    public Service(int service_id, String vin, String service_type, Date service_date, String serviceDateStringImpl) {
        this.service_id = service_id;
        this.vin = vin;
        this.service_type = service_type;
        this.service_date = service_date;
        this.serviceDateStringImpl = serviceDateStringImpl;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public String getServiceDateStringImpl() {
        return serviceDateStringImpl;
    }

    public void setServiceDateStringImpl(String serviceDateStringImpl) {
        this.serviceDateStringImpl = serviceDateStringImpl;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_id=" + service_id +
                ", vin='" + vin + '\'' +
                ", service_type='" + service_type + '\'' +
                ", service_date=" + service_date +
                ", serviceDateStringImpl='" + serviceDateStringImpl + '\'' +
                '}';
    }
}
