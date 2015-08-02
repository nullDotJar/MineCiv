package com.nulll.jar.civ.common.modBlocks;

import com.nulll.jar.civ.common.core.MineCiv;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ResourceNode extends Block {

    public ResourceNode(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(MineCiv.ModTabBlocks);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public ResourceNode(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.rock, hardness, resistance);
    }

    public ResourceNode(String unlocalizedName) {
        this(unlocalizedName, -1f, 18000000f);
        // Same hardness and resistance as bedrock 
    }
}
