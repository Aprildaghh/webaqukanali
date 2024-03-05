package com.aprildaghh.webaqukanali.Model.UserStates;


import com.aprildaghh.webaqukanali.Controller.AqukanaliController;
import com.aprildaghh.webaqukanali.Controller.OldAqukanaliController;
import com.aprildaghh.webaqukanali.Exceptions.UserStateException;

public class GoodbyeUserState extends UserStateSubject implements UserState {

    private final AqukanaliController controller;

    public GoodbyeUserState(AqukanaliController mc){
        super(mc);
        controller = mc;
    }

    @Override
    public void leaving() {
        throw new UserStateException("Cannot change state from goodbye to goodbye");
    }

    @Override
    public void intentionInspecting() {
        throw new UserStateException("Cannot change state from goodbye to intentionInspecting");
    }

    @Override
    public void intentionEditing() {
        throw new UserStateException("Cannot change state from goodbye to intentionEditing");
    }

    @Override
    public void mainMenu() {
        throw new UserStateException("Cannot change state from goodbye to mainMenu");
    }

    @Override
    public void intentionCreation() {
        throw new UserStateException("Cannot change state from goodbye to intentionCreation");
    }
}
