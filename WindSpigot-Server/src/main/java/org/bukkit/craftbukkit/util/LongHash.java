package org.bukkit.craftbukkit.util;

public class LongHash {
	public static long toLong(int msw, int lsw) {
		return ((long) msw << 32) + lsw - Integer.MIN_VALUE;
	}

	public static int msw(long l) {
		return (int) (l >> 32);
	}

	public static int lsw(long l) {
		return (int) (l & 0xffff_ffff_ffff_ffffL) + Integer.MIN_VALUE;
	}
}
