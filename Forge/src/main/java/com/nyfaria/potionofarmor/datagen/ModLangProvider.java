package com.nyfaria.potionofarmor.datagen;

import com.google.common.collect.ImmutableMap;
import com.nyfaria.potionofarmor.registration.RegistryObject;
import com.nyfaria.potionofarmor.Constants;
import com.nyfaria.potionofarmor.init.BlockInit;
import com.nyfaria.potionofarmor.init.EntityInit;
import com.nyfaria.potionofarmor.init.ItemInit;
import com.nyfaria.potionofarmor.init.MobEffectInit;
import com.nyfaria.potionofarmor.init.PotionInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModLangProvider extends LanguageProvider {
    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.ITEMS.getEntries().forEach(this::itemLang);
        EntityInit.ENTITIES.getEntries().forEach(this::entityLang);
        BlockInit.BLOCKS.getEntries().forEach(this::blockLang);
        Stream.of(
                PotionInit.POTION_OF_ARMOR,
                PotionInit.POTION_OF_IRON_ARMOR,
                PotionInit.POTION_OF_DIAMOND_ARMOR,
                PotionInit.POTION_OF_NETHERITE_ARMOR
        ).forEach(this::potionLang);
        addEffect(MobEffectInit.MAGIC_ARMOR, "Magic Armor");

    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplace(entry));
        }
    }

    protected void potionLang(RegistryObject<Potion> entry) {
        add(entry.get().getName(Items.POTION.getDescriptionId() + ".effect."), checkReplace(entry));
        add(entry.get().getName(Items.SPLASH_POTION.getDescriptionId() + ".effect."), "Splash " + checkReplace(entry));
        add(entry.get().getName(Items.LINGERING_POTION.getDescriptionId() + ".effect."), "Lingering " + checkReplace(entry));
    }

    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}
