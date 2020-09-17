package org.capcaval.lafab.labase.command;

import org.junit.Assert;

public class CommandExecutorTest {

    @org.junit.Test
    public void testCommandExecutor(){

        CommandRepo repo = new CommandRepo( new CommandDescription( new CommandSample(), "sayHello", "String"));
        CommandResult result = CommandExecutor.execute(repo, "sayHello", "Stephen");

        //Assert.assertEquals("Hello Stephen!", result.getMessage());
        //Assert.assertTrue( result.isSuccessful());
    }

    public static class CommandSample{
        public String sayHello(String name){
            return "Hello " + name +"!";
        }
    }
}
