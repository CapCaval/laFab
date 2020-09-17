package org.capcaval.lafab.labase.command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public class CommandRepo {
    Map<String, Object> map = new HashMap<>();
    public CommandRepo(CommandDescription... commandDescriptionArray) {
        // Fill the hash map
        Arrays.stream(commandDescriptionArray).forEach(cd -> map.put(cd.getSignature(), cd.getInstance()));
    }

    /**
     *
     * @param command
     * @param parameters
     * @return
     */
    public Optional<CommandDescription> getCommandDescription(String command, String... parameters){
        return Optional.ofNullable(
                this.map.get(command + " " + String.join(" ", parameters))
        ).map(CommandDescription.class::cast);
    }
}
