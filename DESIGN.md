# Design brief: The Undertide

## Horror thesis
Fear comes from scale mismatch, not damage numbers. The player should first notice a sound without a source, then a shape too large to frame, then a geological implication that invalidates the map. The Witness never attacks; its indifference is the threat.

## In-game arc
1. **Pressure** — caves below Y=48 produce occasional darkness, ash and cave resonance.
2. **Response** — below Y=32 the action bar reports that stone flexes. It is not a quest prompt and gives no direction.
3. **Evidence** — lore fragments in LORE.md establish that the Overworld is a crust laid over a planetary-scale organism.
4. **Witness** — the command brings in a distant, translucent silhouette. Its giant render bounds defeat ordinary distance culling; its collision box remains intentionally small because the body is only an image imposed on local space.
5. **Afterimage** — the entity approaches in brief pulses rather than continuous motion. It is never framed as a boss or objective.

## Scale and implementation limits
Minecraft's entity coordinates and collision are designed for local actors. The mod keeps the logical entity small enough to behave safely and enlarges only its client-side model, while forcing its renderer to remain eligible outside normal culling. This creates an impossible apparent scale without rewriting the game's world coordinate system or flooding chunks with enormous hitboxes.

## Future authored content
The strongest next additions are a rare bedrock seam structure containing the field notes, custom low-frequency audio, and a horizon shader that draws a curved shadow only during underground weather. Those require extra authored assets and a render pipeline beyond this starter's vanilla-compatible core.
