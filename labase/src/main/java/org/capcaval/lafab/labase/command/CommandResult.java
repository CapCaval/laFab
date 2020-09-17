package org.capcaval.lafab.labase.command;

public class CommandResult {

    private final boolean isSuccessful;
    private final String message;

    public CommandResult(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }
}
