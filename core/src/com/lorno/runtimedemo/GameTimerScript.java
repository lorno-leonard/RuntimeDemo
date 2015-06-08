package com.lorno.runtimedemo;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.Image9patchItem;
import com.uwsoft.editor.renderer.script.IScript;
import com.uwsoft.editor.renderer.script.SimpleButtonScript;

import java.awt.event.InputEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by LEONARD on 6/8/2015.
 */
public class GameTimerScript implements IScript {
    private CompositeItem wrapperItem;

    private CompositeItem gameTimer;
    private CompositeItem btnTimer100;
    private CompositeItem btnTimer50;

    private Image9patchItem bg9Patch;
    private Image9patchItem progress9Patch;
    private float progressMaxWidth;

    private SimpleButtonScript scrBtnTimer100 = new SimpleButtonScript();
    private SimpleButtonScript scrBtnTimer50 = new SimpleButtonScript();

    private long delay = 0;
    private long intervalPeriod = 1 * 50;

    public GameTimerScript() {}

    @Override
    public void init(CompositeItem item) {
        wrapperItem = item;

        initItems();
    }

    @Override
    public void dispose() {
        btnTimer100.dispose();
        btnTimer50.dispose();
    }

    @Override
    public void act(float delta) {
        btnTimer100.act(delta);
        btnTimer50.act(delta);
    }

    private void initItems() {
        // Game Timer
        gameTimer = wrapperItem.getCompositeById("gameTimer");

        // Buttons
        btnTimer100 = wrapperItem.getCompositeById("btnTimer100");
        btnTimer50 = wrapperItem.getCompositeById("btnTimer50");

        // 9 Patch Image
        bg9Patch = gameTimer.getNinePatchById("bg");
        progress9Patch = gameTimer.getNinePatchById("progress");
        progressMaxWidth = progress9Patch.getWidth();

        // Simple Button Script
        scrBtnTimer100.init(btnTimer100);
        scrBtnTimer50.init(btnTimer50);

        initListeners();
    }

    private void initListeners() {
        btnTimer100.addListener(new ClickListener() {
            public boolean touchDown (com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                class percentTask extends TimerTask {
                    public volatile float percent = 100;
                    Timer timer;

                    public percentTask(Timer timer) {
                        this.timer = timer;
                    }

                    @Override
                    public void run() {
                        if( percent != 0 ) {
                            float decPercent = percent / 100;
                            BigDecimal bdWidth = new BigDecimal(decPercent * progressMaxWidth).setScale(2, RoundingMode.FLOOR);
                            float width = bdWidth.floatValue();
                            progress9Patch.setWidth(width);

                            percent--;
                        }
                        else {
                            progress9Patch.setVisible(false);
                            this.timer.cancel();
                            this.timer.purge();
                        }
                    }
                }

                Timer timer = new Timer();
                progress9Patch.setVisible(true);
                timer.scheduleAtFixedRate(new percentTask(timer), delay, intervalPeriod);
            }
        });
        btnTimer50.addListener(new ClickListener() {
            public boolean touchDown (com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                class percentTask extends TimerTask {
                    public volatile float percent = 50;
                    Timer timer;

                    public percentTask(Timer timer) {
                        this.timer = timer;
                    }

                    @Override
                    public void run() {
                        if( percent != 0 ) {
                            float decPercent = percent / 100;
                            BigDecimal bdWidth = new BigDecimal(decPercent * progressMaxWidth).setScale(2, RoundingMode.FLOOR);
                            float width = bdWidth.floatValue();
                            progress9Patch.setWidth(width);

                            percent--;
                        }
                        else {
                            progress9Patch.setVisible(false);
                            this.timer.cancel();
                            this.timer.purge();
                        }
                    }
                }

                Timer timer = new Timer();
                progress9Patch.setVisible(true);
                timer.scheduleAtFixedRate(new percentTask(timer), delay, intervalPeriod);
            }
        });
    }
}
