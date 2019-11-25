public class Test2_1 {
    public static void main(String[] args) {
        Course c = new Course();
        c.setId("1008611");
        c.setName("java");
        c.setSelectId("10086");
        System.out.println("编号"+c.getId());
        System.out.println("课程名"+c.getName());
        System.out.println("先修课号"+c.getSelectId());
    }
}
class Course {
    private String name;//课程名
    private String id; //编号
    private String selectId; //先修课号
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSelectId() {
        return selectId;
    }
    public void setSelectId(String selectId) {
        this.selectId = selectId;
    }

}
