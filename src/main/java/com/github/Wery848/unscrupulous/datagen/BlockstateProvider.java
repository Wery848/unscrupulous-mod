package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.block.SoulBurnFire;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockstateProvider extends BlockStateProvider {
    public BlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UnscrupulousMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Do for all Blocks in BLOCKS Deferred register
        blockWithItem(ModBlocks.SOUL_STONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SOUL_STONE_ORE);

        // Soul Fire Multipart Block
        ModelFile soulBurnFloor0 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_floor0.json"));     //.withExistingParent("soul_burn_fire_floor0", this.mcLoc("block/template_fire_floor"));
        ModelFile soulBurnFloor1 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_floor1.json"));
        ModelFile soulBurnSide0 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_side0.json"));
        ModelFile soulBurnSide1 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_side1.json"));
        ModelFile soulBurnSideAlt0 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_side_alt0.json"));
        ModelFile soulBurnSideAlt1 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_side_alt1.json"));
        ModelFile soulBurnUp0 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_up0.json"));
        ModelFile soulBurnUp1 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_up1.json"));
        ModelFile soulBurnUpAlt0 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_up_alt0.json"));
        ModelFile soulBurnUpAlt1 = models().getExistingFile(ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/soul_burn_fire_up_alt1.json"));

        MultiPartBlockStateBuilder builder = getMultipartBuilder(ModBlocks.SOUL_BURN_FIRE.get());

        // Floor
        builder.part()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_floor0")))
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_floor1")))
                .addModel()
                .end();

        // Sides
        builder.part()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side0")))
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side1")))
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt0")))
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt1")))
                .addModel()
                .end();

        builder.part()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side0")))
                .rotationY(90)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side1")))
                .rotationY(90)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt0")))
                .rotationY(90)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt1")))
                .rotationY(90)
                .addModel()
                .end();

        builder.part()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side0")))
                .rotationY(180)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side1")))
                .rotationY(180)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt0")))
                .rotationY(180)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt1")))
                .rotationY(180)
                .addModel()
                .end();

        builder.part()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side0")))
                .rotationY(270)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side1")))
                .rotationY(270)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt0")))
                .rotationY(270)
                .nextModel()
                .modelFile(models().getExistingFile(modLoc("block/soul_burn_fire_side_alt1")))
                .rotationY(270)
                .addModel()
                .end();
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
