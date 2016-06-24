package com.balance.balancegame.Objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balance.balancegame.Constants;

/**
 * Created by Registered User on 6/23/2016.
 */
public class Scale {
    public static Body horizontalScaleBody;
    public static Body verticalScaleBody;

    public Scale(World world){
        Scale.horizontalScaleBody = world.createBody(createHorizontalScaleBody());
        Scale.horizontalScaleBody.createFixture(createHorizontalScaleFixture());

        Scale.verticalScaleBody = world.createBody(createVerticalScaleBody());
        Scale.verticalScaleBody.createFixture(createVerticalScaleFixture());
    }
     public BodyDef createHorizontalScaleBody(){
         BodyDef bodyDef = new BodyDef();
         bodyDef.position.set(new Vector2(3.6f,0));
         bodyDef.type = BodyDef.BodyType.StaticBody;


        return bodyDef;

    }

    public FixtureDef createHorizontalScaleFixture(){
        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(3f,.25f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 50;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0;
        fixtureDef.shape = rectangle;
        fixtureDef.filter.categoryBits = Constants.SCALE;

        return fixtureDef;
    }

    public BodyDef createVerticalScaleBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(3.6f,0));
        bodyDef.type = BodyDef.BodyType.KinematicBody;


        return bodyDef;

    }

    public FixtureDef createVerticalScaleFixture(){
        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(.25f,2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 50;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0;
        fixtureDef.shape = rectangle;
        fixtureDef.filter.categoryBits = Constants.SCALE;

        return fixtureDef;
    }
}
