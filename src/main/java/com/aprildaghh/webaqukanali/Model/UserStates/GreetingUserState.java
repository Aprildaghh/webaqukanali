package com.aprildaghh.webaqukanali.Model.UserStates;

import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Exceptions.UserStateException;

public class GreetingUserState extends UserStateSubject implements UserState{

    private final AqukanaliController controller;

    public GreetingUserState(AqukanaliController mc)
    {
        super(mc);
        this.controller = mc;
    }

    @Override
    public void leaving() {
        throw new UserStateException("Cannot change state from greeting to goodbye");
    }

    @Override
    public void intentionInspecting() {
        throw new UserStateException("Cannot change state from greeting to intentionInspecting");
    }

    @Override
    public void intentionEditing() {
        throw new UserStateException("Cannot change state from greeting to intentionEditing");
    }

    @Override
    public void mainMenu() {
        controller.setCurrentUserState(controller.getMainMenuUserState());
        notifyObserver();
    }

    @Override
    public void intentionCreation() {
        throw new UserStateException("Cannot change state from greeting to intentionCreation");
    }
}
