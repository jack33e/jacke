package net.jack.jackmod.datagen;

import net.jack.jackmod.JackMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = JackMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new net.jack.jackmod.datagen.ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), net.jack.jackmod.datagen.ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new net.jack.jackmod.datagen.ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new net.jack.jackmod.datagen.ModItemModelProvider(packOutput, existingFileHelper));

        net.jack.jackmod.datagen.ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new net.jack.jackmod.datagen.ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new net.jack.jackmod.datagen.ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new net.jack.jackmod.datagen.ModGlobalLootModifiersProvider(packOutput));
    }
}
