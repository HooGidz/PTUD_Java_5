package db;

public class tbl_Menu {
	private int menu_ID;
	private String name;
	private String alias;
	private String description;
	
	
	public tbl_Menu(int menu_ID, String name, String alias, String description) {
		super();
		this.menu_ID = menu_ID;
		this.name = name;
		this.alias = alias;
		this.description = description;
	}

	public int getMenu_ID() {
		return menu_ID;
	}

	public void setMenu_ID(int menu_ID) {
		this.menu_ID = menu_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "tbl_Menu [menu_ID=" + menu_ID + ", name=" + name + ", alias=" + alias + ", description=" + description
				+ "]";
	}
	
	
}
