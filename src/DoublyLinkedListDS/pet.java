package DoublyLinkedListDS;

import com.google.gson.Gson;

public class pet {
        private static String crunchify_file_location = "/Users/appshah/Documents/crunchify.txt";
        static Gson gson = new Gson();
        //  String name;
        int id;
        String type;
        String breed;
        String color;

        public pet(int id, String type, String breed, String color) {
            this.id = id;
            this.type = type;
            this.breed = breed;
            this.color = color;
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


