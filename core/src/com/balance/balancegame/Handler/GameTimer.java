package com.balance.balancegame.Handler;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Timer;
import com.balance.balancegame.Objects.GeneratedObjects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Registered User on 7/10/2016.
 */
public class GameTimer extends Timer {

    public HashMap<String,Task> tasks;
    public Timer timer;
    private World world;
    private GeneratedObjects generatedObjects;

    public GameTimer(World world){
        this.world = world;
        tasks = new HashMap<String, Task>();
        timer = new Timer();
        generatedObjects = new GeneratedObjects(world);

        boxGenerator();
        circleGenerator();
    }

    public void boxGenerator(){
        Task task = timer.scheduleTask(new Task() {
            @Override
            public void run() {
                generatedObjects.boxGeneratedObjects();
            }
        },2, 2, -2);

        System.out.println("Box");

    }

    public void circleGenerator(){
        Task task = timer.scheduleTask(new Task() {
            @Override
            public void run() {
                generatedObjects.circleGeneratedObjects();
            }
        },7, 3, -2);

        System.out.println("Circle");

    }

    public void newTask(String taskName ,Task task){
        tasks.put(taskName ,task);
    }

    public Task getTasks(String taskName){
        return tasks.get(taskName);
    }

}
