package com.balance.balancegame.Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Game;
import com.balance.balancegame.Screens.GameScreen;

import static com.balance.balancegame.Constants.PPM;
import static com.balance.balancegame.Constants.HEIGHT;
import static com.balance.balancegame.Constants.WIDTH;

/**
 * Created by Registered User on 6/23/2016.
 */


public class Scale {
    public static Body horizontalScaleBody;
    public static Body verticalScaleBody;
    public float HorizontalWidth = (float) (WIDTH*.40)/PPM;
    public float HorizontalHeight = (float)(HEIGHT*.02)/PPM;
    public float VerticalWidth = (float) (WIDTH*.025)/PPM;
    public float VerticalHeight = (float) (HEIGHT*.20)/PPM;
    public Vector2 HorizontalPosition = new Vector2((WIDTH/2)/PPM,0);
    public Vector2 VerticalPosition = new Vector2((WIDTH/2)/PPM,0);
    public Sprite HSprite, VSprite;

    public Scale(World world){
        horizontalScaleBody = world.createBody(createHorizontalScaleBody());
        horizontalScaleBody.createFixture(createHorizontalScaleFixture());
        horizontalScaleBody.getPosition().setAngle(0);

        verticalScaleBody = world.createBody(createVerticalScaleBody());
        verticalScaleBody.createFixture(createVerticalScaleFixture());
        HSprite = new Sprite(GameScreen.content.getGameTexture("scalebackground"));
        VSprite = new Sprite(GameScreen.content.getGameTexture("scalebackground"));
    }
     public BodyDef createHorizontalScaleBody(){
         BodyDef bodyDef = new BodyDef();
         bodyDef.position.set(HorizontalPosition);
         bodyDef.type = BodyDef.BodyType.DynamicBody;

//Fixing PPM conversion
        return bodyDef;

    }

    public FixtureDef createHorizontalScaleFixture(){
        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(HorizontalWidth, HorizontalHeight);




        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 50;
        fixtureDef.friction = 1;
        fixtureDef.restitution = 0;
        fixtureDef.shape = rectangle;
        fixtureDef.filter.categoryBits = Constants.SCALE;


        return fixtureDef;
    }

    public BodyDef createVerticalScaleBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(VerticalPosition);
        bodyDef.type = BodyDef.BodyType.KinematicBody;


        return bodyDef;

    }

    public FixtureDef createVerticalScaleFixture(){
        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(VerticalWidth, VerticalHeight);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 50;
        fixtureDef.friction = 1;
        fixtureDef.restitution = 0;
        fixtureDef.shape = rectangle;
        fixtureDef.filter.categoryBits = Constants.SCALE;

        return fixtureDef;
    }

    public void renderScales(float delta, SpriteBatch batch){
        HSprite.draw(batch);
        VSprite.draw(batch);
    }

    public void update(){
        HSprite.setSize(HorizontalWidth*2, HorizontalHeight*2);
        HSprite.setPosition(horizontalScaleBody.getPosition().x - HorizontalWidth, horizontalScaleBody.getPosition().y-HorizontalHeight);
        HSprite.setOrigin(HorizontalWidth, HorizontalHeight);
        HSprite.setRotation(horizontalScaleBody.getAngle()* MathUtils.radiansToDegrees);

        VSprite.setSize(VerticalWidth*2, VerticalHeight*2);
        VSprite.setPosition(verticalScaleBody.getPosition().x - VerticalWidth, verticalScaleBody.getPosition().y-VerticalHeight);
        VSprite.setOrigin(VerticalWidth, VerticalHeight);
        VSprite.setRotation(verticalScaleBody.getAngle()* MathUtils.radiansToDegrees);
    }
}
