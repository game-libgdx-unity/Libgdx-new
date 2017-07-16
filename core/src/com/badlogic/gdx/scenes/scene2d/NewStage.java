package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class NewStage extends Stage {

	public NewStage() {
		// TODO Auto-generated constructor stub
	}

	public NewStage(float width, float height, boolean keepAspectRatio) {
//		super(width, height, keepAspectRatio);
        super(new StretchViewport(width, width));
		// TODO Auto-generated constructor stub
	}

	public NewStage(float width, float height, boolean keepAspectRatio,
			SpriteBatch batch) {
        super(new StretchViewport(width, width), batch);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		try {
			return super.touchDown(screenX, screenY, pointer, button);
		} catch (Exception ex) {
			return true;
		}
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		try {
			return super.touchUp(screenX, screenY, pointer, button);
		} catch (Exception ex) {
			return true;
		}
	}
}
