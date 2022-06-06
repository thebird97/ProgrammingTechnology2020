package hu.elte.fi.progtech.ae.persistence.entity;

import java.io.Serializable;

public class Artist implements Identifiable<Long>, Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String instruments;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInstruments() {
        return instruments;
    }

    public void setInstruments(String instruments) {
        this.instruments = instruments;
    }
}
