package dev.blacktide.undertide;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;
public class WitnessModel extends EntityModel<TheWitness> {
 private final ModelPart root,head,leftArm,rightArm,leftLeg,rightLeg;
 public WitnessModel(ModelPart root){this.root=root;head=root.getChild("head");leftArm=root.getChild("left_arm");rightArm=root.getChild("right_arm");leftLeg=root.getChild("left_leg");rightLeg=root.getChild("right_leg");}
 public static TexturedModelData getTexturedModelData(){ModelData d=new ModelData();ModelPartData r=d.getRoot();
  r.addChild("head",CubeListBuilder.create().uv(0,0).cuboid(-7,-10,-6,14,16,12),ModelTransform.pivot(0,-30,0));
  r.addChild("body",CubeListBuilder.create().uv(0,32).cuboid(-10,-20,-6,20,38,12),ModelTransform.pivot(0,-7,0));
  r.addChild("left_arm",CubeListBuilder.create().uv(64,0).cuboid(-4,-2,-4,8,42,8),ModelTransform.pivot(14,-25,0));
  r.addChild("right_arm",CubeListBuilder.create().uv(64,0).cuboid(-4,-2,-4,8,42,8),ModelTransform.pivot(-14,-25,0));
  r.addChild("left_leg",CubeListBuilder.create().uv(96,0).cuboid(-5,0,-5,10,44,10),ModelTransform.pivot(6,10,0));
  r.addChild("right_leg",CubeListBuilder.create().uv(96,0).cuboid(-5,0,-5,10,44,10),ModelTransform.pivot(-6,10,0));return TexturedModelData.of(d,128,128);}
 @Override public void setAngles(TheWitness e,float limbAngle,float limbDistance,float age,float yaw,float pitch){head.yaw=yaw*.017453292f;head.pitch=pitch*.017453292f;leftArm.pitch=MathHelper.cos(age*.025f)*.04f;rightArm.pitch=-leftArm.pitch;leftLeg.pitch=MathHelper.cos(age*.018f)*.025f;rightLeg.pitch=-leftLeg.pitch;}
 @Override public void render(net.minecraft.client.util.math.MatrixStack matrices,net.minecraft.client.render.VertexConsumer vertices,int light,int overlay,float r,float g,float b,float a){root.render(matrices,vertices,light,overlay,r,g,b,a);}
}
