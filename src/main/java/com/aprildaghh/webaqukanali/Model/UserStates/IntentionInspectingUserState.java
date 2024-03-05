package com.aprildaghh.webaqukanali.Model.UserStates;

import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Controller.OldAqukanaliController;
import com.aprildaghh.webaqukanali.Exceptions.UserStateException;

public class IntentionInspectingUserState extends UserStateSubject implements UserState{

    private final AqukanaliController controller;

    public IntentionInspectingUserState(AqukanaliController mc)
    {
        super(mc);
        controller = mc;
    }

    @Override
    public void leaving() {
        throw new UserStateException("Cannot change state from intentionInspecting to leaving");
    }

    @Override
    public void intentionInspecting() {
        throw new UserStateException("Cannot change state from intentionInspecting to intentionInspecting");
    }

    @Override
    public void intentionEditing() {
        controller.setCurrentUserState(controller.getIntentionEditingUserState());
        notifyObserver();

    }

    @Override
    public void mainMenu() {
        controller.setCurrentUserState(controller.getMainMenuUserState());
        notifyObserver();

    }

    @Override
    public void intentionCreation()
    {
        throw new UserStateException("Cannot change state from intentionInspecting to intentionCreation");
    }
}
