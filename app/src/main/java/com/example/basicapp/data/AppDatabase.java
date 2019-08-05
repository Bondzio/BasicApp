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

			list.add(new Subject("1. Mathematik", "https://cdn4.iconfinder.com/data/icons/education-and-school-10/800/compass-512.png"));
			list.add(new Subject("2. Informatik", "https://cdn0.iconfinder.com/data/icons/electronics-line-style/64/Laptop-512.png"));
			list.add(new Subject("3. Biologie", "https://cdn4.iconfinder.com/data/icons/education-free/512/education-school-learn-study-15-512.png"));
			list.add(new Subject("4. Chemie", "https://cdn4.iconfinder.com/data/icons/medical-227/512/584_Flask_lab_research_medical-512.png"));
			list.add(new Subject("5. Physik", "https://cdn1.iconfinder.com/data/icons/science-technology-outline-24-px/24/Horseshoe_magnet_magnet_magnetic_field_magnetism_physics-512.png"));
			list.add(new Subject("6. Technik", "https://cdn1.iconfinder.com/data/icons/web-basic-2/512/721_gear__setting_engine_-512.png"));

			return list;
		}

	}
}
