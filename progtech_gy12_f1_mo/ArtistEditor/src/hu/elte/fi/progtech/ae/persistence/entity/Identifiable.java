package hu.elte.fi.progtech.ae.persistence.entity;

public interface Identifiable <T extends Number> {

    T getId();

    void setId(T id);
}
