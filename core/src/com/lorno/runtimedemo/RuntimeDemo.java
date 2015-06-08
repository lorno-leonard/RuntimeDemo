package com.lorno.runtimedemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class RuntimeDemo extends ApplicationAdapter {
    private GameStage stage;

    private OrthographicCamera camera;

    private static final int VIRTUAL_WIDTH = 800;
    private static final int VIRTUAL_HEIGHT = 450;
    private static float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;

    private String type;

    public RuntimeDemo(String type) {
        this.type = type;
    }

	@Override
	public void create () {
        stage = new GameStage(this.type);

        ASPECT_RATIO = (float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();
        stage.getCamera().position.set(Gdx.graphics.getWidth()/2, (Gdx.graphics.getHeight()/2), 0);
	}

	@Override
	public void render () {
        super.render();
		Gdx.gl.glClearColor(197, 202, 208, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}

    @Override
    public void resize(int width, int height){
    }
}
