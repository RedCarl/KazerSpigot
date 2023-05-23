package net.minecraft.server;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;

public class EntitySlice<T> extends AbstractSet<T> {

	private static final Set<Class<?>> a = Sets.newConcurrentHashSet(); // CraftBukkit
	private final Map<Class<?>, List<T>> b =  new Object2ObjectArrayMap<>(); // WindSpigot - more fastutil collections
	private final Set<Class<?>> c = Sets.newIdentityHashSet();
	private final Class<T> d;
	private final List<T> e = Lists.newArrayList();

	public EntitySlice(Class<T> oclass) {
		this.d = oclass;
		this.c.add(oclass);
		this.b.put(oclass, this.e);

		for (Class<?> aClass : EntitySlice.a) {
			Class oclass1 = aClass;

			this.a(oclass1);
		}

	}

	protected void a(Class<?> oclass) {
		EntitySlice.a.add(oclass);

		for (T object : this.e) {
			if (oclass.isAssignableFrom(object.getClass())) {
				this.a(object, oclass);
			}
		}

		this.c.add(oclass);
	}

	protected Class<?> b(Class<?> oclass) {
		if (this.d.isAssignableFrom(oclass)) {
			if (!this.c.contains(oclass)) {
				this.a(oclass);
			}

			return oclass;
		} else {
			throw new IllegalArgumentException("Don't know how to search for " + oclass);
		}
	}

	@Override
	public boolean add(T t0) {

		for (Class<?> aClass : this.c) {
			Class oclass = aClass;

			if (oclass.isAssignableFrom(t0.getClass())) {
				this.a(t0, oclass);
			}
		}

		return true;
	}

	private void a(T t0, Class<?> oclass) {
		List<T> list = this.b.get(oclass);

		if (list == null) {
			this.b.put(oclass, Lists.newArrayList(t0));
		} else {
			list.add(t0);
		}

	}

	@Override
	public boolean remove(Object object) {
		Object object1 = object;
		boolean flag = false;

		for (Class<?> aClass : this.c) {
			Class oclass = aClass;

			if (oclass.isAssignableFrom(object1.getClass())) {
				List<T> list = this.b.get(oclass);

				if (list != null && list.remove(object1)) {
					flag = true;
				}
			}
		}

		return flag;
	}

	@Override
	public boolean contains(Object object) {
		return Iterators.contains(this.c(object.getClass()).iterator(), object);
	}

	public <S> Iterable<S> c(final Class<S> oclass) {
		return new Iterable() {
			@Override
			public Iterator<S> iterator() {
				List<T> list = EntitySlice.this.b.get(EntitySlice.this.b(oclass));

				if (list == null) {
					return Iterators.emptyIterator();
				} else {
					Iterator<T> iterator = list.iterator();

					return Iterators.filter(iterator, oclass);
				}
			}
		};
	}

	@Override
	public Iterator<T> iterator() {
		return this.e.isEmpty() ? Iterators.emptyIterator() : Iterators.unmodifiableIterator(this.e.iterator());
	}

	@Override
	public int size() {
		return this.e.size();
	}
}
