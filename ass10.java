import java.util.*;
import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

class User {

    protected String userID;
    protected String name;
    protected String address;
    protected String PAN;
    protected LocalDate dob;
    protected String email;
    protected int password;

    public User(String userID, String name, String address, String PAN, LocalDate dob, String email, int passowrd) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.PAN = PAN;
        this.dob = dob;
        this.password = passowrd;
        this.email = email;
    }

    User() {

    };

    public boolean checkUserID(int useriD) {
        if (this.userID.equals(useriD)) {
            return true;
        } else {
            return false;
        }
    }

}

class Admin extends User {
    protected String doj;

    Admin() {

    };

    Admin(String userID, String name, String address, String PAN, LocalDate dob, String email, int passowrd,
            String doj) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.PAN = PAN;
        this.dob = dob;
        this.password = passowrd;
        this.email = email;
        this.doj = doj;
    }

    public void addNewStock(ArrayList<Item> ItemDataBase) {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\t1 - FoodItem");
        System.out.println("\t2 - NonFoodItem");
        System.out.println("\t3 - cancel()");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Enter Choice : ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter Itemcode : ");
            int itemcode = input.nextInt();

            System.out.print("Enter Price : ");
            int price = input.nextInt();

            System.out.print("Enter AvailableQty : ");
            int AvailableQty = input.nextInt();
            input.nextLine();

            System.out.print("Enter dateOfExpiry : ");
            String dateOfExpiry = input.nextLine();

            FoodItem newitem = new FoodItem(itemcode, price, AvailableQty, dateOfExpiry);
            ItemDataBase.add(newitem);
        } else if (choice == 2) {
            System.out.print("Enter Itemcode : ");
            int itemcode = input.nextInt();

            System.out.print("Enter Price : ");
            int price = input.nextInt();

            System.out.print("Enter AvailableQty : ");
            int AvailableQty = input.nextInt();
            input.nextLine();

            System.out.print("Enter warrentyPeriod : ");
            int warrentyPeriod = input.nextInt();

            NonFoodItem newitem = new NonFoodItem(itemcode, price, AvailableQty, warrentyPeriod);
            ItemDataBase.add(newitem);
        }
    }

    public static void deleteStock(ArrayList<Item> ItemDataBase, int indexofItemcode) {
        ItemDataBase.remove(indexofItemcode);
    }

}

class Sell extends Item {
    String dos;
    int itemcode;
    int quantity;
    int totalAmount;

    Sell() {
    };

    Sell(String dos, int itemcode, int quantity, int totalAmount) {
        this.dos = dos;
        this.itemcode = itemcode;
        this.quantity = quantity;
        this.totalAmount = totalAmount;

    }

    public void displaySell(String startDate, String endDate) {

        if (getYear(this.dos) >= getYear(startDate)
                && getYear(this.dos) <= getYear(endDate)
                && getMonth(this.dos) >= getMonth(startDate)
                && getMonth(this.dos) <= getMonth(endDate)
                && getDay(this.dos) <= getDay(endDate) &&
                getDay(this.dos) >= getDay(startDate)) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("\tdateOfSell : " + this.dos);
            System.out.println("\titemcode : " + this.itemcode);
            System.out.println("\tquantity : " + this.quantity);
            System.out.println("\ttotalAmount : " + this.totalAmount);
            System.out.println("------------------------------------------------------------------------------");
        }
    }

}

class Return extends Item {
    String dos;
    int itemcode;
    int quantity;
    int returnAmount;

    Return() {
    };

    Return(String dos, int itemcode, int quantity, int returnAmount) {
        this.dos = dos;
        this.itemcode = itemcode;
        this.quantity = quantity;
        this.returnAmount = returnAmount;
    }

    public void displayReturn(String startDate, String endDate) {

        if (getYear(this.dos) >= getYear(startDate)
                && getYear(this.dos) <= getYear(endDate)
                && getMonth(this.dos) >= getMonth(startDate)
                && getMonth(this.dos) <= getMonth(endDate)
                && getDay(this.dos) <= getDay(endDate) &&
                getDay(this.dos) >= getDay(startDate)) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("\tdateOfReturn : " + this.dos);
            System.out.println("\titemcode : " + this.itemcode);
            System.out.println("\tquantity : " + this.quantity);
            System.out.println("\ttotalAmount : " + this.returnAmount);
            System.out.println("------------------------------------------------------------------------------");
        }
    }

}

class General extends User {

    protected String doj;

    General() {

    };

    General(String userID, String name, String address, String PAN, LocalDate dob, String email, int passowrd,
            String doj) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.PAN = PAN;
        this.dob = dob;
        this.password = passowrd;
        this.email = email;
        this.doj = doj;
    }

    public static void displayStock(ArrayList<Item> ItemDataBase, int itemcode) {
        for (Item user : ItemDataBase) {
            if (user.itemcode == itemcode) {
                if (user instanceof FoodItem) {
                    System.out.println("FoodItem : ");
                } else {
                    System.out.println("NonFoodItem : ");
                }
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("\tItemcode : " + user.itemcode);
                System.out.println("\tPrice : " + user.price);
                System.out.println("\tAvailableQty : " + user.availableQty);
                System.out.println("------------------------------------------------------------------------------");
            }
        }
    }

    public static void sellItem(ArrayList<Item> ItemDataBase, ArrayList<Sell> SellDataBase) {
        Scanner scn = new Scanner(System.in);
        System.out.println("**********************************");
        System.out.println("\t1 - FoodItem");
        System.out.println("\t2 - NonFoodItem");
        System.out.println("\t3 - cancel()");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Enter Choice : ");
        int choice = scn.nextInt();

        if (choice == 1) {
            System.out.print("Enter itemcode : ");
            int itemcode = scn.nextInt();

            System.out.print("Enter quantity : ");
            int quantity = scn.nextInt();
            scn.nextLine();

            System.out.print("Enter dateOfSell (dd/mm/yyyy): ");
            String dateOfSell = scn.nextLine();
            while (!Item.isValidDate(dateOfSell)) {
                System.out.println("Invalid Date Please Re-Enter!");
                dateOfSell = scn.nextLine();
            }
            System.out.print("Enter totalAmount : ");
            int totalAmount = scn.nextInt();

            for (Item checkItem : ItemDataBase) {
                if (checkItem.checkItemcode(itemcode) && checkItem instanceof FoodItem) {
                    if (checkItem.checkQuantity(quantity)) {
                        Sell sellNewItem = new Sell(dateOfSell, itemcode, quantity, totalAmount);
                        SellDataBase.add(sellNewItem);
                        checkItem.availableQty -= quantity;
                        break;
                    } else {
                        checkItem = null;
                        System.out.println("Not Sufficient Stock Available!");
                        break;
                    }
                } else {
                    System.out.println("Item is not present in stock!");
                    break;
                }

            }
        }
        if (choice == 2) {
            System.out.print("Enter itemcode : ");
            int itemcode = scn.nextInt();

            System.out.print("Enter quantity : ");
            int quantity = scn.nextInt();
            scn.nextLine();

            System.out.print("Enter dateOfSell (dd/mm/yyyy): ");
            String dateOfSell = scn.nextLine();
            while (!Item.isValidDate(dateOfSell)) {
                System.out.println("Invalid Date Please Re-Enter!");
                dateOfSell = scn.nextLine();
            }
            System.out.print("Enter totalAmount : ");
            int totalAmount = scn.nextInt();

            for (Item checkItem : ItemDataBase) {
                if (checkItem.checkItemcode(itemcode) && checkItem instanceof NonFoodItem) {
                    if (checkItem.checkQuantity(quantity)) {
                        Sell sellNewItem = new Sell(dateOfSell, itemcode, quantity, totalAmount);
                        SellDataBase.add(sellNewItem);
                        checkItem.availableQty -= quantity;
                        break;
                    } else {
                        checkItem = null;
                        System.out.println("Not Sufficient Stock Available!");
                        break;
                    }
                } else {
                    System.out.println("Item is not present in stock!");
                    break;
                }
            }

        }
    }

    public void returnItem(ArrayList<Return> ReturnDataBase, ArrayList<Item> ItemDataBase) {

        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\t1 - FoodItem");
        System.out.println("\t2 - NonFoodItem");
        System.out.println("\t3 - cancel()");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Enter Choice : ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter itemcode : ");
            int itemcode = input.nextInt();
            input.nextLine();

            System.out.print("Enter dateOfReturn (dd/mm/yyyy): ");
            String dateOfReturn = input.nextLine();
            while (!Item.isValidDate(dateOfReturn)) {
                System.out.println("Invalid Date Please Re-Enter!");
                dateOfReturn = input.nextLine();
            }

            System.out.print("Enter quantity : ");
            int quantity = input.nextInt();

            System.out.print("Enter returnAmount : ");
            int returnAmount = input.nextInt();
            for (Item checkItem : ItemDataBase) {
                if (checkItem.checkItemcode(itemcode) && checkItem instanceof FoodItem) {
                    if (((FoodItem) checkItem).checkExpiry(dateOfReturn)) {
                        Return returnSoldItem = new Return(dateOfReturn, itemcode, quantity, returnAmount);
                        ReturnDataBase.add(returnSoldItem);
                        checkItem.availableQty += quantity;
                        break;
                    } else {
                        checkItem = null;
                        System.out.println("Cant't return Expired item!");
                        break;
                    }
                } else {
                    System.out.println("Item is not present in stock!");
                    break;
                }
            }
        } else if (choice == 2) {
            System.out.print("Enter itemcode : ");
            int itemcode = input.nextInt();
            input.nextLine();

            System.out.print("Enter dateOfReturn (dd/mm/yyyy): ");
            String dateOfReturn = input.nextLine();
            while (!Item.isValidDate(dateOfReturn)) {
                System.out.println("Invalid Date Please Re-Enter!");
                dateOfReturn = input.nextLine();
            }

            System.out.print("Enter quantity : ");
            int quantity = input.nextInt();

            System.out.print("Enter returnAmount : ");
            int returnAmount = input.nextInt();
            for (Item checkItem : ItemDataBase) {
                if (checkItem.checkItemcode(itemcode) && checkItem instanceof NonFoodItem) {
                    Return returnSoldItem = new Return(dateOfReturn, itemcode, quantity, returnAmount);
                    ReturnDataBase.add(returnSoldItem);
                    checkItem.availableQty += quantity;
                    break;
                } else {
                    System.out.println("Item is not present in stock!");
                    break;
                }
            }
        }
    }

}

class Item {

    protected int itemcode;
    protected int price;
    protected int availableQty;

    Item() {

    };

    Item(int itemcode, int price, int availableQty) {
        this.itemcode = itemcode;
        this.price = price;
        this.availableQty = availableQty;
    }

    public static boolean isValidDate(String date) {
        String regex = "^[0-3][0-9]/[0-1][0-9]/[0-9]{4}$";
        Pattern p = Pattern.compile(regex);
        if (date == null) {
            return false;
        }
        Matcher m = p.matcher(date);
        return m.matches();
    }

    public void modifyStock(int itemcode) {
        if (this.itemcode == itemcode) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter AvailableQty : ");
            int newAvailableQty = input.nextInt();

            System.out.print("Enter Price : ");
            int newprice = input.nextInt();

            this.price = newprice;
            this.availableQty = newAvailableQty;
        } else {
            System.out.println("Not Found");
        }
    }

    public Boolean checkQuantity(int quantity) {
        if (this.availableQty >= quantity) {
            return true;
        }
        return false;
    }

    public Boolean checkItemcode(int itemcode) {
        if (this.itemcode == itemcode) {
            return true;
        }
        return false;
    }

    public int getYear(String dateOfSell) {
        return Integer.parseInt(dateOfSell.substring(6, 10));
    }

    public int getMonth(String dateOfSell) {
        return Integer.parseInt(dateOfSell.substring(3, 5));
    }

    public int getDay(String dateOfSell) {
        return Integer.parseInt(dateOfSell.substring(0, 2));
    }

}

class FoodItem extends Item {

    protected String doe;

    FoodItem() {

    };

    FoodItem(int itemcode, int price, int availableQty, String doe) {
        this.itemcode = itemcode;
        this.price = price;
        this.availableQty = availableQty;
        this.doe = doe;
    }

    public boolean checkExpiry(String dateOfReturn) {
        if (getYear(doe) + 1 < getYear(dateOfReturn)) {
            return false;
        }
        return true;
    }

}

class NonFoodItem extends Item {

    protected int warrentyPeriod;

    NonFoodItem() {

    };

    NonFoodItem(int itemcode, int price, int availableQty, int warrentyPeriod) {
        this.itemcode = itemcode;
        this.price = price;
        this.availableQty = availableQty;
        this.warrentyPeriod = warrentyPeriod;
    }

    public int returnCount(int itemcode) {
        if (this.itemcode == itemcode) {
            return availableQty;
        }
        return -1;
    }

}

public class ass10 {

    Scanner in = new Scanner(System.in);

    static boolean isValidDate(String date) {
        String regex = "^[0-3][0-9]/[0-1][0-9]/[0-9]{4}$";
        Pattern p = Pattern.compile(regex);
        if (date == null) {
            return false;
        Matcher m = p.matcher(date);
        return m.matches();

    }
 
    static boolean isValidPAN(String pan) {
        String regex = "^[A-Z0-9]*{12}";
        Pattern p = Pattern.compile(regex);
        if (pan == null) {
            return false;
        }
        Matcher m = p.matcher(pan);
        return m.matches();
    }

    static boolean isValidMail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        Matcher m = p.matcher(email);
        return m.matches();
    }

    static boolean isValidpass(String password) {
        String regex = ".{6,}";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }

    static ArrayList<User> mainuser = new ArrayList<User>();
    static ArrayList<Item> ItemDataBase = new ArrayList<Item>();
    static ArrayList<Sell> SellDataBase = new ArrayList<Sell>();
    static ArrayList<Return> ReturnDataBase = new ArrayList<Return>();

    static void adminControlSystem() {

        Scanner in = new Scanner(System.in);
        System.out.println("****************************************************************");
        System.out.println("1.ADD STOCK\n2.DELETE STOCK\n3.MODIFY STOCK\n4.LOGOUT\n");
        System.out.println("****************************************************************");

        int ch2 = in.nextInt();
        if (ch2 == 1) {
            Admin admin = new Admin();
            admin.addNewStock(ItemDataBase);
            mainuser.add(admin);

        } else if (ch2 == 2) {
            System.out.print("Enter itemcode : ");
            int itemcode = in.nextInt();
            int flag = 0, i = 0;
            for (Item user : ItemDataBase) {
                if (user.itemcode == itemcode) {
                    flag = 1;
                    break;
                }
                i++;
            }
            if (flag == 1) {
                Admin.deleteStock(ItemDataBase, i);
            } else {
                System.out.println("Item not Found!");
            }

        } else if (ch2 == 3) {
            System.out.print("Enter itemcode : ");
            int itemcode = in.nextInt();
            int flag = 0;
            for (Item user : ItemDataBase) {
                if (user.itemcode == itemcode) {
                    user.modifyStock(itemcode);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Item not Found!");
            }

        } else if (ch2 == 4) {
            break;
        }
    }

    }

    static void generalControlSystem() {
        System.out.println("****************************************************************");
        System.out.println(
                "1.SELL ITEM\n2.RETURN ITEM\n3.DISPLAY ITEM\n4.DISPLAY SELL\n5.DIPLAY RETURN\n6.LOGOUGT\n");
        System.out.println("****************************************************************");

        int ch3 = in.nextInt();
        if (ch3 == 1) {

        } else if (ch3 == 2) {

        } else if (ch3 == 3) {

        } else if (ch3 == 4) {
            break;
        }

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("***********************************************************");
            System.out.println("1.ADD ADMIN\n2.ADD GENERAL\n3.SIGIN IN\n4.EXIT\n");
            System.out.println("***********************************************************");

            int ch1 = scn.nextInt();

            if (ch1 == 1) {
                System.out.println("ENTER YOUR NAME:");
                String name = scn.nextLine();
                System.out.println("ENTER YOUR DATE OF BIRTH");
                String dob = scn.nextLine();
                System.out.println("ENTER YOUR USER ID");
                int userid = scn.nextInt();
                System.out.println("ENTER YOUR PASSWORD");
                int password = scn.nextInt();
                System.out.println("ENTER YOUR ADDRESS");
                String address = scn.nextLine();
                System.out.println("ENTER YOUR PAN");
                int pan = scn.nextInt();
                System.out.println("ENTER YOUR DATE OF JOINING");
                String doj = scn.nextLine();

                // incomplete adding required;

            }

            if (ch1 == 2) {
                System.out.println("ENTER YOUR NAME:");
                String name = scn.nextLine();
                System.out.println("ENTER YOUR DATE OF BIRTH");
                String dob = scn.nextLine();
                System.out.println("ENTER YOUR USER ID");
                int userid = scn.nextInt();
                System.out.println("ENTER YOUR PASSWORD");
                int password = scn.nextInt();
                System.out.println("ENTER YOUR ADDRESS");
                String address = scn.nextLine();
                System.out.println("ENTER YOUR PAN");
                int pan = scn.nextInt();
                System.out.println("ENTER YOUR DATE OF JOINING");
                String doj = scn.nextLine();

                // incomplete add required;

            }

            if (ch1 == 3) {
                System.out.println("ENTER YOUR USER ID:");
                int userid = scn.nextInt();
                System.out.println("ENTER YOUR PASSWORD:");
                int password = scn.nextInt();

            }
        }

    }
}
