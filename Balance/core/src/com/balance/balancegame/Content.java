package com.balance.balancegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Registered User on 6/22/2016.
 */
public class Content {

    private HashMap<String, Texture> textures;

    public Texture box = new Texture(Gdx.files.internal("box.jpg"));

    public Content(){
        textures = new HashMap<String, Texture>();
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

}
