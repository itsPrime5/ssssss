package dev.blacktide.undertide;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import static net.minecraft.server.command.CommandManager.literal;

public class Undertide implements ModInitializer {
 public static final String MOD_ID="undertide";
 public static final EntityType<TheWitness> WITNESS=Registry.register(Registries.ENTITY_TYPE,new Identifier(MOD_ID,"the_witness"),FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,TheWitness::new).dimensions(EntityDimensions.fixed(3,10)).trackRangeBlocks(256).trackedUpdateRate(3).build());
 @Override public void onInitialize() {
  ServerTickEvents.END_WORLD_TICK.register(world->{
   if(world.getTime()%80!=0)return;
   for(ServerPlayerEntity player:world.getPlayers()) {
    if(player.isCreative()||player.isSpectator())continue;
    BlockPos p=player.getBlockPos();
    if(p.getY()<48&&world.getRandom().nextInt(5)==0){player.playSound(SoundEvents.AMBIENT_CAVE,0.7f,0.38f);player.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.DARKNESS,50,0,false,false,true));world.spawnParticles(ParticleTypes.ASH,player.getX(),player.getEyeY(),player.getZ(),8,.6,.4,.6,.01);}
    if(p.getY()<32&&world.getRandom().nextInt(24)==0)player.sendMessage(Text.translatable("message.undertide.pressure"),true);
   }
  });
  CommandRegistrationCallback.EVENT.register((dispatcher,registryAccess,environment)->dispatcher.register(literal("undertide").then(literal("witness").executes(ctx->{
   var player=ctx.getSource().getPlayerOrThrow();TheWitness e=WITNESS.create(player.getWorld());if(e==null)return 0;
   e.refreshPositionAndAngles(player.getX()+36,player.getY(),player.getZ()+36,135,0);player.getWorld().spawnEntity(e);
   ctx.getSource().sendFeedback(()->Text.literal("Something far too large has noticed the surface."),false);return 1;
  }))));
 }
}
