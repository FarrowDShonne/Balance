package com.balance.balancegame.Objects;

import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Content;
import com.balance.balancegame.Screens.GameScreen;

import java.util.Random;

import javafx.scene.shape.TriangleMesh;

import static com.balance.balancegame.Constants.HEIGHT;
import static com.balance.balancegame.Constants.PPM;
import static com.balance.balancegame.Constants.WIDTH;


public class GeneratedObjects {
    private World world;
    private float BlocksHeight = (float) (HEIGHT*.025)/PPM;
    private float BlocksWidth = (float) (WIDTH*.04)/PPM;

    public GeneratedObjects(World world){
        this.world = world;
    }


    public void generateBlocks(float x, float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(x/PPM,y/PPM));
        bodyDef.type = BodyDef.BodyType.DynamicBody;


        PolygonShape box = new PolygonShape();
        box.setAsBox(BlocksWidth,BlocksHeight);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = box;
        fixtureDef.density = 25;
        fixtureDef.restitution = 0;
        fixtureDef.friction = 1;
        fixtureDef.filter.categoryBits = Constants.CLICKBOX;

        world.createBody(bodyDef).createFixture(fixtureDef);
    }

    public void boxGeneratedObjects(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set((new Random().nextInt((int)WIDTH))/PPM,
                (new Random().nextInt((int)HEIGHT/2)+HEIGHT)/PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.gravityScale = .1f;



        PolygonShape box = new PolygonShape();
        box.setAsBox(BlocksWidth,BlocksHeight);


        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = box;
        fixtureDef.density = GenerateDensity();
        fixtureDef.restitution = 0;
        fixtureDef.friction = 1;
        fixtureDef.filter.categoryBits = Constants.GBOX;

        world.createBody(bodyDef).createFixture(fixtureDef);
        box.dispose();
    }

    public void circleGeneratedObjects(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set((new Random().nextInt((int)WIDTH))/PPM,
                (new Random().nextInt((int)HEIGHT/2)+HEIGHT)/PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.gravityScale = .25f;


        CircleShape circle = new CircleShape();
        circle.setRadius((float) (WIDTH*.04)/PPM);





        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 60;
        fixtureDef.restitution = .2f;
        fixtureDef.friction = 0;
        fixtureDef.filter.categoryBits = Constants.GCIRCLE;


        world.createBody(bodyDef).createFixture(fixtureDef);
        circle.dispose();
    }

    public int GenerateDensity(){
        int temp = 25;
        int randNum = new Random().nextInt(4)+1;
        switch(randNum){
            case 1:
                temp = 25;
                break;

            case 2:
                temp = 50;
                break;

            case 3:
                temp = 75;
                break;

            case 4:
                temp = 100;
                break;
        }
        System.out.println(temp);
        return temp;
    }

}
