package com.nulll.jar.civ.common.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModTabItems extends CreativeTabs{

	public ModTabItems(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Items.apple;
	}

}
