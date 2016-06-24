package com.balance.balancegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Content;
import com.balance.balancegame.Game;

/**
 * Created by Registered User on 6/22/2016.
 */
public class GameScreen implements Screen {

    private Game myGame;
    public GameScreen(Game myGame){
        this.myGame = myGame;
    }
    private Viewport viewport;
    private OrthographicCamera camera;
    private static Content content;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(Constants.WIDTH/100, Constants.HEIGHT/100, camera);



        content = new Content();
        content.loadTexture("badlogic.jpg", "bad");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,0);
        myGame.batch.setProjectionMatrix(camera.combined);
        myGame.batch.begin();
        myGame.batch.draw(content.getTexture("bad"), 0,0,4,3);
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
