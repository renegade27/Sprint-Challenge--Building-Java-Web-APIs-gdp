package com.lambdaschool.sprintcountry.model;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;
    public Country(String name, String gdp) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;
    }
    public Country(Country toClone) {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.gdp = String.valueOf(toClone.getGdp());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGdp() {
        return Long.parseLong(gdp);
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public long getId() {
        return id;
    }
}
