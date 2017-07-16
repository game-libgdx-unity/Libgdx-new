package com.doodlegames.air.force.screen;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.AddAction;

public class Actions2 extends com.badlogic.gdx.scenes.scene2d.actions.Actions {
	static public AddAction add(Actor targetActor, Action action) {
		AddAction addAction = action(AddAction.class);
		addAction.setTargetActor(targetActor);
		addAction.setAction(action);
		return addAction;
	}
}
