package com.lorno.runtimedemo;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.SpriteAnimation;
import com.uwsoft.editor.renderer.script.IScript;
import com.uwsoft.editor.renderer.script.SimpleButtonScript;

import java.util.HashMap;

/**
 * Created by LEONARD on 5/26/2015.
 */
public class GameCardScript implements IScript {
    private CompositeItem wrapperItem;

    private CompositeItem btnCardAS;
    private CompositeItem btnCard9D;
    private CompositeItem btnCardKC;
    private CompositeItem btnCardSmallAS;
    private CompositeItem btnCardSmall9D;
    private CompositeItem btnCardSmallKC;
    private CompositeItem btnChipP;
    private CompositeItem btnChipN;
    private CompositeItem btnChipZ;

    private SpriteAnimation cardAnimation;
    private SpriteAnimation cardSmallAnimation;
    private SpriteAnimation chipAnimation;

    private HashMap<String, Integer> cardHashMap = new HashMap<String, Integer>();
    private HashMap<String, Integer> chipHashMap = new HashMap<String, Integer>();

    private SimpleButtonScript scrBtnCardAS = new SimpleButtonScript();
    private SimpleButtonScript scrBtnCard9D = new SimpleButtonScript();
    private SimpleButtonScript scrBtnCardKC = new SimpleButtonScript();
    private SimpleButtonScript scrBtnCardSmallAS = new SimpleButtonScript();
    private SimpleButtonScript scrBtnCardSmall9D = new SimpleButtonScript();
    private SimpleButtonScript scrBtnCardSmallKC = new SimpleButtonScript();
    private SimpleButtonScript scrBtnChipP = new SimpleButtonScript();
    private SimpleButtonScript scrBtnChipN = new SimpleButtonScript();
    private SimpleButtonScript scrBtnChipZ = new SimpleButtonScript();

    @Override
    public void init(CompositeItem item) {
        wrapperItem = item;

        initItems();
        initHashMaps();
    }

    @Override
    public void dispose() {
        btnCardAS.dispose();
        btnCard9D.dispose();
        btnCardKC.dispose();
        btnCardSmallAS.dispose();
        btnCardSmall9D.dispose();
        btnCardSmallKC.dispose();
        btnChipP.dispose();
        btnChipN.dispose();
        btnChipZ.dispose();
    }

    @Override
    public void act(float delta) {
        btnCardAS.act(delta);
        btnCard9D.act(delta);
        btnCardKC.act(delta);
        btnCardSmallAS.act(delta);
        btnCardSmall9D.act(delta);
        btnCardSmallKC.act(delta);
        btnChipP.act(delta);
        btnChipN.act(delta);
        btnChipZ.act(delta);
    }

    private void initItems() {
        // Animations
        cardAnimation = wrapperItem.getSpriteAnimationById("cardAnimation");
        cardSmallAnimation = wrapperItem.getSpriteAnimationById("cardSmallAnimation");
        chipAnimation = wrapperItem.getSpriteAnimationById("chipAnimation");

        // Buttons
        btnCardAS = wrapperItem.getCompositeById("btnCardAS");
        btnCard9D = wrapperItem.getCompositeById("btnCard9D");
        btnCardKC = wrapperItem.getCompositeById("btnCardKC");
        btnCardSmallAS = wrapperItem.getCompositeById("btnCardSmallAS");
        btnCardSmall9D = wrapperItem.getCompositeById("btnCardSmall9D");
        btnCardSmallKC = wrapperItem.getCompositeById("btnCardSmallKC");
        btnChipP = wrapperItem.getCompositeById("btnChipP");
        btnChipN = wrapperItem.getCompositeById("btnChipN");
        btnChipZ = wrapperItem.getCompositeById("btnChipZ");

        // Simple Button Script
        scrBtnCardAS.init(btnCardAS);
        scrBtnCard9D.init(btnCard9D);
        scrBtnCardKC.init(btnCardKC);
        scrBtnCardSmallAS.init(btnCardSmallAS);
        scrBtnCardSmall9D.init(btnCardSmall9D);
        scrBtnCardSmallKC.init(btnCardSmallKC);
        scrBtnChipP.init(btnChipP);
        scrBtnChipN.init(btnChipN);
        scrBtnChipZ.init(btnChipZ);

        initListeners();
    }

    private void initListeners() {
        btnCardAS.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardAnimation.setCurrFrame(cardHashMap.get("as"));
                cardAnimation.pause();
            }
        });
        btnCard9D.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardAnimation.setCurrFrame(cardHashMap.get("9d"));
                cardAnimation.pause();
            }
        });
        btnCardKC.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardAnimation.setCurrFrame(cardHashMap.get("ks"));
                cardAnimation.pause();
            }
        });
        btnCardSmallAS.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardSmallAnimation.setCurrFrame(cardHashMap.get("as"));
                cardSmallAnimation.pause();
            }
        });
        btnCardSmall9D.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardSmallAnimation.setCurrFrame(cardHashMap.get("9d"));
                cardSmallAnimation.pause();
            }
        });
        btnCardSmallKC.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                cardSmallAnimation.setCurrFrame(cardHashMap.get("ks"));
                cardSmallAnimation.pause();
            }
        });
        btnChipP.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                chipAnimation.setCurrFrame(chipHashMap.get("positive"));
                chipAnimation.pause();
            }
        });
        btnChipN.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                chipAnimation.setCurrFrame(chipHashMap.get("negative"));
                chipAnimation.pause();
            }
        });
        btnChipZ.addListener(new ClickListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                chipAnimation.setCurrFrame(chipHashMap.get("zero"));
                chipAnimation.pause();
            }
        });
    }

    private void initHashMaps() {
        // Set Card HashMap values
        cardHashMap.put("2h",  0);
        cardHashMap.put("3h",  1);
        cardHashMap.put("4h",  2);
        cardHashMap.put("5h",  3);
        cardHashMap.put("6h",  4);
        cardHashMap.put("7h",  5);
        cardHashMap.put("8h",  6);
        cardHashMap.put("9h",  7);
        cardHashMap.put("th",  8);
        cardHashMap.put("jh",  9);
        cardHashMap.put("qh", 10);
        cardHashMap.put("kh", 11);
        cardHashMap.put("ah", 12);

        cardHashMap.put("2c", 13);
        cardHashMap.put("3c", 14);
        cardHashMap.put("4c", 15);
        cardHashMap.put("5c", 16);
        cardHashMap.put("6c", 17);
        cardHashMap.put("7c", 18);
        cardHashMap.put("8c", 19);
        cardHashMap.put("9c", 20);
        cardHashMap.put("tc", 21);
        cardHashMap.put("jc", 22);
        cardHashMap.put("qc", 23);
        cardHashMap.put("kc", 24);
        cardHashMap.put("ac", 25);

        cardHashMap.put("2d", 26);
        cardHashMap.put("3d", 27);
        cardHashMap.put("4d", 28);
        cardHashMap.put("5d", 29);
        cardHashMap.put("6d", 30);
        cardHashMap.put("7d", 31);
        cardHashMap.put("8d", 32);
        cardHashMap.put("9d", 33);
        cardHashMap.put("td", 34);
        cardHashMap.put("jd", 35);
        cardHashMap.put("qd", 36);
        cardHashMap.put("kd", 37);
        cardHashMap.put("ad", 38);

        cardHashMap.put("2s", 39);
        cardHashMap.put("3s", 40);
        cardHashMap.put("4s", 41);
        cardHashMap.put("5s", 42);
        cardHashMap.put("6s", 43);
        cardHashMap.put("7s", 44);
        cardHashMap.put("8s", 45);
        cardHashMap.put("9s", 46);
        cardHashMap.put("ts", 47);
        cardHashMap.put("js", 48);
        cardHashMap.put("qs", 49);
        cardHashMap.put("ks", 50);
        cardHashMap.put("as", 51);

        cardHashMap.put("bg", 52);
        cardHashMap.put("bs", 53);

        // Set Chip HashMap values
        chipHashMap.put("positive", 0);
        chipHashMap.put("negative", 1);
        chipHashMap.put("zero", 2);
    }
}
