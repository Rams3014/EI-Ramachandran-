package builder;
public class House {
    private String foundation;
    private String structure;
    private String roof;

    public void setFoundation(String foundation) { this.foundation = foundation; }
    public void setStructure(String structure) { this.structure = structure; }
    public void setRoof(String roof) { this.roof = roof; }

    public void showHouse() {
        System.out.println("\n=== Villa Details ===");
        System.out.println("Foundation: " + foundation);
        System.out.println("Structure: " + structure);
        System.out.println("Roof: " + roof);
    }
}
