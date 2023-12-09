public interface IShop {
    public void doReturn();

    default public void doComplaint(String name){
        System.out.println("Cliente "+name+" está a reclamar!");
    }
}
