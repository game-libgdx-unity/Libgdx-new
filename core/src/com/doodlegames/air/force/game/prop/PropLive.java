package com.doodlegames.air.force.game.prop;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.doodlegames.air.force.fighters.Fighter;
import com.doodlegames.air.force.game.GameObject;
import com.doodlegames.air.force.game.World;
import com.doodlegames.air.force.game.prop.Prop;
import com.doodlegames.air.force.game.prop.PropGenerator;
import com.doodlegames.air.force.game.prop.propFloatingPath.CircleFloating;
import com.doodlegames.air.force.resource.Assets_Props;
import com.doodlegames.air.force.utils.Animation;

import java.util.LinkedList;
import java.util.Queue;

public class PropLive extends Prop {

   private static int HEIGHT;
   public static final Animation PROPANIMATION;
   private static int WIDTH;
   public static PropGenerator propLiveGen = new PropGenerator() {
      public Prop getAProp(GameObject var1, World var2, float var3, float var4) {
         return PropLive.getAPropLive(var1, var2, var3, var4);
      }
   };
   private static Queue<PropLive> propLivePool = new LinkedList();


   static {
      TextureRegion[] var0 = new TextureRegion[]{Assets_Props.atlas_Prop.findRegion("player")};
      PROPANIMATION = new Animation(0, 1.0F, var0);
      WIDTH = -1;
      HEIGHT = -1;
   }

   public PropLive(GameObject var1, World var2, float var3, float var4) {
      super(var1, var2, var3, var4, (float)getRegionSize(true) / 1.0F, (float)getRegionSize(false) / 1.0F, true);
      this.initPropLive();
      this.propFloating = new CircleFloating(var2.rand, this);
   }

   private static void cycleAPropLive(PropLive var0) {
      if(var0 != null && propLivePool.size() < 5) {
         propLivePool.offer(var0);
      }
   }

   private static PropLive getAPropLive(GameObject var0, World var1, float var2, float var3) {
      if(propLivePool.peek() == null) {
         for(int var5 = 0; var5 < 10; ++var5) {
            propLivePool.offer(new PropLive(var0, var1, var2, var3));
         }
      }

      PropLive var4 = (PropLive)propLivePool.remove();
      var4.reset(var0, var1, var2, var3);
      return var4;
   }

   public static int getRegionSize(boolean var0) {
      if(WIDTH < 0 || HEIGHT < 0) {
         TextureAtlas.AtlasRegion var1 = Assets_Props.atlas_Prop.findRegion("player");
         int var2;
         if(var1.rotate) {
            var2 = var1.getRegionHeight();
         } else {
            var2 = var1.getRegionWidth();
         }

         WIDTH = var2;
         int var3;
         if(var1.rotate) {
            var3 = var1.getRegionWidth();
         } else {
            var3 = var1.getRegionHeight();
         }

         HEIGHT = var3;
      }

      return var0?WIDTH:HEIGHT;
   }

   public static void loadResource() {
      PROPANIMATION.setKeyFrame(0, Assets_Props.atlas_Prop.findRegion("player"));
   }

   public static int poolSize() {
      return propLivePool.size();
   }

   protected boolean exeutePropEffect(Fighter var1) {
      return var1.increaseALive();
   }

   public void freeToPool() {
      cycleAPropLive(this);
   }

   public void initPropLive() {
      this.propAnimation = PROPANIMATION;
   }

   public void reset(GameObject var1, World var2, float var3, float var4) {
      super.reset(var1, var2, var3, var4, (float)getRegionSize(true) / 1.0F, (float)getRegionSize(false) / 1.0F);
      this.initPropLive();
   }
}
