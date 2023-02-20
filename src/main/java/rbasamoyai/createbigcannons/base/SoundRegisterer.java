package rbasamoyai.createbigcannons.base;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import rbasamoyai.createbigcannons.CreateBigCannons;

public class SoundRegisterer {

    public static SoundEvent mw2nuke_warn;
    public static SoundEvent mw2nuke_explode;
    public static SoundEvent smoke_shell_hiss;

    static {
        mw2nuke_warn = addSoundsToRegistry("mw2nuke_warn");
        mw2nuke_explode = addSoundsToRegistry("mw2nuke_explode");
        smoke_shell_hiss = addSoundsToRegistry("smoke_shell_hiss");
    }

    private static SoundEvent addSoundsToRegistry(String path){
        ResourceLocation soundLocation = new ResourceLocation(CreateBigCannons.MOD_ID,path);
        SoundEvent event = new SoundEvent(soundLocation);
        event.setRegistryName(soundLocation);
        return event;
    }
}
