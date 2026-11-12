package dev.blacktide.undertide;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
public class UndertideClient implements ClientModInitializer {
 public static final EntityModelLayer WITNESS_LAYER=new EntityModelLayer(new Identifier("undertide","witness"),"main");
 @Override public void onInitializeClient(){net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.registerModelLayer(WITNESS_LAYER,WitnessModel::getTexturedModelData);EntityRendererRegistry.register(Undertide.WITNESS,WitnessRenderer::new);}
}
