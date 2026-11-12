package dev.blacktide.undertide;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
public class WitnessRenderer extends EntityRenderer<TheWitness> {
 private final WitnessModel model;
 private static final Identifier SKIN=new Identifier("minecraft","textures/entity/enderman/enderman.png");
 public WitnessRenderer(EntityRendererFactory.Context ctx){super(ctx);model=new WitnessModel(ctx.getPart(UndertideClient.WITNESS_LAYER));}
 @Override public void render(TheWitness e,float yaw,float tickDelta,MatrixStack matrices,VertexConsumerProvider vertices,int light){matrices.push();matrices.scale(4.5f,4.5f,4.5f);model.setAngles(e,0,0,e.age+tickDelta,0,0);model.render(matrices,vertices.getBuffer(RenderLayer.getEntityTranslucent(SKIN)),light,OverlayTexture.DEFAULT_UV,.28f,.31f,.34f,.78f);matrices.pop();super.render(e,yaw,tickDelta,matrices,vertices,light);}
 @Override public Identifier getTexture(TheWitness e){return SKIN;}
 @Override public boolean shouldRender(TheWitness e,net.minecraft.client.render.Frustum f,double x,double y,double z){return true;}
 @Override protected int getBlockLight(TheWitness e,net.minecraft.util.math.BlockPos pos){return 5;}
}
