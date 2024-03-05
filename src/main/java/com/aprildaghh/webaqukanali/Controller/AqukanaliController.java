package com.aprildaghh.webaqukanali.Controller;

import com.aprildaghh.webaqukanali.Dao.IntentionDAO;
import com.aprildaghh.webaqukanali.Model.Entity.ContentEntity;
import com.aprildaghh.webaqukanali.Model.Entity.IntentionEntity;
import com.aprildaghh.webaqukanali.Model.UserStates.*;
import com.aprildaghh.webaqukanali.View.ConsoleView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AqukanaliController {

    private final ConsoleView view;
    private final IntentionDAO intentionDAO;
    private IntentionEntity currentIntention;

    private UserState currentUserState;
    private final UserState goodbyeUserState;
    private final UserState greetingUserState;
    private final UserState intentionEditingUserState;
    private final UserState intentionInspectingUserState;
    private final UserState mainMenuUserState;
    private final UserState intentionCreationUserState;
    private String responseString;

    public AqukanaliController()
    {
        this.view = ConsoleView.getInstance();
        this.intentionDAO = IntentionDAO.getInstance();
        this.goodbyeUserState = new GoodbyeUserState(this);
        this.greetingUserState = new GreetingUserState(this);
        this.intentionEditingUserState = new IntentionEditingUserState(this);
        this.intentionInspectingUserState = new IntentionInspectingUserState(this);
        this.mainMenuUserState = new MainMenuUserState(this);
        this.intentionCreationUserState = new IntentionCreationUserState(this);
        currentUserState = greetingUserState;
    }

    public IntentionEntity getCurrentIntention() {
        return currentIntention;
    }

    public void setCurrentIntention(IntentionEntity currentIntention) {
        this.currentIntention = currentIntention;
    }

    public UserState getCurrentUserState() {
        return currentUserState;
    }

    public void setCurrentUserState(UserState currentUserState) {
        this.currentUserState = currentUserState;
    }

    public UserState getGoodbyeUserState() {
        return goodbyeUserState;
    }

    public UserState getGreetingUserState() {
        return greetingUserState;
    }

    public UserState getIntentionEditingUserState() {
        return intentionEditingUserState;
    }

    public UserState getIntentionInspectingUserState() {
        return intentionInspectingUserState;
    }

    public UserState getMainMenuUserState() {
        return mainMenuUserState;
    }

    public UserState getIntentionCreationUserState() {
        return intentionCreationUserState;
    }

    @GetMapping("")
    public String mainPageRedirecterer()
    {
        // return "redirect:/aqukanali/";
        return "redirect:/";
    }
    @GetMapping("/")
    public String mainPage()
    {
        return "aqukanali-main";
    }

    @GetMapping("/answer")
    @ResponseBody
    public String answer(@RequestParam(name="input") String input)
    {

        if(Objects.equals(input, "hello")&& currentUserState.equals(greetingUserState))
            currentUserState.mainMenu();
        else if(Objects.equals(input, "1")&& currentUserState.equals(mainMenuUserState))
        {
            currentIntention = intentionDAO.getIntentionByDate(LocalDate.now());

            if(currentIntention == null)
                currentUserState.intentionCreation();
            else
                currentUserState.intentionInspecting();
        }
        else if(Objects.equals(input, "2")&& currentUserState.equals(mainMenuUserState))
        {
            responseString = view.showSpecificDateAsking();
            // getDate();
        }
        else if(Objects.equals(input, "3") && currentUserState.equals(mainMenuUserState))
        {
            currentUserState.leaving();
        }
        else if(Objects.equals(input, "e") && currentUserState.equals(intentionInspectingUserState))
        {
            currentUserState.intentionEditing();
        }
        else if(Objects.equals(input, "m") && currentUserState.equals(intentionInspectingUserState))
        {
            currentUserState.mainMenu();
        }

        return responseString;
    }

    @GetMapping("/date")
    @ResponseBody
    public String getDate(@RequestParam(name="date") String date){
        LocalDate theDate =  LocalDate.parse(date);
        currentIntention = intentionDAO.getIntentionByDate(theDate);

        currentUserState.intentionInspecting();

        return responseString;
    }

    @PostMapping("/creation")
    public void intentionCreation()
    {
        // TODO: get contents and store them in the contents variable
        List<ContentEntity> contents = new ArrayList<>();


        IntentionEntity intention = new IntentionEntity();
        intention.setContents(contents);
        intention.setId(0);
        intention.setIntentionDate(LocalDate.now());
        intentionDAO.addIntention(intention);

        currentIntention = intention;
        currentUserState.mainMenu();
    }

    @PostMapping("/edit")
    public void intentionEditing()
    {
        // TODO: set new contents to the current intention


        intentionDAO.updateIntention(currentIntention);
        currentUserState.mainMenu();
    }

    public void update()
    {
        if (currentUserState.equals(greetingUserState))
        {
            responseString = view.showGreeting();
        }
        else if (currentUserState.equals(mainMenuUserState))
        {
            responseString =  view.showMainMenu();
        }
        else if(currentUserState.equals(intentionInspectingUserState))
        {
            if(currentIntention == null)
            {
                responseString =  "Error at showScreen(Intention) in MainController.java: Given intention is null.";
            }
            else if (currentIntention.getContents() == null)
            {
                responseString =  "Error at showScreen(Intention) in MainController.java: Given intention's contents are null";
            }

            responseString =  view.showExistingIntention(currentIntention);
        }
        else if(currentUserState.equals(intentionEditingUserState))
        {
            responseString =  view.showIntentionEditing();
        }
        else if(currentUserState.equals(goodbyeUserState))
        {
            responseString =  view.showGoodbye();
        }
        else if(currentUserState.equals(intentionCreationUserState))
        {
            responseString =  view.showIntentionCreation();
        }
    }


}
