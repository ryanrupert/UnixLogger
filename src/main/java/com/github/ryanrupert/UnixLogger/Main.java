package com.github.ryanrupert.UnixLogger;

class Main {
    public static void main(String args[]){
        Logger logger = Logger.create();
        logger.crit("critical message");
        logger.notice("notice message");
        logger.debug("debug message");
    }
}
