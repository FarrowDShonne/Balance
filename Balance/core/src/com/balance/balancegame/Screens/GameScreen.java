package com.balance.balancegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Content;
import com.balance.balancegame.Game;
import com.balance.balancegame.Objects.Scale;


public class GameScreen implements Screen {

    private Game myGame;
    public GameScreen(Game myGame){
        this.myGame = myGame;
    }
    private Viewport viewport;
    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    private Scale scale;

    @Override
    public void show() {
        world = new World(new Vector2(0,-9.81f), true);
        camera = new OrthographicCamera();
        viewport = new StretchViewport(Constants.WIDTH/100, Constants.HEIGHT/100, camera);

        box2DDebugRenderer = new Box2DDebugRenderer();

        scale = new Scale(world);



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,0);

        world.step(1/45f, 6, 2);
        box2DDebugRenderer.render(world, camera.combined);

        myGame.batch.setProjectionMatrix(camera.combined);
        myGame.batch.begin();
        myGame.batch.end();

    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
        viewport.apply(true);


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

    }
}
