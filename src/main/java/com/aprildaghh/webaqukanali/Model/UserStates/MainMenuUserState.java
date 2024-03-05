package com.aprildaghh.webaqukanali.Model.UserStates;

import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Controller.OldAqukanaliController;

public class MainMenuUserState extends UserStateSubject implements UserState{

    private final AqukanaliController controller;

    public MainMenuUserState(AqukanaliController mc)
    {
        super(mc);
        controller = mc;
    }

    @Override
    public void mainMenu() {
        notifyObserver();
    }

    @Override
    public void leaving() {
        controller.setCurrentUserState(controller.getGoodbyeUserState());
        notifyObserver();

    }

    @Override
    public void intentionInspecting() {
        controller.setCurrentUserState(controller.getIntentionInspectingUserState());
        notifyObserver();

    }

    @Override
    public void intentionEditing() {
        controller.setCurrentUserState(controller.getIntentionEditingUserState());
        notifyObserver();

    }

    @Override
    public void intentionCreation() {
        controller.setCurrentUserState(controller.getIntentionCreationUserState());
        notifyObserver();
    }
}
