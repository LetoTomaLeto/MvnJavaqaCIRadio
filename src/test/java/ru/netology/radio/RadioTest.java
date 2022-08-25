package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio rad = new Radio();

    @Test
    public void validateChangeFields() {
        assertEquals(0, rad.getCurrentRadioStation());
        rad.setCurrentRadioStation(4);
        assertEquals(4, rad.getCurrentRadioStation());
    }

    // тестируем станции
    @Test
    public void changeOverLastRadioStation() {
        rad.setCurrentRadioStation(9);
        rad.pressNextStation();
        assertEquals(0, rad.getCurrentRadioStation());
    }

    @Test
    public void changeUnderInitialRadioStation() {
        rad.setCurrentRadioStation(0);
        rad.pressPrevStation();
        assertEquals(9, rad.getCurrentRadioStation());

    }

    @Test
    public void nextRadioStation() {
        rad.setCurrentRadioStation(6);
        rad.pressNextStation();
        assertEquals(7, rad.getCurrentRadioStation());
    }

    @Test
    public void prevRadioStation() {
        rad.setCurrentRadioStation(6);
        rad.pressPrevStation();
        assertEquals(5, rad.getCurrentRadioStation());
    }

    @Test
    public void OverInitialRadioStation() {
        rad.setCurrentRadioStation(11);
        rad.getMaxRadioStation();
        assertEquals(0, rad.getCurrentRadioStation());
    }

    @Test
    public void UnderInitialRadioStation() {
        rad.setCurrentRadioStation(-1);
        rad.getMinRadioStation();
        assertEquals(0, rad.getCurrentRadioStation());
    }

    // тестируем громкость
    @Test
    public void volumeOverMax() {
        rad.setCurrentVolume(11);
        rad.getMaxVolume();
        assertEquals(10, rad.getMaxVolume());
    }

    @Test
    public void volumeDownUnderMin() {
        rad.setCurrentVolume(-11);
        rad.getMinVolume();
        assertEquals(0, rad.getMinVolume());

    }

    @Test
    public void plusVolume() {
        rad.setCurrentVolume(4);
        rad.pressPlusVolume();
        assertEquals(5, rad.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        rad.setCurrentVolume(4);
        rad.pressMinusVolume();
        assertEquals(3, rad.getCurrentVolume());
    }

    @Test
    public void testStationSum() {
        Radio rad = new Radio(15);
        rad.setCurrentRadioStation(5);
        rad.pressNextStation();

        int expected = 6;
        int actual = rad.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    /**@Test
    public void test2StationSum() {
        Radio rad = new Radio(15);
        rad.setCurrentRadioStation(9);
        rad.pressNextStation();

        int expected = 10;
        int actual = rad.getCurrentRadioStation();

        assertEquals(expected, actual);
    }*/
}