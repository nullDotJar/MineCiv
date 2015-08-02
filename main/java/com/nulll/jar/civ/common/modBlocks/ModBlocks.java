package com.nulll.jar.civ.common.modBlocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block copperOreNode;

    public static void createBlocks() {
        GameRegistry.registerBlock(copperOreNode = new ResourceNode("copperOreNode"), "copperOreNode");
    }
}