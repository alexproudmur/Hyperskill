class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (String str : args) {
            System.out.println(str);
        }
    }
}