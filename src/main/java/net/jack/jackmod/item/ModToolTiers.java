package net.jack.jackmod.item;

import net.jack.jackmod.JackMod;
import net.jack.jackmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;


import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 6f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(net.jack.jackmod.item.ModItems.SAPPHIRE.get())),
            new ResourceLocation(JackMod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
            }
