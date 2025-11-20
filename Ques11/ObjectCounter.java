package Ques11;
class ObjectCounter {

    private static int objectCount = 0;

    private final String objectName;

    public ObjectCounter(String name) {
        objectCount++;
        this.objectName = name;
        System.out.println("Object created: " + this.objectName);
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public static void main(String[] args) {
        
        System.out.println("--- Starting Object Creation ---");

        System.out.println("Current object count: " + ObjectCounter.getObjectCount());
        
        ObjectCounter obj1 = new ObjectCounter("Instance A");
        ObjectCounter obj2 = new ObjectCounter("Instance B");
        ObjectCounter obj3 = new ObjectCounter("Instance C");
        
        System.out.println("\n--- Object Creation Finished ---");
        
        int finalCount = ObjectCounter.getObjectCount();
        System.out.println("Total objects created: " + finalCount);
    }
}