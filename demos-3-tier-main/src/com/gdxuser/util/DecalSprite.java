package com.gdxuser.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Vector3;

public class DecalSprite{

	public Decal sprite;

	public DecalSprite() {
		// constructor
	}
	
	public DecalSprite build(String imgPath) {
		TextureWrap texWrap = Texture.TextureWrap.ClampToEdge;	// default
		return build(imgPath, texWrap);
	}

	public DecalSprite build(String imgPath, TextureWrap texWrap) {
		Texture image = new Texture(
				Gdx.files.internal(imgPath));
		image.setFilter(Texture.TextureFilter.Linear,
				Texture.TextureFilter.Linear);
		image.setWrap(Texture.TextureWrap.Repeat,
				Texture.TextureWrap.Repeat);

		float w = image.getWidth();
		float h = image.getHeight();
		sprite = Decal.newDecal(w, h, new TextureRegion(image), true);
		return this;
	}

	public void faceCamera(Camera oCam) {
		// having the decal lookAt the camera...
		Vector3 dir = new Vector3(oCam.position.cpy().sub(sprite.getPosition()).nor());
		sprite.setRotation(dir, oCam.up.cpy().nor());
	}

	public void update(float delta) {
		// sprite.setRotation(dir, up)
	}
}
