package org.capcaval.lafab.labase.command;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class CommandExecutor {
    static public CommandResult execute(CommandRepo repo, String command, String...  parameterArray) {
        AtomicReference<CommandResult> result = new AtomicReference<>();

        String fullCommand = command + " " + String.join( " ", parameterArray);

        //CommandDescription cd = repo.getCommandDescription(fullCommand).orElse(()->return new CommandResult(false, "Error can not found command."));

        repo.getCommandDescription(fullCommand).ifPresentOrElse(
                (cd)->{
                    try{
                        // get the command description if any
                        Method m = cd.getInstance().getClass().getMethod(command);
                        m.invoke(cd.getInstance());

                        result.set(new CommandResult(true, "All good"));
                    }catch(Exception e){
                        result.set(new CommandResult(false, "Error \n" + e.getMessage()));
                    }
                },
                ()->{
                    result.set(new CommandResult(false, "Error can not find command " + command));
                });

        return result.get();
    }

}
