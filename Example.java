interface DisplayProduct {
        void display();
    }

class WomanCategory implements DisplayProduct {
        public void display() {
            System.out.println("Displaying Women's Products");
        }
}

class ManCategory implements DisplayProduct {
    public void display() {
    System.out.println("Displaying Men's Products");
        }
}

class DisplayProductFactory {
    public static DisplayProduct createProduct(String type) {
        if (type.equalsIgnoreCase("woman")) {
                return new WomanCategory();
        } else if (type.equalsIgnoreCase("man")) {
            return new ManCategory();
        }
            return null;
    }
}

