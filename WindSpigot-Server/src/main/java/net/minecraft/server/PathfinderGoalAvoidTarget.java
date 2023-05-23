package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.util.List;
import java.util.Objects;

public class PathfinderGoalAvoidTarget<T extends Entity> extends PathfinderGoal {

	private final Predicate<Entity> c = new Predicate<Entity>() {

		@Override
		public boolean apply(Entity param1Entity) {
			return (Objects.requireNonNull(param1Entity).isAlive() && a.getEntitySenses().a(param1Entity));
		}
	};

	protected EntityCreature a;

	private final double d;

	private final double e;

	protected T b;

	private final float f;

	private PathEntity g;

	private final NavigationAbstract h;

	private final Class<T> i;

	private final Predicate<? super T> j;

	public PathfinderGoalAvoidTarget(EntityCreature paramEntityCreature, Class<T> paramClass, float paramFloat,
			double paramDouble1, double paramDouble2) {
		this(paramEntityCreature, paramClass, Predicates.alwaysTrue(), paramFloat, paramDouble1, paramDouble2);
	}

	public PathfinderGoalAvoidTarget(EntityCreature paramEntityCreature, Class<T> paramClass,
			Predicate<? super T> paramPredicate, float paramFloat, double paramDouble1, double paramDouble2) {
		this.a = paramEntityCreature;
		this.i = paramClass;
		this.j = paramPredicate;
		this.f = paramFloat;
		this.d = paramDouble1;
		this.e = paramDouble2;
		this.h = paramEntityCreature.getNavigation();
		a(1);
	}

	public boolean a() {
		List<T> list = this.a.world.a(this.i, this.a.getBoundingBox().grow(this.f, 3.0D, this.f),
				Predicates.and(IEntitySelector.d, this.c, this.j));
		if (list.isEmpty())
			return false;
		this.b = list.get(0);
		Vec3D vec3D = RandomPositionGenerator.b(this.a, 16, 7,
				new Vec3D(this.b.locX, this.b.locY, this.b.locZ));
		if (vec3D == null)
			return false;
		if (this.b.e(vec3D.a, vec3D.b, vec3D.c) < this.b.h(this.a))
			return false;
		this.g = this.h.a(vec3D.a, vec3D.b, vec3D.c); 
		if (this.g == null)
			return false;
		return this.g.b(vec3D);
	}

	public boolean b() {
		return !this.h.m();
	}

	public void c() {
		this.h.a(this.g, this.d);
	}

	public void d() {
		this.b = null;
	}

	public void e() {
		if (this.a.h(this.b) < 49.0D) {
			this.a.getNavigation().a(this.e);
		} else {
			this.a.getNavigation().a(this.d);
		}
	}
}
