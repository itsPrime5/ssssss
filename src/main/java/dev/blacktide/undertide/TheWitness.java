package dev.blacktide.undertide;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
/** The visible body is only a tiny proxy for a geological-scale intelligence. */
public class TheWitness extends Entity {
 private int phase;
 public TheWitness(EntityType<? extends TheWitness> type,World world){super(type,world);noClip=true;}
 @Override public void tick(){super.tick();noClip=true;if(!getWorld().isClient&&age%200==0){var p=getWorld().getClosestPlayer(this,96);if(p!=null){Vec3d d=p.getPos().subtract(getPos()).normalize();setVelocity(d.multiply(.12));velocityDirty=true;}}if(age%400==0)phase++;}
 public int getPhase(){return phase;}
 @Override protected void initDataTracker(){}
 @Override protected void readCustomDataFromNbt(NbtCompound n){phase=n.getInt("Phase");}
 @Override protected void writeCustomDataToNbt(NbtCompound n){n.putInt("Phase",phase);}
 @Override public boolean canHit(){return false;}
 @Override public boolean isPushable(){return false;}
 @Override public boolean shouldRender(double distance){return true;}
}
