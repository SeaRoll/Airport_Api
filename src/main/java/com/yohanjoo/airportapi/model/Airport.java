package com.yohanjoo.airportapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Represents an Airport
 *
 * @author              Yo Han Joo
 * @since               0.0.1-SNAPSHOT
 */
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

    /**
     * Empty Constructor for an airport
     */
    public Airport() {
    }

    /**
     * Creates an Airport with specified data
     *
     * @param ident         Airport 4 code ICAO Code
     * @param type          What type of airport, small_airport, medium airport, large_airport
     * @param name          Name of the airport
     * @param elevation_ft  Elevation of airport in feet
     * @param continent     which continent the airport belongs to
     * @param iso_country   which country in ISO-code(2 number code) the airport belongs to
     * @param iso_region    which region in ISO-format the country airport belongs to
     * @param municipality  name of the municipality
     * @param gps_code      code of the GPS for the airport (usually same as ICAO)
     * @param iata_code     IATA code for the airport (3 codes)
     * @param local_code    Actually no idea
     * @param coordinates   coordinates in "lon,lat" format
     * @author              Yo Han Joo
     * @since               0.0.1-SNAPSHOT
     */
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

    /**
     * Get ID of Airport in Table
     *
     * @return id of the airport in table
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of airport in table
     *
     * @param id which id it should change to
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the icao ident of the airport
     *
     * @return icao code of airport
     */
    public String getIdent() {
        return ident;
    }

    /**
     * Sets ident code of airport in table
     *
     * @param ident which ident it should change to
     */
    public void setIdent(String ident) {
        this.ident = ident;
    }

    /**
     * Gets the airport type
     *
     * @return type of airport
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of airport (small_airport || medium_airport || large_airport)
     *
     * @param type which type it should set to
     */
    public void setType(String type) {
        if(type.equals("small_airport") || type.equals("medium_airport") || type.equals("large_airport") )
            this.type = type;
    }

    /**
     * Gets the airport name
     *
     * @return name of airport
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of airport
     *
     * @param name which name it should set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get elevation in feet of airport
     *
     * @return elevation of airport in feet
     */
    public String getElevation_ft() {
        return elevation_ft;
    }

    /**
     * Sets the elevation in feet of airport
     *
     * @param elevation_ft elevation in String format
     */
    public void setElevation_ft(String elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    /**
     * Gets the continent name in 2-code format of airport
     *
     * @return continent 2-code.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the continent name in 2-code format of airport
     *
     * @param continent new 2 code name
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the ISO-country code of airport
     *
     * @return country in ISO format
     */
    public String getIso_country() {
        return iso_country;
    }

    /**
     * sets the ISO-country code of airport
     *
     * @param iso_country new ISO country
     */
    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    /**
     * gets the ISO-region code of airport
     *
     * @return region in ISO format
     */
    public String getIso_region() {
        return iso_region;
    }

    /**
     * sets the ISO-region code of airport
     *
     * @param iso_region new region in ISO format
     */
    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    /**
     * gets the municipality of airport
     *
     * @return municipality where airport is
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * sets the municipality of airport
     *
     * @param municipality new municipality
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    /**
     * gets the gps code of airport
     *
     * @return gps code of the airport
     */
    public String getGps_code() {
        return gps_code;
    }

    /**
     * sets the gps code of airport
     *
     * @param gps_code new gps code
     */
    public void setGps_code(String gps_code) {
        this.gps_code = gps_code;
    }

    /**
     * gets the iata code of airport
     *
     * @return iata code of airport
     */
    public String getIata_code() {
        return iata_code;
    }

    /**
     * sets the iata code of airport
     *
     * @param iata_code new iata code
     */
    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    /**
     * gets the local code of airport
     *
     * @return local code of airport
     */
    public String getLocal_code() {
        return local_code;
    }

    /**
     * sets the local code of airport
     *
     * @param local_code new local code
     */
    public void setLocal_code(String local_code) {
        this.local_code = local_code;
    }

    /**
     * gets the longitude coordinates of airport
     *
     * @return longitude coordinates of airport
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * sets the longitude code of airport
     *
     * @param longitude new longitude of airport
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * gets the latitude coordinates of airport
     *
     * @return latitude coordinates of airport
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * sets the latitude code of airport
     *
     * @param latitude new latitude of airport
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * compares if current object and param object is the same
     *
     * @param o object to compare with
     * @return 0 if same, other numbers if they don't match
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Double.compare(airport.longitude, longitude) == 0 && Double.compare(airport.latitude, latitude) == 0 && Objects.equals(id, airport.id) && Objects.equals(ident, airport.ident) && Objects.equals(type, airport.type) && Objects.equals(name, airport.name) && Objects.equals(elevation_ft, airport.elevation_ft) && Objects.equals(continent, airport.continent) && Objects.equals(iso_country, airport.iso_country) && Objects.equals(iso_region, airport.iso_region) && Objects.equals(municipality, airport.municipality) && Objects.equals(gps_code, airport.gps_code) && Objects.equals(iata_code, airport.iata_code) && Objects.equals(local_code, airport.local_code);
    }

    /**
     * Returns hashcode of object
     * @return Hash of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, ident, type, name, elevation_ft, continent, iso_country, iso_region, municipality, gps_code, iata_code, local_code, longitude, latitude);
    }

    /**
     * returns the object in string format
     * @return returns the object in string format
     */
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
