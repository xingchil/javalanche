package de.unisb.cs.st.javalanche.mutation.run.threaded.task;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import de.unisb.cs.st.javalanche.mutation.properties.MutationProperties;

public class MutationTask {

	private File taskFile;

	private int id;

	public MutationTask(File taskFile, int id) {
		super();
		this.taskFile = taskFile;
		this.id = id;
	}

	public File getTaskFile() {
		return taskFile;
	}

	public int getID() {
		return id;
	}

	@Override
	public String toString() {
		return id +  " - "  + taskFile;
	}

	public static List<MutationTask> getTasks() {
		List<MutationTask> result = new ArrayList<MutationTask>();
		File dir = new File(MutationProperties.OUTPUT_DIR);
		File[] taskFiles = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name
						.startsWith(MutationTaskCreator.MUTATION_TASK_FILE_PREFIX)) {
					return true;
				}
				return false;
			}

		});
		for (File file : taskFiles) {
			int id = parseId(file);
			MutationTask mt = new MutationTask(file, id);
			result.add(mt);
		}
		return result;
	}

	private static int parseId(File file) {
		String name = file.getName();
		String idString = name.substring(
				MutationTaskCreator.MUTATION_TASK_FILE_PREFIX.length(), name
						.lastIndexOf('.'));
		int id = Integer.parseInt(idString);
		return id;
	}

	public static void main(String[] args) {
		System.out.println(getTasks());

	}
}
