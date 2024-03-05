package com.aprildaghh.webaqukanali.View;

import com.aprildaghh.webaqukanali.Exceptions.NullIntentionException;
import com.aprildaghh.webaqukanali.Model.Entity.ContentEntity;
import com.aprildaghh.webaqukanali.Model.Entity.IntentionEntity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConsoleView {

    private static ConsoleView uniqueInstance;

    private ConsoleView(){}

    public static ConsoleView getInstance() {
        if(uniqueInstance == null)
        {
            uniqueInstance = new ConsoleView();
        }
        return uniqueInstance;
    }

    /*

    private void slowPrint(String s)
    {
        try {
            TimeUnit.MICROSECONDS.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < s.length(); i++)
        {
            System.out.print(s.charAt(i));
            try {
                TimeUnit.MICROSECONDS.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print('\n');
    }

    */

    public String showExistingIntention(IntentionEntity intention)
    {
        if(intention == null)
            throw new NullIntentionException("Given intention is null!");

        List<ContentEntity> contents = intention.getContents();
        String str = intention.getIntentionDate().toString() + "\n";

        for(int i = 0; i < contents.size(); i++)
        {
            ContentEntity content = contents.get(i);
            str += (i+1) + ". " + ((content.isContentCompletion() ? "(DONE) " : "(NOT COMPLETED) ")) + content.getIntentionContent() + "\n";
        }

        str += "\nType 'e' for edit, 'm' for returning to main menu.\n";

        return str;
    }

    public String showSpecificDateAsking()
    {
        return  "Enter the date(dd-mm-yyyy):";
    }

    public String showGreeting()
    {
        return  "Welcome to AQUKANALI, the todo app\n" +
                "say hello to continue...";
    }

    public String showGoodbye()
    {
        return  """
                Thank you for using our service!
                Have a great day!
                """;
    }

    public String showMainMenu()
    {
        return """
                What would you want today?
                1. Show today's plan, if there's not create one.
                2. Show a specific day's plan.
                3. Exit.""";

    }

    public String showIntentionCreation()
    {
        return  """
                Enter your intentions for today
                For help type 'help'
                """;
    }

    public String showIntentionCreationHelp()
    {
        return """
                Enter your intentions one by one.
                Press enter to add new intention.
                For exiting creation simply type 'exit'.
                """;
    }

    public String showIntentionEditing()
    {
        return """
                Editing Intention...
                For help type 'help'
                """;
    }

    public String showIntentionEditingHelp()
    {
        return """
                Simply first type the intention number you want to change then rewrite the intention if you want.
                If you want to simply mark the intention as completed just type DONE after the intention number.
                If you want to create new intention start your intention with the next numerical intention number value.
                For exiting editing simply type 'exit'.
                Ex:
                    1. DONE
                    2. Changed Intention
                    3. New Intention
                    exit
                """;
    }

}
