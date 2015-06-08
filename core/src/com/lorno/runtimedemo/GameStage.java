package com.lorno.runtimedemo;

import com.badlogic.gdx.Gdx;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.resources.ResourceManager;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by LEONARD on 5/26/2015.
 */
public class GameStage extends Stage {

    private ResourceManager resourceManager;

    private String type;

    public GameStage(String type) {
        super();

        this.type = type;
        Gdx.input.setInputProcessor(this);

        resourceManager = new ResourceManager();
        resourceManager.initAllResources();

        initDemo();
    }

    public void initDemo() {
        clear();
        SceneLoader sceneLoader = new SceneLoader(resourceManager);

        if(this.type.equals("card")) {
            sceneLoader.loadScene("MainScene");
            GameCardScript gameCardScript = new GameCardScript();
            sceneLoader.sceneActor.addScript(gameCardScript);
        }
        else if(this.type.equals("timer")) {
            sceneLoader.loadScene("TimerScene");
            GameTimerScript gameTimerScript = new GameTimerScript();
            sceneLoader.sceneActor.addScript(gameTimerScript);
        }

        addActor(sceneLoader.sceneActor);
    }
}
