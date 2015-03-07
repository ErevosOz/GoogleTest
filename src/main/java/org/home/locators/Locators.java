package org.home.locators;

public final class Locators {
    //TODO avoid using xpath, when possible, use CSS, ids, names etc
    public final static String logo = ".//*[@id='hplogo']";
    public final static String searchForm = ".//input [@id='lst-ib']";
    public final static String searchButton = ".//button[@class='lsb']";
    public final static String firstLink = "(.//*[@id='ires']//a)[1]";
}
