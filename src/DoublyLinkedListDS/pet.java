package DoublyLinkedListDS;

public class pet {
  //  String name;
    int id;
    String type;
    String breed;
    String  color;

    public pet(int id,String type, String breed, String color){
        this.id=id;
        this.type=type;
        this.breed=breed;
        this.color=color;
    }

    @Override
    public String toString() {
        return "pet{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


}


