package com.aprildaghh.webaqukanali.Model.UserStates;


import com.aprildaghh.webaqukanali.Controller.AqukanaliController;

public abstract class UserStateSubject {

    private AqukanaliController observer;

    public UserStateSubject(AqukanaliController observer)
    {
        if(observer != null) this.observer = observer;
    }

    public void notifyObserver()
    {
        observer.update();
    }
}
