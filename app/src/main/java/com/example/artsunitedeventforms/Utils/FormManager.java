package com.example.artsunitedeventforms.Utils;

import android.provider.ContactsContract;
import android.text.InputType;

import com.example.artsunitedeventforms.data.enums.QuestionType;
import com.example.artsunitedeventforms.data.local.Answer;
import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.data.local.SectionedQuestions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FormManager {
	
	public static ArrayList<SectionedQuestions> getTestingData() {
		
		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();
		
		questions.add(new Question("Event", QuestionType.TEXT));
		questions.add(new Question("House Manager", QuestionType.TEXT));
		questions.add(new Question("Radio Checked Out", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ushers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Volunteers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Production Lead Staff Member", QuestionType.TEXT));
		questions.add(new Question("Arts United Tech Monitor", QuestionType.TEXT));
		questions.add(new Question("Notes From Preshow Meeting", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Lobby Open Time", QuestionType.TIME));
		questions.add(new Question("House Open Time", QuestionType.TIME));
		questions.add(new Question("Show Start Time", QuestionType.TIME));
		questions.add(new Question("Was A Preshow Hold Needed", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Ticketing Or Seating Issues", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Intermission Start Time", QuestionType.TIME));
		questions.add(new Question("Second Act Start Time", QuestionType.TIME));
		questions.add(new Question("Was An Intermission Hold Needed?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Show End Time", QuestionType.TIME));
		questions.add(new Question("Any Patron Incidents To Note?", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Cash", QuestionType.NUMBER));
		questions.add(new Question("Credit", QuestionType.NUMBER));
		sectionedQuestions.add(new SectionedQuestions(questions, "Concession Earned"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Cash", QuestionType.NUMBER));
		questions.add(new Question("Credit", QuestionType.NUMBER));
		questions.add(new Question("Final Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, "Parking Earned"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Northeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("All Exterior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Interior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Security Lights On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Northwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Lobby Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage To Lobby Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("All Radios Returned To Charging Station", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Shutdown Checklist"));
		
		return sectionedQuestions;
	}
	
	
	public static ArrayList<SectionedQuestions> getAucEventReportForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();

		questions.add(new Question("Event", QuestionType.TEXT));
		questions.add(new Question("House Manager", QuestionType.TEXT));
		questions.add(new Question("Radio Checked Out", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ushers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Volunteers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Production Lead Staff Member", QuestionType.TEXT));
		questions.add(new Question("Arts United Tech Monitor", QuestionType.TEXT));
		questions.add(new Question("Notes From Preshow Meeting", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Lobby Open Time", QuestionType.TIME));
		questions.add(new Question("House Open Time", QuestionType.TIME));
		questions.add(new Question("Show Start Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Was A Preshow Hold Needed", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Ticketing Or Seating Issues", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Intermission Start Time", QuestionType.TIME));
		questions.add(new Question("Second Act Start Time", QuestionType.TIME));
		questions.add(new Question("Was An Intermission Hold Needed?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Show End Time", QuestionType.TIME));
		questions.add(new Question("Any Patron Incidents To Note?", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Cash", QuestionType.NUMBER));
		questions.add(new Question("Credit", QuestionType.NUMBER));
		sectionedQuestions.add(new SectionedQuestions(questions, "Concession Earned"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Cash", QuestionType.NUMBER));
		questions.add(new Question("Credit", QuestionType.NUMBER));
		sectionedQuestions.add(new SectionedQuestions(questions, "Parking Earned"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Final Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Northeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("All Exterior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Interior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Security Lights On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Northwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Lobby Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage To Lobby Door", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Shutdown Checklist"));
		
		questions = new ArrayList<>();
		questions.add(new Question("All Radios Returned To Charging Station", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));


		return sectionedQuestions;
	}
	
	
	public static ArrayList<SectionedQuestions> getAlEventReportForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();

		questions.add(new Question("Event", QuestionType.TEXT));
		questions.add(new Question("House Manager", QuestionType.TEXT));
		questions.add(new Question("Desk Monitor", QuestionType.TEXT));
		questions.add(new Question("Key Checked Out", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Radio Checked OUT", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ushers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Volunteers", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Production's Lead Staff Member", QuestionType.TEXT));
		questions.add(new Question("Arts United Tech Monitor", QuestionType.TEXT));
		questions.add(new Question("Notes From Preshow Meeting", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Lobby Open Time", QuestionType.TIME));
		questions.add(new Question("House Open Time", QuestionType.TIME));
		questions.add(new Question("Was The Skybox used?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Show Start Time", QuestionType.TIME));
		questions.add(new Question("Was A Preshow Hold Needed", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Ticketing Or Seating Issue", QuestionType.MULTILINE_TEXT ));
		questions.add(new Question("Intermission Start Time", QuestionType.TIME));
		questions.add(new Question("Second Act Start Time", QuestionType.TIME));
		questions.add(new Question("Was An Intermission Hold Needed?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Length", QuestionType.TEXT));
		questions.add(new Question("Reason", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Show End Time", QuestionType.TIME));
		questions.add(new Question("Any Incidents To Note", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Concession Earned", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Cash", QuestionType.NUMBER));
		questions.add(new Question("Credit", QuestionType.NUMBER));
		questions.add(new Question("Concessions Stored And Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Cooler Stocked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Concession Stand And Cooler Cleaned", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("ArtsLab Theatre Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Exterior Lobby Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Theatre Work Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Lobby Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Interior Lobby Doors  (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Radio Returned To The Charging Station", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Key Checked In", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Final Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, "Shutdown Checklist"));
		
		return sectionedQuestions;
	}


	public static ArrayList<SectionedQuestions> getAucDeskMonitorForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();

		questions.add(new Question("Your Name", QuestionType.TEXT));
		questions.add(new Question("Your Arrival Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Did You Shift Change From Someone", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who?", QuestionType.TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Event(s)", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Time Greenroom Unlocked", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Greenroom", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Rehearsal Hall", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Rehearsal Hall", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Men's Dressing Room", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Women's Dressing Room", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Front Lobby", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Gallery", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, "Rooms Used"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Time Greenroom Locked (Last Person Out)", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Did You Shift Change To Someone", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who?", QuestionType.TEXT));
		questions.add(new Question("Your End Time", QuestionType.TIME));
		questions.add(new Question("Greenroom Left Clean", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Tables And Surfaces Cleaned", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Chairs Pushed In", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Large Trash Picked Up", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Did You Shovel Or Salt The Sidewalk", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Shut Down Checklist"));
		sectionedQuestions.add(new SectionedQuestions(questions, "Lobby"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Northeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southeast Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Custodial Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Men's Restroom Clear", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("All Exterior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Interior Vestibule Doors (8)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Box Office Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Vestibule Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Security Lights On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Youtheatre Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Box Office Manager's Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Women's Restroom Clear", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Southwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Northwest Lobby Doors (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Kitchen Custodial Closet", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Lobby Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Kitchen Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Lights (3)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Doors (3)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Hallway Light", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk 1 Doors And Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk 2 Doors And Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk 3 Doors And Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk 4 Doors And Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk Hallways Doors And Lights (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East House Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage to Lobby Door", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Stage Lights By Stage Door (4)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Exterior Rolling Shop Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Exterior Shop Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Civic Offices Lights and Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Shop Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Sliding Shop Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage Lights (3) (Security Left ON)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Balcony Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Balcony Door to Rehearsal Hall", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stairway Light ON", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stage Crossover Tunnel Doors", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "stage"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Men’s Dressing Room Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Men’s Dressing Room Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Women’s Dressing Room Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Women’s Dressing Room Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Both Restroom Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Civic Finance Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Exterior Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Stairway Door Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Rear Door to Women's Dressing Room", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Rehearsal Hall Door To Stairway", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Rehearsal Hall Door To Stage", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Rehearsal Hall Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Rehearsal Hall Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Rehearsal Hall Doors To Stairway", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Rear Door To Men's Dressing Room", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Greenroom"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Costume Shop Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Costume Shop Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Basement Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Basement Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("West Basement Doors", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Basement"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Glass Doors To West Stairway", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("East Glass Greenroom Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Office Lights OFF", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Office Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Vestibule Lights OFF", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Building Armed", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Did You Leave A Building Resident To Secure The Building?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who?", QuestionType.TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, "Ending"));

		return sectionedQuestions;
	}


	public static ArrayList<SectionedQuestions> getAlDeskMonitorForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();

		questions.add(new Question("Your Name", QuestionType.TEXT));
		questions.add(new Question("Your Arrival Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Did You Shift Change From Someone", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who?", QuestionType.TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Was There An Event In The ArtsLab", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Conference Room", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Skybox", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Ballet Classes/Event", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Artlink Event", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Other Event", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Please List", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Auer Lobby Cleaned", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Floors Swept", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Table Tops And Surfaces Cleaned", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Chairs Pushed In", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Did You Shovel Or Salt The Sidewalk", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, "Events In These Spaces:"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Front Auer Doors Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Artlink Lobby Doors (2)", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Auer Shutdown"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Ballet Area Empty", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ballet Studio And Dressing Room Doors (9)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ballet Area Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Upstairs Bathroom", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Studio A Back Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Arts United Office Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Hallway Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Skybox Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Skybox Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ballet Costume shop", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Upstairs Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Upstairs Stairway Door Closed", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Upstairs Mechanical Room", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Upstairs"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Rear Stairwell Exterior Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Loading Dock Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Rear Theatre Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stairway Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Auer Loading Dock Double Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Copy Room", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Greenroom Theatre Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Lights On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Greenroom Doors (3)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Maintenance Closet", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Family Restroom Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Trails Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("FAME Office", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Server Room", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Check Behind Curtains", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Downstairs Restroom Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ballet Studio E", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Conference Room Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Conference Room Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Artlink Back Door (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Exterior Mechanical Room Doors", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Interior Mechanical Room Doors  (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Back Hallway Lights", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Theatre Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Exterior Lobby Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Theatre Work Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Lobby Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Interior Lobby Doors  (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Auer Lobby Lights", QuestionType.BOOLEAN_CHECK));
		sectionedQuestions.add(new SectionedQuestions(questions, "Downstairs"));
		
		questions = new ArrayList<>();
		questions.add(new Question("Building Empty", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who Was Left", QuestionType.TEXT));
		questions.add(new Question("Building Alarm Set", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Exterior Door Locked", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Did You Shift Change To Someone", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Who", QuestionType.TEXT));
		questions.add(new Question("Your End Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));

		return sectionedQuestions;
	}


	public static ArrayList<SectionedQuestions> getAucTechForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();
		
		questions.add(new Question("Your Name", QuestionType.TEXT));
		questions.add(new Question("Event", QuestionType.TEXT));
		questions.add(new Question("Your Clock In Time", QuestionType.TIME));
		questions.add(new Question("Tech Key Checked Out", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("House Manager", QuestionType.TEXT));
		questions.add(new Question("Lead Technician On Duty", QuestionType.TEXT));
		questions.add(new Question("Audio Technician On duty", QuestionType.TEXT));
		questions.add(new Question("Was Audio System Used Today", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Was The Audio System Properly Turned On", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Temperature Preshow", QuestionType.NUMBER));
		questions.add(new Question("Show Start Time", QuestionType.TIME));
		questions.add(new Question("Intermission Start Time", QuestionType.TIME));
		questions.add(new Question("Temperature Intermission", QuestionType.NUMBER));
		questions.add(new Question("Second Act Start Time", QuestionType.TIME));
		questions.add(new Question("End Of Event Time", QuestionType.TIME));
		questions.add(new Question("Temperature End", QuestionType.NUMBER));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Any Accidents To The Cast Or Crew", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Incident Report Completed", QuestionType.BOOLEAN_SWITCH));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Any Damage To AU Equipment (Torn Curtains, Mishandled/Broken Equipment, Damage To Fly Pipes, Etc.)  ", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Did The Production Run Smoothly", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Was The Audio System Properly Turned Off", QuestionType.BOOLEAN_SWITCH));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Any Improper Equipment Use (Man-lift Without It’s Outriggers, Fly System Without Gloves, Etc.)", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Was The Orchestra Pit Left At Stage Level", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("If The Pit Remained Down Was The Rope Put Up At The End Of The Night", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Were The Backstage Run Lights Turned Off At The End", QuestionType.BOOLEAN_SWITCH));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Any Other Issues That Need To Be Noted", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Was The Ghost Light Put Out At The End Of The Night", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Final Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Tech Key Checked In", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Your End Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));


		return sectionedQuestions;
	}


	public static ArrayList<SectionedQuestions> getAlTechForm() {

		ArrayList<SectionedQuestions> sectionedQuestions = new ArrayList<>();
		ArrayList<Question> questions = new ArrayList<>();

		questions.add(new Question("Your Name", QuestionType.TEXT));
		questions.add(new Question("Event", QuestionType.TEXT));
		questions.add(new Question("Your Clock In Time", QuestionType.TIME));
		questions.add(new Question("Tech Key Checked Out", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("House Manager", QuestionType.TEXT));
		questions.add(new Question("Lead Technician On Duty", QuestionType.TEXT));
		questions.add(new Question("Audio Technician On duty", QuestionType.TEXT));
		questions.add(new Question("Was Audio System Used Today", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Was The Audio System Properly Turned On", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Temperature Preshow", QuestionType.NUMBER));
		questions.add(new Question("Show Start Time", QuestionType.TIME));
		questions.add(new Question("Intermission Start Time", QuestionType.TIME));
		questions.add(new Question("Temperature Intermission", QuestionType.NUMBER));
		questions.add(new Question("Second Act Start Time", QuestionType.TIME));
		questions.add(new Question("End Of Event Time", QuestionType.TIME));
		questions.add(new Question("Temperature End", QuestionType.NUMBER));
		questions.add(new Question("Any Accidents To The Cast Or Crew", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Incident Report Completed", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Any Damage to AU Equipment (Torn curtains, mishandled/broken equipment, etc.)  ", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Did The Production Run Smoothly", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Any Improper Equipment Use", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Was The Skybox Seated For This Event?", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Any Other issues that need to be noted", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Notes", QuestionType.MULTILINE_TEXT));
		questions.add(new Question("Was The Audio System Properly Turned Off", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Were All Backstage Run Lights Turned Off", QuestionType.BOOLEAN_SWITCH));
		questions.add(new Question("Was The Ghost Light Put Out At The End Of The Night", QuestionType.BOOLEAN_SWITCH));
		sectionedQuestions.add(new SectionedQuestions(questions, ""));
		
		questions = new ArrayList<>();
		questions.add(new Question("Audio System Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Intelligent Lights OFF", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Light Board Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Paradigm Control", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Work Lights Lockout Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Work Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("ArtsLab Fans On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Catwalk Door Closed And Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Air Conditioner Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Lights Off (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Booth Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Skybox Seating Checked For Trash", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Skybox Lights Off And Locked", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Ghost Light", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Loading Dock Roll Doors closed (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Loading Dock Heating Or cooling On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Loading Dock Lights On", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Loading Dock Blue Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Loading Dock Hallway Door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Stairway ArtsLab Theatre door", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Theatre Doors (2)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Blue Lights Off", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Lights ON", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Greenroom Doors (3)", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Tech Key Returned To Desk Monitor", QuestionType.BOOLEAN_CHECK));
		questions.add(new Question("Your Clock Out Time", QuestionType.TIME));
		sectionedQuestions.add(new SectionedQuestions(questions, "End Shutdown"));

		return sectionedQuestions;
	}
	
	public static Question getPdfIncludedField(){
		
		String date = Utils.getCurrentDate("hh:mm:ss");
		
		Question question = new Question("End Time", QuestionType.AUTO_GEN_DATE);
		Answer answer = new Answer();
		answer.setDate(date);
		
		question.setAnswer(answer);
		return question;
	}
	
}
