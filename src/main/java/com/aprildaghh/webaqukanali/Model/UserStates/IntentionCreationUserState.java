package com.aprildaghh.webaqukanali.Model.UserStates;

import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Controller.OldAqukanaliController;
import com.aprildaghh.webaqukanali.Exceptions.UserStateException;

public class IntentionCreationUserState extends UserStateSubject implements UserState{

    private final AqukanaliController controller;

    public IntentionCreationUserState(AqukanaliController mc)
    {
        super(mc);
        controller = mc;
    }

    @Override
    public void leaving() {
        throw new UserStateException("Cannot change state from intentionCreation to leaving.");
    }

    @Override
    public void intentionInspecting() {
        throw new UserStateException("Cannot change state from intentionCreation to intentionInspecting.");
    }

    @Override
    public void intentionEditing() {
        throw new UserStateException("Cannot change state from intentionCreation to intentionEditing.");
    }

    @Override
    public void mainMenu() {
        controller.setCurrentUserState(controller.getMainMenuUserState());
        controller.update();
    }

    @Override
    public void intentionCreation() {
        throw new UserStateException("Cannot change state from intentionCreation to intentionCreation");
    }
}
