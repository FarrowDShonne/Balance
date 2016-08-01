package com.balance.balancegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.balance.balancegame.Content;
import com.balance.balancegame.Game;
import com.balance.balancegame.Handler.Collision;
import com.balance.balancegame.Handler.GameTimer;
import com.balance.balancegame.Objects.GeneratedObjects;
import com.balance.balancegame.Objects.Scale;

import static com.balance.balancegame.Constants.PPM;
import static com.balance.balancegame.Constants.HEIGHT;
import static com.balance.balancegame.Constants.WIDTH;

public class GameScreen implements Screen {

    private Game myGame;
    public GameScreen(Game myGame){
        this.myGame = myGame;
    }

    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private GeneratedObjects generatedObjects;
    private Scale scale;
    private GameTimer gameTimer;
    public static Content content;


    @Override
    public void show() {
        world = new World(new Vector2(0,-9.81f), true);
        world.setContactListener(new Collision());
        camera = new OrthographicCamera();
        camera.setToOrtho(false,WIDTH/PPM,HEIGHT/PPM);
        content = new Content();
        content.loadGameTexture("box.jpg","box");
        content.loadGameTexture("background.jpg", "background");
        content.loadGameTexture("scalebackground.jpg", "scalebackground");



        box2DDebugRenderer = new Box2DDebugRenderer();

        scale = new Scale(world);

        generatedObjects = new GeneratedObjects(world);
        //gameTimer = new GameTimer(world);
        world.setContactListener(new Collision());



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,0);
        camera.update();
        world.step(1/45f, 6, 2);
        scale.update();

        myGame.batch.setProjectionMatrix(camera.combined);
        myGame.batch.begin();
        myGame.batch.draw(content.getGameTexture("background"), 0,0,camera.viewportWidth, camera.viewportHeight);
        scale.renderScales(delta, myGame.batch);
        generatedObjects.renderGeneratedObjects(delta, myGame.batch);

        myGame.batch.end();
       box2DDebugRenderer.render(world, camera.combined);


        if(Gdx.input.justTouched()){
            float x = (float) Gdx.input.getX();
            float y = (float) (HEIGHT-Gdx.input.getY());

            generatedObjects.generateBlocks(x,y);

        }




    }

    @Override
    public void resize(int width, int height) {


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        box2DDebugRenderer.dispose();
    }
}
