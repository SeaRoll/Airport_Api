package com.yohanjoo.airportapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Airport {
    private @Id @GeneratedValue Long id;
    private String ident;
    private String type;
    private String name;
    private String elevation_ft;
    private String continent;
    private String iso_country;
    private String iso_region;
    private String municipality;
    private String gps_code;
    private String iata_code;
    private String local_code;
    private double longitude;
    private double latitude;

    public Airport() {
    }

    public Airport(String ident, String type, String name, String elevation_ft, String continent, String iso_country, String iso_region, String municipality, String gps_code, String iata_code, String local_code, String coordinates) {
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.elevation_ft = elevation_ft;
        this.continent = continent;
        this.iso_country = iso_country;
        this.iso_region = iso_region;
        this.municipality = municipality;
        this.gps_code = gps_code;
        this.iata_code = iata_code;
        this.local_code = local_code;

        String[] coords = coordinates.split(",");

        this.longitude = Double.parseDouble(coords[0]);
        this.latitude = Double.parseDouble(coords[1]);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElevation_ft() {
        return elevation_ft;
    }

    public void setElevation_ft(String elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }

    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGps_code() {
        return gps_code;
    }

    public void setGps_code(String gps_code) {
        this.gps_code = gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public void setLocal_code(String local_code) {
        this.local_code = local_code;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Double.compare(airport.longitude, longitude) == 0 && Double.compare(airport.latitude, latitude) == 0 && Objects.equals(id, airport.id) && Objects.equals(ident, airport.ident) && Objects.equals(type, airport.type) && Objects.equals(name, airport.name) && Objects.equals(elevation_ft, airport.elevation_ft) && Objects.equals(continent, airport.continent) && Objects.equals(iso_country, airport.iso_country) && Objects.equals(iso_region, airport.iso_region) && Objects.equals(municipality, airport.municipality) && Objects.equals(gps_code, airport.gps_code) && Objects.equals(iata_code, airport.iata_code) && Objects.equals(local_code, airport.local_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ident, type, name, elevation_ft, continent, iso_country, iso_region, municipality, gps_code, iata_code, local_code, longitude, latitude);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", ident='" + ident + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", elevation_ft='" + elevation_ft + '\'' +
                ", continent='" + continent + '\'' +
                ", iso_country='" + iso_country + '\'' +
                ", iso_region='" + iso_region + '\'' +
                ", municipality='" + municipality + '\'' +
                ", gps_code='" + gps_code + '\'' +
                ", iata_code='" + iata_code + '\'' +
                ", local_code='" + local_code + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
