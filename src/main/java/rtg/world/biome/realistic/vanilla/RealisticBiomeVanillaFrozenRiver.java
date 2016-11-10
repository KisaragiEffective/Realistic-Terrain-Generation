package rtg.world.biome.realistic.vanilla;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import rtg.api.biome.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.vanilla.SurfaceVanillaFrozenRiver;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeVanillaFrozenRiver extends RealisticBiomeVanillaBase {

    public static Biome biome = Biomes.FROZEN_RIVER;
    public static Biome river = Biomes.FROZEN_RIVER;

    public RealisticBiomeVanillaFrozenRiver(BiomeConfig config) {

        super(config, biome, river,
            new SurfaceVanillaFrozenRiver(config)
        );

        this.waterSurfaceLakeChance = 0;
        this.lavaSurfaceLakeChance = 0;

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainVanillaFrozenRiver();
    }

    public class TerrainVanillaFrozenRiver extends TerrainBase {

        public TerrainVanillaFrozenRiver() {

        }

        @Override
        public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

            return terrainFlatLakes(x, y, simplex, river, 3f, 60f);
        }
    }
}
