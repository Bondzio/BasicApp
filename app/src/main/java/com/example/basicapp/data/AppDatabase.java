package com.example.basicapp.data;

import java.util.ArrayList;
import java.util.List;

public final class AppDatabase {


	public static List<Subject> getSubjectList() {
		return Subject.getSubjectList();
	}


	public static class Subject {

		private String name;
		private String drawableId;

		public Subject(String name, String drawableId) {
			this.name = name;
			this.drawableId = drawableId;
		}

		public String getName() {
			return name;
		}

		public String getDrawableId() {
			return drawableId;
		}

		public static List<Subject> getSubjectList() {

			List<Subject> list = new ArrayList<>();

			list.add(new Subject("1. Mathematik",
				"https://epsilonbildung" + ".de/wp-content/uploads/2019/02/Fotolia_76300304_L.jpg"));
			list.add(new Subject("2. Informatik", "https://i.redd.it/tpsnoz5bzo501.jpg"));
			list.add(new Subject("3. Biologie", "https://i.redd.it/qn7f9oqu7o501.jpg"));
			list.add(new Subject("4. Chemie", "https://i.redd.it/j6myfqglup501.jpg"));
			list.add(new Subject("5. Physik", "https://i.redd.it/0h2gm1ix6p501.jpg"));
			list.add(new Subject("6. Technik", "https://i.redd.it/k98uzl68eh501.jpg"));

			return list;
		}
	}
}
