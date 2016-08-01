package com.balance.balancegame.Objects;

import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Screens.GameScreen;


import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.TriangleMesh;

import static com.balance.balancegame.Constants.HEIGHT;
import static com.balance.balancegame.Constants.PPM;
import static com.balance.balancegame.Constants.WIDTH;


public class GeneratedObjects {
    private World world;
    private float BlocksHeight = (float) (HEIGHT*.025)/PPM;
    private float BlocksWidth = (float) (WIDTH*.04)/PPM;
    private static ArrayList<Fixture> Bodies = new ArrayList<Fixture>();
    public TextureRegion standardBlockImage, twentyFiveDensity, fiftyDensity, seventyDiveDensity, hundredDensity;

    public GeneratedObjects(World world){
        this.world = world;
        standardBlockImage = new TextureRegion(GameScreen.content.getGameTexture("box"));
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

        Bodies.add(world.createBody(bodyDef).createFixture(fixtureDef));

        box.dispose();




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

        Bodies.add(world.createBody(bodyDef).createFixture(fixtureDef));
        box.dispose();
    }

    public void circleGeneratedObjects(){
        Body body;
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


        Bodies.add(world.createBody(bodyDef).createFixture(fixtureDef));
        circle.dispose();


    }

    public void renderGeneratedObjects(float delta, SpriteBatch batch){
        for(int render = 0; render < Bodies.size(); render++){
            switch (Bodies.get(render).getFilterData().categoryBits){
                case Constants.CLICKBOX:
                    batch.draw(standardBlockImage, Bodies.get(render).getBody().getPosition().x - BlocksWidth,
                            Bodies.get(render).getBody().getPosition().y - BlocksHeight,
                            BlocksWidth, BlocksHeight,
                            BlocksWidth*2, BlocksHeight*2,1, 1,
                            Bodies.get(render).getBody().getAngle()* MathUtils.radiansToDegrees, false
                    );
                    break;
                case Constants.GCIRCLE:
                    break;
                case Constants.GBOX:
                    switch((int) Bodies.get(render).getDensity()){

                    }
                    break;
                default:

            }

        }

//        HSprite.setSize(HorizontalWidth*2, HorizontalHeight*2);
//        HSprite.setPosition(horizontalScaleBody.getPosition().x - HorizontalWidth, horizontalScaleBody.getPosition().y-HorizontalHeight);
//        HSprite.setOrigin(HorizontalWidth, HorizontalHeight);
//        HSprite.setRotation(horizontalScaleBody.getAngle()* MathUtils.radiansToDegrees);
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
