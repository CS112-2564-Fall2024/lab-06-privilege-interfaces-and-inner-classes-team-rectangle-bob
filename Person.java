public class Person implements Comparable<Person>
{
	public class Identity {
		private String pronouns;
		private String background;

		public static final String DEFAULT_PRONOUNS = " ";
		public static final String DEFAULT_BACKGROUND = " ";

		public Identity() {
			pronouns = DEFAULT_PRONOUNS;
			background = DEFAULT_BACKGROUND;
		}
		
		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public String toString(String pronouns, String background) {
			return String.format("Pronouns: %s\nBackground: %s", this.pronouns, this.background);
		}

		public boolean equals(Object other) {
			if (other == null || (!(other instanceof Identity))) {
				return false;
			}
	
			Identity otherIdentity = (Identity) other;
			return this.pronouns.equals(otherIdentity.pronouns) && this.background.equals(otherIdentity.background);	
		}

	}
	/***** TODO: (Part 2) create helper inner class for Identity*****/

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final Identity DEFAULT_STORY = null;
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, Identity story, int privilege) {
		this.setAll(name, story, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(Identity story) {
		this.story = story;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, Identity story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public Identity getStory() {
		return this.story;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other == null || (!(other instanceof Person))) {
			return false;
		}

		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) && this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/
	public int compareTo(Person other) {
		if (this.privilege < other.privilege) {
			return -1;
		}
		else if (this.privilege > other.privilege) {
			return 1;
		}
		else {
			return 0;
		}
	}
}