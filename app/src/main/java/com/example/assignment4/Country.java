package com.example.assignment4;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    private String name;
    private int flagImgId;
    private int symbolImgId;
    private long area;
    private long population;
    private String capitalCity;

    public Country(String name, int flagImgId, int symbolImgId, long area, long population, String capitalCity) {
        this.name = name;
        this.flagImgId = flagImgId;
        this.symbolImgId = symbolImgId;
        this.area = area;
        this.population = population;
        this.capitalCity = capitalCity;
    }

    protected Country(Parcel in) {
        name = in.readString();
        flagImgId = in.readInt();
        symbolImgId = in.readInt();
        area = in.readLong();
        population = in.readLong();
        capitalCity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(flagImgId);
        dest.writeInt(symbolImgId);
        dest.writeLong(area);
        dest.writeLong(population);
        dest.writeString(capitalCity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagImgId() {
        return flagImgId;
    }

    public void setFlagImgId(int flagImgId) {
        this.flagImgId = flagImgId;
    }

    public int getSymbolImgId() {
        return symbolImgId;
    }

    public void setSymbolImgId(int symbolImgId) {
        this.symbolImgId = symbolImgId;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public static Creator<Country> getCREATOR() {
        return CREATOR;
    }
}
