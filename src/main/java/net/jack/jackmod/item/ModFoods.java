package net.jack.jackmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(5).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.6f).build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(5).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 400), 0.6f).build();















}

