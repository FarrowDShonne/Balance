package com.balance.balancegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Registered User on 6/22/2016.
 */
public class Content {

    private HashMap<String, Texture> textures;
    private HashMap<String, Texture> Gametextures;

    public Content(){
        textures = new HashMap<String, Texture>();
        Gametextures = new HashMap<String, Texture>();
}

    public void loadTexture(String path, String key) {
        Texture tex = new Texture(Gdx.files.internal(path));
        textures.put(key, tex);
    }
    public Texture getTexture(String key) {
        return textures.get(key);
    }
    public void removeTexture(String key) {
        Texture tex = textures.get(key);
        if(tex != null) {
            textures.remove(key);
            tex.dispose();
        }
    }


    public void loadGameTexture(String path, String key) {
        Texture tex = new Texture(Gdx.files.internal(path));
        Gametextures.put(key, tex);
    }
    public Texture getGameTexture(String key) {
        return Gametextures.get(key);
    }
    public void removeGameTexture(String key) {
        Texture tex = Gametextures.get(key);
        if(tex != null) {
            Gametextures.remove(key);
            tex.dispose();
        }
    }

}
