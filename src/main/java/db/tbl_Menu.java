package db;

public class tbl_Menu {
	private int menu_ID;
	private String name;
	private String alias;
	public tbl_Menu(int menu_ID, String name, String alias) {
		super();
		this.menu_ID = menu_ID;
		this.name = name;
		this.alias = alias;
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
	@Override
	public String toString() {
		return "tbl_Menu [menu_ID=" + menu_ID + ", name=" + name + ", alias=" + alias + "]";
	}
	

	
}
