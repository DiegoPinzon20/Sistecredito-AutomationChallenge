package com.sistecredito.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteLogger implements Task {

    private static final Logger LOGGER = LogManager.getLogger(WriteLogger.class);
    private final Level level;
    private final String message;

    public WriteLogger(Level level, String message) {
        this.level = level;
        this.message = message;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.log(level, message);
    }

    public static Performable theInfo(Level level, String message){
        return instrumented(WriteLogger.class, level, message);
    }
}
