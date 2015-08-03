package com.nulll.jar.civ.common.modItems;

import com.nulll.jar.civ.common.core.MineCiv;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String unlocalizedName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(MineCiv.ModTabItems);
	}

}
