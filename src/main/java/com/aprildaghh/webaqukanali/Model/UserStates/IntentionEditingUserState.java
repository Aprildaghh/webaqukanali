package com.aprildaghh.webaqukanali.Model.UserStates;

import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Controller.OldAqukanaliController;
import com.aprildaghh.webaqukanali.Exceptions.UserStateException;

public class IntentionEditingUserState extends UserStateSubject implements UserState{

    private final AqukanaliController controller;

    public IntentionEditingUserState(AqukanaliController mc)
    {
        super(mc);
        controller = mc;
    }

    @Override
    public void leaving() {
        throw new UserStateException("Cannot change state from intentionEditing to leaving");
    }

    @Override
    public void intentionInspecting() {
        controller.setCurrentUserState(controller.getIntentionInspectingUserState());
        notifyObserver();

    }

    @Override
    public void intentionEditing() {
        throw new UserStateException("Cannot change state from intentionEditing to intentionEditing");
    }

    @Override
    public void mainMenu() {
        controller.setCurrentUserState(controller.getMainMenuUserState());
        notifyObserver();

    }

    @Override
    public void intentionCreation() {
        throw new UserStateException("Cannot change state from intentionEditing to intentionCreation");
    }
}
