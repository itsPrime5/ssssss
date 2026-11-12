# THE UNDERTIDE

*A megalophobia horror mod for Minecraft Java 1.20.1 (Fabric).* 

## The hidden story
Before there was a sky, there was a listening dark. The Overworld is not a planet: it is the thin mineral scab over the sleeping back of something called the **First Stillness**. Mountains are scar tissue. Oceans are the hollows left where its weight pressed the world flat. The moon is a pale knot in a nerve that never finished dying.

The Witness is not the First Stillness. It is the shape a single thought makes while crossing the distance between two buried nerves. Its apparent body is already too large for the horizon; the limbs you see are only the nearest folds. It does not hunt. It checks whether the crust is still there.

## What the mod does
- Below Y=48, darkness, ash and distant cave resonance can interrupt the player. Below Y=32, the stone sometimes whispers through the action bar.
- `/undertide witness` calls a wandering, enormous silhouette into view. It slips toward nearby players in slow pulses and has deliberately oversized rendering bounds so the game does not cull it at normal distances.
- The Witness uses a deliberately incomplete humanoid texture: the player is meant to read it as a shape, not a creature.

The tension is environmental and sparse by design; effects are randomized, and creative/spectator players are unaffected.

## Build and install
1. Install a Java 17 JDK and a Fabric 1.20.1 profile.
2. Open this folder in IntelliJ IDEA, or run `gradle build` if Gradle is installed.
3. Copy `build/libs/undertide-1.0.0.jar` into the instance's `mods` folder alongside Fabric API.
4. Enter a world and run `/undertide witness` (cheats or operator permission required).

The Gradle project downloads Minecraft and Fabric dependencies on its first build. A Gradle wrapper is not included.

## Source map
- `Undertide.java`: entity registration, subterranean effects and summon command.
- `TheWitness.java`: server entity behavior and persistent phase.
- `UndertideClient.java`, `WitnessModel.java`, `WitnessRenderer.java`: client renderer and giant silhouette.
