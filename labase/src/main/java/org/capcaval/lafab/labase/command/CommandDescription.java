package org.capcaval.lafab.labase.command;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CommandDescription {
    private final Object instance;
    private final String commandSignature;

    /**
     *
     * @param instance
     * @param commandSignatureArray
     */
    public CommandDescription(Object instance, String... commandSignatureArray) {
        this.instance = instance;
        this.commandSignature = Arrays.stream(commandSignatureArray).collect(Collectors.joining());
    }

    public String getSignature() {
        return this.commandSignature;
    }

    public Object getInstance() {
        return this.instance;
    }
}
