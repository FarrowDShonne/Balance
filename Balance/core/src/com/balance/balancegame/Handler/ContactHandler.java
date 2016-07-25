package com.balance.balancegame.Handler;

import com.balance.balancegame.Constants;
import com.badlogic.gdx.physics.box2d.Fixture;

/**
 * Created by Registered User on 7/20/2016.
 */
public class ContactHandler {
    //public final static short SCALE = 2, CLICKBOX = 4, GCIRCLE = 8, GBOX = 16;
    public ContactHandler(){

    }

    public static void handleContacts(Fixture a, Fixture b){
        if(a.getFilterData().categoryBits == Constants.SCALE && b.getFilterData().categoryBits != Constants.SCALE){
           // System.out.println("You have hit the ground");
        }
    }
}
