package com.github.Wery848.unscrupulous.datagen;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import com.github.Wery848.unscrupulous.block.ModBlocks;
import com.github.Wery848.unscrupulous.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.Condition;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, UnscrupulousMod.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Block Models
        blockModels.createTrivialCube(ModBlocks.SOUL_STONE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_SOUL_STONE_ORE.get());

        // Multipart Blocks
        blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(ModBlocks.SOUL_BURN_FIRE.get())
                        .with(
                                Condition.and(
                                        Condition.condition().negatedTerm(BlockStateProperties.NORTH, true),
                                        Condition.condition().negatedTerm(BlockStateProperties.EAST, true),
                                        Condition.condition().negatedTerm(BlockStateProperties.SOUTH, true),
                                        Condition.condition().negatedTerm(BlockStateProperties.UP, true),
                                        Condition.condition().negatedTerm(BlockStateProperties.WEST, true)
                                ),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_floor0")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_floor1"))
                        )
                        .with(
                                Condition.or(
                                        Condition.condition().term(BlockStateProperties.NORTH, true),
                                        Condition.and(
                                                Condition.condition().negatedTerm(BlockStateProperties.NORTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.EAST, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.SOUTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.UP, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.WEST, true)
                                        )
                                ),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side0")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side1")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt0")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt1"))
                        )
                        .with(
                                Condition.or(
                                        Condition.condition().term(BlockStateProperties.EAST, true),
                                        Condition.and(
                                                Condition.condition().negatedTerm(BlockStateProperties.NORTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.EAST, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.SOUTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.UP, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.WEST, true)
                                        )
                                ),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        )
                        .with(
                                Condition.or(
                                        Condition.condition().term(BlockStateProperties.SOUTH, true),
                                        Condition.and(
                                                Condition.condition().negatedTerm(BlockStateProperties.NORTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.EAST, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.SOUTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.UP, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.WEST, true)
                                        )
                                ),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        )
                        .with(
                                Condition.or(
                                        Condition.condition().term(BlockStateProperties.WEST, true),
                                        Condition.and(
                                                Condition.condition().negatedTerm(BlockStateProperties.NORTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.EAST, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.SOUTH, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.UP, true),
                                                Condition.condition().negatedTerm(BlockStateProperties.WEST, true)
                                        )
                                ),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt0")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_side_alt1")).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        )
                        .with(
                                Condition.condition().term(BlockStateProperties.UP, true),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_up0")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_up1")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_up_alt0")),
                                Variant.variant().with(VariantProperties.MODEL, rl("soul_burn_fire_up_alt1"))
                        )
        );

        // Define all model resource locations
        blockModels.createFloorFireModels(ModBlocks.SOUL_BURN_FIRE.get());
        blockModels.createSideFireModels(ModBlocks.SOUL_BURN_FIRE.get());
        //blockModels.createTopFireModels(ModBlocks.SOUL_BURN_FIRE.get());
        blockModels.createFire();

        // Item Models
        itemModels.generateFlatItem(ModItems.SOUL_STONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SOUL_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.REFINED_SOUL_STONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SOUL_IN_A_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
    }

    private static ResourceLocation rl(String name) {
        return ResourceLocation.fromNamespaceAndPath("unscrupulous", "block/" + name);
    }
}
