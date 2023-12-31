package net.minecraft.server;

public class NextTickListEntry implements Comparable<NextTickListEntry> {

	private static long d;
	private final Block e;
	public final BlockPosition a;
	public long b;
	public int c;
	private final long f;

	public NextTickListEntry(BlockPosition blockposition, Block block) {
		this.f = (NextTickListEntry.d++);
		this.a = blockposition;
		this.e = block;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof NextTickListEntry)) {
			return false;
		} else {
			NextTickListEntry nextticklistentry = (NextTickListEntry) object;

			return this.a.equals(nextticklistentry.a) && Block.a(this.e, nextticklistentry.e);
		}
	}

	@Override
	public int hashCode() {
		return this.a.hashCode();
	}

	public NextTickListEntry a(long i) {
		this.b = i;
		return this;
	}

	public void a(int i) {
		this.c = i;
	}

	public int a(NextTickListEntry nextticklistentry) {
		return this.b < nextticklistentry.b ? -1
				: (this.b > nextticklistentry.b ? 1
						: (this.c != nextticklistentry.c ? this.c - nextticklistentry.c
								: (Long.compare(this.f, nextticklistentry.f))));
	}

	@Override
	public String toString() {
		return Block.getId(this.e) + ": " + this.a + ", " + this.b + ", " + this.c + ", " + this.f;
	}

	public Block a() {
		return this.e;
	}

	@Override
	public int compareTo(NextTickListEntry object) {
		return this.a(object);
	}
}
