public static void main(String[] args) {
        DisplayProduct product = DisplayProductFactory.createProduct("man");
        product.display();
}