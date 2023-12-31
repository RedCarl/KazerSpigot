package net.minecraft.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class CommandScoreboard extends CommandAbstract {

	// TacoSpigot start - fix compile errors
	@Override
	public int compareTo(ICommand o) {
		return super.a(o);
	}
	// TacoSpigot end

	public CommandScoreboard() {
	}

	@Override
	public String getCommand() {
		return "scoreboard";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String getUsage(ICommandListener icommandlistener) {
		return "commands.scoreboard.usage";
	}

	@Override
	public void execute(ICommandListener icommandlistener, String[] astring) throws CommandException {
		if (!this.b(icommandlistener, astring)) {
			if (astring.length < 1) {
				throw new ExceptionUsage("commands.scoreboard.usage");
			} else if ("objectives".equalsIgnoreCase(astring[0])) {
				if (astring.length == 1) {
					throw new ExceptionUsage("commands.scoreboard.objectives.usage");
				}

				if ("list".equalsIgnoreCase(astring[1])) {
					this.d(icommandlistener);
				} else if ("add".equalsIgnoreCase(astring[1])) {
					if (astring.length < 4) {
						throw new ExceptionUsage("commands.scoreboard.objectives.add.usage");
					}

					this.b(icommandlistener, astring, 2);
				} else if ("remove".equalsIgnoreCase(astring[1])) {
					if (astring.length != 3) {
						throw new ExceptionUsage("commands.scoreboard.objectives.remove.usage");
					}

					this.h(icommandlistener, astring[2]);
				} else {
					if (!"setdisplay".equalsIgnoreCase(astring[1])) {
						throw new ExceptionUsage("commands.scoreboard.objectives.usage");
					}

					if (astring.length != 3 && astring.length != 4) {
						throw new ExceptionUsage("commands.scoreboard.objectives.setdisplay.usage");
					}

					this.j(icommandlistener, astring, 2);
				}
			} else if ("players".equalsIgnoreCase(astring[0])) {
				if (astring.length == 1) {
					throw new ExceptionUsage("commands.scoreboard.players.usage");
				}

				if ("list".equalsIgnoreCase(astring[1])) {
					if (astring.length > 3) {
						throw new ExceptionUsage("commands.scoreboard.players.list.usage");
					}

					this.k(icommandlistener, astring, 2);
				} else if ("add".equalsIgnoreCase(astring[1])) {
					if (astring.length < 5) {
						throw new ExceptionUsage("commands.scoreboard.players.add.usage");
					}

					this.l(icommandlistener, astring, 2);
				} else if ("remove".equalsIgnoreCase(astring[1])) {
					if (astring.length < 5) {
						throw new ExceptionUsage("commands.scoreboard.players.remove.usage");
					}

					this.l(icommandlistener, astring, 2);
				} else if ("set".equalsIgnoreCase(astring[1])) {
					if (astring.length < 5) {
						throw new ExceptionUsage("commands.scoreboard.players.set.usage");
					}

					this.l(icommandlistener, astring, 2);
				} else if ("reset".equalsIgnoreCase(astring[1])) {
					if (astring.length != 3 && astring.length != 4) {
						throw new ExceptionUsage("commands.scoreboard.players.reset.usage");
					}

					this.m(icommandlistener, astring, 2);
				} else if ("enable".equalsIgnoreCase(astring[1])) {
					if (astring.length != 4) {
						throw new ExceptionUsage("commands.scoreboard.players.enable.usage");
					}

					this.n(icommandlistener, astring, 2);
				} else if ("test".equalsIgnoreCase(astring[1])) {
					if (astring.length != 5 && astring.length != 6) {
						throw new ExceptionUsage("commands.scoreboard.players.test.usage");
					}

					this.o(icommandlistener, astring, 2);
				} else {
					if (!"operation".equalsIgnoreCase(astring[1])) {
						throw new ExceptionUsage("commands.scoreboard.players.usage");
					}

					if (astring.length != 7) {
						throw new ExceptionUsage("commands.scoreboard.players.operation.usage");
					}

					this.p(icommandlistener, astring, 2);
				}
			} else {
				if (!"teams".equalsIgnoreCase(astring[0])) {
					throw new ExceptionUsage("commands.scoreboard.usage");
				}

				if (astring.length == 1) {
					throw new ExceptionUsage("commands.scoreboard.teams.usage");
				}

				if ("list".equalsIgnoreCase(astring[1])) {
					if (astring.length > 3) {
						throw new ExceptionUsage("commands.scoreboard.teams.list.usage");
					}

					this.f(icommandlistener, astring, 2);
				} else if ("add".equalsIgnoreCase(astring[1])) {
					if (astring.length < 3) {
						throw new ExceptionUsage("commands.scoreboard.teams.add.usage");
					}

					this.c(icommandlistener, astring, 2);
				} else if ("remove".equalsIgnoreCase(astring[1])) {
					if (astring.length != 3) {
						throw new ExceptionUsage("commands.scoreboard.teams.remove.usage");
					}

					this.e(icommandlistener, astring, 2);
				} else if ("empty".equalsIgnoreCase(astring[1])) {
					if (astring.length != 3) {
						throw new ExceptionUsage("commands.scoreboard.teams.empty.usage");
					}

					this.i(icommandlistener, astring, 2);
				} else if ("join".equalsIgnoreCase(astring[1])) {
					if (astring.length < 4 && (astring.length != 3 || !(icommandlistener instanceof EntityHuman))) {
						throw new ExceptionUsage("commands.scoreboard.teams.join.usage");
					}

					this.g(icommandlistener, astring, 2);
				} else if ("leave".equalsIgnoreCase(astring[1])) {
					if (astring.length < 3 && !(icommandlistener instanceof EntityHuman)) {
						throw new ExceptionUsage("commands.scoreboard.teams.leave.usage");
					}

					this.h(icommandlistener, astring, 2);
				} else {
					if (!"option".equalsIgnoreCase(astring[1])) {
						throw new ExceptionUsage("commands.scoreboard.teams.usage");
					}

					if (astring.length != 4 && astring.length != 5) {
						throw new ExceptionUsage("commands.scoreboard.teams.option.usage");
					}

					this.d(icommandlistener, astring, 2);
				}
			}
		}
	}

	private boolean b(ICommandListener icommandlistener, String[] astring) throws CommandException {
		int i = -1;

		for (int j = 0; j < astring.length; ++j) {
			if (this.isListStart(astring, j) && "*".equals(astring[j])) {
				if (i >= 0) {
					throw new CommandException("commands.scoreboard.noMultiWildcard");
				}

				i = j;
			}
		}

		if (i < 0) {
			return false;
		} else {
			ArrayList<String> arraylist = Lists.newArrayList(this.d().getPlayers());
			String s = astring[i];
			ArrayList<Object> arraylist1 = Lists.newArrayList();

			for (String s1 : arraylist) {
				astring[i] = s1;

				try {
					this.execute(icommandlistener, astring);
					arraylist1.add(s1);
				} catch (CommandException commandexception) {
					ChatMessage chatmessage = new ChatMessage(commandexception.getMessage(),
							commandexception.getArgs());

					chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
					icommandlistener.sendMessage(chatmessage);
				}
			}

			astring[i] = s;
			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, arraylist1.size());
			if (arraylist1.size() == 0) {
				throw new ExceptionUsage("commands.scoreboard.allMatchesFailed");
			} else {
				return true;
			}
		}
	}

	protected Scoreboard d() {
		return MinecraftServer.getServer().getWorldServer(0).getScoreboard();
	}

	protected ScoreboardObjective a(String s, boolean flag) throws CommandException {
		Scoreboard scoreboard = this.d();
		ScoreboardObjective scoreboardobjective = scoreboard.getObjective(s);

		if (scoreboardobjective == null) {
			throw new CommandException("commands.scoreboard.objectiveNotFound", s);
		} else if (flag && scoreboardobjective.getCriteria().isReadOnly()) {
			throw new CommandException("commands.scoreboard.objectiveReadOnly", s);
		} else {
			return scoreboardobjective;
		}
	}

	protected ScoreboardTeam e(String s) throws CommandException {
		Scoreboard scoreboard = this.d();
		ScoreboardTeam scoreboardteam = scoreboard.getTeam(s);

		if (scoreboardteam == null) {
			throw new CommandException("commands.scoreboard.teamNotFound", s);
		} else {
			return scoreboardteam;
		}
	}

	protected void b(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		String s = astring[i++];
		String s1 = astring[i++];
		Scoreboard scoreboard = this.d();
		IScoreboardCriteria iscoreboardcriteria = IScoreboardCriteria.criteria.get(s1);

		if (iscoreboardcriteria == null) {
			throw new ExceptionUsage("commands.scoreboard.objectives.add.wrongType", s1);
		} else if (scoreboard.getObjective(s) != null) {
			throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", s);
		} else if (s.length() > 16) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.objectives.add.tooLong",
					s, 16);
		} else if (s.length() == 0) {
			throw new ExceptionUsage("commands.scoreboard.objectives.add.usage");
		} else {
			if (astring.length > i) {
				String s2 = a(icommandlistener, astring, i).c();

				if (s2.length() > 32) {
					throw new ExceptionInvalidSyntax("commands.scoreboard.objectives.add.displayTooLong",
							s2, 32);
				}

				if (s2.length() > 0) {
					scoreboard.registerObjective(s, iscoreboardcriteria).setDisplayName(s2);
				} else {
					scoreboard.registerObjective(s, iscoreboardcriteria);
				}
			} else {
				scoreboard.registerObjective(s, iscoreboardcriteria);
			}

			a(icommandlistener, this, "commands.scoreboard.objectives.add.success", s);
		}
	}

	protected void c(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		String s = astring[i++];
		Scoreboard scoreboard = this.d();

		if (scoreboard.getTeam(s) != null) {
			throw new CommandException("commands.scoreboard.teams.add.alreadyExists", s);
		} else if (s.length() > 16) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.teams.add.tooLong",
					s, 16);
		} else if (s.length() == 0) {
			throw new ExceptionUsage("commands.scoreboard.teams.add.usage");
		} else {
			if (astring.length > i) {
				String s1 = a(icommandlistener, astring, i).c();

				if (s1.length() > 32) {
					throw new ExceptionInvalidSyntax("commands.scoreboard.teams.add.displayTooLong",
							s1, 32);
				}

				if (s1.length() > 0) {
					scoreboard.createTeam(s).setDisplayName(s1);
				} else {
					scoreboard.createTeam(s);
				}
			} else {
				scoreboard.createTeam(s);
			}

			a(icommandlistener, this, "commands.scoreboard.teams.add.success", s);
		}
	}

	protected void d(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		ScoreboardTeam scoreboardteam = this.e(astring[i++]);

		if (scoreboardteam != null) {
			String s = astring[i++].toLowerCase();

			if (!"color".equalsIgnoreCase(s) && !"friendlyfire".equalsIgnoreCase(s)
					&& !"seeFriendlyInvisibles".equalsIgnoreCase(s) && !"nametagVisibility".equalsIgnoreCase(s)
					&& !"deathMessageVisibility".equalsIgnoreCase(s)) {
				throw new ExceptionUsage("commands.scoreboard.teams.option.usage");
			} else if (astring.length == 4) {
				if ("color".equalsIgnoreCase(s)) {
					throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
							s, a(EnumChatFormat.a(true, false)));
				} else if (!"friendlyfire".equalsIgnoreCase(s) && !"seeFriendlyInvisibles".equalsIgnoreCase(s)) {
					if (!"nametagVisibility".equalsIgnoreCase(s) && !"deathMessageVisibility".equalsIgnoreCase(s)) {
						throw new ExceptionUsage("commands.scoreboard.teams.option.usage");
					} else {
						throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
								s, a(ScoreboardTeamBase.EnumNameTagVisibility.a()));
					}
				} else {
					throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
							s, a(Arrays.asList("true", "false")));
				}
			} else {
				String s1 = astring[i];

				if ("color".equalsIgnoreCase(s)) {
					EnumChatFormat enumchatformat = EnumChatFormat.b(s1);

					if (enumchatformat == null || enumchatformat.isFormat()) {
						throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
								s, a(EnumChatFormat.a(true, false)));
					}

					scoreboardteam.a(enumchatformat);
					scoreboardteam.setPrefix(enumchatformat.toString());
					scoreboardteam.setSuffix(EnumChatFormat.RESET.toString());
				} else if ("friendlyfire".equalsIgnoreCase(s)) {
					if (!"true".equalsIgnoreCase(s1) && !"false".equalsIgnoreCase(s1)) {
						throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
								s, a(Arrays.asList("true", "false")));
					}

					scoreboardteam.setAllowFriendlyFire("true".equalsIgnoreCase(s1));
				} else if ("seeFriendlyInvisibles".equalsIgnoreCase(s)) {
					if (!"true".equalsIgnoreCase(s1) && !"false".equalsIgnoreCase(s1)) {
						throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
								s, a(Arrays.asList("true", "false")));
					}

					scoreboardteam.setCanSeeFriendlyInvisibles("true".equalsIgnoreCase(s1));
				} else {
					ScoreboardTeamBase.EnumNameTagVisibility scoreboardteambase_enumnametagvisibility;

					if ("nametagVisibility".equalsIgnoreCase(s)) {
						scoreboardteambase_enumnametagvisibility = ScoreboardTeamBase.EnumNameTagVisibility.a(s1);
						if (scoreboardteambase_enumnametagvisibility == null) {
							throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
									s, a(ScoreboardTeamBase.EnumNameTagVisibility.a()));
						}

						scoreboardteam.setNameTagVisibility(scoreboardteambase_enumnametagvisibility);
					} else if ("deathMessageVisibility".equalsIgnoreCase(s)) {
						scoreboardteambase_enumnametagvisibility = ScoreboardTeamBase.EnumNameTagVisibility.a(s1);
						if (scoreboardteambase_enumnametagvisibility == null) {
							throw new ExceptionUsage("commands.scoreboard.teams.option.noValue",
									s, a(ScoreboardTeamBase.EnumNameTagVisibility.a()));
						}

						scoreboardteam.b(scoreboardteambase_enumnametagvisibility);
					}
				}

				a(icommandlistener, this, "commands.scoreboard.teams.option.success",
						s, scoreboardteam.getName(), s1);
			}
		}
	}

	protected void e(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		ScoreboardTeam scoreboardteam = this.e(astring[i]);

		if (scoreboardteam != null) {
			scoreboard.removeTeam(scoreboardteam);
			a(icommandlistener, this, "commands.scoreboard.teams.remove.success",
					scoreboardteam.getName());
		}
	}

	protected void f(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();

		if (astring.length > i) {
			ScoreboardTeam scoreboardteam = this.e(astring[i]);

			if (scoreboardteam == null) {
				return;
			}

			Collection<String> collection = scoreboardteam.getPlayerNameSet();

			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.QUERY_RESULT, collection.size());
			if (collection.size() == 0) {
				throw new CommandException("commands.scoreboard.teams.list.player.empty",
						scoreboardteam.getName());
			}

			ChatMessage chatmessage = new ChatMessage("commands.scoreboard.teams.list.player.count",
					collection.size(), scoreboardteam.getName());

			chatmessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			icommandlistener.sendMessage(chatmessage);
			icommandlistener.sendMessage(new ChatComponentText(a(collection.toArray())));
		} else {
			Collection<ScoreboardTeam> collection1 = scoreboard.getTeams();

			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.QUERY_RESULT, collection1.size());
			if (collection1.size() == 0) {
				throw new CommandException("commands.scoreboard.teams.list.empty");
			}

			ChatMessage chatmessage1 = new ChatMessage("commands.scoreboard.teams.list.count",
					collection1.size());

			chatmessage1.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			icommandlistener.sendMessage(chatmessage1);

			for (ScoreboardTeam scoreboardteam1 : collection1) {
				icommandlistener.sendMessage(new ChatMessage("commands.scoreboard.teams.list.entry",
						scoreboardteam1.getName(), scoreboardteam1.getDisplayName(),
						scoreboardteam1.getPlayerNameSet().size()));
			}
		}

	}

	protected void g(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = astring[i++];
		HashSet<Object> hashset = Sets.newHashSet();
		HashSet<Object> hashset1 = Sets.newHashSet();
		String s1;

		if (icommandlistener instanceof EntityHuman && i == astring.length) {
			s1 = b(icommandlistener).getName();
			if (scoreboard.addPlayerToTeam(s1, s)) {
				hashset.add(s1);
			} else {
				hashset1.add(s1);
			}
		} else {
			while (i < astring.length) {
				s1 = astring[i++];
				if (s1.startsWith("@")) {
					List<Entity> list = c(icommandlistener, s1);

					for (Entity entity : list) {
						if (!entity.world.tacoSpigotConfig.nonPlayerEntitiesOnScoreboards
								&& !(entity instanceof EntityHuman)) {
							continue; // TacoSpigot
						}
						String s2 = e(icommandlistener, entity.getUniqueID().toString());

						if (scoreboard.addPlayerToTeam(s2, s)) {
							hashset.add(s2);
						} else {
							hashset1.add(s2);
						}
					}
				} else {
					String s3 = e(icommandlistener, s1);

					if (scoreboard.addPlayerToTeam(s3, s)) {
						hashset.add(s3);
					} else {
						hashset1.add(s3);
					}
				}
			}
		}

		if (!hashset.isEmpty()) {
			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, hashset.size());
			a(icommandlistener, this, "commands.scoreboard.teams.join.success", hashset.size(), s, a(hashset.toArray(new Object[0])));
		}

		if (!hashset1.isEmpty()) {
			throw new CommandException("commands.scoreboard.teams.join.failure", hashset1.size(), s, a(hashset1.toArray(new Object[0])));
		}
	}

	protected void h(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		HashSet<Object> hashset = Sets.newHashSet();
		HashSet<Object> hashset1 = Sets.newHashSet();
		String s;

		if (icommandlistener instanceof EntityHuman && i == astring.length) {
			s = b(icommandlistener).getName();
			if (scoreboard.removePlayerFromTeam(s)) {
				hashset.add(s);
			} else {
				hashset1.add(s);
			}
		} else {
			while (i < astring.length) {
				s = astring[i++];
				if (s.startsWith("@")) {
					List<Entity> list = c(icommandlistener, s);

					for (Entity entity : list) {
						String s1 = e(icommandlistener, entity.getUniqueID().toString());

						if (scoreboard.removePlayerFromTeam(s1)) {
							hashset.add(s1);
						} else {
							hashset1.add(s1);
						}
					}
				} else {
					String s2 = e(icommandlistener, s);

					if (scoreboard.removePlayerFromTeam(s2)) {
						hashset.add(s2);
					} else {
						hashset1.add(s2);
					}
				}
			}
		}

		if (!hashset.isEmpty()) {
			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, hashset.size());
			a(icommandlistener, this, "commands.scoreboard.teams.leave.success",
					hashset.size(), a(hashset.toArray(new Object[0])));
		}

		if (!hashset1.isEmpty()) {
			throw new CommandException("commands.scoreboard.teams.leave.failure", hashset1.size(), a(hashset1.toArray(new Object[0])));
		}
	}

	protected void i(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		ScoreboardTeam scoreboardteam = this.e(astring[i]);

		if (scoreboardteam != null) {
			ArrayList<String> arraylist = Lists.newArrayList(scoreboardteam.getPlayerNameSet());

			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, arraylist.size());
			if (arraylist.isEmpty()) {
				throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty",
						scoreboardteam.getName());
			} else {

				for (String s : arraylist) {
					scoreboard.removePlayerFromTeam(s, scoreboardteam);
				}

				a(icommandlistener, this, "commands.scoreboard.teams.empty.success",
						arraylist.size(), scoreboardteam.getName());
			}
		}
	}

	protected void h(ICommandListener icommandlistener, String s) throws CommandException {
		Scoreboard scoreboard = this.d();
		ScoreboardObjective scoreboardobjective = this.a(s, false);

		scoreboard.unregisterObjective(scoreboardobjective);
		a(icommandlistener, this, "commands.scoreboard.objectives.remove.success", s);
	}

	protected void d(ICommandListener icommandlistener) throws CommandException {
		Scoreboard scoreboard = this.d();
		Collection<ScoreboardObjective> collection = scoreboard.getObjectives();

		if (collection.size() == 0) {
			throw new CommandException("commands.scoreboard.objectives.list.empty");
		} else {
			ChatMessage chatmessage = new ChatMessage("commands.scoreboard.objectives.list.count",
					collection.size());

			chatmessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			icommandlistener.sendMessage(chatmessage);

			for (ScoreboardObjective scoreboardobjective : collection) {
				icommandlistener.sendMessage(new ChatMessage("commands.scoreboard.objectives.list.entry",
						scoreboardobjective.getName(), scoreboardobjective.getDisplayName(),
						scoreboardobjective.getCriteria().getName()));
			}

		}
	}

	protected void j(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = astring[i++];
		int j = Scoreboard.getSlotForName(s);
		ScoreboardObjective scoreboardobjective = null;

		if (astring.length == 4) {
			scoreboardobjective = this.a(astring[i], false);
		}

		if (j < 0) {
			throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", s);
		} else {
			scoreboard.setDisplaySlot(j, scoreboardobjective);
			if (scoreboardobjective != null) {
				a(icommandlistener, this, "commands.scoreboard.objectives.setdisplay.successSet",
						Scoreboard.getSlotName(j), scoreboardobjective.getName());
			} else {
				a(icommandlistener, this, "commands.scoreboard.objectives.setdisplay.successCleared",
						Scoreboard.getSlotName(j));
			}

		}
	}

	protected void k(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();

		if (astring.length > i) {
			String s = e(icommandlistener, astring[i]);
			Map<ScoreboardObjective, ScoreboardScore> map = scoreboard.getPlayerObjectives(s);

			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.QUERY_RESULT, map.size());
			if (map.size() == 0) {
				throw new CommandException("commands.scoreboard.players.list.player.empty", s);
			}

			ChatMessage chatmessage = new ChatMessage("commands.scoreboard.players.list.player.count",
					map.size(), s);

			chatmessage.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			icommandlistener.sendMessage(chatmessage);

			for (ScoreboardScore scoreboardscore : map.values()) {
				icommandlistener.sendMessage(new ChatMessage("commands.scoreboard.players.list.player.entry",
						scoreboardscore.getScore(),
						scoreboardscore.getObjective().getDisplayName(),
						scoreboardscore.getObjective().getName()));
			}
		} else {
			Collection<String> collection = scoreboard.getPlayers();

			icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.QUERY_RESULT, collection.size());
			if (collection.size() == 0) {
				throw new CommandException("commands.scoreboard.players.list.empty");
			}

			ChatMessage chatmessage1 = new ChatMessage("commands.scoreboard.players.list.count",
					collection.size());

			chatmessage1.getChatModifier().setColor(EnumChatFormat.DARK_GREEN);
			icommandlistener.sendMessage(chatmessage1);
			icommandlistener.sendMessage(new ChatComponentText(a(collection.toArray())));
		}

	}

	protected void l(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		String s = astring[i - 1];
		int j = i;
		String s1 = e(icommandlistener, astring[i++]);

		if (s1.length() > 40) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.players.name.tooLong",
					s1, 40);
		} else {
			ScoreboardObjective scoreboardobjective = this.a(astring[i++], true);
			int k = "set".equalsIgnoreCase(s) ? a(astring[i++]) : a(astring[i++], 0);

			if (astring.length > i) {
				Entity entity = b(icommandlistener, astring[j]);

				try {
					NBTTagCompound nbttagcompound = MojangsonParser.parse(a(astring, i));
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();

					entity.e(nbttagcompound1);
					if (!GameProfileSerializer.a(nbttagcompound, nbttagcompound1, true)) {
						throw new CommandException("commands.scoreboard.players.set.tagMismatch", s1);
					}
				} catch (MojangsonParseException mojangsonparseexception) {
					throw new CommandException("commands.scoreboard.players.set.tagError",
							mojangsonparseexception.getMessage());
				}
			}

			Scoreboard scoreboard = this.d();
			ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(s1, scoreboardobjective);

			if ("set".equalsIgnoreCase(s)) {
				scoreboardscore.setScore(k);
			} else if ("add".equalsIgnoreCase(s)) {
				scoreboardscore.addScore(k);
			} else {
				scoreboardscore.removeScore(k);
			}

			a(icommandlistener, this, "commands.scoreboard.players.set.success",
					scoreboardobjective.getName(), s1, scoreboardscore.getScore());
		}
	}

	protected void m(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = e(icommandlistener, astring[i++]);

		if (astring.length > i) {
			ScoreboardObjective scoreboardobjective = this.a(astring[i++], false);

			scoreboard.resetPlayerScores(s, scoreboardobjective);
			a(icommandlistener, this, "commands.scoreboard.players.resetscore.success",
					scoreboardobjective.getName(), s);
		} else {
			scoreboard.resetPlayerScores(s, null);
			a(icommandlistener, this, "commands.scoreboard.players.reset.success", s);
		}

	}

	protected void n(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = d(icommandlistener, astring[i++]);

		if (s.length() > 40) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.players.name.tooLong",
					s, 40);
		} else {
			ScoreboardObjective scoreboardobjective = this.a(astring[i], false);

			if (scoreboardobjective.getCriteria() != IScoreboardCriteria.c) {
				throw new CommandException("commands.scoreboard.players.enable.noTrigger",
						scoreboardobjective.getName());
			} else {
				ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(s, scoreboardobjective);

				scoreboardscore.a(false);
				a(icommandlistener, this, "commands.scoreboard.players.enable.success",
						scoreboardobjective.getName(), s);
			}
		}
	}

	protected void o(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = e(icommandlistener, astring[i++]);

		if (s.length() > 40) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.players.name.tooLong",
					s, 40);
		} else {
			ScoreboardObjective scoreboardobjective = this.a(astring[i++], false);

			if (!scoreboard.b(s, scoreboardobjective)) {
				throw new CommandException("commands.scoreboard.players.test.notFound",
						scoreboardobjective.getName(), s);
			} else {
				int j = "*".equals(astring[i]) ? Integer.MIN_VALUE : a(astring[i]);

				++i;
				int k = i < astring.length && !"*".equals(astring[i]) ? a(astring[i], j) : Integer.MAX_VALUE;
				ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(s, scoreboardobjective);

				if (scoreboardscore.getScore() >= j && scoreboardscore.getScore() <= k) {
					a(icommandlistener, this, "commands.scoreboard.players.test.success", scoreboardscore.getScore(), j, k);
				} else {
					throw new CommandException("commands.scoreboard.players.test.failed", scoreboardscore.getScore(), j, k);
				}
			}
		}
	}

	protected void p(ICommandListener icommandlistener, String[] astring, int i) throws CommandException {
		Scoreboard scoreboard = this.d();
		String s = e(icommandlistener, astring[i++]);
		ScoreboardObjective scoreboardobjective = this.a(astring[i++], true);
		String s1 = astring[i++];
		String s2 = e(icommandlistener, astring[i++]);
		ScoreboardObjective scoreboardobjective1 = this.a(astring[i], false);

		if (s.length() > 40) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.players.name.tooLong",
					s, 40);
		} else if (s2.length() > 40) {
			throw new ExceptionInvalidSyntax("commands.scoreboard.players.name.tooLong",
					s2, 40);
		} else {
			ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(s, scoreboardobjective);

			if (!scoreboard.b(s2, scoreboardobjective1)) {
				throw new CommandException("commands.scoreboard.players.operation.notFound",
						scoreboardobjective1.getName(), s2);
			} else {
				ScoreboardScore scoreboardscore1 = scoreboard.getPlayerScoreForObjective(s2, scoreboardobjective1);

				if ("+=".equals(s1)) {
					scoreboardscore.setScore(scoreboardscore.getScore() + scoreboardscore1.getScore());
				} else if ("-=".equals(s1)) {
					scoreboardscore.setScore(scoreboardscore.getScore() - scoreboardscore1.getScore());
				} else if ("*=".equals(s1)) {
					scoreboardscore.setScore(scoreboardscore.getScore() * scoreboardscore1.getScore());
				} else if ("/=".equals(s1)) {
					if (scoreboardscore1.getScore() != 0) {
						scoreboardscore.setScore(scoreboardscore.getScore() / scoreboardscore1.getScore());
					}
				} else if ("%=".equals(s1)) {
					if (scoreboardscore1.getScore() != 0) {
						scoreboardscore.setScore(scoreboardscore.getScore() % scoreboardscore1.getScore());
					}
				} else if ("=".equals(s1)) {
					scoreboardscore.setScore(scoreboardscore1.getScore());
				} else if ("<".equals(s1)) {
					scoreboardscore.setScore(Math.min(scoreboardscore.getScore(), scoreboardscore1.getScore()));
				} else if (">".equals(s1)) {
					scoreboardscore.setScore(Math.max(scoreboardscore.getScore(), scoreboardscore1.getScore()));
				} else {
					if (!"><".equals(s1)) {
						throw new CommandException("commands.scoreboard.players.operation.invalidOperation",
								s1);
					}

					int j = scoreboardscore.getScore();

					scoreboardscore.setScore(scoreboardscore1.getScore());
					scoreboardscore1.setScore(j);
				}

				a(icommandlistener, this, "commands.scoreboard.players.operation.success");
			}
		}
	}

	@Override
	public List<String> tabComplete(ICommandListener icommandlistener, String[] astring, BlockPosition blockposition) {
		if (astring.length == 1) {
			return a(astring, "objectives", "players", "teams");
		} else {
			if ("objectives".equalsIgnoreCase(astring[0])) {
				if (astring.length == 2) {
					return a(astring, "list", "add", "remove", "setdisplay");
				}

				if ("add".equalsIgnoreCase(astring[1])) {
					if (astring.length == 4) {
						Set<String> set = IScoreboardCriteria.criteria.keySet();

						return a(astring, set);
					}
				} else if ("remove".equalsIgnoreCase(astring[1])) {
					if (astring.length == 3) {
						return a(astring, this.a(false));
					}
				} else if ("setdisplay".equalsIgnoreCase(astring[1])) {
					if (astring.length == 3) {
						return a(astring, Scoreboard.h());
					}

					if (astring.length == 4) {
						return a(astring, this.a(false));
					}
				}
			} else if ("players".equalsIgnoreCase(astring[0])) {
				if (astring.length == 2) {
					return a(astring,
							"set", "add", "remove", "reset", "list", "enable", "test", "operation");
				}

				if (!"set".equalsIgnoreCase(astring[1]) && !"add".equalsIgnoreCase(astring[1])
						&& !"remove".equalsIgnoreCase(astring[1]) && !"reset".equalsIgnoreCase(astring[1])) {
					if ("enable".equalsIgnoreCase(astring[1])) {
						if (astring.length == 3) {
							return a(astring, MinecraftServer.getServer().getPlayers());
						}

						if (astring.length == 4) {
							return a(astring, this.e());
						}
					} else if (!"list".equalsIgnoreCase(astring[1]) && !"test".equalsIgnoreCase(astring[1])) {
						if ("operation".equalsIgnoreCase(astring[1])) {
							switch (astring.length) {
							case 3:
								return a(astring, this.d().getPlayers());
							case 4:
								return a(astring, this.a(true));
							case 5:
								return a(astring, "+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><");
							case 6:
								return a(astring, MinecraftServer.getServer().getPlayers());
							case 7:
								return a(astring, this.a(false));
							default:
								break;
							}
						}
					} else {
						if (astring.length == 3) {
							return a(astring, this.d().getPlayers());
						}

						if (astring.length == 4 && "test".equalsIgnoreCase(astring[1])) {
							return a(astring, this.a(false));
						}
					}
				} else {
					if (astring.length == 3) {
						return a(astring, MinecraftServer.getServer().getPlayers());
					}

					if (astring.length == 4) {
						return a(astring, this.a(true));
					}
				}
			} else if ("teams".equalsIgnoreCase(astring[0])) {
				if (astring.length == 2) {
					return a(astring, "add", "remove", "join", "leave", "empty", "list", "option");
				}

				if ("join".equalsIgnoreCase(astring[1])) {
					if (astring.length == 3) {
						return a(astring, this.d().getTeamNames());
					}

                    return a(astring, MinecraftServer.getServer().getPlayers());
                } else {
					if ("leave".equalsIgnoreCase(astring[1])) {
						return a(astring, MinecraftServer.getServer().getPlayers());
					}

					if (!"empty".equalsIgnoreCase(astring[1]) && !"list".equalsIgnoreCase(astring[1])
							&& !"remove".equalsIgnoreCase(astring[1])) {
						if ("option".equalsIgnoreCase(astring[1])) {
							switch (astring.length) {
							case 3:
								return a(astring, this.d().getTeamNames());
							case 4:
								return a(astring, "color", "friendlyfire", "seeFriendlyInvisibles",
										"nametagVisibility", "deathMessageVisibility");
							case 5:
								if ("color".equalsIgnoreCase(astring[3])) {
									return a(astring, EnumChatFormat.a(true, false));
								}
								if ("nametagVisibility".equalsIgnoreCase(astring[3])
										|| "deathMessageVisibility".equalsIgnoreCase(astring[3])) {
									return a(astring, ScoreboardTeamBase.EnumNameTagVisibility.a());
								}
								if ("friendlyfire".equalsIgnoreCase(astring[3])
										|| "seeFriendlyInvisibles".equalsIgnoreCase(astring[3])) {
									return a(astring, "true", "false");
								}
								break;
							default:
								break;
							}
						}
					} else if (astring.length == 3) {
						return a(astring, this.d().getTeamNames());
					}
				}
			}

			return null;
		}
	}

	protected List<String> a(boolean flag) {
		Collection<ScoreboardObjective> collection = this.d().getObjectives();
		ArrayList arraylist = Lists.newArrayList();

		for (ScoreboardObjective scoreboardobjective : collection) {
			if (!flag || !scoreboardobjective.getCriteria().isReadOnly()) {
				arraylist.add(scoreboardobjective.getName());
			}
		}

		return arraylist;
	}

	protected List<String> e() {
		Collection<ScoreboardObjective> collection = this.d().getObjectives();
		ArrayList arraylist = Lists.newArrayList();

		for (ScoreboardObjective scoreboardobjective : collection) {
			if (scoreboardobjective.getCriteria() == IScoreboardCriteria.c) {
				arraylist.add(scoreboardobjective.getName());
			}
		}

		return arraylist;
	}

	@Override
	public boolean isListStart(String[] astring, int i) {
		return !"players".equalsIgnoreCase(astring[0]) ? ("teams".equalsIgnoreCase(astring[0]) && i == 2)
				: (astring.length > 1 && "operation".equalsIgnoreCase(astring[1]) ? i == 2 || i == 5 : i == 2);
	}
}
