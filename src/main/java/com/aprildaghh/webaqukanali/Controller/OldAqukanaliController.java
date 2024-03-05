package com.aprildaghh.webaqukanali.Controller;


import com.aprildaghh.webaqukanali.Dao.IntentionDAO;
import com.aprildaghh.webaqukanali.Model.Entity.ContentEntity;
import com.aprildaghh.webaqukanali.Model.Entity.IntentionEntity;
import com.aprildaghh.webaqukanali.Model.UserStates.*;
import com.aprildaghh.webaqukanali.View.ConsoleView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class OldAqukanaliController {

    /*
    private void getDate()
    {
        // get the date from the user
        LocalDate theDate = null;
        int dd, mm, yyyy;

        while(true)
        {
            Scanner myObj = new Scanner(System.in);
            String[] dateParts = myObj.nextLine().split("-", 3);

            if(dateParts.length != 3)
            {
                System.err.println("Given date format is not correct! Ex: dd-mm-yyyy");
                continue;
            }

            dd = Integer.parseInt(dateParts[0]);
            mm = Integer.parseInt(dateParts[1]);
            yyyy = Integer.parseInt(dateParts[2]);

            if(dd < 1 || dd > 31)
            {
                System.err.println("Given day is not possible! It should be between 1 and 31");
                continue;
            }
            else if( mm < 1 || mm > 12)
            {
                System.err.println("Given month is not possible! It should be between 1 and 12");
                continue;
            }

            theDate = LocalDate.of(yyyy, mm, dd);
            break;
        }

    }

    private void intentionCreation()
    {
        // get the intentions from user
        IntentionEntity newIntention = new IntentionEntity(java.sql.Date.valueOf(LocalDate.now()));
        newIntention.setId(0);

        List<ContentEntity> contents = new ArrayList<>();
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(Objects.equals(input, "exit")) break;
            else if(Objects.equals(input, "help"))
            {
                view.showIntentionCreationHelp();
                continue;
            }

            ContentEntity content = new ContentEntity(false, input, newIntention);
            contents.add(content);
        }
        newIntention.setContents(contents);

        // store the intention to db
        intentionDAO.addIntention(newIntention);

        // set the currentIntention to the new intention
        currentIntention = newIntention;

        // get to the main screen state
        currentUserState.mainMenu();
    }

    private void intentionEditing()
    {

        // get the string from user
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(Objects.equals(input, "exit")) break;
            else if(Objects.equals(input, "help"))
            {
                view.showIntentionEditingHelp();
                continue;
            }

            int id = 0;
            for(int i = 0; i < input.length(); i++)
            {
                char c = input.charAt(i);
                if( c == '.')
                {
                    input = input.substring(i+2);
                    break;
                }
                id = (id * 10) + (c - '0');
            }

            id--;

            if(input.equals("DONE"))
            {
                currentIntention.getContents().get(id).setContentCompletion(true);
            }
            else if(id >= currentIntention.getContents().size())
            {
                currentIntention.add(new ContentEntity(false, input, currentIntention));
            }
            else
            {
                currentIntention.getContents().get(id).setIntentionContent(input);
            }

        }


        // update the intention on db
        intentionDAO.updateIntention(currentIntention);

        // get main screen state
        currentUserState.mainMenu();
    }

     */

}
